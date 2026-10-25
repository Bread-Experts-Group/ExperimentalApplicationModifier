package org.bread_experts_group.eam

import org.bread_experts_group.eam.transform.v1x21x1.MinecraftTransform
import org.bread_experts_group.eam.transform.v1x21x1.TitleScreenTransform
import org.bread_experts_group.eamlaunch.*
import org.bread_experts_group.eamlaunch.api.Mapping
import java.lang.classfile.ClassFile
import java.lang.constant.ClassDesc
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
				val transforms: Array<ClassTransform<*>> = arrayOf(MinecraftTransform, TitleScreenTransform)
				val whitelist: Array<String> = arrayOf("joml")

				/**
				 * Adds non-mc classes to the mappings, such as joml so mimics can access them during runtime.
				 */
				fun addNonMinecraftClassToMappings(className: String) {
					if (whitelist.any { className.contains(it) }) {
						val desc = ClassDesc.of(className)
						// todo members
						Mapping.INSTANCE.unobfuscatedToClass[desc] = Mapping.Class(desc, desc, listOf())
					}
				}

				override fun transform(
					module: Module?,
					loader: ClassLoader?,
					className: String,
					classBeingRedefined: Class<*>?,
					protectionDomain: ProtectionDomain?,
					classfileBuffer: ByteArray
				): ByteArray? {
					try {
						val transform = transforms.firstOrNull { className == it.classMapping.obfuscated.displayName() }
						if (transform == null) {
							val name = className.replace('/', '.')
							if (Mapping.contains(name)) return null
							addNonMinecraftClassToMappings(name)
							return null
						}

						val mapping = Mapping.of(transform.target)
						if (className != mapping.obfuscated.displayName()) return null
						val model = classFile.parse(classfileBuffer)

						println("Transforming ${transform.target.simpleName} ($className)")
						return classFile.transformClass(model) { classBuilder, classElement ->
							transform.transform().invoke(classBuilder, classElement)
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