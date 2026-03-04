package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0

import org.bread_experts_group.BSLLogMessage
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.feature.SupportedMCFeatures
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.BlockTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.ContainerCreativeTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.EntityPlayerSPTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.EntityPlayerTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify.*
import org.bread_experts_group.generic.logging.LevelLogger
import java.lang.classfile.ClassFile

object V1X0X0MinecraftImplementations : MinecraftImplementations() {
	override val logger: LevelLogger<BSLLogMessage> = LevelLogger("V1x0x0 Impl")
	override val supportedFeatures: SupportedMCFeatures = mutableMapOf(
		MinecraftFeatures.BLOCK to mutableListOf(MinecraftBlockFeature1x0x0())
	)

	override fun preload(): List<String> = listOf(
		NativeConstantsV1x0x0.net_minecraft_GuiMainMenu
	)

	override fun start(scanning: Scanning, classFile: ClassFile) {
		val asList = mods.flatMap { it.value }
		val holder = ModTransformHolder()
		holder.gatherTransforms(asList)
		BlockTransform(scanning, classFile).addTransform(holder)
		ContainerCreativeTransform(scanning, classFile).addTransform(holder)
		EntityPlayerTransform(scanning, classFile).addTransform(holder)
		EntityPlayerSPTransform(scanning, classFile).addTransform(holder)

		// LWJGL3ify
		// todo holy crap the amount of work that needs to go into this is astounding
		GuiMainMenuTransform_LWJGL3(scanning, classFile).addTransform(holder)
		GuiScreenTransform_LWJGL3(scanning, classFile).addTransform(holder)
		EntityRendererTransform_LWJGL3(scanning, classFile).addTransform(holder)
		MinecraftTransform_LWJGL3(scanning, classFile).addTransform(holder)
		OpenGlHelperTransform_LWJGL3(scanning, classFile).addTransform(holder)
		TesselatorTransform_LWJGL3(scanning, classFile).addTransform(holder)
		OpenGlCapsCheckerTransform_LWJGL3(scanning, classFile).addTransform(holder)
	}

	@Suppress("unused")
	@JvmStatic
	fun registerBlocks() {
		for ((_, modGroup) in mods) for (mod in modGroup) mod.addBlocks(
			this.get(MinecraftFeatures.BLOCK)
		)
	}
}