package org.bread_experts_group.eam.minecraft.mimic

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeLookupV1x21x1
import java.lang.classfile.instruction.LocalVariable
import java.lang.constant.ClassDesc
import java.lang.reflect.Parameter
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

/**
 * Provides a "translation" layer to retrieve native class names from supplied mimic classes.
 * 
 * - Should be used in edge cases where class transforms attempt to load a duplicate class definition, causing a LinkageError.
 */
abstract class NativeLookup {
	companion object {
		fun getLookup(clazz: Class<*>): NativeLookup {
			val name = clazz.packageName

			return when {
				name.contains("v1x21x1") -> NativeLookupV1x21x1

				else -> throw NullPointerException("Lookup cannot be found for $name")
			}
		}
	}

	fun findNativeInLocalVars(mimicParameter: Parameter, localVars: List<LocalVariable>) : LocalVariable {
		val kClass: KClass<*> = mimicParameter.type.kotlin
		require(kClass.isSubclassOf(MimickedClass::class)) { "Parameter does not subclass MimickedClass!" }

		val nativeClassName: String = this.resolveNativeNameFromClass(kClass)

		return localVars.find {
			it.typeSymbol().displayName() == nativeClassName
		} ?: throw NullPointerException("Local variable not found with provided native name.")
	}

	abstract fun resolveNativeNameFromClass(clazz: KClass<*>): String

	fun nativeClassDesc(clazz: KClass<*>): ClassDesc = ClassDesc.of(this.resolveNativeNameFromClass(clazz))
}