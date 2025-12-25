package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify

import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class GuiMainMenuTransform_LWJGL3(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(NativeConstantsV1x0x0.net_minecraft_GuiMainMenu, "GuiMainMenu", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val func_35355_b = classBuilder.transformMethodCode( // Panorama?
			classElement,
			"b",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int,
				ConstantDescs.CD_float
			)
		) { codeBuilder, codeElement, index ->
			println("$index, $codeElement")
//			codeBuilder.with(codeElement)
		}

		if (!func_35355_b) classBuilder.with(classElement)
	}
}