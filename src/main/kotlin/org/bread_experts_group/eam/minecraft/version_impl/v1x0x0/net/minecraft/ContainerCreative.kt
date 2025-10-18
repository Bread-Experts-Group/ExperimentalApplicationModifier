package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.net.minecraft

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.net_minecraft_ContainerCreative

class ContainerCreative(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> =
			loadClass(net_minecraft_ContainerCreative)
	}
}