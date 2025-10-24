package org.bread_experts_group.eam.minecraft.feature.event.listeners

import org.bread_experts_group.eam.minecraft.feature.event.EventSystem

abstract class MouseEvent<T> : EventSystem.Event<T>() {

	class Pre : MouseEvent<(Int, Int, Int) -> Boolean>() {
		fun post(button: Int, action: Int, modifiers: Int): Boolean {
			var flag = false
			this.listeners.forEach { flag = it.invoke(button, action, modifiers) }
			return flag
		}
	}

	class Post: MouseEvent<(Int, Int, Int) -> Unit>() {
		fun post(button: Int, action: Int, modifiers: Int) {
			this.listeners.forEach { it.invoke(button, action, modifiers) }
		}
	}
}