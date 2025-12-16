package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_world_entity_Display_BlockDisplay
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.Level
import java.lang.constant.ClassDesc

open class Display(around: Any) : Entity(around) {

	/*
	net.minecraft.world.entity.Display$BlockDisplay -> bsq$b:
    java.lang.String TAG_BLOCK_STATE -> p
    net.minecraft.network.syncher.EntityDataAccessor DATA_BLOCK_STATE_ID -> q
    net.minecraft.world.entity.Display$BlockDisplay$BlockRenderState blockRenderState -> r
    684:686:void defineSynchedData(net.minecraft.network.syncher.SynchedEntityData$Builder) -> a
    690:695:void onSyncedDataUpdated(net.minecraft.network.syncher.EntityDataAccessor) -> a
    698:698:net.minecraft.world.level.block.state.BlockState getBlockState() -> t
    702:703:void setBlockState(net.minecraft.world.level.block.state.BlockState) -> c
    707:709:void readAdditionalSaveData(net.minecraft.nbt.CompoundTag) -> a
    713:715:void addAdditionalSaveData(net.minecraft.nbt.CompoundTag) -> b
    719:719:net.minecraft.world.entity.Display$BlockDisplay$BlockRenderState blockRenderState() -> s
    724:725:void updateRenderSubState(boolean,float) -> a
    673:673:void <clinit>() -> <clinit>
	 */
	class BlockDisplay(around: Any) : Display(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_world_entity_Display_BlockDisplay)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = BlockDisplay::class.classDesc
		}
		constructor(entityType: EntityType, level: Level) : this(
			clazz.getConstructor(EntityType.clazz, Level.clazz)
				.newInstance(entityType.around, level.around)
		)
	}
}