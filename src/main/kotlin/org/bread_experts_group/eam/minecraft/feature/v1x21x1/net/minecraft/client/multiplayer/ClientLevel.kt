package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.multiplayer

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.Level
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_multiplayer_ClientLevel
import java.lang.constant.ClassDesc

/*
net.minecraft.client.multiplayer.ClientLevel -> fzf:
# {"fileName":"ClientLevel.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> a
    double FLUID_PARTICLE_SPAWN_OFFSET -> b
    int NORMAL_LIGHT_UPDATES_PER_FRAME -> c
    int LIGHT_UPDATE_QUEUE_SIZE_THRESHOLD -> d
    net.minecraft.world.level.entity.EntityTickList tickingEntities -> e
    net.minecraft.world.level.entity.TransientEntitySectionManager entityStorage -> f
    net.minecraft.client.multiplayer.ClientPacketListener connection -> D
    net.minecraft.client.renderer.LevelRenderer levelRenderer -> E
    net.minecraft.client.multiplayer.ClientLevel$ClientLevelData clientLevelData -> F
    net.minecraft.client.renderer.DimensionSpecialEffects effects -> G
    net.minecraft.world.TickRateManager tickRateManager -> H
    net.minecraft.client.Minecraft minecraft -> I
    java.util.List players -> J
    java.util.Map mapData -> K
    long CLOUD_COLOR -> L
    int skyFlashTime -> M
    it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap tintCaches -> N
    net.minecraft.client.multiplayer.ClientChunkCache chunkSource -> O
    java.util.Deque lightUpdateQueue -> P
    int serverSimulationDistance -> Q
    net.minecraft.client.multiplayer.prediction.BlockStatePredictionHandler blockStatePredictionHandler -> R
    java.util.Set MARKER_PARTICLE_ITEMS -> S
    130:131:void handleBlockChangedAck(int) -> b
    134:137:void setServerVerifiedBlockState(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,int) -> b
    140:150:void syncBlockState(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.phys.Vec3) -> a
    153:153:net.minecraft.client.multiplayer.prediction.BlockStatePredictionHandler getBlockStatePredictionHandler() -> a
    158:166:boolean setBlock(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,int,int) -> a
    101:184:void <init>(net.minecraft.client.multiplayer.ClientPacketListener,net.minecraft.client.multiplayer.ClientLevel$ClientLevelData,net.minecraft.resources.ResourceKey,net.minecraft.core.Holder,int,int,java.util.function.Supplier,net.minecraft.client.renderer.LevelRenderer,boolean,long) -> <init>
    187:188:void queueLightUpdate(java.lang.Runnable) -> a
    191:201:void pollLightUpdates() -> b
    204:204:boolean isLightUpdateQueueEmpty() -> c
    208:208:net.minecraft.client.renderer.DimensionSpecialEffects effects() -> d
    212:226:void tick(java.util.function.BooleanSupplier) -> a
    229:233:void tickTime() -> n
    236:237:void setGameTime(long) -> b
    240:247:void setDayTime(long) -> c
    250:250:java.lang.Iterable entitiesForRendering() -> e
    254:266:void tickEntities() -> f
    270:270:boolean shouldTickDeath(net.minecraft.world.entity.Entity) -> h
    274:284:void tickNonPassenger(net.minecraft.world.entity.Entity) -> a
    287:304:void tickPassenger(net.minecraft.world.entity.Entity,net.minecraft.world.entity.Entity) -> a
    307:310:void unload(net.minecraft.world.level.chunk.LevelChunk) -> a
    313:316:void onChunkLoaded(net.minecraft.world.level.ChunkPos) -> a
    319:320:void clearTintCaches() -> g
    324:324:boolean hasChunk(int,int) -> b
    328:328:int getEntityCount() -> h
    332:334:void addEntity(net.minecraft.world.entity.Entity) -> c
    337:342:void removeEntity(int,net.minecraft.world.entity.Entity$RemovalReason) -> a
    347:347:net.minecraft.world.entity.Entity getEntity(int) -> a
    352:353:void disconnect() -> Y
    356:365:void animateTick(int,int,int) -> b
    369:377:net.minecraft.world.level.block.Block getMarkerParticleTarget() -> p
    381:413:void doAnimateTick(int,int,int,int,net.minecraft.util.RandomSource,net.minecraft.world.level.block.Block,net.minecraft.core.BlockPos$MutableBlockPos) -> a
    416:440:void trySpawnDripParticles(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.core.particles.ParticleOptions,boolean) -> a
    443:449:void spawnParticle(net.minecraft.core.BlockPos,net.minecraft.core.particles.ParticleOptions,net.minecraft.world.phys.shapes.VoxelShape,double) -> a
    452:453:void spawnFluidParticle(double,double,double,double,double,net.minecraft.core.particles.ParticleOptions) -> a
    457:463:net.minecraft.CrashReportCategory fillReportDetails(net.minecraft.CrashReport) -> a
    468:471:void playSeededSound(net.minecraft.world.entity.player.Player,double,double,double,net.minecraft.core.Holder,net.minecraft.sounds.SoundSource,float,float,long) -> a
    475:478:void playSeededSound(net.minecraft.world.entity.player.Player,net.minecraft.world.entity.Entity,net.minecraft.core.Holder,net.minecraft.sounds.SoundSource,float,float,long) -> a
    482:483:void playLocalSound(net.minecraft.world.entity.Entity,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float) -> a
    487:488:void playLocalSound(double,double,double,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float,boolean) -> a
    491:501:void playSound(double,double,double,net.minecraft.sounds.SoundEvent,net.minecraft.sounds.SoundSource,float,float,boolean,long) -> a
    505:513:void createFireworks(double,double,double,double,double,double,java.util.List) -> a
    517:518:void sendPacketToServer(net.minecraft.network.protocol.Packet) -> a
    522:522:net.minecraft.world.item.crafting.RecipeManager getRecipeManager() -> r
    527:527:net.minecraft.world.TickRateManager tickRateManager() -> s
    532:532:net.minecraft.world.ticks.LevelTickAccess getBlockTicks() -> P
    537:537:net.minecraft.world.ticks.LevelTickAccess getFluidTicks() -> O
    542:542:net.minecraft.client.multiplayer.ClientChunkCache getChunkSource() -> i
    548:548:net.minecraft.world.level.saveddata.maps.MapItemSavedData getMapData(net.minecraft.world.level.saveddata.maps.MapId) -> a
    552:553:void overrideMapData(net.minecraft.world.level.saveddata.maps.MapId,net.minecraft.world.level.saveddata.maps.MapItemSavedData) -> b
    558:558:void setMapData(net.minecraft.world.level.saveddata.maps.MapId,net.minecraft.world.level.saveddata.maps.MapItemSavedData) -> a
    562:562:net.minecraft.world.level.saveddata.maps.MapId getFreeMapId() -> v
    567:567:net.minecraft.world.scores.Scoreboard getScoreboard() -> M
    572:573:void sendBlockUpdated(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState,int) -> a
    577:578:void setBlocksDirty(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState) -> b
    581:582:void setSectionDirtyWithNeighbors(int,int,int) -> c
    586:587:void destroyBlockProgress(int,net.minecraft.core.BlockPos,int) -> a
    591:592:void globalLevelEvent(int,net.minecraft.core.BlockPos,int) -> b
    597:609:void levelEvent(net.minecraft.world.entity.player.Player,int,net.minecraft.core.BlockPos,int) -> a
    613:614:void addParticle(net.minecraft.core.particles.ParticleOptions,double,double,double,double,double,double) -> a
    618:619:void addParticle(net.minecraft.core.particles.ParticleOptions,boolean,double,double,double,double,double,double) -> a
    623:624:void addAlwaysVisibleParticle(net.minecraft.core.particles.ParticleOptions,double,double,double,double,double,double) -> b
    628:629:void addAlwaysVisibleParticle(net.minecraft.core.particles.ParticleOptions,boolean,double,double,double,double,double,double) -> b
    633:633:java.util.List players() -> x
    638:638:net.minecraft.core.Holder getUncachedNoiseBiome(int,int,int) -> a
    642:652:float getSkyDarken(float) -> g
    656:700:net.minecraft.world.phys.Vec3 getSkyColor(net.minecraft.world.phys.Vec3,float) -> a
    704:737:net.minecraft.world.phys.Vec3 getCloudColor(float) -> h
    741:746:float getStarBrightness(float) -> i
    750:750:int getSkyFlashTime() -> j
    755:756:void setSkyFlashTime(int) -> c
    760:778:float getShade(net.minecraft.core.Direction,boolean) -> a
    784:785:int getBlockTint(net.minecraft.core.BlockPos,net.minecraft.world.level.ColorResolver) -> a
    789:810:int calculateBlockTint(net.minecraft.core.BlockPos,net.minecraft.world.level.ColorResolver) -> b
    814:815:void setDefaultSpawnPos(net.minecraft.core.BlockPos,float) -> a
    819:819:java.lang.String toString() -> toString
    824:824:net.minecraft.client.multiplayer.ClientLevel$ClientLevelData getLevelData() -> k
    830:830:void gameEvent(net.minecraft.core.Holder,net.minecraft.world.phys.Vec3,net.minecraft.world.level.gameevent.GameEvent$Context) -> a
    833:833:java.util.Map getAllMapData() -> l
    837:838:void addMapData(java.util.Map) -> a
    961:961:net.minecraft.world.level.entity.LevelEntityGetter getEntities() -> G
    1003:1003:java.lang.String gatherChunkSourceStats() -> I
    1008:1009:void addDestroyBlockEffect(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    1012:1013:void setServerSimulationDistance(int) -> h
    1016:1016:int getServerSimulationDistance() -> m
    1021:1021:net.minecraft.world.flag.FeatureFlagSet enabledFeatures() -> J
    1026:1026:net.minecraft.world.item.alchemy.PotionBrewing potionBrewing() -> K
    95:95:net.minecraft.world.level.storage.LevelData getLevelData() -> A_
    95:95:net.minecraft.world.level.chunk.ChunkSource getChunkSource() -> N
    660:660:net.minecraft.world.phys.Vec3 lambda$getSkyColor$12(net.minecraft.world.level.biome.BiomeManager,int,int,int) -> a
    461:461:java.lang.String lambda$fillReportDetails$11() -> q
    460:460:java.lang.String lambda$fillReportDetails$10() -> u
    459:459:java.lang.String lambda$fillReportDetails$9() -> w
    408:411:void lambda$doAnimateTick$8(net.minecraft.core.BlockPos$MutableBlockPos,net.minecraft.world.level.biome.AmbientParticleSettings) -> a
    319:319:void lambda$clearTintCaches$7(net.minecraft.world.level.ColorResolver,net.minecraft.client.color.block.BlockTintCache) -> a
    313:313:void lambda$onChunkLoaded$6(net.minecraft.world.level.ChunkPos,net.minecraft.world.level.ColorResolver,net.minecraft.client.color.block.BlockTintCache) -> a
    277:277:java.lang.String lambda$tickNonPassenger$5(net.minecraft.world.entity.Entity) -> d
    258:262:void lambda$tickEntities$4(net.minecraft.world.entity.Entity) -> e
    116:119:void lambda$new$3(it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap) -> a
    118:118:int lambda$new$2(net.minecraft.core.BlockPos) -> a
    117:117:int lambda$new$1(net.minecraft.core.BlockPos) -> b
    116:116:int lambda$new$0(net.minecraft.core.BlockPos) -> c
    96:169:void <clinit>() -> <clinit>
net.minecraft.client.multiplayer.ClientLevel$1 -> fzf$1:
# {"fileName":"ClientLevel.java","id":"sourceFile"}
    int[] $SwitchMap$net$minecraft$core$Direction -> a
    766:766:void <clinit>() -> <clinit>
net.minecraft.client.multiplayer.ClientLevel$ClientLevelData -> fzf$a:
# {"fileName":"ClientLevel.java","id":"sourceFile"}
    boolean hardcore -> a
    net.minecraft.world.level.GameRules gameRules -> b
    boolean isFlat -> c
    net.minecraft.core.BlockPos spawnPos -> d
    float spawnAngle -> e
    long gameTime -> f
    long dayTime -> g
    boolean raining -> h
    net.minecraft.world.Difficulty difficulty -> i
    boolean difficultyLocked -> j
    855:860:void <init>(net.minecraft.world.Difficulty,boolean,boolean) -> <init>
    863:863:net.minecraft.core.BlockPos getSpawnPos() -> a
    868:868:float getSpawnAngle() -> b
    873:873:long getGameTime() -> c
    878:878:long getDayTime() -> d
    882:883:void setGameTime(long) -> a
    886:887:void setDayTime(long) -> b
    891:893:void setSpawn(net.minecraft.core.BlockPos,float) -> a
    897:897:boolean isThundering() -> g
    902:902:boolean isRaining() -> i
    907:908:void setRaining(boolean) -> b
    912:912:boolean isHardcore() -> l
    917:917:net.minecraft.world.level.GameRules getGameRules() -> o
    922:922:net.minecraft.world.Difficulty getDifficulty() -> q
    927:927:boolean isDifficultyLocked() -> r
    932:933:void fillCrashReportCategory(net.minecraft.CrashReportCategory,net.minecraft.world.level.LevelHeightAccessor) -> a
    936:937:void setDifficulty(net.minecraft.world.Difficulty) -> a
    940:941:void setDifficultyLocked(boolean) -> a
    944:948:double getHorizonHeight(net.minecraft.world.level.LevelHeightAccessor) -> a
    952:955:float getClearColorScale() -> e
net.minecraft.client.multiplayer.ClientLevel$EntityCallbacks -> fzf$b:
# {"fileName":"ClientLevel.java","id":"sourceFile"}
    net.minecraft.client.multiplayer.ClientLevel this$0 -> a
    964:964:void <init>(net.minecraft.client.multiplayer.ClientLevel) -> <init>
    967:967:void onCreated(net.minecraft.world.entity.Entity) -> a
    971:971:void onDestroyed(net.minecraft.world.entity.Entity) -> b
    975:976:void onTickingStart(net.minecraft.world.entity.Entity) -> c
    980:981:void onTickingEnd(net.minecraft.world.entity.Entity) -> d
    985:988:void onTrackingStart(net.minecraft.world.entity.Entity) -> e
    992:994:void onTrackingEnd(net.minecraft.world.entity.Entity) -> f
    998:998:void onSectionChange(net.minecraft.world.entity.Entity) -> g
    964:964:void onSectionChange(java.lang.Object) -> a
    964:964:void onTrackingEnd(java.lang.Object) -> b
    964:964:void onTrackingStart(java.lang.Object) -> c
    964:964:void onTickingEnd(java.lang.Object) -> d
    964:964:void onTickingStart(java.lang.Object) -> e
    964:964:void onDestroyed(java.lang.Object) -> f
    964:964:void onCreated(java.lang.Object) -> g
 */
class ClientLevel(around: Any) : Level(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_client_multiplayer_ClientLevel
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
}