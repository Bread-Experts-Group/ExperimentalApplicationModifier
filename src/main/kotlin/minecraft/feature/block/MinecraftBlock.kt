package org.bread_experts_group.eam.minecraft.feature.block

import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import java.lang.constant.ClassDesc

class MinecraftBlock() {
	companion object {
		val classDesc: ClassDesc = ClassDesc.of(MinecraftBlock::class.qualifiedName)
	}

	@JvmField
	var mimic: MimickedClass? = null
}