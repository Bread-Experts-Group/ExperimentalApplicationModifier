package org.bread_experts_group.eam.org.bread_experts_group

import org.bread_experts_group.coder.Mappable
import org.bread_experts_group.command_line.Flag
import org.bread_experts_group.command_line.readArgs
import org.bread_experts_group.command_line.stringToBoolean
import org.bread_experts_group.eam.minecraft.feature.v1x0x0.V1x0x0Implementations
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.V1x21x1Implementations
import org.bread_experts_group.logging.ColoredHandler
import java.lang.instrument.ClassFileTransformer
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain

enum class EAMModificationType(
	override val id: String,
	val instrument: (instrumentation: Instrumentation, args: Array<String>) -> Unit
) : Mappable<EAMModificationType, String> {
	MINECRAFT(
		"org/bread_experts_group/minecraft_experts_group/minecraft",
		{ instrumentation, args ->
			val scanning = mutableMapOf<String, (ClassLoader?, Class<*>?, ProtectionDomain, ByteArray) -> ByteArray?>()
			val versionFlag = Flag(
				"version",
				"The Minecraft version to target.",
				required = 1,
				conv = {
					when (it) {
						"1.0", "1.0.0" -> V1x0x0Implementations
						"1.21.1" -> V1x21x1Implementations
						else -> throw IllegalArgumentException("Cannot modify for unknown version $it")
					}
				}
			)
			val logAllLoadsFlag = Flag(
				"log_all_class_loads",
				"Loads all class loads.",
				conv = ::stringToBoolean
			)
			val args = readArgs(
				args,
				"BEG EAM Minecraft modification",
				"TODO write usage",
				versionFlag,
				logAllLoadsFlag
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
					if (args.get(logAllLoadsFlag) == true) logger.info(
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
			args.getRequired(versionFlag).implement(instrumentation, scanning)
		}
	);

	override val tag: String = name
	override fun toString(): String = stringForm()
}