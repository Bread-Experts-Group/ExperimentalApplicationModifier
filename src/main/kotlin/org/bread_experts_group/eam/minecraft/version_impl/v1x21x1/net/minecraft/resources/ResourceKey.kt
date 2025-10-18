package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.Registry
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_resources_ResourceKey
import java.lang.constant.ClassDesc

/*
net.minecraft.resources.ResourceKey -> akq:
# {"fileName":"ResourceKey.java","id":"sourceFile"}
    java.util.concurrent.ConcurrentMap VALUES -> a
    net.minecraft.resources.ResourceLocation registryName -> b
    net.minecraft.resources.ResourceLocation location -> c
    26:26:com.mojang.serialization.Codec codec(net.minecraft.resources.ResourceKey) -> a
    30:30:net.minecraft.network.codec.StreamCodec streamCodec(net.minecraft.resources.ResourceKey) -> b
    34:34:net.minecraft.resources.ResourceKey create(net.minecraft.resources.ResourceKey,net.minecraft.resources.ResourceLocation) -> a
    41:41:net.minecraft.resources.ResourceKey createRegistryKey(net.minecraft.resources.ResourceLocation) -> a
    46:46:net.minecraft.resources.ResourceKey create(net.minecraft.resources.ResourceLocation,net.minecraft.resources.ResourceLocation) -> a
    49:52:void <init>(net.minecraft.resources.ResourceLocation,net.minecraft.resources.ResourceLocation) -> <init>
    56:56:java.lang.String toString() -> toString
    60:60:boolean isFor(net.minecraft.resources.ResourceKey) -> c
    65:65:java.util.Optional cast(net.minecraft.resources.ResourceKey) -> d
    69:69:net.minecraft.resources.ResourceLocation location() -> a
    73:73:net.minecraft.resources.ResourceLocation registry() -> b
    77:77:net.minecraft.resources.ResourceKey registryKey() -> c
    46:46:net.minecraft.resources.ResourceKey lambda$create$2(net.minecraft.resources.ResourceKey$InternKey) -> a
    30:30:net.minecraft.resources.ResourceKey lambda$streamCodec$1(net.minecraft.resources.ResourceKey,net.minecraft.resources.ResourceLocation) -> b
    26:26:net.minecraft.resources.ResourceKey lambda$codec$0(net.minecraft.resources.ResourceKey,net.minecraft.resources.ResourceLocation) -> c
    20:20:void <clinit>() -> <clinit>
 */
class ResourceKey<T>(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_resources_ResourceKey)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ResourceKey::class.classDesc

		fun <T> create(resourceKey: ResourceKey<Registry<T>>, resourceLocation: ResourceLocation): ResourceKey<T> = ResourceKey(
			clazz.getMethod("a", clazz, ResourceLocation.clazz)
				.invoke(null, resourceKey.around, resourceLocation.around)
		)
	}
}