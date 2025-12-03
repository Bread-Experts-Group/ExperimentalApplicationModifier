package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.numeric.geometry.Matrix4F
import org.bread_experts_group.numeric.geometry.Vector4F
import kotlin.math.tan

/**
 * ClassBuilder method integration test class.
 */
class Test {
	/*
		classBuilder.integrateMethod(Test::class.java, "perspective")
		classBuilder.integrateMethod(Test::class.java, "test")
		classBuilder.integrateMethod(Test::class.java, "mimicTest", generateMimicMethod = true)
	 */

	fun test() {
		println("this is a test...")
		val isTrue = System.currentTimeMillis() > 30
		if (isTrue) {
			println("lmao")
		}
	}

	fun perspective(fovYRadians: Float, aspect: Float, zNear: Float, zFar: Float): Matrix4F {
		val f = 1f / tan(fovYRadians / 2f)
		return Matrix4F(
			Vector4F(f / aspect, 0f, 0f, 0f),
			Vector4F(0f, f, 0f, 0f),
			Vector4F(0f, 0f, (zFar + zNear) / (zNear - zFar), -1f),
			Vector4F(0f, 0f, (2f * zFar * zNear) / (zNear - zFar), 0f)
		)
	}

	fun mimicTest(minecraft: Minecraft, stack: ItemStack, bool: Boolean, longVar: Long) {
		val item = stack.getItem()
		val level = minecraft.level
		if (longVar > 10) {
			println(item)
			println(level)
			println(bool)
		}
	}

	fun lambdaTest(lambda: () -> Unit) {
		lambda.invoke()
	}

	fun lambdaExecuteTest() {
		lambdaTest { println("test") }
	}
}