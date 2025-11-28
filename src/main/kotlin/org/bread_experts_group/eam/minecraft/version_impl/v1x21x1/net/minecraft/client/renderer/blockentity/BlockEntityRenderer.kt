package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_blockentity_BlockEntityRenderer
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.blockentity.BlockEntityRenderer -> ggz:
# {"fileName":"BlockEntityRenderer.java","id":"sourceFile"}
    void render(net.minecraft.world.level.block.entity.BlockEntity,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int,int) -> a
    12:12:boolean shouldRenderOffScreen(net.minecraft.world.level.block.entity.BlockEntity) -> a
    16:16:int getViewDistance() -> aW_
    20:20:boolean shouldRender(net.minecraft.world.level.block.entity.BlockEntity,net.minecraft.world.phys.Vec3) -> a
 */
class BlockEntityRenderer<T : BlockEntity> : MimickedClass(0) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_blockentity_BlockEntityRenderer)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockEntityRenderer::class.classDesc
	}
}