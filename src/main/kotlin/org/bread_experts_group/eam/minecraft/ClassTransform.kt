package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.eam.minecraft.feature.Scanning
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.exists

abstract class ClassTransform(
	private val targetClass: String,
	private val deobfClassName: String,
	private val scanning: Scanning,
	private val classFile: ClassFile
) : CodeTransformers {
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
}