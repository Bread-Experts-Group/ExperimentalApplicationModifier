package eamlaunch

import eamlaunch.api.Mapping
import eamlaunch.api.VersionInfo
import eamlaunch.api.VersionManifestV2
import eamlaunch.api.mappingDecode
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
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentSkipListSet
import java.util.concurrent.Executors
import kotlin.io.path.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.fileSize
import kotlin.io.path.invariantSeparatorsPathString
import kotlin.io.path.name
import kotlin.io.path.notExists
import kotlin.system.exitProcess

const val minecraftVersion = "1.21.1"

val minecraftPath = Path("./minecraft")
val minecraftVersionPath = Path("./minecraft/$minecraftVersion")

val libraryPath: Path = minecraftPath.resolve("libraries")
val gamePath: Path = minecraftVersionPath.resolve("game")
val eamLaunchResourcePath: Path = minecraftVersionPath.resolve("eam launch")

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

    val buffer = ByteBuffer.allocateDirect(16384)

    var update = false

    val versionInfo = (if (versionInfoPath.notExists()) FileChannel.open(
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
    }).use { channel ->
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

        var versionInfo = if (!update) {
            try {
                bslGPDecode<VersionInfo>(input)
            } catch (_: EOFException) {
                println("Local copy may be corrupt")
                update = true
                null
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

            channel.truncate(0)
            var fileOffset = 0L
            val output = FlushingOutput.Buffer(ByteBuffer.allocateDirect(32768)) { buffer, size ->
                channel.write(buffer.clear().limit(size), fileOffset)
                fileOffset += size
            }
            bslGPEncode(versionInfo, output)
            output.flush()
        }
        versionInfo!!
    }

    val clientJarPath = eamLaunchResourcePath.resolve("client.jar")
    if (clientJarPath.notExists() || update) {
        client.send(
            HttpRequest.newBuilder(versionInfo.downloads.client.url.value).build(),
            HttpResponse.BodyHandlers.ofFile(clientJarPath)
        )
        println("Downloaded ${clientJarPath.name} (${clientJarPath.fileSize()} bytes)")
    }

    if (versionInfo.downloads.clientMappings != null) {
        val mappingPath = eamLaunchResourcePath.resolve("mapping").also {
            it.parent.createDirectories()
        }

        val mapping = (if (mappingPath.notExists() || update) FileChannel.open(
            mappingPath,
            StandardOpenOption.READ, StandardOpenOption.WRITE,
            StandardOpenOption.CREATE
        ).also {
            println("No local mapping or version was updated")
            update = true
        } else FileChannel.open(
            mappingPath,
            StandardOpenOption.READ, StandardOpenOption.WRITE
        )).use { channel ->
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

            var mapping = if (!update) {
                try {
                    bslGPDecode<Mapping>(input)
                } catch (_: EOFException) {
                    println("Local copy may be corrupt")
                    update = true
                    null
                }
            } else null

            if (update) {
                println("Updating local copy...")
                mapping = mappingDecode(
                    client.send(
                        HttpRequest.newBuilder(versionInfo.downloads.clientMappings.url.value).build(),
                        HttpResponse.BodyHandlers.ofString()
                    ).body().also { println(it.length) }.reader()
                )!!

                channel.truncate(0)
                var fileOffset = 0L
                val output = FlushingOutput.Buffer(ByteBuffer.allocateDirect(32768)) { buffer, size ->
                    channel.write(buffer.clear().limit(size), fileOffset)
                    fileOffset += size
                }
                bslGPEncode(mapping, output)
                output.flush()
            }

            mapping!!
        }
    }

    val classPath = ConcurrentSkipListSet<Path>()
    val executor = Executors.newVirtualThreadPerTaskExecutor()
    CompletableFuture.allOf(
        *versionInfo.libraries.map library@{ library ->
            CompletableFuture.supplyAsync({
                library.rules?.forEach { rule ->
                    if (rule.os!!.name == "windows") {
                        if (rule.action != "allow") return@supplyAsync null
                    } else if (rule.action != "deny") return@supplyAsync null
                }

                val remotePath = library.downloads.artifact.path
                val fileSeparator = remotePath.lastIndexOf('/')
                val path = libraryPath.resolve(remotePath.take(fileSeparator)).resolve(
                    library.downloads.artifact.sha1.value.toHexString()
                ).resolve(remotePath.substring(fileSeparator + 1))
                path.parent.createDirectories()

                if (path.notExists()) {
                    client.send(
                        HttpRequest.newBuilder(library.downloads.artifact.url.value).build(),
                        HttpResponse.BodyHandlers.ofFile(path)
                    )
                    println("Downloaded ${path.name} (${path.fileSize()} bytes)")
                }

                classPath.add(gamePath.relativize(path))
            }, executor)
        }.toTypedArray()
    ).join()

    classPath.add(gamePath.relativize(clientJarPath))
    val classPathString = classPath.joinToString(";") { it.invariantSeparatorsPathString }

    val minecraft = Runtime.getRuntime().exec(
        arrayOf(
            Path(System.getProperty("java.home")).resolve("bin").resolve("java").toString(),
            "-cp", classPathString,
            "net.minecraft.client.main.Main",
            "--version", minecraftVersion,
            "--accessToken", "0"
        ),
        null,
        gamePath.createDirectories().toFile()
    )
    minecraft.inputStream.transferTo(System.out)
    minecraft.errorStream.transferTo(System.err)
    println(minecraft.waitFor())
}