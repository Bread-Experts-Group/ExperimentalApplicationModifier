package org.bread_experts_group.eam.minecraft.feature.breadmod

import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.MinecraftProvider
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock

class BreadMod : MinecraftMod() {
	override fun registerObjects() {
		val blocks = MinecraftProvider.get(MinecraftFeatures.BLOCK)
		repeat(1000) {
			blocks.register("breadmod:block_$it", MinecraftBlock())
		}
	}
}