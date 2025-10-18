package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_server_packs_repository_BuiltInPackSource
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.repository.BuiltInPackSource -> atj:
# {"fileName":"BuiltInPackSource.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> c
    java.lang.String VANILLA_ID -> a
    net.minecraft.server.packs.repository.KnownPack CORE_PACK_INFO -> b
    net.minecraft.server.packs.PackType packType -> d
    net.minecraft.server.packs.VanillaPackResources vanillaPack -> e
    net.minecraft.resources.ResourceLocation packDir -> f
    net.minecraft.world.level.validation.DirectoryValidator validator -> g
    36:41:void <init>(net.minecraft.server.packs.PackType,net.minecraft.server.packs.VanillaPackResources,net.minecraft.resources.ResourceLocation,net.minecraft.world.level.validation.DirectoryValidator) -> <init>
    45:50:void loadPacks(java.util.function.Consumer) -> loadPacks
    net.minecraft.server.packs.repository.Pack createVanillaPack(net.minecraft.server.packs.PackResources) -> a
    net.minecraft.network.chat.Component getPackTitle(java.lang.String) -> a
    58:58:net.minecraft.server.packs.VanillaPackResources getVanillaPack() -> a
    62:72:void listBundledPacks(java.util.function.Consumer) -> a
    75:76:void populatePackList(java.util.function.BiConsumer) -> a
    79:88:void discoverPacksInPath(java.nio.file.Path,java.util.function.BiConsumer) -> a
    91:91:java.lang.String pathToId(java.nio.file.Path) -> a
    net.minecraft.server.packs.repository.Pack createBuiltinPack(java.lang.String,net.minecraft.server.packs.repository.Pack$ResourcesSupplier,net.minecraft.network.chat.Component) -> a
    98:98:net.minecraft.server.packs.repository.Pack$ResourcesSupplier fixedResources(net.minecraft.server.packs.PackResources) -> b
    82:82:void lambda$discoverPacksInPath$3(java.util.function.BiConsumer,java.nio.file.Path,net.minecraft.server.packs.repository.Pack$ResourcesSupplier) -> a
    82:82:net.minecraft.server.packs.repository.Pack lambda$discoverPacksInPath$2(net.minecraft.server.packs.repository.Pack$ResourcesSupplier,java.lang.String) -> a
    75:75:void lambda$populatePackList$1(java.util.function.BiConsumer,java.nio.file.Path) -> a
    67:71:void lambda$listBundledPacks$0(java.util.function.Consumer,java.lang.String,java.util.function.Function) -> a
    25:29:void <clinit>() -> <clinit>
 */
open class BuiltInPackSource(around: Any) : RepositorySource(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_repository_BuiltInPackSource)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BuiltInPackSource::class.classDesc
	}
}