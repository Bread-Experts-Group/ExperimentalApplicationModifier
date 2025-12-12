package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_DeltaTracker
import java.lang.constant.ClassDesc

class DeltaTracker(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_DeltaTracker)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = DeltaTracker::class.classDesc

		val ZERO: DeltaTracker = DeltaTracker(clazz.getField("a").get(null))

		val ONE: DeltaTracker = DeltaTracker(clazz.getField("b").get(null))
	}

	fun getGameTimeDeltaTicks(): Float = clazz.getMethod("a").invoke(around) as Float
	fun getRealtimeDeltaTicks(): Float = clazz.getMethod("b").invoke(around) as Float

	fun getGameTimeDeltaPartialTick(runsNormally: Boolean): Float =
		clazz.getMethod("a", Boolean::class.java).invoke(around, runsNormally) as Float
}