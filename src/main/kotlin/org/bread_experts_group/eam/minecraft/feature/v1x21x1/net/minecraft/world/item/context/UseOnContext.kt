package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.context

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_context_UseOnContext
import java.lang.constant.ClassDesc

/*
net.minecraft.world.item.context.UseOnContext -> cyf:
# {"fileName":"UseOnContext.java","id":"sourceFile"}
    net.minecraft.world.entity.player.Player player -> a
    net.minecraft.world.InteractionHand hand -> b
    net.minecraft.world.phys.BlockHitResult hitResult -> c
    net.minecraft.world.level.Level level -> d
    net.minecraft.world.item.ItemStack itemStack -> e
    24:25:void <init>(net.minecraft.world.entity.player.Player,net.minecraft.world.InteractionHand,net.minecraft.world.phys.BlockHitResult) -> <init>
    27:34:void <init>(net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,net.minecraft.world.InteractionHand,net.minecraft.world.item.ItemStack,net.minecraft.world.phys.BlockHitResult) -> <init>
    37:37:net.minecraft.world.phys.BlockHitResult getHitResult() -> j
    41:41:net.minecraft.core.BlockPos getClickedPos() -> a
    45:45:net.minecraft.core.Direction getClickedFace() -> k
    49:49:net.minecraft.world.phys.Vec3 getClickLocation() -> l
    53:53:boolean isInside() -> m
    57:57:net.minecraft.world.item.ItemStack getItemInHand() -> n
    62:62:net.minecraft.world.entity.player.Player getPlayer() -> o
    66:66:net.minecraft.world.InteractionHand getHand() -> p
    70:70:net.minecraft.world.level.Level getLevel() -> q
    74:74:net.minecraft.core.Direction getHorizontalDirection() -> g
    78:78:boolean isSecondaryUseActive() -> h
    82:82:float getRotation() -> i
 */
class UseOnContext(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_world_item_context_UseOnContext
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
		val mimicClassDesc: ClassDesc = ClassDesc.of(UseOnContext::class.qualifiedName)
	}
}