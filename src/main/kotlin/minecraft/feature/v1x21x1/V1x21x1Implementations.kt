package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Implementations
import org.bread_experts_group.eam.minecraft.feature.invokeStaticMethodWithMimics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.math.Axis
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import java.awt.Color
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method
import kotlin.reflect.jvm.javaMethod

object V1x21x1Implementations : Implementations() {
	override fun start() {
		invokeAtMethodReturns(
			net_minecraft_core_registries_BuiltInRegistries,
			net_minecraft_core_registries_BuiltInRegistries_createContents,
			MethodTypeDesc.of(ConstantDescs.CD_void),
			::afterCreateContents.javaMethod!!
		)
		invokeAtMethodReturns(
			net_minecraft_client_gui_screens_TitleScreen,
			net_minecraft_client_gui_screens_TitleScreen_render,
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				GuiGraphics.classDesc, ConstantDescs.CD_int, ConstantDescs.CD_int,
				ConstantDescs.CD_float
			),
			::renderTitleScreen.javaMethod!!
		)
		invokeAtMethodReturns(
			net_minecraft_client_Minecraft,
			net_minecraft_client_Minecraft_updateTitle,
			MethodTypeDesc.of(ConstantDescs.CD_void),
			::updateWindowTitle.javaMethod!!
		)
	}

	@JvmStatic
	@Suppress("unused")
	fun afterCreateContents() {
		mods.forEach { it.addBlocks(MinecraftBlockFeature1x21x1()) }
		mods.forEach { it.addItems(MinecraftItemFeature1x21x1()) }
	}

	@JvmStatic
	@Suppress("unused")
	fun renderTitleScreen(self: Any, guiGraphics: GuiGraphics) {
		val poseStack = guiGraphics.pose()
		poseStack.pushPose()
		poseStack.translate(10f, 3f, 0f)
		poseStack.scale(1.25f, 1.25f, 1.25f)
		poseStack.pushPose()
		poseStack.scale(2f, 2f, 2f)
		guiGraphics.renderItem(BuiltInRegistries.ITEM.get(ResourceLocation.parse("breadmod:bread_block")).getDefaultInstance(), 0, 30)
		poseStack.popPose()
		poseStack.mulPose(Axis.ZP.rotationDegrees(25f))
		guiGraphics.drawString(Minecraft.getInstance().font, "EAM on top", 0, 0, Color.WHITE.rgb)
		guiGraphics.drawString(Minecraft.getInstance().font, "oh yeah also minecraft is very cool and nice you should play it :thumbsup:", 0, 10, Color.ORANGE.rgb)
		poseStack.popPose()
	}

	@JvmStatic
	@Suppress("unused")
	fun updateWindowTitle(self: Minecraft) {
		self.getWindow().setTitle("Minecraft - EAM 1.21.1")
	}

	private fun invokeAtMethodReturns(
		scanClass: String,
		targetMethodName: String,
		targetMethodType: MethodTypeDesc,
		method: Method
	) {
		if (method.returnType != Void.TYPE) throw IllegalArgumentException(
			"$method (in injection to returns of $targetMethodName : $targetMethodType) must return void!"
		)
		scanning[scanClass] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (
					classElement is MethodModel &&
					classElement.methodName().equalsString(targetMethodName) &&
					classElement.methodType().equalsString(targetMethodType.descriptorString())
				) {
					classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
						if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							if (codeElement is ReturnInstruction) codeBuilder.invokeStaticMethodWithMimics(method)
							codeBuilder.with(codeElement)
						}
					}
				} else classBuilder.with(classElement)
			}
		}
	}
}