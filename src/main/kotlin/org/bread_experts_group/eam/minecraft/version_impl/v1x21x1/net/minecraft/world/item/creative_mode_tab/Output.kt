package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.creative_mode_tab

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_item_CreativeModeTab_Output
import java.lang.constant.ClassDesc

/*
net.minecraft.world.item.CreativeModeTab$Output -> cta$e:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
void accept(net.minecraft.world.item.ItemStack,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
268:269:void accept(net.minecraft.world.item.ItemStack) -> a
272:273:void accept(net.minecraft.world.level.ItemLike,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
276:277:void accept(net.minecraft.world.level.ItemLike) -> a
280:281:void acceptAll(java.util.Collection,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
284:285:void acceptAll(java.util.Collection) -> a
280:280:void lambda$acceptAll$0(net.minecraft.world.item.CreativeModeTab$TabVisibility,net.minecraft.world.item.ItemStack) -> a
 */
class Output(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab_Output)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Output::class.classDesc
	}

	fun accept(stack: ItemStack) {
		clazz.getMethod("a", ItemStack.Companion.clazz)
			.invoke(around, stack.around)
	}
}