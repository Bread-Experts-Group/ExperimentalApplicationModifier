package org.bread_experts_group.eam.minecraft.feature.layer

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.Identifier

abstract class MinecraftLayerFeature : MinecraftFeatureImplementation<MinecraftLayerFeature>() {
	override val expresses: FeatureExpression<MinecraftLayerFeature> = MinecraftFeatures.LAYER

	fun add(
		id: Identifier,
		layer: MinecraftLayer
	): MinecraftLayer {
		EAMRegistries.layers.add(id, layer)
		return register(id, layer)
	}

	protected abstract fun register(
		id: Identifier,
		layer: MinecraftLayer
	): MinecraftLayer
}