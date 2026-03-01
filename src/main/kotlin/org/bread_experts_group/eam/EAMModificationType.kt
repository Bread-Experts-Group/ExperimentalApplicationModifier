package org.bread_experts_group.eam

import org.bread_experts_group.BSLLogMessage
import org.bread_experts_group.BSLLogMessage.Companion.info
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.logAllLoadsFlag
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeMimics
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeTransformedClasses
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeTransformedFeatures
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.V1X0X0MinecraftImplementations
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations
import org.bread_experts_group.generic.Mappable
import org.bread_experts_group.generic.command_line.Flag
import org.bread_experts_group.generic.command_line.readArgs
import org.bread_experts_group.generic.logging.LevelLogger
import java.lang.instrument.ClassFileTransformer
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain

enum class EAMModificationType(
	override val id: String,
	val instrument: (instrumentation: Instrumentation, args: Array<String>) -> Unit
) : Mappable<EAMModificationType, String> {
	MINECRAFT(
		"minecraft",
		{ instrumentation, args ->
			val scanning = mutableMapOf<String, (ClassLoader?, Class<*>?, ProtectionDomain, ByteArray) -> ByteArray?>()
			val versions = mapOf(
				"1.0" to V1X0X0MinecraftImplementations,
				"1.0.0" to V1X0X0MinecraftImplementations,
				"1.21.1" to V1X21X1MinecraftImplementations
			)
			val versionFlag = Flag(
				"version",
				"The Minecraft version to target.\nAcceptable values: ${versions.keys}",
				required = 1,
				conv = { versions[it] ?: throw IllegalArgumentException("Cannot modify for unknown version $it") }
			)
			val arguments = readArgs(
				args,
				"BEG EAM Minecraft modification",
				"EAM for Minecraft Modding.",
				versionFlag,
				logAllLoadsFlag,
				writeTransformedClasses,
				writeTransformedFeatures,
				writeMimics
			)
			val logger = LevelLogger<BSLLogMessage>("TMP logger EAM")
			instrumentation.addTransformer(object : ClassFileTransformer {
				override fun transform(
					module: Module?,
					loader: ClassLoader?,
					className: String,
					classBeingRedefined: Class<*>?,
					protectionDomain: ProtectionDomain,
					classfileBuffer: ByteArray
				): ByteArray? {
					if (arguments.get(logAllLoadsFlag) == true) logger.info(
						"Loading class $className [$classBeingRedefined, $module] Data#${classfileBuffer.size}"
					)
					return runCatching {
						scanning[className]?.invoke(
							loader,
							classBeingRedefined, protectionDomain, classfileBuffer
						)
					}.onFailure {
						it.printStackTrace()
					}.getOrNull()
				}
			}, instrumentation.isRetransformClassesSupported)
			val impl = arguments.getRequired(versionFlag)
			impl.implement(instrumentation, scanning)
			MinecraftImplementations.arguments = arguments
			if (impl.preload().isNotEmpty()) impl.preload().forEach { loadClass(it).getConstructor() }
		}
	);

	override val tag: String = name
	override fun toString(): String = stringForm()
}