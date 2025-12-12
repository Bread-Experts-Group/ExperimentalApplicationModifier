package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.eam.classDesc
import java.lang.constant.ClassDesc

data class Identifier(val namespace: String, val subject: String) {
	companion object {
		val classDesc: ClassDesc = Identifier::class.classDesc
	}
	override fun equals(other: Any?): Boolean =
		other is Identifier && other.namespace == namespace && other.subject == subject

	override fun hashCode(): Int {
		var result = namespace.hashCode()
		result = 31 * result + subject.hashCode()
		return result
	}
}