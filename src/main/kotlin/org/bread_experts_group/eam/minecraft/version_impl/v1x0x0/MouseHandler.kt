package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0

import kotlin.math.roundToInt

@Suppress("unused")
class MouseHandler {
	@JvmField
	var currentWindow: Long = 0

	@JvmField
	var cursorX: Double = 0.0

	@JvmField
	var cursorY: Double = 0.0

	fun setCurrentWindow(id: Long) {
		if (currentWindow == 0L) currentWindow = id
	}

	fun cursorXAsInt(): Int = cursorX.roundToInt()
	fun cursorYAsInt(): Int = cursorY.roundToInt()
}