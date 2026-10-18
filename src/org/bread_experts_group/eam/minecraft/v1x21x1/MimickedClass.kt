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

    fun callMethod() {

    }
}