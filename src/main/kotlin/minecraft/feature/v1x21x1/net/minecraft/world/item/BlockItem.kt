package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item

import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.Block
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_BlockItem
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_Item

/*
    net.minecraft.world.level.block.Block block -> a
    40:42:void <init>(net.minecraft.world.level.block.Block,net.minecraft.world.item.Item$Properties) -> <init>
    46:54:net.minecraft.world.InteractionResult useOn(net.minecraft.world.item.context.UseOnContext) -> a
    58:100:net.minecraft.world.InteractionResult place(net.minecraft.world.item.context.BlockPlaceContext) -> a
    104:104:net.minecraft.sounds.SoundEvent getPlaceSound(net.minecraft.world.level.block.state.BlockState) -> a
    109:109:net.minecraft.world.item.context.BlockPlaceContext updatePlacementContext(net.minecraft.world.item.context.BlockPlaceContext) -> b
    113:118:void updateBlockEntityComponents(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.item.ItemStack) -> a
    121:121:boolean updateCustomBlockEntityTag(net.minecraft.core.BlockPos,net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,net.minecraft.world.item.ItemStack,net.minecraft.world.level.block.state.BlockState) -> a
    126:127:net.minecraft.world.level.block.state.BlockState getPlacementState(net.minecraft.world.item.context.BlockPlaceContext) -> c
    131:139:net.minecraft.world.level.block.state.BlockState updateBlockStateFromTag(net.minecraft.core.BlockPos,net.minecraft.world.level.Level,net.minecraft.world.item.ItemStack,net.minecraft.world.level.block.state.BlockState) -> a
    143:145:boolean canPlace(net.minecraft.world.item.context.BlockPlaceContext,net.minecraft.world.level.block.state.BlockState) -> b
    149:149:boolean mustSurvive() -> c
    153:153:boolean placeBlock(net.minecraft.world.item.context.BlockPlaceContext,net.minecraft.world.level.block.state.BlockState) -> a
    158:174:boolean updateCustomBlockEntityTag(net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,net.minecraft.core.BlockPos,net.minecraft.world.item.ItemStack) -> a
    179:179:java.lang.String getDescriptionId() -> a
    184:186:void appendHoverText(net.minecraft.world.item.ItemStack,net.minecraft.world.item.Item$TooltipContext,java.util.List,net.minecraft.world.item.TooltipFlag) -> a
    189:189:net.minecraft.world.level.block.Block getBlock() -> d
    193:194:void registerBlocks(java.util.Map,net.minecraft.world.item.Item) -> a
    199:199:boolean canFitInsideContainerItems() -> ar_
    204:208:void onDestroyed(net.minecraft.world.entity.item.ItemEntity) -> a
    211:218:void setBlockEntityData(net.minecraft.world.item.ItemStack,net.minecraft.world.level.block.entity.BlockEntityType,net.minecraft.nbt.CompoundTag) -> a
    222:222:net.minecraft.world.flag.FeatureFlagSet requiredFeatures() -> i
 */
class BlockItem(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = ClassLoader.getSystemClassLoader().loadClass(net_minecraft_world_item_BlockItem)
	}

	constructor(block: Block, properties: Item.Properties) : this(
		clazz
			.getConstructor(Block.clazz, Item.Properties.clazz)
			.newInstance(block.around, properties.around)
	)
}