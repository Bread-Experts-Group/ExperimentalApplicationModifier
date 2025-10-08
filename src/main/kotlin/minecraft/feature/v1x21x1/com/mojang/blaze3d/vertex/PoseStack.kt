package org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.blaze3d.vertex

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com_mojang_blaze3d_vertex_PoseStack
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com_mojang_blaze3d_vertex_PoseStack_Pose
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.org.joml.Quaternionf

/*
com.mojang.blaze3d.vertex.PoseStack -> fbi:
# {"fileName":"PoseStack.java","id":"sourceFile"}
    java.util.Deque poseStack -> a
    66:66:com.mojang.blaze3d.vertex.PoseStack$Pose last() -> c
    70:70:boolean clear() -> d
    74:78:void setIdentity() -> e
    81:91:void mulPose(org.joml.Matrix4f) -> a
    15:18:void lambda$new$0(java.util.ArrayDeque) -> a
*/
class PoseStack(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(com_mojang_blaze3d_vertex_PoseStack)
	}

	constructor() : this(clazz.getConstructor().newInstance())

	fun pushPose() {
		clazz.getMethod("a").invoke(around)
	}

	fun popPose() {
		clazz.getMethod("b").invoke(around)
	}

	fun translate(x: Float, y: Float, z: Float) {
		clazz.getMethod("a", Float::class.java, Float::class.java, Float::class.java)
			.invoke(around, x, y, z)
	}

	fun translate(x: Double, y: Double, z: Double) {
		clazz.getMethod("a", Double::class.java, Double::class.java, Double::class.java)
			.invoke(around, x, y, z)
	}

	fun scale(x: Float, y: Float, z: Float) {
		clazz.getMethod("b", Float::class.java, Float::class.java, Float::class.java)
			.invoke(around, x, y, z)
	}

	fun mulPose(rotation: Quaternionf) {
		clazz.getMethod("a", Quaternionf.clazz).invoke(around, rotation.around)
	}

	fun rotateAround(rotation: Quaternionf, x: Float, y: Float, z: Float) {
		clazz.getMethod("a", Quaternionf.clazz, Float::class.java, Float::class.java, Float::class.java)
			.invoke(around, rotation,around, x, y, z)
	}

	/*
	com.mojang.blaze3d.vertex.PoseStack$Pose -> fbi$a:
	# {"fileName":"PoseStack.java","id":"sourceFile"}
    org.joml.Matrix4f pose -> a
    org.joml.Matrix3f normal -> b
    boolean trustedNormals -> c
    97:102:void <init>(org.joml.Matrix4f,org.joml.Matrix3f) -> <init>
    97:108:void <init>(com.mojang.blaze3d.vertex.PoseStack$Pose) -> <init>
    111:113:void computeNormalMatrix() -> d
    116:116:org.joml.Matrix4f pose() -> a
    124:124:org.joml.Matrix3f normal() -> b
    128:128:org.joml.Vector3f transformNormal(org.joml.Vector3f,org.joml.Vector3f) -> a
    132:133:org.joml.Vector3f transformNormal(float,float,float,org.joml.Vector3f) -> a
    137:137:com.mojang.blaze3d.vertex.PoseStack$Pose copy() -> c
	*/
	class Pose(around: Any) : MimickedClass(around) {
		companion object {
			val clazz: Class<*> = loadClass(com_mojang_blaze3d_vertex_PoseStack_Pose)
		}


	}
}