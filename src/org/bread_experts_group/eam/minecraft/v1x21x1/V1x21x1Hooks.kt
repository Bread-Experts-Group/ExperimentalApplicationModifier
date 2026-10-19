package org.bread_experts_group.eam.minecraft.v1x21x1

@Suppress("unused", "FunctionName")
object V1x21x1Hooks {
    @JvmStatic
    fun minecraft_setTitleScreen(self: Any) {
        val minecraft = Minecraft(self)
        minecraft.callMethod("setScreen")
        minecraft.callMethod("getWindow")
    }
}