package org.bread_experts_group.eam.minecraft.test_mods.breadmod

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer

object BMContentClient {
	val TEST_RENDERER: BlockEntityWithoutLevelRenderer = TestRenderer(Minecraft.getInstance())
}