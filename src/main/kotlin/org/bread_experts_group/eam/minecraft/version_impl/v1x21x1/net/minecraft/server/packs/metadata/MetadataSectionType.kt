package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.metadata

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_metadata_MetadataSectionType
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.metadata.MetadataSectionType -> ate:
# {"fileName":"MetadataSectionType.java","id":"sourceFile"}
    com.google.gson.JsonObject toJson(java.lang.Object) -> a
    12:12:net.minecraft.server.packs.metadata.MetadataSectionType fromCodec(java.lang.String,com.mojang.serialization.Codec) -> a
 */
class MetadataSectionType<T>(around: Any) : MetadataSectionSerializer<T>(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_metadata_MetadataSectionType)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = MetadataSectionType::class.classDesc
	}
}