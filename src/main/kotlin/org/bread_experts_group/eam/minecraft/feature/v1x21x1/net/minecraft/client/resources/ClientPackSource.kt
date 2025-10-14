package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.repository.BuiltInPackSource
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.validation.DirectoryValidator
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_resources_ClientPackSource
import java.lang.constant.ClassDesc
import java.nio.file.Path

/*
net.minecraft.client.resources.ClientPackSource -> grc:
# {"fileName":"ClientPackSource.java","id":"sourceFile"}
    net.minecraft.server.packs.metadata.pack.PackMetadataSection VERSION_METADATA_SECTION -> d
    net.minecraft.server.packs.BuiltInMetadata BUILT_IN_METADATA -> e
    java.lang.String HIGH_CONTRAST_PACK -> c
    java.util.Map SPECIAL_PACK_NAMES -> f
    net.minecraft.server.packs.PackLocationInfo VANILLA_PACK_INFO -> g
    net.minecraft.server.packs.PackSelectionConfig VANILLA_SELECTION_CONFIG -> h
    net.minecraft.server.packs.PackSelectionConfig BUILT_IN_SELECTION_CONFIG -> i
    net.minecraft.resources.ResourceLocation PACKS_DIR -> j
    java.nio.file.Path externalAssetDir -> k
    71:73:void <init>(java.nio.file.Path,net.minecraft.world.level.validation.DirectoryValidator) -> <init>
    76:80:net.minecraft.server.packs.PackLocationInfo createBuiltInPackLocation(java.lang.String,net.minecraft.network.chat.Component) -> a
    86:92:java.nio.file.Path findExplodedAssetPacks(java.nio.file.Path) -> a
    96:108:net.minecraft.server.packs.VanillaPackResources createVanillaPackSource(java.nio.file.Path) -> b
    113:114:net.minecraft.network.chat.Component getPackTitle(java.lang.String) -> a
    120:120:net.minecraft.server.packs.repository.Pack createVanillaPack(net.minecraft.server.packs.PackResources) -> a
    126:126:net.minecraft.server.packs.repository.Pack createBuiltinPack(java.lang.String,net.minecraft.server.packs.repository.Pack$ResourcesSupplier,net.minecraft.network.chat.Component) -> a
    131:136:void populatePackList(java.util.function.BiConsumer) -> a
    31:65:void <clinit>() -> <clinit>
 */
class ClientPackSource(around: Any) : BuiltInPackSource(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_resources_ClientPackSource)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ClientPackSource::class.classDesc
	}

	constructor(path: Path, validator: DirectoryValidator) : this(
		clazz.getConstructor(Path::class.java, DirectoryValidator.clazz)
			.newInstance(path, validator.around)
	)
}