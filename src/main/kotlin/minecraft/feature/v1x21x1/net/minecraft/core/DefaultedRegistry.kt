package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation

class DefaultedRegistry<T>(around: Any) : Registry<T>(around) {
	companion object {
		val clazz: Class<*> = ClassLoader.getSystemClassLoader().loadClass("jh")
	}

	fun getKey(o: T): ResourceLocation = TODO("Not yet implemented, b")
	fun getDefaultKey(): ResourceLocation = TODO("Not yet implemented, b")
	fun get(r: ResourceLocation): T = TODO("Not yet implemented, a")
	fun byId(id: Int): T = TODO("Not yet implemented, a")
}