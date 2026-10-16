package org.bread_experts_group.eam

import org.bread_experts_group.eam.mappings.Mappings
import java.lang.constant.ClassDesc
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
            get() = ClassDesc.of(Mappings.obfuscationEntries[this.simpleName])

        val <T : MimickedClass> Class<T>.nativeDesc: ClassDesc
            get() = ClassDesc.of(Mappings.obfuscationEntries[this.simpleName])
    }

    fun callMethod() {

    }
}