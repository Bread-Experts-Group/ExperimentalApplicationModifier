package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.creative_mode_tab

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_item_CreativeModeTab_DisplayItemsGenerator
import java.lang.constant.ClassDesc

/*
net.minecraft.world.item.CreativeModeTab$DisplayItemsGenerator -> cta$b:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
void accept(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> accept
 */
open class DisplayItemsGenerator(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab_DisplayItemsGenerator)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = DisplayItemsGenerator::class.classDesc
	}

	open fun acceptInternal(displayParameters: ItemDisplayParameters, output: Output) {}
}