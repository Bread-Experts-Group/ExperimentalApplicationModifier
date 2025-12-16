package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_LevelRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Camera
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.phys.Vec3
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.org.joml.Matrix4f
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.LevelRenderer -> gex:
# {"fileName":"LevelRenderer.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> e
    int SECTION_SIZE -> a
    int HALF_SECTION_SIZE -> b
    float SKY_DISC_RADIUS -> f
    int MIN_FOG_DISTANCE -> g
    int RAIN_RADIUS -> h
    int RAIN_DIAMETER -> i
    int TRANSPARENT_SORT_COUNT -> j
    net.minecraft.resources.ResourceLocation MOON_LOCATION -> k
    net.minecraft.resources.ResourceLocation SUN_LOCATION -> l
    net.minecraft.resources.ResourceLocation CLOUDS_LOCATION -> c
    net.minecraft.resources.ResourceLocation END_SKY_LOCATION -> m
    net.minecraft.resources.ResourceLocation FORCEFIELD_LOCATION -> n
    net.minecraft.resources.ResourceLocation RAIN_LOCATION -> o
    net.minecraft.resources.ResourceLocation SNOW_LOCATION -> p
    net.minecraft.core.Direction[] DIRECTIONS -> d
    net.minecraft.client.Minecraft minecraft -> q
    net.minecraft.client.renderer.entity.EntityRenderDispatcher entityRenderDispatcher -> r
    net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher blockEntityRenderDispatcher -> s
    net.minecraft.client.renderer.RenderBuffers renderBuffers -> t
    net.minecraft.client.multiplayer.ClientLevel level -> u
    net.minecraft.client.renderer.SectionOcclusionGraph sectionOcclusionGraph -> v
    it.unimi.dsi.fastutil.objects.ObjectArrayList visibleSections -> w
    java.util.Set globalBlockEntities -> x
    net.minecraft.client.renderer.ViewArea viewArea -> y
    com.mojang.blaze3d.vertex.VertexBuffer starBuffer -> z
    com.mojang.blaze3d.vertex.VertexBuffer skyBuffer -> A
    com.mojang.blaze3d.vertex.VertexBuffer darkBuffer -> B
    boolean generateClouds -> C
    com.mojang.blaze3d.vertex.VertexBuffer cloudBuffer -> D
    net.minecraft.client.renderer.RunningTrimmedMean frameTimes -> E
    int ticks -> F
    it.unimi.dsi.fastutil.ints.Int2ObjectMap destroyingBlocks -> G
    it.unimi.dsi.fastutil.longs.Long2ObjectMap destructionProgress -> H
    java.util.Map playingJukeboxSongs -> I
    com.mojang.blaze3d.pipeline.RenderTarget entityTarget -> J
    net.minecraft.client.renderer.PostChain entityEffect -> K
    com.mojang.blaze3d.pipeline.RenderTarget translucentTarget -> L
    com.mojang.blaze3d.pipeline.RenderTarget itemEntityTarget -> M
    com.mojang.blaze3d.pipeline.RenderTarget particlesTarget -> N
    com.mojang.blaze3d.pipeline.RenderTarget weatherTarget -> O
    com.mojang.blaze3d.pipeline.RenderTarget cloudsTarget -> P
    net.minecraft.client.renderer.PostChain transparencyChain -> Q
    int lastCameraSectionX -> R
    int lastCameraSectionY -> S
    int lastCameraSectionZ -> T
    double prevCamX -> U
    double prevCamY -> V
    double prevCamZ -> W
    double prevCamRotX -> X
    double prevCamRotY -> Y
    int prevCloudX -> Z
    int prevCloudY -> aa
    int prevCloudZ -> ab
    net.minecraft.world.phys.Vec3 prevCloudColor -> ac
    net.minecraft.client.CloudStatus prevCloudsType -> ad
    net.minecraft.client.renderer.chunk.SectionRenderDispatcher sectionRenderDispatcher -> ae
    int lastViewDistance -> af
    int renderedEntities -> ag
    int culledEntities -> ah
    net.minecraft.client.renderer.culling.Frustum cullingFrustum -> ai
    boolean captureFrustum -> aj
    net.minecraft.client.renderer.culling.Frustum capturedFrustum -> ak
    org.joml.Vector4f[] frustumPoints -> al
    org.joml.Vector3d frustumPos -> am
    double xTransparentOld -> an
    double yTransparentOld -> ao
    double zTransparentOld -> ap
    int rainSoundTime -> aq
    float[] rainSizeX -> ar
    float[] rainSizeZ -> as
    185:293:void <init>(net.minecraft.client.Minecraft,net.minecraft.client.renderer.entity.EntityRenderDispatcher,net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher,net.minecraft.client.renderer.RenderBuffers) -> <init>
    296:433:void renderSnowAndRain(net.minecraft.client.renderer.LightTexture,float,double,double,double) -> a
    436:492:void tickRain(net.minecraft.client.Camera) -> a
    497:504:void close() -> close
    508:512:void onResourceManagerReload(net.minecraft.server.packs.resources.ResourceManager) -> a
    515:532:void initOutline() -> a
    535:574:void initTransparency() -> y
    577:593:void deinitTransparency() -> z
    596:603:void doEntityOutline() -> b
    606:606:boolean shouldShowEntityOutlines() -> d
    610:618:void createDarkSky() -> A
    621:629:void createLightSky() -> B
    632:640:com.mojang.blaze3d.vertex.MeshData buildSkyDisc(com.mojang.blaze3d.vertex.Tesselator,float) -> a
    644:652:void createStars() -> C
    655:687:com.mojang.blaze3d.vertex.MeshData drawStars(com.mojang.blaze3d.vertex.Tesselator) -> a
    691:712:void setLevel(net.minecraft.client.multiplayer.ClientLevel) -> a
    715:720:void graphicsChanged() -> e
    723:760:void allChanged() -> f
    763:771:void resize(int,int) -> a
    774:782:java.lang.String getSectionStatistics() -> g
    787:787:net.minecraft.client.renderer.chunk.SectionRenderDispatcher getSectionRenderDispatcher() -> h
    791:791:double getTotalSections() -> i
    795:795:double getLastViewDistance() -> j
    799:805:int countRenderedSections() -> k
    809:809:java.lang.String getEntityStatistics() -> l
    813:876:void setupRender(net.minecraft.client.Camera,net.minecraft.client.renderer.culling.Frustum,boolean,boolean) -> a
    879:879:net.minecraft.client.renderer.culling.Frustum offsetFrustum(net.minecraft.client.renderer.culling.Frustum) -> a
    883:890:void applyFrustum(net.minecraft.client.renderer.culling.Frustum) -> b
    893:894:void addRecentlyCompiledSection(net.minecraft.client.renderer.chunk.SectionRenderDispatcher$RenderSection) -> a
    897:923:void captureFrustum(org.joml.Matrix4f,org.joml.Matrix4f,double,double,double,net.minecraft.client.renderer.culling.Frustum) -> a
    1301:1304:void checkPoseStack(com.mojang.blaze3d.vertex.PoseStack) -> a
    1307:1313:void renderEntity(net.minecraft.world.entity.Entity,double,double,double,float,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource) -> a
    1316:1402:void renderSectionLayer(net.minecraft.client.renderer.RenderType,double,double,double,org.joml.Matrix4f,org.joml.Matrix4f) -> a
    1405:1573:void renderDebug(com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource,net.minecraft.client.Camera) -> a
    1576:1577:void addFrustumVertex(com.mojang.blaze3d.vertex.VertexConsumer,org.joml.Matrix4f,int) -> a
    1580:1585:void addFrustumQuad(com.mojang.blaze3d.vertex.VertexConsumer,org.joml.Matrix4f,int,int,int,int,int,int,int) -> a
    1588:1589:void captureFrustum() -> m
    1592:1593:void killFrustum() -> n
    1596:1615:void tick() -> o
    1618:1624:void removeProgress(net.minecraft.server.level.BlockDestructionProgress) -> a
    1627:1664:void renderEndSky(com.mojang.blaze3d.vertex.PoseStack) -> b
    1667:1802:void renderSky(org.joml.Matrix4f,org.joml.Matrix4f,float,net.minecraft.client.Camera,boolean,java.lang.Runnable) -> a
    1805:1808:boolean doesMobEffectBlockSky(net.minecraft.client.Camera) -> b
    1812:1887:void renderClouds(com.mojang.blaze3d.vertex.PoseStack,org.joml.Matrix4f,org.joml.Matrix4f,float,double,double,double) -> a
    1890:1990:com.mojang.blaze3d.vertex.MeshData buildClouds(com.mojang.blaze3d.vertex.Tesselator,double,double,double,net.minecraft.world.phys.Vec3) -> a
    1994:2032:void compileSections(net.minecraft.client.Camera) -> c
    2035:2138:void renderWorldBorder(net.minecraft.client.Camera) -> d
    2147:2149:void renderHitOutline(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,net.minecraft.world.entity.Entity,double,double,double,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState) -> a
    2153:2163:net.minecraft.world.phys.Vec3 mixColor(float) -> a
    2169:2174:net.minecraft.world.phys.Vec3 shiftHue(float,float,float,float) -> a
    2178:2190:void renderVoxelShape(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,net.minecraft.world.phys.shapes.VoxelShape,double,double,double,float,float,float,float,boolean) -> a
    2193:2206:void renderShape(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,net.minecraft.world.phys.shapes.VoxelShape,double,double,double,float,float,float,float) -> a
    2209:2210:void renderLineBox(com.mojang.blaze3d.vertex.VertexConsumer,double,double,double,double,double,double,float,float,float,float) -> a
    2213:2214:void renderLineBox(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,net.minecraft.world.phys.AABB,float,float,float,float) -> a
    2217:2218:void renderLineBox(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,double,double,double,double,double,double,float,float,float,float) -> a
    2222:2267:void renderLineBox(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,double,double,double,double,double,double,float,float,float,float,float,float,float) -> a
    2270:2271:void addChainedFilledBoxVertices(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,double,double,double,double,double,double,float,float,float,float) -> b
    2274:2320:void addChainedFilledBoxVertices(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,float,float,float,float,float,float,float,float,float,float) -> a
    2323:2362:void renderFace(com.mojang.blaze3d.vertex.PoseStack,com.mojang.blaze3d.vertex.VertexConsumer,net.minecraft.core.Direction,float,float,float,float,float,float,float,float,float,float) -> a
    2365:2366:void blockChanged(net.minecraft.world.level.BlockGetter,net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState,int) -> a
    2369:2376:void setBlockDirty(net.minecraft.core.BlockPos,boolean) -> a
    2379:2386:void setBlocksDirty(int,int,int,int,int,int) -> a
    2389:2392:void setBlockDirty(net.minecraft.core.BlockPos,net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.block.state.BlockState) -> a
    2395:2402:void setSectionDirtyWithNeighbors(int,int,int) -> a
    2405:2406:void setSectionDirty(int,int,int) -> b
    2409:2410:void setSectionDirty(int,int,int,boolean) -> a
    2413:2426:void playJukeboxSong(net.minecraft.core.Holder,net.minecraft.core.BlockPos) -> a
    2429:2433:void stopJukeboxSong(net.minecraft.core.BlockPos) -> c
    2436:2440:void stopJukeboxSongAndNotifyNearby(net.minecraft.core.BlockPos) -> a
    2443:2447:void notifyNearbyEntities(net.minecraft.world.level.Level,net.minecraft.core.BlockPos,boolean) -> a
    2450:2451:void addParticle(net.minecraft.core.particles.ParticleOptions,boolean,double,double,double,double,double,double) -> a
    2455:2466:void addParticle(net.minecraft.core.particles.ParticleOptions,boolean,boolean,double,double,double,double,double,double) -> a
    2469:2470:void addParticle(net.minecraft.core.particles.ParticleOptions,double,double,double,double,double,double) -> a
    2474:2474:net.minecraft.client.particle.Particle addParticleInternal(net.minecraft.core.particles.ParticleOptions,boolean,double,double,double,double,double,double) -> b
    2479:2495:net.minecraft.client.particle.Particle addParticleInternal(net.minecraft.core.particles.ParticleOptions,boolean,boolean,double,double,double,double,double,double) -> b
    2499:2515:net.minecraft.client.ParticleStatus calculateParticleLevel(boolean) -> a
    2519:2519:void clear() -> p
    2522:2554:void globalLevelEvent(int,net.minecraft.core.BlockPos,int) -> a
    2557:2963:void levelEvent(int,net.minecraft.core.BlockPos,int) -> b
    2966:2986:void destroyBlockProgress(int,net.minecraft.core.BlockPos,int) -> c
    2989:2989:boolean hasRenderedAllSections() -> q
    2993:2994:void onChunkLoaded(net.minecraft.world.level.ChunkPos) -> a
    2997:2999:void needsUpdate() -> r
    3002:3006:void updateGlobalBlockEntities(java.util.Collection,java.util.Collection) -> a
    3009:3009:int getLightColor(net.minecraft.world.level.BlockAndTintGetter,net.minecraft.core.BlockPos) -> a
    3013:3023:int getLightColor(net.minecraft.world.level.BlockAndTintGetter,net.minecraft.world.level.block.state.BlockState,net.minecraft.core.BlockPos) -> a
    3027:3028:boolean isSectionCompiled(net.minecraft.core.BlockPos) -> b
    3033:3033:com.mojang.blaze3d.pipeline.RenderTarget entityTarget() -> s
    3038:3038:com.mojang.blaze3d.pipeline.RenderTarget getTranslucentTarget() -> t
    3043:3043:com.mojang.blaze3d.pipeline.RenderTarget getItemEntityTarget() -> u
    3048:3048:com.mojang.blaze3d.pipeline.RenderTarget getParticlesTarget() -> v
    3053:3053:com.mojang.blaze3d.pipeline.RenderTarget getWeatherTarget() -> w
    3058:3058:com.mojang.blaze3d.pipeline.RenderTarget getCloudsTarget() -> x
    3068:3087:void shootParticles(int,net.minecraft.core.BlockPos,net.minecraft.util.RandomSource,net.minecraft.core.particles.SimpleParticleType) -> a
    2984:2984:java.util.SortedSet lambda$destroyBlockProgress$9(long) -> a
    2890:2890:void lambda$levelEvent$8(net.minecraft.core.BlockPos,net.minecraft.core.Holder$Reference) -> a
    2751:2754:net.minecraft.world.phys.Vec3 lambda$levelEvent$7(net.minecraft.util.RandomSource) -> a
    2462:2462:java.lang.String lambda$addParticle$6(double,double,double) -> a
    2461:2461:java.lang.String lambda$addParticle$5(net.minecraft.core.particles.ParticleOptions) -> a
    2195:2205:void lambda$renderShape$4(com.mojang.blaze3d.vertex.VertexConsumer,com.mojang.blaze3d.vertex.PoseStack$Pose,double,double,double,float,float,float,float,double,double,double,double,double,double) -> a
    1350:1350:java.lang.String lambda$renderSectionLayer$3(net.minecraft.client.renderer.RenderType) -> a
    1105:1109:com.mojang.blaze3d.vertex.VertexConsumer lambda$renderLevel$2(net.minecraft.client.renderer.MultiBufferSource$BufferSource,com.mojang.blaze3d.vertex.VertexConsumer,net.minecraft.client.renderer.RenderType) -> a
    977:977:void lambda$renderLevel$1(net.minecraft.client.Camera,float,boolean,float) -> a
    561:561:net.minecraft.network.chat.MutableComponent lambda$initTransparency$0(net.minecraft.server.packs.PackResources) -> a
    153:173:void <clinit>() -> <clinit>
 */
