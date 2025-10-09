package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayerFeature

abstract class MinecraftMod {
	abstract fun addBlocks(blocks: MinecraftBlockFeature)
	abstract fun addItems(items: MinecraftItemFeature)
	abstract fun addLayers(layers: MinecraftLayerFeature)
}