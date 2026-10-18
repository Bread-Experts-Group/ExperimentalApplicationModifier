package org.bread_experts_group.eam.transform

import org.bread_experts_group.eam.minecraft.v1x21x1.MimickedClass
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import kotlin.reflect.KClass

abstract class ClassTransform<T: MimickedClass>(val target: KClass<T>) {
    abstract fun transform(): (ClassBuilder, ClassElement) -> Unit
}