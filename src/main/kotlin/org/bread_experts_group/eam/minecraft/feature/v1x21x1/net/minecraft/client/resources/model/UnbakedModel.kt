package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_resources_model_UnbakedModel
import java.lang.constant.ClassDesc

/*
net.minecraft.client.resources.model.UnbakedModel -> gsy:
# {"fileName":"UnbakedModel.java","id":"sourceFile"}
    java.util.Collection getDependencies() -> f
    void resolveParents(java.util.function.Function) -> a
    net.minecraft.client.resources.model.BakedModel bake(net.minecraft.client.resources.model.ModelBaker,java.util.function.Function,net.minecraft.client.resources.model.ModelState) -> a
net.minecraft.client.resources.model.WeightedBakedModel -> gsz:
# {"fileName":"WeightedBakedModel.java","id":"sourceFile"}
    int totalWeight -> a
    java.util.List list -> b
    net.minecraft.client.resources.model.BakedModel wrapped -> c
    23:27:void <init>(java.util.List) -> <init>
    31:33:java.util.List getQuads(net.minecraft.world.level.block.state.BlockState,net.minecraft.core.Direction,net.minecraft.util.RandomSource) -> a
    38:38:boolean useAmbientOcclusion() -> a
    43:43:boolean isGui3d() -> b
    48:48:boolean usesBlockLight() -> c
    53:53:boolean isCustomRenderer() -> d
    58:58:net.minecraft.client.renderer.texture.TextureAtlasSprite getParticleIcon() -> e
    63:63:net.minecraft.client.renderer.block.model.ItemTransforms getTransforms() -> f
    68:68:net.minecraft.client.renderer.block.model.ItemOverrides getOverrides() -> g
    32:32:java.util.List lambda$getQuads$0(net.minecraft.world.level.block.state.BlockState,net.minecraft.core.Direction,net.minecraft.util.RandomSource,net.minecraft.util.random.WeightedEntry$Wrapper) -> a
net.minecraft.client.resources.model.WeightedBakedModel$Builder -> gsz$a:
# {"fileName":"WeightedBakedModel.java","id":"sourceFile"}
    java.util.List list -> a
    71:72:void <init>() -> <init>
    75:78:net.minecraft.client.resources.model.WeightedBakedModel$Builder add(net.minecraft.client.resources.model.BakedModel,int) -> a
    83:89:net.minecraft.client.resources.model.BakedModel build() -> a
 */
class UnbakedModel(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_client_resources_model_UnbakedModel
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
}