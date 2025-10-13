package org.bread_experts_group.eam.minecraft.feature.v1x21x1.org.joml

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass

class Quaternionf(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> =
			loadClass("org.joml.Quaternionf")
	}

	constructor() : this(clazz.getConstructor().newInstance())
}