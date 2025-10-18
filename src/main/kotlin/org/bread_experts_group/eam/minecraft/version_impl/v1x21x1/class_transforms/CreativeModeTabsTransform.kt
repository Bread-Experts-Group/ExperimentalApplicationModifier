package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.getLocalVariableInfo
import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.invokeStaticMethodWithLocalVars
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.Registry
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.CreativeModeTab
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.CreativeModeTabs.Temp.registerTabs
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_item_CreativeModeTabs
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.LineNumber
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class CreativeModeTabsTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_world_item_CreativeModeTabs, "CreativeModeTabs",  scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		if (
			classElement is MethodModel &&
			classElement.methodName().equalsString("a") &&
			classElement.methodTypeSymbol() == MethodTypeDesc.of(
				CreativeModeTab.classDesc,
				Registry.classDesc
		)) {
			classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
				if (methodElement is CodeModel) {
					val localVars = methodBuilder.getLocalVariableInfo(methodElement)
					methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
						if (
							codeElement is LineNumber &&
							codeElement.line() == 68
						) {
							codeBuilder.invokeStaticMethodWithLocalVars(::registerTabs.javaMethod, localVars)
						}
						codeBuilder.with(codeElement)
					}
				}
			}
		} else classBuilder.with(classElement)
	}
}