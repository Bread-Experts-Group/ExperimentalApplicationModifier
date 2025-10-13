package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.state

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_level_block_state_BlockState

class BlockState(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_world_level_block_state_BlockState
		)
	}
}