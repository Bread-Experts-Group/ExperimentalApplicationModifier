package org.bread_experts_group.eam

import org.bread_experts_group.eam.minecraft.v1x21x1.transform.MinecraftTransform
import org.bread_experts_group.eamlaunch.api.Mapping
import java.lang.classfile.ClassFile
import java.lang.instrument.ClassFileTransformer
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain

@Suppress("unused")
class Agent {
	companion object {
		@JvmField
		val classFile: ClassFile = ClassFile.of()

		@JvmStatic
		fun premain(agentArgs: String, instrumentation: Instrumentation) {
			println("Starting EAM Agent")

			instrumentation.addTransformer(object : ClassFileTransformer {
				override fun transform(
					module: Module?,
					loader: ClassLoader?,
					className: String,
					classBeingRedefined: Class<*>?,
					protectionDomain: ProtectionDomain?,
					classfileBuffer: ByteArray
				): ByteArray? {
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

					return null
				}
			}, instrumentation.isRetransformClassesSupported)
		}
	}
}