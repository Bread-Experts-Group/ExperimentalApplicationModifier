package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.components

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.putReferenceField
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_components_AbstractWidget
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.withReferenceField
import java.lang.classfile.ClassFile.ACC_PROTECTED
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

/*
net.minecraft.client.gui.components.AbstractWidget -> fik:
# {"fileName":"AbstractWidget.java","id":"sourceFile"}
    double PERIOD_PER_SCROLLED_PIXEL -> a
    double MIN_SCROLL_PERIOD -> b
    int width -> g
    int height -> h
    int x -> c
    int y -> d
    net.minecraft.network.chat.Component message -> e
    boolean isHovered -> i
    boolean active -> j
    boolean visible -> k
    float alpha -> l
    int tabOrderGroup -> f
    boolean focused -> m
    net.minecraft.client.gui.components.WidgetTooltipHolder tooltip -> n
    37:52:void <init>(int,int,int,int,net.minecraft.network.chat.Component) -> <init>
    56:56:int getHeight() -> w
    61:69:void render(net.minecraft.client.gui.GuiGraphics,int,int,float) -> a
    77:77:net.minecraft.client.gui.components.Tooltip getTooltip() -> x
    81:82:void setTooltipDelay(java.time.Duration) -> a
    85:85:net.minecraft.network.chat.MutableComponent createNarrationMessage() -> aQ_
    89:89:net.minecraft.network.chat.MutableComponent wrapDefaultNarrationMessage(net.minecraft.network.chat.Component) -> a_
    void renderWidget(net.minecraft.client.gui.GuiGraphics,int,int,float) -> b
    95:96:void renderScrollingString(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.gui.Font,net.minecraft.network.chat.Component,int,int,int,int,int) -> a
    99:115:void renderScrollingString(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.gui.Font,net.minecraft.network.chat.Component,int,int,int,int,int,int) -> a
    118:121:void renderScrollingString(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.gui.Font,int,int) -> a
    124:124:void onClick(double,double) -> a
    127:127:void onRelease(double,double) -> a_
    130:130:void onDrag(double,double,double,double) -> b
    134:145:boolean mouseClicked(double,double,int) -> a
    150:154:boolean mouseReleased(double,double,int) -> b
    158:158:boolean isValidClickButton(int) -> j
    163:167:boolean mouseDragged(double,double,int,double,double) -> a
    171:171:boolean clicked(double,double) -> d
    177:184:net.minecraft.client.gui.ComponentPath nextFocusPath(net.minecraft.client.gui.navigation.FocusNavigationEvent) -> a
    189:189:boolean isMouseOver(double,double) -> c
    193:194:void playDownSound(net.minecraft.client.sounds.SoundManager) -> a
    198:198:int getWidth() -> y
    202:203:void setWidth(int) -> k
    206:207:void setHeight(int) -> l
    210:211:void setAlpha(float) -> a
    214:215:void setMessage(net.minecraft.network.chat.Component) -> b
    218:218:net.minecraft.network.chat.Component getMessage() -> z
    223:223:boolean isFocused() -> aO_
    227:227:boolean isHovered() -> A
    231:231:boolean isHoveredOrFocused() -> B
    236:236:boolean isActive() -> C
    244:245:void setFocused(boolean) -> a
    249:255:net.minecraft.client.gui.narration.NarratableEntry$NarrationPriority narrationPriority() -> u
    260:262:void updateNarration(net.minecraft.client.gui.narration.NarrationElementOutput) -> b
    void updateWidgetNarration(net.minecraft.client.gui.narration.NarrationElementOutput) -> a
    268:276:void defaultButtonNarrationText(net.minecraft.client.gui.narration.NarrationElementOutput) -> c
    285:286:void setX(int) -> m
    295:296:void setY(int) -> n
    299:299:int getRight() -> F
    303:303:int getBottom() -> G
    308:309:void visitWidgets(java.util.function.Consumer) -> a
    312:314:void setSize(int,int) -> b
    318:318:net.minecraft.client.gui.navigation.ScreenRectangle getRectangle() -> H
    322:324:void setRectangle(int,int,int,int) -> a
    328:328:int getTabOrderGroup() -> I
    332:333:void setTabOrderGroup(int) -> o
 */
abstract class AbstractWidget(
	x: Int,
	y: Int,
	width: Int,
	height: Int,
	message: Component
) : MimickedClass(0) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_gui_components_AbstractWidget)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = AbstractWidget::class.classDesc
	}

	constructor(around: Any) : this(0, 0, 0, 0, Component.empty()) {
		this.around = around
	}

	init {
		val usedAround = x == 0 && y == 0 && width == 0 && height == 0
		if (overrides("renderWidget") && !usedAround) this.around = createNative(
			AbstractWidget::class.java,
			this::class.java.classLoader
		) { classBuilder, name ->
			classBuilder.withSuperclass(classDesc)
			classBuilder.withMethodBody(
				"<init>",
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					mimicClassDesc,
					ConstantDescs.CD_int,
					ConstantDescs.CD_int,
					ConstantDescs.CD_int,
					ConstantDescs.CD_int,
					Component.classDesc
				),
				ACC_PUBLIC
			) { codeBuilder ->
				codeBuilder
					.aload(0)
					.iload(2)
					.iload(3)
					.iload(4)
					.iload(5)
					.aload(6)
					.invokespecial(
						classDesc,
						"<init>",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							Component.classDesc
						)
					)
					.aload(0)
					.aload(1)
					.putReferenceField(name, mimicClassDesc)
					.return_()
			}
			classBuilder.withMethodBody(
				"b",
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					GuiGraphics.classDesc,
					ConstantDescs.CD_int,
					ConstantDescs.CD_int,
					ConstantDescs.CD_float
				),
				ACC_PROTECTED
			) { codeBuilder ->
				codeBuilder
					.getReferenceField(name, mimicClassDesc)
					.invokeSpecialNewMimic(GuiGraphics.mimicClassDesc, 1)
					.iload(2)
					.iload(3)
					.fload(4)
					.invokevirtual(
						mimicClassDesc,
						"renderWidget",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							GuiGraphics.mimicClassDesc,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ConstantDescs.CD_float
						)
					)
					.return_()
			}
			classBuilder.withReferenceField(mimicClassDesc)
		}.newInstance(this, x, y, width, height, message.around)
	}

	fun getX(): Int = clazz.getMethod("D").invoke(around) as Int
	fun getY(): Int = clazz.getMethod("E").invoke(around) as Int

	fun getWidth(): Int = clazz.getMethod("y").invoke(around) as Int
	fun getHeight(): Int = clazz.getMethod("w").invoke(around) as Int

	fun setTooltip(tooltip: Tooltip?) {
		clazz.getMethod("a", Tooltip.clazz)
			.invoke(around, tooltip?.around)
	}

	abstract fun renderWidget(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float)
}