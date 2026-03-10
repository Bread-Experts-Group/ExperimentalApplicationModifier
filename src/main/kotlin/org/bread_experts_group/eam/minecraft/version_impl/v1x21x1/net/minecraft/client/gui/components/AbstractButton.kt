package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.components

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_components_AbstractButton
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import java.lang.constant.ClassDesc

/*
net.minecraft.client.gui.components.AbstractButton -> fid:
# {"fileName":"AbstractButton.java","id":"sourceFile"}
    int TEXT_MARGIN -> e
    net.minecraft.client.gui.components.WidgetSprites SPRITES -> a
    22:23:void <init>(int,int,int,int,net.minecraft.network.chat.Component) -> <init>
    void onPress() -> b
    43:44:void renderString(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.gui.Font,int) -> a
    48:49:void onClick(double,double) -> a
    53:61:boolean keyPressed(int,int,int) -> a
    15:18:void <clinit>() -> <clinit>
 */
abstract class AbstractButton(
	x: Int,
	y: Int,
	width: Int,
	height: Int,
	message: Component
) : AbstractWidget(x, y, width, height, message) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_gui_components_AbstractButton)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc= AbstractButton::class.classDesc
	}

	constructor(around: Any) : this(0, 0, 0, 0, Component.empty()) {
		this.around = around
	}

	override fun renderWidget(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
		clazz.getMethod("b", GuiGraphics.clazz, Int::class.java, Int::class.java, Float::class.java)
			.invoke(around, guiGraphics.around, mouseX, mouseY, partialTick)
	}
}