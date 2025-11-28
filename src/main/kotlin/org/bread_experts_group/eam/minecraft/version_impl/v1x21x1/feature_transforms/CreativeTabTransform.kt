package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms

import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.FeatureTransform
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTab
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTabFeature
import java.lang.classfile.ClassBuilder

class CreativeTabTransform(input: MinecraftCreativeTab) :
	FeatureTransform<MinecraftCreativeTab, MinecraftCreativeTabFeature>(
		input,
		MinecraftFeatures.CREATIVE_TAB
	) {
	override fun createInstance(clazz: Class<*>): Any {
		TODO("Not yet implemented")
	}
	override fun startTransform(name: String): (ClassBuilder) -> Any {
		TODO("Not yet implemented")
	}
}