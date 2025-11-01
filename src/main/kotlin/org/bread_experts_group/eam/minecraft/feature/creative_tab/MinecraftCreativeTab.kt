package org.bread_experts_group.eam.minecraft.feature.creative_tab

import org.bread_experts_group.eam.minecraft.feature.base_mimics.AbstractResourceKey

/**
 * Holds the native creative tab and resource key needed to add it into mc.
 */
data class MinecraftCreativeTab(
	val nativeTab: AbstractCreativeTab,
	val nativeResourceKey: AbstractResourceKey
)