package org.bread_experts_group.eamlaunch.api

import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.eamlaunch.pending_bsl.BSLGPDeserializer
import org.bread_experts_group.eamlaunch.pending_bsl.BSLGPSerializer
import org.bread_experts_group.eamlaunch.pending_bsl.DecodingContext
import org.bread_experts_group.eamlaunch.pending_bsl.EncodingContext
import org.bread_experts_group.eamlaunch.pending_bsl.IBSLGPDeserializer
import org.bread_experts_group.eamlaunch.pending_bsl.IBSLGPSerializer
import org.bread_experts_group.eamlaunch.pending_bsl.bslGPDecode
import org.bread_experts_group.eamlaunch.pending_bsl.bslGPEncode
import java.lang.constant.ClassDesc

data class Mapping(
    val classes: List<Class>,
    val obfuscatedToClass: Map<ClassDesc, Class>,
    val unobfuscatedToClass: Map<ClassDesc, Class>,
) {
    sealed interface ClassKind

    data class Class(
        val obfuscated: ClassDesc,
        val unobfuscated: ClassDesc,
        val members: List<ObfuscatedMember>
    ) : ClassKind {
        sealed interface ObfuscatedMember {
            val obfuscated: String
            val unobfuscated: String
            val returnType: ClassKind
        }

        data class Method(
            override val obfuscated: String,
            override val unobfuscated: String,
            val parameters: List<ClassKind>,
            override val returnType: ClassKind
        ) : ObfuscatedMember

        data class Field(
            override val obfuscated: String,
            override val unobfuscated: String,
            override val returnType: ClassKind
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