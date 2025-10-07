package org.bread_experts_group.eam.minecraft.feature.block

import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation

abstract class MinecraftBlockFeature : MinecraftFeatureImplementation<MinecraftBlockFeature>() {
	abstract fun register(
		id: String,
		block: MinecraftBlock
	): MinecraftBlock
}