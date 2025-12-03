package org.bread_experts_group.eam.minecraft.test_mods.breadmod

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation

object BMUtil {
	fun modLocation(vararg path: String): ResourceLocation =
		path.toMutableList().let {
			ResourceLocation.fromNamespaceAndPath("breadmod", it.joinToString("/"))
		}
}