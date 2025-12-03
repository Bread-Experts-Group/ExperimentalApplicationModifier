package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import java.lang.constant.ClassDesc

interface ItemLike {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass("dcv")
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ItemLike::class.classDesc
	}
}