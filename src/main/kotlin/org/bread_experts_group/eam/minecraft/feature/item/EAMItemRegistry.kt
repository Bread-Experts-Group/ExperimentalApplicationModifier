package org.bread_experts_group.eam.minecraft.feature.item

import org.bread_experts_group.eam.minecraft.feature.EAMRegistry
import org.bread_experts_group.eam.minecraft.feature.Identifier

class EAMItemRegistry(namespace: String) : EAMRegistry<MinecraftItem>(namespace) {
	fun registerItem(identifier: Identifier, item: MinecraftItem): MinecraftItem =
		this.add(identifier, item)

	fun registerItem(id: String, item: MinecraftItem): MinecraftItem =
		this.add(id, item)
}