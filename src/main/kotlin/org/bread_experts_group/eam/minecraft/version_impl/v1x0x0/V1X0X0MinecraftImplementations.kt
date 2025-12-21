package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0

import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import org.bread_experts_group.eam.minecraft.feature.SupportedMCFeatures
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.BlockTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.ContainerCreativeTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.EntityPlayerSPTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.EntityPlayerTransform
import org.bread_experts_group.logging.ColoredHandler
import java.util.logging.Logger

object V1X0X0MinecraftImplementations : MinecraftImplementations() {
	override val logger: Logger = ColoredHandler.newLogger("V1x0x0 Impl")
	override val supportedFeatures: SupportedMCFeatures = mutableMapOf(
		MinecraftFeatures.BLOCK to mutableListOf(MinecraftBlockFeature1x0x0())
	)

	override fun start() {
		BlockTransform(scanning, classFile).startTransform()
		ContainerCreativeTransform(scanning, classFile).startTransform()
		EntityPlayerTransform(scanning, classFile).startTransform()
		EntityPlayerSPTransform(scanning, classFile).startTransform()

		// LWJGL3ify
		// todo holy crap the amount of work that needs to go into this is astounding
//		MinecraftTransform_LWJGL3(scanning, classFile).startTransform()
//		OpenGlHelperTransform_LWJGL3(scanning, classFile).startTransform()
//		TesselatorTransform_LWJGL3(scanning, classFile).startTransform()
//		OpenGlCapsCheckerTransform_LWJGL3(scanning, classFile).startTransform()
	}
	@Suppress("unused")
	@JvmStatic
	fun registerBlocks() {
		mods.forEach {
			it.addBlocks(this.get(MinecraftFeatures.BLOCK))
		}
	}
}