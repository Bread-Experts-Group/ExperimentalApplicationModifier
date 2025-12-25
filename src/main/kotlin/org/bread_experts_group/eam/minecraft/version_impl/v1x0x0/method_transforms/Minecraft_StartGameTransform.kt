package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.method_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.transform.MethodTransform
import org.bread_experts_group.eam.toConstantDesc
import java.io.PrintStream
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.CodeBuilder
import java.lang.classfile.CodeElement
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class Minecraft_StartGameTransform(
	classBuilder: ClassBuilder,
	classElement: ClassElement,
	owningClass: ClassDesc
) : MethodTransform(classBuilder, classElement, "a", owningClass, DEFAULT_VOID) {
	private val callbackDesc = ClassDesc.of("org.lwjgl.glfw.GLFWErrorCallback")
	private val glfwDesc = ClassDesc.of("org.lwjgl.glfw.GLFW")
	private val memoryUtilDesc = ClassDesc.of("org.lwjgl.system.MemoryUtil")
	private val glDesc = ClassDesc.of("org.lwjgl.opengl.GL")
	private val glCapabilitiesDesc = ClassDesc.of("org.lwjgl.opengl.GLCapabilities")

	override fun transform(): (CodeBuilder, CodeElement, Int) -> Unit = { codeBuilder, codeElement, index ->
		when (index) {
			// todo instruction index 0 and 4 to 123 relating to LWJGL2 code has been dropped, replace with modern LWJGL
			0 -> codeBuilder
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
				.loadConstant(854)
				.loadConstant(480)
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
				.putfield(owningClass, "window", ConstantDescs.CD_long)

				.aload(0) // Make the OpenGL context current
				.getfield(owningClass, "window", ConstantDescs.CD_long)
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

				.aload(0)
				.aload(0) // setup mouse button callbacks
				.getfield(owningClass, "window", ConstantDescs.CD_long)
				.invokevirtual(
					owningClass,
					"setupKeyCallbacks",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long)
				)

				.aload(0) // todo injected mouse pos fields aren't being seen by the Minecraft class, look into later
				.aload(0) // setup cursor pos callbacks
				.getfield(owningClass, "window", ConstantDescs.CD_long)
				.invokevirtual(
					owningClass,
					"setupMouseCallbacks",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long)
				)

				.aload(0)
				.aload(0) // setup keyboard callbacks
				.getfield(owningClass, "window", ConstantDescs.CD_long)
				.invokevirtual(
					owningClass,
					"setupCursorPosCallbacks",
					MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_long)
				)

				.aload(0)  // Make the window visible
				.getfield(owningClass, "window", ConstantDescs.CD_long)
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

			276, 313, 442 -> codeBuilder.invokespecial(
				owningClass,
				"setErrorSection",
				MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_String)
			)

			else if (
				index !in 0 .. 2 && // Drop try catch instructions
				index !in 4 .. 123 && // Drop Display && PixelFormat code
				index !in 248 .. 252 && // Drop Keyboard.create && Mouse.create
				index !in 253 .. 259 && // Drop mouseHelper field assignment
				index !in 261 .. 263 // Drop Controllers.create try catch
			) -> codeBuilder.with(codeElement)
		}
	}
}