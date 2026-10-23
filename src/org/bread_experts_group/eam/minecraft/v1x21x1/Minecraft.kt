package org.bread_experts_group.eam.minecraft.v1x21x1

class Minecraft(original: Any): MimickedClass(original) {
    companion object {
        fun getInstance(): Minecraft = Minecraft(callStaticMethod(Minecraft::class, "getInstance")!!)
    }

    fun getWindow(): Window = Window(callMethod("getWindow")!!)
}