package org.bread_experts_group.eamlaunch.api

import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.bread_systems_library.model.codings.BSLGPDeserializer
import org.bread_experts_group.bread_systems_library.model.codings.BSLGPSerializer
import org.bread_experts_group.bread_systems_library.model.codings.DecodingContext
import org.bread_experts_group.bread_systems_library.model.codings.EncodingContext
import org.bread_experts_group.bread_systems_library.model.codings.IBSLGPDeserializer
import org.bread_experts_group.bread_systems_library.model.codings.IBSLGPSerializer
import org.bread_experts_group.bread_systems_library.model.codings.IJSONDeserializer
import org.bread_experts_group.bread_systems_library.model.codings.JSONDeserializer
import org.bread_experts_group.bread_systems_library.model.codings.bslGPDecode
import org.bread_experts_group.bread_systems_library.model.codings.bslGPEncode
import java.net.URI
import java.time.LocalDateTime

object URISerializer : IJSONDeserializer<String, SerializableURI>, IBSLGPSerializer<SerializableURI>,
    IBSLGPDeserializer<SerializableURI> {
    override fun jsonDeserialize(input: String?): SerializableURI = SerializableURI(URI(input!!))

    override fun bslGpSerialize(data: SerializableURI, output: FlushingOutput, context: EncodingContext) {
        bslGPEncode(data.value.toString(), output, context)
    }

    override fun bslGpDeserialize(input: BlockingInput, context: DecodingContext): SerializableURI = SerializableURI(
        URI(bslGPDecode<String>(input, context))
    )
}

@JSONDeserializer(URISerializer::class)
@BSLGPSerializer(URISerializer::class)
@BSLGPDeserializer(URISerializer::class)
@JvmInline
value class SerializableURI(val value: URI)

@JSONDeserializer(ManifestTimeSerializer::class)
@BSLGPSerializer(ManifestTimeSerializer::class)
@JvmInline
value class SerializableManifestDateTime(val value: LocalDateTime)

@JSONDeserializer(SHA1Serializer::class)
@BSLGPSerializer(SHA1Serializer::class)
@BSLGPDeserializer(SHA1Serializer::class)
@JvmInline
value class SHA1(val value: ByteArray)