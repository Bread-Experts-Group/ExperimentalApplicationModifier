package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.eam.minecraft.feature.MinecraftBlockFeature

object MinecraftFeatures {
	val BLOCK: FeatureExpression<MinecraftBlockFeature> = object : FeatureExpression<MinecraftBlockFeature> {
		override val name: String = "Block Support"
	}
}