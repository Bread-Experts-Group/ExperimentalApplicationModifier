package org.bread_experts_group.eam.minecraft.test_mods.breadmod

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.ItemBlockRenderTypes
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.entity.ItemRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.BakedModel
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.ModelResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation

class TestBlockEntityRenderer(
	context: BlockEntityRendererProvider.Context
) : BlockEntityRenderer<TestBlockEntity>(context) {
	private val mainModel: BakedModel = Minecraft.getInstance().getModelManager().getModel(
		ModelResourceLocation("breadmod:item/tool_gun/item")
	)
	private val coilModel: BakedModel = Minecraft.getInstance().getModelManager().getModel(
		ModelResourceLocation("breadmod:item/tool_gun/coil")
	)

	override fun render(
		blockEntity: TestBlockEntity,
		partialTick: Float,
		poseStack: PoseStack,
		bufferSource: MultiBufferSource,
		packedLight: Int,
		packedOverlay: Int
	) {
		val itemRenderer = this.context.getItemRenderer()
		val noOverlay = 0 or 10 shl 16
		val fullBright = 15728880
		val stack = BuiltInRegistries.ITEM.get(ResourceLocation.parse("breadmod:tool_gun")).getDefaultInstance()
		val consumer = ItemRenderer.getFoilBufferDirect(
			bufferSource,
			ItemBlockRenderTypes.getRenderType(stack, false),
			true,
			stack.hasFoil()
		)

		poseStack.pushPose()
		poseStack.scale(2f, 2f, 2f)
		itemRenderer.renderModelLists(mainModel, stack, fullBright, noOverlay, poseStack, consumer)
		itemRenderer.renderModelLists(coilModel, stack, fullBright, noOverlay, poseStack, consumer)
		poseStack.popPose()
	}
}