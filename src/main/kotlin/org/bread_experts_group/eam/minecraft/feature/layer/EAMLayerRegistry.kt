package org.bread_experts_group.eam.minecraft.feature.layer

import org.bread_experts_group.eam.minecraft.feature.EAMRegistry
import org.bread_experts_group.eam.minecraft.feature.Identifier

class EAMLayerRegistry(namespace: String) : EAMRegistry<MinecraftLayer>(namespace) {
	fun registerLayer(identifier: Identifier, layer: MinecraftLayer): MinecraftLayer =
		this.add(identifier, layer)

	fun registerLayer(id: String, layer: MinecraftLayer): MinecraftLayer =
		this.add(id, layer)
}