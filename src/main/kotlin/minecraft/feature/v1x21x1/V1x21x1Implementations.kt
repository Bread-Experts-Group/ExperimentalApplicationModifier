package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Implementations
import org.bread_experts_group.eam.minecraft.feature.invokeStaticMethodWithMimics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.math.Axis
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.Gui
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.LayeredDraw
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import java.awt.Color
import java.lang.classfile.*
import java.lang.classfile.ClassFile.ACC_FINAL
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.instruction.InvokeInstruction
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method
import kotlin.reflect.jvm.javaMethod

object V1x21x1Implementations : Implementations() {
	override fun start() {
		scanning[net_minecraft_core_registries_BuiltInRegistries] = { _, _, _, data ->
			val r = invokeAtMethodReturns(
				net_minecraft_core_registries_BuiltInRegistries_createContents,
				MethodTypeDesc.of(ConstantDescs.CD_void),
				::afterCreateContents.javaMethod!!
			)
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (!r.invoke(classBuilder, classElement)) classBuilder.with(classElement)
			}
		}
		scanning[net_minecraft_client_gui_screens_TitleScreen] = { _, _, _, data ->
			val r = invokeAtMethodReturns(
				net_minecraft_client_gui_screens_TitleScreen_render,
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					GuiGraphics.classDesc, ConstantDescs.CD_int, ConstantDescs.CD_int,
					ConstantDescs.CD_float
				),
				::renderTitleScreen.javaMethod!!
			)
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (!r.invoke(classBuilder, classElement)) classBuilder.with(classElement)
			}
		}
		scanning[net_minecraft_client_Minecraft] = { _, _, _, data ->
			val r = invokeAtMethodReturns(
				net_minecraft_client_Minecraft_updateTitle,
				MethodTypeDesc.of(ConstantDescs.CD_void),
				::updateWindowTitle.javaMethod!!
			)
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (!r.invoke(classBuilder, classElement)) classBuilder.with(classElement)
			}
		}
		scanning[net_minecraft_client_gui_Gui] = { _, _, _, data ->
			val r = invokeAtMethodReturns(
				"<init>",
				MethodTypeDesc.of(ConstantDescs.CD_void, ClassDesc.of(Minecraft.clazz.name)),
				::addLayers.javaMethod!!
			)
			val p = modifyFieldAccess(
				net_minecraft_client_gui_Gui_layers,
				ACC_PUBLIC or ACC_FINAL
			)
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (
					!(r.invoke(classBuilder, classElement) ||
							p.invoke(classBuilder, classElement))
				) classBuilder.with(classElement)
			}
		}
		scanning[net_minecraft_client_gui_LayeredDraw] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (
					classElement is MethodModel &&
					classElement.methodName().equalsString(net_minecraft_client_gui_LayeredDraw_render) &&
					classElement.methodType().equalsString(MethodTypeDesc.of(
						ConstantDescs.CD_void,
						GuiGraphics.classDesc,
						DeltaTracker.classDesc
					).descriptorString())
				) {
					classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
						if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							if (codeElement is InvokeInstruction &&
								codeElement.typeSymbol() == MethodTypeDesc.of(
									ConstantDescs.CD_void,
									GuiGraphics.classDesc,
									DeltaTracker.classDesc
								)) {
								codeBuilder.invokeStaticMethodWithMimics(::renderOverlay.javaMethod!!)
							}
							codeBuilder.with(codeElement)
						}
					}
				} else classBuilder.with(classElement)
			}
		}
	}

	// todo temporary solution until i write adding layers directly into Gui itself
	val drawLayers: MutableList<LayeredDraw.Layer> = mutableListOf()

	@JvmStatic
	@Suppress("unused")
	fun addLayers(self: Gui) {
		println("registering drawLayers")
		val layers = self.layers
		println(layers)
		this.drawLayers.forEach { layers.add(it) }
	}

	@JvmStatic
	@Suppress("unused")
	fun renderOverlay(self: LayeredDraw, guiGraphics: GuiGraphics) {
		guiGraphics.drawString(Minecraft.getInstance().font, "I LOVE OVERLAYS", 0, 0, Color.CYAN.rgb)
	}

	@JvmStatic
	@Suppress("unused")
	fun afterCreateContents() {
		mods.forEach { it.addBlocks(MinecraftBlockFeature1x21x1()) }
		mods.forEach { it.addItems(MinecraftItemFeature1x21x1()) }
		mods.forEach { it.addLayers(MinecraftLayerFeature1x21x1()) }
	}

	@JvmStatic
	@Suppress("unused")
	fun renderTitleScreen(titleScreen: Any, guiGraphics: GuiGraphics) {
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
		targetMethodName: String,
		targetMethodType: MethodTypeDesc,
		method: Method
	): (ClassBuilder, ClassElement) -> Boolean {
		if (method.returnType != Void.TYPE) throw IllegalArgumentException(
			"$method (in injection to returns of $targetMethodName : $targetMethodType) must return void!"
		)
		return transform@{ classBuilder, classElement ->
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
				return@transform true
			}
			return@transform false
		}
	}

	private fun modifyFieldAccess(
		targetField: String,
		newAccessFlags: Int
	): (ClassBuilder, ClassElement) -> Boolean = transform@{ classBuilder, classElement ->
		if (
			classElement is FieldModel &&
			classElement.fieldName().equalsString(targetField)
		) {
			classBuilder.transformField(classElement) { fieldBuilder, fieldElement ->
				if (fieldElement is AccessFlags) fieldBuilder.withFlags(newAccessFlags)
				else fieldBuilder.with(fieldElement)
			}
			return@transform true
		}
		return@transform false
	}
}