package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.BlockPos
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.Level
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.state.BlockState
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_level_block_entity_BlockEntity
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

/*
net.minecraft.world.level.block.entity.BlockEntity -> dqh:
# {"fileName":"BlockEntity.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> d
    net.minecraft.world.level.block.entity.BlockEntityType type -> e
    net.minecraft.world.level.Level level -> n
    net.minecraft.core.BlockPos worldPosition -> o
    boolean remove -> p
    net.minecraft.world.level.block.state.BlockState blockState -> f
    net.minecraft.core.component.DataComponentMap components -> g
    46:53:void <init>(net.minecraft.world.level.block.entity.BlockEntityType,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> <init>
    56:59:void validateBlockState(net.minecraft.world.level.block.state.BlockState) -> a
    62:62:boolean isValidBlockState(net.minecraft.world.level.block.state.BlockState) -> b
    66:66:net.minecraft.core.BlockPos getPosFromTag(net.minecraft.nbt.CompoundTag) -> b
    71:71:net.minecraft.world.level.Level getLevel() -> i
    75:76:void setLevel(net.minecraft.world.level.Level) -> a
    79:79:boolean hasLevel() -> m
    83:83:void loadAdditional(net.minecraft.nbt.CompoundTag,net.minecraft.core.HolderLookup$Provider) -> a
    86:91:void loadWithComponents(net.minecraft.nbt.CompoundTag,net.minecraft.core.HolderLookup$Provider) -> c
    94:95:void loadCustomOnly(net.minecraft.nbt.CompoundTag,net.minecraft.core.HolderLookup$Provider) -> d
    98:98:void saveAdditional(net.minecraft.nbt.CompoundTag,net.minecraft.core.HolderLookup$Provider) -> b
    105:107:net.minecraft.nbt.CompoundTag saveWithFullMetadata(net.minecraft.core.HolderLookup$Provider) -> b
    115:117:net.minecraft.nbt.CompoundTag saveWithId(net.minecraft.core.HolderLookup$Provider) -> c
    124:131:net.minecraft.nbt.CompoundTag saveWithoutMetadata(net.minecraft.core.HolderLookup$Provider) -> d
    135:137:net.minecraft.nbt.CompoundTag saveCustomOnly(net.minecraft.core.HolderLookup$Provider) -> e
    141:143:net.minecraft.nbt.CompoundTag saveCustomAndMetadata(net.minecraft.core.HolderLookup$Provider) -> f
    147:152:void saveId(net.minecraft.nbt.CompoundTag) -> c
    155:156:void addEntityType(net.minecraft.nbt.CompoundTag,net.minecraft.world.level.block.entity.BlockEntityType) -> a
    160:164:void saveToItem(net.minecraft.world.item.ItemStack,net.minecraft.core.HolderLookup$Provider) -> a
    167:171:void saveMetadata(net.minecraft.nbt.CompoundTag) -> d
    175:201:net.minecraft.world.level.block.entity.BlockEntity loadStatic(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.nbt.CompoundTag,net.minecraft.core.HolderLookup$Provider) -> a
    208:211:void setChanged() -> e
    214:219:void setChanged(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    226:226:net.minecraft.world.level.block.state.BlockState getBlockState() -> n
    231:231:net.minecraft.network.protocol.Packet getUpdatePacket() -> az_
    235:235:net.minecraft.nbt.CompoundTag getUpdateTag(net.minecraft.core.HolderLookup$Provider) -> a
    239:239:boolean isRemoved() -> o
    243:244:void setRemoved() -> aA_
    247:248:void clearRemoved() -> p
    251:251:boolean triggerEvent(int,int) -> a_
    255:264:void fillCrashReportCategory(net.minecraft.CrashReportCategory) -> a
    267:267:java.lang.String getNameForReporting() -> k
    271:271:boolean onlyOpCanSetNbt() -> q
    275:275:net.minecraft.world.level.block.entity.BlockEntityType getType() -> r
    283:285:void setBlockState(net.minecraft.world.level.block.state.BlockState) -> c
    295:295:void applyImplicitComponents(net.minecraft.world.level.block.entity.BlockEntity$DataComponentInput) -> a
    298:299:void applyComponentsFromItemStack(net.minecraft.world.item.ItemStack) -> a
    302:328:void applyComponents(net.minecraft.core.component.DataComponentMap,net.minecraft.core.component.DataComponentPatch) -> a
    331:331:void collectImplicitComponents(net.minecraft.core.component.DataComponentMap$Builder) -> a
    337:337:void removeComponentsFromTag(net.minecraft.nbt.CompoundTag) -> a
    340:343:net.minecraft.core.component.DataComponentMap collectComponents() -> s
    347:347:net.minecraft.core.component.DataComponentMap components() -> t
    351:352:void setComponents(net.minecraft.core.component.DataComponentMap) -> a
    357:360:net.minecraft.network.chat.Component parseCustomNameSafe(java.lang.String,net.minecraft.core.HolderLookup$Provider) -> a
    202:203:net.minecraft.world.level.block.entity.BlockEntity lambda$loadStatic$6(java.lang.String) -> a
    194:198:net.minecraft.world.level.block.entity.BlockEntity lambda$loadStatic$5(net.minecraft.nbt.CompoundTag,net.minecraft.core.HolderLookup$Provider,java.lang.String,net.minecraft.world.level.block.entity.BlockEntity) -> a
    186:189:net.minecraft.world.level.block.entity.BlockEntity lambda$loadStatic$4(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,java.lang.String,net.minecraft.world.level.block.entity.BlockEntityType) -> a
    129:129:void lambda$saveWithoutMetadata$3(net.minecraft.nbt.CompoundTag,net.minecraft.nbt.Tag) -> a
    128:128:void lambda$saveWithoutMetadata$2(java.lang.String) -> b
    90:90:void lambda$loadWithComponents$1(net.minecraft.core.component.DataComponentMap) -> b
    89:89:void lambda$loadWithComponents$0(java.lang.String) -> c
    36:36:void <clinit>() -> <clinit>
 */
