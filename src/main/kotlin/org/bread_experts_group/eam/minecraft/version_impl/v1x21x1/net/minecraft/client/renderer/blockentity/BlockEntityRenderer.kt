package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_blockentity_BlockEntityRenderer
import java.lang.classfile.ClassFile.ACC_FINAL
import java.lang.classfile.ClassFile.ACC_PRIVATE
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

/*
net.minecraft.client.renderer.blockentity.BlockEntityRenderer -> ggz:
# {"fileName":"BlockEntityRenderer.java","id":"sourceFile"}
    void render(net.minecraft.world.level.block.entity.BlockEntity,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int,int) -> a
    12:12:boolean shouldRenderOffScreen(net.minecraft.world.level.block.entity.BlockEntity) -> a
    16:16:int getViewDistance() -> aW_
    20:20:boolean shouldRender(net.minecraft.world.level.block.entity.BlockEntity,net.minecraft.world.phys.Vec3) -> a
 */
abstract class BlockEntityRenderer<T : BlockEntity>(
	val context: BlockEntityRendererProvider.Context
) : MimickedClass(0) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_blockentity_BlockEntityRenderer)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockEntityRenderer::class.classDesc

		fun <T : BlockEntity> implementNative(renderer: BlockEntityRenderer<T>, blockEntityClass: Class<*>): BlockEntityRenderer<T> {
			renderer.around = renderer.implementNative(BlockEntityRenderer::class.java) { classBuilder, name ->
				classBuilder.withInterfaceSymbols(classDesc)
				classBuilder.withMethodBody(
					"a",
					MethodTypeDesc.of(
						ConstantDescs.CD_void,
						BlockEntity.classDesc,
						ConstantDescs.CD_float,
						PoseStack.classDesc,
						MultiBufferSource.classDesc,
						ConstantDescs.CD_int,
						ConstantDescs.CD_int
					),
					ACC_PUBLIC
				) { codeBuilder ->
					codeBuilder
						.getReferenceField(name, mimicClassDesc)
						.invokeSpecialNewMimic(blockEntityClass.classDesc, 1)
						.fload(2)
						.invokeSpecialNewMimic(PoseStack.mimicClassDesc, 3)
						.invokeSpecialNewMimic(MultiBufferSource.mimicClassDesc, 4)
						.iload(5)
						.iload(6)
						.invokevirtual(
							mimicClassDesc,
							"render",
							MethodTypeDesc.of(
								ConstantDescs.CD_void,
								BlockEntity.mimicClassDesc,
								ConstantDescs.CD_float,
								PoseStack.mimicClassDesc,
								MultiBufferSource.mimicClassDesc,
								ConstantDescs.CD_int,
								ConstantDescs.CD_int
							)
						)
						.return_()
				}
				classBuilder.withMethodBody(
					"<init>",
					MethodTypeDesc.of(ConstantDescs.CD_void, mimicClassDesc),
					ACC_PUBLIC
				) { codeBuilder ->
					codeBuilder
						.aload(0)
						.dup()
						.invokespecial(
							ConstantDescs.CD_Object,
							"<init>",
							MethodTypeDesc.of(ConstantDescs.CD_void)
						)
						.aload(1)
						.putfield(
							ClassDesc.of(name),
							"reference",
							mimicClassDesc
						)
						.return_()
				}
				classBuilder.withField(
					"reference",
					mimicClassDesc,
					ACC_FINAL or ACC_PRIVATE
				)
			}.newInstance(renderer)
			return renderer
		}
	}

	abstract fun render(
		blockEntity: T,
		partialTick: Float,
		poseStack: PoseStack,
		bufferSource: MultiBufferSource,
		packedLight: Int,
		packedOverlay: Int
	)
}