package org.bread_experts_group.eam.minecraft.mimic

import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.LevelRendererTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Camera
import java.lang.classfile.instruction.LocalVariable
import java.lang.constant.ClassDesc
import java.lang.reflect.Parameter
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

/**
 * Provides a "translation" layer to retrieve native class names from supplied mimic classes.
 *
 * ### Cases found when using [MimickedClass]#classDesc directly in transforms
 * - Class transforms attempt to load a duplicate class definition, causing a [LinkageError].
 * Usually caused when a [ClassDesc] directly referencing the target class is used in the transform.
 *
 * - Classes missing fields / methods in runtime when they're used in a transform, *example being [Camera] in [LevelRendererTransform]*
 */
abstract class NativeLookup {
	companion object {
		fun getLookup(clazz: Class<*>): NativeLookup {
			val name = clazz.packageName

			return when {
				name.contains("v1x21x1") -> NativeConstantsV1x21x1

				else -> throw NullPointerException("Lookup cannot be found for $name")
			}
		}
	}

	private val allFields: Map<String, String> = buildMap {
		val stringFields = this@NativeLookup::class.java.fields.filter { it.type == String::class.java }
		stringFields.forEach {
			this[it.name.substringAfterLast('_')] = it.get(null) as String
		}
	}

	fun resolveNativeNameFromClass(clazz: KClass<*>): String =
		allFields[clazz.simpleName] ?: throw IllegalStateException("Native class name for ${clazz.simpleName} not implemented.")

	fun resolveMimicNameFromNative(name: String): String? =
		allFields.entries.find { name == it.value }?.key /*?:
		throw IllegalStateException("Cannot resolve mimic for class $name, is it defined in the NativeLookup impl?")*/

	fun findNativeInLocalVars(mimicParameter: Parameter, localVars: List<LocalVariable>) : LocalVariable {
		val kClass: KClass<*> = mimicParameter.type.kotlin
		require(kClass.isSubclassOf(MimickedClass::class)) { "Parameter does not subclass MimickedClass!" }

		val nativeClassName: String = this.resolveNativeNameFromClass(kClass)

		return localVars.find {
			it.typeSymbol().displayName() == nativeClassName
		} ?: throw NullPointerException("Local variable not found with provided native name.")
	}

	fun nativeClassDesc(clazz: KClass<*>): ClassDesc = ClassDesc.of(this.resolveNativeNameFromClass(clazz))
}