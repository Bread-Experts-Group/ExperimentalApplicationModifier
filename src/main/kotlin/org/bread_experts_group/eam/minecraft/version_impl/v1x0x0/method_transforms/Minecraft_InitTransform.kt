package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.method_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.LAMBDA_METAFACTORY_METHOD_HANDLE
import org.bread_experts_group.eam.minecraft.loadConstant
import org.bread_experts_group.eam.minecraft.transform.MethodTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.MouseHandler
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.CodeBuilder
import java.lang.classfile.CodeElement
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.DirectMethodHandleDesc
import java.lang.constant.DynamicCallSiteDesc
import java.lang.constant.MethodHandleDesc
import java.lang.constant.MethodTypeDesc

class Minecraft_InitTransform(
	classBuilder: ClassBuilder,
	classElement: ClassElement,
	owningClass: ClassDesc
) : MethodTransform(classBuilder, classElement, ConstantDescs.INIT_NAME, owningClass) {
	private val glfwErrorCallbackDesc = ClassDesc.of("org.lwjgl.glfw.GLFWErrorCallback")
	private val glfwErrorCallbackIDesc = ClassDesc.of("org.lwjgl.glfw.GLFWErrorCallbackI")
	private val minecraftDesc = ClassDesc.of("net.minecraft.client.Minecraft")

	override fun transform(): (CodeBuilder, CodeElement, Int) -> Unit = { codeBuilder, codeElement, index ->
		val callBackDescriptor = MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_int, ConstantDescs.CD_long)

		if (index == 3) codeBuilder
			.aload(0)
			.loadConstant("")
			.putfield(minecraftDesc, "errorSection", ConstantDescs.CD_String)

			.aload(0)
			.aload(0)
			.invokedynamic(
				DynamicCallSiteDesc.of(
					LAMBDA_METAFACTORY_METHOD_HANDLE,
					"invoke",
					MethodTypeDesc.of(glfwErrorCallbackIDesc, minecraftDesc),
					callBackDescriptor,
					MethodHandleDesc.ofMethod(
						DirectMethodHandleDesc.Kind.VIRTUAL,
						minecraftDesc,
						"defaultErrorCallback",
						callBackDescriptor
					),
					callBackDescriptor
				)
			)
			.invokestatic(
				glfwErrorCallbackDesc,
				"create",
				MethodTypeDesc.of(glfwErrorCallbackDesc, glfwErrorCallbackIDesc)
			)
			.putfield(
				minecraftDesc,
				"glfwErrorCallback",
				glfwErrorCallbackDesc
			)

			.aload(0)
			.new_(MouseHandler::class.classDesc)
			.dup()
			.invokespecial(
				MouseHandler::class.classDesc,
				ConstantDescs.INIT_NAME,
				DEFAULT_VOID
			)
			.putfield(
				owningClass,
				"mouseHandler",
				MouseHandler::class.classDesc
			)

			.new_(ClassDesc.of("eh"))
			.dup()
			.invokespecial(
				ClassDesc.of("eh"),
				ConstantDescs.INIT_NAME,
				MethodTypeDesc.of(ConstantDescs.CD_void)
			)
			.pop()
		codeBuilder.with(codeElement)
	}
}