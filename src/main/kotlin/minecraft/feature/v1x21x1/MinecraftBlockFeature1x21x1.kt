package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.api.ImplementationSource
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.food.FoodProperties
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.BlockItem
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.Item
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.Items
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.Block
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.Blocks
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.state.BlockBehaviour

class MinecraftBlockFeature1x21x1 : MinecraftBlockFeature() {
	override val source: ImplementationSource = ImplementationSource.JVM_NATIVE
	override val expresses: FeatureExpression<MinecraftBlockFeature> = MinecraftFeatures.BLOCK

	override fun register(id: Identifier, block: MinecraftBlock): MinecraftBlock {
		val properties = BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)
		val mcBlock = Block(properties)
		Blocks.register("${id.namespace}:${id.subject}", mcBlock)
		mcBlock.getStateDefinition().getPossibleStates().forEach {
			Block.BLOCK_STATE_REGISTRY.add(it)
		}
		val itemProperties = Item.Properties()
			.stacksTo(32)
			.food(
				FoodProperties.Builder()
					.nutrition(20)
					.build()
			)
		val blockItem = BlockItem(
			mcBlock,
			itemProperties
		)
		Items.registerBlock(blockItem)
		return block
	}
}