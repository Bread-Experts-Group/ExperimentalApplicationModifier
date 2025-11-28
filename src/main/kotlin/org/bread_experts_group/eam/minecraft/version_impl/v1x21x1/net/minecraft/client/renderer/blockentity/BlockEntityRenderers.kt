package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntityType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_blockentity_BlockEntityRenderers
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.blockentity.BlockEntityRenderers -> ghb:
# {"fileName":"BlockEntityRenderers.java","id":"sourceFile"}
    java.util.Map PROVIDERS -> a
    11:11:void <init>() -> <init>
    42:43:void register(net.minecraft.world.level.block.entity.BlockEntityType,net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider) -> a
    46:54:java.util.Map createEntityRenderers(net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context) -> a
    49:53:void lambda$createEntityRenderers$0(com.google.common.collect.ImmutableMap$Builder,net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context,net.minecraft.world.level.block.entity.BlockEntityType,net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider) -> a
    12:39:void <clinit>() -> <clinit>
 */
class BlockEntityRenderers(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_blockentity_BlockEntityRenderers)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockEntityRenderers::class.classDesc

		fun <T : BlockEntity> register(type: BlockEntityType<T>, provider: BlockEntityRendererProvider<T>) {
			clazz.getMethod("a", BlockEntityType.clazz, BlockEntityRendererProvider.clazz)
				.invoke(null, type.around, provider.around)
		}
	}
}