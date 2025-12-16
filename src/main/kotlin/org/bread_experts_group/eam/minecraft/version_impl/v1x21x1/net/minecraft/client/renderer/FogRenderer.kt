package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_FogRenderer
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.FogRenderer -> ger:
# {"fileName":"FogRenderer.java","id":"sourceFile"}
    int WATER_FOG_DISTANCE -> b
    java.util.List MOB_EFFECT_FOG -> c
    float BIOME_FOG_TRANSITION_TIME -> a
    float fogRed -> d
    float fogGreen -> e
    float fogBlue -> f
    int targetBiomeFog -> g
    int previousBiomeFog -> h
    long biomeChangedTime -> i
    31:31:void <init>() -> <init>
    53:200:void setupColor(net.minecraft.client.Camera,float,net.minecraft.client.multiplayer.ClientLevel,int,float) -> a
    203:204:void setupNoFog() -> a
    208:211:net.minecraft.client.renderer.FogRenderer$MobEffectFogFunction getPriorityFogFunction(net.minecraft.world.entity.Entity,float) -> a
    215:281:void setupFog(net.minecraft.client.Camera,net.minecraft.client.renderer.FogRenderer$FogMode,float,boolean,float) -> a
    284:285:void levelFogColor() -> b
    209:209:boolean lambda$getPriorityFogFunction$1(net.minecraft.world.entity.LivingEntity,float,net.minecraft.client.renderer.FogRenderer$MobEffectFogFunction) -> a
    110:110:net.minecraft.world.phys.Vec3 lambda$setupColor$0(net.minecraft.client.multiplayer.ClientLevel,net.minecraft.world.level.biome.BiomeManager,float,int,int,int) -> a
    40:50:void <clinit>() -> <clinit>
 */
class FogRenderer(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_FogRenderer)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = FogRenderer::class.classDesc

		fun setupNoFog() {
			clazz.getMethod("a").invoke(null)
		}
	}
}