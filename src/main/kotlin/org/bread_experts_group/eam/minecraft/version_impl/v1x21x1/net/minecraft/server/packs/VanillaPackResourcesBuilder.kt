package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_VanillaPackResourcesBuilder
import java.lang.constant.ClassDesc
import java.nio.file.Path

/*
net.minecraft.server.packs.VanillaPackResourcesBuilder -> asv:
# {"fileName":"VanillaPackResourcesBuilder.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> b
    java.util.function.Consumer developmentConfig -> a
    java.util.Map ROOT_DIR_BY_TYPE -> c
    java.util.Set rootPaths -> d
    java.util.Map pathsForType -> e
    net.minecraft.server.packs.BuiltInMetadata metadata -> f
    java.util.Set namespaces -> g
    30:85:void <init>() -> <init>
    37:51:java.nio.file.Path safeGetPath(java.net.URI) -> a
    88:94:boolean validateDirPath(java.nio.file.Path) -> b
    98:101:void pushRootPath(java.nio.file.Path) -> c
    104:107:void pushPathForType(net.minecraft.server.packs.PackType,java.nio.file.Path) -> b
    178:189:net.minecraft.server.packs.VanillaPackResources build(net.minecraft.server.packs.PackLocationInfo) -> a
    195:197:java.util.List copyAndReverse(java.util.Collection) -> a
    111:113:void lambda$pushJarResources$3(net.minecraft.server.packs.PackType,java.nio.file.Path) -> c
    105:105:java.util.Set lambda$pushPathForType$2(net.minecraft.server.packs.PackType) -> a
    55:78:com.google.common.collect.ImmutableMap lambda$static$1() -> c
    33:33:void lambda$static$0(net.minecraft.server.packs.VanillaPackResourcesBuilder) -> a
    31:54:void <clinit>() -> <clinit>
 */
class VanillaPackResourcesBuilder private constructor(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_VanillaPackResourcesBuilder)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = VanillaPackResourcesBuilder::class.classDesc
	}

	constructor() : this(clazz.getConstructor().newInstance())

	fun pushJarResources(): VanillaPackResourcesBuilder = VanillaPackResourcesBuilder(
		clazz.getMethod("a").invoke(around)
	)

	fun pushClasspathResources(packType: PackType, loaderClass: Class<*>): VanillaPackResourcesBuilder =
		VanillaPackResourcesBuilder(
			clazz.getMethod("a", PackType.clazz, Class::class.java)
				.invoke(around, packType.around, loaderClass)
		)

	fun applyDevelopmentConfig(): VanillaPackResourcesBuilder = VanillaPackResourcesBuilder(
		clazz.getMethod("b").invoke(around)
	)

	fun pushUniversalPath(path: Path): VanillaPackResourcesBuilder = VanillaPackResourcesBuilder(
		clazz.getMethod("a", Path::class.java)
			.invoke(around, path)
	)

	fun pushAssetPath(packType: PackType, path: Path): VanillaPackResourcesBuilder = VanillaPackResourcesBuilder(
		clazz.getMethod("a", PackType.clazz, Path::class.java)
			.invoke(around, packType.around, path)
	)

	fun setMetadata(builtInMetadata: BuiltInMetadata): VanillaPackResourcesBuilder = VanillaPackResourcesBuilder(
		clazz.getMethod("a", BuiltInMetadata.clazz)
			.invoke(around, builtInMetadata.around)
	)

	fun exposeNamespace(vararg namespaces: String): VanillaPackResourcesBuilder = VanillaPackResourcesBuilder(
		clazz.getMethod("a", String::class.java.arrayType())
			.invoke(around, namespaces)
	)

	fun build(packLocationInfo: PackLocationInfo): VanillaPackResources = VanillaPackResources(
		clazz.getMethod("a", PackLocationInfo.clazz)
			.invoke(around, packLocationInfo.around)
	)
}