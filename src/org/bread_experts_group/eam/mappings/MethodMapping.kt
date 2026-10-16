package org.bread_experts_group.eam.mappings

import org.bread_experts_group.eam.mappings.MappingsBuilder.Companion.parseReturnType

data class MethodMapping(
    val name: String,
    val obfuscatedName: String,
    val returnType: String,
    val parameters: List<String>,
    val descriptor: String
) {
    fun hasNoParams(): Boolean = parameters.isEmpty()

    // todo fix
    fun obfuscatedDescriptor(): String = parameters.joinToString("") {
        val param = if (it.contains(".")) {
            Mappings.obfuscationEntries[it.substringAfterLast(".")] ?: it
        } else it
        val returnType = if (returnType.contains("."))
            "L${Mappings.obfuscationEntries[returnType.substringAfterLast(".").substringBefore(";")]};"
        else returnType
        "(${if (hasNoParams()) "" else parseReturnType(param)})$returnType"
    }
}