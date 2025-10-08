package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.IdMapper
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.state.BlockBehaviour
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.state.BlockState
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.state.StateDefinition
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_level_block_Block

/*
net.minecraft.world.level.block.Block -> dfy:
# {"fileName":"Block.java","id":"sourceFile"}
    com.mojang.serialization.MapCodec CODEC -> p
    org.slf4j.Logger LOGGER -> a
    net.minecraft.core.Holder$Reference builtInRegistryHolder -> b
    net.minecraft.core.IdMapper BLOCK_STATE_REGISTRY -> q
    com.google.common.cache.LoadingCache SHAPE_FULL_BLOCK_CACHE -> c
    int UPDATE_NEIGHBORS -> r
    int UPDATE_CLIENTS -> s
    int UPDATE_INVISIBLE -> t
    int UPDATE_IMMEDIATE -> u
    int UPDATE_KNOWN_SHAPE -> v
    int UPDATE_SUPPRESS_DROPS -> w
    int UPDATE_MOVE_BY_PISTON -> x
    int UPDATE_NONE -> y
    int UPDATE_ALL -> z
    int UPDATE_ALL_IMMEDIATE -> A
    float INDESTRUCTIBLE -> B
    float INSTANT -> C
    int UPDATE_LIMIT -> D
    net.minecraft.world.level.block.state.StateDefinition stateDefinition -> E
    net.minecraft.world.level.block.state.BlockState defaultBlockState -> d
    java.lang.String descriptionId -> e
    net.minecraft.world.item.Item item -> f
    int CACHE_SIZE -> g
    java.lang.ThreadLocal OCCLUSION_CACHE -> h
    115:115:com.mojang.serialization.MapCodec codec() -> a
    119:123:int getId(net.minecraft.world.level.block.state.BlockState) -> i
    127:128:net.minecraft.world.level.block.state.BlockState stateById(int) -> a
    132:136:net.minecraft.world.level.block.Block byItem(net.minecraft.world.item.Item) -> a
    140:150:net.minecraft.world.level.block.state.BlockState pushEntitiesUp(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.LevelAccessor,net.minecraft.core.BlockPos) -> a
    154:154:net.minecraft.world.phys.shapes.VoxelShape box(double,double,double,double,double,double) -> a
    158:166:net.minecraft.world.level.block.state.BlockState updateFromNeighbourShapes(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.LevelAccessor,net.minecraft.core.BlockPos) -> b
    170:171:void updateOrDestroy(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.LevelAccessor,net.minecraft.core.BlockPos,int) -> a
    174:183:void updateOrDestroy(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.LevelAccessor,net.minecraft.core.BlockPos,int,int) -> a
    81:208:void <init>(net.minecraft.world.level.block.state.BlockBehaviour$Properties) -> <init>
    211:217:boolean isExceptionForConnection(net.minecraft.world.level.block.state.BlockState) -> j
    268:294:boolean shouldRenderFace(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos,net.minecraft.core.Direction,net.minecraft.core.BlockPos) -> a
    298:298:boolean canSupportRigidBlock(net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> c
    302:308:boolean canSupportCenter(net.minecraft.world.level.LevelReader,net.minecraft.core.BlockPos,net.minecraft.core.Direction) -> a
    312:313:boolean isFaceFull(net.minecraft.world.phys.shapes.VoxelShape,net.minecraft.core.Direction) -> a
    317:317:boolean isShapeFullBlock(net.minecraft.world.phys.shapes.VoxelShape) -> a
    321:321:void animateTick(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.util.RandomSource) -> a
    325:325:void destroy(net.minecraft.world.level.LevelAccessor,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    328:332:java.util.List getDrops(net.minecraft.world.level.block.state.BlockState,net.minecraft.server.level.ServerLevel,net.minecraft.core.BlockPos,net.minecraft.world.level.block.entity.BlockEntity) -> a
    336:341:java.util.List getDrops(net.minecraft.world.level.block.state.BlockState,net.minecraft.server.level.ServerLevel,net.minecraft.core.BlockPos,net.minecraft.world.level.block.entity.BlockEntity,net.minecraft.world.entity.Entity,net.minecraft.world.item.ItemStack) -> a
    345:349:void dropResources(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos) -> c
    352:356:void dropResources(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.LevelAccessor,net.minecraft.core.BlockPos,net.minecraft.world.level.block.entity.BlockEntity) -> a
    359:363:void dropResources(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.block.entity.BlockEntity,net.minecraft.world.entity.Entity,net.minecraft.world.item.ItemStack) -> a
    366:373:void popResource(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.item.ItemStack) -> a
    376:392:void popResourceFromFace(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.core.Direction,net.minecraft.world.item.ItemStack) -> a
    395:402:void popResource(net.minecraft.world.level.Level,java.util.function.Supplier,net.minecraft.world.item.ItemStack) -> a
    405:408:void popExperience(net.minecraft.server.level.ServerLevel,net.minecraft.core.BlockPos,int) -> a
    411:411:float getExplosionResistance() -> e
    415:415:void wasExploded(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.Explosion) -> a
    418:418:void stepOn(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.entity.Entity) -> a
    432:432:net.minecraft.world.level.block.state.BlockState getStateForPlacement(net.minecraft.world.item.context.BlockPlaceContext) -> a
    437:440:void playerDestroy(net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.entity.BlockEntity,net.minecraft.world.item.ItemStack) -> a
    443:443:void setPlacedBy(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.entity.LivingEntity,net.minecraft.world.item.ItemStack) -> a
    447:447:boolean isPossibleToRespawnInThis(net.minecraft.world.level.block.state.BlockState) -> a
    451:451:net.minecraft.network.chat.MutableComponent getName() -> f
    455:458:java.lang.String getDescriptionId() -> g
    465:466:void fallOn(net.minecraft.world.level.Level,net.minecraft.world.level.block.state.BlockState,net.minecraft.core.BlockPos,net.minecraft.world.entity.Entity,float) -> a
    469:470:void updateEntityAfterFallOn(net.minecraft.world.level.BlockGetter,net.minecraft.world.entity.Entity) -> a
    474:474:net.minecraft.world.item.ItemStack getCloneItemStack(net.minecraft.world.level.LevelReader,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    478:478:float getFriction() -> h
    482:482:float getSpeedFactor() -> j
    486:486:float getJumpFactor() -> k
    490:491:void spawnDestroyParticles(net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    495:501:net.minecraft.world.level.block.state.BlockState playerWillDestroy(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.entity.player.Player) -> a
    505:505:void handlePrecipitation(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.biome.Biome$Precipitation) -> a
    508:508:boolean dropFromExplosion(net.minecraft.world.level.Explosion) -> a
    512:512:void createBlockStateDefinition(net.minecraft.world.level.block.state.StateDefinition$Builder) -> a
    515:515:net.minecraft.world.level.block.state.StateDefinition getStateDefinition() -> l
    519:520:void registerDefaultState(net.minecraft.world.level.block.state.BlockState) -> k
    523:523:net.minecraft.world.level.block.state.BlockState defaultBlockState() -> o
    527:533:net.minecraft.world.level.block.state.BlockState withPropertiesOf(net.minecraft.world.level.block.state.BlockState) -> l
    538:538:net.minecraft.world.level.block.state.BlockState copyProperty(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.properties.Property) -> a
    543:546:net.minecraft.world.item.Item asItem() -> r
    550:550:boolean hasDynamicShape() -> p
    555:555:java.lang.String toString() -> toString
    559:559:void appendHoverText(net.minecraft.world.item.ItemStack,net.minecraft.world.item.Item$TooltipContext,java.util.List,net.minecraft.world.item.TooltipFlag) -> a
    563:563:net.minecraft.world.level.block.Block asBlock() -> q
    570:570:com.google.common.collect.ImmutableMap getShapeForEachState(java.util.function.Function) -> a
    578:578:net.minecraft.core.Holder$Reference builtInRegistryHolder() -> s
    582:586:void tryDropExperience(net.minecraft.server.level.ServerLevel,net.minecraft.core.BlockPos,net.minecraft.world.item.ItemStack,net.minecraft.util.valueproviders.IntProvider) -> a
    391:391:net.minecraft.world.entity.item.ItemEntity lambda$popResourceFromFace$5(net.minecraft.world.level.Level,double,double,double,net.minecraft.world.item.ItemStack,double,double,double) -> a
    372:372:net.minecraft.world.entity.item.ItemEntity lambda$popResource$4(net.minecraft.world.level.Level,double,double,double,net.minecraft.world.item.ItemStack) -> a
    360:360:void lambda$dropResources$3(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.item.ItemStack) -> b
    353:353:void lambda$dropResources$2(net.minecraft.world.level.LevelAccessor,net.minecraft.core.BlockPos,net.minecraft.world.item.ItemStack) -> a
    346:346:void lambda$dropResources$1(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.item.ItemStack) -> c
    255:261:it.unimi.dsi.fastutil.objects.Object2ByteLinkedOpenHashMap lambda$static$0() -> y
    77:254:void <clinit>() -> <clinit>
 */
class Block(around: Any) : BlockBehaviour(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_world_level_block_Block)
		val BLOCK_STATE_REGISTRY: IdMapper<BlockState>
			get() = IdMapper(clazz.getField("q").get(null))
	}

	constructor(properties: Properties) : this(
		clazz.getConstructor(Properties.clazz).newInstance(properties.around)
	)

	fun getStateDefinition(): StateDefinition {
		return StateDefinition(clazz.getMethod("l").invoke(around))
	}
}