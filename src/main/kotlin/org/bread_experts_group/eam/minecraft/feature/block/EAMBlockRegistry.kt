package org.bread_experts_group.eam.minecraft.feature.block

import org.bread_experts_group.eam.minecraft.feature.EAMRegistry
import org.bread_experts_group.eam.minecraft.feature.Identifier

class EAMBlockRegistry(namespace: String) : EAMRegistry<MinecraftBlock>(namespace) {
	fun registerBlock(identifier: Identifier, block: MinecraftBlock): MinecraftBlock =
		this.add(identifier, block)

	fun registerBlock(id: String, block: MinecraftBlock) =
		this.add(id, block)
}