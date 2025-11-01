package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTab
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItem
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayer
import java.lang.constant.ClassDesc

// todo need to figure out a "base" variant of blocks, items, and classes used in their methods (inventoryTick, useOn, etc)
//  to be shared among all mc versions so we don't have a million duplicates
//  (which would also allow us to finally put the registered content into static fields to be used in impls)
object EAMRegistries {
	val classDesc: ClassDesc = ClassDesc.of(this::class.qualifiedName)

	@JvmField
	val BLOCKS: EAMRegistry<MinecraftBlock> = EAMRegistry()

	@JvmField
	val ITEMS: EAMRegistry<MinecraftItem> = EAMRegistry()

	@JvmField
	val LAYERS: EAMRegistry<MinecraftLayer> = EAMRegistry()

	@JvmField
	val CREATIVE_TABS: EAMRegistry<MinecraftCreativeTab> = EAMRegistry()
}