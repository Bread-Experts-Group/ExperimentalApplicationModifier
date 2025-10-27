package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_server_packs_PackResources
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.PackResources -> asq:
# {"fileName":"PackResources.java","id":"sourceFile"}
    java.lang.String METADATA_EXTENSION -> a
    java.lang.String PACK_META -> b
    net.minecraft.server.packs.resources.IoSupplier getRootResource(java.lang.String[]) -> a
    net.minecraft.server.packs.resources.IoSupplier getResource(net.minecraft.server.packs.PackType,net.minecraft.resources.ResourceLocation) -> a
    void listResources(net.minecraft.server.packs.PackType,java.lang.String,java.lang.String,net.minecraft.server.packs.PackResources$ResourceOutput) -> a
    java.util.Set getNamespaces(net.minecraft.server.packs.PackType) -> a
    java.lang.Object getMetadataSection(net.minecraft.server.packs.metadata.MetadataSectionSerializer) -> a
    net.minecraft.server.packs.PackLocationInfo location() -> a
    35:35:java.lang.String packId() -> b
    39:39:java.util.Optional knownPackInfo() -> c
    void close() -> close
 */
class PackResources(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_PackResources)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = PackResources::class.classDesc
	}
}