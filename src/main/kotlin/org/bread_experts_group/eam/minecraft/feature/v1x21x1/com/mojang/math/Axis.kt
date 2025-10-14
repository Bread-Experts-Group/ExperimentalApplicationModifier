package org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.math

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com_mojang_math_Axis
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.org.joml.Quaternionf
import java.lang.constant.ClassDesc

/*
com.mojang.math.Axis -> a:
# {"fileName":"Axis.java","id":"sourceFile"}
    17:17:com.mojang.math.Axis of(org.joml.Vector3f) -> of
    17:17:org.joml.Quaternionf lambda$of$6(org.joml.Vector3f,float) -> a
 */
class Axis(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_math_Axis)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Axis::class.classDesc

		val XN: Axis = Axis(clazz.getField("a").get(null))
		val XP: Axis = Axis(clazz.getField("b").get(null))
		val YN: Axis = Axis(clazz.getField("c").get(null))
		val YP: Axis = Axis(clazz.getField("d").get(null))
		val ZN: Axis = Axis(clazz.getField("e").get(null))
		val ZP: Axis = Axis(clazz.getField("f").get(null))
	}

	fun rotation(value: Float): Quaternionf =
		Quaternionf(
			clazz.getMethod("rotation", Float::class.java).invoke(around, value)
		)

	fun rotationDegrees(value: Float): Quaternionf =
		Quaternionf(
			clazz.getMethod("rotationDegrees", Float::class.java).invoke(around, value)
		)
}