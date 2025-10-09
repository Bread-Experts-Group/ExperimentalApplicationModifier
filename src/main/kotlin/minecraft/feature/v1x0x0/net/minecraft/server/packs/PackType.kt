package org.bread_experts_group.eam.minecraft.feature.v1x0x0.net.minecraft.server.packs

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_server_packs_PackType

class PackType(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_server_packs_PackType)

		val CLIENT_RESOURCES: PackType
			get() = PackType(clazz.getField("a").get(null))
		val SERVER_DATA: PackType
			get() = PackType(clazz.getField("b").get(null))
	}

	fun getDirectory(): String = clazz.getMethod("a").invoke(around).toString()
}