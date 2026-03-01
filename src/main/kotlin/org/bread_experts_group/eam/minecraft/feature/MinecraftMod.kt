package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlockFeature
import org.bread_experts_group.eam.minecraft.feature.creative_tab.MinecraftCreativeTabFeature
import org.bread_experts_group.eam.minecraft.feature.item.MinecraftItemFeature
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayerFeature
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.datafixers.util.Pair
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.ShaderInstance
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.resources.ResourceProvider
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemDisplayContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.util.function.Consumer

abstract class MinecraftMod(val id: String) {
	val transforms: MutableMap<String, (ClassBuilder, ClassElement) -> Unit> = mutableMapOf()

	abstract fun addBlocks(blocks: MinecraftBlockFeature)
	abstract fun addItems(items: MinecraftItemFeature)
	abstract fun addLayers(layers: MinecraftLayerFeature)
	abstract fun addCreativeTabs(tabs: MinecraftCreativeTabFeature)
	open fun registerEvents() {}
	open fun afterCreateContents() {}
	open fun renderBEWLRs(
		stack: ItemStack,
		displayContext: ItemDisplayContext,
		poseStack: PoseStack,
		bufferSource: MultiBufferSource,
		packedLight: Int,
		packedOverlay: Int
	) {
	}
	open fun postClientInit() {}
	open fun registerShaders(resourceProvider: ResourceProvider, shaderList: MutableList<Any>) {}
	fun prepareClassTransforms(): Unit = transformClasses(transforms)
	fun getClassTransform(className: String): ((ClassBuilder, ClassElement) -> Unit)? = this.transforms[className]

	open fun transformClasses(transforms: MutableMap<String, (ClassBuilder, ClassElement) -> Unit>) {}

	fun makeShaderPair(shaderInstance: ShaderInstance, onLoaded: (ShaderInstance) -> Unit): Any =
		Pair(shaderInstance.around, Consumer<Any> { onLoaded(ShaderInstance(it)) }).around
}