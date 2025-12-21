package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import org.bread_experts_group.eam.toConstantDesc
import java.io.PrintStream
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PRIVATE
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.MethodModel
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.DirectMethodHandleDesc
import java.lang.constant.DynamicCallSiteDesc
import java.lang.constant.MethodHandleDesc
import java.lang.constant.MethodTypeDesc
import java.lang.invoke.CallSite
import java.lang.invoke.LambdaMetafactory
import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType

class MinecraftTransform_LWJGL3(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	NativeConstantsV1x0x0.net_minecraft_client_Minecraft,
	"Minecraft",
	scanning,
	classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val callbackDesc = ClassDesc.of("org.lwjgl.glfw.GLFWErrorCallback")
		val glfwDesc = ClassDesc.of("org.lwjgl.glfw.GLFW")
		val memoryUtilDesc = ClassDesc.of("org.lwjgl.system.MemoryUtil")
		val glDesc = ClassDesc.of("org.lwjgl.opengl.GL")
		val glCapabilitiesDesc = ClassDesc.of("org.lwjgl.opengl.GLCapabilities")
		val minecraftDesc = ClassDesc.of("net.minecraft.client.Minecraft")
		val minecraftAppletDesc = ClassDesc.of("net.minecraft.client.MinecraftApplet")
		val glfwErrorCallbackIDesc = ClassDesc.of("org.lwjgl.glfw.GLFWErrorCallbackI")
		val glfwErrorCallbackDesc = ClassDesc.of("org.lwjgl.glfw.GLFWErrorCallback")

		classBuilder.withVersion(ClassFile.latestMajorVersion(), ClassFile.latestMinorVersion())

		val startGame = classBuilder.transformMethodCode(
			classElement,
			"a",
			DEFAULT_VOID
		) { codeBuilder, codeElement, index ->
			when (index) {
				// todo instruction index 0 and 4 to 123 relating to LWJGL2 code has been dropped, replace with modern LWJGL
				0 -> {
					codeBuilder
						.getstatic(
							System::class.classDesc,
							"err",
							PrintStream::class.classDesc
						)
						.invokestatic(
							callbackDesc,
							"createPrint",
							MethodTypeDesc.of(callbackDesc, PrintStream::class.classDesc)
						)
						.invokevirtual( // Setup error callback
							callbackDesc,
							"set",
							MethodTypeDesc.of(callbackDesc)
						)
						.pop()

						.invokestatic( // Init GLFW
							glfwDesc,
							"glfwInit",
							MethodTypeDesc.of(ConstantDescs.CD_boolean)
						)
						.pop()

						.aload(0) // create the GL window
						.loadConstant(800)
						.loadConstant(800)
						.loadConstant("Minecraft 1.0 - LWJGL3".toConstantDesc())
						.getstatic(
							memoryUtilDesc,
							"NULL",
							ConstantDescs.CD_long
						)
						.getstatic(
							memoryUtilDesc,
							"NULL",
							ConstantDescs.CD_long
						)
						.invokestatic(
							glfwDesc,
							"glfwCreateWindow",
							MethodTypeDesc.of(
								ConstantDescs.CD_long,
								ConstantDescs.CD_int,
								ConstantDescs.CD_int,
								CharSequence::class.classDesc,
								ConstantDescs.CD_long,
								ConstantDescs.CD_long
							)
						)
						.putfield(minecraftDesc, "window", ConstantDescs.CD_long)

						.aload(0) // Make the OpenGL context current
						.getfield(minecraftDesc, "window", ConstantDescs.CD_long)
						.invokestatic(
							glfwDesc,
							"glfwMakeContextCurrent",
							MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long)
						)

						.iconst_1() // Enable v-sync
						.invokestatic(
							glfwDesc,
							"glfwSwapInterval",
							MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_int)
						)

						.aload(0)  // Make the window visible
						.getfield(minecraftDesc, "window", ConstantDescs.CD_long)
						.invokestatic(
							glfwDesc,
							"glfwShowWindow",
							MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long)
						)

						.invokestatic( // Create the gl capabilities
							glDesc,
							"createCapabilities",
							MethodTypeDesc.of(glCapabilitiesDesc)
						)
						.pop()
				}

				else if (
					index !in 0 .. 2 && // Drop try catch instructions
					index !in 4 .. 123 && // Drop Display && PixelFormat code
					index !in 248 .. 252 && // Drop Keyboard.create && Mouse.create
					index !in 253 .. 259 && // Drop mouseHelper field assignment
					index !in 261 .. 263 // Drop Controllers.create try catch
				) -> codeBuilder.with(codeElement)
			}
		}
		val loadScreen = classBuilder.transformMethodCode(
			classElement,
			"v"
		) { codeBuilder, codeElement, index ->
			if (index == 172) codeBuilder
				.aload(0)
				.getfield(minecraftDesc, "window", ConstantDescs.CD_long)
				.invokestatic(
					glfwDesc,
					"glfwSwapBuffers",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long)
				)
			else codeBuilder.with(codeElement)
		}
		val init = classBuilder.transformMethodCode(
			classElement,
			ConstantDescs.INIT_NAME
		) { codeBuilder, codeElement, index ->
			val callBackDescriptor = MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_int, ConstantDescs.CD_long)
			val metafactoryDesc = MethodHandleDesc.ofMethod(
				DirectMethodHandleDesc.Kind.STATIC,
				LambdaMetafactory::class.classDesc,
				"metafactory",
				MethodTypeDesc.of(
					CallSite::class.classDesc,
					MethodHandles.Lookup::class.classDesc,
					ConstantDescs.CD_String,
					MethodType::class.classDesc,
					MethodType::class.classDesc,
					MethodHandle::class.classDesc,
					MethodType::class.classDesc
				)
			)

			if (index == 3) codeBuilder
				.aload(0)
				.loadConstant("".toConstantDesc())
				.putfield(minecraftDesc, "errorSection", ConstantDescs.CD_String)

				// todo java.lang.VerifyError: Expecting a stackmap frame at branch target 39
				.aload(0)
				.aload(0)
				.invokedynamic(
					DynamicCallSiteDesc.of(
						metafactoryDesc,
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
			codeBuilder.with(codeElement)

			/*
			MethodHandleDesc.ofMethod(
							DirectMethodHandleDesc.Kind.valueOf(REF_invokeVirtual),
							minecraftDesc,
							"defaultErrorCallback",
							MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_int, ConstantDescs.CD_long)
						)
			 */

		}
		// There's no proper name in the deobfuscated class, but the code inside appears to refer to the game loop
		val func_40001_x = classBuilder.transformMethodCode(
			classElement,
			"x"
		) { codeBuilder, codeElement, index ->
//			println("$index, $codeElement")
			codeBuilder.with(codeElement)
		}
		val checkGlErrorRemove =
			classElement is MethodModel &&
			classElement.methodName().equalsString("d") &&
			classElement.methodTypeSymbol() == MethodTypeDesc.of(
		ConstantDescs.CD_void, ConstantDescs.CD_String
			)

		classBuilder.addMethodWithCode(
			"setErrorSection",
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_String),
			ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.aload(1)
				.putfield(minecraftDesc, "errorSection", ConstantDescs.CD_String)
				.return_()
		}

		classBuilder.addMethodWithCode(
			"defaultErrorCallback",
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_int, ConstantDescs.CD_long),
			ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder.return_()
		}

		classBuilder.addField("window", ConstantDescs.CD_long, ACC_PUBLIC)
		classBuilder.addField("glfwErrorCallback", glfwErrorCallbackDesc, ACC_PUBLIC)
		classBuilder.addField("errorSection", ConstantDescs.CD_String, ACC_PRIVATE)

		if (!(startGame || loadScreen || checkGlErrorRemove || init || func_40001_x)) classBuilder.with(classElement)
	}
}