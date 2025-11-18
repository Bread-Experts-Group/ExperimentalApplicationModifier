package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTab
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTabFeature
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms.CreativeTabTransform

class MinecraftCreativeTabFeature1x21x1 : MinecraftCreativeTabFeature() {
	override fun getTransformer(input: MinecraftCreativeTab): CreativeTabTransform = CreativeTabTransform(input)

	override fun register(
		id: Identifier,
		value: MinecraftCreativeTab
	): MinecraftCreativeTab {
		return value
	}
}