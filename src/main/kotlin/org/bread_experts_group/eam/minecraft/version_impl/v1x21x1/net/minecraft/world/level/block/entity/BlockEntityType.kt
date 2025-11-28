package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimicClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.BlockPos
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.Block
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.BlockState
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_level_block_entity_BlockEntityType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_level_block_entity_BlockEntityType_BlockEntitySupplier
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_level_block_entity_BlockEntityType_Builder
import java.lang.classfile.ClassFile.ACC_FINAL
import java.lang.classfile.ClassFile.ACC_PRIVATE
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

/*
net.minecraft.world.level.block.entity.BlockEntityType -> dqj:
# {"fileName":"BlockEntityType.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> S
    net.minecraft.world.level.block.entity.BlockEntityType FURNACE -> a
    net.minecraft.world.level.block.entity.BlockEntityType CHEST -> b
    net.minecraft.world.level.block.entity.BlockEntityType TRAPPED_CHEST -> c
    net.minecraft.world.level.block.entity.BlockEntityType ENDER_CHEST -> d
    net.minecraft.world.level.block.entity.BlockEntityType JUKEBOX -> e
    net.minecraft.world.level.block.entity.BlockEntityType DISPENSER -> f
    net.minecraft.world.level.block.entity.BlockEntityType DROPPER -> g
    net.minecraft.world.level.block.entity.BlockEntityType SIGN -> h
    net.minecraft.world.level.block.entity.BlockEntityType HANGING_SIGN -> i
    net.minecraft.world.level.block.entity.BlockEntityType MOB_SPAWNER -> j
    net.minecraft.world.level.block.entity.BlockEntityType PISTON -> k
    net.minecraft.world.level.block.entity.BlockEntityType BREWING_STAND -> l
    net.minecraft.world.level.block.entity.BlockEntityType ENCHANTING_TABLE -> m
    net.minecraft.world.level.block.entity.BlockEntityType END_PORTAL -> n
    net.minecraft.world.level.block.entity.BlockEntityType BEACON -> o
    net.minecraft.world.level.block.entity.BlockEntityType SKULL -> p
    net.minecraft.world.level.block.entity.BlockEntityType DAYLIGHT_DETECTOR -> q
    net.minecraft.world.level.block.entity.BlockEntityType HOPPER -> r
    net.minecraft.world.level.block.entity.BlockEntityType COMPARATOR -> s
    net.minecraft.world.level.block.entity.BlockEntityType BANNER -> t
    net.minecraft.world.level.block.entity.BlockEntityType STRUCTURE_BLOCK -> u
    net.minecraft.world.level.block.entity.BlockEntityType END_GATEWAY -> v
    net.minecraft.world.level.block.entity.BlockEntityType COMMAND_BLOCK -> w
    net.minecraft.world.level.block.entity.BlockEntityType SHULKER_BOX -> x
    net.minecraft.world.level.block.entity.BlockEntityType BED -> y
    net.minecraft.world.level.block.entity.BlockEntityType CONDUIT -> z
    net.minecraft.world.level.block.entity.BlockEntityType BARREL -> A
    net.minecraft.world.level.block.entity.BlockEntityType SMOKER -> B
    net.minecraft.world.level.block.entity.BlockEntityType BLAST_FURNACE -> C
    net.minecraft.world.level.block.entity.BlockEntityType LECTERN -> D
    net.minecraft.world.level.block.entity.BlockEntityType BELL -> E
    net.minecraft.world.level.block.entity.BlockEntityType JIGSAW -> F
    net.minecraft.world.level.block.entity.BlockEntityType CAMPFIRE -> G
    net.minecraft.world.level.block.entity.BlockEntityType BEEHIVE -> H
    net.minecraft.world.level.block.entity.BlockEntityType SCULK_SENSOR -> I
    net.minecraft.world.level.block.entity.BlockEntityType CALIBRATED_SCULK_SENSOR -> J
    net.minecraft.world.level.block.entity.BlockEntityType SCULK_CATALYST -> K
    net.minecraft.world.level.block.entity.BlockEntityType SCULK_SHRIEKER -> L
    net.minecraft.world.level.block.entity.BlockEntityType CHISELED_BOOKSHELF -> M
    net.minecraft.world.level.block.entity.BlockEntityType BRUSHABLE_BLOCK -> N
    net.minecraft.world.level.block.entity.BlockEntityType DECORATED_POT -> O
    net.minecraft.world.level.block.entity.BlockEntityType CRAFTER -> P
    net.minecraft.world.level.block.entity.BlockEntityType TRIAL_SPAWNER -> Q
    net.minecraft.world.level.block.entity.BlockEntityType VAULT -> R
    net.minecraft.world.level.block.entity.BlockEntityType$BlockEntitySupplier factory -> T
    java.util.Set validBlocks -> U
    com.mojang.datafixers.types.Type dataType -> V
    net.minecraft.core.Holder$Reference builtInRegistryHolder -> W
    29:29:net.minecraft.resources.ResourceLocation getKey(net.minecraft.world.level.block.entity.BlockEntityType) -> a
    78:82:net.minecraft.world.level.block.entity.BlockEntityType register(java.lang.String,net.minecraft.world.level.block.entity.BlockEntityType$Builder) -> a
    89:95:void <init>(net.minecraft.world.level.block.entity.BlockEntityType$BlockEntitySupplier,java.util.Set,com.mojang.datafixers.types.Type) -> <init>
    99:99:net.minecraft.world.level.block.entity.BlockEntity create(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    106:106:boolean isValid(net.minecraft.world.level.block.state.BlockState) -> a
    111:111:net.minecraft.core.Holder$Reference builtInRegistryHolder() -> a
    140:144:net.minecraft.world.level.block.entity.BlockEntity getBlockEntity(net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> a
    25:75:void <clinit>() -> <clinit>
 */
