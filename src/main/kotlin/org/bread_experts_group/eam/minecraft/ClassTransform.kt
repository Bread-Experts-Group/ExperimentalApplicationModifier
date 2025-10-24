package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.eam.minecraft.feature.Scanning
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.MethodBuilder
import java.lang.constant.MethodTypeDesc
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.exists

abstract class ClassTransform(
	private val targetClass: String,
	private val deobfClassName: String,
	private val scanning: Scanning,
	private val classFile: ClassFile
) : CodeTransformer {
	// classBuilder.constantPool().forEach { println(it::class.qualifiedName) }
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