package org.bread_experts_group.eamlaunch.api

import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.eamlaunch.pending_bsl.EncodingContext
import org.bread_experts_group.eamlaunch.pending_bsl.IBSLGPSerializer
import org.bread_experts_group.eamlaunch.pending_bsl.IJSONDeserializer
import org.bread_experts_group.eamlaunch.pending_bsl.bslGPEncode
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField

object ManifestTimeSerializer : IJSONDeserializer<String, SerializableManifestDateTime>,
    IBSLGPSerializer<SerializableManifestDateTime> {
    override fun jsonDeserialize(input: String?): SerializableManifestDateTime = SerializableManifestDateTime(
        LocalDateTime.parse(input!!, DateTimeFormatter.ISO_DATE_TIME)
    )

    override fun bslGpSerialize(data: SerializableManifestDateTime, output: FlushingOutput, context: EncodingContext) {
        bslGPEncode(data.value.getLong(ChronoField.NANO_OF_DAY), output, context)
        bslGPEncode(data.value.getLong(ChronoField.EPOCH_DAY), output, context)
    }
}

data class VersionManifestV2(
    val latest: Latest,
    val versions: List<Version>
) {
    data class Latest(
        val release: String,
        val snapshot: String
    )

    data class Version(
        val id: String,
        val url: SerializableURI,
        val type: String,

        val time: SerializableManifestDateTime,
        val releaseTime: SerializableManifestDateTime,
        val sha1: SHA1,
        val complianceLevel: BigDecimal
    )
}