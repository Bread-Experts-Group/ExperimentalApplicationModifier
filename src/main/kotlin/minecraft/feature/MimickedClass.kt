package org.bread_experts_group.eam.minecraft.feature

abstract class MimickedClass(val around: Any) {
	override fun equals(other: Any?): Boolean = around == other
	override fun hashCode(): Int = around.hashCode()
	override fun toString(): String = around.toString()
}