package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms

import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTab
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTabFeature
import org.bread_experts_group.eam.minecraft.transform.FeatureTransform
import java.lang.classfile.ClassBuilder

// todo ...actually work on tab population and make transform here
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