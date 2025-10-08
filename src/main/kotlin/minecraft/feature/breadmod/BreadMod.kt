package org.bread_experts_group.eam.minecraft.feature.breadmod

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItem
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.entity.Entity
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.Level

class BreadMod : MinecraftMod() {
	override fun addBlocks(blocks: MinecraftBlockFeature) {
		blocks.add(Identifier("breadmod", "bread_block"), MinecraftBlock())
	}

	override fun addItems(items: MinecraftItemFeature) {
		items.add(Identifier("breadmod", "bread_2"), MinecraftItem())
		items.add(Identifier("breadmod", "bread_3"), object : MinecraftItem() {
			override fun inventoryTick(stack: ItemStack, level: Level, entity: Entity, slot: Int, beingHeld: Boolean) {
				println("Bread_3: $stack, $level, $entity, $slot, $beingHeld")
			}
		})
	}
}