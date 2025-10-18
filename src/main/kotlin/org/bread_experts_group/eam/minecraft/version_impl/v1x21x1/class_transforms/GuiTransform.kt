package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1x21x1Implementations.addLayers
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_gui_Gui
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_gui_Gui_layers
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_FINAL
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class GuiTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_gui_Gui, "Gui", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val r = invokeAtMethodReturns(
			"<init>",
			MethodTypeDesc.of(ConstantDescs.CD_void, ClassDesc.of(Minecraft.clazz.name)),
			::addLayers.javaMethod!!
		)
		val p = modifyFieldAccess(
			net_minecraft_client_gui_Gui_layers,
			ACC_PUBLIC or ACC_FINAL
		)
		if (
			!(r.invoke(classBuilder, classElement) ||
					p.invoke(classBuilder, classElement))
		) classBuilder.with(classElement)
	}
}