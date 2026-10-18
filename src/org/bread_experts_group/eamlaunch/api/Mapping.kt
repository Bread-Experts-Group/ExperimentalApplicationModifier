package org.bread_experts_group.eamlaunch.api

import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.bread_systems_library.model.jsonParse
import org.bread_experts_group.eam.first
import org.bread_experts_group.eam.minecraft.v1x21x1.MimickedClass
import org.bread_experts_group.eamlaunch.pending_bsl.BSLGPDeserializer
import org.bread_experts_group.eamlaunch.pending_bsl.BSLGPSerializer
import org.bread_experts_group.eamlaunch.pending_bsl.DecodingContext
import org.bread_experts_group.eamlaunch.pending_bsl.EncodingContext
import org.bread_experts_group.eamlaunch.pending_bsl.IBSLGPDeserializer
import org.bread_experts_group.eamlaunch.pending_bsl.IBSLGPSerializer
import org.bread_experts_group.eamlaunch.pending_bsl.bslGPDecode
import org.bread_experts_group.eamlaunch.pending_bsl.bslGPEncode
import org.bread_experts_group.eamlaunch.pending_bsl.jsonDecode
import java.lang.constant.ClassDesc
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.reflect.KClass

data class Mapping(
    val classes: List<Class>,
    val obfuscatedToClass: Map<ClassDesc, Class>,
    val unobfuscatedToClass: Map<ClassDesc, Class>
) {
    companion object {
        lateinit var INSTANCE: Mapping

        // todo stripped down version of mappings downloader in AcquireMain2
        fun getMappingForMinecraftVersion(minecraftVersion: String): Mapping {
            val client = HttpClient.newHttpClient()
            val versionManifest = jsonDecode<VersionManifestV2>(
                jsonParse(
                    client.send(
                        HttpRequest.newBuilder(URI("https://piston-meta.mojang.com/mc/game/version_manifest_v2.json"))
                            .build(),
                        HttpResponse.BodyHandlers.ofString()
                    ).body().reader()
                )
            )
            val versionInfo = jsonDecode<VersionInfo>(
                jsonParse(
                    client.send(
                        HttpRequest.newBuilder(versionManifest.versions.first { it.id == minecraftVersion }.url.value)
                            .build(),
                        HttpResponse.BodyHandlers.ofString()
                    ).body().reader()
                )
            )

            return mappingDecode(
                client.send(
                    HttpRequest.newBuilder(versionInfo.downloads.clientMappings?.url?.value).build(),
                    HttpResponse.BodyHandlers.ofString()
                ).body().also { println(it.length) }.reader()
            )!!
        }

        fun <T : MimickedClass> of(mimicClass: KClass<T>): Class =
            INSTANCE.unobfuscatedToClass.first { it.key.displayName() == mimicClass.simpleName }
    }

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