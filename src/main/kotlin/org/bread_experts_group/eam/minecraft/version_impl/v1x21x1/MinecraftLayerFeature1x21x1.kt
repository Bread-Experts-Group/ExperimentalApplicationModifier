package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayer
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayerFeature
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms.LayerFeatureTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.LayeredDraw

class MinecraftLayerFeature1x21x1 : MinecraftLayerFeature() {
	override fun getTransformer(input: MinecraftLayer): LayerFeatureTransform = LayerFeatureTransform(input)

	override fun register(id: Identifier, value: MinecraftLayer): MinecraftLayer {
		val drawLayer = LayeredDraw.Layer(getTransformer(value).build())
		V1x21x1Implementations.drawLayers.add(drawLayer)
		return value
	}
}