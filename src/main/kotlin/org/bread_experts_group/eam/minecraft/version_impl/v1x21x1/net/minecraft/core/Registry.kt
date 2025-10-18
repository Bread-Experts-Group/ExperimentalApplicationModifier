package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceKey
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_core_Registry
import java.lang.constant.ClassDesc

/*
    net.minecraft.resources.ResourceKey key() -> d
    29:29:com.mojang.serialization.Codec byNameCodec() -> r
    36:36:com.mojang.serialization.Codec holderByNameCodec() -> s
    43:48:com.mojang.serialization.Codec referenceHolderWithLifecycle() -> b
    52:52:com.mojang.serialization.DataResult safeCastToReference(net.minecraft.core.Holder) -> a
    57:57:java.util.stream.Stream keys(com.mojang.serialization.DynamicOps) -> keys
    net.minecraft.resources.ResourceLocation getKey(java.lang.Object) -> b
    java.util.Optional getResourceKey(java.lang.Object) -> d
    int getId(java.lang.Object) -> a
    java.lang.Object get(net.minecraft.resources.ResourceKey) -> a
    java.lang.Object get(net.minecraft.resources.ResourceLocation) -> a
    java.util.Optional registrationInfo(net.minecraft.resources.ResourceKey) -> c
    com.mojang.serialization.Lifecycle registryLifecycle() -> e
    82:82:java.util.Optional getOptional(net.minecraft.resources.ResourceLocation) -> b
    86:86:java.util.Optional getOptional(net.minecraft.resources.ResourceKey) -> e
    java.util.Optional getAny() -> a
    98:102:java.lang.Object getOrThrow(net.minecraft.resources.ResourceKey) -> f
    java.util.Set keySet() -> f
    java.util.Set entrySet() -> h
    java.util.Set registryKeySet() -> g
    java.util.Optional getRandom(net.minecraft.util.RandomSource) -> a
    114:114:java.util.stream.Stream stream() -> t
    boolean containsKey(net.minecraft.resources.ResourceLocation) -> d
    boolean containsKey(net.minecraft.resources.ResourceKey) -> d
    122:122:java.lang.Object register(net.minecraft.core.Registry,java.lang.String,java.lang.Object) -> a
    126:126:java.lang.Object register(net.minecraft.core.Registry,net.minecraft.resources.ResourceLocation,java.lang.Object) -> a
    135:135:net.minecraft.core.Holder$Reference registerForHolder(net.minecraft.core.Registry,net.minecraft.resources.ResourceKey,java.lang.Object) -> b
    139:139:net.minecraft.core.Holder$Reference registerForHolder(net.minecraft.core.Registry,net.minecraft.resources.ResourceLocation,java.lang.Object) -> b
    net.minecraft.core.Registry freeze() -> m
    net.minecraft.core.Holder$Reference createIntrusiveHolder(java.lang.Object) -> f
    java.util.Optional getHolder(int) -> c
    java.util.Optional getHolder(net.minecraft.resources.ResourceLocation) -> c
    java.util.Optional getHolder(net.minecraft.resources.ResourceKey) -> b
    net.minecraft.core.Holder wrapAsHolder(java.lang.Object) -> e
    160:160:net.minecraft.core.Holder$Reference getHolderOrThrow(net.minecraft.resources.ResourceKey) -> g
    java.util.stream.Stream holders() -> i
    java.util.Optional getTag(net.minecraft.tags.TagKey) -> b
    168:168:java.lang.Iterable getTagOrEmpty(net.minecraft.tags.TagKey) -> c
    172:172:java.util.Optional getRandomElementOf(net.minecraft.tags.TagKey,net.minecraft.util.RandomSource) -> a
    net.minecraft.core.HolderSet$Named getOrCreateTag(net.minecraft.tags.TagKey) -> a
    java.util.stream.Stream getTags() -> j
    java.util.stream.Stream getTagNames() -> k
    void resetTags() -> n
    void bindTags(java.util.Map) -> a
    186:186:net.minecraft.core.IdMap asHolderIdMap() -> u
    net.minecraft.core.HolderOwner holderOwner() -> p
    net.minecraft.core.HolderLookup$RegistryLookup asLookup() -> q
    215:215:net.minecraft.core.HolderLookup$RegistryLookup asTagAddingLookup() -> v
    172:172:java.util.Optional lambda$getRandomElementOf$10(net.minecraft.util.RandomSource,net.minecraft.core.HolderSet$Named) -> a
    160:160:java.lang.IllegalStateException lambda$getHolderOrThrow$9(net.minecraft.resources.ResourceKey) -> h
    57:57:java.lang.Object lambda$keys$8(com.mojang.serialization.DynamicOps,net.minecraft.resources.ResourceLocation) -> a
    52:52:java.lang.String lambda$safeCastToReference$7(net.minecraft.core.Holder) -> b
    48:48:com.mojang.serialization.Lifecycle lambda$referenceHolderWithLifecycle$6(net.minecraft.core.Holder$Reference) -> a
    45:45:net.minecraft.resources.ResourceLocation lambda$referenceHolderWithLifecycle$5(net.minecraft.core.Holder$Reference) -> b
    44:44:com.mojang.serialization.DataResult lambda$referenceHolderWithLifecycle$4(net.minecraft.resources.ResourceLocation) -> e
    44:44:com.mojang.serialization.DataResult lambda$referenceHolderWithLifecycle$3(net.minecraft.resources.ResourceLocation) -> f
    44:44:java.lang.String lambda$referenceHolderWithLifecycle$2(net.minecraft.resources.ResourceLocation) -> g
    37:37:net.minecraft.core.Holder lambda$holderByNameCodec$1(net.minecraft.core.Holder$Reference) -> c
    31:31:com.mojang.serialization.DataResult lambda$byNameCodec$0(java.lang.Object) -> g
 */
open class Registry<T>(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_core_Registry)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Registry::class.classDesc

		fun <V : MimickedClass, T : V> register(registry: Registry<V>, resourceKey: ResourceKey<V>, `object`: T): T {
			clazz.getMethod("a", clazz, ResourceKey.clazz, Object::class.java)
				.invoke(null, registry.around, resourceKey.around, `object`.around)
			return `object`
		}
	}
}