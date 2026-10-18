package org.bread_experts_group.eam

import org.bread_experts_group.eam.minecraft.v1x21x1.transform.MinecraftTransform
import org.bread_experts_group.eam.transform.ClassTransform
import org.bread_experts_group.eam.transform.TransformUtil
import org.bread_experts_group.eamlaunch.api.Mapping
import java.lang.instrument.ClassFileTransformer
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain

@Suppress("unused")
class Agent {
	companion object {
		@JvmStatic
		fun premain(agentArgs: String, instrumentation: Instrumentation) {
			val args = agentArgs.split(",")
			// todo remove legacy parsing and mappings with new code after it's finished
			Mapping.INSTANCE = Mapping.getMappingForMinecraftVersion(args[0])
			println("Starting EAM Agent")

			instrumentation.addTransformer(object : ClassFileTransformer {
				override fun transform(
					module: Module?,
					loader: ClassLoader?,
					className: String?,
					classBeingRedefined: Class<*>?,
					protectionDomain: ProtectionDomain?,
					classfileBuffer: ByteArray?
				): ByteArray? = if (className != null && classfileBuffer != null)
					runTransforms(className, classfileBuffer) else null
			})
		}

		private val transforms: Array<ClassTransform<*>> = arrayOf(MinecraftTransform)

		fun runTransforms(className: String, classFileBuffer: ByteArray): ByteArray? {
			val classFile = TransformUtil.classFile

			val transform = transforms.firstOrNull { className == Mapping.of(it.target).obfuscated.displayName() }
			val model = classFile.parse(classFileBuffer)
			return if (transform != null) {
				classFile.transformClass(model) { classBuilder, classElement ->
					transform.transform().invoke(classBuilder, classElement)
				}
			} else null
		}
	}
}