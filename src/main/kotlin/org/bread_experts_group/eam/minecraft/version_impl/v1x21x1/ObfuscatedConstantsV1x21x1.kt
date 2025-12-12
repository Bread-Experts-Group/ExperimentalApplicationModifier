package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

// todo might look into this more instead of manually defining the translation keys from mimic -> native in NativeLookup
object ObfuscatedConstantsV1x21x1 {
	init {
		val stringFields = this::class.java.fields.filter { it.type == String::class.java }
		val stringMap: Map<String, String> = buildMap {
			stringFields.forEach { field ->
				val qualifiedName = field.name.replace('_', '.')
				this[qualifiedName] = field.get(this) as String
			}
		}
	}
}