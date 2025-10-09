package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_InteractionResult
import java.lang.constant.ClassDesc

/*
net.minecraft.world.InteractionResult -> bqr:
# {"fileName":"InteractionResult.java","id":"sourceFile"}
    net.minecraft.world.InteractionResult[] $VALUES -> g
    3:3:net.minecraft.world.InteractionResult[] values() -> values
    3:3:net.minecraft.world.InteractionResult valueOf(java.lang.String) -> valueOf
    3:3:void <init>(java.lang.String,int) -> <init>
    12:12:boolean consumesAction() -> a
    16:16:boolean shouldSwing() -> b
    20:20:boolean indicateItemUse() -> c
    28:28:net.minecraft.world.InteractionResult sidedSuccess(boolean) -> a
    3:3:net.minecraft.world.InteractionResult[] $values() -> d
    3:9:void <clinit>() -> <clinit>
 */
class InteractionResult(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_world_InteractionResult)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
		val mimicClassDesc: ClassDesc = ClassDesc.of(InteractionResult::class.qualifiedName)

		val SUCCESS: InteractionResult
			get() = InteractionResult(clazz.getField("a").get(null))
		val SUCCESS_NO_ITEM_USED: InteractionResult
			get() = InteractionResult(clazz.getField("b").get(null))
		val CONSUME: InteractionResult
			get() = InteractionResult(clazz.getField("c").get(null))
		val CONSUME_PARTIAL: InteractionResult
			get() = InteractionResult(clazz.getField("d").get(null))
		val PASS: InteractionResult
			get() = InteractionResult(clazz.getField("e").get(null))
		val FAIL: InteractionResult
			get() = InteractionResult(clazz.getField("f").get(null))
	}
}