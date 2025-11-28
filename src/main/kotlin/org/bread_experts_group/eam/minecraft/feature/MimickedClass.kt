package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.DefiningClassLoader
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile.StackMapsOption
import java.lang.classfile.ClassFile.of
import java.lang.constant.ClassDesc
import java.lang.reflect.Constructor
import java.nio.file.Files
import kotlin.io.path.Path

abstract class MimickedClass(@JvmField var around: Any) {
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
		writeFile: Boolean = false,
		builder: (ClassBuilder, String) -> Unit
	): Constructor<*> {
		val cf = of(StackMapsOption.GENERATE_STACK_MAPS)
		val cl = DefiningClassLoader()
		val name = "EAM_NativeMimic_${mimicClass.simpleName}"

		return cl.define(
			name,
			cf.build(ClassDesc.of(name)) { builder(it, name) }
				.also { if (writeFile) Files.write(Path("$name.class"), it) }
		).constructors[0]
	}

	override fun equals(other: Any?): Boolean = around == other
	override fun hashCode(): Int = around.hashCode()
	override fun toString(): String = around.toString()
}