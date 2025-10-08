package org.bread_experts_group.eam.minecraft.feature.item

import java.lang.constant.ClassDesc

open class MinecraftItem {
	companion object {
		val mimicClassDesc: ClassDesc = ClassDesc.of(MinecraftItem::class.java.name)
	}

	open fun inventoryTick() {}
}