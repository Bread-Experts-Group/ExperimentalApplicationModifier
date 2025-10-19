package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms

import org.bread_experts_group.eam.minecraft.feature.FeatureTransform
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import java.lang.classfile.ClassBuilder

class BlockFeatureTransform(input: MinecraftBlock) : FeatureTransform<MinecraftBlock>(input) {
	override fun createInstance(clazz: Class<*>): Any {
		TODO("Not yet implemented")
	}

	override fun startTransform(name: String): (ClassBuilder) -> Any {
		TODO("Not yet implemented")
	}
}