open class BlockEntity(type: BlockEntityType, pos: BlockPos, state: BlockState, initAround: Boolean = true) : MimickedClass(0) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_level_block_entity_BlockEntity)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockEntity::class.classDesc
	}

	constructor(around: Any) : this(BlockEntityType(0), BlockPos(0), BlockState(0), false) {
		this.around = around
	}

	init {
		if (initAround) this.around = createNative(BlockEntity::class.java) { classBuilder, _ ->
			classBuilder.withSuperclass(classDesc)
			classBuilder.withMethodBody(
				"<init>",
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					BlockEntityType.classDesc,
					BlockPos.classDesc,
					BlockState.classDesc
				),
				ACC_PUBLIC
			) { codeBuilder ->
				codeBuilder
					.aload(0)
					.aload(1)
					.aload(2)
					.aload(3)
					.invokespecial(
						classDesc,
						"<init>",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							BlockEntityType.classDesc,
							BlockPos.classDesc,
							BlockState.classDesc
						)
					)
					.return_()
			}

		}.newInstance(type.around, pos.around, state.around)
	}

	fun getLevel(): Level? = clazz.getMethod("i").invoke(around)?.let { Level(it) }

	private var pos: BlockPos? = null
	fun getBlockPos(): BlockPos {
		if (pos == null) {
			pos = BlockPos(clazz.getMethod("aD_").invoke(around))
			return pos!!
		}
		return pos!!
	}

//	constructor(type: BlockEntityType<*>, pos: BlockPos, state: BlockState) : this(
//		clazz.getConstructor(BlockEntityType.clazz, BlockPos.clazz, BlockState.clazz)
//			.newInstance(type.around, pos.around, state.around)
//	)
}