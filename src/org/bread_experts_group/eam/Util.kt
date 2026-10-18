package org.bread_experts_group.eam

import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDesc
import java.lang.reflect.Parameter
import kotlin.reflect.KClass

val Parameter.classDesc: ClassDesc
    get() = ClassDesc.of(this.type.name)

val Class<*>.classDesc: ClassDesc
    get() = ClassDesc.of(this.name)

val KClass<*>.classDesc: ClassDesc
    get() {
        val declaring = this.java.declaringClass
        return if (declaring != null) ClassDesc.of(declaring.name + "$" + this.simpleName)
        else ClassDesc.of(this.java.name)
    }

val ClassDesc.qualifiedName: String
    get() = "${this.packageName()}.${this.displayName()}"

val ClassDesc.clazz: Class<*>
    get() = ClassLoader.getSystemClassLoader().loadClass(this.qualifiedName)

@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
fun String.toConstantDesc(): ConstantDesc = java.lang.String(this)

fun String.containsAny(vararg delimiters: String): Boolean = delimiters.any { this.contains(it) }