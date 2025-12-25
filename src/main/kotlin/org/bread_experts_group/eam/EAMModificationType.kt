package org.bread_experts_group.eam

import org.bread_experts_group.Mappable
import org.bread_experts_group.command_line.Flag
import org.bread_experts_group.command_line.readArgs
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.logAllLoadsFlag
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeMimics
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeTransformedClasses
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeTransformedFeatures
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.V1X0X0MinecraftImplementations
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations
import org.bread_experts_group.logging.ColoredHandler
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
			val versionFlag = Flag(
				"version",
				"The Minecraft version to target.",
				required = 1,
				conv = {
					when (it) {
						"1.0", "1.0.0" -> V1X0X0MinecraftImplementations
						"1.21.1" -> V1X21X1MinecraftImplementations
						else -> throw IllegalArgumentException("Cannot modify for unknown version $it")
					}
				}
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
			val logger = ColoredHandler.newLogger("TMP logger EAM")
			instrumentation.addTransformer(object : ClassFileTransformer {
				override fun transform(
					module: Module?,
					loader: ClassLoader?,
					className: String,
					classBeingRedefined: Class<*>?,
					protectionDomain: ProtectionDomain,
					classfileBuffer: ByteArray
				): ByteArray? {
					if (className == "xe") println("THE CLASS IS FOUND")
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
			}, false)
			arguments.getRequired(versionFlag).implement(instrumentation, scanning)
			MinecraftImplementations.arguments = arguments
		}
	);

	override val tag: String = name
	override fun toString(): String = stringForm()
}