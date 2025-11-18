package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTabFeature
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayerFeature

abstract class MinecraftMod(val id: String) {
	abstract fun addBlocks(blocks: MinecraftBlockFeature)
	abstract fun addItems(items: MinecraftItemFeature)
	abstract fun addLayers(layers: MinecraftLayerFeature)
	abstract fun addCreativeTabs(tabs: MinecraftCreativeTabFeature)
	open fun registerEvents() {}
}