class LevelRenderer(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_LevelRenderer)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = LevelRenderer::class.classDesc
	}

	fun prepareCullFrustum(cameraPosition: Vec3, frustumMatrix: Matrix4f, projectionMatrix: Matrix4f) {
		clazz.getMethod("a", Vec3.clazz, Matrix4f.clazz, Matrix4f.clazz)
			.invoke(around, cameraPosition.around, frustumMatrix.around, projectionMatrix.around)
	}

	// renderLevel(net.minecraft.client.DeltaTracker,boolean,net.minecraft.client.Camera,net.minecraft.client.renderer.GameRenderer,net.minecraft.client.renderer.LightTexture,org.joml.Matrix4f,org.joml.Matrix4f) -> a
	fun renderLevel(
		deltaTracker: DeltaTracker,
		renderBlockOutline: Boolean,
		camera: Camera,
		gameRenderer: GameRenderer,
		lightTexture: LightTexture,
		frustumMatrix: Matrix4f,
		projectionMatrix: Matrix4f
	) {
		clazz.getMethod(
			"a",
			DeltaTracker.clazz,
			Boolean::class.java,
			Camera.clazz,
			GameRenderer.clazz,
			LightTexture.clazz,
			Matrix4f.clazz,
			Matrix4f.clazz
		).invoke(
			around,
			deltaTracker.around,
			renderBlockOutline,
			camera.around,
			gameRenderer.around,
			lightTexture.around,
			frustumMatrix.around,
			projectionMatrix.around
		)
	}
}