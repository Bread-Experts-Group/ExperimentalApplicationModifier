package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.getLocalVariableInfo
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.invokeStaticWithLocalVars
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_screens_TitleScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_screens_TitleScreen_render
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations.renderTitleScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import java.lang.classfile.*
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class TitleScreenTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_client_gui_screens_TitleScreen,
	"TitleScreen",
	scanning, classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		TODO("KILL")
		if (
			classElement is MethodModel &&
			classElement.methodName().equalsString(net_minecraft_client_gui_screens_TitleScreen_render) &&
			classElement.methodTypeSymbol() == MethodTypeDesc.of(
				ConstantDescs.CD_void,
				GuiGraphics.classDesc,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int,
				ConstantDescs.CD_float
			)) {
			classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
				if (methodElement is CodeModel) {
					val localVars = methodBuilder.getLocalVariableInfo(methodElement)
					methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
						codeBuilder.atLineNumber(273, codeElement) { builder ->
							builder.invokeStaticWithLocalVars(::renderTitleScreen.javaMethod, localVars)
						}
						.with(codeElement)
					}
				}
			}
		} else classBuilder.with(classElement)
	}
}