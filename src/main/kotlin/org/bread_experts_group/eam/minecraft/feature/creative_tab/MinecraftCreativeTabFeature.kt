package org.bread_experts_group.eam.minecraft.feature.creative_tab

import org.bread_experts_group.api.feature.FeatureExpression
import org.bread_experts_group.api.feature.ImplementationSource
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.Identifier

abstract class MinecraftCreativeTabFeature : MinecraftFeatureImplementation<MinecraftCreativeTab, MinecraftCreativeTabFeature>() {
	override val source: ImplementationSource = ImplementationSource.JVM_NATIVE
	override val expresses: FeatureExpression<MinecraftCreativeTabFeature> = MinecraftFeatures.CREATIVE_TAB

	override fun add(
		id: Identifier,
		value: MinecraftCreativeTab
	): MinecraftCreativeTab {
		// this only exists cause the injection point is called multiple times in native code
		if (EAMRegistries.CREATIVE_TABS.hasElement(id)) return value
		EAMRegistries.CREATIVE_TABS.add(id, value)
		return register(id, value)
	}
}