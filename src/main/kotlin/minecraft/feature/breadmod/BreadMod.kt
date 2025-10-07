package org.bread_experts_group.eam.minecraft.feature.breadmod

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature

class BreadMod : MinecraftMod() {
	override fun addBlocks(blocks: MinecraftBlockFeature) {
		blocks.add(Identifier("breadmod", "bread_block"), MinecraftBlock())
	}
}