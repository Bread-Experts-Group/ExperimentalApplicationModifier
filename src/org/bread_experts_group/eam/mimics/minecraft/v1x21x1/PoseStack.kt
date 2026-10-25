package org.bread_experts_group.eam.mimics.minecraft.v1x21x1

import org.bread_experts_group.eam.mimics.joml.Quaternionf
import org.bread_experts_group.eamlaunch.api.Mapping

class PoseStack(original: Any): MimickedClass(original) {
    constructor(): this(Mapping.of(PoseStack::class).getConstructor().newInstance())

    fun pushPose() { callMethod("pushPose",) }
    fun popPose() { callMethod("popPose",) }

    fun translate(x: Float, y: Float, z: Float) {
        callMethod("translate", z)
    }

    fun translate(x: Double, y: Double, z: Double) {
        callMethod("translate", z)
    }

    fun scale(x: Float, y: Float, z: Float) {
        callMethod("scale", z)
    }

    fun mulPose(rotation: Quaternionf) {
        callMethod("mulPose", rotation)
    }

    fun rotateAround(rotation: Quaternionf, x: Float, y: Float, z: Float) {
        callMethod(
            "rotateAround",
            z
        )
    }

    fun last(): Pose = Pose(callMethod("last",)!!)

    class Pose(original: Any): MimickedClass(original)
}