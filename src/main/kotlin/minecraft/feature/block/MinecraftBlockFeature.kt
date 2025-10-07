package org.bread_experts_group.eam.minecraft.feature.block

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.Identifier

abstract class MinecraftBlockFeature : MinecraftFeatureImplementation<MinecraftBlockFeature>() {
	override val expresses: FeatureExpression<MinecraftBlockFeature> = MinecraftFeatures.BLOCK

	fun add(
		id: Identifier,
		block: MinecraftBlock
	): MinecraftBlock {
		EAMRegistries.blocks.add(id, block)
		return register(id, block)
	}

	protected abstract fun register(
		id: Identifier,
		block: MinecraftBlock
	): MinecraftBlock
}