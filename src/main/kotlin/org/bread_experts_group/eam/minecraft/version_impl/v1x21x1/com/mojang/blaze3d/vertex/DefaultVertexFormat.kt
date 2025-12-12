package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com_mojang_blaze3d_vertex_DefaultVertexFormat
import java.lang.constant.ClassDesc

/*
com.mojang.blaze3d.vertex.DefaultVertexFormat -> fbg:
# {"fileName":"DefaultVertexFormat.java","id":"sourceFile"}
    com.mojang.blaze3d.vertex.VertexFormat BLIT_SCREEN -> a
    com.mojang.blaze3d.vertex.VertexFormat BLOCK -> b
    com.mojang.blaze3d.vertex.VertexFormat NEW_ENTITY -> c
    com.mojang.blaze3d.vertex.VertexFormat PARTICLE -> d
    com.mojang.blaze3d.vertex.VertexFormat POSITION -> e
    com.mojang.blaze3d.vertex.VertexFormat POSITION_COLOR -> f
    com.mojang.blaze3d.vertex.VertexFormat POSITION_COLOR_NORMAL -> g
    com.mojang.blaze3d.vertex.VertexFormat POSITION_COLOR_LIGHTMAP -> h
    com.mojang.blaze3d.vertex.VertexFormat POSITION_TEX -> i
    com.mojang.blaze3d.vertex.VertexFormat POSITION_TEX_COLOR -> j
    com.mojang.blaze3d.vertex.VertexFormat POSITION_COLOR_TEX_LIGHTMAP -> k
    com.mojang.blaze3d.vertex.VertexFormat POSITION_TEX_LIGHTMAP_COLOR -> l
    com.mojang.blaze3d.vertex.VertexFormat POSITION_TEX_COLOR_NORMAL -> m
    3:3:void <init>() -> <init>
    4:87:void <clinit>() -> <clinit>
 */
object DefaultVertexFormat : MimickedClass(0), ClassInfo {
	override val clazz: Class<*> = loadClass(com_mojang_blaze3d_vertex_DefaultVertexFormat)
	override val classDesc: ClassDesc = clazz.classDesc
	override val mimicClassDesc: ClassDesc = DefaultVertexFormat::class.classDesc

	val POSITION_TEX_COLOR: VertexFormat = VertexFormat(clazz.getField("j").get(null))
}