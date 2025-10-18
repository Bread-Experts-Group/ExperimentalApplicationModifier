package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_server_packs_PackType
import java.lang.constant.ClassDesc

class PackType(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_PackType)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = PackType::class.classDesc

		val CLIENT_RESOURCES: PackType
			get() = PackType(clazz.getField("a").get(null))
		val SERVER_DATA: PackType
			get() = PackType(clazz.getField("b").get(null))
	}

	fun getDirectory(): String = clazz.getMethod("a").invoke(around).toString()
}