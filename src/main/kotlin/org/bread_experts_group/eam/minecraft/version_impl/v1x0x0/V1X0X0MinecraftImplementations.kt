package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0

import org.bread_experts_group.BSLLogMessage
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import org.bread_experts_group.eam.minecraft.feature.SupportedMCFeatures
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.BlockTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.ContainerCreativeTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.EntityPlayerSPTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.EntityPlayerTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify.EntityRendererTransform_LWJGL3
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify.GuiMainMenuTransform_LWJGL3
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify.GuiScreenTransform_LWJGL3
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify.MinecraftTransform_LWJGL3
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify.OpenGlCapsCheckerTransform_LWJGL3
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify.OpenGlHelperTransform_LWJGL3
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify.TesselatorTransform_LWJGL3
import org.bread_experts_group.generic.logging.LevelLogger

object V1X0X0MinecraftImplementations : MinecraftImplementations() {
	override val logger: LevelLogger<BSLLogMessage> = LevelLogger("V1x0x0 Impl")
	override val supportedFeatures: SupportedMCFeatures = mutableMapOf(
		MinecraftFeatures.BLOCK to mutableListOf(MinecraftBlockFeature1x0x0())
	)

	override fun start(mods: List<MinecraftMod>, transformHolder: ModTransformHolder) {
		addToScanning(
			BlockTransform(transformHolder),
			ContainerCreativeTransform(transformHolder),
			EntityPlayerTransform(transformHolder),
			EntityPlayerSPTransform(transformHolder),
			GuiMainMenuTransform_LWJGL3(),
			GuiScreenTransform_LWJGL3(),
			EntityRendererTransform_LWJGL3(),
			MinecraftTransform_LWJGL3(),
			OpenGlHelperTransform_LWJGL3(),
			TesselatorTransform_LWJGL3(),
			OpenGlCapsCheckerTransform_LWJGL3()
		)
	}

	@Suppress("unused")
	@JvmStatic
	fun registerBlocks() {
		for ((_, modGroup) in mods) for (mod in modGroup) mod.addBlocks(
			this.get(MinecraftFeatures.BLOCK)
		)
	}
}