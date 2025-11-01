package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTab
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTabFeature

class MinecraftCreativeTabFeature1x21x1 : MinecraftCreativeTabFeature() {
	override fun register(
		id: Identifier,
		value: MinecraftCreativeTab
	): MinecraftCreativeTab = value
}