package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify

import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class OpenGlCapsCheckerTransform_LWJGL3(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	NativeConstantsV1x0x0.net_minecraft_OpenGlCapsChecker,
	"OpenGlCapsChecker",
	scanning,
	classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val glDesc = ClassDesc.of("org.lwjgl.opengl.GL")
		val glCapabilitiesDesc = ClassDesc.of("org.lwjgl.opengl.GLCapabilities")

		val checkARBOcclusion = classBuilder.transformMethodCode(
			classElement,
			"a"
		) { codeBuilder, codeElement, index ->
			when (index) {
				3 -> codeBuilder.invokestatic(
					glDesc,
					"getCapabilities",
					MethodTypeDesc.of(glCapabilitiesDesc)
				)
				4 -> codeBuilder.getfield(
					glCapabilitiesDesc,
					"GL_ARB_occlusion_query",
					ConstantDescs.CD_boolean
				)
				else -> codeBuilder.with(codeElement)
			}
		}

		if (!checkARBOcclusion) classBuilder.with(classElement)
	}
}