package org.bread_experts_group.eamlaunch

import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.bread_systems_library.model.jsonParse
import org.bread_experts_group.eamlaunch.api.Mapping
import org.bread_experts_group.eamlaunch.api.VersionInfo
import org.bread_experts_group.eamlaunch.api.VersionManifestV2
import org.bread_experts_group.eamlaunch.api.mappingDecode
import org.bread_experts_group.eamlaunch.pending_bsl.bslGPDecode
import org.bread_experts_group.eamlaunch.pending_bsl.bslGPEncode
import org.bread_experts_group.eamlaunch.pending_bsl.jsonDecode
import java.io.EOFException
import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.security.MessageDigest
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.concurrent.Flow
import kotlin.io.path.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.notExists
import kotlin.reflect.typeOf
import kotlin.system.exitProcess

const val minecraftVersion = "1.21.1"

val eamLaunchPath = Path("./eam launch")
val minecraftVersionPath: Path = eamLaunchPath.resolve(minecraftVersion)

val libraryPath: Path = eamLaunchPath.resolve("libraries")
val assetsPath: Path = eamLaunchPath.resolve("assets")
val gamePath: Path = minecraftVersionPath.resolve("game")

val minecraftVersionResourcePath: Path = minecraftVersionPath.resolve("eam resources")
val versionInfoPath: Path = minecraftVersionResourcePath.resolve("version info.bsl gp")
val versionClientJARPath: Path = minecraftVersionResourcePath.resolve("client.jar")
val versionClientMappingsPath: Path = minecraftVersionResourcePath.resolve("client mappings.bsl gp")

val userDateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss.SSS")

fun verifyFail(content: String, received: ByteArray, expected: ByteArray){
    if (!received.contentEquals(expected)) throw IOException(
        "Failed to verify $content. " +
                "Received/expected hash: ${received.toHexString()} / ${expected.toHexString()}"
    )
}

fun verify(
    hash: MessageDigest,
    verifyHash: ByteArray,
    buffer: ByteBuffer,
    channel: FileChannel
) {
    while (true) {
        val read = channel.read(buffer.clear())
        if (read == -1) break
        hash.update(buffer.flip())
    }
    verifyFail("content", hash.digest(), verifyHash)
}

fun getVersionManifest(client: HttpClient): VersionManifestV2 = jsonDecode<VersionManifestV2>(
    jsonParse(
        client.send(
            HttpRequest.newBuilder(URI("https://piston-meta.mojang.com/mc/game/version_manifest_v2.json")).build(),
            HttpResponse.BodyHandlers.ofString()
        ).body().reader()
    )
)

fun getVersion(versionManifest: VersionManifestV2, id: String = minecraftVersion): VersionManifestV2.Version {
    val version = versionManifest.versions.firstOrNull { it.id == id }
    if (version == null) {
        System.err.println("Version manifest did not provide an entry for version \"$minecraftVersion\".")
        exitProcess(1)
    }
    return version
}

fun downloadString(
    client: HttpClient,
    sha1: MessageDigest,
    download: VersionInfo.Downloads.Entry
): String {
    val builder = StringBuilder(download.size.intValueExact())
    val utf8 = Charsets.UTF_8.newDecoder()

    client.send(
        HttpRequest.newBuilder(download.url.value).build(),
        HttpResponse.BodyHandlers.fromSubscriber(
            object : Flow.Subscriber<List<ByteBuffer>> {
                override fun onSubscribe(subscription: Flow.Subscription) {
                    sha1.reset()
                    subscription.request(Long.MAX_VALUE)
                }

                override fun onNext(item: List<ByteBuffer>) {
                    item.forEach { buffer ->
                        sha1.update(buffer)
                        builder.append(utf8.decode(buffer.rewind()))
                    }
                }

                override fun onError(throwable: Throwable) {
                    throw throwable
                }

                override fun onComplete() {
                    verifyFail("content from ${download.url.value}", sha1.digest(), download.sha1.value)
                }
            }
        )
    )

    return builder.toString()
}

fun download(
    client: HttpClient,
    sha1: MessageDigest,
    uri: URI,
    verifyHash: ByteArray,
    file: Path
) {
    file.parent.createDirectories()
    val channel = Files.newByteChannel(file, StandardOpenOption.WRITE, StandardOpenOption.CREATE)
    channel.truncate(0)

    client.send(
        HttpRequest.newBuilder(uri).build(),
        HttpResponse.BodyHandlers.fromSubscriber(
            object : Flow.Subscriber<List<ByteBuffer>> {
                override fun onSubscribe(subscription: Flow.Subscription) {
                    sha1.reset()
                    subscription.request(Long.MAX_VALUE)
                }

                override fun onNext(item: List<ByteBuffer>) {
                    item.forEach { buffer ->
                        sha1.update(buffer)
                        channel.write(buffer.rewind())
                    }
                }

                override fun onError(throwable: Throwable) {
                    channel.close()
                    throw throwable
                }

                override fun onComplete() {
                    channel.close()
                    verifyFail("content from $uri", sha1.digest(), verifyHash)
                }
            }
        )
    )
}

fun download(
    client: HttpClient,
    sha1: MessageDigest,
    download: VersionInfo.Downloads.Entry,
    file: Path
) = download(client, sha1, download.url.value, download.sha1.value, file)

inline fun <reified T> writeBSLGP(data: T, buffer: ByteBuffer, channel: FileChannel) {
    channel.truncate(0)

    var fileOffset = 0L
    val output = FlushingOutput.Buffer(buffer) { buffer, size ->
        channel.write(buffer.clear().limit(size), fileOffset)
        fileOffset += size
    }
    bslGPEncode(typeOf<T>(), data, output)
    output.flush()
}

fun input(channel: FileChannel, buffer: ByteBuffer): BlockingInput {
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
    return input
}

data class UpdatableValue<T>(val value: T, val wasUpdated: Boolean = false)

fun getVersionInfo(
    version: VersionManifestV2.Version,
    versionInfoPath: Path,
    client: HttpClient,
    buffer: ByteBuffer
): UpdatableValue<VersionInfo> {
    versionInfoPath.parent.createDirectories()

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
        val input = input(channel, buffer)
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
                        HttpRequest.newBuilder(version.url.value).build(),
                        HttpResponse.BodyHandlers.ofString()
                    ).body().reader()
                )
            )

            writeBSLGP(versionInfo, buffer, channel)
        }
        versionInfo!!
    }

    return UpdatableValue(versionInfo, update)
}

fun getMapping(
    entry: VersionInfo.Downloads.Entry,
    versionInfoUpdated: Boolean,
    path: Path,
    client: HttpClient,
    sha1: MessageDigest,
    buffer: ByteBuffer
): UpdatableValue<Mapping> {
    path.parent.createDirectories()
    var update = false
    val mapping = (if (path.notExists() || versionInfoUpdated) FileChannel.open(
        path,
        StandardOpenOption.READ, StandardOpenOption.WRITE,
        StandardOpenOption.CREATE
    ).also {
        println("No local mapping or version was updated")
        update = true
    } else FileChannel.open(
        path,
        StandardOpenOption.READ, StandardOpenOption.WRITE
    )).use { channel ->
        val input = input(channel, buffer)
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
                downloadString(
                    client,
                    sha1,
                    entry
                ).reader()
            )!!

            writeBSLGP(mapping, buffer, channel)
        }

        mapping!!
    }
    return UpdatableValue(mapping, update)
}