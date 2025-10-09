package org.bread_experts_group.eam.minecraft.feature.breadmod

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItem
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayer
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayerFeature
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.InteractionResult
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.context.UseOnContext
import java.awt.Color

class BreadMod : MinecraftMod() {
	override fun addBlocks(blocks: MinecraftBlockFeature) {
		blocks.add(Identifier("breadmod", "bread_block"), MinecraftBlock())
	}

	override fun addItems(items: MinecraftItemFeature) {
		items.add(Identifier("breadmod", "bread_2"), MinecraftItem())
		items.add(Identifier("breadmod", "bread_3"), object : MinecraftItem() {
			override fun useOn(context: UseOnContext): InteractionResult {
				println("useOn test??")
				return InteractionResult.CONSUME
			}
		})
	}

	override fun addLayers(layers: MinecraftLayerFeature) {
		layers.add(Identifier("breadmod", "test_layer"), object : MinecraftLayer() {
			override fun render(self: Any, guiGraphics: GuiGraphics, deltaTracker: DeltaTracker) {
				guiGraphics.drawString(Minecraft.getInstance().font, "I LOVE REGISTERED OVERLAYS", 0, 20, Color.WHITE.rgb)
			}
		})
	}
}