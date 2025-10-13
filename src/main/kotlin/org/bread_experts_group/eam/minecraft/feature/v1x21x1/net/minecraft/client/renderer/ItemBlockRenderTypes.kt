package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_renderer_ItemBlockRenderTypes

/*
net.minecraft.client.renderer.ItemBlockRenderTypes -> geu:
# {"fileName":"ItemBlockRenderTypes.java","id":"sourceFile"}
    java.util.Map TYPE_BY_BLOCK -> a
    java.util.Map TYPE_BY_FLUID -> b
    boolean renderCutout -> c
    21:21:void <init>() -> <init>
    374:382:net.minecraft.client.renderer.RenderType getChunkRenderType(net.minecraft.world.level.block.state.BlockState) -> a
    386:397:net.minecraft.client.renderer.RenderType getMovingBlockRenderType(net.minecraft.world.level.block.state.BlockState) -> b
    401:408:net.minecraft.client.renderer.RenderType getRenderType(net.minecraft.world.level.block.state.BlockState,boolean) -> a
    412:417:net.minecraft.client.renderer.RenderType getRenderType(net.minecraft.world.item.ItemStack,boolean) -> a
    421:425:net.minecraft.client.renderer.RenderType getRenderLayer(net.minecraft.world.level.material.FluidState) -> a
    429:430:void setFancy(boolean) -> a
    366:369:void lambda$static$1(java.util.HashMap) -> a
    23:363:void lambda$static$0(java.util.HashMap) -> b
    22:365:void <clinit>() -> <clinit>
 */
class ItemBlockRenderTypes(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_client_renderer_ItemBlockRenderTypes
		)

		fun getRenderType(stack: ItemStack, cull: Boolean): RenderType = RenderType(
			clazz.getMethod("a", ItemStack.clazz, Boolean::class.java)
				.invoke(null, stack.around, cull)
		)
	}
}