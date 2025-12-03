package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.systems

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.pipeline.RenderCall
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com_mojang_blaze3d_systems_RenderSystem
import java.lang.constant.ClassDesc

class RenderSystem(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_blaze3d_systems_RenderSystem)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = RenderSystem::class.classDesc

		fun isOnRenderThread(): Boolean = clazz.getMethod("isOnRenderThread").invoke(null) as Boolean

		fun recordRenderCall(runnable: () -> Unit) {
			clazz.getMethod("recordRenderCall", RenderCall.clazz)
				.invoke(null, RenderCall.native { runnable() })
		}

		fun executeOnRenderThread(runnable: () -> Unit) {
			if (!this.isOnRenderThread()) {
				this.recordRenderCall { runnable() }
			} else runnable()
		}
	}
}