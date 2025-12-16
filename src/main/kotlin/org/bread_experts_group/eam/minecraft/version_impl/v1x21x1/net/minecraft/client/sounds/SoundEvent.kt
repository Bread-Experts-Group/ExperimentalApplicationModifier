package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.sounds

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_sounds_SoundEvent
import java.lang.constant.ClassDesc

/*
net.minecraft.sounds.SoundEvent -> avo:
# {"fileName":"SoundEvent.java","id":"sourceFile"}
    com.mojang.serialization.Codec DIRECT_CODEC -> a
    com.mojang.serialization.Codec CODEC -> b
    net.minecraft.network.codec.StreamCodec DIRECT_STREAM_CODEC -> c
    net.minecraft.network.codec.StreamCodec STREAM_CODEC -> d
    float DEFAULT_RANGE -> e
    net.minecraft.resources.ResourceLocation location -> f
    float range -> g
    boolean newSystem -> h
    43:43:net.minecraft.sounds.SoundEvent create(net.minecraft.resources.ResourceLocation,java.util.Optional) -> a
    47:47:net.minecraft.sounds.SoundEvent createVariableRangeEvent(net.minecraft.resources.ResourceLocation) -> a
    51:51:net.minecraft.sounds.SoundEvent createFixedRangeEvent(net.minecraft.resources.ResourceLocation,float) -> a
    54:58:void <init>(net.minecraft.resources.ResourceLocation,float,boolean) -> <init>
    61:61:net.minecraft.resources.ResourceLocation getLocation() -> a
    65:68:float getRange(float) -> a
    72:72:java.util.Optional fixedRange() -> b
    43:43:net.minecraft.sounds.SoundEvent lambda$create$2(net.minecraft.resources.ResourceLocation) -> b
    43:43:net.minecraft.sounds.SoundEvent lambda$create$1(net.minecraft.resources.ResourceLocation,java.lang.Float) -> a
    17:20:com.mojang.datafixers.kinds.App lambda$static$0(com.mojang.serialization.codecs.RecordCodecBuilder$Instance) -> a
    17:30:void <clinit>() -> <clinit>
 */
class SoundEvent(around: Any): MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_sounds_SoundEvent)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = SoundEvent::class.classDesc
	}
}