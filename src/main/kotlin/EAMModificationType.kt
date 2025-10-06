package org.bread_experts_group.eam

import org.bread_experts_group.coder.Mappable
import org.bread_experts_group.command_line.Flag
import org.bread_experts_group.command_line.readArgs
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.V1x21x1Implementations
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
			instrumentation.addTransformer(object : ClassFileTransformer {
				override fun transform(
					module: Module?,
					loader: ClassLoader?,
					className: String,
					classBeingRedefined: Class<*>?,
					protectionDomain: ProtectionDomain,
					classfileBuffer: ByteArray
				): ByteArray? {
					return scanning[className]?.invoke(
						loader,
						classBeingRedefined, protectionDomain, classfileBuffer
					)
				}
			}, false)
			val versionFlag = Flag(
				"version",
				"The Minecraft version to target.",
				required = 1,
				conv = {
					when (it) {
						"1.21.1" -> {
							V1x21x1Implementations.instrumentation = instrumentation
							V1x21x1Implementations.scanning = scanning
							V1x21x1Implementations.preBootstrap()
						}
						else -> throw IllegalArgumentException("Cannot modify for unknown version $it")
					}
					it
				}
			)
			readArgs(
				args,
				"BEG EAM Minecraft modification",
				"TODO write usage",
				versionFlag
			)
//			ServiceLoader.load(MinecraftMod::class.java).toList()
		}
	);

	override val tag: String = name
	override fun toString(): String = stringForm()
}