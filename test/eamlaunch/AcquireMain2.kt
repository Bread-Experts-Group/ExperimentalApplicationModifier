package eamlaunch

import org.bread_experts_group.eamlaunch.api.AssetIndex
import org.bread_experts_group.eamlaunch.api.Mapping
import org.bread_experts_group.eamlaunch.api.VersionInfo
import org.bread_experts_group.eamlaunch.api.VersionManifestV2
import org.bread_experts_group.eamlaunch.api.mappingDecode
import org.bread_experts_group.eamlaunch.pending_bsl.bslGPDecode
import org.bread_experts_group.eamlaunch.pending_bsl.bslGPEncode
import org.bread_experts_group.eamlaunch.pending_bsl.jsonDecode
import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.bread_systems_library.model.jsonParse
import java.io.EOFException
import java.io.File
import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.OpenOption
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.security.MessageDigest
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentSkipListSet
import java.util.concurrent.Executors
import java.util.concurrent.Flow
import java.util.concurrent.atomic.AtomicInteger
import kotlin.io.path.Path
import kotlin.io.path.bufferedReader
import kotlin.io.path.createDirectories
import kotlin.io.path.exists
import kotlin.io.path.fileSize
import kotlin.io.path.invariantSeparatorsPathString
import kotlin.io.path.name
import kotlin.io.path.notExists
import kotlin.reflect.typeOf
import kotlin.system.exitProcess

const val minecraftVersion = "1.21.1"

val minecraftPath = Path("./minecraft")
val minecraftVersionPath = Path("./minecraft/$minecraftVersion")

val libraryPath: Path = minecraftPath.resolve("libraries")
val assetsPath: Path = minecraftPath.resolve("assets")
val gamePath: Path = minecraftVersionPath.resolve("game")
val eamLaunchResourcePath: Path = minecraftVersionPath.resolve("eam launch")

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

    val localData = ThreadLocal.withInitial { ByteBuffer.allocateDirect(32768) }
    val localSha = ThreadLocal.withInitial { MessageDigest.getInstance("SHA-1") }
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
        val input = input(channel, localData.get())
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

            writeBSLGP(versionInfo, localData.get(), channel)
        }
        versionInfo!!
    }

    val clientJarPath = eamLaunchResourcePath.resolve("client.jar")
    if (clientJarPath.exists() && !update) try {
        FileChannel.open(clientJarPath, StandardOpenOption.READ).use {
            verify(
                localSha.get(),
                versionInfo.downloads.client.sha1.value,
                localData.get(),
                it
            )
        }
    } catch (_: IOException) {
        download(
            client,
            localSha.get(),
            versionInfo.downloads.client,
            clientJarPath
        )
    } else download(
        client,
        localSha.get(),
        versionInfo.downloads.client,
        clientJarPath
    )

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
            val input = input(channel, localData.get())
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
                        localSha.get(),
                        versionInfo.downloads.clientMappings
                    ).reader()
                )!!

                writeBSLGP(mapping, localData.get(), channel)
            }

            mapping!!
        }
    }

    val assetIndexPath = assetsPath.resolve("indexes").createDirectories()
        .resolve("${versionInfo.assetIndexID}.json")

    val executor = Executors.newFixedThreadPool(5)
    val executor2 = Executors.newCachedThreadPool()
    val assetsDownloaded = AtomicInteger(0)

    client.send(
        HttpRequest.newBuilder(versionInfo.assetIndex.url.value).build(),
        HttpResponse.BodyHandlers.ofFile(assetIndexPath)
    )

    val assetIndex = jsonDecode<AssetIndex>(jsonParse(assetIndexPath.bufferedReader()))
    val objectsPath = assetsPath.resolve("objects")
    CompletableFuture.allOf(
        *assetIndex.objects.map { (_, obj) ->
            val hex = obj.hash.value.toHexString()
            val hex2 = hex.substring(0..1)
            val path = objectsPath.resolve(hex2).createDirectories().resolve(hex)

            fun download() {
                var tries = 0
                while (tries < 3) try {
                    download(
                        client,
                        localSha.get(),
                        URI("https://resources.download.minecraft.net/$hex2/$hex"),
                        obj.hash.value,
                        path
                    )
                    break
                } catch (e: IOException) {
                    tries++
                    if (tries == 3) println("Failed ${path.fileName} ${assetsDownloaded.incrementAndGet()} / ${assetIndex.objects.size}: $e")
                }
            }

            if (path.notExists()) CompletableFuture.runAsync({
                download()
            }, executor) else CompletableFuture.runAsync({
                FileChannel.open(path, StandardOpenOption.READ).use {
                    verify(localSha.get(), obj.hash.value, localData.get(), it)
                }
            }, executor2).exceptionallyAsync({ _ ->
                println("Redownloading ${path.fileName}")
                download()
                null
            }, executor)
        }.toTypedArray()
    ).join()
    executor2.shutdown()

    val classPath = ConcurrentSkipListSet<Path>()
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
    executor.shutdown()

    classPath.add(gamePath.relativize(clientJarPath))
    val classPathString = classPath.joinToString(";") { it.invariantSeparatorsPathString }

    println("=/= =/= =/= =/= =/= =/=")

    //   --username
    //   --uuid
    //   --userType

    val minecraft = Runtime.getRuntime().exec(
        arrayOf(
            Path(System.getProperty("java.home")).resolve("bin").resolve("java").toString(),
            "-cp", classPathString,
            "-javaagent:${Path("./out/artifacts/ExperimentalApplicationModifier_jar/ExperimentalApplicationModifier.jar").toAbsolutePath()}=$minecraftVersion",
            "-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005",
            versionInfo.mainClass,
            "--gameDir", ".",
            "--assetsDir", gamePath.relativize(assetsPath).invariantSeparatorsPathString,
            "--assetIndex", versionInfo.assetIndexID,
            "--version", minecraftVersion,
            "--accessToken", "0",
            "--versionType", "release"
        ),
        null,
        gamePath.createDirectories().toFile()
    )
    Thread.ofVirtual().start {
        minecraft.inputStream.transferTo(System.out)
        minecraft.errorStream.transferTo(System.err)
        System.`in`.transferTo(minecraft.outputStream)
    }
    println(minecraft.waitFor())
}