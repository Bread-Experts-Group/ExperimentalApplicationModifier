package org.bread_experts_group.eam.minecraft.test_mods.breadmod.camera

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.texture.AbstractTexture
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.texture.Tickable
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.resources.ResourceManager

class CameraTexture : AbstractTexture(0), Tickable {
	init {
		this.around = implementNative(this)
	}

	override fun tick() {
	}

	override fun close() {
	}

	override fun load(resourceManager: ResourceManager) {
	}
}