package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_network_chat_MutableComponent
import java.lang.constant.ClassDesc

/*
net.minecraft.network.chat.MutableComponent -> xn:
# {"fileName":"MutableComponent.java","id":"sourceFile"}
    net.minecraft.network.chat.ComponentContents contents -> c
    java.util.List siblings -> d
    net.minecraft.network.chat.Style style -> e
    net.minecraft.util.FormattedCharSequence visualOrderText -> f
    net.minecraft.locale.Language decomposedWith -> g
    18:26:void <init>(net.minecraft.network.chat.ComponentContents,java.util.List,net.minecraft.network.chat.Style) -> <init>
    29:29:net.minecraft.network.chat.MutableComponent create(net.minecraft.network.chat.ComponentContents) -> a
    34:34:net.minecraft.network.chat.ComponentContents getContents() -> b
    39:39:java.util.List getSiblings() -> c
    43:44:net.minecraft.network.chat.MutableComponent setStyle(net.minecraft.network.chat.Style) -> b
    49:49:net.minecraft.network.chat.Style getStyle() -> a
    53:56:net.minecraft.network.chat.MutableComponent append(java.lang.String) -> f
    60:61:net.minecraft.network.chat.MutableComponent append(net.minecraft.network.chat.Component) -> b
    65:66:net.minecraft.network.chat.MutableComponent withStyle(java.util.function.UnaryOperator) -> a
    70:71:net.minecraft.network.chat.MutableComponent withStyle(net.minecraft.network.chat.Style) -> c
    75:76:net.minecraft.network.chat.MutableComponent withStyle(net.minecraft.ChatFormatting[]) -> a
    80:81:net.minecraft.network.chat.MutableComponent withStyle(net.minecraft.ChatFormatting) -> a
    85:86:net.minecraft.network.chat.MutableComponent withColor(int) -> b
    91:96:net.minecraft.util.FormattedCharSequence getVisualOrderText() -> g
    101:109:boolean equals(java.lang.Object) -> equals
    114:114:int hashCode() -> hashCode
    119:137:java.lang.String toString() -> toString
 */
class MutableComponent(around: Any) : Component(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_network_chat_MutableComponent)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = MutableComponent::class.classDesc
	}
}