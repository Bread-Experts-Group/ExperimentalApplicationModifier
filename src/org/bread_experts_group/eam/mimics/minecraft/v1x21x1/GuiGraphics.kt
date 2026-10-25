package org.bread_experts_group.eam.mimics.minecraft.v1x21x1

class GuiGraphics(original: Any) : MimickedClass(original) {
    fun drawString(font: Font, string: String, x: Int, y: Int, color: Int) {
        println("???")
        // todo not calling
        callMethod("drawString", font, string, x, y, color)
    }

    fun drawString(font: Font, string: String, x: Int, y: Int, color: Int, shadow: Boolean) {
        callMethod(
            "drawString",
            shadow
        )
    }
}