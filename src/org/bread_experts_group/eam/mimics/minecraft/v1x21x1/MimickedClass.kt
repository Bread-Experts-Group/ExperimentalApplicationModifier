package org.bread_experts_group.eam.mimics.minecraft.v1x21x1

import org.bread_experts_group.eam.clazz
import org.bread_experts_group.eamlaunch.api.Mapping
import java.lang.constant.ClassDesc
import java.lang.reflect.AccessFlag
import kotlin.reflect.KClass

abstract class MimickedClass(@JvmField var original: Any) {
    companion object {
        val <T: MimickedClass> KClass<T>.nativeDesc: ClassDesc
            get() = Mapping.of(this).obfuscated

        val <T: MimickedClass> Class<T>.nativeDesc: ClassDesc
            get() = Mapping.of(this.kotlin).obfuscated

        val <T: MimickedClass> KClass<T>.nativeClass: KClass<*>
            get() = nativeDesc.clazz.kotlin

        // hahaha what is this
        fun <T : MimickedClass> addToStaticArray(mClass: KClass<T>, fieldName: String, vararg elements: Any) {
            val field = Mapping.of(mClass).getField(fieldName)?.obfField() ?: return
            val obfClass = mClass.nativeClass.java
            check(field.accessFlags().contains(AccessFlag.STATIC)) { "Field $fieldName is not static!" }
            val list = (field.get(null) as Array<*>).toMutableList()
            list.addAll(elements.map { (it as? MimickedClass)?.original ?: it })
            val newArray = java.lang.reflect.Array.newInstance(obfClass, list.size)

            repeat(list.size) {
                java.lang.reflect.Array.set(newArray, it, list[it])
            }
            field.set(null, newArray)
        }

        private fun mapArgsToDesc(vararg args: Any?): Array<ClassDesc?> =
            args.map {
                if (it != null) {
                    val jClass = it::class.javaPrimitiveType ?: it::class.java
                    if (jClass.isArray) ClassDesc.ofDescriptor(jClass.name.replace('.', '/')) else ClassDesc.of(jClass.name)
                } else null
            }.toTypedArray()

        private fun mapArgs(args: Array<out Any?>): Array<Any?> = args.map { (it as? MimickedClass)?.original ?: it }.toTypedArray()

        fun <T: MimickedClass> callStaticMethod(
            mClass: KClass<T>,
            methodName: String,
            vararg args: Any?
        ): Any? {
            val params = if (args.isEmpty()) emptyArray() else mapArgsToDesc(args)
            val method = Mapping.of(mClass).getMethod(methodName, *params)?.obfMethod()
            return method?.invoke(null, *mapArgs(args))
        }

        fun <T: MimickedClass> getStaticField(mClass: KClass<T>, fieldName: String): Any? {
            val field = Mapping.of(mClass).getField(fieldName)?.obfField()
            return field?.get(null)
        }
    }

    protected fun callMethod(methodName: String, vararg args: Any?): Any? {
        val params = if (args.isEmpty()) emptyArray() else mapArgsToDesc(args)
        val method = Mapping.of(this::class).getMethod(methodName, *params)?.obfMethod()
        return method?.invoke(original, *mapArgs(args))
    }

    protected fun getField(fieldName: String): Any? {
        val field = Mapping.of(this::class).getField(fieldName)?.obfField()
        return field?.get(original)
    }

    override fun equals(other: Any?): Boolean =
        if (other is MimickedClass) other.original == original else other == original

    override fun hashCode(): Int = original.hashCode()

    override fun toString(): String = original.toString()
}