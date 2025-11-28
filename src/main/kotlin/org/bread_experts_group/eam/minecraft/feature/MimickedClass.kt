package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.DefiningClassLoader
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeMimics
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile.StackMapsOption
import java.lang.classfile.ClassFile.of
import java.lang.constant.ClassDesc
import java.lang.reflect.Constructor
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.createParentDirectories

abstract class MimickedClass(
	@JvmField var around: Any
) {
	companion object {
		val classDesc: ClassDesc = ClassDesc.of(MimickedClass::class.qualifiedName)
	}
	/**
	 * Used for implementing native classes into this [MimickedClass].
	 *
	 * @return The constructor for the generated class.
	 */
	fun implementNative(
		mimicClass: Class<*>,
		builder: (ClassBuilder, String) -> Unit
	): Constructor<*> {
		val cf = of(StackMapsOption.GENERATE_STACK_MAPS)
		val cl = DefiningClassLoader()
		val name = "EAM_NativeMimic_${mimicClass.simpleName}"
		val built = cf.build(ClassDesc.of(name)) { builder(it, name) }

		val path = MinecraftImplementations.arguments.get(writeMimics)
		if (path != null) Files.write(
			Path(path)
				.resolve("$name.class")
				.createParentDirectories(),
			built
		)

		return cl.define(name, built).constructors[0]
	}

	override fun equals(other: Any?): Boolean = around == other
	override fun hashCode(): Int = around.hashCode()
	override fun toString(): String = around.toString()
}