class BlockEntityType<T : BlockEntity>(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_level_block_entity_BlockEntityType)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockEntityType::class.classDesc

		fun <T : BlockEntity> register(name: String, builder: Builder<T>): BlockEntityType<T> =
			BlockEntityType(clazz.getMethod("a", String::class.java, Builder.clazz)
				.invoke(null, name, builder.around)
			)
	}

	val validBlocks: Set<Block>
		get() {
			val set = clazz.getField("U").get(around) as Set<*>
			return set.map { Block(it!!) }.toSet()
		}

	/*
	net.minecraft.world.level.block.entity.BlockEntityType$BlockEntitySupplier -> dqj$a:
# {"fileName":"BlockEntityType.java","id":"sourceFile"}
	net.minecraft.world.level.block.entity.BlockEntity create(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> create
	 */
	abstract class BlockEntitySupplier<T : BlockEntity> : MimickedClass(0) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_world_level_block_entity_BlockEntityType_BlockEntitySupplier)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = BlockEntitySupplier::class.classDesc

			fun <T : BlockEntity> implementNative(supplier: (BlockPos, BlockState) -> T): Any {
				val entitySupplier = object : BlockEntitySupplier<T>() {
					override fun create(pos: BlockPos, state: BlockState): T = supplier(pos, state)
				}

				return entitySupplier.implementNative(BlockEntitySupplier::class.java, true) { classBuilder, name ->
					classBuilder.withInterfaceSymbols(classDesc)
					// todo figure out signatures
//					classBuilder.with(SignatureAttribute.of { "<T:Ldqh;>Ljava/lang/Object;" })
					classBuilder.withMethodBody(
						"create",
						MethodTypeDesc.of(
							BlockEntity.classDesc,
							BlockPos.classDesc,
							BlockState.classDesc
						),
						ACC_PUBLIC
					) { codeBuilder ->
//						val staringPackage = "Lorg/bread_experts_group/eam/minecraft/version_impl/v1x21x1/net/minecraft"
//						val blockPos = "$staringPackage/core/BlockPos;"
//						val blockState = "$staringPackage/world/level/block/state/BlockState;"
						codeBuilder
							.getReferenceField(name, mimicClassDesc)
							.invokeSpecialNewMimicClass(BlockPos.mimicClassDesc, 1)
							.invokeSpecialNewMimicClass(BlockState.mimicClassDesc, 2)
							.invokevirtual(
								mimicClassDesc,
								"create",
								MethodTypeDesc.of(
									BlockEntity.mimicClassDesc,
									BlockPos.mimicClassDesc,
									BlockState.mimicClassDesc
								)
							)
							.getfield(
								BlockEntity.mimicClassDesc,
								"around",
								ConstantDescs.CD_Object
							)
							.checkcast(BlockEntity.classDesc)
							.areturn()
					}
					classBuilder.withMethodBody(
						"<init>",
						MethodTypeDesc.of(
							ConstantDescs.CD_void, mimicClassDesc
						),
						ACC_PUBLIC
					) { codeBuilder ->
						codeBuilder
							.aload(0)
							.dup()
							.invokespecial(
								ConstantDescs.CD_Object,
								"<init>",
								MethodTypeDesc.of(ConstantDescs.CD_void)
							)
							.aload(1)
							.putfield(
								ClassDesc.of(name),
								"reference",
								mimicClassDesc
							)
							.return_()
					}
						classBuilder.withField(
							"reference",
							mimicClassDesc,
							ACC_FINAL or ACC_PRIVATE
						)
				}.newInstance(entitySupplier)
			}
		}

		abstract fun create(pos: BlockPos, state: BlockState): T
	}

	/*
	net.minecraft.world.level.block.entity.BlockEntityType$Builder -> dqj$b:
# {"fileName":"BlockEntityType.java","id":"sourceFile"}
    net.minecraft.world.level.block.entity.BlockEntityType$BlockEntitySupplier factory -> a
    java.util.Set validBlocks -> b
    123:126:void <init>(net.minecraft.world.level.block.entity.BlockEntityType$BlockEntitySupplier,java.util.Set) -> <init>
    129:129:net.minecraft.world.level.block.entity.BlockEntityType$Builder of(net.minecraft.world.level.block.entity.BlockEntityType$BlockEntitySupplier,net.minecraft.world.level.block.Block[]) -> a
    133:133:net.minecraft.world.level.block.entity.BlockEntityType build(com.mojang.datafixers.types.Type) -> a
	 */
	class Builder<T : BlockEntity>(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_world_level_block_entity_BlockEntityType_Builder)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = Builder::class.classDesc

			// todo the supplier parameter is Any because of the implementNative method in BlockEntitySupplier
			fun <T : BlockEntity> of(supplier: Any, vararg blocks: Block): Builder<T> {
				val array = java.lang.reflect.Array.newInstance(Block.clazz, blocks.size)
				repeat(blocks.size) {
					println("BLOCKS FROM BUILDER: ${blocks[it].around}")
					java.lang.reflect.Array.set(array, it, blocks[it].around)
				}
				return Builder(
					clazz.getMethod("a", BlockEntitySupplier.clazz, Block.clazz.arrayType())
						.invoke(null, supplier, array)
				)
			}
		}

		fun build(): BlockEntityType<T> = BlockEntityType(
			clazz.getMethod("a", loadClass("com.mojang.datafixers.types.Type"))
				.invoke(around, null)
		)
	}
}