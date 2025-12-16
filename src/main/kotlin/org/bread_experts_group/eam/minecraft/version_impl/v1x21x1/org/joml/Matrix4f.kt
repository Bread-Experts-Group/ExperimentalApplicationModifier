package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.org.joml

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.org_joml_Matrix4f
import java.lang.constant.ClassDesc

class Matrix4f(around: Any) : Matrix4fc(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(org_joml_Matrix4f)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Matrix4f::class.classDesc
	}

	constructor() : this(clazz.getConstructor().newInstance())

	fun identity(): Matrix4f = Matrix4f(clazz.getMethod("identity").invoke(around))

	fun perspective(fovy: Float, aspect: Float, zNear: Float, zFar: Float): Matrix4f = Matrix4f(
		clazz.getMethod("perspective", Float::class.java, Float::class.java, Float::class.java, Float::class.java)
			.invoke(around, fovy, aspect, zNear, zFar)
	)

	fun mul(right: Matrix4fc) {
		clazz.getMethod("mul", Matrix4fc.clazz)
			.invoke(around, right.around)
	}

	fun rotation(dest: Quaternionfc): Matrix4f = Matrix4f(
		clazz.getMethod("rotation", Quaternionfc.clazz)
			.invoke(around, dest.around)
	)

	fun set(m: Matrix4fc) : Matrix4f = Matrix4f(
		clazz.getMethod("set", Matrix4fc.clazz)
			.invoke(around, m.around)
	)

	fun transformPosition(x: Float, y: Float, z: Float, dest: Vector3f): Vector3f = Vector3f(
		clazz.getMethod("transformPosition",Float::class.java, Float::class.java, Float::class.java, Vector3f.clazz)
			.invoke(around, x, y, z, dest.around)
	)
}