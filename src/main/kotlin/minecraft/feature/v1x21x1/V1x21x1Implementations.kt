package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Implementations
import java.awt.Color
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

object V1x21x1Implementations : Implementations() {
	override fun start() {
		scanning[net_minecraft_core_registries_BuiltInRegistries] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (
					classElement is MethodModel &&
					classElement.methodName().equalsString(net_minecraft_core_registries_BuiltInRegistries_createContents) &&
					classElement.methodType().equalsString("()V")
				) {
					classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
						if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							if (codeElement is ReturnInstruction) {
								codeBuilder.invokestatic(
									ClassDesc.of(this::class.qualifiedName),
									"afterCreateContents",
									MethodTypeDesc.of(ConstantDescs.CD_void)
								)
							}
							codeBuilder.with(codeElement)
						}
					}
				} else classBuilder.with(classElement)
			}
		}
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
										ClassDesc.of(net_minecraft_client_Minecraft),
										net_minecraft_client_Minecraft_getInstance,
										MethodTypeDesc.of(ClassDesc.of(net_minecraft_client_Minecraft))
									)
									.getfield(
										ClassDesc.of(net_minecraft_client_Minecraft),
										net_minecraft_client_Minecraft_font,
										ClassDesc.of(net_minecraft_client_gui_Font),
									)
									.ldc(
										codeBuilder.constantPool().stringEntry("EAM on top")
									)
									.bipush(0)
									.bipush(0)
									.loadConstant(Color.WHITE.rgb)
									.invokevirtual(
										ClassDesc.of(net_minecraft_client_gui_GuiGraphics),
										net_minecraft_client_gui_GuiGraphics_drawString,
										MethodTypeDesc.of(
											ConstantDescs.CD_int,
											ClassDesc.of(net_minecraft_client_gui_Font),
											ConstantDescs.CD_String,
											ConstantDescs.CD_int,
											ConstantDescs.CD_int,
											ConstantDescs.CD_int
										)
									)
							}
							codeBuilder.with(codeElement)
						}
					}
				} else classBuilder.with(classElement)
			}
		}
	}

	@JvmStatic
	@Suppress("unused")
	fun afterCreateContents() {
		mods.forEach { it.addBlocks(MinecraftBlockFeature1x21x1()) }
	}
}