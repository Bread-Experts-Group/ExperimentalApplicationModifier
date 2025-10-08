package org.bread_experts_group.eam.minecraft.feature.breadmod

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItem
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature

class BreadMod : MinecraftMod() {
	override fun addBlocks(blocks: MinecraftBlockFeature) {
		blocks.add(Identifier("breadmod", "bread_block"), MinecraftBlock())
	}

	override fun addItems(items: MinecraftItemFeature) {
		items.add(Identifier("breadmod", "bread_2"), MinecraftItem())
		items.add(Identifier("breadmod", "bread_3"), object : MinecraftItem() {
			override fun inventoryTick() {
				println("Bread_3 $this tick")
			}
		})
	}
}