package org.bread_experts_group.eam.minecraft.transform

import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod.Companion.modID

class ModTransformHolder {
	private val modTransforms: MutableMap<MinecraftMod, MutableMap<String, ModClassTransform>> = mutableMapOf()

	fun submit(mod: MinecraftMod, target: String, transform: ModClassTransform) {
		val map = this.modTransforms.getOrPut(mod) { mutableMapOf() }
		if (map[target] == null) map[target] = transform else
			throw IllegalStateException("Transform already exists for target $target from mod ${mod::class.java.modID}")
	}

	fun getTransforms(targetClass: String): Map<MinecraftMod, ModClassTransform> {
		val filtered = this.modTransforms.filter { it.value[targetClass] != null }
		return buildMap { filtered.forEach { (mod, map) -> this[mod] = map[targetClass] ?: return@forEach } }
	}

	fun isEmpty(): Boolean = this.modTransforms.isEmpty()

	fun gatherTransforms(mods: List<MinecraftMod>) {
		mods.forEach { it.gatherClassTransforms(this) }
	}
}