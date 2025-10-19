package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0

import org.bread_experts_group.api.ImplementationSource
import org.bread_experts_group.eam.minecraft.feature.FeatureTransform
import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.net.minecraft.Block
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.net.minecraft.Material

// TODO: Add namespaces to 1.0.0
class MinecraftBlockFeature1x0x0 : MinecraftBlockFeature() {
	override val source: ImplementationSource = ImplementationSource.JVM_NATIVE
	override fun getTransformer(input: MinecraftBlock): FeatureTransform<MinecraftBlock> {
		TODO("Not yet implemented")
	}

	override fun register(id: Identifier, value: MinecraftBlock): MinecraftBlock {
		value.mimic = Block(123, Material.grass)
		return value
	}
}