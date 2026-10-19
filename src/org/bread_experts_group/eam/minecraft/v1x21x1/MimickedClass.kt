package org.bread_experts_group.eam.minecraft.v1x21x1

import org.bread_experts_group.eam.clazz
import org.bread_experts_group.eamlaunch.api.Mapping
import java.lang.constant.ClassDesc
import java.lang.reflect.AccessFlag
import kotlin.reflect.KClass

abstract class MimickedClass(@JvmField var original: Any) {
    companion object {
        val <T : MimickedClass> KClass<T>.mimicDesc: ClassDesc
            get() {
                val declaring = this.java.declaringClass
                return if (declaring != null) ClassDesc.of(declaring.name + "$" + this.simpleName)
                else ClassDesc.of(this.java.name)
            }

        val <T : MimickedClass> Class<T>.mimicDesc: ClassDesc
            get() = ClassDesc.of(this.name)

        val <T : MimickedClass> KClass<T>.nativeDesc: ClassDesc
            get() = Mapping.of(this).obfuscated

        val <T : MimickedClass> Class<T>.nativeDesc: ClassDesc
            get() = Mapping.of(this.kotlin).obfuscated

        fun <T : MimickedClass> addToStaticArray(mClass: KClass<T>, fieldName: String, vararg elements: Any) {
            val mapping = Mapping.of(mClass)
            val obfClass = mapping.obfuscated.clazz
            val member = mapping.members.first { it.unobfuscated == fieldName }
            val field = obfClass.getField(member.unobfuscated)
            check(field.accessFlags().contains(AccessFlag.STATIC)) { "Field $fieldName is not static!" }
            val list = (field.get(null) as Array<*>).toMutableList()
            list.addAll(elements.map { (it as? MimickedClass)?.original ?: it })
            val newArray = java.lang.reflect.Array.newInstance(obfClass, list.size)

            repeat(list.size) {
                java.lang.reflect.Array.set(newArray, it, list[it])
            }
            obfClass.getField(fieldName).set(null, newArray)
        }
    }

    fun nativeClass(): Class<*> = this::class.nativeDesc.clazz

    fun callMethod(methodName: String, vararg args: Any): Any {
        val mapping = Mapping.of(this::class)
        val methodMapping = mapping.members.first { it.unobfuscated == methodName } as Mapping.Class.Method
        val parameters = methodMapping.parameters.map {
            val value = (it as? Mapping.ResolvedFuture)?.value ?: it
            when (value) {
                is Mapping.Class -> value.obfuscated
                is Mapping.ObfuscatedClass -> value.desc
                is Mapping.NonObfuscatedClass -> value.desc
                else -> throw IllegalStateException("Unknown state: $value")
            }.clazz
        }
//        val returnType = when (val type = methodMapping.returnType) {
//            is Mapping.Class -> type.obfuscated
//            is Mapping.ObfuscatedClass -> type.desc
//            is Mapping.NonObfuscatedClass -> type.desc
//            else -> throw IllegalStateException("Unknown state: $type")
//        }.clazz

//        println("method: $methodName")
//        methodMapping.parameters.map { if (it is Mapping.ResolvedFuture) it.value else it }.forEach(::println)
//        println(returnType)

        val method = nativeClass().getMethod(methodMapping.obfuscated, *parameters.toTypedArray())
        println(method)
        return Unit // todo
    }

//    override fun equals(other: Any?): Boolean =
//        if (other is MimickedClass) other.original == original else other == original
}