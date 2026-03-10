package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation

// todo i'll probably find a use for this eventually
object V1X21X1Util {
	fun eamLoc(vararg path: String): ResourceLocation =
		ResourceLocation.fromNamespaceAndPath("eam", path.joinToString("/"))
}