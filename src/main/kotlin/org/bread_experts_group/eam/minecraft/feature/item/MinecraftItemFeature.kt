package org.bread_experts_group.eam.minecraft.feature.item

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.Identifier

abstract class MinecraftItemFeature : MinecraftFeatureImplementation<MinecraftItemFeature>() {
	override val expresses: FeatureExpression<MinecraftItemFeature> = MinecraftFeatures.ITEM

	fun add(
		id: Identifier,
		item: MinecraftItem
	): MinecraftItem {
		EAMRegistries.ITEMS.registerItem(id, item)
		return register(id, item)
	}

	protected abstract fun register(
		id: Identifier,
		item: MinecraftItem
	): MinecraftItem
}