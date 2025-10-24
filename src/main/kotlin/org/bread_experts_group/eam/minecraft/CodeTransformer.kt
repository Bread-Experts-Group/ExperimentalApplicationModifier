package org.bread_experts_group.eam.minecraft

import java.lang.classfile.AccessFlags
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.CodeBuilder
import java.lang.classfile.CodeElement
import java.lang.classfile.CodeModel
import java.lang.classfile.FieldModel
import java.lang.classfile.MethodBuilder
import java.lang.classfile.MethodElement
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.LineNumber
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method

/**
 * Contains helper methods to aid in transforming code within classes and methods.
 */
interface CodeTransformer {
	fun CodeBuilder.atLine(
		line: Int,
		codeElement: CodeElement,
		transform: (CodeBuilder) -> Unit
	): CodeBuilder {
		if (codeElement is LineNumber && codeElement.line() == line) transform(this)
		return this
	}

	// todo injects at every return in the targeted method, find a way to fix this
	fun CodeBuilder.atReturn(
		codeElement: CodeElement,
		transform: (CodeBuilder) -> Unit
	): CodeBuilder {
		if (codeElement is ReturnInstruction) transform(this)
		return this
	}

	fun ClassBuilder.modifyMethod(
		classElement: ClassElement,
		methodName: String,
		typeDesc: MethodTypeDesc? = null,
		transform: (MethodBuilder, MethodElement) -> Unit
	) {
		if (
			classElement is MethodModel &&
			classElement.methodName().equalsString(methodName) &&
			(classElement.methodTypeSymbol() == typeDesc || typeDesc == null)
		) {
			this.transformMethod(classElement) { methodBuilder, methodElement ->
				transform(methodBuilder, methodElement)
			}
		} else this.with(classElement)
	}

	fun invokeAtMethodReturns(
		targetMethodName: String,
		targetMethodType: MethodTypeDesc,
		method: Method
	): (ClassBuilder, ClassElement) -> Boolean {
		if (method.returnType != Void.TYPE) throw IllegalArgumentException(
			"$method (in injection to returns of $targetMethodName : $targetMethodType) must return void!"
		)
		return transform@{ classBuilder, classElement ->
			if (
				classElement is MethodModel &&
				classElement.methodName().equalsString(targetMethodName) &&
				classElement.methodType().equalsString(targetMethodType.descriptorString())
			) {
				classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
					if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
						// todo replace with invokeStaticMethodWithLocalVars
						if (codeElement is ReturnInstruction) codeBuilder.invokeStaticMethodWithMimics(method)
						codeBuilder.with(codeElement)
					}
				}
				return@transform true
			}
			return@transform false
		}
	}

	fun modifyFieldAccess(
		targetField: String,
		newAccessFlags: Int
	): (ClassBuilder, ClassElement) -> Boolean = transform@{ classBuilder, classElement ->
		if (
			classElement is FieldModel &&
			classElement.fieldName().equalsString(targetField)
		) {
			classBuilder.transformField(classElement) { fieldBuilder, fieldElement ->
				if (fieldElement is AccessFlags) fieldBuilder.withFlags(newAccessFlags)
				else fieldBuilder.with(fieldElement)
			}
			return@transform true
		}
		return@transform false
	}

	fun modifyMethodAccess(
		targetMethod: String,
		targetMethodType: MethodTypeDesc,
		newAccessFlags: Int
	): (ClassBuilder, ClassElement) -> Boolean = transform@{ classBuilder, classElement ->
		if (
			classElement is MethodModel &&
			classElement.methodName().equalsString(targetMethod) &&
			classElement.methodType().equalsString(targetMethodType.descriptorString())
		) {
			classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
				if (methodElement is AccessFlags) methodBuilder.withFlags(newAccessFlags)
				else methodBuilder.with(methodElement)
			}
			return@transform true
		}
		return@transform false
	}
}