package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature

object MinecraftFeatures {
	val BLOCK: FeatureExpression<MinecraftBlockFeature> = object : FeatureExpression<MinecraftBlockFeature> {
		override val name: String = "Block Support"
	}

	val ITEM: FeatureExpression<MinecraftItemFeature> = object : FeatureExpression<MinecraftItemFeature> {
		override val name: String = "Item Support"
	}
}