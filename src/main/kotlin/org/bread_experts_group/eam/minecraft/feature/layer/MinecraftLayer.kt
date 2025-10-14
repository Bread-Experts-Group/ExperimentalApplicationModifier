package org.bread_experts_group.eam.minecraft.feature.layer

import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.GuiGraphics
import java.lang.constant.ClassDesc

abstract class MinecraftLayer {
	companion object {
		val mimicClassDesc: ClassDesc = ClassDesc.of(MinecraftLayer::class.java.name)
	}

	// todo 1.21 class...
	abstract fun render(
		guiGraphics: GuiGraphics,
		deltaTracker: DeltaTracker
	)
}