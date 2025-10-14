package org.bread_experts_group.eam.minecraft.feature.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.V1x21x1Implementations.updateWindowTitle
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_Minecraft
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_Minecraft_updateTitle
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class MinecraftTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_Minecraft, "Minecraft", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val r = invokeAtMethodReturns(
			net_minecraft_client_Minecraft_updateTitle,
			MethodTypeDesc.of(ConstantDescs.CD_void),
			::updateWindowTitle.javaMethod!!
		)
		if (!r.invoke(classBuilder, classElement)) classBuilder.with(classElement)
	}
}