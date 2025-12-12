package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.resources

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_server_packs_resources_ResourceProvider
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.resources.ResourceProvider -> auh:
# {"fileName":"ResourceProvider.java","id":"sourceFile"}
    net.minecraft.server.packs.resources.ResourceProvider EMPTY -> b
    java.util.Optional getResource(net.minecraft.resources.ResourceLocation) -> getResource
    23:23:net.minecraft.server.packs.resources.Resource getResourceOrThrow(net.minecraft.resources.ResourceLocation) -> getResourceOrThrow
    27:27:java.io.InputStream open(net.minecraft.resources.ResourceLocation) -> open
    31:31:java.io.BufferedReader openAsReader(net.minecraft.resources.ResourceLocation) -> openAsReader
    35:35:net.minecraft.server.packs.resources.ResourceProvider fromMap(java.util.Map) -> fromMap
    35:35:java.util.Optional lambda$fromMap$2(java.util.Map,net.minecraft.resources.ResourceLocation) -> a
    23:23:java.io.FileNotFoundException lambda$getResourceOrThrow$1(net.minecraft.resources.ResourceLocation) -> b
    14:14:java.util.Optional lambda$static$0(net.minecraft.resources.ResourceLocation) -> c
    14:14:void <clinit>() -> <clinit>
 */
class ResourceProvider(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_resources_ResourceProvider)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ResourceProvider::class.classDesc
	}
}