package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.eam.minecraft.MimicLookup
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Camera
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.Screen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.TitleScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.ModelBakery
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

object MimicLookup1x21x1 : MimicLookup() {
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
		Screen::class      -> net_minecraft_client_gui_screens_Screen
		TitleScreen::class -> net_minecraft_client_gui_screens_TitleScreen
		GuiGraphics::class -> net_minecraft_client_gui_GuiGraphics

		ModelBakery::class -> net_minecraft_client_resources_model_ModelBakery
		PoseStack::class -> com_mojang_blaze3d_vertex_PoseStack
		PoseStack.Pose::class -> com_mojang_blaze3d_vertex_PoseStack_Pose
		MultiBufferSource::class -> net_minecraft_client_renderer_MultiBufferSource
		else             -> throw IllegalStateException("Native class name for ${mimic.simpleName} not implemented.")
	}
}