package org.bread_experts_group.eam.transform

import org.bread_experts_group.eam.minecraft.v1x21x1.MimickedClass
import org.bread_experts_group.eamlaunch.api.Mapping
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import kotlin.reflect.KClass

abstract class ClassTransform<T: MimickedClass>(val target: KClass<T>) {
    val classMapping: Mapping.Class = Mapping.of(target)

    fun obfMethodName(name: String): String =
        classMapping.members.first { it is Mapping.Class.Method && it.unobfuscated == name }.obfuscated

    abstract fun transform(): (ClassBuilder, ClassElement) -> Unit
}