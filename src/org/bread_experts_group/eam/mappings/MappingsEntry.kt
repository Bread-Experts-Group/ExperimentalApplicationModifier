package org.bread_experts_group.eam.mappings

data class MappingsEntry(
    val classMapping: ClassMapping,
    val fieldMappings: List<FieldMapping>,
    val methodMappings: List<MethodMapping>
) {
    fun append(builder: StringBuilder) {
        builder.appendLine(classMapping)
        fieldMappings.forEach(builder::appendLine)
        methodMappings.forEach(builder::appendLine)
    }
}