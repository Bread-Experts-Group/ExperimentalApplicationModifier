package org.bread_experts_group.eam.minecraft.feature.breadmod

import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.MinecraftProvider
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod

class BreadMod : MinecraftMod() {
	init {
		val blocks = MinecraftProvider.get(MinecraftFeatures.BLOCK)
		println(blocks)
	}
}