package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature

abstract class MinecraftMod {
	abstract fun addBlocks(blocks: MinecraftBlockFeature)
}