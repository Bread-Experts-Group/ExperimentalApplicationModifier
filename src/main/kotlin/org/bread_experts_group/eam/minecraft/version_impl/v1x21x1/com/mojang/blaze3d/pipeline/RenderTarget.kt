package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.pipeline

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.com_mojang_blaze3d_pipeline_RenderTarget
import java.lang.constant.ClassDesc

/*
com.mojang.blaze3d.pipeline.RenderTarget -> ezv:
# {"fileName":"RenderTarget.java","id":"sourceFile"}
    int RED_CHANNEL -> a
    int GREEN_CHANNEL -> b
    int BLUE_CHANNEL -> l
    int ALPHA_CHANNEL -> m
    int width -> c
    int height -> d
    int viewWidth -> e
    int viewHeight -> f
    boolean useDepth -> g
    int frameBufferId -> h
    int colorTextureId -> i
    int depthBufferId -> j
    float[] clearChannels -> n
    int filterMode -> k
    33:50:void <init>(boolean) -> <init>
    53:60:void resize(int,int,boolean) -> a
    63:73:void _resize(int,int,boolean) -> d
    96:103:void copyDepthFrom(com.mojang.blaze3d.pipeline.RenderTarget) -> a
    106:150:void createBuffers(int,int,boolean) -> b
    153:154:void setFilterMode(int) -> a
    157:165:void setFilterMode(int,boolean) -> a
    168:185:void checkStatus() -> b
    190:192:void bindRead() -> c
    195:197:void unbindRead() -> d
    211:216:void _bindWrite(boolean) -> c
    230:234:void setClearColor(float,float,float,float) -> a
    237:238:void blitToScreen(int,int) -> a
    241:242:void blitToScreen(int,int,boolean) -> c
    245:272:void _blitToScreen(int,int,boolean) -> e
    222:223:void lambda$unbindWrite$3() -> h
    203:204:void lambda$bindWrite$2(boolean) -> d
    55:56:void lambda$resize$1(int,int,boolean) -> f
    34:39:float[] lambda$new$0() -> i
 */
abstract class RenderTarget(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_blaze3d_pipeline_RenderTarget)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = RenderTarget::class.classDesc
	}

	val width: Int
		get() = clazz.getField("c").getInt(around)

	val height: Int
		get() = clazz.getField("d").getInt(around)

	fun clear(clearError: Boolean) {
		clazz.getMethod("b", Boolean::class.java).invoke(around, clearError)
	}

	fun bindWrite(setViewport: Boolean) {
		clazz.getMethod("a", Boolean::class.java).invoke(around, setViewport)
	}

	fun unbindWrite() {
		clazz.getMethod("e").invoke(around)
	}

	fun destroyBuffers() {
		clazz.getMethod("a").invoke(around)
	}

	fun getColorTextureId(): Int = clazz.getMethod("f").invoke(around) as Int

	fun getDepthTextureId(): Int = clazz.getMethod("g").invoke(around) as Int
}