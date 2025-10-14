package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_gui_Font
import java.lang.constant.ClassDesc

/*
net.minecraft.client.gui.Font -> fhx:
# {"fileName":"Font.java","id":"sourceFile"}
    float EFFECT_DEPTH -> d
    org.joml.Vector3f SHADOW_OFFSET -> e
    int ALPHA_CUTOFF -> a
    int lineHeight -> b
    net.minecraft.util.RandomSource random -> c
    java.util.function.Function fonts -> f
    boolean filterFishyGlyphs -> g
    net.minecraft.client.StringSplitter splitter -> h
    42:54:void <init>(java.util.function.Function,boolean) -> <init>
    57:57:net.minecraft.client.gui.font.FontSet getFontSet(net.minecraft.resources.ResourceLocation) -> a
    62:68:java.lang.String bidirectionalShaping(java.lang.String) -> a
    72:72:int drawInBatch(java.lang.String,float,float,int,boolean,org.joml.Matrix4f,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.gui.Font$DisplayMode,int,int) -> a
    76:76:int drawInBatch(java.lang.String,float,float,int,boolean,org.joml.Matrix4f,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.gui.Font$DisplayMode,int,int,boolean) -> a
    80:80:int drawInBatch(net.minecraft.network.chat.Component,float,float,int,boolean,org.joml.Matrix4f,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.gui.Font$DisplayMode,int,int) -> a
    84:84:int drawInBatch(net.minecraft.util.FormattedCharSequence,float,float,int,boolean,org.joml.Matrix4f,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.gui.Font$DisplayMode,int,int) -> a
    88:114:void drawInBatch8xOutline(net.minecraft.util.FormattedCharSequence,float,float,int,int,org.joml.Matrix4f,net.minecraft.client.renderer.MultiBufferSource,int) -> a
    118:121:int adjustColor(int) -> a
    125:139:int drawInternal(java.lang.String,float,float,int,boolean,org.joml.Matrix4f,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.gui.Font$DisplayMode,int,int,boolean) -> b
    143:153:int drawInternal(net.minecraft.util.FormattedCharSequence,float,float,int,boolean,org.joml.Matrix4f,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.gui.Font$DisplayMode,int,int) -> b
    291:293:float renderText(java.lang.String,float,float,int,boolean,org.joml.Matrix4f,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.gui.Font$DisplayMode,int,int) -> b
    297:299:float renderText(net.minecraft.util.FormattedCharSequence,float,float,int,boolean,org.joml.Matrix4f,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.gui.Font$DisplayMode,int,int) -> c
    303:307:void renderChar(net.minecraft.client.gui.font.glyphs.BakedGlyph,boolean,boolean,float,float,float,org.joml.Matrix4f,com.mojang.blaze3d.vertex.VertexConsumer,float,float,float,float,int) -> a
    310:310:int width(java.lang.String) -> b
    314:314:int width(net.minecraft.network.chat.FormattedText) -> a
    318:318:int width(net.minecraft.util.FormattedCharSequence) -> a
    322:322:java.lang.String plainSubstrByWidth(java.lang.String,int,boolean) -> a
    326:326:java.lang.String plainSubstrByWidth(java.lang.String,int) -> a
    330:330:net.minecraft.network.chat.FormattedText substrByWidth(net.minecraft.network.chat.FormattedText,int) -> a
    334:334:int wordWrapHeight(java.lang.String,int) -> b
    338:338:int wordWrapHeight(net.minecraft.network.chat.FormattedText,int) -> b
    342:342:java.util.List split(net.minecraft.network.chat.FormattedText,int) -> c
    346:346:boolean isBidirectional() -> a
    350:350:net.minecraft.client.StringSplitter getSplitter() -> b
    97:105:boolean lambda$drawInBatch8xOutline$1(net.minecraft.client.gui.Font$StringRenderOutput,float[],int,float,int,int,int,net.minecraft.network.chat.Style,int) -> a
    53:53:float lambda$new$0(int,net.minecraft.network.chat.Style) -> a
 */
class Font(around: Any): MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_gui_Font)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Font::class.classDesc
	}
}