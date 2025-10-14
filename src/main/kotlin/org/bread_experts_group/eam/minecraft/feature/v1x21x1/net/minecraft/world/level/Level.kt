package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_level_Level
import java.lang.constant.ClassDesc

/*
    net.minecraft.world.level.border.WorldBorder worldBorder -> F
    net.minecraft.world.level.biome.BiomeManager biomeManager -> G
    net.minecraft.resources.ResourceKey dimension -> H
    net.minecraft.core.RegistryAccess registryAccess -> I
    net.minecraft.world.damagesource.DamageSources damageSources -> J
    long subTickCount -> K
    101:167:void <init>(net.minecraft.world.level.storage.WritableLevelData,net.minecraft.resources.ResourceKey,net.minecraft.core.RegistryAccess,net.minecraft.core.Holder,java.util.function.Supplier,boolean,boolean,long,int) -> <init>
    171:171:boolean isClientSide() -> x_
    177:177:net.minecraft.server.MinecraftServer getServer() -> o
    181:181:boolean isInWorldBounds(net.minecraft.core.BlockPos) -> k
    185:185:boolean isInSpawnableBounds(net.minecraft.core.BlockPos) -> l
    189:189:boolean isInWorldBoundsHorizontal(net.minecraft.core.BlockPos) -> g
    193:193:boolean isOutsideSpawnableHeight(int) -> b
    197:197:net.minecraft.world.level.chunk.LevelChunk getChunkAt(net.minecraft.core.BlockPos) -> m
    202:202:net.minecraft.world.level.chunk.LevelChunk getChunk(int,int) -> d
    208:212:net.minecraft.world.level.chunk.ChunkAccess getChunk(int,int,net.minecraft.world.level.chunk.status.ChunkStatus,boolean) -> a
    217:217:boolean setBlock(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,int) -> a
    222:270:boolean setBlock(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,int,int) -> a
    274:274:void onBlockStateChange(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState) -> a
    285:286:boolean removeBlock(net.minecraft.core.BlockPos,boolean) -> a
    299:319:boolean destroyBlock(net.minecraft.core.BlockPos,boolean,net.minecraft.world.entity.Entity,int) -> a
    323:323:void addDestroyBlockEffect(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    326:326:boolean setBlockAndUpdate(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> b
    void sendBlockUpdated(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState,int) -> a
    332:332:void setBlocksDirty(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState) -> b
    335:335:void updateNeighborsAt(net.minecraft.core.BlockPos,net.minecraft.world.level.block.Block) -> a
    338:338:void updateNeighborsAtExceptFromFacing(net.minecraft.core.BlockPos,net.minecraft.world.level.block.Block,net.minecraft.core.Direction) -> a
    341:341:void neighborChanged(net.minecraft.core.BlockPos,net.minecraft.world.level.block.Block,net.minecraft.core.BlockPos) -> a
    344:344:void neighborChanged(net.minecraft.world.level.block.state.BlockState,net.minecraft.core.BlockPos,net.minecraft.world.level.block.Block,net.minecraft.core.BlockPos,boolean) -> a
    348:349:void neighborShapeChanged(net.minecraft.core.Direction,net.minecraft.world.level.block.state.BlockState,net.minecraft.core.BlockPos,net.minecraft.core.BlockPos,int,int) -> a
    354:361:int getHeight(net.minecraft.world.level.levelgen.Heightmap$Types,int,int) -> a
    366:366:net.minecraft.world.level.lighting.LevelLightEngine getLightEngine() -> y_
    371:375:net.minecraft.world.level.block.state.BlockState getBlockState(net.minecraft.core.BlockPos) -> a_
    380:384:net.minecraft.world.level.material.FluidState getFluidState(net.minecraft.core.BlockPos) -> b_
    388:388:boolean isDay() -> R
    392:392:boolean isNight() -> S
    397:398:void playSound(net.minecraft.world.entity.Entity,net.minecraft.core.BlockPos,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float) -> a
    403:404:void playSound(net.minecraft.world.entity.player.Player,net.minecraft.core.BlockPos,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float) -> a
    void playSeededSound(net.minecraft.world.entity.player.Player,double,double,double,net.minecraft.core.Holder,net.minecraft.sounds.SoundSource,float,float,long) -> a
    410:411:void playSeededSound(net.minecraft.world.entity.player.Player,double,double,double,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float,long) -> a
    void playSeededSound(net.minecraft.world.entity.player.Player,net.minecraft.world.entity.Entity,net.minecraft.core.Holder,net.minecraft.sounds.SoundSource,float,float,long) -> a
    418:419:void playSound(net.minecraft.world.entity.player.Player,double,double,double,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource) -> a
    423:424:void playSound(net.minecraft.world.entity.player.Player,double,double,double,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float) -> a
    428:429:void playSound(net.minecraft.world.entity.player.Player,double,double,double,net.minecraft.core.Holder,net.minecraft.sounds.SoundSource,float,float) -> a
    433:434:void playSound(net.minecraft.world.entity.player.Player,net.minecraft.world.entity.Entity,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float) -> a
    437:438:void playLocalSound(net.minecraft.core.BlockPos,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float,boolean) -> a
    441:441:void playLocalSound(net.minecraft.world.entity.Entity,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float) -> a
    444:444:void playLocalSound(double,double,double,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float,boolean) -> a
    448:448:void addParticle(net.minecraft.core.particles.ParticleOptions,double,double,double,double,double,double) -> a
    451:451:void addParticle(net.minecraft.core.particles.ParticleOptions,boolean,double,double,double,double,double,double) -> a
    456:456:void addAlwaysVisibleParticle(net.minecraft.core.particles.ParticleOptions,double,double,double,double,double,double) -> b
    459:459:void addAlwaysVisibleParticle(net.minecraft.core.particles.ParticleOptions,boolean,double,double,double,double,double,double) -> b
    462:463:float getSunAngle(float) -> a
    467:468:void addBlockEntityTicker(net.minecraft.world.level.block.entity.TickingBlockEntity) -> a
    471:494:void tickBlockEntities() -> T
    498:507:void guardEntityTick(java.util.function.Consumer,net.minecraft.world.entity.Entity) -> a
    510:510:boolean shouldTickDeath(net.minecraft.world.entity.Entity) -> h
    514:514:boolean shouldTickBlocksAt(long) -> a
    518:518:boolean shouldTickBlocksAt(net.minecraft.core.BlockPos) -> n
    543:543:net.minecraft.world.level.Explosion explode(net.minecraft.world.entity.Entity,double,double,double,float,net.minecraft.world.level.Level$ExplosionInteraction) -> a
    547:547:net.minecraft.world.level.Explosion explode(net.minecraft.world.entity.Entity,double,double,double,float,boolean,net.minecraft.world.level.Level$ExplosionInteraction) -> a
    551:551:net.minecraft.world.level.Explosion explode(net.minecraft.world.entity.Entity,net.minecraft.world.damagesource.DamageSource,net.minecraft.world.level.ExplosionDamageCalculator,net.minecraft.world.phys.Vec3,float,boolean,net.minecraft.world.level.Level$ExplosionInteraction) -> a
    555:555:net.minecraft.world.level.Explosion explode(net.minecraft.world.entity.Entity,net.minecraft.world.damagesource.DamageSource,net.minecraft.world.level.ExplosionDamageCalculator,double,double,double,float,boolean,net.minecraft.world.level.Level$ExplosionInteraction) -> a
    559:559:net.minecraft.world.level.Explosion explode(net.minecraft.world.entity.Entity,net.minecraft.world.damagesource.DamageSource,net.minecraft.world.level.ExplosionDamageCalculator,double,double,double,float,boolean,net.minecraft.world.level.Level$ExplosionInteraction,net.minecraft.core.particles.ParticleOptions,net.minecraft.core.particles.ParticleOptions,net.minecraft.core.Holder) -> a
    563:575:net.minecraft.world.level.Explosion explode(net.minecraft.world.entity.Entity,net.minecraft.world.damagesource.DamageSource,net.minecraft.world.level.ExplosionDamageCalculator,double,double,double,float,boolean,net.minecraft.world.level.Level$ExplosionInteraction,boolean,net.minecraft.core.particles.ParticleOptions,net.minecraft.core.particles.ParticleOptions,net.minecraft.core.Holder) -> a
    579:579:net.minecraft.world.level.Explosion$BlockInteraction getDestroyType(net.minecraft.world.level.GameRules$Key) -> a
    java.lang.String gatherChunkSourceStats() -> I
    587:596:net.minecraft.world.level.block.entity.BlockEntity getBlockEntity(net.minecraft.core.BlockPos) -> c_
    600:606:void setBlockEntity(net.minecraft.world.level.block.entity.BlockEntity) -> a
    609:614:void removeBlockEntity(net.minecraft.core.BlockPos) -> o
    617:620:boolean isLoaded(net.minecraft.core.BlockPos) -> p
    629:638:boolean loadedAndEntityCanStandOnFace(net.minecraft.core.BlockPos,net.minecraft.world.entity.Entity,net.minecraft.core.Direction) -> a
    642:642:boolean loadedAndEntityCanStandOn(net.minecraft.core.BlockPos,net.minecraft.world.entity.Entity) -> a
    646:652:void updateSkyBrightness() -> U
    655:656:void setSpawnSettings(boolean,boolean) -> b
    659:663:net.minecraft.core.BlockPos getSharedSpawnPos() -> V
    667:667:float getSharedSpawnAngle() -> W
    671:677:void prepareWeather() -> X
    681:682:void close() -> close
    687:687:net.minecraft.world.level.BlockGetter getChunkForCollisions(int,int) -> c
    692:708:java.util.List getEntities(net.minecraft.world.entity.Entity,net.minecraft.world.phys.AABB,java.util.function.Predicate) -> a
    713:715:java.util.List getEntities(net.minecraft.world.level.entity.EntityTypeTest,net.minecraft.world.phys.AABB,java.util.function.Predicate) -> a
    719:720:void getEntities(net.minecraft.world.level.entity.EntityTypeTest,net.minecraft.world.phys.AABB,java.util.function.Predicate,java.util.List) -> a
    723:746:void getEntities(net.minecraft.world.level.entity.EntityTypeTest,net.minecraft.world.phys.AABB,java.util.function.Predicate,java.util.List,int) -> a
    net.minecraft.world.entity.Entity getEntity(int) -> a
    752:755:void blockEntityChanged(net.minecraft.core.BlockPos) -> q
    759:759:int getSeaLevel() -> z_
    763:763:void disconnect() -> Y
    769:769:long getGameTime() -> Z
    777:777:long getDayTime() -> aa
    781:781:boolean mayInteract(net.minecraft.world.entity.player.Player,net.minecraft.core.BlockPos) -> a
    785:785:void broadcastEntityEvent(net.minecraft.world.entity.Entity,byte) -> a
    788:788:void broadcastDamageEvent(net.minecraft.world.entity.Entity,net.minecraft.world.damagesource.DamageSource) -> a
    791:792:void blockEvent(net.minecraft.core.BlockPos,net.minecraft.world.level.block.Block,int,int) -> a
    796:796:net.minecraft.world.level.storage.LevelData getLevelData() -> A_
    800:800:net.minecraft.world.level.GameRules getGameRules() -> ab
    net.minecraft.world.TickRateManager tickRateManager() -> s
    806:806:float getThunderLevel(float) -> b
    810:813:void setThunderLevel(float) -> c
    816:816:float getRainLevel(float) -> d
    820:823:void setRainLevel(float) -> e
    826:829:boolean isThundering() -> ac
    833:833:boolean isRaining() -> ad
    837:849:boolean isRainingAt(net.minecraft.core.BlockPos) -> r
    net.minecraft.world.level.saveddata.maps.MapItemSavedData getMapData(net.minecraft.world.level.saveddata.maps.MapId) -> a
    void setMapData(net.minecraft.world.level.saveddata.maps.MapId,net.minecraft.world.level.saveddata.maps.MapItemSavedData) -> a
    net.minecraft.world.level.saveddata.maps.MapId getFreeMapId() -> v
    860:860:void globalLevelEvent(int,net.minecraft.core.BlockPos,int) -> b
    863:875:net.minecraft.CrashReportCategory fillReportDetails(net.minecraft.CrashReport) -> a
    void destroyBlockProgress(int,net.minecraft.core.BlockPos,int) -> a
    881:881:void createFireworks(double,double,double,double,double,double,java.util.List) -> a
    net.minecraft.world.scores.Scoreboard getScoreboard() -> M
    886:903:void updateNeighbourForOutputSignal(net.minecraft.core.BlockPos,net.minecraft.world.level.block.Block) -> c
    907:914:net.minecraft.world.DifficultyInstance getCurrentDifficultyAt(net.minecraft.core.BlockPos) -> d_
    919:919:int getSkyDarken() -> B_
    923:923:void setSkyFlashTime(int) -> c
    927:927:net.minecraft.world.level.border.WorldBorder getWorldBorder() -> C_
    931:931:void sendPacketToServer(net.minecraft.network.protocol.Packet) -> a
    936:936:net.minecraft.world.level.dimension.DimensionType dimensionType() -> D_
    940:940:net.minecraft.core.Holder dimensionTypeRegistration() -> ae
    944:944:net.minecraft.resources.ResourceKey dimension() -> af
    949:949:net.minecraft.util.RandomSource getRandom() -> E_
    954:954:boolean isStateAtPosition(net.minecraft.core.BlockPos,java.util.function.Predicate) -> a
    959:959:boolean isFluidAtPosition(net.minecraft.core.BlockPos,java.util.function.Predicate) -> b
    net.minecraft.world.item.crafting.RecipeManager getRecipeManager() -> r
    965:968:net.minecraft.core.BlockPos getBlockRandomPos(int,int,int,int) -> a
    972:972:boolean noSave() -> t
    976:976:net.minecraft.util.profiling.ProfilerFiller getProfiler() -> ag
    980:980:java.util.function.Supplier getProfilerSupplier() -> ah
    985:985:net.minecraft.world.level.biome.BiomeManager getBiomeManager() -> F_
    989:989:boolean isDebug() -> ai
    net.minecraft.world.level.entity.LevelEntityGetter getEntities() -> G
    996:996:long nextSubTickCount() -> G_
    1001:1001:net.minecraft.core.RegistryAccess registryAccess() -> H_
    1005:1005:net.minecraft.world.damagesource.DamageSources damageSources() -> aj
    net.minecraft.world.item.alchemy.PotionBrewing potionBrewing() -> K
    83:83:net.minecraft.world.level.chunk.ChunkAccess getChunk(int,int) -> a
    867:867:java.lang.String lambda$fillReportDetails$3() -> a
    865:865:java.lang.String lambda$fillReportDetails$2() -> p
    726:744:net.minecraft.util.AbortableIterationConsumer$Continuation lambda$getEntities$1(java.util.function.Predicate,java.util.List,int,net.minecraft.world.level.entity.EntityTypeTest,net.minecraft.world.entity.Entity) -> a
    696:707:void lambda$getEntities$0(net.minecraft.world.entity.Entity,java.util.function.Predicate,java.util.List,net.minecraft.world.entity.Entity) -> a
    84:88:void <clinit>() -> <clinit>

 */
open class Level(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_world_level_Level
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
		val mimicClassDesc: ClassDesc = ClassDesc.of(Level::class.qualifiedName)
	}
}