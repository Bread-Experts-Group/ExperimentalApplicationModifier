package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.texture

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_texture_TextureManager
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.texture.TextureManager -> gqm:
# {"fileName":"TextureManager.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> b
    net.minecraft.resources.ResourceLocation INTENTIONAL_MISSING_TEXTURE -> a
    java.util.Map byPath -> c
    java.util.Set tickableTextures -> d
    java.util.Map prefixRegister -> e
    net.minecraft.server.packs.resources.ResourceManager resourceManager -> f
    34:43:void <init>(net.minecraft.server.packs.resources.ResourceManager) -> <init>
    46:53:void bindForSetup(net.minecraft.resources.ResourceLocation) -> a
    56:65:void _bind(net.minecraft.resources.ResourceLocation) -> d
    68:79:void register(net.minecraft.resources.ResourceLocation,net.minecraft.client.renderer.texture.AbstractTexture) -> a
    82:92:void safeClose(net.minecraft.resources.ResourceLocation,net.minecraft.client.renderer.texture.AbstractTexture) -> c
    96:109:net.minecraft.client.renderer.texture.AbstractTexture loadTexture(net.minecraft.resources.ResourceLocation,net.minecraft.client.renderer.texture.AbstractTexture) -> d
    114:121:net.minecraft.client.renderer.texture.AbstractTexture getTexture(net.minecraft.resources.ResourceLocation) -> b
    125:125:net.minecraft.client.renderer.texture.AbstractTexture getTexture(net.minecraft.resources.ResourceLocation,net.minecraft.client.renderer.texture.AbstractTexture) -> b
    130:141:net.minecraft.resources.ResourceLocation register(java.lang.String,net.minecraft.client.renderer.texture.DynamicTexture) -> a
    145:150:java.util.concurrent.CompletableFuture preload(net.minecraft.resources.ResourceLocation,java.util.concurrent.Executor) -> a
    154:155:void execute(java.lang.Runnable) -> a
    159:162:void tick() -> e
    165:169:void release(net.minecraft.resources.ResourceLocation) -> c
    173:177:void close() -> close
    181:203:java.util.concurrent.CompletableFuture reload(net.minecraft.server.packs.resources.PreparableReloadListener$PreparationBarrier,net.minecraft.server.packs.resources.ResourceManager,net.minecraft.util.profiling.ProfilerFiller,net.minecraft.util.profiling.ProfilerFiller,java.util.concurrent.Executor,java.util.concurrent.Executor) -> a
    207:214:void dumpAllSheets(java.nio.file.Path) -> a
    218:233:void _dumpAllSheets(java.nio.file.Path) -> b
    225:232:void lambda$_dumpAllSheets$8(java.nio.file.Path,net.minecraft.resources.ResourceLocation,net.minecraft.client.renderer.texture.AbstractTexture) -> a
    209:210:void lambda$dumpAllSheets$7(java.nio.file.Path) -> c
    201:201:void lambda$reload$6(java.lang.Runnable) -> b
    185:201:void lambda$reload$5(net.minecraft.server.packs.resources.ResourceManager,java.util.concurrent.Executor,java.util.concurrent.CompletableFuture,java.lang.Void) -> a
    200:200:void lambda$reload$4(java.util.concurrent.CompletableFuture) -> a
    154:154:void lambda$execute$3(java.lang.Runnable) -> c
    148:148:void lambda$preload$2(net.minecraft.resources.ResourceLocation,net.minecraft.client.renderer.texture.PreloadedTexture) -> a
    107:107:java.lang.String lambda$loadTexture$1(net.minecraft.client.renderer.texture.AbstractTexture) -> a
    48:49:void lambda$bindForSetup$0(net.minecraft.resources.ResourceLocation) -> e
    30:32:void <clinit>() -> <clinit>
 */
class TextureManager(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_texture_TextureManager)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = TextureManager::class.classDesc

		@JvmField
		var textureLock: Boolean = false
	}

	fun release(path: ResourceLocation) {
		clazz.getMethod("c", ResourceLocation.clazz)
			.invoke(around, path.around)
	}

	fun register(path: ResourceLocation, texture: AbstractTexture) {
		clazz.getMethod("a", ResourceLocation.clazz, AbstractTexture.clazz)
			.invoke(around, path.around, texture.around)
	}
}