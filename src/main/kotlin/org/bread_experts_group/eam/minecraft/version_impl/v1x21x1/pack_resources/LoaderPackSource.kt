package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.pack_resources

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.BuiltInMetadata
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackLocationInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackSelectionConfig
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.VanillaPackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.VanillaPackResourcesBuilder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.metadata.pack.PackMetadataSection
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.BuiltInPackSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.KnownPack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.Pack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.PackSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.validation.DirectoryValidator
import java.nio.file.Path
import java.util.*

// todo future objective: gathering and adding mod jar assets to eam's pack source
class LoaderPackSource(
	path: Path,
	directoryValidator: DirectoryValidator
) : BuiltInPackSource(
	PackType.CLIENT_RESOURCES,
	createPackSource(path),
	ResourceLocation.fromNamespaceAndPath("eam", "resourcepacks"),
	directoryValidator
) {
	companion object {
		private val EAM_PACK_INFO: PackLocationInfo = PackLocationInfo(
			"eam",
			Component.literal("EAM Internal Assets"),
			PackSource.BUILT_IN,
			Optional.of(KnownPack("eam", "core", "1.0"))
		)

		private val EAM_METADATA: BuiltInMetadata = BuiltInMetadata.of(
			PackMetadataSection.TYPE,
			PackMetadataSection(Component.literal("eam"), 34)
		)

		private fun createPackSource(path: Path): VanillaPackResources =
			VanillaPackResourcesBuilder()
				.pushAssetPath(PackType.CLIENT_RESOURCES, path)
				.exposeNamespace("breadmod", "minecraft")
				.setMetadata(EAM_METADATA)
				.build(EAM_PACK_INFO)

		private fun createBuiltInPackLocation(id: String, title: Component) =
			PackLocationInfo(id, title, PackSource.BUILT_IN, Optional.of(KnownPack("breadmod", id, "1.0")))
	}

	override fun createVanillaPack(resources: PackResources): Pack? = Pack.readMetaAndCreate(
		EAM_PACK_INFO,
		fixedResources(resources),
		PackType.CLIENT_RESOURCES,
		PackSelectionConfig(true, Pack.Position.TOP, false)
	)

	override fun getPackTitle(id: String): Component = Component.literal("EAM Test")

	override fun createBuiltinPack(
		id: String,
		resources: Pack.ResourcesSupplier,
		name: Component
	): Pack? = Pack.readMetaAndCreate(
		createBuiltInPackLocation(id, name),
		resources,
		PackType.CLIENT_RESOURCES,
		PackSelectionConfig(true, Pack.Position.TOP, false)
	)
}