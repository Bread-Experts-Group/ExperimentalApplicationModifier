package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_world_level_block_EntityBlock
import java.lang.constant.ClassDesc

/*
net.minecraft.world.level.block.EntityBlock -> diq:
# {"fileName":"EntityBlock.java","id":"sourceFile"}
    net.minecraft.world.level.block.entity.BlockEntity newBlockEntity(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    20:20:net.minecraft.world.level.block.entity.BlockEntityTicker getTicker(net.minecraft.world.level.Level,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.entity.BlockEntityType) -> a
    25:29:net.minecraft.world.level.gameevent.GameEventListener getListener(net.minecraft.server.level.ServerLevel,net.minecraft.world.level.block.entity.BlockEntity) -> a
 */
class EntityBlock(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_level_block_EntityBlock)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = EntityBlock::class.classDesc
	}
}