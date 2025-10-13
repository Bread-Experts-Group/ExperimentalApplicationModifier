package org.bread_experts_group.eam.minecraft.feature

import java.lang.constant.ClassDesc

abstract class MimickedClass(@JvmField val around: Any) {
	companion object {
		val classDesc: ClassDesc = ClassDesc.of(MimickedClass::class.qualifiedName)
	}

	override fun equals(other: Any?): Boolean = around == other
	override fun hashCode(): Int = around.hashCode()
	override fun toString(): String = around.toString()
}