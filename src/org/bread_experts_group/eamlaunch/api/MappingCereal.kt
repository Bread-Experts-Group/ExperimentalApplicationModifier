package org.bread_experts_group.eamlaunch.api

import java.io.Reader
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs

fun mappingDecode(reader: Reader): Mapping? {
    val list = mutableListOf<Mapping.Class>()
    val lines = ArrayDeque<String>()
    lines.addAll(reader.readLines())
    val obf2Class = mutableMapOf<ClassDesc, Mapping.Class>()
    val unObf2Class = mutableMapOf<ClassDesc, Mapping.Class>()

    val futures = mutableMapOf<String, MutableList<(Mapping.ClassKind) -> Unit>>()
    while (lines.isNotEmpty()) {
        val trimmed = lines.removeFirst().trim()
        if (trimmed.isEmpty() || trimmed[0] == '#') continue
        val separator = trimmed.indexOf(" -> ")
        if (separator == -1) {
            println("Bad mapping file: no separator between unobfuscated/obfuscated object")
            return null
        }
        val end = trimmed.indexOf(':', separator + 4)
        if (end == -1) {
            println("Bad mapping file: no colon at obfuscation end")
            return null
        }

        val unobfuscated = ClassDesc.of(trimmed.take(separator))
        val obfuscated = ClassDesc.of(trimmed.substring(separator + 4..<end))
        val members = mutableListOf<Mapping.Class.ObfuscatedMember>()

        futures.remove(trimmed.take(separator))?.let {
            it.forEach { task -> task(Mapping.ObfuscatedClass(obfuscated)) }
        }

        val mClass = Mapping.Class(obfuscated, unobfuscated, members)
        obf2Class[obfuscated] = mClass
        unObf2Class[unobfuscated] = mClass

        list.add(mClass)

        fun resolveClassKind(item: String): Mapping.ClassKind {
            val primitive = when (item) {
                "void" -> ConstantDescs.CD_void
                "byte" -> ConstantDescs.CD_byte
                "short" -> ConstantDescs.CD_short
                "char" -> ConstantDescs.CD_char
                "int" -> ConstantDescs.CD_int
                "long" -> ConstantDescs.CD_long
                "float" -> ConstantDescs.CD_float
                "double" -> ConstantDescs.CD_double
                else -> null
            }
            if (primitive != null) return Mapping.NonObfuscatedClass(primitive)

            val arrayIndex = item.indexOf("[]")
            if (arrayIndex != -1) {
                val baseDesc = ClassDesc.of(item.take(arrayIndex))
                if (baseDesc == unobfuscated) return Mapping.SelfReference

                //.arrayType((item.length - arrayIndex) / 2)
                return obf2Class[baseDesc] ?: unObf2Class[baseDesc] ?: Mapping.ResolvedFuture().also { future ->
                    futures.getOrPut(item.take(arrayIndex)) { mutableListOf() }.add(future::initialize)
                }
            }

            val desc = ClassDesc.of(item)
            if (desc == unobfuscated) return Mapping.SelfReference

            return obf2Class[desc] ?: unObf2Class[desc] ?: Mapping.ResolvedFuture().also { future ->
                futures.getOrPut(item) { mutableListOf() }.add(future::initialize)
            }
        }

        while (lines.isNotEmpty()) {
            val member = lines.removeFirst().trim()
            if (member.isEmpty() || member[0] == '#') continue
            if (member[member.lastIndex] == ':') {
                lines.addFirst(member)
                break
            }
            val parametersStart = member.indexOf('(')
            if (parametersStart != -1) {
                val parametersEnd = member.indexOf(')')
                if (parametersEnd == -1) {
                    println("Bad mapping file: no end to method parameters")
                    return null
                }
                val obfuscated = member.substringAfterLast(" -> ", "<ERROR>")
                if (obfuscated == "<ERROR>") {
                    println("Bad mapping file: no method obfuscated name")
                    return null
                }
                val linesReturnTypeAndName = member.take(parametersStart)
                val returnTypeAndName = linesReturnTypeAndName.substringAfterLast(':')
                val separator = returnTypeAndName.indexOf(' ')
                members.add(
                    Mapping.Class.Method(
                        obfuscated,
                        returnTypeAndName.substring(separator + 1),
                        member.substring(parametersStart+ 1 ..<parametersEnd).let {
                            if (it.isEmpty()) emptyList()
                            else it.split(',').map(::resolveClassKind)
                        },
                        resolveClassKind(
                            returnTypeAndName.take(separator)
                        ),
                        mClass.unobfuscated
                    )
                )
                continue
            }
            val typeAndNameSeparator = member.indexOf(' ')

            val unobfuscatedAndObfuscated = member.substring(typeAndNameSeparator + 1)
            val nameSeparator = unobfuscatedAndObfuscated.indexOf(" -> ")

            members.add(
                Mapping.Class.Field(
                    unobfuscatedAndObfuscated.substring(nameSeparator + 4),
                    unobfuscatedAndObfuscated.take(nameSeparator),
                    resolveClassKind(
                        member.take(typeAndNameSeparator)
                    ),
                    mClass.unobfuscated
                )
            )
        }
    }
    futures.forEach { (kind, tasks) ->
        val desc = ClassDesc.of(kind)
        tasks.forEach { task -> task(Mapping.NonObfuscatedClass(desc)) }
    }
    return Mapping(list, obf2Class, unObf2Class)
}