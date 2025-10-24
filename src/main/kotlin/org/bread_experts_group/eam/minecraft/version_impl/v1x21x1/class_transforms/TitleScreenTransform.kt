package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.getLocalVariableInfo
import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.invokeStaticMethodWithLocalVars
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1x21x1Implementations.renderTitleScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_gui_screens_TitleScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_gui_screens_TitleScreen_render
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class TitleScreenTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_gui_screens_TitleScreen, "TitleScreen", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
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
						codeBuilder.atLine(273, codeElement) { builder ->
							builder.invokeStaticMethodWithLocalVars(::renderTitleScreen.javaMethod, localVars)
						}
						.with(codeElement)
					}
				}
			}
		} else classBuilder.with(classElement)
	}
}