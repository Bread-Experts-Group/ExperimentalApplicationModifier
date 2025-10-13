package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.renderer.blockentity

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_renderer_blockentity_BlockEntityRenderDispatcher
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher -> ggy:
# {"fileName":"BlockEntityRenderDispatcher.java","id":"sourceFile"}
    java.util.Map renderers -> d
    net.minecraft.client.gui.Font font -> e
    net.minecraft.client.model.geom.EntityModelSet entityModelSet -> f
    net.minecraft.world.level.Level level -> a
    net.minecraft.client.Camera camera -> b
    net.minecraft.world.phys.HitResult cameraHitResult -> c
    java.util.function.Supplier blockRenderDispatcher -> g
    java.util.function.Supplier itemRenderer -> h
    java.util.function.Supplier entityRenderer -> i
    30:48:void <init>(net.minecraft.client.gui.Font,net.minecraft.client.model.geom.EntityModelSet,java.util.function.Supplier,java.util.function.Supplier,java.util.function.Supplier) -> <init>
    53:53:net.minecraft.client.renderer.blockentity.BlockEntityRenderer getRenderer(net.minecraft.world.level.block.entity.BlockEntity) -> a
    57:62:void prepare(net.minecraft.world.level.Level,net.minecraft.client.Camera,net.minecraft.world.phys.HitResult) -> a
    65:80:void render(net.minecraft.world.level.block.entity.BlockEntity,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource) -> a
    84:91:void setupAndRender(net.minecraft.client.renderer.blockentity.BlockEntityRenderer,net.minecraft.world.level.block.entity.BlockEntity,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource) -> a
    94:99:boolean renderItem(net.minecraft.world.level.block.entity.BlockEntity,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int,int) -> a
    104:113:void tryRender(net.minecraft.world.level.block.entity.BlockEntity,java.lang.Runnable) -> a
    116:120:void setLevel(net.minecraft.world.level.Level) -> a
    124:126:void onResourceManagerReload(net.minecraft.server.packs.resources.ResourceManager) -> a
    98:98:void lambda$renderItem$1(net.minecraft.client.renderer.blockentity.BlockEntityRenderer,net.minecraft.world.level.block.entity.BlockEntity,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int,int) -> a
    79:79:void lambda$render$0(net.minecraft.client.renderer.blockentity.BlockEntityRenderer,net.minecraft.world.level.block.entity.BlockEntity,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource) -> b
 */
class BlockEntityRenderDispatcher(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_client_renderer_blockentity_BlockEntityRenderDispatcher
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
}