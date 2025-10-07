package org.bread_experts_group.eam.minecraft.feature.v1x0x0.net.minecraft

import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x0x0.net_minecraft_ContainerCreative

class ContainerCreative(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_ContainerCreative)
	}
}