
import org.bread_experts_group.bread_systems_library.model.jsonParse
import org.bread_experts_group.eam.minecraft.v1x21x1.Minecraft
import org.bread_experts_group.eamlaunch.api.Mapping
import org.bread_experts_group.eamlaunch.api.VersionInfo
import org.bread_experts_group.eamlaunch.api.VersionManifestV2
import org.bread_experts_group.eamlaunch.api.mappingDecode
import org.bread_experts_group.eamlaunch.pending_bsl.jsonDecode
import java.lang.constant.ConstantDescs
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    Mapping.INSTANCE = getMappingForMinecraftVersion("1.21.1")
    val mapping = Mapping.of(Minecraft::class)

    mapping.let {
        println("name: ${it.unobfuscated} (${it.obfuscated})")
        val init = it.getMethod(ConstantDescs.INIT_NAME) ?: return

        println(init)
        println(init.obfTypeDesc())
        println(init.obfReturnDesc())
        println(init.unobfTypeDesc())
        println(init.unobfReturnDesc())
    }
}

// stripped down version of mappings downloader in AcquireMain2 (testing only)
fun getMappingForMinecraftVersion(minecraftVersion: String): Mapping {
    val client = HttpClient.newHttpClient()
    val versionManifest = jsonDecode<VersionManifestV2>(
        jsonParse(
            client.send(
                HttpRequest.newBuilder(URI("https://piston-meta.mojang.com/mc/game/version_manifest_v2.json"))
                    .build(),
                HttpResponse.BodyHandlers.ofString()
            ).body().reader()
        )
    )
    val versionInfo = jsonDecode<VersionInfo>(
        jsonParse(
            client.send(
                HttpRequest.newBuilder(versionManifest.versions.first { it.id == minecraftVersion }.url.value)
                    .build(),
                HttpResponse.BodyHandlers.ofString()
            ).body().reader()
        )
    )

    return mappingDecode(
        client.send(
            HttpRequest.newBuilder(versionInfo.downloads.clientMappings?.url?.value).build(),
            HttpResponse.BodyHandlers.ofString()
        ).body().also { println(it.length) }.reader()
    )!!
}