package org.bread_experts_group.eam.minecraft.feature.item

import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.entity.Entity
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.Level
import java.lang.constant.ClassDesc

open class MinecraftItem {
	companion object {
		val mimicClassDesc: ClassDesc = ClassDesc.of(MinecraftItem::class.java.name)
	}

	open fun inventoryTick(
		stack: ItemStack,
		level: Level,
		entity: Entity,
		slot: Int,
		beingHeld: Boolean
	) {
	}
}