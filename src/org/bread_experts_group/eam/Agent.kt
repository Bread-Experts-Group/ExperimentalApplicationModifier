package org.bread_experts_group.eam

import org.bread_experts_group.eam.mappings.Mappings
import org.bread_experts_group.eam.minecraft.v1x21x1.Minecraft
import org.bread_experts_group.eam.transform.TransformUtil
import org.bread_experts_group.eam.transform.TransformUtil.beforeFinalReturn
import java.io.PrintStream
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
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
					if (Mappings.obfuscatedClassName(Minecraft::class) != className)
						return super.transform(module, loader, className, classBeingRedefined, protectionDomain, classfileBuffer)

					println("!!! Found Minecraft ($className) !!!")
					val cf = TransformUtil.classFile
					val model = cf.parse(classfileBuffer)
					val mapping = Mappings.of(Minecraft::class)

					return cf.transformClass(model) { classBuilder, classElement ->
						if (classElement is MethodModel && classElement.methodName().equalsString("<init>")) {
							classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
								TransformUtil.dumpIndex(methodElement)
								if (methodElement is CodeModel) {
									methodBuilder.beforeFinalReturn(methodElement) { codeBuilder ->
										codeBuilder
											.getstatic(System::class.classDesc, "out", PrintStream::class.classDesc)
											.ldc("WORDS".toConstantDesc())
											.invokevirtual(PrintStream::class.classDesc, "println", MethodTypeDesc.of(
												ConstantDescs.CD_void, ConstantDescs.CD_String))
									}
								} else methodBuilder.with(methodElement)
							}
						} else classBuilder.with(classElement)
					}
				}
			})
		}
	}
}