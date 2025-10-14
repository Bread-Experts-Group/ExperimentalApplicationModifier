package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.repository

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.PackType
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.validation.DirectoryValidator
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_server_packs_repository_FolderRepositorySource
import java.lang.constant.ClassDesc
import java.nio.file.Path

/*
net.minecraft.server.packs.repository.FolderRepositorySource -> atk:
# {"fileName":"FolderRepositorySource.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> a
    net.minecraft.server.packs.PackSelectionConfig DISCOVERED_PACK_SELECTION_CONFIG -> b
    java.nio.file.Path folder -> c
    net.minecraft.server.packs.PackType packType -> d
    net.minecraft.server.packs.repository.PackSource packSource -> e
    net.minecraft.world.level.validation.DirectoryValidator validator -> f
    44:49:void <init>(java.nio.file.Path,net.minecraft.server.packs.PackType,net.minecraft.server.packs.repository.PackSource,net.minecraft.world.level.validation.DirectoryValidator) -> <init>
    52:52:java.lang.String nameFromPath(java.nio.file.Path) -> a
    58:71:void loadPacks(java.util.function.Consumer) -> loadPacks
    74:79:net.minecraft.server.packs.PackLocationInfo createDiscoveredFilePackInfo(java.nio.file.Path) -> b
    84:103:void discoverPacks(java.nio.file.Path,net.minecraft.world.level.validation.DirectoryValidator,java.util.function.BiConsumer) -> a
    62:67:void lambda$loadPacks$0(java.util.function.Consumer,java.nio.file.Path,net.minecraft.server.packs.repository.Pack$ResourcesSupplier) -> a
    31:33:void <clinit>() -> <clinit>
 */
class FolderRepositorySource(around: Any) : RepositorySource(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_repository_FolderRepositorySource)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = FolderRepositorySource::class.classDesc
	}

	constructor(
		path: Path,
		packType: PackType,
		packSource: PackSource,
		directoryValidator: DirectoryValidator
	) : this(
		clazz.getConstructor(
			Path::class.java,
			PackType.clazz,
			PackSource.clazz,
			DirectoryValidator.clazz
		).newInstance(path, packType.around, packSource.around, directoryValidator.around)
	)
}