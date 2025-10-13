package org.bread_experts_group.eam

import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import java.lang.classfile.ClassBuilder
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodBuilder
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.LocalVariable
import java.lang.constant.ClassDesc
import java.lang.reflect.Method
import java.lang.reflect.Parameter
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.isSubclassOf

fun loadClass(clazz: String): Class<*> = ClassLoader.getSystemClassLoader().loadClass(clazz)

/**
 * @return The native class name of the wrapped class.
 * Returns an empty string if the class does not subclass [MimickedClass].
 */
fun Class<*>.getAroundClassName(): String {
	val kClass = this.kotlin
	if (!kClass.isSubclassOf(MimickedClass::class)) return ""
	val companionInst = kClass.companionObjectInstance ?: return ""
	val clazz = companionInst.javaClass.getMethod("getClazz").invoke(companionInst)
	return clazz.toString().substringAfterLast(' ')
}
/**
 * @return The parameters subclassing [MimickedClass].
 */
fun Method.getMimicParameters(): List<Parameter> =
	this.parameters.filter { it.type.kotlin.isSubclassOf(MimickedClass::class) }

//fun Method.getMatchingNativeVariables(builder: ClassBuilder): List<LocalVariable> {
//	val mimicParams = this.getMimicParameters()
//}

/**
 * @return The wrapped native class names of each parameter subclassing [MimickedClass].
 */
fun List<Parameter>.getMimicClassNames(): List<String> = this.map { it.type.getAroundClassName() }

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

fun MethodBuilder.getLocalVariableInfo(code: CodeModel): List<LocalVariable> {
	val list = mutableListOf<LocalVariable>()
	this.transformCode(code) { codeBuilder, codeElement ->
		if (codeElement is LocalVariable) list.add(codeElement)
		this.with(code)
	}
	return list
}

fun MethodBuilder.populateVariableList(code: CodeModel, destination: MutableList<LocalVariable>) {
	destination.addAll(this.getLocalVariableInfo(code))
}

val Parameter.classDesc: ClassDesc
	get() = ClassDesc.of(this.type.name)