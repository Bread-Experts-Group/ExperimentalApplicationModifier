package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_core_DefaultedRegistry
import java.lang.constant.ClassDesc

class DefaultedRegistry<T : MimickedClass>(mimics: Class<T>, around: Any) : Registry<T>(mimics, around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_core_DefaultedRegistry)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = DefaultedRegistry::class.classDesc
	}
}