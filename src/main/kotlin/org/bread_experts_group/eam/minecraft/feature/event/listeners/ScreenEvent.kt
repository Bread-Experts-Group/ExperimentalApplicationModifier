package org.bread_experts_group.eam.minecraft.feature.event.listeners

import org.bread_experts_group.eam.minecraft.feature.event.CancellableEvent
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.Screen

// todo screen scrolling and dragging
abstract class ScreenEvent<T> : EventSystem.Event<T>() {
	class MouseButtonPressedPre : ScreenEvent<(Screen, Double, Double, Int) -> Unit>(), CancellableEvent {
		fun post(screen: Screen, mouseX: Double, mouseY: Double, button: Int): Boolean {
			this.listeners.forEach { it.invoke(screen, mouseX, mouseY, button)  }
			return this.getCanceledAndReset()
		}
	}

	class MouseButtonPressedPost : ScreenEvent<(Screen, Double, Double, Int) -> Unit>() {
		fun post(screen: Screen, mouseX: Double, mouseY: Double, button: Int) {
			this.listeners.forEach { it.invoke(screen, mouseX, mouseY, button) }
		}
	}

	class MouseButtonReleasedPre : ScreenEvent<(Screen, Double, Double, Int) -> Unit>(), CancellableEvent {
		fun post(screen: Screen, mouseX: Double, mouseY: Double, button: Int): Boolean {
			this.listeners.forEach { it.invoke(screen, mouseX, mouseY, button)  }
			return this.getCanceledAndReset()
		}
	}

	class MouseButtonReleasedPost : ScreenEvent<(Screen, Double, Double, Int) -> Unit>() {
		fun post(screen: Screen, mouseX: Double, mouseY: Double, button: Int) {
			this.listeners.forEach { it.invoke(screen, mouseX, mouseY, button) }
		}
	}

	class MouseScrolledPre : ScreenEvent<(MouseHandler, Screen, Double, Double) -> Unit>(), CancellableEvent {
		fun post(mouseHandler: MouseHandler, screen: Screen, scrollDeltaX: Double, scrollDeltaY: Double): Boolean {
			this.listeners.forEach { it.invoke(mouseHandler, screen, scrollDeltaX, scrollDeltaY) }
			return this.getCanceledAndReset()
		}
	}

	class MouseScrolledPost : ScreenEvent<(MouseHandler, Screen, Double, Double) -> Unit>() {
		fun post(mouseHandler: MouseHandler, screen: Screen, scrollDeltaX: Double, scrollDeltaY: Double) {
			this.listeners.forEach { it.invoke(mouseHandler, screen, scrollDeltaX, scrollDeltaY) }
		}
	}

	class MouseDraggedPre : ScreenEvent<(Screen, Double, Double, Int, Double, Double) -> Unit>() {
		fun post(screen: Screen, mouseX: Double, mouseY: Double, mouseButton: Int, dragX: Double, dragY: Double): Boolean {
			this.listeners.forEach { it.invoke(screen, mouseX, mouseY, mouseButton, dragX, dragY) }
			return this.getCanceledAndReset()
		}
	}

	class MouseDraggedPost : ScreenEvent<(Screen, Double, Double, Int, Double, Double) -> Unit>() {
		fun post(screen: Screen, mouseX: Double, mouseY: Double, mouseButton: Int, dragX: Double, dragY: Double) {
			this.listeners.forEach { it.invoke(screen, mouseX, mouseY, mouseButton, dragX, dragY) }
		}
	}
}