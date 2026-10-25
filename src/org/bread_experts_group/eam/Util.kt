package org.bread_experts_group.eam

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

/**
 * Gets the java class associated with this [ClassDesc].
 *
 * #### !!! Do not use this during class transforms, it will most likely cause a classloading error !!!
 * Specifically, invoking this method inside a class transform will make the JVM load that class.
 * Which could throw an exception if that class is the one currently being transformed.
 */
val ClassDesc.clazz: Class<*>
    get() = ClassLoader.getSystemClassLoader().loadClass(this.qualifiedName)

@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
fun String.toConstantDesc(): ConstantDesc = java.lang.String(this)

fun <K, V> Map<K, V>.first(predicate: (Map.Entry<K, V>) -> Boolean): V =
    this.firstOrNull(predicate) ?: throw NullPointerException("No element of the map was found.")

fun <K, V> Map<K, V>.firstOrNull(predicate: (Map.Entry<K, V>) -> Boolean): V? {
    for (element in this) if (predicate(element)) return element.value
    return null
}

operator fun CodeModel.get(index: Int): CodeElement {
    this.forEachIndexed { i, element ->
        if (index == i) return element
    }
    throw NoSuchElementException("No CodeElement at index $index found.")
}