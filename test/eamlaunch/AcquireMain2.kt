package eamlaunch

import eamlaunch.api.VersionInfo
import eamlaunch.api.VersionManifestV2
import eamlaunch.pending_bsl.bslGPDecode
import eamlaunch.pending_bsl.bslGPEncode
import eamlaunch.pending_bsl.jsonDecode
import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.bread_systems_library.model.jsonParse
import java.io.EOFException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.channels.FileLock
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.io.path.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.notExists
import kotlin.system.exitProcess

const val minecraftVersion = "1.21.1"

val minecraftPath = Path("./minecraft/$minecraftVersion")

val libraryPath: Path = minecraftPath.resolve("libraries")
val eamLaunchResourcePath: Path = minecraftPath.resolve("eam launch")

val userDateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss.SSS")

fun main() {
    println("EAM launch starting...")
    val client = HttpClient.newHttpClient()
    val versionManifest = jsonDecode<VersionManifestV2>(
        jsonParse(
            client.send(
                HttpRequest.newBuilder(URI("https://piston-meta.mojang.com/mc/game/version_manifest_v2.json")).build(),
                HttpResponse.BodyHandlers.ofString()
            ).body().reader()
        )
    )
    val version = versionManifest.versions.firstOrNull { it.id == minecraftVersion }
    if (version == null) {
        System.err.println("Version manifest did not provide an entry for version \"$minecraftVersion\".")
        exitProcess(1)
    }
    val versionInfoPath = eamLaunchResourcePath.resolve("version_info").also {
        it.parent.createDirectories()
    }

    var update = false
    val channel = if (versionInfoPath.notExists()) FileChannel.open(
        versionInfoPath,
        StandardOpenOption.READ, StandardOpenOption.WRITE,
        StandardOpenOption.CREATE
    ).also {
        println(
            "${version.id} (${userDateTimeFormatter.format(version.releaseTime.value)}) last updated on " +
                    "${userDateTimeFormatter.format(version.time.value)} " +
                    "(no local)"
        )
        update = true
    } else FileChannel.open(
        versionInfoPath,
        StandardOpenOption.READ, StandardOpenOption.WRITE
    ).also {
        val versionInfoLocalLastModified = LocalDateTime.ofInstant(
            Files.getLastModifiedTime(versionInfoPath).toInstant(),
            ZoneId.systemDefault()
        )
        println(
            "${version.id} (${userDateTimeFormatter.format(version.releaseTime.value)}) last updated on " +
                    "${userDateTimeFormatter.format(version.time.value)} " +
                    "(local ${userDateTimeFormatter.format(versionInfoLocalLastModified)})"
        )
        update = version.time.value > versionInfoLocalLastModified
    }

    val buffer = ByteBuffer.allocateDirect(16384)
    val input = BlockingInput()
    input.suspensionNotification = { required ->
        var required = required
        while (required > 0) {
            val read = channel.read(buffer)
            if (read == -1) throw EOFException()
            val data = ByteArray(read)
            buffer.flip().get(data).clear()
            input.load(data)
            required -= read
        }
    }

    @Suppress("VariableInitializerIsRedundant")
    var versionInfo = if (!update) {
        try {
            bslGPDecode<VersionInfo>(input)
        } catch (_: EOFException) {
            println("Local copy may be corrupt")
            update = true
        }
    } else null

    if (update) {
        println("Updating local copy...")
        versionInfo = jsonDecode<VersionInfo>(
            jsonParse(
                client.send(
                    HttpRequest.newBuilder(versionManifest.versions.first { it.id == minecraftVersion }.url.value).build(),
                    HttpResponse.BodyHandlers.ofString()
                ).body().reader()
            )
        )

        var fileOffset = 0L
        val output = FlushingOutput.Buffer(ByteBuffer.allocateDirect(32768)) { buffer, size ->
            channel.write(buffer, fileOffset)
            fileOffset += size
        }
        bslGPEncode(versionInfo, output)
        output.flush()
    }

    println(versionInfo)
    TODO("*")

//    val mappings = client.send(
//        HttpRequest.newBuilder(versionInfo.downloads.clientMappings.url).build(),
//        HttpResponse.BodyHandlers.ofString()
//    )
}