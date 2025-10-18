package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.entity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.VertexConsumer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.RenderType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.BakedModel
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemDisplayContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.Level
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_entity_ItemRenderer
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.entity.ItemRenderer -> glh:
# {"fileName":"ItemRenderer.java","id":"sourceFile"}
    net.minecraft.resources.ResourceLocation ENCHANTED_GLINT_ENTITY -> a
    net.minecraft.resources.ResourceLocation ENCHANTED_GLINT_ITEM -> b
    java.util.Set IGNORED -> k
    int GUI_SLOT_CENTER_X -> c
    int GUI_SLOT_CENTER_Y -> d
    int ITEM_COUNT_BLIT_OFFSET -> e
    float COMPASS_FOIL_UI_SCALE -> f
    float COMPASS_FOIL_FIRST_PERSON_SCALE -> g
    float COMPASS_FOIL_TEXTURE_SCALE -> h
    net.minecraft.client.resources.model.ModelResourceLocation TRIDENT_MODEL -> l
    net.minecraft.client.resources.model.ModelResourceLocation TRIDENT_IN_HAND_MODEL -> i
    net.minecraft.client.resources.model.ModelResourceLocation SPYGLASS_MODEL -> m
    net.minecraft.client.resources.model.ModelResourceLocation SPYGLASS_IN_HAND_MODEL -> j
    net.minecraft.client.Minecraft minecraft -> n
    net.minecraft.client.renderer.ItemModelShaper itemModelShaper -> o
    net.minecraft.client.renderer.texture.TextureManager textureManager -> p
    net.minecraft.client.color.item.ItemColors itemColors -> q
    net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer blockEntityRenderer -> r
    77:89:void <init>(net.minecraft.client.Minecraft,net.minecraft.client.renderer.texture.TextureManager,net.minecraft.client.resources.model.ModelManager,net.minecraft.client.color.item.ItemColors,net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer) -> <init>
    92:92:net.minecraft.client.renderer.ItemModelShaper getItemModelShaper() -> a
    97:105:void renderModelLists(net.minecraft.client.resources.model.BakedModel,net.minecraft.world.item.ItemStack,int,int,com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer) -> a
    108:162:void render(net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemDisplayContext,boolean,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int,int,net.minecraft.client.resources.model.BakedModel) -> a
    165:165:boolean hasAnimatedTexture(net.minecraft.world.item.ItemStack) -> a
    169:175:com.mojang.blaze3d.vertex.VertexConsumer getArmorFoilBuffer(net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.renderer.RenderType,boolean) -> a
    179:181:com.mojang.blaze3d.vertex.VertexConsumer getCompassFoilBuffer(net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.renderer.RenderType,com.mojang.blaze3d.vertex.PoseStack$Pose) -> a
    186:199:com.mojang.blaze3d.vertex.VertexConsumer getFoilBuffer(net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.renderer.RenderType,boolean,boolean) -> a
    213:229:void renderQuadList(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,java.util.List,net.minecraft.world.item.ItemStack,int,int) -> a
    234:246:net.minecraft.client.resources.model.BakedModel getModel(net.minecraft.world.item.ItemStack,net.minecraft.world.level.Level,net.minecraft.world.entity.LivingEntity,int) -> a
    250:251:void renderStatic(net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemDisplayContext,int,int,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.world.level.Level,int) -> a
    254:261:void renderStatic(net.minecraft.world.entity.LivingEntity,net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemDisplayContext,boolean,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.world.level.Level,int,int,int) -> a
    265:266:void onResourceManagerReload(net.minecraft.server.packs.resources.ResourceManager) -> a
    47:69:void <clinit>() -> <clinit>
net.minecraft.client.renderer.entity.LeashKnotRenderer -> gli:
# {"fileName":"LeashKnotRenderer.java","id":"sourceFile"}
    net.minecraft.resources.ResourceLocation KNOT_LOCATION -> a
    net.minecraft.client.model.LeashKnotModel model -> g
    18:20:void <init>(net.minecraft.client.renderer.entity.EntityRendererProvider$Context) -> <init>
    24:36:void render(net.minecraft.world.entity.decoration.LeashFenceKnotEntity,float,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int) -> a
    40:40:net.minecraft.resources.ResourceLocation getTextureLocation(net.minecraft.world.entity.decoration.LeashFenceKnotEntity) -> a
    12:12:net.minecraft.resources.ResourceLocation getTextureLocation(net.minecraft.world.entity.Entity) -> a
    12:12:void render(net.minecraft.world.entity.Entity,float,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int) -> a
    13:13:void <clinit>() -> <clinit>
