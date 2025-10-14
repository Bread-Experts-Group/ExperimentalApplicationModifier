package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.blaze3d.vertex.VertexConsumer
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_renderer_MultiBufferSource
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.MultiBufferSource -> gez:
# {"fileName":"MultiBufferSource.java","id":"sourceFile"}
    17:17:net.minecraft.client.renderer.MultiBufferSource$BufferSource immediate(com.mojang.blaze3d.vertex.ByteBufferBuilder) -> a
    21:21:net.minecraft.client.renderer.MultiBufferSource$BufferSource immediateWithBuffers(java.util.SequencedMap,com.mojang.blaze3d.vertex.ByteBufferBuilder) -> a
    com.mojang.blaze3d.vertex.VertexConsumer getBuffer(net.minecraft.client.renderer.RenderType) -> getBuffer
net.minecraft.client.renderer.MultiBufferSource$BufferSource -> gez$a:
# {"fileName":"MultiBufferSource.java","id":"sourceFile"}
    com.mojang.blaze3d.vertex.ByteBufferBuilder sharedBuffer -> a
    java.util.SequencedMap fixedBuffers -> b
    java.util.Map startedBuilders -> c
    net.minecraft.client.renderer.RenderType lastSharedType -> d
    30:37:void <init>(com.mojang.blaze3d.vertex.ByteBufferBuilder,java.util.SequencedMap) -> <init>
    41:64:com.mojang.blaze3d.vertex.VertexConsumer getBuffer(net.minecraft.client.renderer.RenderType) -> getBuffer
    68:72:void endLastBatch() -> a
    75:80:void endBatch() -> b
    83:87:void endBatch(net.minecraft.client.renderer.RenderType) -> a
    90:101:void endBatch(net.minecraft.client.renderer.RenderType,com.mojang.blaze3d.vertex.BufferBuilder) -> a
 */
class MultiBufferSource(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_MultiBufferSource)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = MultiBufferSource::class.classDesc
	}

	fun getBuffer(renderType: RenderType): VertexConsumer =
		VertexConsumer(
			clazz.getMethod("getBuffer", RenderType.clazz)
				.invoke(around, renderType.around)
		)
}