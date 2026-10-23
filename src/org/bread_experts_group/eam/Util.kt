package org.bread_experts_group.eam

import org.bread_experts_group.eam.minecraft.v1x21x1.MimickedClass
import java.lang.classfile.CodeElement
import java.lang.classfile.CodeModel
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
    get() = this.packageName().let { if (it.isEmpty()) "" else "$it." } + this.displayName()

val ClassDesc.clazz: Class<*>
    get() = ClassLoader.getSystemClassLoader().loadClass(this.qualifiedName)

@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
fun String.toConstantDesc(): ConstantDesc = java.lang.String(this)

fun <K, V> Map<K, V>.first(checker: (Map.Entry<K, V>) -> Boolean): V =
    this.firstOrNull(checker) ?: throw NullPointerException("No element of the map was found.")

fun <K, V> Map<K, V>.firstOrNull(checker: (Map.Entry<K, V>) -> Boolean): V? {
    for (element in this) if (checker(element)) return element.value
    return null
}

fun mapArgs(args: Array<out Any?>): Array<Any?> = args.map { (it as? MimickedClass)?.original ?: it }.toTypedArray()

operator fun CodeModel.get(index: Int): CodeElement {
    this.forEachIndexed { i, element ->
        if (index == i) return element
    }
    throw NullPointerException("No element with index $index found.")
}