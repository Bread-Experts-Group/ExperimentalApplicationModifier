package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.player

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity.player.Player
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_player_AbstractClientPlayer
import java.lang.constant.ClassDesc

/*
net.minecraft.client.player.AbstractClientPlayer -> gdy:
# {"fileName":"AbstractClientPlayer.java","id":"sourceFile"}
    net.minecraft.client.multiplayer.PlayerInfo playerInfo -> g
    net.minecraft.world.phys.Vec3 deltaMovementOnPreviousTick -> b
    float elytraRotX -> c
    float elytraRotY -> d
    float elytraRotZ -> e
    net.minecraft.client.multiplayer.ClientLevel clientLevel -> f
    24:34:void <init>(net.minecraft.client.multiplayer.ClientLevel,com.mojang.authlib.GameProfile) -> <init>
    38:39:boolean isSpectator() -> R_
    44:45:boolean isCreative() -> f
    50:53:net.minecraft.client.multiplayer.PlayerInfo getPlayerInfo() -> a
    58:60:void tick() -> l
    63:63:net.minecraft.world.phys.Vec3 getDeltaMovementLerped(float) -> G
    67:68:net.minecraft.client.resources.PlayerSkin getSkin() -> b
    72:100:float getFieldOfViewModifier() -> c
 */
abstract class AbstractClientPlayer(around: Any) : Player(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_player_AbstractClientPlayer)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = AbstractClientPlayer::class.classDesc
	}
}