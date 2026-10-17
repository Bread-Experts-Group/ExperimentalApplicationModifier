package eamlaunch.api

import eamlaunch.pending_bsl.IBSLGPSerializer
import eamlaunch.pending_bsl.IJSONDeserializer
import eamlaunch.pending_bsl.bslGPEncode
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField

object ManifestTimeSerializer : IJSONDeserializer<String, SerializableManifestDateTime>, IBSLGPSerializer<SerializableManifestDateTime> {
    override fun jsonDeserialize(input: String?): SerializableManifestDateTime = SerializableManifestDateTime(
        LocalDateTime.parse(input!!, DateTimeFormatter.ISO_DATE_TIME)
    )

    override fun bslGpSerialize(data: SerializableManifestDateTime, output: FlushingOutput) {
        bslGPEncode(data.value.getLong(ChronoField.NANO_OF_DAY), output)
        bslGPEncode(data.value.getLong(ChronoField.EPOCH_DAY), output)
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
        val sha1: String,
        val complianceLevel: BigDecimal
    )
}