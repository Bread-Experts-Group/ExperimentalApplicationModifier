package eamlaunch.api

import eamlaunch.pending_bsl.BSLGPSerializer
import eamlaunch.pending_bsl.JSONDeserializer
import eamlaunch.pending_bsl.JSONName
import eamlaunch.pending_bsl.URISerializer
import java.math.BigDecimal
import java.net.URI

data class VersionInfo(
    val downloads: Downloads,
    val libraries: List<Library>,
    val type: String
) {
    data class Downloads(
        val client: Entry,
        @JSONName("client_mappings") val clientMappings: Entry,
        val server: Entry,
        @JSONName("server_mappings") val serverMappings: Entry
    ) {
        data class Entry(
            val sha1: String,
            val size: BigDecimal,
            val url: SerializableURI
        )
    }

    data class Library(
        val name: String,
        val downloads: Download,
        val rules: List<Rule>?
    ) {
        data class Rule(
            val action: String,
            val os: OS?
        ) {
            data class OS(
                val name: String
            )
        }

        data class Download(
            val artifact: Artifact
        ) {
            data class Artifact(
                val path: String,
                val sha1: String,
                val size: BigDecimal,
                val url: SerializableURI
            )
        }
    }
}