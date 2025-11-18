package org.bread_experts_group.eam.minecraft.test_mods

import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTab
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTabFeature
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItem
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemProperties
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayer
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayerFeature
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.sounds.SoundEvents
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.sounds.SoundSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.InteractionResult
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity.Entity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.context.UseOnContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.Level
import java.awt.Color

class BreadMod : MinecraftMod("breadmod") {
	override fun addBlocks(blocks: MinecraftBlockFeature) {
		blocks.add(
			Identifier("breadmod", "bread_block"),
			MinecraftBlock()
		)
	}

	override fun addItems(items: MinecraftItemFeature) {
		items.add(Identifier("breadmod", "bread_2"), MinecraftItem(MinecraftItemProperties()))
		items.add(
			Identifier(
				"breadmod",
				"bread_3"
			), object : MinecraftItem(MinecraftItemProperties()) {
				override fun useOn(context: UseOnContext): InteractionResult {
					println("useOn test??")
					return InteractionResult.CONSUME
				}

				override fun inventoryTick(
					stack: ItemStack,
					level: Level,
					entity: Entity,
					slot: Int,
					beingHeld: Boolean
				) {
				}
		})
		// todo mouse and keyboard hooks
		items.add(Identifier("breadmod", "tool_gun"), MinecraftItem(MinecraftItemProperties()))
	}

	override fun addLayers(layers: MinecraftLayerFeature) {
		layers.add(Identifier("breadmod", "test_layer"), object : MinecraftLayer() {
			override fun render(guiGraphics: GuiGraphics, deltaTracker: DeltaTracker) {
				guiGraphics.drawString(Minecraft.Companion.getInstance().font, "I LOVE REGISTERED OVERLAYS", 0, 20, Color.WHITE.rgb)
			}
		})
	}

	override fun addCreativeTabs(tabs: MinecraftCreativeTabFeature) {
		tabs.add(Identifier("breadmod", "breadmod"), MinecraftCreativeTab())
	}

	override fun registerEvents() {
		EventSystem.addListener(EventSystem.MOUSE_BUTTON_PRE) { event, button, action, _ ->
		}

		EventSystem.addListener(EventSystem.MOUSE_BUTTON_POST) { event, button, action, _ ->
		}

		EventSystem.addListener(EventSystem.MOUSE_SCROLLED) { event, mouseHandler, scrollX, scrollY ->
			val minecraft = Minecraft.getInstance()
			val player = minecraft.player ?: return@addListener
			val level = minecraft.level ?: return@addListener
			val item = BuiltInRegistries.ITEM.get(ResourceLocation.parse("breadmod:tool_gun"))
			if (player.isHolding(item) && player.isShiftKeyDown()) {
				level.playSound(
					player.getX(),
					player.getY(),
					player.getZ(),
					SoundEvents.NOTE_BLOCK_PLING.value(),
					SoundSource.AMBIENT,
					1f,
					1f,
					false,
					42L
				)
				event.setCanceled(true)
			}
		}
	}
}