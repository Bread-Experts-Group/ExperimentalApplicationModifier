package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTabFeature
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayerFeature

object MinecraftFeatures {
	val BLOCK: FeatureExpression<MinecraftBlockFeature> = object : FeatureExpression<MinecraftBlockFeature> {
		override val name: String = "Block Support"
	}

	val ITEM: FeatureExpression<MinecraftItemFeature> = object : FeatureExpression<MinecraftItemFeature> {
		override val name: String = "Item Support"
	}

	val LAYER: FeatureExpression<MinecraftLayerFeature> = object : FeatureExpression<MinecraftLayerFeature> {
		override val name: String = "Layer Support"
	}

	val CREATIVE_TAB: FeatureExpression<MinecraftCreativeTabFeature> = object : FeatureExpression<MinecraftCreativeTabFeature> {
		override val name: String = "Creative Tab Support"
	}
}