package org.bread_experts_group.eam.minecraft.mimic

import java.lang.classfile.instruction.LocalVariable
import java.lang.constant.ClassDesc
import java.lang.reflect.Parameter
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

/**
 * Provides a "translation" layer to retrieve native class names from supplied mimic classes.
 * 
 * - Primarily used in edge cases where [org.bread_experts_group.eam.minecraft.invokeStaticWithLocalVars]
 * attempts to load a duplicate class definition, causing a LinkageError.
 */
abstract class MimicLookup {
	fun findNativeInLocalVars(mimicParameter: Parameter, localVars: List<LocalVariable>) : LocalVariable {
		val kClass: KClass<*> = mimicParameter.type.kotlin
		require(kClass.isSubclassOf(MimickedClass::class)) { "Parameter does not subclass MimickedClass!" }

		val nativeClassName: String = this.resolveNativeNameFromMimic(kClass)

		return localVars.find {
			it.typeSymbol().displayName() == nativeClassName
		} ?: throw NullPointerException("Local variable not found with provided native name.")
	}

	abstract fun resolveNativeNameFromMimic(mimic: KClass<*>): String

	fun nativeClassDesc(mimic: KClass<*>): ClassDesc = ClassDesc.of(this.resolveNativeNameFromMimic(mimic))
}