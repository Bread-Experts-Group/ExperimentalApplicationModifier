package org.bread_experts_group.eam

import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1x21x1Implementations
import java.lang.classfile.CodeBuilder
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodBuilder
import java.lang.classfile.instruction.LocalVariable
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method
import java.lang.reflect.Parameter
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

fun loadClass(clazz: String): Class<*> = ClassLoader.getSystemClassLoader().loadClass(clazz)

/**
 * @return The parameters subclassing [MimickedClass].
 */
fun Method.getMimicParameters(): List<Parameter> =
	this.parameters.filter { it.type.kotlin.isSubclassOf(MimickedClass::class) }

//fun Method.getMatchingNativeVariables(builder: ClassBuilder): List<LocalVariable> {
//	val mimicParams = this.getMimicParameters()
//}

fun CodeBuilder.injectTestMethod(): CodeBuilder =
	this.invokestatic(
		V1x21x1Implementations::class.classDesc,
		"test",
		MethodTypeDesc.of(ConstantDescs.CD_void)
	)

fun List<Parameter>.printParameterInfo() {
	this.forEach { method ->
		println("Parameter[Name: ${method.name}, ClassDesc: ${method.classDesc}, Type: ${method.type}]")
	}
}

fun List<LocalVariable>.getNativeLocalVariable(target: String): LocalVariable =
	this.first { it.typeSymbol().displayName() == target }

fun List<LocalVariable>.printLocalVarInfo() {
	this.forEach { localVar ->
		println("LocalVariable[Name: ${localVar.name()}, ClassDesc: ${localVar.typeSymbol()}]")
	}
}

fun CodeModel.getParameterDescs(): List<ClassDesc> =
	this.parent().get().methodTypeSymbol().parameterList()

fun MethodBuilder.getLocalVariableInfo(code: CodeModel): List<LocalVariable> {
	val list = mutableListOf<LocalVariable>()
	this.transformCode(code) { codeBuilder, codeElement ->
		if (codeElement is LocalVariable) list.add(codeElement)
		this.with(code)
	}
	return list
}

fun addToStaticArray(
	clazz: String,
	fieldName: String,
	arrayType: Class<*>,
	vararg elements: Any
) {
	val clazz = loadClass(clazz)
	val list = (clazz.getField(fieldName).get(null) as Array<*>).toMutableList()
	elements.forEach { list.add(if (it is MimickedClass) it.around else it) }
	val array = java.lang.reflect.Array.newInstance(arrayType, list.size)
	repeat(list.size) {
		java.lang.reflect.Array.set(array, it, list[it])
	}
	clazz.getField(fieldName).set(null, array)
}

val Parameter.classDesc: ClassDesc
	get() = ClassDesc.of(this.type.name)

val Class<*>.classDesc: ClassDesc
	get() = ClassDesc.of(this.name)

val KClass<*>.classDesc: ClassDesc
	get() = ClassDesc.of(this.java.name)