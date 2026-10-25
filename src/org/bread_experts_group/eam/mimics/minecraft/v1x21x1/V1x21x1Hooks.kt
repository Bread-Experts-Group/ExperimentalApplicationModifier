package org.bread_experts_group.eam.mimics.minecraft.v1x21x1

import org.bread_experts_group.eam.Color

@Suppress("unused", "FunctionName")
object V1x21x1Hooks {
    @JvmStatic
    fun minecraft_setTitleScreen(self: Any) {
        val minecraft = Minecraft(self)
        minecraft.getWindow().setTitle("Minecraft EAM - 1.21.1")
    }

    @JvmStatic
    fun titleScreen_renderText(guiGraphics: GuiGraphics, width: Int, height: Int, mouseX: Int, mouseY: Int) {
        val font = Minecraft.getInstance().font
        guiGraphics.drawString(font, "EAM Rewrite", 2, height - 30, Color.WHITE)
    }
}