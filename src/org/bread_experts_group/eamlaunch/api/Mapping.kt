package org.bread_experts_group.eamlaunch.api

import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.eam.clazz
import org.bread_experts_group.eam.first
import org.bread_experts_group.eam.mimics.minecraft.v1x21x1.MimickedClass
import org.bread_experts_group.eamlaunch.pending_bsl.*
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Constructor
import kotlin.reflect.KClass

data class Mapping(
    val classes: List<Class>,
    val obfuscatedToClass: MutableMap<ClassDesc, Class>,
    val unobfuscatedToClass: MutableMap<ClassDesc, Class>
) {
    companion object {
        lateinit var INSTANCE: Mapping

        fun <T : MimickedClass> of(mimicClass: KClass<T>): Class =
            INSTANCE.unobfuscatedToClass.first { it.key.displayName() == mimicClass.simpleName }

        fun of(desc: ClassDesc): Class = INSTANCE.unobfuscatedToClass.first { it.key == desc }

        fun contains(className: String): Boolean = INSTANCE.obfuscatedToClass.containsKey(ClassDesc.of(className))
    }

    sealed interface ClassKind

    data class Class(
        val obfuscated: ClassDesc,
        val unobfuscated: ClassDesc,
        val members: List<ObfuscatedMember>
    ) : ClassKind {
        /**
         * @param methodName The name to match in this [Class]'s methods
         * @param parameters The parameters to match in this [Class]'s methods.
         */
        fun getMethod(methodName: String, vararg parameters: ClassDesc?): Method? =
            members.filterIsInstance<Method>().firstOrNull { method ->
                val descList = method.unobfTypeDesc.parameterList()
                (method.unobfuscated == methodName) && parameters.all { p -> descList.any { (it.displayName() == p?.displayName()) } || p == null }
            }

        fun getField(fieldName: String): Field? =
            members.filterIsInstance<Field>().firstOrNull { field -> field.unobfuscated == fieldName }

        fun getConstructor(vararg parameters: ClassDesc): Constructor<*> {
            val parameters = members.filterIsInstance<Method>().first { method ->
                method.obfuscated == ConstantDescs.INIT_NAME &&
                        (method.unobfTypeDesc.parameterList() == parameters.toList() || parameters.isEmpty())
            }.obfClazzParams().toTypedArray()
            return obfuscated.clazz.getConstructor(*parameters)
        }

        sealed interface ObfuscatedMember {
            val obfuscated: String
            val unobfuscated: String
            val returnType: ClassKind
            val parentClass: ClassDesc

            private fun resolveKind(kind: ClassKind): ClassKind = (kind as? ResolvedFuture)?.value ?: kind

            val obfReturnDesc: ClassDesc
                get() = when (val value = resolveKind(returnType)) {
                    is Class -> value.obfuscated
                    is ObfuscatedClass -> value.desc
                    is NonObfuscatedClass -> value.desc
                    is SelfReference -> parentClass
                    else -> throw IllegalStateException("Unknown state: $value")
                }

            val unobfReturnDesc: ClassDesc
                get() = when (val value = resolveKind(returnType)) {
                    is Class -> value.unobfuscated
                    is ObfuscatedClass -> value.desc
                    is NonObfuscatedClass -> value.desc
                    is SelfReference -> parentClass
                    else -> throw IllegalStateException("Unknown state: $value")
                }
        }

        data class Method(
            override val obfuscated: String,
            override val unobfuscated: String,
            val parameters: List<ClassKind>,
            override val returnType: ClassKind,
            override val parentClass: ClassDesc
        ) : ObfuscatedMember {
            private fun resolveFutures(): List<ClassKind> = parameters.map { (it as? ResolvedFuture)?.value ?: it }

            val obfTypeDesc: MethodTypeDesc = MethodTypeDesc.of(obfReturnDesc, paramsToDescObf())
            val unobfTypeDesc: MethodTypeDesc = MethodTypeDesc.of(unobfReturnDesc, paramsToDesc())

            private fun paramsToDesc(): List<ClassDesc> = resolveFutures().map {
                when (it) {
                    is Class -> it.unobfuscated
                    is ObfuscatedClass -> it.desc
                    is NonObfuscatedClass -> it.desc
                    is SelfReference -> parentClass
                    else -> throw IllegalStateException("Unknown state: $it")
                }
            }

            private fun paramsToDescObf(): List<ClassDesc> = resolveFutures().map {
                when (it) {
                    is Class -> it.obfuscated
                    is ObfuscatedClass -> it.desc
                    is NonObfuscatedClass -> it.desc
                    is SelfReference -> parentClass
                    else -> throw IllegalStateException("Unknown state: $it")
                }
            }

            fun obfClazzParams(): List<java.lang.Class<*>> = paramsToDescObf().map { it.clazz }

            /**
             * @return The java method belonging to the obfuscated class.
             *
             * ### Do not call this during class transforms!
             */
            fun obfMethod(): java.lang.reflect.Method = of(parentClass).obfuscated.clazz.getMethod(
                obfuscated, *paramsToDescObf().map {
                    if (it.isPrimitive) when (it) {
                        ConstantDescs.CD_int -> Int::class.java
                        ConstantDescs.CD_double -> Double::class.java
                        ConstantDescs.CD_float -> Double::class.java
                        ConstantDescs.CD_boolean -> Boolean::class.java
                        else -> throw IllegalStateException("Primitive not found for $it")
                    } else it.clazz
                }.toTypedArray()
            )
        }

        data class Field(
            override val obfuscated: String,
            override val unobfuscated: String,
            override val returnType: ClassKind,
            override val parentClass: ClassDesc
        ) : ObfuscatedMember {
            fun obfField(): java.lang.reflect.Field = of(parentClass).obfuscated.clazz.getField(obfuscated)
        }
    }

    @JvmInline
    value class NonObfuscatedClass(val desc: ClassDesc) : ClassKind

    @JvmInline
    value class ObfuscatedClass(val desc: ClassDesc) : ClassKind

    object SelfReference : ClassKind

    @BSLGPDeserializer(ResolvedFuture.Serializer::class)
    @BSLGPSerializer(ResolvedFuture.Serializer::class)
    class ResolvedFuture : ClassKind {
        private var internal: ClassKind? = null
        val value: ClassKind
            get() = internal ?: throw IllegalStateException("Not initialized")

        fun initialize(value: ClassKind) {
            if (this.internal != null) throw IllegalStateException("Already set")
            this.internal = value
        }

        object Serializer : IBSLGPSerializer<ResolvedFuture>, IBSLGPDeserializer<ResolvedFuture> {
            override fun bslGpSerialize(data: ResolvedFuture, output: FlushingOutput, context: EncodingContext) {
                bslGPEncode(data.value, output, context)
            }

            override fun bslGpDeserialize(
                input: BlockingInput, context: DecodingContext
            ): ResolvedFuture = ResolvedFuture().also {
                it.initialize(bslGPDecode(input, context))
            }
        }
    }
}