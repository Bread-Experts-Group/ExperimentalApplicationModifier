package org.bread_experts_group.eam.mappings

import org.bread_experts_group.eam.minecraft.v1x21x1.MimickedClass
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.reflect.KClass

object Mappings {
    val entries: MutableMap<String, MappingsEntry> = mutableMapOf()

    /**
     * Entries for retrieving the obfuscated name of the class with the unobfuscated name
     */
    val obfuscationEntries: MutableMap<String, String> = mutableMapOf()

    fun dumpToFile() {
        val mappingsPath = Path("minecraft_sources/output_mappings.txt")
        val mappingBuilder = StringBuilder()
        this.entries.forEach { (obfuscatedName, entry) ->
            mappingBuilder.appendLine("///// ${entry.classMapping.name} ($obfuscatedName) /////")
            entry.append(mappingBuilder)
        }
        Files.write(mappingsPath, mappingBuilder.toString().toByteArray())
    }

    fun <T: MimickedClass> of(mimicClass: KClass<T>): MappingsEntry =
        this.entries[obfuscationEntries[mimicClass.simpleName]] ?:
        throw NullPointerException("No mapping found for ${mimicClass.qualifiedName}")

    fun <T: MimickedClass> obfuscatedClassName(mimicClass: KClass<T>): String =
        of(mimicClass).classMapping.obfuscatedName
}