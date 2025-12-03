package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.eam.minecraft.mimic.NativeLookup
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.pipeline.RenderCall
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.platform.Window
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.systems.RenderSystem
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.VertexConsumer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.math.Axis
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Camera
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.Font
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.Gui
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.LayeredDraw
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.Screen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.TitleScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.main.GameConfig
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.model.geom.EntityModelSet
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.multiplayer.ClientLevel
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.player.AbstractClientPlayer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.player.LocalPlayer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.ItemBlockRenderTypes
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.RenderType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRenderers
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.entity.ItemRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.texture.AbstractTexture
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.texture.Tickable
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.ClientPackSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.BakedModel
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.ModelBakery
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.ModelManager
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.ModelResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.UnbakedModel
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.sounds.SoundEvent
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.sounds.SoundEvents
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.sounds.SoundSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.BlockPos
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.DefaultedRegistry
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.Holder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.IdMapper
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.Registry
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.registries.Registries
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.MutableComponent
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceKey
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.VanillaPackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.BuiltInPackSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.FolderRepositorySource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.Pack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.PackRepository
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.PackSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.RepositorySource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.resources.ResourceManager
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.InteractionResult
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity.Entity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity.LivingEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity.player.Player
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.food.FoodProperties
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.BlockItem
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.CreativeModeTab
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.CreativeModeTabs
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.Item
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemDisplayContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.Items
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.context.UseOnContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.Level
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.Block
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.Blocks
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.EntityBlock
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntityType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.BlockBehaviour
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.BlockState
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.StateDefinition
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.validation.DirectoryValidator
import kotlin.reflect.KClass

