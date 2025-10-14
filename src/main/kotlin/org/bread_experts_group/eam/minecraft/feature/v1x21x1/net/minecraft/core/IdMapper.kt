package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.state.BlockBehaviour
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_core_IdMapper
import java.lang.constant.ClassDesc

/*
    int nextId -> b
    it.unimi.dsi.fastutil.objects.Reference2IntMap tToId -> c
    java.util.List idToT -> d
    20:21:void <init>() -> <init>
    23:27:void <init>(int) -> <init>
    30:42:void addMapping(java.lang.Object,int) -> a
    50:50:int getId(java.lang.Object) -> a
    56:60:java.lang.Object byId(int) -> a
    65:65:java.util.Iterator iterator() -> iterator
    69:69:boolean contains(int) -> c
    74:74:int size() -> c
 */
class IdMapper<T : MimickedClass>(around: Any) : BlockBehaviour(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_core_IdMapper)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = IdMapper::class.classDesc
	}

	fun add(o: T) {
		clazz.getMethod("b", Object::class.java).invoke(around, o.around)
	}
}