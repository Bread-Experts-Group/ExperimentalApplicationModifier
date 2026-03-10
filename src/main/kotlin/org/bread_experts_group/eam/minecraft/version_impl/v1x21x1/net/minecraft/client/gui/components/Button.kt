package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.components

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeDefaultSuper
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.putReferenceField
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_components_Button
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_components_Button_Builder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_components_Button_OnPress
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.withReferenceField
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

/*
net.minecraft.client.gui.components.Button -> fim:
# {"fileName":"Button.java","id":"sourceFile"}
    int SMALL_WIDTH -> f
    int DEFAULT_WIDTH -> m
    int BIG_WIDTH -> n
    int DEFAULT_HEIGHT -> o
    int DEFAULT_SPACING -> p
    net.minecraft.client.gui.components.Button$CreateNarration DEFAULT_NARRATION -> q
    net.minecraft.client.gui.components.Button$OnPress onPress -> r
    net.minecraft.client.gui.components.Button$CreateNarration createNarration -> s
    81:81:net.minecraft.client.gui.components.Button$Builder builder(net.minecraft.network.chat.Component,net.minecraft.client.gui.components.Button$OnPress) -> a
    88:92:void <init>(int,int,int,int,net.minecraft.network.chat.Component,net.minecraft.client.gui.components.Button$OnPress,net.minecraft.client.gui.components.Button$CreateNarration) -> <init>
    96:97:void onPress() -> b
    101:101:net.minecraft.network.chat.MutableComponent createNarrationMessage() -> aQ_
    106:107:void updateWidgetNarration(net.minecraft.client.gui.narration.NarrationElementOutput) -> a
    101:101:net.minecraft.network.chat.MutableComponent lambda$createNarrationMessage$1() -> a
    16:16:net.minecraft.network.chat.MutableComponent lambda$static$0(java.util.function.Supplier) -> a
    16:16:void <clinit>() -> <clinit>
 */
open class Button(around: Any) : AbstractButton(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_gui_components_Button)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Button::class.classDesc

		const val SMALL_WIDTH: Int = 120
		const val DEFAULT_WIDTH: Int = 150
		const val BIG_WIDTH: Int = 200
		const val DEFAULT_HEIGHT: Int = 20
		const val DEFAULT_SPACING: Int = 8

		fun builder(message: Component, onPress: OnPress): Builder = Builder(
			clazz.getMethod("a", Component.clazz, OnPress.clazz)
				.invoke(null, message.around, onPress.native())
		)
	}

	/*
	net.minecraft.client.gui.components.Button$Builder -> fim$a:
	# {"fileName":"Button.java","id":"sourceFile"}
    net.minecraft.network.chat.Component message -> a
    net.minecraft.client.gui.components.Button$OnPress onPress -> b
    net.minecraft.client.gui.components.Tooltip tooltip -> c
    int x -> d
    int y -> e
    int width -> f
    int height -> g
    net.minecraft.client.gui.components.Button$CreateNarration createNarration -> h
    33:40:void <init>(net.minecraft.network.chat.Component,net.minecraft.client.gui.components.Button$OnPress) -> <init>
    43:45:net.minecraft.client.gui.components.Button$Builder pos(int,int) -> a
    49:50:net.minecraft.client.gui.components.Button$Builder width(int) -> a
    54:56:net.minecraft.client.gui.components.Button$Builder size(int,int) -> b
    60:60:net.minecraft.client.gui.components.Button$Builder bounds(int,int,int,int) -> a
    64:65:net.minecraft.client.gui.components.Button$Builder tooltip(net.minecraft.client.gui.components.Tooltip) -> a
    69:70:net.minecraft.client.gui.components.Button$Builder createNarration(net.minecraft.client.gui.components.Button$CreateNarration) -> a
    74:76:net.minecraft.client.gui.components.Button build() -> a
	 */
	class Builder(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_gui_components_Button_Builder)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = Builder::class.classDesc
		}

		fun bounds(x: Int, y: Int, width: Int, height: Int): Builder = Builder(
			clazz.getMethod("a", Int::class.java, Int::class.java, Int::class.java, Int::class.java)
				.invoke(around, x, y, width, height)
		)

		fun build(): Button = Button(clazz.getMethod("a").invoke(around))
	}

	fun interface OnPress {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_gui_components_Button_OnPress)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = OnPress::class.classDesc
		}

		@Suppress("unused")
		fun onPress(button: Button)

		fun native(): Any = createNative(
			this::class.java,
			this::class.java.classLoader
		) { classBuilder, name ->
			classBuilder.withInterfaceSymbols(classDesc)
			classBuilder.withMethodBody(
				"onPress",
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					Button.classDesc
				),
				ACC_PUBLIC
			) { codeBuilder ->
				codeBuilder
					.getReferenceField(name, mimicClassDesc)
					.invokeSpecialNewMimic(Button.mimicClassDesc, 1)
					.invokevirtual(
						mimicClassDesc,
						"onPress",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							Button.mimicClassDesc
						)
					)
					.return_()
			}
			classBuilder.withMethodBody(
				ConstantDescs.INIT_NAME,
				MethodTypeDesc.of(ConstantDescs.CD_void, mimicClassDesc),
				ACC_PUBLIC
			) { codeBuilder ->
				codeBuilder
					.aload(0)
					.invokeDefaultSuper()
					.aload(1)
					.putReferenceField(name, mimicClassDesc)
					.return_()
			}
			classBuilder.withReferenceField(mimicClassDesc)
		}.newInstance(this)
	}
}