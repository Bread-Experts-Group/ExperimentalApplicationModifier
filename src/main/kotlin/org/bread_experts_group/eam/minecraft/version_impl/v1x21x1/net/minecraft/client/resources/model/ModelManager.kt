package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_resources_model_ModelManager
import java.lang.constant.ClassDesc

/*
net.minecraft.client.resources.model.ModelManager -> gst:
# {"fileName":"ModelManager.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> a
    java.util.Map VANILLA_ATLASES -> b
    java.util.Map bakedRegistry -> c
    net.minecraft.client.resources.model.AtlasSet atlases -> d
    net.minecraft.client.renderer.block.BlockModelShaper blockModelShaper -> e
    net.minecraft.client.color.block.BlockColors blockColors -> f
    int maxMipmapLevels -> g
    net.minecraft.client.resources.model.BakedModel missingModel -> h
    it.unimi.dsi.fastutil.objects.Object2IntMap modelGroups -> i
    63:68:void <init>(net.minecraft.client.renderer.texture.TextureManager,net.minecraft.client.color.block.BlockColors,int) -> <init>
    75:75:net.minecraft.client.resources.model.BakedModel getMissingModel() -> a
    79:79:net.minecraft.client.renderer.block.BlockModelShaper getBlockModelShaper() -> b
    84:95:java.util.concurrent.CompletableFuture reload(net.minecraft.server.packs.resources.PreparableReloadListener$PreparationBarrier,net.minecraft.server.packs.resources.ResourceManager,net.minecraft.util.profiling.ProfilerFiller,net.minecraft.util.profiling.ProfilerFiller,java.util.concurrent.Executor,java.util.concurrent.Executor) -> a
    99:100:java.util.concurrent.CompletableFuture loadBlockModels(net.minecraft.server.packs.resources.ResourceManager,java.util.concurrent.Executor) -> a
    117:118:java.util.concurrent.CompletableFuture loadBlockStates(net.minecraft.server.packs.resources.ResourceManager,java.util.concurrent.Executor) -> b
    140:175:net.minecraft.client.resources.model.ModelManager$ReloadState loadModels(net.minecraft.util.profiling.ProfilerFiller,java.util.Map,net.minecraft.client.resources.model.ModelBakery) -> a
    179:193:void apply(net.minecraft.client.resources.model.ModelManager$ReloadState,net.minecraft.util.profiling.ProfilerFiller) -> a
    196:209:boolean requiresRender(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState) -> a
    213:213:net.minecraft.client.renderer.texture.TextureAtlas getAtlas(net.minecraft.resources.ResourceLocation) -> a
    218:219:void close() -> close
    222:223:void updateMaxMipLevel(int) -> a
    172:172:java.util.concurrent.CompletableFuture[] lambda$loadModels$19(int) -> b
    166:169:void lambda$loadModels$18(java.util.Map,net.minecraft.client.resources.model.BakedModel,java.util.Map,net.minecraft.world.level.block.state.BlockState) -> a
    156:156:void lambda$loadModels$17(net.minecraft.client.resources.model.ModelResourceLocation,java.util.Collection) -> a
    156:156:java.lang.String lambda$loadModels$16(net.minecraft.client.resources.model.Material) -> a
    146:152:net.minecraft.client.renderer.texture.TextureAtlasSprite lambda$loadModels$15(java.util.Map,com.google.common.collect.Multimap,net.minecraft.client.resources.model.ModelResourceLocation,net.minecraft.client.resources.model.Material) -> a
    119:135:java.util.concurrent.CompletionStage lambda$loadBlockStates$14(java.util.concurrent.Executor,java.util.Map) -> a
    135:135:java.util.Map lambda$loadBlockStates$13(java.util.List) -> a
    122:132:com.mojang.datafixers.util.Pair lambda$loadBlockStates$12(java.util.Map$Entry) -> a
    117:117:java.util.Map lambda$loadBlockStates$11(net.minecraft.server.packs.resources.ResourceManager) -> a
    101:112:java.util.concurrent.CompletionStage lambda$loadBlockModels$10(java.util.concurrent.Executor,java.util.Map) -> b
    112:112:java.util.Map lambda$loadBlockModels$9(java.util.List) -> b
    104:108:com.mojang.datafixers.util.Pair lambda$loadBlockModels$8(java.util.Map$Entry) -> b
    99:99:java.util.Map lambda$loadBlockModels$7(net.minecraft.server.packs.resources.ResourceManager) -> b
    95:95:void lambda$reload$6(net.minecraft.util.profiling.ProfilerFiller,net.minecraft.client.resources.model.ModelManager$ReloadState) -> a
    93:93:java.util.concurrent.CompletionStage lambda$reload$5(net.minecraft.client.resources.model.ModelManager$ReloadState) -> a
    93:93:net.minecraft.client.resources.model.ModelManager$ReloadState lambda$reload$4(net.minecraft.client.resources.model.ModelManager$ReloadState,java.lang.Void) -> a
    92:92:net.minecraft.client.resources.model.ModelManager$ReloadState lambda$reload$3(net.minecraft.util.profiling.ProfilerFiller,java.util.Map,java.util.concurrent.CompletableFuture,java.lang.Void) -> a
    92:92:net.minecraft.client.resources.model.AtlasSet$StitchResult lambda$reload$2(java.util.Map$Entry) -> c
    91:91:java.util.concurrent.CompletableFuture[] lambda$reload$1(int) -> c
    87:87:net.minecraft.client.resources.model.ModelBakery lambda$reload$0(net.minecraft.util.profiling.ProfilerFiller,java.util.Map,java.util.Map) -> a
    41:52:void <clinit>() -> <clinit>
 */
class ModelManager(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_resources_model_ModelManager)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ModelManager::class.classDesc
	}

	fun getModel(modelLocation: ModelResourceLocation): BakedModel = BakedModel(
		clazz.getMethod("a", ModelResourceLocation.clazz)
			.invoke(around, modelLocation.around)
	)
}