package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_DeltaTracker
import java.lang.constant.ClassDesc

/*
net.minecraft.client.DeltaTracker -> fgf:
# {"fileName":"DeltaTracker.java","id":"sourceFile"}
    net.minecraft.client.DeltaTracker ZERO -> a
    net.minecraft.client.DeltaTracker ONE -> b
    float getGameTimeDeltaTicks() -> a
    float getGameTimeDeltaPartialTick(boolean) -> a
    float getRealtimeDeltaTicks() -> b
    13:14:void <clinit>() -> <clinit>
 */
class DeltaTracker(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_client_DeltaTracker
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
		val mimicClassDesc: ClassDesc = ClassDesc.of(DeltaTracker::class.qualifiedName)
	}
}