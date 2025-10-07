package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.eam.minecraft.MinecraftProvider
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain
import java.util.*

object V1x21x1Implementations {
	private val classFile: ClassFile = ClassFile.of()

	lateinit var instrumentation: Instrumentation
	lateinit var scanning: MutableMap<String, (ClassLoader?, Class<*>?, ProtectionDomain, ByteArray) -> ByteArray?>
	val mods: List<MinecraftMod> = ServiceLoader.load(MinecraftMod::class.java).toList()

	fun preBootstrap() {
		scanning[net_minecraft_core_registries_BuiltInRegistries] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (
					classElement is MethodModel &&
					classElement.methodName().equalsString(net_minecraft_core_registries_BuiltInRegistries_createContents) &&
					classElement.methodType().equalsString("()V")
				) {
					classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
						if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							if (codeElement is ReturnInstruction) {
								codeBuilder.invokestatic(
									ClassDesc.of(this::class.qualifiedName),
									"afterCreateContents",
									MethodTypeDesc.of(ConstantDescs.CD_void)
								)
							}
							codeBuilder.with(codeElement)
						}
					}
				} else classBuilder.with(classElement)
			}
		}
	}

	@JvmStatic
	@Suppress("unused")
	fun afterCreateContents() {
		MinecraftProvider.features.add(MinecraftBlockFeature1x21x1())
		mods.forEach { it.registerObjects() }
	}
}