package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.eam.minecraft.MinecraftProvider
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.food.FoodProperties
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.BlockItem
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.Item
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.Items
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.Block
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.Blocks
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.state.BlockBehaviour
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain

const val net_minecraft_world_level_block_Block_getStateDefinition: String = "l"
const val net_minecraft_world_level_block_Block_BLOCK_STATE_REGISTRY_add: String = "b" // Method(BlockState)

const val net_minecraft_world_level_block_state_StateDefinition_getPossibleStates: String = "a"

const val net_minecraft_world_level_block_Blocks_add: String = "a" // Method(String, Block)

object V1x21x1Implementations {
	private val classFile: ClassFile = ClassFile.of()

	lateinit var instrumentation: Instrumentation
	lateinit var scanning: MutableMap<String, (ClassLoader?, Class<*>?, ProtectionDomain, ByteArray) -> ByteArray?>

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
		val properties = BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)
		val block = Block(properties)
		Blocks.register("breadmod:bread_block", block)
		block.getStateDefinition().getPossibleStates().forEach {
			Block.BLOCK_STATE_REGISTRY.add(it)
		}
		val itemProperties = Item.Properties()
			.stacksTo(32)
			.food(
				FoodProperties.Builder()
					.nutrition(20)
					.build()
			)
		val blockItem = BlockItem(
			block,
			itemProperties
		)
		Items.registerBlock(blockItem)
	}
}