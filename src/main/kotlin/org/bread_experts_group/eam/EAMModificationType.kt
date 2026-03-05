package org.bread_experts_group.eam

import org.bread_experts_group.api.system.SystemFeatures
import org.bread_experts_group.api.system.SystemProvider
import org.bread_experts_group.api.system.device.SystemDeviceFeatures
import org.bread_experts_group.api.system.io.IODevice
import org.bread_experts_group.api.system.io.IODeviceFeatures
import org.bread_experts_group.api.system.io.open.FileIOOpenFeatures
import org.bread_experts_group.api.system.io.open.FileIOReOpenFeatures
import org.bread_experts_group.api.system.io.open.StandardIOOpenFeatures
import org.bread_experts_group.api.system.io.open.WindowsIOReOpenFeatures
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.logAllLoadsFlag
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeMimics
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeTransformedClasses
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeTransformedFeatures
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.V1X0X0MinecraftImplementations
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations
import org.bread_experts_group.generic.Mappable
import org.bread_experts_group.generic.command_line.Flag
import org.bread_experts_group.generic.command_line.readArgs
import org.bread_experts_group.generic.logging.LevelLogger
import java.lang.instrument.ClassFileTransformer
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain
import kotlin.time.DurationUnit
import kotlin.time.toDuration

enum class EAMModificationType(
	override val id: String,
	val instrument: (instrumentation: Instrumentation, args: Array<String>) -> Unit
) : Mappable<EAMModificationType, String> {
	MINECRAFT(
		"minecraft",
		{ instrumentation, args ->
			val scanning = mutableMapOf<String, ClassTransform>()
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
			val logLoadsPath = arguments.get(logAllLoadsFlag)
			val startTime = System.nanoTime()
			val logger = if (logLoadsPath != null) {
				val logDevice = SystemProvider.get(SystemFeatures.GET_CURRENT_WORKING_PATH_DEVICE).device
					.get(SystemDeviceFeatures.PATH_APPEND).append(logLoadsPath)
					.get(SystemDeviceFeatures.IO_DEVICE).open(
						StandardIOOpenFeatures.CREATE,
						FileIOOpenFeatures.TRUNCATE,
						FileIOReOpenFeatures.WRITE,
						FileIOReOpenFeatures.SHARE_READ,
						WindowsIOReOpenFeatures.OPTIMIZE_SEQUENTIAL_ACCESS
					).firstNotNullOf { it as? IODevice }
				val ldWrite = logDevice.get(IODeviceFeatures.WRITE)
				val newLogger = LevelLogger<EAMLogMessage>("EAM Load Logger")
				ldWrite.sendString(
					"EAM Load Logger - Initial Nanos: $startTime",
					Charsets.UTF_8
				)
				newLogger.flushers.add { _, entry ->
					ldWrite.sendString(
						"\n[${(entry.nano - startTime).toDuration(DurationUnit.NANOSECONDS)}] ${entry.message}",
						Charsets.UTF_8
					)
				}
				newLogger
			} else null
			instrumentation.addTransformer(object : ClassFileTransformer {
				override fun transform(
					module: Module?,
					loader: ClassLoader?,
					className: String?,
					classBeingRedefined: Class<*>?,
					protectionDomain: ProtectionDomain?,
					classfileBuffer: ByteArray?
				): ByteArray? {
					if (protectionDomain == null || classfileBuffer == null) return null
					logger?.log(
						EAMLogMessage(
							"Loading class $className in $module from $loader" +
									if (classBeingRedefined != null) "(was $classBeingRedefined)" else "",
						)
					)
					return try {
						scanning[className]?.transformClass(classfileBuffer) ?: classfileBuffer
					} catch (t: Throwable) {
						t.printStackTrace()
						throw t
					}
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