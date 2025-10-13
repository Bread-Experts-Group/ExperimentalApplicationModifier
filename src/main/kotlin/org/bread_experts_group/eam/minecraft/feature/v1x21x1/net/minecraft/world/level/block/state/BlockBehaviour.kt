package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.state

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_level_block_state_BlockBehaviour
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_level_block_state_BlockBehaviour_Properties
import java.util.function.ToIntFunction

/*
    net.minecraft.core.Direction[] UPDATE_SHAPE_ORDER -> aF
    boolean hasCollision -> aG
    float explosionResistance -> aH
    boolean isRandomlyTicking -> aI
    net.minecraft.world.level.block.SoundType soundType -> aJ
    float friction -> aK
    float speedFactor -> aL
    float jumpFactor -> aM
    boolean dynamicShape -> aN
    net.minecraft.world.flag.FeatureFlagSet requiredFeatures -> aO
    net.minecraft.world.level.block.state.BlockBehaviour$Properties properties -> aP
    net.minecraft.resources.ResourceKey drops -> aQ
    104:116:void <init>(net.minecraft.world.level.block.state.BlockBehaviour$Properties) -> <init>
    119:119:net.minecraft.world.level.block.state.BlockBehaviour$Properties properties() -> t
    com.mojang.serialization.MapCodec codec() -> a
    131:131:com.mojang.serialization.codecs.RecordCodecBuilder propertiesCodec() -> u
    135:135:com.mojang.serialization.MapCodec simpleCodec(java.util.function.Function) -> b
    141:141:void updateIndirectNeighbourShapes(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.LevelAccessor,net.minecraft.core.BlockPos,int,int) -> a
    145:153:boolean isPathfindable(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.pathfinder.PathComputationType) -> a
    163:163:net.minecraft.world.level.block.state.BlockState updateShape(net.minecraft.world.level.block.state.BlockState,net.minecraft.core.Direction,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.LevelAccessor,net.minecraft.core.BlockPos,net.minecraft.core.BlockPos) -> a
    167:167:boolean skipRendering(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState,net.minecraft.core.Direction) -> a
    174:175:void neighborChanged(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.block.Block,net.minecraft.core.BlockPos,boolean) -> a
    178:178:void onPlace(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,boolean) -> b
    181:184:void onRemove(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,boolean) -> a
    187:212:void onExplosionHit(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.level.Explosion,java.util.function.BiConsumer) -> a
    219:219:net.minecraft.world.InteractionResult useWithoutItem(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.entity.player.Player,net.minecraft.world.phys.BlockHitResult) -> a
    226:226:net.minecraft.world.ItemInteractionResult useItemOn(net.minecraft.world.item.ItemStack,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.entity.player.Player,net.minecraft.world.InteractionHand,net.minecraft.world.phys.BlockHitResult) -> a
    230:230:boolean triggerEvent(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,int,int) -> a
    236:236:net.minecraft.world.level.block.RenderShape getRenderShape(net.minecraft.world.level.block.state.BlockState) -> a_
    240:240:boolean useShapeForLightOcclusion(net.minecraft.world.level.block.state.BlockState) -> f_
    244:244:boolean isSignalSource(net.minecraft.world.level.block.state.BlockState) -> e_
    248:248:net.minecraft.world.level.material.FluidState getFluidState(net.minecraft.world.level.block.state.BlockState) -> b_
    252:252:boolean hasAnalogOutputSignal(net.minecraft.world.level.block.state.BlockState) -> c_
    256:256:float getMaxHorizontalOffset() -> av_
    260:260:float getMaxVerticalOffset() -> ax_
    265:265:net.minecraft.world.flag.FeatureFlagSet requiredFeatures() -> i
    271:271:net.minecraft.world.level.block.state.BlockState rotate(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.Rotation) -> a
    275:275:net.minecraft.world.level.block.state.BlockState mirror(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.Mirror) -> a
    287:287:boolean canBeReplaced(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.item.context.BlockPlaceContext) -> a
    291:291:boolean canBeReplaced(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.material.Fluid) -> a
    295:302:java.util.List getDrops(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.storage.loot.LootParams$Builder) -> a
    307:307:long getSeed(net.minecraft.world.level.block.state.BlockState,net.minecraft.core.BlockPos) -> a
    313:313:net.minecraft.world.phys.shapes.VoxelShape getOcclusionShape(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> f
    317:317:net.minecraft.world.phys.shapes.VoxelShape getBlockSupportShape(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> b_
    321:321:net.minecraft.world.phys.shapes.VoxelShape getInteractionShape(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> a
    325:328:int getLightBlock(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> g
    333:333:net.minecraft.world.MenuProvider getMenuProvider(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos) -> b
    337:337:boolean canSurvive(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.LevelReader,net.minecraft.core.BlockPos) -> a
    341:341:float getShadeBrightness(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> d
    345:345:int getAnalogOutputSignal(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos) -> a
    351:351:net.minecraft.world.phys.shapes.VoxelShape getShape(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos,net.minecraft.world.phys.shapes.CollisionContext) -> a
    355:355:net.minecraft.world.phys.shapes.VoxelShape getCollisionShape(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos,net.minecraft.world.phys.shapes.CollisionContext) -> b
    359:359:boolean isCollisionShapeFullBlock(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> c
    363:363:boolean isOcclusionShapeFullBlock(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> h
    367:367:net.minecraft.world.phys.shapes.VoxelShape getVisualShape(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos,net.minecraft.world.phys.shapes.CollisionContext) -> c
    371:371:void randomTick(net.minecraft.world.level.block.state.BlockState,net.minecraft.server.level.ServerLevel,net.minecraft.core.BlockPos,net.minecraft.util.RandomSource) -> b
    374:374:void tick(net.minecraft.world.level.block.state.BlockState,net.minecraft.server.level.ServerLevel,net.minecraft.core.BlockPos,net.minecraft.util.RandomSource) -> a
    377:382:float getDestroyProgress(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.entity.player.Player,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> a
    386:386:void spawnAfterBreak(net.minecraft.world.level.block.state.BlockState,net.minecraft.server.level.ServerLevel,net.minecraft.core.BlockPos,net.minecraft.world.item.ItemStack,boolean) -> a
    389:389:void attack(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.entity.player.Player) -> a_
    392:392:int getSignal(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos,net.minecraft.core.Direction) -> a
    400:400:void entityInside(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.entity.Entity) -> a
    403:403:int getDirectSignal(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos,net.minecraft.core.Direction) -> b
    407:412:net.minecraft.resources.ResourceKey getLootTable() -> v
    416:416:void onProjectileHit(net.minecraft.world.level.Level,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.phys.BlockHitResult,net.minecraft.world.entity.projectile.Projectile) -> a
    419:419:boolean propagatesSkylightDown(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> a_
    423:423:boolean isRandomlyTicking(net.minecraft.world.level.block.state.BlockState) -> d_
    427:427:net.minecraft.world.level.block.SoundType getSoundType(net.minecraft.world.level.block.state.BlockState) -> g_
    net.minecraft.world.item.Item asItem() -> r
    net.minecraft.world.level.block.Block asBlock() -> q
    441:441:net.minecraft.world.level.material.MapColor defaultMapColor() -> w
    445:445:float defaultDestroyTime() -> x
    207:207:void lambda$onExplosionHit$1(java.util.function.BiConsumer,net.minecraft.core.BlockPos,net.minecraft.world.item.ItemStack) -> a
    135:135:com.mojang.datafixers.kinds.App lambda$simpleCodec$0(java.util.function.Function,com.mojang.serialization.codecs.RecordCodecBuilder$Instance) -> a
    88:88:void <clinit>() -> <clinit>
 */
