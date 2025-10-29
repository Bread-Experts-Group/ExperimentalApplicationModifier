package org.bread_experts_group.eam.minecraft.feature.event.listeners

import org.bread_experts_group.eam.minecraft.feature.event.CancellableEvent
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.MouseHandler

abstract class MouseEvent<T> : EventSystem.Event<T>() {
	class ButtonPre : MouseEvent<(ButtonPre, Int, Int, Int) -> Unit>(), CancellableEvent {
		fun post(button: Int, action: Int, modifiers: Int): Boolean {
			this.listeners.forEach { it.invoke(this, button, action, modifiers) }
			return this.getCanceledAndReset()
		}
	}

	class ButtonPost : MouseEvent<(ButtonPost, Int, Int, Int) -> Unit>() {
		fun post(button: Int, action: Int, modifiers: Int) {
			this.listeners.forEach { it.invoke(this, button, action, modifiers) }
		}
	}

	class Scroll : MouseEvent<(Scroll, MouseHandler, Double, Double) -> Unit>(), CancellableEvent {
		fun post(mouseHandler: MouseHandler, xOffset: Double, yOffset: Double): Boolean {
			this.listeners.forEach { it.invoke(this, mouseHandler, xOffset, yOffset) }
			return this.getCanceledAndReset()
		}
	}
}