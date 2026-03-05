package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify

import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class OpenGlHelperTransform_LWJGL3: ClassTransform(
	NativeConstantsV1x0x0.net_minecraft_OpenGlHelper,
	"OpenGlHelper"
) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val glDesc = ClassDesc.of("org.lwjgl.opengl.GL")
		val glCapabilitiesDesc = ClassDesc.of("org.lwjgl.opengl.GLCapabilities")
		val initializeTextures = classBuilder.transformMethodCode(
			classElement,
			"a",
			DEFAULT_VOID
		) { codeBuilder, codeElement, index ->
			when (index) {
				1 -> codeBuilder.invokestatic(
					glDesc,
					"getCapabilities",
					MethodTypeDesc.of(glCapabilitiesDesc)
				)
				2 -> codeBuilder.getfield(
					glCapabilitiesDesc,
					"GL_ARB_multitexture",
					ConstantDescs.CD_boolean
				)
				4 -> codeBuilder.invokestatic(
					glDesc,
					"getCapabilities",
					MethodTypeDesc.of(glCapabilitiesDesc)
				)
				5 -> codeBuilder.getfield(
					glCapabilitiesDesc,
					"OpenGL13",
					ConstantDescs.CD_boolean
				)
				else -> codeBuilder.with(codeElement)
			}
		}

		if (!initializeTextures) classBuilder.with(classElement)
	}
}