net.minecraft.client.renderer.entity.LightningBoltRenderer -> glj:
# {"fileName":"LightningBoltRenderer.java","id":"sourceFile"}
    15:16:void <init>(net.minecraft.client.renderer.entity.EntityRendererProvider$Context) -> <init>
    20:82:void render(net.minecraft.world.entity.LightningBolt,float,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int) -> a
    85:120:void quad(org.joml.Matrix4f,com.mojang.blaze3d.vertex.VertexConsumer,float,float,int,float,float,float,float,float,float,float,boolean,boolean,boolean,boolean) -> a
    124:124:net.minecraft.resources.ResourceLocation getTextureLocation(net.minecraft.world.entity.LightningBolt) -> a
    13:13:net.minecraft.resources.ResourceLocation getTextureLocation(net.minecraft.world.entity.Entity) -> a
    13:13:void render(net.minecraft.world.entity.Entity,float,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int) -> a
net.minecraft.client.renderer.entity.LivingEntityRenderer -> glk:
# {"fileName":"LivingEntityRenderer.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> a
    float EYE_BED_OFFSET -> i
    net.minecraft.client.model.EntityModel model -> g
    java.util.List layers -> h
    36:42:void <init>(net.minecraft.client.renderer.entity.EntityRendererProvider$Context,net.minecraft.client.model.EntityModel,float) -> <init>
    45:45:boolean addLayer(net.minecraft.client.renderer.entity.layers.RenderLayer) -> a
    50:50:net.minecraft.client.model.EntityModel getModel() -> a
    55:156:void render(net.minecraft.world.entity.LivingEntity,float,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int) -> a
    160:170:net.minecraft.client.renderer.RenderType getRenderType(net.minecraft.world.entity.LivingEntity,boolean,boolean,boolean) -> a
    174:174:int getOverlayCoords(net.minecraft.world.entity.LivingEntity,float) -> c
    178:178:boolean isBodyVisible(net.minecraft.world.entity.LivingEntity) -> d
    182:192:float sleepDirectionToRotation(net.minecraft.core.Direction) -> a
    197:197:boolean isShaking(net.minecraft.world.entity.LivingEntity) -> a
    201:228:void setupRotations(net.minecraft.world.entity.LivingEntity,com.mojang.blaze3d.vertex.PoseStack,float,float,float,float) -> a
    231:231:float getAttackAnim(net.minecraft.world.entity.LivingEntity,float) -> d
    235:235:float getBob(net.minecraft.world.entity.LivingEntity,float) -> a
    239:239:float getFlipDegrees(net.minecraft.world.entity.LivingEntity) -> c
    243:243:float getWhiteOverlayProgress(net.minecraft.world.entity.LivingEntity,float) -> b
    247:247:void scale(net.minecraft.world.entity.LivingEntity,com.mojang.blaze3d.vertex.PoseStack,float) -> a
    251:278:boolean shouldShowName(net.minecraft.world.entity.LivingEntity) -> b
    282:288:boolean isEntityUpsideDown(net.minecraft.world.entity.LivingEntity) -> e
    293:293:float getShadowRadius(net.minecraft.world.entity.LivingEntity) -> f
    30:30:float getShadowRadius(net.minecraft.world.entity.Entity) -> c
    30:30:boolean shouldShowName(net.minecraft.world.entity.Entity) -> b
    30:30:void render(net.minecraft.world.entity.Entity,float,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,int) -> a
    31:31:void <clinit>() -> <clinit>
 */
class ItemRenderer(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_entity_ItemRenderer)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ItemRenderer::class.classDesc

		fun getFoilBufferDirect(
			bufferSource: MultiBufferSource,
			renderType: RenderType,
			noEntity: Boolean,
			withGlint: Boolean
		): VertexConsumer =
			VertexConsumer(
				clazz.getMethod(
					"b",
					MultiBufferSource.clazz,
					RenderType.clazz,
					Boolean::class.java,
					Boolean::class.java
				).invoke(null, bufferSource.around, renderType.around, noEntity, withGlint)
			)
	}

	fun renderStatic(
		stack: ItemStack,
		displayContext: ItemDisplayContext,
		combinedLight: Int,
		combinedOverlay: Int,
		poseStack: PoseStack,
		bufferSource: MultiBufferSource,
		level: Level?,
		seed: Int
	) {
		clazz.getMethod("a",
			ItemStack.clazz,
			ItemDisplayContext.clazz,
			Int::class.java,
			Int::class.java,
			PoseStack.clazz,
			MultiBufferSource.clazz,
			Level.clazz,
			Int::class.java
		).invoke(around, stack, displayContext, combinedLight, combinedOverlay, poseStack, bufferSource, level, seed)
	}

	// todo OVERRIDE ACCESS FLAGS ON NATIVE METHOD CAUSE THIS IS PRIVATE
	fun renderModelLists(
		model: BakedModel,
		stack: ItemStack,
		combinedLight: Int,
		combinedOverlay: Int,
		poseStack: PoseStack,
		vertexConsumer: VertexConsumer
	) {
		clazz.getMethod(
			"a",
			BakedModel.clazz,
			ItemStack.clazz,
			Int::class.java,
			Int::class.java,
			PoseStack.clazz,
			VertexConsumer.clazz
		).invoke(around, model.around, stack.around, combinedLight, combinedOverlay, poseStack.around, vertexConsumer.around)
	}
}