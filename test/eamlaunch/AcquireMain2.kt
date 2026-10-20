package eamlaunch

import org.bread_experts_group.bread_systems_library.model.jsonParse
import org.bread_experts_group.eamlaunch.api.AssetIndex
import org.bread_experts_group.eamlaunch.api.SHA1
import org.bread_experts_group.eamlaunch.api.VersionManifestV2
import org.bread_experts_group.eamlaunch.pending_bsl.jsonDecode
import java.io.IOException
import java.lang.management.ManagementFactory
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.security.MessageDigest
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentSkipListSet
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.io.path.*
import kotlin.system.exitProcess

const val minecraftVersion = "1.21.1"

val minecraftPath = Path("./minecraft")
val minecraftVersionPath = Path("./minecraft/$minecraftVersion")

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
    val (versionInfo, versionInfoUpdated) = getVersionInfo(version, versionInfoPath, client, localData.get())

    val clientJarPath = eamLaunchResourcePath.resolve("client.jar")
    try {
        FileChannel.open(clientJarPath, StandardOpenOption.READ).use {
            if (!versionInfoUpdated) verify(
                localSha.get(),
                versionInfo.downloads.client.sha1.value,
                localData.get(),
                it
            ) else throw IOException()
        }
    } catch (_: IOException) {
        download(
            client,
            localSha.get(),
            versionInfo.downloads.client,
            clientJarPath
        )
    }

    versionInfo.downloads.clientMappings?.let {
        val mappingPath = eamLaunchResourcePath.resolve("mapping").also { mappingFile ->
            mappingFile.parent.createDirectories()
        }
        getMapping(it, versionInfoUpdated, mappingPath, client, localSha.get(), localData.get())
    }

    val assetIndexPath = assetsPath.resolve("indexes").createDirectories()
        .resolve("${versionInfo.assetIndexID}.json")

    client.send(
        HttpRequest.newBuilder(versionInfo.assetIndex.url.value).build(),
        HttpResponse.BodyHandlers.ofFile(assetIndexPath)
    )

    val downloadExecutor = Executors.newFixedThreadPool(5)
    val verificationExecutor = Executors.newCachedThreadPool()

    fun downloadRetry(uri: URI, verifyHash: SHA1, path: Path) {
        var tries = 0
        while (tries < 3) try {
            download(
                client,
                localSha.get(),
                uri,
                verifyHash.value,
                path
            )
            break
        } catch (e: IOException) {
            tries++
            if (tries == 3) println("Failed ${path.fileName}: $e")
        }
    }

    val assetIndex = jsonDecode<AssetIndex>(jsonParse(assetIndexPath.bufferedReader()))
    val objectsPath = assetsPath.resolve("objects")
    CompletableFuture.allOf(
        *assetIndex.objects.map { (_, obj) ->
            val hex = obj.hash.value.toHexString()
            val hex2 = hex.substring(0..1)
            val path = objectsPath.resolve(hex2).createDirectories().resolve(hex)

            val download = {
                downloadRetry(
                    URI("https://resources.download.minecraft.net/$hex2/$hex"),
                    obj.hash,
                    path
                )
            }

            if (path.notExists()) CompletableFuture.runAsync({
                download()
            }, downloadExecutor) else CompletableFuture.runAsync({
                FileChannel.open(path, StandardOpenOption.READ).use {
                    verify(
                        localSha.get(),
                        obj.hash.value,
                        localData.get(),
                        it
                    )
                }
            }, verificationExecutor).exceptionallyAsync({ _ ->
                println("Redownloading ${path.fileName}")
                download()
                null
            }, downloadExecutor)
        }.toTypedArray()
    ).join()

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

                val download = {
                    downloadRetry(
                        library.downloads.artifact.url.value,
                        library.downloads.artifact.sha1,
                        path
                    )
                }

                if (path.notExists()) CompletableFuture.runAsync({
                    download()
                }, downloadExecutor) else CompletableFuture.runAsync({
                    FileChannel.open(path, StandardOpenOption.READ).use {
                        verify(
                            localSha.get(),
                            library.downloads.artifact.sha1.value,
                            localData.get(),
                            it
                        )
                    }
                }, verificationExecutor).exceptionallyAsync({ _ ->
                    println("Redownloading ${path.fileName}")
                    download()
                    null
                }, downloadExecutor)

                classPath.add(gamePath.relativize(path))
            }, downloadExecutor)
        }.toTypedArray()
    ).join()

    verificationExecutor.shutdown()
    downloadExecutor.shutdown()

    classPath.add(gamePath.relativize(clientJarPath))
    val classPathString = classPath.joinToString(";") { it.invariantSeparatorsPathString }

    println("=/= =/= =/= =/= =/= =/=")

    //   --username
    //   --uuid
    //   --userType

    val suspend = if (
        ManagementFactory.getRuntimeMXBean().inputArguments.any { it.startsWith("-agentlib:jdwp") }
    ) {
        println("Suspend debug mode: attach to the Minecraft process remotely")
        'y'
    } else 'n'

    val minecraft = ProcessBuilder(
        Path(System.getProperty("java.home")).resolve("bin").resolve("java").toString(),
        "-cp", classPathString,
        "-javaagent:${Path("./out/artifacts/ExperimentalApplicationModifier_jar/ExperimentalApplicationModifier.jar").toAbsolutePath()}=$minecraftVersion",
        "-agentlib:jdwp=transport=dt_socket,server=y,suspend=$suspend,address=*:5005",
        versionInfo.mainClass,
        "--gameDir", ".",
        "--assetsDir", gamePath.relativize(assetsPath).invariantSeparatorsPathString,
        "--assetIndex", versionInfo.assetIndexID,
        "--version", minecraftVersion,
        "--accessToken", "0",
        "--versionType", "release"
    ).run {
        inheritIO()
        directory(gamePath.createDirectories().toFile())
        start()
    }
    Runtime.getRuntime().addShutdownHook(
        thread(false) {
            minecraft.destroy()
            try {
                if (!minecraft.waitFor(5, TimeUnit.SECONDS)) minecraft.destroyForcibly()
            } catch (_: InterruptedException) {
                minecraft.destroyForcibly()
            }
        }
    )
    val exit = minecraft.waitFor()
    println("=/= =/= =/= =/= =/= =/=")
    exitProcess(exit)
}