package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.metadata.pack

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_metadata_pack_PackMetadataSection
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.metadata.MetadataSectionType
import java.lang.constant.ClassDesc
import java.util.*

/*
net.minecraft.server.packs.metadata.pack.PackMetadataSection -> atf:
# {"fileName":"PackMetadataSection.java","id":"sourceFile"}
    net.minecraft.network.chat.Component description -> c
    int packFormat -> d
    java.util.Optional supportedFormats -> e
    com.mojang.serialization.Codec CODEC -> a
    net.minecraft.server.packs.metadata.MetadataSectionType TYPE -> b
    12:12:void <init>(net.minecraft.network.chat.Component,int,java.util.Optional) -> <init>
    12:12:java.lang.String toString() -> toString
    12:12:int hashCode() -> hashCode
    12:12:boolean equals(java.lang.Object) -> equals
    12:12:net.minecraft.network.chat.Component description() -> a
    12:12:int packFormat() -> b
    12:12:java.util.Optional supportedFormats() -> c
    13:17:com.mojang.datafixers.kinds.App lambda$static$0(com.mojang.serialization.codecs.RecordCodecBuilder$Instance) -> a
    13:19:void <clinit>() -> <clinit>
 */
class PackMetadataSection private constructor(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_metadata_pack_PackMetadataSection)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = PackMetadataSection::class.classDesc

		val TYPE: MetadataSectionType<PackMetadataSection> = MetadataSectionType(clazz.getField("b").get(null))
	}

	constructor(description: Component, packFormat: Int,/* supportedFormats:*/) : this(
		clazz.getConstructor(Component.clazz, Int::class.java, Optional::class.java)
			.newInstance(description.around, packFormat, Optional.empty<Any>())
	)
}