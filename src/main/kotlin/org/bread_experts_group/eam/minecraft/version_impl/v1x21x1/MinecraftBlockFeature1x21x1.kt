package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms.BlockFeatureTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.food.FoodProperties
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.BlockItem
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.Item
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.Items
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.Block
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.Blocks
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.BlockBehaviour

class MinecraftBlockFeature1x21x1 : MinecraftBlockFeature() {
	override fun getTransformer(input: MinecraftBlock): BlockFeatureTransform = BlockFeatureTransform(input)

	override fun register(id: Identifier, value: MinecraftBlock): MinecraftBlock {
		val properties = BlockBehaviour.Properties.ofFullCopy(Blocks.Companion.HAY_BLOCK)
		val mcBlock = Block(properties)
		Blocks.register("${id.namespace}:${id.subject}", mcBlock)
		mcBlock.getStateDefinition().getPossibleStates().forEach { Block.Companion.BLOCK_STATE_REGISTRY.add(it) }
		val itemProperties = Item.Properties()
			.stacksTo(32)
			.food(
				FoodProperties.Builder()
					.nutrition(20)
					.build()
			)
		val blockItem = BlockItem(mcBlock, itemProperties)
		Items.registerBlock(blockItem)
		return value
	}
}