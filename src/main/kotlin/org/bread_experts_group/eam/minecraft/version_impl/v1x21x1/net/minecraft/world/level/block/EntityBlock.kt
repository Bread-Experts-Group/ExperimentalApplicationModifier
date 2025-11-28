package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block

import org.bread_experts_group.eam.minecraft.feature.MimickedClass

/*
net.minecraft.world.level.block.EntityBlock -> diq:
# {"fileName":"EntityBlock.java","id":"sourceFile"}
    net.minecraft.world.level.block.entity.BlockEntity newBlockEntity(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    20:20:net.minecraft.world.level.block.entity.BlockEntityTicker getTicker(net.minecraft.world.level.Level,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.entity.BlockEntityType) -> a
    25:29:net.minecraft.world.level.gameevent.GameEventListener getListener(net.minecraft.server.level.ServerLevel,net.minecraft.world.level.block.entity.BlockEntity) -> a
 */
class EntityBlock(around: Any) : MimickedClass(around) {
}