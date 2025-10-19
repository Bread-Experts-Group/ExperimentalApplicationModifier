package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.api.FeatureImplementation
import org.bread_experts_group.eam.minecraft.feature.FeatureTransform
import org.bread_experts_group.eam.minecraft.feature.Identifier

abstract class MinecraftFeatureImplementation<T, I : MinecraftFeatureImplementation<T, I>> : FeatureImplementation<I> {
	abstract fun getTransformer(input: T): FeatureTransform<T>

	abstract fun add(id: Identifier, value: T): T

	protected abstract fun register(id: Identifier, value: T): T
}