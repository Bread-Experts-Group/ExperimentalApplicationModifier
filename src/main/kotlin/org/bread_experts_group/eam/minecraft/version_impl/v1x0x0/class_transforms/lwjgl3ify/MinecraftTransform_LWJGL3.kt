package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.LAMBDA_METAFACTORY_METHOD_HANDLE
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.loadConstant
import org.bread_experts_group.eam.minecraft.localVariable
import org.bread_experts_group.eam.minecraft.println
import org.bread_experts_group.eam.minecraft.stringBuilderAppend
import org.bread_experts_group.eam.minecraft.stringBuilderInvoke
import org.bread_experts_group.eam.minecraft.stringBuilderToString
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.method_transforms.Minecraft_InitTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.method_transforms.Minecraft_RunTickTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.method_transforms.Minecraft_StartGameTransform
import java.io.File
import java.io.PrintStream
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PRIVATE
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_SYNTHETIC
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.BranchInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.DirectMethodHandleDesc
import java.lang.constant.DynamicCallSiteDesc
import java.lang.constant.MethodHandleDesc
import java.lang.constant.MethodTypeDesc
import java.nio.IntBuffer

class MinecraftTransform_LWJGL3(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	NativeConstantsV1x0x0.net_minecraft_client_Minecraft,
	"Minecraft",
	scanning,
	classFile
) {
	private val guiScreenDesc = ClassDesc.of(NativeConstantsV1x0x0.net_minecraft_GuiScreen)
	private val callbackDesc = ClassDesc.of("org.lwjgl.glfw.GLFWErrorCallback")
	private val glfwDesc = ClassDesc.of("org.lwjgl.glfw.GLFW")
	private val memoryUtilDesc = ClassDesc.of("org.lwjgl.system.MemoryUtil")
	private val glDesc = ClassDesc.of("org.lwjgl.opengl.GL")
	private val glCapabilitiesDesc = ClassDesc.of("org.lwjgl.opengl.GLCapabilities")
	private val minecraftAppletDesc = ClassDesc.of("net.minecraft.client.MinecraftApplet")
	private val glfwErrorCallbackDesc = ClassDesc.of("org.lwjgl.glfw.GLFWErrorCallback")
	private val glfwErrorCallbackIDesc = ClassDesc.of("org.lwjgl.glfw.GLFWErrorCallbackI")
	private val glfwKeyCallbackDesc = ClassDesc.of("org.lwjgl.glfw.GLFWKeyCallback")
	private val glfwKeyCallbackIDesc = ClassDesc.of("org.lwjgl.glfw.GLFWKeyCallbackI")
	private val glfwMouseButtonCallbackDesc = ClassDesc.of("org.lwjgl.glfw.GLFWMouseButtonCallback")
	private val glfwMouseButtonCallbackIDesc = ClassDesc.of("org.lwjgl.glfw.GLFWMouseButtonCallbackI")
	private val glfwCursorPosCallbackDesc = ClassDesc.of("org.lwjgl.glfw.GLFWCursorPosCallback")
	private val glfwCursorPosCallbackIDesc = ClassDesc.of("org.lwjgl.glfw.GLFWCursorPosCallbackI")
	private val entityRendererDesc = ClassDesc.of(NativeConstantsV1x0x0.net_minecraft_EntityRenderer)

	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->

		val startGame = Minecraft_StartGameTransform(classBuilder, classElement, thisClassDesc).run()
		val init = Minecraft_InitTransform(classBuilder, classElement, thisClassDesc).run()
		val runTick = Minecraft_RunTickTransform(classBuilder, classElement, thisClassDesc).run()

		val loadScreen = classBuilder.transformMethodCode(
			classElement,
			"v"
		) { codeBuilder, codeElement, index ->
			if (index == 172) codeBuilder
				.aload(0)
				.getfield(thisClassDesc, "window", ConstantDescs.CD_long)
				.invokestatic(
					glfwDesc,
					"glfwSwapBuffers",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long)
				)
			else codeBuilder.with(codeElement)
		}
		val main = classBuilder.transformMethodCode(
			classElement,
			"main"
		) { codeBuilder, _, _ ->
			codeBuilder
				.aload(0)
				.iconst_0()
				.aaload()
				.aload(0)
				.iconst_1()
				.aaload()
				.invokestatic(
					thisClassDesc,
					"a",
					MethodTypeDesc.of(
						ConstantDescs.CD_void,
						ConstantDescs.CD_String,
						ConstantDescs.CD_String
					)
				)
				.return_()
		}
		val func_40001_x = applyFunc_40001_xTransform(classBuilder, classElement)
		val checkGlErrorRemove =
			classElement is MethodModel &&
			classElement.methodName().equalsString("d") &&
			classElement.methodTypeSymbol() == MethodTypeDesc.of(
		ConstantDescs.CD_void, ConstantDescs.CD_String
			)
		val shutdownMinecraftApplet = classBuilder.transformMethodCode(
			classElement,
			"d",
			DEFAULT_VOID
		) { codeBuilder, codeElement, index ->
			when (index) {
				else if (index !in listOf(68, 70, 73, 85)) -> codeBuilder.with(codeElement)
			}
		}
		val toggleFullscreen = classBuilder.transformMethodCode(
			classElement,
			"j",
			DEFAULT_VOID
		) { codeBuilder, codeElement, index ->
			IntBuffer.allocate(1)[0]
			when (index) {
				2 -> codeBuilder
					.localVariable(1, "widthBuffer", IntBuffer::class.classDesc)
					.localVariable(2, "heightBuffer", IntBuffer::class.classDesc)

					.iconst_1()
					.invokestatic(
						IntBuffer::class.classDesc,
						"allocate",
						MethodTypeDesc.of(IntBuffer::class.classDesc, ConstantDescs.CD_int)
					)
					.astore(1)
					.iconst_1()
					.invokestatic(
						IntBuffer::class.classDesc,
						"allocate",
						MethodTypeDesc.of(IntBuffer::class.classDesc, ConstantDescs.CD_int)
					)
					.astore(2)

				48 -> codeBuilder
					.aload(0)
					.getfield(thisClassDesc, "window", ConstantDescs.CD_long)
					.aload(1)
					.aload(2)
					.invokestatic(
						glfwDesc,
						"glfwGetWindowSize",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							ConstantDescs.CD_long,
							IntBuffer::class.classDesc,
							IntBuffer::class.classDesc
						)
					).aload(0)
					.getfield(thisClassDesc, "window", ConstantDescs.CD_long)
					.aload(1)
					.aload(2)
					.invokestatic(
						glfwDesc,
						"glfwGetWindowSize",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							ConstantDescs.CD_long,
							IntBuffer::class.classDesc,
							IntBuffer::class.classDesc
						)
					)
					.aload(0)
					.aload(1)
					.iconst_0()
					.invokevirtual(
						IntBuffer::class.classDesc,
						"get",
						MethodTypeDesc.of(ConstantDescs.CD_int, ConstantDescs.CD_int)
					)
					.putfield(thisClassDesc, "d", ConstantDescs.CD_int)
					.aload(0)
					.aload(2)
					.iconst_0()
					.invokevirtual(
						IntBuffer::class.classDesc,
						"get",
						MethodTypeDesc.of(ConstantDescs.CD_int, ConstantDescs.CD_int)
					)
					.putfield(thisClassDesc, "e", ConstantDescs.CD_int)

				else if (index !in 48 .. 90) -> codeBuilder.with(codeElement)
			}
		}

		addSetErrorSection(classBuilder)
		addDefaultErrorCallback(classBuilder)
		addSetupKeyCallbacks(classBuilder)
		addSetupMouseCallbacks(classBuilder)
		addSetupCursorPosCallbacks(classBuilder)

		classBuilder.addField("window", ConstantDescs.CD_long, ACC_PUBLIC)
		classBuilder.addField("glfwErrorCallback", glfwErrorCallbackDesc, ACC_PUBLIC)
		classBuilder.addField("errorSection", ConstantDescs.CD_String, ACC_PRIVATE)
		classBuilder.addField("mouseHandler", MouseHandler::class.classDesc, ACC_PUBLIC)

		val modified = startGame || loadScreen || checkGlErrorRemove || init || main || func_40001_x || runTick || shutdownMinecraftApplet || toggleFullscreen
		if (!modified) classBuilder.with(classElement)
	}

	private fun addSetErrorSection(classBuilder: ClassBuilder) {
		classBuilder.addMethodWithCode(
			"setErrorSection",
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_String),
			ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.aload(1)
				.putfield(thisClassDesc, "errorSection", ConstantDescs.CD_String)
				.return_()
		}
	}

	private fun addDefaultErrorCallback(classBuilder: ClassBuilder) {
		classBuilder.addMethodWithCode(
			"defaultErrorCallback",
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_int, ConstantDescs.CD_long),
			ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.localVariable(3, "string", ConstantDescs.CD_String)
				.lload(2)
				.invokestatic(
					memoryUtilDesc,
					"memUTF8",
					MethodTypeDesc.of(ConstantDescs.CD_String, ConstantDescs.CD_long)
				)
				.astore(3)
				.println("########## GL ERROR ##########")
				.getstatic(
					System::class.classDesc,
					"out",
					PrintStream::class.classDesc
				)
				.stringBuilderInvoke()
				.loadConstant("@")
				.stringBuilderAppend()
				.iload(1)
				.invokestatic(
					Integer::class.classDesc,
					"toString",
					MethodTypeDesc.of(ConstantDescs.CD_String, ConstantDescs.CD_int)
				)
				.stringBuilderAppend()
				.stringBuilderToString()
				.invokevirtual(
					PrintStream::class.classDesc,
					"println",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_String)
				)
				.getstatic(
					System::class.classDesc,
					"out",
					PrintStream::class.classDesc
				)
				.stringBuilderInvoke()
				.iload(1)
				.invokestatic(
					Integer::class.classDesc,
					"toString",
					MethodTypeDesc.of(ConstantDescs.CD_String, ConstantDescs.CD_int)
				)
				.stringBuilderAppend()
				.loadConstant(":")
				.stringBuilderAppend()
				.aload(3)
				.stringBuilderAppend()
				.stringBuilderToString()
				.invokevirtual(
					PrintStream::class.classDesc,
					"println",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_String)
				)
				.return_()
		}
	}

	private fun addSetupKeyCallbacks(classBuilder: ClassBuilder) {
		val keyCallbackDesc = MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long, ConstantDescs.CD_int, ConstantDescs.CD_int, ConstantDescs.CD_int, ConstantDescs.CD_int)
		classBuilder.addMethodWithCode(
			"setupKeyCallbacks",
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long),
			ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.lload(1)
				.aload(0)
				.invokedynamic(
					DynamicCallSiteDesc.of(
						LAMBDA_METAFACTORY_METHOD_HANDLE,
						"invoke",
						MethodTypeDesc.of(glfwKeyCallbackIDesc, thisClassDesc),
						keyCallbackDesc,
						MethodHandleDesc.ofMethod(
							DirectMethodHandleDesc.Kind.VIRTUAL,
							thisClassDesc,
							$$"Minecraft$setupKeyCallbacks$lambda$1",
							keyCallbackDesc
						),
						keyCallbackDesc
					)
				)
				.invokestatic(
					glfwDesc,
					"glfwSetKeyCallback",
					MethodTypeDesc.of(glfwKeyCallbackDesc, ConstantDescs.CD_long, glfwKeyCallbackIDesc)
				)
				.pop()
				.return_()
		}

		classBuilder.addMethodWithCode(
			$$"Minecraft$setupKeyCallbacks$lambda$1",
			keyCallbackDesc,
			ACC_PRIVATE or ACC_SYNTHETIC
		) { codeBuilder ->
			val label = codeBuilder.newLabel()
			codeBuilder
				.iload(3)
				.getstatic(
					glfwDesc,
					"GLFW_KEY_F2",
					ConstantDescs.CD_int
				)
				.if_icmpne(label)
				.iload(5)
				.getstatic(
					glfwDesc,
					"GLFW_PRESS",
					ConstantDescs.CD_int
				)
				.if_icmpne(label)
				.aload(0)
				.getfield(thisClassDesc, "w", ClassDesc.of("qd")) // GuiInGame
				.getstatic(
					thisClassDesc,
					"aj",
					File::class.classDesc,
				)
				.aload(0)
				.getfield(
					thisClassDesc,
					"d",
					ConstantDescs.CD_int
				)
				.aload(0)
				.getfield(
					thisClassDesc,
					"e",
					ConstantDescs.CD_int
				)
				.invokestatic(
					ClassDesc.of("abx"),
					"a",
					MethodTypeDesc.of(
						ConstantDescs.CD_String,
						File::class.classDesc,
						ConstantDescs.CD_int,
						ConstantDescs.CD_int
					)
				)
				.invokevirtual(
					ClassDesc.of("qd"),
					"a",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_String)
				)
				.labelBinding(label)
				.return_()
		}
	}

	private fun addSetupCursorPosCallbacks(classBuilder: ClassBuilder) {
		val cursePosCallbackDesc = MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long, ConstantDescs.CD_double, ConstantDescs.CD_double)
		classBuilder.addMethodWithCode(
			"setupCursorPosCallbacks",
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long),
			ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.lload(1)
				.aload(0)
				.invokedynamic(
					DynamicCallSiteDesc.of(
						LAMBDA_METAFACTORY_METHOD_HANDLE,
						"invoke",
						MethodTypeDesc.of(glfwCursorPosCallbackIDesc, thisClassDesc),
						cursePosCallbackDesc,
						MethodHandleDesc.ofMethod(
							DirectMethodHandleDesc.Kind.VIRTUAL,
							thisClassDesc,
							$$"Minecraft$setupCursorCallbacks$lambda$3",
							cursePosCallbackDesc
						),
						cursePosCallbackDesc
					)
				)
				.invokestatic(
					glfwDesc,
					"glfwSetCursorPosCallback",
					MethodTypeDesc.of(glfwCursorPosCallbackDesc, ConstantDescs.CD_long, glfwCursorPosCallbackIDesc)
				)
				.pop()
				.return_()
		}

		classBuilder.addMethodWithCode(
			$$"Minecraft$setupCursorCallbacks$lambda$3",
			cursePosCallbackDesc,
			ACC_PRIVATE or ACC_SYNTHETIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.getfield(
					thisClassDesc,
					"mouseHandler",
					MouseHandler::class.classDesc
				)
				.lload(1)
				.invokevirtual(
					MouseHandler::class.classDesc,
					"setCurrentWindow",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long)
				)
				.aload(0)
				.getfield(
					thisClassDesc,
					"mouseHandler",
					MouseHandler::class.classDesc
				)
				.dload(3)
				.putfield(
					MouseHandler::class.classDesc,
					"cursorX",
					ConstantDescs.CD_double
				)
				.aload(0)
				.getfield(
					thisClassDesc,
					"mouseHandler",
					MouseHandler::class.classDesc
				)
				.dload(5)
				.putfield(
					MouseHandler::class.classDesc,
					"cursorY",
					ConstantDescs.CD_double
				)
				.return_()
		}
	}

	private fun addSetupMouseCallbacks(classBuilder: ClassBuilder) {
		val mouseCallbackDesc = MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long, ConstantDescs.CD_int, ConstantDescs.CD_int, ConstantDescs.CD_int)
		classBuilder.addMethodWithCode(
			"setupMouseCallbacks",
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long),
			ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.lload(1)
				.aload(0)
				.invokedynamic(
					DynamicCallSiteDesc.of(
						LAMBDA_METAFACTORY_METHOD_HANDLE,
						"invoke",
						MethodTypeDesc.of(glfwMouseButtonCallbackIDesc, thisClassDesc),
						mouseCallbackDesc,
						MethodHandleDesc.ofMethod(
							DirectMethodHandleDesc.Kind.VIRTUAL,
							thisClassDesc,
							$$"Minecraft$setupMouseCallbacks$lambda$2",
							mouseCallbackDesc
						),
						mouseCallbackDesc
					)
				)
				.invokestatic(
					glfwDesc,
					"glfwSetMouseButtonCallback",
					MethodTypeDesc.of(glfwMouseButtonCallbackDesc, ConstantDescs.CD_long, glfwMouseButtonCallbackIDesc)
				)
				.pop()
				.return_()
		}

		classBuilder.addMethodWithCode(
			$$"Minecraft$setupMouseCallbacks$lambda$2",
			mouseCallbackDesc,
			ACC_PRIVATE or ACC_SYNTHETIC
		) { codeBuilder ->
			val label = codeBuilder.newLabel()
			codeBuilder
				.aload(0)
				.getfield(
					thisClassDesc,
					"s",
					guiScreenDesc
				)
				.ifnull(label)
				.aload(0)
				.getfield(
					thisClassDesc,
					"s",
					guiScreenDesc
				)
				.aload(0)
				.getfield(
					thisClassDesc,
					"mouseHandler",
					MouseHandler::class.classDesc
				)
				.iload(3)
				.iload(4)
				.iload(5)
				.invokevirtual(
					guiScreenDesc,
					"g",
					MethodTypeDesc.of(
						ConstantDescs.CD_void,
//						ConstantDescs.CD_long, // window
						MouseHandler::class.classDesc,
						ConstantDescs.CD_int, // button
						ConstantDescs.CD_int, // action
						ConstantDescs.CD_int // mods
					)
				)
				.labelBinding(label)
				.return_()
		}
	}

	private fun applyFunc_40001_xTransform(classBuilder: ClassBuilder, classElement: ClassElement): Boolean {
		// There's no proper name in the deobfuscated class, but the code inside appears to refer to the game loop
		return classBuilder.transformMethodCode(
			classElement,
			"x"
		) { codeBuilder, codeElement, index ->
			when (index) {
				27 -> codeBuilder
					.aload(0)
					.getfield(thisClassDesc, "window", ConstantDescs.CD_long)
					.invokestatic(
						glfwDesc,
						"glfwWindowShouldClose",
						MethodTypeDesc.of(ConstantDescs.CD_boolean, ConstantDescs.CD_long)
					)
				120 -> codeBuilder
					.invokestatic(
						glfwDesc,
						"glfwPollEvents",
						DEFAULT_VOID
					)
					.with(codeElement)
				123, 340 -> codeBuilder.invokespecial(
					thisClassDesc,
					"setErrorSection",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_String)
				)
				213 -> codeBuilder
					.aload(0)
					.getfield(thisClassDesc, "window", ConstantDescs.CD_long)
					.invokevirtual(
						entityRendererDesc,
						"b",
						MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_float, ConstantDescs.CD_long)
					)
				222 -> codeBuilder
					.aload(0)
					.getfield(thisClassDesc, "window", ConstantDescs.CD_long)
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
				223 -> {
					val original = codeElement as BranchInstruction
					codeBuilder.if_icmpne(original.target())
				}

				else if (
					index !in 24 .. 26 && // Replace Display.isCloseRequested
					index !in 164 .. 169 && // Delete Display.update & Keyboard
					index !in 271 .. 276 && // Delete Keyboard.isKeyDown & Display.update
					index !in 277 .. 279 // Relocate screenshot call into key callback
				) -> codeBuilder.with(codeElement)
			}
		}
	}
}