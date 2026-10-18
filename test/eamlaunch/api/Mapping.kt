package eamlaunch.api

import java.lang.constant.ClassDesc

data class Mapping(
    val classes: List<Class>,
    val obfuscatedToClass: Map<ClassDesc, Class>,
    val unobfuscatedToClass: Map<ClassDesc, Class>,
) {
    sealed interface ClassKind

    data class Class(
        val obfuscated: ClassDesc,
        val unobfuscated: ClassDesc,
        val members: List<ObfuscatedMember>
    ) : ClassKind {
        sealed interface ObfuscatedMember {
            val obfuscated: String
            val unobfuscated: String
            val returnType: ClassKind
        }

        data class Method(
            override val obfuscated: String,
            override val unobfuscated: String,
            val parameters: List<ClassKind>,
            override val returnType: ClassKind
        ) : ObfuscatedMember

        data class Field(
            override val obfuscated: String,
            override val unobfuscated: String,
            override val returnType: ClassKind
        ) : ObfuscatedMember
    }

    @JvmInline
    value class NonObfuscatedClass(val desc: ClassDesc) : ClassKind

    object SelfReference : ClassKind

    data class PendFuture(
        val a: Int = 0
    ) : ClassKind
}