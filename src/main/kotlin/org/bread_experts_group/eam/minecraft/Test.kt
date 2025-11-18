package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.numeric.geometry.Matrix4F
import org.bread_experts_group.numeric.geometry.Vector4F
import kotlin.math.tan

class Test {
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
}