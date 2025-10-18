package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_resources_model_ModelBakery
import java.lang.constant.ClassDesc

/*
net.minecraft.client.resources.model.ModelBakery -> gss:
# {"fileName":"ModelBakery.java","id":"sourceFile"}
    net.minecraft.client.resources.model.Material FIRE_0 -> a
    net.minecraft.client.resources.model.Material FIRE_1 -> b
    net.minecraft.client.resources.model.Material LAVA_FLOW -> c
    net.minecraft.client.resources.model.Material WATER_FLOW -> d
    net.minecraft.client.resources.model.Material WATER_OVERLAY -> e
    net.minecraft.client.resources.model.Material BANNER_BASE -> f
    net.minecraft.client.resources.model.Material SHIELD_BASE -> g
    net.minecraft.client.resources.model.Material NO_PATTERN_SHIELD -> h
    int DESTROY_STAGE_COUNT -> i
    java.util.List DESTROY_STAGES -> j
    java.util.List BREAKING_LOCATIONS -> k
    java.util.List DESTROY_TYPES -> l
    org.slf4j.Logger LOGGER -> s
    java.lang.String BUILTIN_SLASH -> t
    java.lang.String BUILTIN_SLASH_GENERATED -> u
    java.lang.String BUILTIN_BLOCK_ENTITY -> v
    java.lang.String MISSING_MODEL_NAME -> w
    net.minecraft.resources.ResourceLocation MISSING_MODEL_LOCATION -> m
    net.minecraft.client.resources.model.ModelResourceLocation MISSING_MODEL_VARIANT -> n
    net.minecraft.resources.FileToIdConverter MODEL_LISTER -> o
    java.lang.String MISSING_MODEL_MESH -> p
    java.util.Map BUILTIN_MODELS -> x
    net.minecraft.client.renderer.block.model.BlockModel GENERATION_MARKER -> q
    net.minecraft.client.renderer.block.model.BlockModel BLOCK_ENTITY_MARKER -> r
    net.minecraft.client.renderer.block.model.ItemModelGenerator ITEM_MODEL_GENERATOR -> y
    java.util.Map modelResources -> z
    java.util.Set loadingStack -> A
    java.util.Map unbakedCache -> B
    java.util.Map bakedCache -> C
    java.util.Map topLevelModels -> D
    java.util.Map bakedTopLevelModels -> E
    net.minecraft.client.resources.model.UnbakedModel missingModel -> F
    it.unimi.dsi.fastutil.objects.Object2IntMap modelGroups -> G
    99:143:void <init>(net.minecraft.client.color.block.BlockColors,net.minecraft.util.profiling.ProfilerFiller,java.util.Map,java.util.Map) -> <init>
    146:158:void bakeModels(net.minecraft.client.resources.model.ModelBakery$TextureGetter) -> a
    189:193:void loadItemModelAndDependencies(net.minecraft.resources.ResourceLocation) -> b
    196:199:void loadSpecialItemModelAndDependencies(net.minecraft.client.resources.model.ModelResourceLocation) -> a
    202:206:void registerModelAndLoadDependencies(net.minecraft.client.resources.model.ModelResourceLocation,net.minecraft.client.resources.model.UnbakedModel) -> a
    209:210:void registerModel(net.minecraft.client.resources.model.ModelResourceLocation,net.minecraft.client.resources.model.UnbakedModel) -> b
    252:277:net.minecraft.client.renderer.block.model.BlockModel loadBlockModel(net.minecraft.resources.ResourceLocation) -> c
    282:282:java.util.Map getBakedTopLevelModels() -> a
    286:286:it.unimi.dsi.fastutil.objects.Object2IntMap getModelGroups() -> b
    147:157:void lambda$bakeModels$6(net.minecraft.client.resources.model.ModelBakery$TextureGetter,net.minecraft.client.resources.model.ModelResourceLocation,net.minecraft.client.resources.model.UnbakedModel) -> a
    141:141:void lambda$new$5(net.minecraft.client.resources.model.UnbakedModel) -> a
    94:94:void lambda$static$4(net.minecraft.client.renderer.block.model.BlockModel) -> a
    93:93:void lambda$static$3(net.minecraft.client.renderer.block.model.BlockModel) -> b
    53:53:net.minecraft.resources.ResourceLocation lambda$static$2(net.minecraft.resources.ResourceLocation) -> d
    53:53:java.lang.String lambda$static$1(java.lang.String) -> a
    50:50:net.minecraft.resources.ResourceLocation lambda$static$0(int) -> a
    39:95:void <clinit>() -> <clinit>
net.minecraft.client.resources.model.ModelBakery$BakedCacheKey -> gss$a:
# {"fileName":"ModelBakery.java","id":"sourceFile"}
    net.minecraft.resources.ResourceLocation id -> a
    com.mojang.math.Transformation transformation -> b
    boolean isUvLocked -> c
    289:289:void <init>(net.minecraft.resources.ResourceLocation,com.mojang.math.Transformation,boolean) -> <init>
    289:289:java.lang.String toString() -> toString
    289:289:int hashCode() -> hashCode
    289:289:boolean equals(java.lang.Object) -> equals
    289:289:net.minecraft.resources.ResourceLocation id() -> a
    289:289:com.mojang.math.Transformation transformation() -> b
    289:289:com.mojang.math.Transformation transformation() -> b
    289:289:boolean isUvLocked() -> c
net.minecraft.client.resources.model.ModelBakery$ModelBakerImpl -> gss$b:
# {"fileName":"ModelBakery.java","id":"sourceFile"}
    java.util.function.Function modelTextureGetter -> b
    net.minecraft.client.resources.model.ModelBakery this$0 -> a
    215:217:void <init>(net.minecraft.client.resources.model.ModelBakery,net.minecraft.client.resources.model.ModelBakery$TextureGetter,net.minecraft.client.resources.model.ModelResourceLocation) -> <init>
    221:221:net.minecraft.client.resources.model.UnbakedModel getModel(net.minecraft.resources.ResourceLocation) -> a
    226:237:net.minecraft.client.resources.model.BakedModel bake(net.minecraft.resources.ResourceLocation,net.minecraft.client.resources.model.ModelState) -> a
    242:247:net.minecraft.client.resources.model.BakedModel bakeUncached(net.minecraft.client.resources.model.UnbakedModel,net.minecraft.client.resources.model.ModelState) -> a
    216:216:net.minecraft.client.renderer.texture.TextureAtlasSprite lambda$new$0(net.minecraft.client.resources.model.ModelBakery$TextureGetter,net.minecraft.client.resources.model.ModelResourceLocation,net.minecraft.client.resources.model.Material) -> a
net.minecraft.client.resources.model.ModelBakery$TextureGetter -> gss$c:
# {"fileName":"ModelBakery.java","id":"sourceFile"}
    net.minecraft.client.renderer.texture.TextureAtlasSprite get(net.minecraft.client.resources.model.ModelResourceLocation,net.minecraft.client.resources.model.Material) -> get
 */
class ModelBakery(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_resources_model_ModelBakery)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ModelBakery::class.classDesc
	}

	fun getModel(location: String): UnbakedModel =
		this.getModel(ResourceLocation.parse(location))

	fun getModel(arg: ResourceLocation): UnbakedModel = UnbakedModel(
		clazz.getMethod("a", ResourceLocation.clazz)
			.invoke(around, arg.around)
	)

	fun registerModelAndLoadDependencies(location: ModelResourceLocation, unbaked: UnbakedModel) {
		clazz.getMethod("a", ModelResourceLocation.clazz, UnbakedModel.clazz)
			.invoke(around, location.around, unbaked.around)
	}
}