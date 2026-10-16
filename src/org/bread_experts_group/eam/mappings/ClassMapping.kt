package org.bread_experts_group.eam.mappings

import org.bread_experts_group.eam.mappings.MappingsBuilder.Companion.parseReturnType

data class ClassMapping(
    val name: String,
    val obfuscatedName: String,
    val inits: MutableList<MethodMapping> = mutableListOf()
) {

    fun addInit(input: String) {
        val noParams = input.contains("()")
        val params = input.substringAfter("(").substringBefore(")").split(",")
        val descriptor = params.joinToString("") { parseReturnType(it) }
        val desc = if (noParams) "" else descriptor
        inits.add(MethodMapping("<init>", "<init>", "V", params, "($desc)V"))
    }
}