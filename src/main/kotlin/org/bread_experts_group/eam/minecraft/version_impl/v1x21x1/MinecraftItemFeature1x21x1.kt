package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItem
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms.ItemFeatureTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.food.FoodProperties
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.Item
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.Items

class MinecraftItemFeature1x21x1 : MinecraftItemFeature() {
	override fun getTransformer(input: MinecraftItem): ItemFeatureTransform = ItemFeatureTransform(input)

	override fun register(id: Identifier, value: MinecraftItem): MinecraftItem {
		val mcItem = if (value::class == MinecraftItem::class) Item(
			Item.Properties()
				.stacksTo(64)
				.food(FoodProperties.Builder().nutrition(20).build())
		) else Item(getTransformer(value).build())
		Items.registerItem(ResourceLocation.parse("${id.namespace}:${id.subject}"), mcItem)
		return value
	}
}