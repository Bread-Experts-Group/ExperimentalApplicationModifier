package org.bread_experts_group.eam

import org.bread_experts_group.eam.minecraft.v1x21x1.transform.MinecraftTransform
import org.bread_experts_group.eamlaunch.*
import org.bread_experts_group.eamlaunch.api.Mapping
import java.lang.classfile.ClassFile
import java.lang.instrument.ClassFileTransformer
import java.lang.instrument.Instrumentation
import java.net.http.HttpClient
import java.nio.ByteBuffer
import java.nio.file.Path
import java.security.MessageDigest
import java.security.ProtectionDomain
import kotlin.io.path.Path

@Suppress("unused")
class Agent {
	companion object {
		@JvmField
		val classFile: ClassFile = ClassFile.of()

		private fun configureMappings(eamLaunchPath: Path) {
			val client = HttpClient.newHttpClient()

			val versionManifest = getVersionManifest(client)
			val version = getVersion(versionManifest)

			val localData = ByteBuffer.allocateDirect(32768)

			val (versionInfo, versionInfoUpdated) = getVersionInfo(
				version, eamLaunchPath.resolve(versionInfoPath),
				client, localData
			)

			versionInfo.downloads.clientMappings?.let {
				val localSha = MessageDigest.getInstance("SHA-1")
				val mapping = getMapping(
					it, versionInfoUpdated, eamLaunchPath.resolve(versionClientMappingsPath),
					client, localSha, localData
				)
				Mapping.INSTANCE = mapping.value
			}
			client.shutdown()
		}

		@JvmStatic
		fun premain(agentArgs: String, instrumentation: Instrumentation) {
			println("Starting EAM Agent")
			configureMappings(if (agentArgs.isEmpty()) Path(".") else Path(agentArgs))

			instrumentation.addTransformer(object : ClassFileTransformer {
				override fun transform(
					module: Module?,
					loader: ClassLoader?,
					className: String,
					classBeingRedefined: Class<*>?,
					protectionDomain: ProtectionDomain?,
					classfileBuffer: ByteArray
				): ByteArray? {
					try {
						val transforms: Array<ClassTransform<*>> = arrayOf(MinecraftTransform())
						transforms.forEach { transform ->
							val mapping = Mapping.of(transform.target)
							if (className != mapping.obfuscated.displayName()) return null
							val model = classFile.parse(classfileBuffer)

							println("Transforming ${transform.target.simpleName} ($className)")
							return classFile.transformClass(model) { classBuilder, classElement ->
								transform.transform().invoke(classBuilder, classElement)
							}
						}
					} catch (e: Throwable) {
						println("Agent transformation error...")
						e.printStackTrace()
					}

					return null
				}
			}, instrumentation.isRetransformClassesSupported)
		}
	}
}