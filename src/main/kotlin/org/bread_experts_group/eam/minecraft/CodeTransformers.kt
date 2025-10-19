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
import java.lang.classfile.instruction.InvokeInstruction
import java.lang.classfile.instruction.LineNumber
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method

/**
 * Contains helper methods to aid in transforming code within classes and methods.
 */
interface CodeTransformers {
	/**
	 * CodeElement#with is automatically called after [transform] is invoked.
	 *
	 * @param withBefore If true, places the CodeBuilder#with before the transform to place native code behind the modifications.
	 * Defaults to false (puts modifications behind the native code)
	 */
	fun MethodBuilder.atLine(line: Int, codeModel: CodeModel, withBefore: Boolean = false, transform: (CodeBuilder, CodeElement) -> Unit) {
		this.transformCode(codeModel) { codeBuilder, codeElement ->
			if (withBefore) codeBuilder.with(codeElement)
			if (codeElement is LineNumber && codeElement.line() == line) transform(codeBuilder, codeElement)
			if (!withBefore) codeBuilder.with(codeElement)
		}
	}

	fun MethodBuilder.atInvoke(ordinal: Int, codeModel: CodeModel, transform: (CodeBuilder, CodeElement) -> Unit) {
		var counter = 0
		this.transformCode(codeModel) { codeBuilder, codeElement ->
			if (codeElement is InvokeInstruction && counter == ordinal) transform(codeBuilder, codeElement)
			else counter++
			codeBuilder.with(codeElement)
		}
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
			classElement.methodTypeSymbol() == typeDesc
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