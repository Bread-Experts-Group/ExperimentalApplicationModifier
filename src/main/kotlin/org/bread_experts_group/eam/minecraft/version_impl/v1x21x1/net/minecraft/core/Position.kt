package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_core_Position
import java.lang.constant.ClassDesc

/*
net.minecraft.core.Position -> jw:
# {"fileName":"Position.java","id":"sourceFile"}
    double x() -> a
    double y() -> b
    double z() -> c
 */
interface Position {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_core_Position)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Position::class.classDesc
	}

	fun x(): Double
	fun y(): Double
	fun z(): Double
}