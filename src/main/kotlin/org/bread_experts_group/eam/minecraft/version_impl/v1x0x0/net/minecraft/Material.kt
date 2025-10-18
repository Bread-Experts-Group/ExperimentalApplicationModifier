package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.net.minecraft

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass

class Material(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass("p")
		val grass: Material
			get() = Material(clazz.getField("b").get(null))
	}
}