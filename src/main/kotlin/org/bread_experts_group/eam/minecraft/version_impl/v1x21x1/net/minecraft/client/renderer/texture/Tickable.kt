package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.texture

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_texture_Tickable
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.texture.Tickable -> gqn:
# {"fileName":"Tickable.java","id":"sourceFile"}
    void tick() -> e
 */
interface Tickable {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_texture_Tickable)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Tickable::class.classDesc

		const val tick: String = "e"
	}

	fun tick()
}