abstract class BlockBehaviour(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_world_level_block_state_BlockBehaviour
		)
	}

	/*
	    com.mojang.serialization.Codec CODEC -> a
    java.util.function.Function mapColor -> b
    boolean hasCollision -> c
    net.minecraft.world.level.block.SoundType soundType -> d
    java.util.function.ToIntFunction lightEmission -> e
    float explosionResistance -> f
    float destroyTime -> g
    boolean requiresCorrectToolForDrops -> h
    boolean isRandomlyTicking -> i
    float friction -> j
    float speedFactor -> k
    float jumpFactor -> l
    net.minecraft.resources.ResourceKey drops -> m
    boolean canOcclude -> n
    boolean isAir -> o
    boolean ignitedByLava -> p
    boolean liquid -> q
    boolean forceSolidOff -> r
    boolean forceSolidOn -> s
    net.minecraft.world.level.material.PushReaction pushReaction -> t
    boolean spawnTerrainParticles -> u
    net.minecraft.world.level.block.state.properties.NoteBlockInstrument instrument -> v
    boolean replaceable -> w
    net.minecraft.world.level.block.state.BlockBehaviour$StateArgumentPredicate isValidSpawn -> x
    net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate isRedstoneConductor -> y
    net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate isSuffocating -> z
    net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate isViewBlocking -> A
    net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate hasPostProcess -> B
    net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate emissiveRendering -> C
    boolean dynamicShape -> D
    net.minecraft.world.flag.FeatureFlagSet requiredFeatures -> E
    net.minecraft.world.level.block.state.BlockBehaviour$OffsetFunction offsetFunction -> F
    452:498:void <init>() -> <init>
    512:523:net.minecraft.world.level.block.state.BlockBehaviour$Properties ofFullCopy(net.minecraft.world.level.block.state.BlockBehaviour) -> a
    532:560:net.minecraft.world.level.block.state.BlockBehaviour$Properties ofLegacyCopy(net.minecraft.world.level.block.state.BlockBehaviour) -> b
    564:565:net.minecraft.world.level.block.state.BlockBehaviour$Properties mapColor(net.minecraft.world.item.DyeColor) -> a
    569:570:net.minecraft.world.level.block.state.BlockBehaviour$Properties mapColor(net.minecraft.world.level.material.MapColor) -> a
    574:575:net.minecraft.world.level.block.state.BlockBehaviour$Properties mapColor(java.util.function.Function) -> a
    579:581:net.minecraft.world.level.block.state.BlockBehaviour$Properties noCollission() -> b
    585:586:net.minecraft.world.level.block.state.BlockBehaviour$Properties noOcclusion() -> c
    590:591:net.minecraft.world.level.block.state.BlockBehaviour$Properties friction(float) -> a
    595:596:net.minecraft.world.level.block.state.BlockBehaviour$Properties speedFactor(float) -> b
    600:601:net.minecraft.world.level.block.state.BlockBehaviour$Properties jumpFactor(float) -> c
    605:606:net.minecraft.world.level.block.state.BlockBehaviour$Properties sound(net.minecraft.world.level.block.SoundType) -> a
    628:629:net.minecraft.world.level.block.state.BlockBehaviour$Properties randomTicks() -> e
    633:634:net.minecraft.world.level.block.state.BlockBehaviour$Properties dynamicShape() -> f
    642:643:net.minecraft.world.level.block.state.BlockBehaviour$Properties noLootTable() -> g
    647:648:net.minecraft.world.level.block.state.BlockBehaviour$Properties dropsLike(net.minecraft.world.level.block.Block) -> a
    652:653:net.minecraft.world.level.block.state.BlockBehaviour$Properties ignitedByLava() -> h
    657:658:net.minecraft.world.level.block.state.BlockBehaviour$Properties liquid() -> i
    665:666:net.minecraft.world.level.block.state.BlockBehaviour$Properties forceSolidOn() -> j
    675:676:net.minecraft.world.level.block.state.BlockBehaviour$Properties forceSolidOff() -> k
    680:681:net.minecraft.world.level.block.state.BlockBehaviour$Properties pushReaction(net.minecraft.world.level.material.PushReaction) -> a
    685:686:net.minecraft.world.level.block.state.BlockBehaviour$Properties air() -> l
    690:691:net.minecraft.world.level.block.state.BlockBehaviour$Properties isValidSpawn(net.minecraft.world.level.block.state.BlockBehaviour$StateArgumentPredicate) -> a
    695:696:net.minecraft.world.level.block.state.BlockBehaviour$Properties isRedstoneConductor(net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate) -> a
    700:701:net.minecraft.world.level.block.state.BlockBehaviour$Properties isSuffocating(net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate) -> b
    705:706:net.minecraft.world.level.block.state.BlockBehaviour$Properties isViewBlocking(net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate) -> c
    710:711:net.minecraft.world.level.block.state.BlockBehaviour$Properties hasPostProcess(net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate) -> d
    715:716:net.minecraft.world.level.block.state.BlockBehaviour$Properties emissiveRendering(net.minecraft.world.level.block.state.BlockBehaviour$StatePredicate) -> e
    720:721:net.minecraft.world.level.block.state.BlockBehaviour$Properties requiresCorrectToolForDrops() -> m
    725:726:net.minecraft.world.level.block.state.BlockBehaviour$Properties destroyTime(float) -> e
    730:731:net.minecraft.world.level.block.state.BlockBehaviour$Properties explosionResistance(float) -> f
    735:757:net.minecraft.world.level.block.state.BlockBehaviour$Properties offsetType(net.minecraft.world.level.block.state.BlockBehaviour$OffsetType) -> a
    761:762:net.minecraft.world.level.block.state.BlockBehaviour$Properties noTerrainParticles() -> n
    766:767:net.minecraft.world.level.block.state.BlockBehaviour$Properties requiredFeatures(net.minecraft.world.flag.FeatureFlag[]) -> a
    771:772:net.minecraft.world.level.block.state.BlockBehaviour$Properties instrument(net.minecraft.world.level.block.state.properties.NoteBlockInstrument) -> a
    776:777:net.minecraft.world.level.block.state.BlockBehaviour$Properties replaceable() -> o
    748:754:net.minecraft.world.phys.Vec3 lambda$offsetType$11(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> a
    738:745:net.minecraft.world.phys.Vec3 lambda$offsetType$10(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> b
    569:569:net.minecraft.world.level.material.MapColor lambda$mapColor$9(net.minecraft.world.level.material.MapColor,net.minecraft.world.level.block.state.BlockState) -> a
    564:564:net.minecraft.world.level.material.MapColor lambda$mapColor$8(net.minecraft.world.item.DyeColor,net.minecraft.world.level.block.state.BlockState) -> a
    489:489:boolean lambda$new$7(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> c
    488:488:boolean lambda$new$6(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> d
    485:485:boolean lambda$new$5(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> e
    482:482:boolean lambda$new$4(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos) -> f
    479:479:boolean lambda$new$3(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos,net.minecraft.world.entity.EntityType) -> a
    456:456:int lambda$new$2(net.minecraft.world.level.block.state.BlockState) -> a
    452:452:net.minecraft.world.level.material.MapColor lambda$new$1(net.minecraft.world.level.block.state.BlockState) -> b
    450:450:net.minecraft.world.level.block.state.BlockBehaviour$Properties lambda$static$0() -> p
    450:450:void <clinit>() -> <clinit>
	 */
	class Properties(around: Any) : MimickedClass(around) {
		companion object {
			val clazz: Class<*> = loadClass(
				net_minecraft_world_level_block_state_BlockBehaviour_Properties
			)

			fun of(): Properties = Properties(
				clazz.getMethod("a").invoke(null)
			)

			fun ofFullCopy(p: BlockBehaviour): Properties = Properties(
				clazz.getMethod("a", BlockBehaviour.clazz).invoke(null, p.around)
			)
		}

		fun lightLevel(function: (BlockState) -> Int): Properties = Properties(
			clazz.getMethod("a", ToIntFunction::class.java)
				.invoke(this.around, ToIntFunction<Any> { function(BlockState(it)) })
		)

		fun strength(destroyTime: Float, explosionResistance: Float): Properties = Properties(
			clazz.getMethod("a", Float::class.java, Float::class.java)
				.invoke(this.around, destroyTime, explosionResistance)
		)

		fun strength(strength: Float): Properties = Properties(
			clazz.getMethod("d",Float::class.java)
				.invoke(this.around, strength)
		)

		fun instabreak(): Properties = Properties(
			clazz.getMethod("d").invoke(this.around)
		)
	}
}