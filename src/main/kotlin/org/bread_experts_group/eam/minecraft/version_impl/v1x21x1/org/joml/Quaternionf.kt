package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.org.joml

import org.bread_experts_group.eam.loadClass

class Quaternionf(around: Any) : Quaternionfc(around) {
	companion object {
		val clazz: Class<*> = loadClass("org.joml.Quaternionf")
	}

	constructor() : this(clazz.getConstructor().newInstance())

	fun conjugate(dest: Quaternionf): Quaternionf = Quaternionf(
		clazz.getMethod("conjugate", clazz)
			.invoke(around, dest.around)
	)
}