package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_repository_KnownPack
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.repository.KnownPack -> atl:
# {"fileName":"KnownPack.java","id":"sourceFile"}
    java.lang.String namespace -> c
    java.lang.String id -> d
    java.lang.String version -> e
    net.minecraft.network.codec.StreamCodec STREAM_CODEC -> a
    java.lang.String VANILLA_NAMESPACE -> b
    11:11:void <init>(java.lang.String,java.lang.String,java.lang.String) -> <init>
    22:22:net.minecraft.server.packs.repository.KnownPack vanilla(java.lang.String) -> a
    26:26:boolean isVanilla() -> a
    31:31:java.lang.String toString() -> toString
    11:11:int hashCode() -> hashCode
    11:11:boolean equals(java.lang.Object) -> equals
    11:11:java.lang.String namespace() -> b
    11:11:java.lang.String id() -> c
    11:11:java.lang.String version() -> d
    12:12:void <clinit>() -> <clinit>
 */
class KnownPack private constructor(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_repository_KnownPack)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = KnownPack::class.classDesc
	}

	constructor(namespace: String, id: String, version: String) : this(
		clazz.getConstructor(String::class.java, String::class.java, String::class.java)
			.newInstance(namespace, id, version)
	)
}