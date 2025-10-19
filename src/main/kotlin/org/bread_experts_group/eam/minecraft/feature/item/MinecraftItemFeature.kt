package org.bread_experts_group.eam.minecraft.feature.item

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.api.ImplementationSource
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.Identifier

// todo abstract item properties
abstract class MinecraftItemFeature : MinecraftFeatureImplementation<MinecraftItem, MinecraftItemFeature>() {
	override val source: ImplementationSource = ImplementationSource.JVM_NATIVE
	override val expresses: FeatureExpression<MinecraftItemFeature> = MinecraftFeatures.ITEM

	override fun add(
		id: Identifier,
		value: MinecraftItem
	): MinecraftItem {
		EAMRegistries.ITEMS.registerItem(id, value)
		return register(id, value)
	}
}