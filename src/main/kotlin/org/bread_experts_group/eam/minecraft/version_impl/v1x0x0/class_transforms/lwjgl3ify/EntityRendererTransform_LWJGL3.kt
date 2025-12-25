package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.instruction.BranchInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class EntityRendererTransform_LWJGL3(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(NativeConstantsV1x0x0.net_minecraft_EntityRenderer, "EntityRenderer", scanning, classFile) {
	private val glfwDesc = ClassDesc.of("org.lwjgl.glfw.GLFW")
	private val minecraftDesc = ClassDesc.of("net.minecraft.client.Minecraft")

	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val updateCameraAndRender = classBuilder.transformMethodNewSignature(
			classElement,
			"b",
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_float, ConstantDescs.CD_long),
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_float)
		) { codeBuilder, codeElement, index ->
			when (index) {
				15 -> codeBuilder
					.lload(2)
					.getstatic(
						glfwDesc,
						"GLFW_FOCUSED",
						ConstantDescs.CD_int
					)
					.invokestatic(
						glfwDesc,
						"glfwGetWindowAttrib",
						MethodTypeDesc.of(ConstantDescs.CD_int, ConstantDescs.CD_long, ConstantDescs.CD_int)
					)
					.getstatic(
						glfwDesc,
						"GLFW_TRUE",
						ConstantDescs.CD_int
					)

				16 -> {
					val original = codeElement as BranchInstruction
					codeBuilder.if_icmpne(original.target())
				}

				202 -> codeBuilder
					.aload(0)
					.getfield(
						thisClassDesc,
						"r",
						minecraftDesc
					)
					.getfield(
						minecraftDesc,
						"mouseHandler",
						MouseHandler::class.classDesc
					)
					.invokevirtual(
						MouseHandler::class.classDesc,
						"cursorXAsInt",
						MethodTypeDesc.of(ConstantDescs.CD_int)
					)

				212 -> codeBuilder
					.aload(0)
					.getfield(
						thisClassDesc,
						"r",
						minecraftDesc
					)
					.getfield(
						minecraftDesc,
						"mouseHandler",
						MouseHandler::class.classDesc
					)
					.invokevirtual(
						MouseHandler::class.classDesc,
						"cursorYAsInt",
						MethodTypeDesc.of(ConstantDescs.CD_int)
					)

				else -> codeBuilder.with(codeElement)
			}
		}

		if (!(updateCameraAndRender)) classBuilder.with(classElement)
	}
}