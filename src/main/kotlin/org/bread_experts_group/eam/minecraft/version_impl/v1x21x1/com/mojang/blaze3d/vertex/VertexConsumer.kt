package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com_mojang_blaze3d_vertex_VertexConsumer
import java.lang.constant.ClassDesc

/*
com.mojang.blaze3d.vertex.VertexConsumer -> fbm:
    45:45:com.mojang.blaze3d.vertex.VertexConsumer setWhiteAlpha(int) -> d
    49:49:com.mojang.blaze3d.vertex.VertexConsumer setLight(int) -> c
    53:53:com.mojang.blaze3d.vertex.VertexConsumer setOverlay(int) -> b
    57:58:void putBulkData(com.mojang.blaze3d.vertex.PoseStack$Pose,net.minecraft.client.renderer.block.model.BakedQuad,float,float,float,float,int,int) -> a
    64:114:void putBulkData(com.mojang.blaze3d.vertex.PoseStack$Pose,net.minecraft.client.renderer.block.model.BakedQuad,float[],float,float,float,float,int[],int,boolean) -> a
    117:117:com.mojang.blaze3d.vertex.VertexConsumer addVertex(org.joml.Vector3f) -> a
    121:121:com.mojang.blaze3d.vertex.VertexConsumer addVertex(com.mojang.blaze3d.vertex.PoseStack$Pose,org.joml.Vector3f) -> a
    125:125:com.mojang.blaze3d.vertex.VertexConsumer addVertex(com.mojang.blaze3d.vertex.PoseStack$Pose,float,float,float) -> a
    129:130:com.mojang.blaze3d.vertex.VertexConsumer addVertex(org.joml.Matrix4f,float,float,float) -> a
    134:135:com.mojang.blaze3d.vertex.VertexConsumer setNormal(com.mojang.blaze3d.vertex.PoseStack$Pose,float,float,float) -> b
 */
class VertexConsumer(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_blaze3d_vertex_VertexConsumer)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = VertexConsumer::class.classDesc
	}

	fun addVertex(x: Float, y: Float, z: Float): VertexConsumer = VertexConsumer(
		clazz.getMethod("a", Float::class.java, Float::class.java, Float::class.java)
			.invoke(around, x, y, z)
	)

	fun setColor(red: Int, green: Int, blue: Int, alpha: Int): VertexConsumer = VertexConsumer(
		clazz.getMethod("a", Int::class.java, Int::class.java, Int::class.java, Int::class.java)
			.invoke(around, red, green, blue, alpha)
	)

	fun setUv(u: Float, v: Float): VertexConsumer = VertexConsumer(
		clazz.getMethod("a", Float::class.java, Float::class.java)
			.invoke(around, u, v)
	)

	fun setUv1(u: Int, v: Int): VertexConsumer = VertexConsumer(
		clazz.getMethod("a", Int::class.java, Int::class.java)
			.invoke(around, u, v)
	)

	fun setUv2(u: Int, v: Int): VertexConsumer = VertexConsumer(
		clazz.getMethod("b", Int::class.java, Int::class.java)
			.invoke(around, u, v)
	)

	fun setNormal(normalX: Float, normalY: Float, normalZ: Float): VertexConsumer = VertexConsumer(
		clazz.getMethod("b", Float::class.java, Float::class.java, Float::class.java)
			.invoke(around, normalX, normalY, normalZ)
	)

	fun addVertex(
		x: Float,
		y: Float,
		z: Float,
		color: Int,
		u: Float,
		v: Float,
		packedOverlay: Int,
		packedLight: Int,
		normalX: Float,
		normalY: Float,
		normalZ: Float
	) {
		clazz.getMethod("a",
			Float::class.java,
			Float::class.java,
			Float::class.java,
			Int::class.java,
			Float::class.java,
			Float::class.java,
			Int::class.java,
			Int::class.java,
			Float::class.java,
			Float::class.java,
			Float::class.java
		).invoke(around, x, y, z, color, u, v, packedOverlay, packedLight, normalX, normalY, normalZ)
	}

	fun setColor(red: Float, green: Float, blue: Float, alpha: Float): VertexConsumer = VertexConsumer(
		clazz.getMethod("a", Float::class.java, Float::class.java, Float::class.java, Float::class.java)
			.invoke(around, red, green, blue, alpha)
	)

	fun setColor(color: Int): VertexConsumer = VertexConsumer(
		clazz.getMethod("a", Int::class.java)
			.invoke(around, color)
	)

	fun setLight(packedLight: Int): VertexConsumer = VertexConsumer(
		clazz.getMethod("c", Int::class.java)
			.invoke(around, packedLight)
	)
}