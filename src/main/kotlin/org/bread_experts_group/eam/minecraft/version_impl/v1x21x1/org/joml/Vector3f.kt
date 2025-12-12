package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.org.joml

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import java.lang.constant.ClassDesc

class Vector3f(around: Any) : Vector3fc(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass("org.joml.Vector3f")
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Vector3f::class.classDesc
	}

	constructor() : this(clazz.getConstructor().newInstance())

	fun x(): Float = clazz.getMethod("x").invoke(around) as Float
	fun y(): Float = clazz.getMethod("y").invoke(around) as Float
	fun z(): Float = clazz.getMethod("z").invoke(around) as Float
}