package org.bread_experts_group.eam.minecraft.feature.block

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.BlockPos
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.BlockState

interface MinecraftEntityBlock {
	fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity
}