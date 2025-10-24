package org.bread_experts_group.eam.minecraft.feature.event

import org.bread_experts_group.eam.minecraft.feature.event.listeners.MouseEvent

object EventSystem {
	open class Event<T>(val listeners: MutableSet<T> = mutableSetOf())

	@JvmField
	val MOUSE_INPUT_PRE: MouseEvent.Pre = MouseEvent.Pre()
	@JvmField
	val MOUSE_INPUT_POST: MouseEvent.Post = MouseEvent.Post()

	fun <T> addListener(event: Event<T>, lambda: T) = event.listeners.add(lambda)
}