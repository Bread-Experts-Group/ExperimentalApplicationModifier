package org.bread_experts_group.eam.minecraft.transform

import org.bread_experts_group.api.feature.FeatureExpression
import org.bread_experts_group.api.feature.FeatureImplementation
import org.bread_experts_group.eam.DefiningClassLoader
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.constant.ClassDesc
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.createParentDirectories

abstract class FeatureTransform<I, E : FeatureImplementation<E>>(
	val input: I,
	private val feature: FeatureExpression<E>
) : CodeTransformer {
	private val cf: ClassFile = ClassFile.of(ClassFile.StackMapsOption.GENERATE_STACK_MAPS)
	private val cl: DefiningClassLoader = DefiningClassLoader()
	override val existingElements: MutableList<String> = mutableListOf()

	abstract fun startTransform(name: String): (ClassBuilder) -> Any
	protected abstract fun createInstance(clazz: Class<*>): Any

	fun build(): Any {
		val name = "EAMGenerated_${feature.name.replace(' ', '_')}"
		return createInstance(cl.define(
			name,
			cf.build(ClassDesc.of(name)) { classBuilder ->
				this.startTransform(name).invoke(classBuilder)
			}.also {
				val path = MinecraftImplementations.arguments.get(MinecraftImplementations.writeTransformedFeatures)
				if (path != null) Files.write(
					Path(path)
						.resolve("$name [${feature.name}].class")
						.createParentDirectories(),
					it
				)
			}
		))
	}
}