package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0

import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.feature.SupportedMCFeatures
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
import org.bread_experts_group.logging.ColoredHandler
import java.lang.classfile.ClassFile
import java.util.logging.Logger

object V1X0X0MinecraftImplementations : MinecraftImplementations() {
	override val logger: Logger = ColoredHandler.newLogger("V1x0x0 Impl")
	override val supportedFeatures: SupportedMCFeatures = mutableMapOf(
		MinecraftFeatures.BLOCK to mutableListOf(MinecraftBlockFeature1x0x0())
	)

	override fun preload(): List<String> = listOf(
		NativeConstantsV1x0x0.net_minecraft_GuiMainMenu
	)

	override fun start(scanning: Scanning, classFile: ClassFile) {
		BlockTransform(scanning, classFile).addTransform()
		ContainerCreativeTransform(scanning, classFile).addTransform()
		EntityPlayerTransform(scanning, classFile).addTransform()
		EntityPlayerSPTransform(scanning, classFile).addTransform()

		// LWJGL3ify
		// todo holy crap the amount of work that needs to go into this is astounding
		GuiMainMenuTransform_LWJGL3(scanning, classFile).addTransform()
		GuiScreenTransform_LWJGL3(scanning, classFile).addTransform()
		EntityRendererTransform_LWJGL3(scanning, classFile).addTransform()
		MinecraftTransform_LWJGL3(scanning, classFile).addTransform()
		OpenGlHelperTransform_LWJGL3(scanning, classFile).addTransform()
		TesselatorTransform_LWJGL3(scanning, classFile).addTransform()
		OpenGlCapsCheckerTransform_LWJGL3(scanning, classFile).addTransform()
	}
	@Suppress("unused")
	@JvmStatic
	fun registerBlocks() {
		mods.forEach {
			it.addBlocks(this.get(MinecraftFeatures.BLOCK))
		}
	}
}