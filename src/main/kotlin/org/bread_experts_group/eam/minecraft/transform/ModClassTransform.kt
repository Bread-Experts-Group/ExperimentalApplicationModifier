package org.bread_experts_group.eam.minecraft.transform

import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement

/**
 * Class that allows mods to define transforms for mc classes. These should be passed into gatherTransforms in your [org.bread_experts_group.eam.minecraft.feature.MinecraftMod] subclass.
 */
abstract class ModClassTransform(
	val target: String
) : CodeTransformer {
	override val existingElements: MutableList<String> = mutableListOf()

	fun process(classBuilder: ClassBuilder, classElement: ClassElement) {
		this.transform().invoke(classBuilder, classElement)
	}

	abstract fun transform(): (ClassBuilder, ClassElement) -> Unit
}