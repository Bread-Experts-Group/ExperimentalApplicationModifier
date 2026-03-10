package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.eam_impls

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.components.AbstractWidget
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.generic.bslBuildDate
import org.bread_experts_group.generic.bslVersion
import java.awt.Color

class BSLTextWidget(y: Int) : AbstractWidget(
	2,
	y,
	Minecraft.getInstance().font.width("BSL ${bslVersion()}"),
	10,
	Component.empty()
) {
	override fun renderWidget(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
		val font = Minecraft.getInstance().font
		guiGraphics.drawString(font, "BSL ${bslVersion()}", getX(), getY(), Color.ORANGE.rgb)
		if (
			mouseX > getX() && mouseX < getX() + getWidth() &&
			mouseY > getY() && mouseY < getY() + getHeight()
		) guiGraphics.renderTooltip(font, Component.literal(bslBuildDate()), mouseX, mouseY)
	}
}