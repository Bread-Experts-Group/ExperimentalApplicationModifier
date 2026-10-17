package org.bread_experts_group.eam

import org.bread_experts_group.eam.mappings.Mappings
import org.bread_experts_group.eam.minecraft.v1x21x1.Minecraft
import java.lang.instrument.ClassFileTransformer
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain

@Suppress("unused")
class Agent {
	companion object {
		@JvmStatic
		fun premain(agentArgs: String, instrumentation: Instrumentation) {
			// todo remove legacy parsing and mappings with new code after it's finished
			main(agentArgs)
			println("Starting EAM Agent")

			instrumentation.addTransformer(object : ClassFileTransformer {
				override fun transform(
					module: Module?,
					loader: ClassLoader?,
					className: String?,
					classBeingRedefined: Class<*>?,
					protectionDomain: ProtectionDomain?,
					classfileBuffer: ByteArray?
				): ByteArray? {
					if (Mappings.obfuscatedClassName(Minecraft::class) == className) {
						println("!!! Found Minecraft ($className) !!!")
					}

					return super.transform(module, loader, className, classBeingRedefined, protectionDomain, classfileBuffer)
				}
			})
		}
	}
}