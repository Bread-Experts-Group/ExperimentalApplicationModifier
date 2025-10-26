package org.bread_experts_group.eam.minecraft.feature.event

import org.bread_experts_group.eam.minecraft.feature.event.listeners.MouseEvent
import org.bread_experts_group.eam.minecraft.feature.event.listeners.ScreenEvent
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.Screen
import kotlin.reflect.full.isSubclassOf

@Suppress("unused")
object EventSystem {
	open class Event<T>(val listeners: MutableSet<T> = mutableSetOf()) {
		private var isCanceled: Boolean = false

		fun setCanceled(canceled: Boolean) {
			if (this::class.isSubclassOf(CancellableEvent::class)) {
				isCanceled = canceled
			} else throw IllegalStateException("This event cannot be cancelled!")
		}

		fun getCanceled(): Boolean = this.isCanceled
	}

	// MouseEvent
	val MOUSE_BUTTON_PRE: MouseEvent.ButtonPre = MouseEvent.ButtonPre()
	val MOUSE_BUTTON_POST: MouseEvent.ButtonPost = MouseEvent.ButtonPost()
	val MOUSE_SCROLLED: MouseEvent.Scroll = MouseEvent.Scroll()
	// ScreenEvent
	val SCREEN_INPUT_PRESSED_PRE: ScreenEvent.MouseButtonPressedPre = ScreenEvent.MouseButtonPressedPre()
	val SCREEN_INPUT_PRESSED_POST: ScreenEvent.MouseButtonPressedPost = ScreenEvent.MouseButtonPressedPost()
	val SCREEN_INPUT_RELEASED_PRE: ScreenEvent.MouseButtonReleasedPre = ScreenEvent.MouseButtonReleasedPre()
	val SCREEN_INPUT_RELEASED_POST: ScreenEvent.MouseButtonReleasedPost = ScreenEvent.MouseButtonReleasedPost()
	val SCREEN_INPUT_SCROLL_PRE: ScreenEvent.MouseScrolledPre = ScreenEvent.MouseScrolledPre()

	fun <T> addListener(event: Event<T>, lambda: T) {
		event.listeners.add(lambda)
	}

	@JvmStatic
	fun handleMouseButtonPre(button: Int, action: Int, modifiers: Int): Boolean {
		return MOUSE_BUTTON_PRE.post(button, action, modifiers)
	}

	@JvmStatic
	fun handleMouseButtonPost(button: Int, action: Int, modifiers: Int) {
		MOUSE_BUTTON_POST.post(button, action, modifiers)
	}

	@JvmStatic
	fun handleMouseScroll(mouseHandler: MouseHandler, xOffset: Double, yOffset: Double): Boolean {
		return MOUSE_SCROLLED.post(mouseHandler, xOffset, yOffset)
	}

	@JvmStatic
	fun handleScreenMousePressedPre(screen: Screen, mouseX: Double, mouseY: Double, button: Int): Boolean {
		return SCREEN_INPUT_PRESSED_PRE.post(screen, mouseX, mouseY, button)
	}

	@JvmStatic
	fun handleScreenMousePressedPost(screen: Screen, mouseX: Double, mouseY: Double, button: Int) {
		SCREEN_INPUT_PRESSED_POST.post(screen, mouseX, mouseY, button)
	}

	@JvmStatic
	fun handleScreenMouseReleasedPre(screen: Screen, mouseX: Double, mouseY: Double, button: Int): Boolean {
		return SCREEN_INPUT_RELEASED_PRE.post(screen, mouseX, mouseY, button)
	}

	@JvmStatic
	fun handleScreenMouseReleasedPost(screen: Screen, mouseX: Double, mouseY: Double, button: Int) {
		SCREEN_INPUT_RELEASED_POST.post(screen, mouseX, mouseY, button)
	}

	@JvmStatic
	fun handleScreenMouseScrolledPre(
		mouseHandler: MouseHandler,
		screen: Screen,
		scrollDeltaX: Double,
		scrollDeltaY: Double
	): Boolean {
		return SCREEN_INPUT_SCROLL_PRE.post(mouseHandler, screen, scrollDeltaX, scrollDeltaY)
	}
}