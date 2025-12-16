package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_VanillaPackResources
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.VanillaPackResources -> asu:
# {"fileName":"VanillaPackResources.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> c
    net.minecraft.server.packs.PackLocationInfo location -> d
    net.minecraft.server.packs.BuiltInMetadata metadata -> e
    java.util.Set namespaces -> f
    java.util.List rootPaths -> g
    java.util.Map pathsForType -> h
    35:41:void <init>(net.minecraft.server.packs.PackLocationInfo,net.minecraft.server.packs.BuiltInMetadata,java.util.Set,java.util.List,java.util.Map) -> <init>
    46:55:net.minecraft.server.packs.resources.IoSupplier getRootResource(java.lang.String[]) -> a
    59:72:void listRawPaths(net.minecraft.server.packs.PackType,net.minecraft.resources.ResourceLocation,java.util.function.Consumer) -> a
    76:103:void listResources(net.minecraft.server.packs.PackType,java.lang.String,java.lang.String,net.minecraft.server.packs.PackResources$ResourceOutput) -> a
    106:108:void getResources(net.minecraft.server.packs.PackResources$ResourceOutput,java.lang.String,java.nio.file.Path,java.util.List) -> a
    113:113:net.minecraft.server.packs.resources.IoSupplier getResource(net.minecraft.server.packs.PackType,net.minecraft.resources.ResourceLocation) -> a
    133:133:java.util.Set getNamespaces(net.minecraft.server.packs.PackType) -> a
    139:151:java.lang.Object getMetadataSection(net.minecraft.server.packs.metadata.MetadataSectionSerializer) -> a
    156:156:net.minecraft.server.packs.PackLocationInfo location() -> a
    161:161:void close() -> close
    168:168:net.minecraft.server.packs.resources.ResourceProvider asProvider() -> d
    168:168:java.util.Optional lambda$asProvider$7(net.minecraft.resources.ResourceLocation) -> a
    168:168:net.minecraft.server.packs.resources.Resource lambda$asProvider$6(net.minecraft.server.packs.resources.IoSupplier) -> a
    125:126:net.minecraft.server.packs.resources.IoSupplier lambda$getResource$5(net.minecraft.resources.ResourceLocation,com.mojang.serialization.DataResult$Error) -> a
    115:122:net.minecraft.server.packs.resources.IoSupplier lambda$getResource$4(net.minecraft.resources.ResourceLocation,net.minecraft.server.packs.PackType,java.util.List) -> a
    101:101:void lambda$listResources$3(java.lang.String,com.mojang.serialization.DataResult$Error) -> a
    79:98:void lambda$listResources$2(net.minecraft.server.packs.PackType,net.minecraft.server.packs.PackResources$ResourceOutput,java.lang.String,java.util.List) -> a
    70:70:void lambda$listRawPaths$1(net.minecraft.resources.ResourceLocation,com.mojang.serialization.DataResult$Error) -> b
    62:67:void lambda$listRawPaths$0(net.minecraft.resources.ResourceLocation,net.minecraft.server.packs.PackType,java.util.function.Consumer,java.util.List) -> a
    25:25:void <clinit>() -> <clinit>
 */
class VanillaPackResources(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_VanillaPackResources)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = VanillaPackResources::class.classDesc
	}
}