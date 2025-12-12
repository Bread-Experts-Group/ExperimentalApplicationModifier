package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.pipeline

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com_mojang_blaze3d_pipeline_MainTarget
import java.lang.constant.ClassDesc

/*
com.mojang.blaze3d.pipeline.MainTarget -> ezs:
# {"fileName":"MainTarget.java","id":"sourceFile"}
    int DEFAULT_WIDTH -> a
    int DEFAULT_HEIGHT -> b
    com.mojang.blaze3d.pipeline.MainTarget$Dimension DEFAULT_DIMENSIONS -> l
    19:22:void <init>(int,int) -> <init>
    25:55:void createFrameBuffer(int,int) -> b
    58:79:com.mojang.blaze3d.pipeline.MainTarget$Dimension allocateAttachments(int,int) -> c
    83:89:boolean allocateColorAttachment(com.mojang.blaze3d.pipeline.MainTarget$Dimension) -> a
    93:99:boolean allocateDepthAttachment(com.mojang.blaze3d.pipeline.MainTarget$Dimension) -> b
    16:16:void <clinit>() -> <clinit>
 */
class MainTarget(around: Any) : RenderTarget(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_blaze3d_pipeline_MainTarget)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = MainTarget::class.classDesc

		val DEFAULT_WIDTH: Int = clazz.getField("a").getInt(null)
		val DEFAULT_HEIGHT: Int = clazz.getField("b").getInt(null)
	}

	constructor(width: Int, height: Int) : this(
		clazz.getConstructor(Int::class.java, Int::class.java)
			.newInstance(width, height)
	)
}