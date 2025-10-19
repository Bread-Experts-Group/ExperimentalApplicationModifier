package org.bread_experts_group.eam.minecraft.feature.layer

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.api.ImplementationSource
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.Identifier

abstract class MinecraftLayerFeature : MinecraftFeatureImplementation<MinecraftLayer, MinecraftLayerFeature>() {
	override val source: ImplementationSource = ImplementationSource.JVM_NATIVE
	override val expresses: FeatureExpression<MinecraftLayerFeature> = MinecraftFeatures.LAYER

	override fun add(
		id: Identifier,
		value: MinecraftLayer
	): MinecraftLayer {
		EAMRegistries.LAYERS.registerLayer(id, value)
		return register(id, value)
	}
}