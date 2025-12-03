package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_core_Holder_Reference
import java.lang.constant.ClassDesc

open class Holder<T>(around: Any) : MimickedClass(around) {
	/*
	net.minecraft.core.Holder$Reference -> jm$c:
# {"fileName":"Holder.java","id":"sourceFile"}
    net.minecraft.core.HolderOwner owner -> a
    java.util.Set tags -> b
    net.minecraft.core.Holder$Reference$Type type -> c
    net.minecraft.resources.ResourceKey key -> d
    java.lang.Object value -> e
    137:152:void <init>(net.minecraft.core.Holder$Reference$Type,net.minecraft.core.HolderOwner,net.minecraft.resources.ResourceKey,java.lang.Object) -> <init>
    158:158:net.minecraft.core.Holder$Reference createStandAlone(net.minecraft.core.HolderOwner,net.minecraft.resources.ResourceKey) -> a
    167:167:net.minecraft.core.Holder$Reference createIntrusive(net.minecraft.core.HolderOwner,java.lang.Object) -> a
    171:174:net.minecraft.resources.ResourceKey key() -> h
    179:182:java.lang.Object value() -> a
    187:187:boolean is(net.minecraft.resources.ResourceLocation) -> a
    192:192:boolean is(net.minecraft.resources.ResourceKey) -> a
    197:197:boolean is(net.minecraft.tags.TagKey) -> a
    202:202:boolean is(net.minecraft.core.Holder) -> a
    207:207:boolean is(java.util.function.Predicate) -> a
    212:212:boolean canSerializeIn(net.minecraft.core.HolderOwner) -> a
    217:217:com.mojang.datafixers.util.Either unwrap() -> d
    222:222:java.util.Optional unwrapKey() -> e
    227:227:net.minecraft.core.Holder$Kind kind() -> f
    232:232:boolean isBound() -> b
    236:240:void bindKey(net.minecraft.resources.ResourceKey) -> b
    243:247:void bindValue(java.lang.Object) -> b
    250:251:void bindTags(java.util.Collection) -> a
    255:255:java.util.stream.Stream tags() -> c
    260:260:java.lang.String toString() -> toString
	 */
	class Reference<T : MimickedClass>(private val mimics: Class<T>, around: Any) : Holder<T>(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_core_Holder_Reference)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = Reference::class.classDesc
		}

		fun value(): T = mimics.getConstructor(Object::class.java).newInstance(
			clazz
				.getMethod("a")
				.invoke(around)
		)
	}
}