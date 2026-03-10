package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.components

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_components_Tooltip
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import java.lang.constant.ClassDesc

/*
net.minecraft.client.gui.components.Tooltip -> fjx:
# {"fileName":"Tooltip.java","id":"sourceFile"}
    int MAX_WIDTH -> a
    net.minecraft.network.chat.Component message -> b
    java.util.List cachedTooltip -> c
    net.minecraft.locale.Language splitWithLanguage -> d
    net.minecraft.network.chat.Component narration -> e
    25:28:void <init>(net.minecraft.network.chat.Component,net.minecraft.network.chat.Component) -> <init>
    40:43:void updateNarration(net.minecraft.client.gui.narration.NarrationElementOutput) -> b
    46:51:java.util.List toCharSequence(net.minecraft.client.Minecraft) -> a
    55:55:java.util.List splitTooltip(net.minecraft.client.Minecraft,net.minecraft.network.chat.Component) -> a
 */
class Tooltip(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_gui_components_Tooltip)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Tooltip::class.classDesc

		fun create(message: Component, narration: Component?): Tooltip = Tooltip(
			clazz.getMethod("a", Component.clazz, Component.clazz)
				.invoke(null, message.around, narration?.around)
		)

		fun create(message: Component): Tooltip = Tooltip(
			clazz.getMethod("a", Component.clazz)
				.invoke(null, message.around)
		)
	}
}