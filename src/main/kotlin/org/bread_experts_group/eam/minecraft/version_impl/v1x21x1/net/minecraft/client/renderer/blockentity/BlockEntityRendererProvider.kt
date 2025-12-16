package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_blockentity_BlockEntityRendererProvider
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_blockentity_BlockEntityRendererProvider_Context
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.entity.ItemRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntity
import java.lang.classfile.ClassFile.ACC_FINAL
import java.lang.classfile.ClassFile.ACC_PRIVATE
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

/*
net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider -> gha:
# {"fileName":"BlockEntityRendererProvider.java","id":"sourceFile"}
    net.minecraft.client.renderer.blockentity.BlockEntityRenderer create(net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider$Context) -> create
 */
class BlockEntityRendererProvider<T : BlockEntity>(
	private val rendererProvider: (Context) -> BlockEntityRenderer<T>
) : MimickedClass(0) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_blockentity_BlockEntityRendererProvider)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockEntityRendererProvider::class.classDesc
	}

	init {
		this.around = createNative(BlockEntityRendererProvider::class.java) { classBuilder, name ->
			classBuilder.withInterfaceSymbols(classDesc)
			classBuilder.withMethodBody(
				"create",
				MethodTypeDesc.of(
					BlockEntityRenderer.classDesc,
					Context.classDesc
				),
				ACC_PUBLIC
			) { codeBuilder ->
				codeBuilder
					.getReferenceField(name, mimicClassDesc)
					.invokeSpecialNewMimic(Context.mimicClassDesc, 1)
					.invokevirtual(
						mimicClassDesc,
						"create",
						MethodTypeDesc.of(
							BlockEntityRenderer.mimicClassDesc,
							Context.mimicClassDesc
						)
					)
					.getfield(
						BlockEntityRenderer.mimicClassDesc,
						"around",
						ConstantDescs.CD_Object
					)
					.checkcast(BlockEntityRenderer.classDesc)
					.areturn()
			}
			classBuilder.withMethodBody(
				"<init>",
				MethodTypeDesc.of(
					ConstantDescs.CD_void, mimicClassDesc
				),
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
		}.newInstance(this)
	}

	fun create(context: Context): BlockEntityRenderer<T> = this.rendererProvider(context)
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

		fun getBlockEntityRenderDispatcher(): BlockEntityRenderDispatcher = BlockEntityRenderDispatcher(
			clazz.getMethod("a").invoke(around)
		)

		fun getItemRenderer(): ItemRenderer = ItemRenderer(clazz.getMethod("d").invoke(around))
	}
}