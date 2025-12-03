package org.bread_experts_group.eam

import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodBuilder
import java.lang.classfile.instruction.LocalVariable
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDesc
import java.lang.reflect.Parameter
import kotlin.reflect.KClass

val SYSTEM_CLASS_LOADER: ClassLoader = ClassLoader.getSystemClassLoader()

fun loadClass(clazz: String): Class<*> = SYSTEM_CLASS_LOADER.loadClass(clazz)

///**
// * @return The parameters subclassing [MimickedClass].
// */
//fun Method.getMimicParameters(): List<Parameter> =
//	this.parameters.filter { it.type.kotlin.isSubclassOf(MimickedClass::class) }

//fun Method.getMatchingNativeVariables(builder: ClassBuilder): List<LocalVariable> {
//	val mimicParams = this.getMimicParameters()
//}

//fun CodeBuilder.injectTestMethod(): CodeBuilder =
//	this.invokestatic(
//		V1X21X1MinecraftImplementations::class.classDesc,
//		"test",
//		MethodTypeDesc.of(ConstantDescs.CD_void)
//	)

//fun List<Parameter>.printParameterInfo() {
//	this.forEach { method ->
//		println("Parameter[Name: ${method.name}, ClassDesc: ${method.classDesc}, Type: ${method.type}]")
//	}
//}

fun List<LocalVariable>.getNativeLocalVariable(target: String): LocalVariable =
	this.first { it.typeSymbol().displayName() == target }

//fun List<LocalVariable>.printLocalVarInfo() {
//	this.forEach { localVar ->
//		println("LocalVariable[Name: ${localVar.name()}, ClassDesc: ${localVar.typeSymbol()}]")
//	}
//}

//fun CodeModel.getParameterDescs(): List<ClassDesc> =
//	this.parent().get().methodTypeSymbol().parameterList()

fun MethodBuilder.getLocalVariableInfo(code: CodeModel): List<LocalVariable> {
	val list = mutableListOf<LocalVariable>()
	this.transformCode(code) { _, codeElement ->
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
	get() {
		val declaring = this.java.declaringClass
		return if (declaring != null) ClassDesc.of(declaring.name + "$" + this.simpleName)
		else ClassDesc.of(this.java.name)
	}

val ClassDesc.qualifiedName: String
	get() = "${this.packageName()}.${this.displayName()}"

val ClassDesc.clazz: Class<*>
	get() = loadClass(this.qualifiedName)

@Suppress("CAST_NEVER_SUCCEEDS")
fun String.asConstantDesc(): ConstantDesc = this as ConstantDesc