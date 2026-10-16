package org.bread_experts_group.eam.mappings

class MappingsBuilder {
    companion object {
        fun parseReturnType(input: String): String = when (input) {
            "byte" -> "B"
            "char" -> "C"
            "double" -> "D"
            "float" -> "F"
            "int" -> "I"
            "long" -> "J"
            "short" -> "S"
            "boolean" -> "Z"
            "void" -> "V"
            else -> "L${input.replace(".", "/")};"
        }
    }

    private var currentClassMapping: ClassMapping? = null
    private val methodMappings: MutableList<MethodMapping> = mutableListOf()
    private val fieldMappings: MutableList<FieldMapping> = mutableListOf()
    private val finalMappings: MutableMap<ClassMapping, Pair<List<FieldMapping>, List<MethodMapping>>> = mutableMapOf()

    fun parseClass(classInput: String) {
        currentClassMapping?.let {
            finalMappings[it] = buildList { this.addAll(fieldMappings) } to buildList { this.addAll(methodMappings) }
            fieldMappings.clear()
            methodMappings.clear()
            currentClassMapping = null
        }
        val unobfuscated = classInput.substringBefore(" ")
        val obfuscated = classInput.substringAfterLast(" ")
        this.currentClassMapping = ClassMapping(unobfuscated, obfuscated)
        Mappings.obfuscationEntries[unobfuscated.substringAfterLast(".")] = obfuscated
    }

    fun parseField(input: String) {
        val type = input.substringBefore(" ")
        val name = input.substringAfter(" ").substringBefore(" ")
        val obfuscated = input.substringAfterLast(" ")

        fieldMappings.add(FieldMapping(name, obfuscated, type))
    }

    fun parseMethod(input: String) {
        val returnType = input.substringBefore(" ")
        val name = input.substringAfter(" ").substringBefore("(")
        val obfuscated = input.substringAfterLast(" ")
        val noParams = input.contains("()")
        val parameters = input.substringAfter("(").substringBefore(")").split(",")
        val descriptor = parameters.joinToString("") { parseReturnType(it) }

        methodMappings.add(
            MethodMapping(
                name,
                obfuscated,
                returnType,
                if (noParams) emptyList() else parameters,
                "(${if (noParams) "" else descriptor})${parseReturnType(returnType)}"
            )
        )
    }

    fun parseInit(input: String) {
        currentClassMapping?.addInit(input)
    }

    fun finish() {
        Mappings.entries.putAll(buildMap {
            finalMappings.forEach { (mapping, pair) ->
                this[mapping.obfuscatedName] = MappingsEntry(mapping, pair.first, pair.second)
            }
        })
    }
}