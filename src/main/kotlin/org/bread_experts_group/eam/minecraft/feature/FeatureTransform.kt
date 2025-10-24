package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.DefiningClassLoader
import org.bread_experts_group.eam.minecraft.CodeTransformer
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.StackMapsOption
import java.lang.classfile.ClassFile.of
import java.lang.constant.ClassDesc

abstract class FeatureTransform<I>(val input: I) : CodeTransformer {
	private var c: Int = 0
	private val cf: ClassFile = of(StackMapsOption.GENERATE_STACK_MAPS)
	private val cl: DefiningClassLoader = DefiningClassLoader()

	abstract fun startTransform(name: String): (ClassBuilder) -> Any
	protected abstract fun createInstance(clazz: Class<*>): Any

	fun build(): Any {
		val name = input!!::class.qualifiedName ?: "eamInternal${c++}"
		return createInstance(cl.define(
			name,
			cf.build(ClassDesc.of(name)) { classBuilder ->
				this.startTransform(name).invoke(classBuilder)
			}
		))
	}
}