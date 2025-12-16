package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.sounds

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_sounds_SoundSource
import java.lang.constant.ClassDesc

/*
net.minecraft.sounds.SoundSource -> avq:
# {"fileName":"SoundSource.java","id":"sourceFile"}
    net.minecraft.sounds.SoundSource MASTER -> a
    net.minecraft.sounds.SoundSource MUSIC -> b
    net.minecraft.sounds.SoundSource RECORDS -> c
    net.minecraft.sounds.SoundSource WEATHER -> d
    net.minecraft.sounds.SoundSource BLOCKS -> e
    net.minecraft.sounds.SoundSource HOSTILE -> f
    net.minecraft.sounds.SoundSource NEUTRAL -> g
    net.minecraft.sounds.SoundSource PLAYERS -> h
    net.minecraft.sounds.SoundSource AMBIENT -> i
    net.minecraft.sounds.SoundSource VOICE -> j
    java.lang.String name -> k
    net.minecraft.sounds.SoundSource[] $VALUES -> l
    3:3:net.minecraft.sounds.SoundSource[] values() -> values
    3:3:net.minecraft.sounds.SoundSource valueOf(java.lang.String) -> valueOf
    18:20:void <init>(java.lang.String,int,java.lang.String) -> <init>
    23:23:java.lang.String getName() -> a
    3:3:net.minecraft.sounds.SoundSource[] $values() -> b
    3:13:void <clinit>() -> <clinit>
 */
class SoundSource(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_sounds_SoundSource)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = SoundSource::class.classDesc

		val MASTER: SoundSource = SoundSource(clazz.enumConstants[0])
		val MUSIC: SoundSource = SoundSource(clazz.enumConstants[1])
		val RECORDS: SoundSource = SoundSource(clazz.enumConstants[2])
		val WEATHER: SoundSource = SoundSource(clazz.enumConstants[3])
		val BLOCKS: SoundSource = SoundSource(clazz.enumConstants[4])
		val HOSTILE: SoundSource = SoundSource(clazz.enumConstants[5])
		val PLAYERS: SoundSource = SoundSource(clazz.enumConstants[6])
		val AMBIENT: SoundSource = SoundSource(clazz.enumConstants[7])
		val VOICE: SoundSource = SoundSource(clazz.enumConstants[8])
	}
}