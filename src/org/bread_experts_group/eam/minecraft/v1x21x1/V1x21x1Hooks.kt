package org.bread_experts_group.eam.minecraft.v1x21x1

@Suppress("unused", "FunctionName")
object V1x21x1Hooks {
    @JvmStatic
    fun minecraft_setTitleScreen(self: Any) {
//        println(self)
        val minecraft = Minecraft(self)
        minecraft.getWindow().setTitle("Minecraft EAM - 1.21.1")
    }
}