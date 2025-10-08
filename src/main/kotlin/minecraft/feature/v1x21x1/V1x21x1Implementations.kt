package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Implementations
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.math.Axis
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import java.awt.Color
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

object V1x21x1Implementations : Implementations() {
	override fun start() {
		injectMethodIntoMethodReturn(
			net_minecraft_core_registries_BuiltInRegistries,
			net_minecraft_core_registries_BuiltInRegistries_createContents,
			ClassDesc.of(this::class.qualifiedName),
			"afterCreateContents"
		)
		scanning[net_minecraft_client_gui_screens_TitleScreen] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (
					classElement is MethodModel &&
					classElement.methodName().equalsString(net_minecraft_client_gui_screens_TitleScreen_render) &&
					classElement.methodType().equalsString("(Lfhz;IIF)V")
				) {
					classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
						if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							if (codeElement is ReturnInstruction) {
								codeBuilder
									.aload(1)
									.invokestatic(
										ClassDesc.of(this::class.qualifiedName),
										"renderTitleScreen",
										MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_Object)
									)
							}
							codeBuilder.with(codeElement)
						}
					}
				} else classBuilder.with(classElement)
			}
		}
		injectMethodIntoMethodReturn(
			net_minecraft_client_Minecraft,
			"d",
			ClassDesc.of(this::class.qualifiedName),
			"updateWindowTitle"
		)
	}

	@JvmStatic
	@Suppress("unused")
	fun afterCreateContents() {
		mods.forEach { it.addBlocks(MinecraftBlockFeature1x21x1()) }
	}

	@JvmStatic
	@Suppress("unused")
	fun renderTitleScreen(clazz: Any) {
		val guiGraphics = GuiGraphics(clazz)
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
	fun updateWindowTitle() {
		Minecraft.getInstance().getWindow().setTitle("Minecraft - EAM 1.21.1")
	}
	/**
	 * Only works with methods that have a void return type.
	 * The source method must be static and not contain any args.
	 */
	private fun injectMethodIntoMethodReturn(
		scanClass: String,
		targetMethodName: String,
		sourceClassDesc: ClassDesc,
		sourceMethodName: String
	) {
		scanning[scanClass] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (
					classElement is MethodModel &&
					classElement.methodName().equalsString(targetMethodName) &&
					classElement.methodType().equalsString("()V")
				) {
					classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
						if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							if (codeElement is ReturnInstruction) {
								codeBuilder
									.invokestatic(
										sourceClassDesc,
										sourceMethodName,
										MethodTypeDesc.of(ConstantDescs.CD_void)
									)
							}
							codeBuilder.with(codeElement)
						}
					}
				} else classBuilder.with(classElement)
			}
		}
	}
}