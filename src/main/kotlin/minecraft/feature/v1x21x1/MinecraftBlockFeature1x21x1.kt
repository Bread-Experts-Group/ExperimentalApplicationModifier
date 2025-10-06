package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.api.ImplementationSource
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.MinecraftBlockFeature

class MinecraftBlockFeature1x21x1 : MinecraftBlockFeature() {
	override val source: ImplementationSource = ImplementationSource.JVM_NATIVE
	override val expresses: FeatureExpression<MinecraftBlockFeature> = MinecraftFeatures.BLOCK
}