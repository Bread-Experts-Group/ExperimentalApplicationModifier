package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_level_block_state_StateDefinition
import java.lang.constant.ClassDesc

/*
    java.util.regex.Pattern NAME_PATTERN -> a
    java.lang.Object owner -> b
    com.google.common.collect.ImmutableSortedMap propertiesByName -> c
    com.google.common.collect.ImmutableList states -> d
    34:75:void <init>(java.util.function.Function,java.lang.Object,net.minecraft.world.level.block.state.StateDefinition$Factory,java.util.Map) -> <init>
    78:81:com.mojang.serialization.MapCodec appendPropertyCodec(com.mojang.serialization.MapCodec,java.util.function.Supplier,java.lang.String,net.minecraft.world.level.block.state.properties.Property) -> a
    88:88:com.google.common.collect.ImmutableList getPossibleStates() -> a
    92:92:net.minecraft.world.level.block.state.StateHolder any() -> b
    96:96:java.lang.Object getOwner() -> c
    100:100:java.util.Collection getProperties() -> d
    105:108:java.lang.String toString() -> toString
    113:113:net.minecraft.world.level.block.state.properties.Property getProperty(java.lang.String) -> a
    83:83:com.mojang.datafixers.util.Pair lambda$appendPropertyCodec$7(net.minecraft.world.level.block.state.properties.Property,net.minecraft.world.level.block.state.StateHolder) -> a
    82:82:net.minecraft.world.level.block.state.StateHolder lambda$appendPropertyCodec$6(net.minecraft.world.level.block.state.properties.Property,com.mojang.datafixers.util.Pair) -> a
    80:80:net.minecraft.world.level.block.state.properties.Property$Value lambda$appendPropertyCodec$5(net.minecraft.world.level.block.state.properties.Property,java.util.function.Supplier) -> a
    80:80:void lambda$appendPropertyCodec$4(java.lang.String) -> b
    60:68:void lambda$new$3(net.minecraft.world.level.block.state.StateDefinition$Factory,java.lang.Object,com.mojang.serialization.MapCodec,java.util.Map,java.util.List,java.util.List) -> a
    52:52:java.util.stream.Stream lambda$new$2(net.minecraft.world.level.block.state.properties.Property,java.util.List) -> a
    53:55:java.util.List lambda$new$1(java.util.List,net.minecraft.world.level.block.state.properties.Property,java.lang.Comparable) -> a
    38:38:net.minecraft.world.level.block.state.StateHolder lambda$new$0(java.util.function.Function,java.lang.Object) -> a
    28:28:void <clinit>() -> <clinit>
 */
class StateDefinition(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_level_block_state_StateDefinition)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = StateDefinition::class.classDesc
	}

	fun getPossibleStates(): List<BlockState> {
		val googleList = clazz.getMethod("a").invoke(around)
		val array = googleList::class.java.getMethod("toArray").invoke(googleList) as Array<*>
		return array.map { BlockState(it!!) }
	}
}