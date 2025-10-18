package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_level_block_state_BlockState
import java.lang.constant.ClassDesc

class BlockState(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_level_block_state_BlockState)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockState::class.classDesc
	}
}