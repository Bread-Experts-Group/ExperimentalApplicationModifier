package org.bread_experts_group.eam.minecraft.transform

import org.bread_experts_group.eam.getLocalVariableInfo
import org.bread_experts_group.eam.minecraft.invokeStaticWithLocalVars
import org.bread_experts_group.eam.minecraft.mimic.NativeLookup
import java.lang.classfile.AccessFlags
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.CodeBuilder
import java.lang.classfile.CodeElement
import java.lang.classfile.CodeModel
import java.lang.classfile.FieldModel
import java.lang.classfile.MethodBuilder
import java.lang.classfile.MethodModel
import java.lang.classfile.MethodTransform
import java.lang.classfile.instruction.LineNumber
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method
import java.net.URI
import java.nio.file.FileSystems
import java.nio.file.Files

/**
 * Contains helper methods to aid in transforming code within classes and methods.
 */
interface CodeTransformer {
	fun readClassSource(clazz: Class<*>): ByteArray {
		val fullPath = clazz.name.replace('.', '/')
		val subStringPath = "/" + fullPath.substringBeforeLast('/')
		val className = fullPath.substringAfterLast('/')
		val location = this::class.java.getResource(subStringPath)?.toURI() ?: throw NullPointerException()
		val env = hashMapOf<String, String>()
		val array = location.toString().split("!")
		val uri = URI.create(array[0])
		val fs = try {
			FileSystems.getFileSystem(uri)
		} catch (_: Exception) {
			FileSystems.newFileSystem(uri, env)
		}
		val path = fs.getPath(array[1] + "/" + className + ".class")
		return Files.readAllBytes(path)
	}

	fun CodeBuilder.atLineNumber(
		line: Int,
		codeElement: CodeElement,
		transform: (CodeBuilder) -> Unit
	): CodeBuilder {
		if (codeElement is LineNumber && codeElement.line() == line) transform(this)
		return this
	}

	fun ClassBuilder.transformMethod(
		classElement: ClassElement,
		methodName: String,
		typeDesc: MethodTypeDesc? = null,
		transform: MethodTransform
	) : Boolean = if (
		classElement is MethodModel &&
		classElement.methodName().equalsString(methodName) &&
		(classElement.methodTypeSymbol() == typeDesc || typeDesc == null)
	) {
		this.transformMethod(classElement, transform)
		true
	} else false

	fun ClassBuilder.transformMethodCode(
		classElement: ClassElement,
		methodName: String,
		typeDesc: MethodTypeDesc?,
		transform: (CodeBuilder, CodeElement, Int) -> Unit
	) : Boolean = this.transformMethod(classElement, methodName, typeDesc) { methodBuilder, methodElement ->
		if (methodElement is CodeModel) methodBuilder.transformCodeIndexed(methodElement, transform)
	}
	/**
	 * The index refers to the position of a [CodeElement] in the method being transformed.
	 */
	fun MethodBuilder.transformCodeIndexed(model: CodeModel, transform: (CodeBuilder, CodeElement, Int) -> Unit) {
		var index = 0
		this.transformCode(model) { c, e ->
			@Suppress("AssignedValueIsNeverRead")
			transform(c, e, index++)
		}
	}

	fun invokeAtMethodReturns(
		lookup: NativeLookup,
		targetMethodName: String,
		targetMethodType: MethodTypeDesc,
		method: Method
	): (ClassBuilder, ClassElement) -> Boolean {
		java.lang.Boolean.TYPE
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
					if (methodElement is CodeModel) {
						val localVars = methodBuilder.getLocalVariableInfo(methodElement)
						methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							if (codeElement is ReturnInstruction)
								codeBuilder.invokeStaticWithLocalVars(method, localVars)
							codeBuilder.with(codeElement)
						}
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
			classElement.methodTypeSymbol() == targetMethodType
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