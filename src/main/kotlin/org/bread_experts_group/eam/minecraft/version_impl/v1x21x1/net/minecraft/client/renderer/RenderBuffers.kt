package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_RenderBuffers
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.RenderBuffers -> gff:
# {"fileName":"RenderBuffers.java","id":"sourceFile"}
    net.minecraft.client.renderer.SectionBufferBuilderPack fixedBufferPack -> a
    net.minecraft.client.renderer.SectionBufferBuilderPool sectionBufferPool -> b
    net.minecraft.client.renderer.MultiBufferSource$BufferSource bufferSource -> c
    net.minecraft.client.renderer.MultiBufferSource$BufferSource crumblingBufferSource -> d
    net.minecraft.client.renderer.OutlineBufferSource outlineBufferSource -> e
    19:49:void <init>(int) -> <init>
    52:53:void put(it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap,net.minecraft.client.renderer.RenderType) -> a
    56:56:net.minecraft.client.renderer.SectionBufferBuilderPack fixedBufferPack() -> a
    60:60:net.minecraft.client.renderer.SectionBufferBuilderPool sectionBufferPool() -> b
    68:68:net.minecraft.client.renderer.MultiBufferSource$BufferSource crumblingBufferSource() -> d
    72:72:net.minecraft.client.renderer.OutlineBufferSource outlineBufferSource() -> e
    24:44:void lambda$new$1(it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap) -> a
    43:43:void lambda$new$0(it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap,net.minecraft.client.renderer.RenderType) -> b
 */
class RenderBuffers(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_RenderBuffers)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = RenderBuffers::class.classDesc
	}

	fun bufferSource(): MultiBufferSource.BufferSource =
		MultiBufferSource.BufferSource(clazz.getMethod("c").invoke(around))
}