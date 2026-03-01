package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack

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

	fun mimicTest(minecraft: Minecraft, stack: ItemStack, bool: Boolean, longVar: Long) {
		val item = stack.getItem()
		val level = minecraft.level
		if (longVar > 10) {
			println(item)
			println(level)
			println(bool)
		}
	}

	fun lambdaTest() {
		Runnable { println("test") }
	}
}