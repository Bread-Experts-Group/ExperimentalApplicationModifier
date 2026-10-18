package org.bread_experts_group.eamlaunch.api

import org.bread_experts_group.eamlaunch.pending_bsl.JSONName
import java.math.BigDecimal

data class VersionInfo(
    val downloads: Downloads,
    val libraries: List<Library>,
    val type: String,
    val mainClass: String,
    @JSONName("assets") val assetIndexID: String,
    @JSONName("assetIndex") val assetIndex: AssetIndexDownload
) {
    data class AssetIndexDownload(
        val id: String,
        val sha1: SHA1,
        val size: BigDecimal,
        val totalSize: BigDecimal,
        val url: SerializableURI
    )

    data class Downloads(
        val client: Entry,
        @JSONName("client_mappings") val clientMappings: Entry?,
        val server: Entry,
        @JSONName("server_mappings") val serverMappings: Entry?
    ) {
        data class Entry(
            val sha1: SHA1,
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
                val sha1: SHA1,
                val size: BigDecimal,
                val url: SerializableURI
            )
        }
    }
}