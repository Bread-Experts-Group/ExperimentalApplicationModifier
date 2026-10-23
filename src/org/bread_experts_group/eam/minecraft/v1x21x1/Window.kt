package org.bread_experts_group.eam.minecraft.v1x21x1

class Window(original: Any): MimickedClass(original) {
    fun setTitle(title: String) {
        this.callMethod("setTitle", listOf(String::class), title)
    }
}