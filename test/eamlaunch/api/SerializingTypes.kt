package eamlaunch.api

import eamlaunch.pending_bsl.BSLGPDeserializer
import eamlaunch.pending_bsl.BSLGPSerializer
import eamlaunch.pending_bsl.JSONDeserializer
import eamlaunch.pending_bsl.URISerializer
import java.net.URI
import java.time.LocalDateTime

@JSONDeserializer(URISerializer::class)
@BSLGPSerializer(URISerializer::class)
@BSLGPDeserializer(URISerializer::class)
@JvmInline
value class SerializableURI(val value: URI)

@JSONDeserializer(ManifestTimeSerializer::class)
@BSLGPSerializer(ManifestTimeSerializer::class)
@JvmInline
value class SerializableManifestDateTime(val value: LocalDateTime)