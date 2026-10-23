package org.bread_experts_group.eamlaunch.api

import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.eam.clazz
import org.bread_experts_group.eam.first
import org.bread_experts_group.eam.minecraft.v1x21x1.MimickedClass
import org.bread_experts_group.eamlaunch.pending_bsl.*
import java.lang.constant.ClassDesc
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.KClass

data class Mapping(
    val classes: List<Class>,
    val obfuscatedToClass: Map<ClassDesc, Class>,
    val unobfuscatedToClass: Map<ClassDesc, Class>
) {
    companion object {
        lateinit var INSTANCE: Mapping

        fun <T : MimickedClass> of(mimicClass: KClass<T>): Class =
            INSTANCE.unobfuscatedToClass.first { it.key.displayName() == mimicClass.simpleName }

        fun of(desc: ClassDesc): Class = INSTANCE.unobfuscatedToClass.first { it.key == desc }
    }

    sealed interface ClassKind

    data class Class(
        val obfuscated: ClassDesc,
        val unobfuscated: ClassDesc,
        val members: List<ObfuscatedMember>
    ) : ClassKind {
        fun getMethod(methodName: String, vararg parameters: ClassDesc): Method? =
            members.filterIsInstance<Method>().firstOrNull { method ->
                (method.unobfuscated == methodName) && (method.unobfTypeDesc().parameterList() == parameters.toList() || parameters.isEmpty())
            }

        sealed interface ObfuscatedMember {
            val obfuscated: String
            val unobfuscated: String
            val returnType: ClassKind
            val parentClass: ClassDesc
        }

        data class Method(
            override val obfuscated: String,
            override val unobfuscated: String,
            val parameters: List<ClassKind>,
            override val returnType: ClassKind,
            override val parentClass: ClassDesc
        ) : ObfuscatedMember {
            private fun resolveFutures(): List<ClassKind> = parameters.map { (it as? ResolvedFuture)?.value ?: it }
            private fun resolveReturnType(): ClassKind = (returnType as? ResolvedFuture)?.value ?: returnType

            private fun paramsToDesc(): List<ClassDesc> = resolveFutures().map {
                when (it) {
                    is Class -> it.unobfuscated
                    is ObfuscatedClass -> it.desc
                    is NonObfuscatedClass -> it.desc
                    else -> throw IllegalStateException("Unknown state: $it")
                }
            }

            private fun paramsToDescObf(): List<ClassDesc> = resolveFutures().map {
                when (it) {
                    is Class -> it.obfuscated
                    is ObfuscatedClass -> it.desc
                    is NonObfuscatedClass -> it.desc
                    else -> throw IllegalStateException("Unknown state: $it")
                }
            }

            fun obfReturnDesc(): ClassDesc {
                val kind = when(val value = resolveReturnType()) {
                    is Class -> value.obfuscated
                    is ObfuscatedClass -> value.desc
                    is NonObfuscatedClass -> value.desc
                    else -> throw IllegalStateException("Unknown state: $value")
                }
                return kind
            }

            fun unobfReturnDesc(): ClassDesc {
                val kind = when(val value = resolveReturnType()) {
                    is Class -> value.unobfuscated
                    is ObfuscatedClass -> value.desc
                    is NonObfuscatedClass -> value.desc
                    else -> throw IllegalStateException("Unknown state: $value")
                }
                return kind
            }

            fun obfTypeDesc(): MethodTypeDesc = MethodTypeDesc.of(obfReturnDesc(), paramsToDescObf())
            fun unobfTypeDesc(): MethodTypeDesc = MethodTypeDesc.of(unobfReturnDesc(), paramsToDesc())

            /**
             * @return The java method belonging to the obfuscated class.
             *
             * ### Do not call this during class transforms!
             */
            fun obfMethod(): java.lang.reflect.Method = of(parentClass).obfuscated.clazz.getMethod(
                obfuscated, *paramsToDescObf().map { it.clazz }.toTypedArray()
            )
        }

        data class Field(
            override val obfuscated: String,
            override val unobfuscated: String,
            override val returnType: ClassKind,
            override val parentClass: ClassDesc
        ) : ObfuscatedMember
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