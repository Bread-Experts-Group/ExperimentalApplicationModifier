package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.net.minecraft

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import java.lang.constant.ClassDesc

class Entity(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(NativeConstantsV1x0x0.net_minecraft_Entity)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Entity::class.classDesc
	}
}