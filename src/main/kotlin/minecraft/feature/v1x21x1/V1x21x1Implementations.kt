package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.eam.minecraft.MinecraftProvider
import org.bread_experts_group.eam.minecraft.feature.nameObfuscatedField
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_STATIC
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain

const val java_Void: String = "()V"

const val net_minecraft_server_Bootstrap: String = "akt"
const val net_minecraft_core_registries_BuiltInRegistries: String = "lt"
const val net_minecraft_core_registries_BuiltInRegistries_createContents: String = "b"

const val net_minecraft_world_level_block_Block: String = "dfy"
const val net_minecraft_world_level_block_Block_getStateDefinition: String = "l"
const val net_minecraft_world_level_block_Block_BLOCK_STATE_REGISTRY_add: String = "b" // Method(BlockState)

const val net_minecraft_world_level_block_state_BlockBehaviour: String = "dtb"
const val net_minecraft_world_level_block_state_BlockBehaviour_Properties: String = $$"dtb$d"
const val net_minecraft_world_level_block_state_BlockBehaviour_Properties_of: String = "a"
const val net_minecraft_world_level_block_state_StateDefinition_getPossibleStates: String = "a"
const val net_minecraft_core_MappedRegistry: String = "ju"
const val net_minecraft_core_Registry: String = "jz"

const val net_minecraft_world_level_block_Blocks: String = "dga" // Class
const val net_minecraft_world_level_block_Blocks_add: String = "a" // Method(String, Block)

const val net_minecraft_world_item_Item: String = "cul"
const val net_minecraft_world_item_BlockItem: String = "cso"
const val net_minecraft_world_item_Item_Properties: String = $$"cul$a"

object V1x21x1Implementations {
	private val classFile: ClassFile = ClassFile.of()

	lateinit var instrumentation: Instrumentation
	lateinit var scanning: MutableMap<String, (ClassLoader?, Class<*>?, ProtectionDomain, ByteArray) -> ByteArray?>

	fun preBootstrap() {
		scanning[net_minecraft_core_registries_BuiltInRegistries] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				classBuilder.nameObfuscatedField(classElement, model, "e", "BLOCK", ACC_STATIC or ACC_PUBLIC)
				classBuilder.nameObfuscatedField(classElement, model, "g", "ITEM", ACC_STATIC or ACC_PUBLIC)
				try {
					if (
						classElement is MethodModel &&
						classElement.methodName().equalsString(net_minecraft_core_registries_BuiltInRegistries_createContents) &&
						classElement.methodType().equalsString(java_Void)
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
		scanning[net_minecraft_world_level_block_Block] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				classBuilder.with(classElement).nameObfuscatedField(classElement, model, "q", "BLOCK_STATE_REGISTRY", ACC_STATIC or ACC_PUBLIC)
			}
		}
		scanning[net_minecraft_world_level_block_Blocks] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				classBuilder.with(classElement).nameObfuscatedField(classElement, model, "ij", "HAY_BLOCK", ACC_STATIC or ACC_PUBLIC)
			}
		}
	}

	@JvmStatic
	@Suppress("unused")
	fun afterCreateContents() {
		println("AFTER_CREATE_CONTENTS")
		val blockRegistry = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_core_registries_BuiltInRegistries)
			.getMethod("BLOCK")
			.invoke(null)
		println(blockRegistry)
		val bsp = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_level_block_state_BlockBehaviour_Properties)
		val bb = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_level_block_state_BlockBehaviour)
//		val properties = bsp
//			.getMethod(net_minecraft_world_level_block_state_BlockBehaviour_Properties_of)
//			.invoke(null)
		val blocks = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_level_block_Blocks)
		val hayBlock = blocks.getMethod("HAY_BLOCK").invoke(null)
		val properties = bsp.getDeclaredMethod("a", bb).invoke(null, hayBlock)
		println("$properties")
		val bc = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_level_block_Block)
		val block = bc
			.getConstructor(bsp)
			.newInstance(properties)
		println("$block")
		val bsr = bc.getMethod("BLOCK_STATE_REGISTRY").invoke(null)
		val bsrA = bsr::class.java.getDeclaredMethod(net_minecraft_world_level_block_Block_BLOCK_STATE_REGISTRY_add, Object::class.java)
		val s = bc.getDeclaredMethod(net_minecraft_world_level_block_Block_getStateDefinition).invoke(block)
		val sdI = s::class.java.getDeclaredMethod(net_minecraft_world_level_block_state_StateDefinition_getPossibleStates).invoke(s)
		println("$bsr, $bsrA, $s, $sdI")
		val lll = sdI::class.java.getMethod("iterator").also { it.isAccessible = true }.invoke(sdI) as Iterator<*>
		blocks
			.getMethod(net_minecraft_world_level_block_Blocks_add, String::class.java, bc)
			.invoke(null, "breadmod:bread_block", block)
		println("$block")
		lll.forEach {
			bsrA.invoke(bsr, it)
		}
		println(blockRegistry::class.java.declaredMethods.toList())

		val itemRegistry = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_core_registries_BuiltInRegistries)
			.getMethod("ITEM")
			.invoke(null)
		println(itemRegistry)
		val ip = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_item_Item_Properties)
		var iProp = ip.getConstructor().newInstance()
		iProp = iProp::class.java.getDeclaredMethod("a", Int::class.java).invoke(iProp, 32)

		val food = ClassLoader.getSystemClassLoader().loadClass("cpr")
		val builder = ClassLoader.getSystemClassLoader().loadClass($$"cpr$a")
		val foodBuilder = builder.getConstructor().newInstance()
		val nutrition = builder.getDeclaredMethod("a", Int::class.java).invoke(foodBuilder, 20)
		val builtFood = nutrition::class.java.getMethod("c").invoke(foodBuilder)
		iProp = iProp::class.java.getDeclaredMethod("a", food).invoke(iProp, builtFood)

		val bi = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_item_BlockItem)
		val blockItem = bi
			.getConstructor(bc, ip)
			.newInstance(block, iProp)
		println(blockItem)
		ClassLoader.getSystemClassLoader().loadClass("cut")
			.getDeclaredMethod("a", bi)
			.invoke(null, blockItem)

		MinecraftProvider.features.add(MinecraftBlockFeature1x21x1())
	}
}

// THE MAPPINGS
// https://piston-data.mojang.com/v1/objects/2244b6f072256667bcd9a73df124d6c58de77992/client.txt