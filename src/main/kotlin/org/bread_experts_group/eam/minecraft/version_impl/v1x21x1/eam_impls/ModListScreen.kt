package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.eam_impls

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.components.Button
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.Screen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component

// todo the actual mod list screen
class ModListScreen : Screen(Component.literal("mods")) {
	companion object {
		@JvmStatic
		@Suppress("unused")
		fun makeTitleScreenButton(x: Int, y: Int, rowHeight: Int): Button = Button.builder(
			Component.literal("Mods")
		) { button ->

		}.bounds(x / 2 - 100, y + rowHeight * 2, 200, 20).build()
	}
}