package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.Item
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_core_DefaultedRegistry

class DefaultedRegistry<T>(around: Any) : Registry<T>(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_core_DefaultedRegistry)
	}

	fun getKey(o: T): ResourceLocation = TODO("Not yet implemented, b")
	fun getDefaultKey(): ResourceLocation = TODO("Not yet implemented, b")
	fun get(r: ResourceLocation): T = // todo hacky thing just to get the bread block to render in the title screen, improve later
		Item(clazz.getMethod("a", ResourceLocation.clazz).invoke(around, r.around)) as T
	fun byId(id: Int): T = TODO("Not yet implemented, a")
}