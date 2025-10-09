package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItem
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayer
import java.lang.constant.ClassDesc

object EAMRegistries {
	val classDesc: ClassDesc = ClassDesc.of(this::class.qualifiedName)

	@JvmField
	val blocks: EAMRegistry<MinecraftBlock> = EAMRegistry()

	@JvmField
	val items: EAMRegistry<MinecraftItem> = EAMRegistry()

	@JvmField
	val layers: EAMRegistry<MinecraftLayer> = EAMRegistry()
}