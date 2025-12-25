package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.api.feature.FeatureImplementation
import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.transform.FeatureTransform

abstract class MinecraftFeatureImplementation<T, I : MinecraftFeatureImplementation<T, I>> : FeatureImplementation<I> {
	abstract fun getTransformer(input: T): FeatureTransform<T, I>
	abstract fun add(id: Identifier, value: T): T
	protected abstract fun register(id: Identifier, value: T): T
}