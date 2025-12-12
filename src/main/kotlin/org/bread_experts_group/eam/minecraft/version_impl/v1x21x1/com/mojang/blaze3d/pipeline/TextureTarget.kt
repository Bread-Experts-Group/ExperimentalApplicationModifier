package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.pipeline

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com_mojang_blaze3d_pipeline_TextureTarget
import java.lang.constant.ClassDesc

class TextureTarget(around: Any) : RenderTarget(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_blaze3d_pipeline_TextureTarget)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = TextureTarget::class.classDesc
	}

	constructor(width: Int, height: Int, useDepth: Boolean, clearError: Boolean) : this(
		clazz.getConstructor(Int::class.java, Int::class.java, Boolean::class.java, Boolean::class.java)
			.newInstance(width, height, useDepth, clearError)
	)
}