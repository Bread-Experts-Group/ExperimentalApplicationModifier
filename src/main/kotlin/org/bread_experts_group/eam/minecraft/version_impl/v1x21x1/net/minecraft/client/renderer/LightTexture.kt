package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_LightTexture
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.LightTexture -> gey:
# {"fileName":"LightTexture.java","id":"sourceFile"}
    int FULL_BRIGHT -> a
    int FULL_SKY -> b
    int FULL_BLOCK -> c
    net.minecraft.client.renderer.texture.DynamicTexture lightTexture -> d
    com.mojang.blaze3d.platform.NativeImage lightPixels -> e
    net.minecraft.resources.ResourceLocation lightTextureLocation -> f
    boolean updateLightTexture -> g
    float blockLightRedFlicker -> h
    net.minecraft.client.renderer.GameRenderer renderer -> i
    net.minecraft.client.Minecraft minecraft -> j
    33:46:void <init>(net.minecraft.client.renderer.GameRenderer,net.minecraft.client.Minecraft) -> <init>
    50:51:void close() -> close
    54:57:void tick() -> a
    60:61:void turnOffLightLayer() -> b
    64:69:void turnOnLightLayer() -> c
    72:76:float getDarknessGamma(float) -> b
    80:81:float calculateDarknessScale(net.minecraft.world.entity.LivingEntity,float,float) -> a
    85:193:void updateLightTexture(float) -> a
    196:201:void clampColor(org.joml.Vector3f) -> a
    204:205:float notGamma(float) -> c
    211:214:float getBrightness(net.minecraft.world.level.dimension.DimensionType,int) -> a
    218:218:int pack(int,int) -> a
    222:222:int block(int) -> a
    226:226:int sky(int) -> b
 */
class LightTexture(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_LightTexture)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = LightTexture::class.classDesc
	}
}