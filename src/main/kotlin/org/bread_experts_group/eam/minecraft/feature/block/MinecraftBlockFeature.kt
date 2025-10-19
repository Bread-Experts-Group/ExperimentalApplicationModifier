package org.bread_experts_group.eam.minecraft.feature.block

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.api.ImplementationSource
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.Identifier

abstract class MinecraftBlockFeature : MinecraftFeatureImplementation<MinecraftBlock, MinecraftBlockFeature>() {
	override val source: ImplementationSource = ImplementationSource.JVM_NATIVE
	override val expresses: FeatureExpression<MinecraftBlockFeature> = MinecraftFeatures.BLOCK

	override fun add(
		id: Identifier,
		value: MinecraftBlock
	): MinecraftBlock {
		EAMRegistries.BLOCKS.registerBlock(id, value)
		return register(id, value)
	}
}