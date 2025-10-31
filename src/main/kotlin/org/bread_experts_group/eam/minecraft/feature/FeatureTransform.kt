package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.DefiningClassLoader
import org.bread_experts_group.eam.minecraft.CodeTransformer
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.StackMapsOption
import java.lang.classfile.ClassFile.of
import java.lang.constant.ClassDesc
import java.nio.file.Files
import kotlin.io.path.Path

abstract class FeatureTransform<I>(val input: I, private val featureName: String) : CodeTransformer {
	private val cf: ClassFile = of(StackMapsOption.GENERATE_STACK_MAPS)
	private val cl: DefiningClassLoader = DefiningClassLoader()

	abstract fun startTransform(name: String): (ClassBuilder) -> Any
	protected abstract fun createInstance(clazz: Class<*>): Any

	fun build(): Any {
		val name = "EAMGenerated_$featureName"
		return createInstance(cl.define(
			name,
			cf.build(ClassDesc.of(name)) { classBuilder ->
				this.startTransform(name).invoke(classBuilder)
			}.also { Files.write(Path("$name.class"), it) }
		))
	}
}