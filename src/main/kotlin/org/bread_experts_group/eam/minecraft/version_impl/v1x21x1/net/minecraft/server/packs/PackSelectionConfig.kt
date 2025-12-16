package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_PackSelectionConfig
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.Pack
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.PackSelectionConfig -> asr:
# {"fileName":"PackSelectionConfig.java","id":"sourceFile"}
    boolean required -> a
    net.minecraft.server.packs.repository.Pack$Position defaultPosition -> b
    boolean fixedPosition -> c
    5:5:java.lang.String toString() -> toString
    5:5:int hashCode() -> hashCode
    5:5:boolean equals(java.lang.Object) -> equals
    5:5:boolean required() -> a
    5:5:net.minecraft.server.packs.repository.Pack$Position defaultPosition() -> b
    5:5:boolean fixedPosition() -> c
 */
class PackSelectionConfig(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_PackSelectionConfig)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = PackSelectionConfig::class.classDesc
	}

	constructor(required: Boolean, defaultPosition: Pack.Position, fixedPosition: Boolean) : this(
		clazz.getConstructor(Boolean::class.java, Pack.Position.clazz, Boolean::class.java)
			.newInstance(required, defaultPosition.around, fixedPosition)
	)
}