package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.model.geom.EntityModelSet
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemDisplayContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_BlockEntityWithoutLevelRenderer
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer -> gem:
# {"fileName":"BlockEntityWithoutLevelRenderer.java","id":"sourceFile"}
    net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity[] SHULKER_BOXES -> a
    net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity DEFAULT_SHULKER_BOX -> b
    net.minecraft.world.level.block.entity.ChestBlockEntity chest -> c
    net.minecraft.world.level.block.entity.ChestBlockEntity trappedChest -> d
    net.minecraft.world.level.block.entity.EnderChestBlockEntity enderChest -> e
    net.minecraft.world.level.block.entity.BannerBlockEntity banner -> f
    net.minecraft.world.level.block.entity.BedBlockEntity bed -> g
    net.minecraft.world.level.block.entity.ConduitBlockEntity conduit -> h
    net.minecraft.world.level.block.entity.DecoratedPotBlockEntity decoratedPot -> i
    net.minecraft.client.model.ShieldModel shieldModel -> j
    net.minecraft.client.model.TridentModel tridentModel -> k
    java.util.Map skullModels -> l
    net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher blockEntityRenderDispatcher -> m
    net.minecraft.client.model.geom.EntityModelSet entityModelSet -> n
    56:74:void <init>(net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher,net.minecraft.client.model.geom.EntityModelSet) -> <init>
    78:81:void onResourceManagerReload(net.minecraft.server.packs.resources.ResourceManager) -> a
    84:163:void renderByItem(net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemDisplayContext,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int,int) -> a
    93:93:void lambda$renderByItem$2(net.minecraft.world.item.ItemStack,net.minecraft.world.item.component.ResolvableProfile) -> a
    53:53:net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity[] lambda$static$1(int) -> a
    53:53:net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity lambda$static$0(net.minecraft.world.item.DyeColor) -> a
    53:54:void <clinit>() -> <clinit>
 */
open class BlockEntityWithoutLevelRenderer(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_BlockEntityWithoutLevelRenderer)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockEntityWithoutLevelRenderer::class.classDesc
	}

	constructor(
		blockEntityRenderDispatcher: BlockEntityRenderDispatcher,
		entityModelSet: EntityModelSet
	) : this(clazz.getConstructor(BlockEntityRenderDispatcher.clazz, EntityModelSet.clazz)
		.newInstance(blockEntityRenderDispatcher.around, entityModelSet.around)
	)

	open fun renderByItem(
		stack: ItemStack,
		displayContext: ItemDisplayContext,
		poseStack: PoseStack,
		bufferSource: MultiBufferSource,
		packedLight: Int,
		packedOverlay: Int,
	) {}
}