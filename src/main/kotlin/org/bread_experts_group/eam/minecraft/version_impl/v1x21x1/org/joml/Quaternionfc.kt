package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.org.joml

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import java.lang.constant.ClassDesc

abstract class Quaternionfc(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass("org.joml.Quaternionfc")
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Quaternionfc::class.classDesc
	}
}