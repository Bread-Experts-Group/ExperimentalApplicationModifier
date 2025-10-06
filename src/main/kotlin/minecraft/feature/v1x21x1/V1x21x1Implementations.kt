package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.eam.minecraft.MinecraftProvider
import org.bread_experts_group.eam.minecraft.feature.nameObfuscatedField
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain

const val net_minecraft_server_Bootstrap: String = "akt"
const val net_minecraft_core_registries_BuiltInRegistries: String = "lt"
const val net_minecraft_world_level_block_Block: String = "dfy"
const val net_minecraft_world_level_block_state_BlockBehaviour_Properties: String = $$"dtb$d"
const val net_minecraft_core_MappedRegistry: String = "ju"
const val net_minecraft_core_Registry: String = "jz"
const val net_minecraft_world_level_block_Blocks: String = "dga"

object V1x21x1Implementations {
	private val classFile: ClassFile = ClassFile.of()

	lateinit var instrumentation: Instrumentation
	lateinit var scanning: MutableMap<String, (ClassLoader?, Class<*>?, ProtectionDomain, ByteArray) -> ByteArray?>

	fun preBootstrap() {
		scanning[net_minecraft_core_registries_BuiltInRegistries] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				classBuilder.nameObfuscatedField(classElement, model, "e", "BLOCK")
				classBuilder.nameObfuscatedField(classElement, model, "g", "ITEM")
				try {
					if (
						classElement is MethodModel &&
						classElement.methodName().equalsString("b") &&
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
				} catch (e: Throwable) {
					e.printStackTrace()
					TODO("!")
				}
			}
		}
	}

	@JvmStatic
	@Suppress("unused")
	fun afterCreateContents() {
		val blockRegistry = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_core_registries_BuiltInRegistries)
			.getMethod("BLOCK")
			.invoke(null)
		println(blockRegistry)
		val bsp = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_level_block_state_BlockBehaviour_Properties)
		val properties = bsp
			.getMethod("a")
			.invoke(null)
		println("$properties")
		val bc = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_level_block_Block)
		val block = bc
			.getConstructor(bsp)
			.newInstance(properties)
		println("$block")
		val bsr = bc.getDeclaredField("q").get(null)
		val bsrA = bsr::class.java.getDeclaredMethod("b", Object::class.java)
		val s = bc.getDeclaredMethod("l").invoke(block)
		val sdI = s::class.java.getDeclaredMethod("a").invoke(s)
		println("$bsr, $bsrA, $s, $sdI")
		val lll = sdI::class.java.getMethod("iterator").also { it.isAccessible = true }.invoke(sdI) as Iterator<*>
		ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_level_block_Blocks)
			.getMethod("a", String::class.java, bc)
			.invoke(null, "bread_block", block)
		println("$block")
		lll.forEach {
			bsrA.invoke(bsr, it)
		}
		println(blockRegistry::class.java.declaredMethods.toList())
		MinecraftProvider.features.add(MinecraftBlockFeature1x21x1())
	}
}

// THE MAPPINGS
// https://piston-data.mojang.com/v1/objects/2244b6f072256667bcd9a73df124d6c58de77992/client.txt