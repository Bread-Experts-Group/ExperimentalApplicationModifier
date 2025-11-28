package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.eam.clazz
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.Scanning
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.MethodBuilder
import java.lang.classfile.MethodModel
import java.lang.constant.ClassDesc
import java.lang.constant.MethodTypeDesc
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.exists
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.isSubclassOf

abstract class ClassTransform(
	private val targetClass: String,
	private val deobfClassName: String,
	private val scanning: Scanning,
	private val classFile: ClassFile
) : CodeTransformer {
	private val existingMethods: MutableList<String> = mutableListOf()

	fun startTransform(writeModifiedFile: Boolean = false) {
		scanning[targetClass] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) { classBuilder, classElement ->
				transform().invoke(classBuilder, classElement)
			}.also {
				if(writeModifiedFile) {
					val folder = Path("transformed_classes")
					if (!folder.exists()) folder.createDirectory()
					Files.write(
						Path("transformed_classes/$deobfClassName [${targetClass.substringAfterLast('_')}].class"),
						it
					)
				}
			}
		}
	}

	/**
	 * Integrates a method from a [sourceClass] into the class transform.
	 *
	 * @param generateMimicMethod Generates an additional method to invoke mimic based parameters from the source method using native classes.
	 */
	fun ClassBuilder.integrateMethod(
		sourceClass: Class<*>,
		methodName: String,
		methodTypeDesc: MethodTypeDesc? = null,
		generateMimicMethod: Boolean = false
	) {
		val transformer = this@ClassTransform
		if (methodName !in transformer.existingMethods) transformer.existingMethods.add(methodName) else return
		val classData = transformer.readClassSource(sourceClass)
		transformer.classFile.transformClass(transformer.classFile.parse(classData)) { builder, element ->
			val method = if (
				element is MethodModel &&
				element.methodName().equalsString(methodName) &&
				(element.methodTypeSymbol() == methodTypeDesc || methodTypeDesc == null)
			) element else null
			if (method != null) {
				this.with(method)
				if (generateMimicMethod) {
					val typeDesc = method.methodTypeSymbol()
					this.withMethodBody(
						"${method.methodName()}_EAMGenerated",
						MethodTypeDesc.of(
							typeDesc.returnType(),
							typeDesc.parameterList().map { desc ->
								if (desc.isPrimitive) desc else {
									val clazz = desc.clazz
									if (clazz.kotlin.isSubclassOf(MimickedClass::class)) {
										val companionInst = clazz.kotlin.companionObjectInstance!!
										companionInst.javaClass.getMethod("getClassDesc").invoke(companionInst) as ClassDesc
									} else desc
								}
							}
						),
						ACC_PUBLIC
					) { codeBuilder ->
						val parameters = method.methodTypeSymbol().parameterList()
						codeBuilder.aload(0)
						parameters.forEachIndexed { index, desc ->
							val slot = index + 1
							if (desc.isPrimitive) {
								when (desc.descriptorString()) {
									"Z" -> codeBuilder.iload(slot)
									"D" -> codeBuilder.dload(slot)
									"F" -> codeBuilder.fload(slot)
									"J" -> codeBuilder.lload(slot)
								}
							} else codeBuilder.invokeSpecialNewMimicClass(desc, slot)
						}

						codeBuilder
							.invokevirtual(
								ClassDesc.of(transformer.targetClass),
								methodName,
								method.methodTypeSymbol()
							)
							.return_()
					}
				}
			}
			builder.with(element)
		}
	}

	/**
	 * Wraps withMethod with a check to see if this method already exists inside the class being built.
	 *
	 * If the method doesn't exist, invoke the builder.
	 * Else do nothing to prevent duplicate entries from being added.
	 */
	protected fun ClassBuilder.addMethod(
		name: String,
		descriptor: MethodTypeDesc,
		flags: Int,
		builder: (MethodBuilder) -> Unit
	) {
		if (name !in existingMethods) {
			this.withMethod(name, descriptor, flags, builder)
			existingMethods.add(name)
		}
	}
	/**
	 * ## !!WARNING!!
	 * This method is executed multiple times during class transformation due to [ClassBuilder] iterating through the structure being built.
	 *
	 * Ensure calls that add methods or fields aren't ran more than once, or else the JVM will throw an error about duplicate entries.
	 *
	 * @see addMethod
	 * @see modifyMethod
	 */
	protected abstract fun transform(): (ClassBuilder, ClassElement) -> Unit
}