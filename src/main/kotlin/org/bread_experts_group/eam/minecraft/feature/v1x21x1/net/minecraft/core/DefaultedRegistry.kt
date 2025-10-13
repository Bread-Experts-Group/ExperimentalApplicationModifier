package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_core_DefaultedRegistry

class DefaultedRegistry<T : MimickedClass>(private val mimics: Class<T>, around: Any) : Registry<T>(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_core_DefaultedRegistry
		)
	}

	fun getKey(o: T): ResourceLocation = TODO("Not yet implemented, b")
	fun getDefaultKey(): ResourceLocation = TODO("Not yet implemented, b")
	fun get(r: ResourceLocation): T = mimics.getConstructor(Object::class.java).newInstance(
		clazz
			.getMethod("a", ResourceLocation.clazz)
			.invoke(around, r.around)
	)
	fun byId(id: Int): T = TODO("Not yet implemented, a")
}