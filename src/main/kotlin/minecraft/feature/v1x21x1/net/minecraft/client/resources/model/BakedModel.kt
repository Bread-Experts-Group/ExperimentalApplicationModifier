package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_resources_model_BakedModel
import java.lang.constant.ClassDesc

/*
net.minecraft.client.resources.model.BakedModel -> gsm:
# {"fileName":"BakedModel.java","id":"sourceFile"}
    java.util.List getQuads(net.minecraft.world.level.block.state.BlockState,net.minecraft.core.Direction,net.minecraft.util.RandomSource) -> a
    boolean useAmbientOcclusion() -> a
    boolean isGui3d() -> b
    boolean usesBlockLight() -> c
    boolean isCustomRenderer() -> d
    net.minecraft.client.renderer.texture.TextureAtlasSprite getParticleIcon() -> e
    net.minecraft.client.renderer.block.model.ItemTransforms getTransforms() -> f
    net.minecraft.client.renderer.block.model.ItemOverrides getOverrides() -> g
 */
class BakedModel(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_client_resources_model_BakedModel)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
}