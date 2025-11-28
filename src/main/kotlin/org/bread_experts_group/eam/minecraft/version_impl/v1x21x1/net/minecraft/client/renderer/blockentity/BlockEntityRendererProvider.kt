package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_blockentity_BlockEntityRendererProvider
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_blockentity_BlockEntityRendererProvider_Context
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider -> gha:
# {"fileName":"BlockEntityRendererProvider.java","id":"sourceFile"}
    net.minecraft.client.renderer.blockentity.BlockEntityRenderer create(net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context) -> create
 */
class BlockEntityRendererProvider<T : BlockEntity>(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_blockentity_BlockEntityRendererProvider)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockEntityRendererProvider::class.classDesc
	}
	/*
	net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context -> gha$a:
# {"fileName":"BlockEntityRendererProvider.java","id":"sourceFile"}
    net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher blockEntityRenderDispatcher -> a
    net.minecraft.client.renderer.block.BlockRenderDispatcher blockRenderDispatcher -> b
    net.minecraft.client.renderer.entity.ItemRenderer itemRenderer -> c
    net.minecraft.client.renderer.entity.EntityRenderDispatcher entityRenderer -> d
    net.minecraft.client.model.geom.EntityModelSet modelSet -> e
    net.minecraft.client.gui.Font font -> f
    22:29:void <init>(net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher,net.minecraft.client.renderer.block.BlockRenderDispatcher,net.minecraft.client.renderer.entity.ItemRenderer,net.minecraft.client.renderer.entity.EntityRenderDispatcher,net.minecraft.client.model.geom.EntityModelSet,net.minecraft.client.gui.Font) -> <init>
    32:32:net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher getBlockEntityRenderDispatcher() -> a
    36:36:net.minecraft.client.renderer.block.BlockRenderDispatcher getBlockRenderDispatcher() -> b
    40:40:net.minecraft.client.renderer.entity.EntityRenderDispatcher getEntityRenderer() -> c
    44:44:net.minecraft.client.renderer.entity.ItemRenderer getItemRenderer() -> d
    48:48:net.minecraft.client.model.geom.EntityModelSet getModelSet() -> e
    52:52:net.minecraft.client.model.geom.ModelPart bakeLayer(net.minecraft.client.model.geom.ModelLayerLocation) -> a
    56:56:net.minecraft.client.gui.Font getFont() -> f
	 */
	class Context(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_blockentity_BlockEntityRendererProvider_Context)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = Context::class.classDesc
		}
	}
}