object NativeLookupV1x21x1 : NativeLookup() {
	override fun resolveNativeNameFromMimic(mimic: KClass<*>): String = when (mimic) {
		Component::class -> net_minecraft_network_chat_Component
		MutableComponent::class -> net_minecraft_network_chat_MutableComponent
		ResourceLocation::class -> net_minecraft_resources_ResourceLocation
		ResourceKey::class -> net_minecraft_resources_ResourceKey
		Registry::class -> net_minecraft_core_Registry
		DefaultedRegistry::class -> net_minecraft_core_DefaultedRegistry
		Registries::class -> net_minecraft_core_registries_Registries
		BuiltInRegistries::class -> net_minecraft_core_registries_BuiltInRegistries
		Holder.Reference::class -> net_minecraft_core_Holder_Reference
		BlockPos::class -> net_minecraft_core_BlockPos
		Block::class -> net_minecraft_world_level_block_Block
		BlockBehaviour::class -> net_minecraft_world_level_block_state_BlockBehaviour
		BlockBehaviour.Properties::class -> net_minecraft_world_level_block_state_BlockBehaviour_Properties
		Blocks::class -> net_minecraft_world_level_block_Blocks
		Level::class -> net_minecraft_world_level_Level
		Entity::class -> net_minecraft_world_entity_Entity
		LivingEntity::class -> net_minecraft_world_entity_LivingEntity
		Player::class -> net_minecraft_world_entity_player_Player
		IdMapper::class -> net_minecraft_core_IdMapper
		EntityBlock::class -> net_minecraft_world_level_block_EntityBlock
		BlockState::class -> net_minecraft_world_level_block_state_BlockState
		StateDefinition::class -> net_minecraft_world_level_block_state_StateDefinition
		BlockEntityType::class -> net_minecraft_world_level_block_entity_BlockEntityType
		BlockEntityType.BlockEntitySupplier::class -> net_minecraft_world_level_block_entity_BlockEntityType_BlockEntitySupplier
		BlockEntityType.Builder::class -> net_minecraft_world_level_block_entity_BlockEntityType_Builder
		BlockEntity::class -> net_minecraft_world_level_block_entity_BlockEntity
		Item.Properties::class -> net_minecraft_world_item_Item_Properties
		Item::class -> net_minecraft_world_item_Item
		BlockItem::class -> net_minecraft_world_item_BlockItem
		Items::class -> net_minecraft_world_item_Items
		ItemStack::class -> net_minecraft_world_item_ItemStack
		CreativeModeTabs::class -> net_minecraft_world_item_CreativeModeTabs
		CreativeModeTab::class -> net_minecraft_world_item_CreativeModeTab
		CreativeModeTab.Builder::class -> net_minecraft_world_item_CreativeModeTab_Builder
		CreativeModeTab.DisplayItemsGenerator::class -> net_minecraft_world_item_CreativeModeTab_DisplayItemsGenerator
		CreativeModeTab.ItemDisplayParameters::class -> net_minecraft_world_item_CreativeModeTab_ItemDisplayParameters
		CreativeModeTab.Output::class -> net_minecraft_world_item_CreativeModeTab_Output
		CreativeModeTab.Row::class -> net_minecraft_world_item_CreativeModeTab_Row
		CreativeModeTab.Type::class -> net_minecraft_world_item_CreativeModeTab_Type
		UseOnContext::class -> net_minecraft_world_item_context_UseOnContext
		ItemDisplayContext::class -> net_minecraft_world_item_ItemDisplayContext
		FoodProperties::class -> net_minecraft_world_food_FoodProperties
		FoodProperties.Builder::class -> net_minecraft_world_food_FoodProperties_Builder
		InteractionResult::class -> net_minecraft_world_InteractionResult
		DirectoryValidator::class -> net_minecraft_world_level_validation_DirectoryValidator
		DeltaTracker::class -> net_minecraft_client_DeltaTracker
		MouseHandler::class -> net_minecraft_client_MouseHandler
		Camera::class -> net_minecraft_client_Camera
		Screen::class -> net_minecraft_client_gui_screens_Screen
		TitleScreen::class -> net_minecraft_client_gui_screens_TitleScreen
		GuiGraphics::class -> net_minecraft_client_gui_GuiGraphics
		LayeredDraw::class -> net_minecraft_client_gui_LayeredDraw
		LayeredDraw.Layer::class -> net_minecraft_client_gui_LayeredDraw_Layer
		Gui::class -> net_minecraft_client_gui_Gui
		CreativeModeInventoryScreen::class -> net_minecraft_client_gui_screens_inventory_CreativeModeInventoryScreen
		AbstractTexture::class -> net_minecraft_client_renderer_texture_AbstractTexture
		Tickable::class -> net_minecraft_client_renderer_texture_Tickable
		BlockEntityWithoutLevelRenderer::class -> net_minecraft_client_renderer_BlockEntityWithoutLevelRenderer
		ItemRenderer::class -> net_minecraft_client_renderer_entity_ItemRenderer
		MultiBufferSource::class -> net_minecraft_client_renderer_MultiBufferSource
		RenderType::class -> net_minecraft_client_renderer_RenderType
		BlockEntityRenderer::class -> net_minecraft_client_renderer_blockentity_BlockEntityRenderer
		BlockEntityRendererProvider::class -> net_minecraft_client_renderer_blockentity_BlockEntityRendererProvider
		BlockEntityRendererProvider.Context::class -> net_minecraft_client_renderer_blockentity_BlockEntityRendererProvider_Context
		BlockEntityRenderDispatcher::class -> net_minecraft_client_renderer_blockentity_BlockEntityRenderDispatcher
		BlockEntityRenderers::class -> net_minecraft_client_renderer_blockentity_BlockEntityRenderers
		ItemBlockRenderTypes::class -> net_minecraft_client_renderer_ItemBlockRenderTypes
		BakedModel::class -> net_minecraft_client_resources_model_BakedModel
		ModelManager::class -> net_minecraft_client_resources_model_ModelManager
		ModelResourceLocation::class -> net_minecraft_client_resources_model_ModelResourceLocation
		ModelBakery::class -> net_minecraft_client_resources_model_ModelBakery
		ClientPackSource::class -> net_minecraft_client_resources_ClientPackSource
		GameConfig::class -> net_minecraft_client_main_GameConfig
		UnbakedModel::class -> net_minecraft_client_resources_model_UnbakedModel
		ClientLevel::class -> net_minecraft_client_multiplayer_ClientLevel
		EntityModelSet::class -> net_minecraft_client_model_geom_EntityModelSet
		AbstractClientPlayer::class -> net_minecraft_client_player_AbstractClientPlayer
		LocalPlayer::class -> net_minecraft_client_player_LocalPlayer
		ResourceManager::class -> net_minecraft_server_packs_resources_ResourceManager
		PackType::class -> net_minecraft_server_packs_PackType
		PackResources::class -> net_minecraft_server_packs_PackResources
		VanillaPackResources::class -> net_minecraft_server_packs_VanillaPackResources
		PackRepository::class -> net_minecraft_server_packs_repository_PackRepository
		FolderRepositorySource::class -> net_minecraft_server_packs_repository_FolderRepositorySource
		RepositorySource::class -> net_minecraft_server_packs_repository_RepositorySource
		BuiltInPackSource::class -> net_minecraft_server_packs_repository_BuiltInPackSource
		Pack::class -> net_minecraft_server_packs_repository_Pack
		Pack.ResourcesSupplier::class -> net_minecraft_server_packs_repository_Pack_ResourcesSupplier
		PackSource::class -> net_minecraft_server_packs_repository_PackSource
		SoundEvent::class -> net_minecraft_sounds_SoundEvent
		SoundEvents::class -> net_minecraft_sounds_SoundEvents
		SoundSource::class -> net_minecraft_sounds_SoundSource
		Font::class -> net_minecraft_client_gui_Font
		Minecraft::class -> net_minecraft_client_Minecraft
		PoseStack::class -> com_mojang_blaze3d_vertex_PoseStack
		PoseStack.Pose::class -> com_mojang_blaze3d_vertex_PoseStack_Pose
		Window::class -> com_mojang_blaze3d_platform_Window
		VertexConsumer::class -> com_mojang_blaze3d_vertex_VertexConsumer
		Axis::class -> com_mojang_math_Axis
		RenderSystem::class -> com_mojang_blaze3d_systems_RenderSystem
		RenderCall::class -> com_mojang_blaze3d_pipeline_RenderCall

		else             -> throw IllegalStateException("Native class name for ${mimic.simpleName} not implemented.")
	}
}