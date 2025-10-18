package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.eam.minecraft.feature.Scanning
import java.lang.classfile.AccessFlags
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.classfile.FieldModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.exists

abstract class ClassTransform(
	private val targetClass: String,
	private val deobfClassName: String,
	private val scanning: Scanning,
	private val classFile: ClassFile
) {
	fun startTransform(writeModifiedFile: Boolean = false) {
		scanning[targetClass] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) { classBuilder, classElement ->
				transform().invoke(classBuilder, classElement)
			}.also { if(writeModifiedFile) {
				val folder = Path("transformed_classes")
				if (!folder.exists()) folder.createDirectory()
				Files.write(
					Path("transformed_classes/$deobfClassName [${targetClass.substringAfterLast('_')}].class"),
					it
				)
			} }
		}
	}

	protected abstract fun transform(): (ClassBuilder, ClassElement) -> Unit

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

	fun atLine(line: Int) {}

	fun atInvoke(ordinal: Int) {}

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