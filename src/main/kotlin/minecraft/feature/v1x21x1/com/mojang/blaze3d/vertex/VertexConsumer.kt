package org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.blaze3d.vertex

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com_mojang_blaze3d_vertex_VertexConsumer
import java.lang.constant.ClassDesc

/*
com.mojang.blaze3d.vertex.VertexConsumer -> fbm:
# {"fileName":"VertexConsumer.java","id":"sourceFile"}
    com.mojang.blaze3d.vertex.VertexConsumer addVertex(float,float,float) -> a
    com.mojang.blaze3d.vertex.VertexConsumer setColor(int,int,int,int) -> a
    com.mojang.blaze3d.vertex.VertexConsumer setUv(float,float) -> a
    com.mojang.blaze3d.vertex.VertexConsumer setUv1(int,int) -> a
    com.mojang.blaze3d.vertex.VertexConsumer setUv2(int,int) -> b
    com.mojang.blaze3d.vertex.VertexConsumer setNormal(float,float,float) -> b
    28:34:void addVertex(float,float,float,int,float,float,int,int,float,float,float) -> a
    37:37:com.mojang.blaze3d.vertex.VertexConsumer setColor(float,float,float,float) -> a
    41:41:com.mojang.blaze3d.vertex.VertexConsumer setColor(int) -> a
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
	companion object {
		val clazz: Class<*> = loadClass(com_mojang_blaze3d_vertex_VertexConsumer)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
}