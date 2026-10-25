package org.bread_experts_group.eam.mimics.minecraft.v1x21x1

class Minecraft(original: Any): MimickedClass(original) {
    companion object {
        fun getInstance(): Minecraft = Minecraft(callStaticMethod(Minecraft::class, "getInstance")!!)

        val ON_OSX: Boolean
            get() = getStaticField(Minecraft::class, "ON_OSX") as Boolean
    }

    val font: Font
        get() = Font(getField("font")!!)

    fun getWindow(): Window = Window(callMethod("getWindow")!!)
}