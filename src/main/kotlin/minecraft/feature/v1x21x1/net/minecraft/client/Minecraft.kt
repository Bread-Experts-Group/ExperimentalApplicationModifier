package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.blaze3d.platform.Window
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.Font
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.multiplayer.ClientLevel
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.renderer.entity.ItemRenderer
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model.ModelManager
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_Minecraft

/*
 266:266:void <clinit>() -> <clinit>
net.minecraft.client.Minecraft -> fgo:
# {"fileName":"Minecraft.java","id":"sourceFile"}
    net.minecraft.client.Minecraft instance -> E
    org.slf4j.Logger LOGGER -> F
    boolean ON_OSX -> a
    int MAX_TICKS_PER_UPDATE -> G
    net.minecraft.resources.ResourceLocation DEFAULT_FONT -> b
    net.minecraft.resources.ResourceLocation UNIFORM_FONT -> c
    net.minecraft.resources.ResourceLocation ALT_FONT -> d
    net.minecraft.resources.ResourceLocation REGIONAL_COMPLIANCIES -> H
    java.util.concurrent.CompletableFuture RESOURCE_RELOAD_INITIAL_TASK -> I
    net.minecraft.network.chat.Component SOCIAL_INTERACTIONS_NOT_AVAILABLE -> J
    java.lang.String UPDATE_DRIVERS_ADVICE -> e
    long canary -> K
    java.nio.file.Path resourcePackDirectory -> L
    java.util.concurrent.CompletableFuture profileFuture -> M
    net.minecraft.client.renderer.texture.TextureManager textureManager -> N
    com.mojang.datafixers.DataFixer fixerUpper -> O
    net.minecraft.client.renderer.VirtualScreen virtualScreen -> P
    com.mojang.blaze3d.platform.Window window -> Q // PRIVATE METHOD
    net.minecraft.client.DeltaTracker$Timer timer -> R
    net.minecraft.client.renderer.RenderBuffers renderBuffers -> S
    net.minecraft.client.renderer.LevelRenderer levelRenderer -> f
    net.minecraft.client.renderer.entity.EntityRenderDispatcher entityRenderDispatcher -> T
    net.minecraft.client.renderer.entity.ItemRenderer itemRenderer -> U
    net.minecraft.client.particle.ParticleEngine particleEngine -> g
    net.minecraft.client.User user -> V
    net.minecraft.client.gui.Font fontFilterFishy -> i
    net.minecraft.client.renderer.GameRenderer gameRenderer -> j
    net.minecraft.client.renderer.debug.DebugRenderer debugRenderer -> k
    java.util.concurrent.atomic.AtomicReference progressListener -> W
    net.minecraft.client.gui.Gui gui -> l
    net.minecraft.client.Options options -> m
    net.minecraft.client.HotbarManager hotbarManager -> X
    net.minecraft.client.MouseHandler mouseHandler -> n
    net.minecraft.client.KeyboardHandler keyboardHandler -> o
    net.minecraft.client.InputType lastInputType -> Y
    java.io.File gameDirectory -> p
    java.lang.String launchedVersion -> Z
    java.lang.String versionType -> aa
    java.net.Proxy proxy -> ab
    net.minecraft.world.level.storage.LevelStorageSource levelSource -> ac
    boolean demo -> ad
    boolean allowsMultiplayer -> ae
    boolean allowsChat -> af
    net.minecraft.server.packs.resources.ReloadableResourceManager resourceManager -> ag
    net.minecraft.server.packs.VanillaPackResources vanillaPackResources -> ah
    net.minecraft.client.resources.server.DownloadedPackSource downloadedPackSource -> ai
    net.minecraft.server.packs.repository.PackRepository resourcePackRepository -> aj
    net.minecraft.client.resources.language.LanguageManager languageManager -> ak
    net.minecraft.client.color.block.BlockColors blockColors -> al
    net.minecraft.client.color.item.ItemColors itemColors -> am
    com.mojang.blaze3d.pipeline.RenderTarget mainRenderTarget -> an
    net.minecraft.client.sounds.SoundManager soundManager -> ao
    net.minecraft.client.sounds.MusicManager musicManager -> ap
    net.minecraft.client.gui.font.FontManager fontManager -> aq
    net.minecraft.client.resources.SplashManager splashManager -> ar
    net.minecraft.client.renderer.GpuWarnlistManager gpuWarnlistManager -> as
    net.minecraft.client.PeriodicNotificationManager regionalCompliancies -> at
    com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService authenticationService -> au
    com.mojang.authlib.minecraft.MinecraftSessionService minecraftSessionService -> av
    com.mojang.authlib.minecraft.UserApiService userApiService -> aw
    java.util.concurrent.CompletableFuture userPropertiesFuture -> ax
    net.minecraft.client.resources.SkinManager skinManager -> ay
    net.minecraft.client.resources.model.ModelManager modelManager -> az
    net.minecraft.client.renderer.block.BlockRenderDispatcher blockRenderer -> aA
    net.minecraft.client.resources.PaintingTextureManager paintingTextures -> aB
    net.minecraft.client.resources.MobEffectTextureManager mobEffectTextures -> aC
    net.minecraft.client.resources.MapDecorationTextureManager mapDecorationTextures -> aD
    net.minecraft.client.gui.GuiSpriteManager guiSprites -> aE
    net.minecraft.client.gui.components.toasts.ToastComponent toast -> aF
    net.minecraft.client.tutorial.Tutorial tutorial -> aG
    net.minecraft.client.gui.screens.social.PlayerSocialManager playerSocialManager -> aH
    net.minecraft.client.model.geom.EntityModelSet entityModels -> aI
    net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher blockEntityRenderDispatcher -> aJ
    net.minecraft.client.telemetry.ClientTelemetryManager telemetryManager -> aK
    net.minecraft.client.multiplayer.ProfileKeyPairManager profileKeyPairManager -> aL
    com.mojang.realmsclient.gui.RealmsDataFetcher realmsDataFetcher -> aM
    net.minecraft.client.quickplay.QuickPlayLog quickPlayLog -> aN
    net.minecraft.client.multiplayer.MultiPlayerGameMode gameMode -> q
    net.minecraft.client.multiplayer.ClientLevel level -> r
    net.minecraft.client.player.LocalPlayer player -> s
    net.minecraft.client.server.IntegratedServer singleplayerServer -> aO
    net.minecraft.network.Connection pendingConnection -> aP
    boolean isLocalServer -> aQ
    net.minecraft.world.entity.Entity cameraEntity -> t
    net.minecraft.world.entity.Entity crosshairPickEntity -> u
    net.minecraft.world.phys.HitResult hitResult -> v
    int rightClickDelay -> aR
    int missTime -> w
    boolean pause -> aS
    long lastNanoTime -> aT
    long lastTime -> aU
    int frames -> aV
    boolean noRender -> x
    net.minecraft.client.gui.screens.Screen screen -> y
    net.minecraft.client.gui.screens.Overlay overlay -> aW
    boolean clientLevelTeardownInProgress -> aX
    java.lang.Thread gameThread -> aY
    boolean running -> aZ
    java.util.function.Supplier delayedCrash -> ba
    int fps -> bb
    java.lang.String fpsString -> z
    long frameTimeNs -> bc
    boolean wireframe -> A
    boolean sectionPath -> B
    boolean sectionVisibility -> C
    boolean smartCull -> D
    boolean windowActive -> bd
    java.util.Queue progressTasks -> be
    java.util.concurrent.CompletableFuture pendingReload -> bf
    net.minecraft.client.gui.components.toasts.TutorialToast socialInteractionsToast -> bg
    net.minecraft.util.profiling.ProfilerFiller profiler -> bh
    int fpsPieRenderTicks -> bi
    net.minecraft.util.profiling.ContinuousProfiler fpsPieProfiler -> bj
    net.minecraft.util.profiling.ProfileResults fpsPieResults -> bk
    net.minecraft.util.profiling.metrics.profiling.MetricsRecorder metricsRecorder -> bl
    net.minecraft.client.ResourceLoadStateTracker reloadStateTracker -> bm
    long savedCpuDuration -> bn
    double gpuUtilization -> bo
    com.mojang.blaze3d.systems.TimerQuery$FrameProfile currentFrameProfile -> bp
    net.minecraft.client.GameNarrator narrator -> bq
    net.minecraft.client.multiplayer.chat.ChatListener chatListener -> br
    net.minecraft.client.multiplayer.chat.report.ReportingContext reportingContext -> bs
    net.minecraft.client.CommandHistory commandHistory -> bt
    net.minecraft.world.level.validation.DirectoryValidator directoryValidator -> bu
    boolean gameLoadFinished -> bv
    long clientStartTimeMs -> bw
    long clientTickCount -> bx
    java.lang.String debugPath -> by
    270:1577:void <init>(net.minecraft.client.main.GameConfig) -> <init>
    709:713:void onResourceLoadFinished(net.minecraft.client.Minecraft$GameLoadCookie) -> a
    716:723:void onGameLoadFinished(net.minecraft.client.Minecraft$GameLoadCookie) -> b
    726:726:boolean isGameLoadFinished() -> c
    730:746:java.lang.Runnable buildInitialScreens(net.minecraft.client.Minecraft$GameLoadCookie) -> c
    750:775:void addInitialScreens(java.util.List) -> a
    779:781:boolean countryEqualsISO3(java.lang.Object) -> b
    786:787:void updateTitle() -> d
    790:812:java.lang.String createTitle() -> bd
    816:819:com.mojang.authlib.minecraft.UserApiService createUserApiService(com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService,net.minecraft.client.main.GameConfig) -> a
    823:823:net.minecraft.util.ModCheck checkModStatus() -> e
    827:832:void rollbackResourcePacks(java.lang.Throwable,net.minecraft.client.Minecraft$GameLoadCookie) -> a
    835:846:void clearResourcePacksOnError(java.lang.Throwable,net.minecraft.network.chat.Component,net.minecraft.client.Minecraft$GameLoadCookie) -> a
    849:856:void abortResourcePackRecovery() -> be
    859:861:void addResourcePackLoadFailToast(net.minecraft.network.chat.Component) -> a
    864:907:void run() -> f
    910:911:void updateFontOptions() -> g
    914:916:void onFullscreenError(int,long) -> a
    919:919:com.mojang.blaze3d.pipeline.RenderTarget getMainRenderTarget() -> h
    923:923:java.lang.String getLaunchedVersion() -> i
    927:927:java.lang.String getVersionType() -> j
    931:932:void delayCrash(net.minecraft.CrashReport) -> a
    938:939:void delayCrashRaw(net.minecraft.CrashReport) -> b
    942:946:void handleDelayedCrash() -> bf
    949:952:void emergencySaveAndCrash(net.minecraft.CrashReport) -> c
    956:976:void crash(net.minecraft.client.Minecraft,java.io.File,net.minecraft.CrashReport) -> a
    979:979:boolean isEnforceUnicode() -> k
    983:983:java.util.concurrent.CompletableFuture reloadResourcePacks() -> l
    989:1023:java.util.concurrent.CompletableFuture reloadResourcePacks(boolean,net.minecraft.client.Minecraft$GameLoadCookie) -> a
    1027:1076:void selfTest() -> bg
    1079:1079:net.minecraft.world.level.storage.LevelStorageSource getLevelSource() -> m
    1083:1102:void openChatScreen(java.lang.String) -> a
    1105:1151:void setScreen(net.minecraft.client.gui.screens.Screen) -> a
    1154:1155:void setOverlay(net.minecraft.client.gui.screens.Overlay) -> a
    1159:1183:void destroy() -> n
    1187:1214:void close() -> close
    1218:1360:void runTick(boolean) -> c
    1364:1387:net.minecraft.util.profiling.ProfilerFiller constructProfiler(boolean,net.minecraft.util.profiling.SingleTickProfiler) -> a
    1391:1400:void finishProfilers(boolean,net.minecraft.util.profiling.SingleTickProfiler) -> b
    1404:1415:void resizeDisplay() -> a
    1419:1420:void cursorEntered() -> b
    1423:1423:int getFps() -> o
    1427:1427:long getFrameTimeNs() -> p
    1431:1434:int getFramerateLimit() -> bh
    1440:1453:void emergencySave() -> bi
    1456:1518:boolean debugClientMetricsStart(java.util.function.Consumer) -> a
    1522:1526:void debugClientMetricsStop() -> bj
    1529:1533:void debugClientMetricsCancel() -> bk
    1539:1574:java.nio.file.Path archiveProfilingReport(net.minecraft.SystemReport,java.util.List) -> a
    1580:1605:void debugFpsMeterKeyPress(int) -> a
    1608:1701:void renderFpsMeter(net.minecraft.client.gui.GuiGraphics,net.minecraft.util.profiling.ProfileResults) -> a
    1704:1705:void stop() -> q
    1708:1708:boolean isRunning() -> r
    1712:1723:void pauseGame(boolean) -> b
    1726:1748:void continueAttack(boolean) -> d
    1751:1799:boolean startAttack() -> bl
    1803:1883:void startUseItem() -> bm
    1886:1886:net.minecraft.client.sounds.MusicManager getMusicManager() -> s
    1890:2012:void tick() -> t
    2015:2015:boolean isLevelRunningNormally() -> bn
    2019:2019:boolean isMultiplayerServer() -> bo
    2023:2123:void handleKeybinds() -> bp
    2126:2126:net.minecraft.client.telemetry.ClientTelemetryManager getTelemetryManager() -> u
    2130:2130:double getGpuUtilization() -> v
    2134:2134:net.minecraft.client.multiplayer.ProfileKeyPairManager getProfileKeyPairManager() -> w
    2138:2138:net.minecraft.client.gui.screens.worldselection.WorldOpenFlows createWorldOpenFlows() -> x
    2142:2199:void doWorldLoad(net.minecraft.world.level.storage.LevelStorageSource$LevelStorageAccess,net.minecraft.server.packs.repository.PackRepository,net.minecraft.server.WorldStem,boolean) -> a
    2202:2212:void setLevel(net.minecraft.client.multiplayer.ClientLevel,net.minecraft.client.gui.screens.ReceivingLevelScreen$Reason) -> a
    2215:2216:void disconnect() -> y
    2219:2220:void disconnect(net.minecraft.client.gui.screens.Screen) -> b
    2225:2269:void disconnect(net.minecraft.client.gui.screens.Screen,boolean) -> a
    2272:2275:void clearDownloadedResourcePacks() -> z
    2278:2305:void clearClientLevel(net.minecraft.client.gui.screens.Screen) -> c
    2308:2317:void updateScreenAndTick(net.minecraft.client.gui.screens.Screen) -> e
    2320:2324:void forceSetScreen(net.minecraft.client.gui.screens.Screen) -> d
    2327:2331:void updateLevelInEngines(net.minecraft.client.multiplayer.ClientLevel) -> a
    2334:2334:com.mojang.authlib.minecraft.UserApiService$UserProperties userProperties() -> bq
    2338:2338:boolean telemetryOptInExtra() -> C
    2342:2342:boolean extraTelemetryAvailable() -> D
    2346:2349:boolean allowsTelemetry() -> E
    2353:2356:boolean allowsMultiplayer() -> F
    2360:2360:boolean allowsRealms() -> G
    2365:2365:com.mojang.authlib.minecraft.BanDetails multiplayerBan() -> H
    2369:2370:boolean isNameBanned() -> I
    2375:2378:boolean isBlocked(java.util.UUID) -> a
    2382:2391:net.minecraft.client.Minecraft$ChatStatus getChatStatus() -> J
    2395:2395:boolean isDemo() -> K
    2400:2400:net.minecraft.client.multiplayer.ClientPacketListener getConnection() -> L
    2404:2404:boolean renderNames() -> M
    2408:2408:boolean useFancyGraphics() -> N
    2412:2412:boolean useShaderTransparency() -> O
    2416:2416:boolean useAmbientOcclusion() -> P
    2420:2486:void pickBlock() -> br
    2490:2496:void addCustomNbtData(net.minecraft.world.item.ItemStack,net.minecraft.world.level.block.entity.BlockEntity,net.minecraft.core.RegistryAccess) -> a
    2499:2512:net.minecraft.CrashReport fillReport(net.minecraft.CrashReport) -> d
    2516:2518:void fillReport(net.minecraft.client.Minecraft,net.minecraft.client.resources.language.LanguageManager,java.lang.String,net.minecraft.client.Options,net.minecraft.CrashReport) -> a
    2521:2521:java.lang.String formatSeconds(double) -> a
    2527:2534:void fillUptime(net.minecraft.CrashReportCategory) -> a
    2537:2574:net.minecraft.SystemReport fillSystemReport(net.minecraft.SystemReport,net.minecraft.client.Minecraft,net.minecraft.client.resources.language.LanguageManager,java.lang.String,net.minecraft.client.Options) -> a
    2582:2582:java.util.concurrent.CompletableFuture delayTextureReload() -> R
    2586:2589:void updateReportEnvironment(net.minecraft.client.multiplayer.chat.report.ReportEnvironment) -> a
    2593:2593:net.minecraft.client.multiplayer.ServerData getCurrentServer() -> S
    2597:2597:boolean isLocalServer() -> T
    2601:2601:boolean hasSingleplayerServer() -> U
    2606:2606:net.minecraft.client.server.IntegratedServer getSingleplayerServer() -> V
    2610:2611:boolean isSingleplayer() -> W
    2615:2615:boolean isLocalPlayer(java.util.UUID) -> b
    2619:2619:net.minecraft.client.User getUser() -> X
    2623:2627:com.mojang.authlib.GameProfile getGameProfile() -> Y
    2631:2631:java.net.Proxy getProxy() -> Z
    2635:2635:net.minecraft.client.renderer.texture.TextureManager getTextureManager() -> aa
    2639:2639:net.minecraft.server.packs.resources.ResourceManager getResourceManager() -> ab
    2643:2643:net.minecraft.server.packs.repository.PackRepository getResourcePackRepository() -> ac
    2647:2647:net.minecraft.server.packs.VanillaPackResources getVanillaPackResources() -> ad
    2651:2651:net.minecraft.client.resources.server.DownloadedPackSource getDownloadedPackSource() -> ae
    2655:2655:java.nio.file.Path getResourcePackDirectory() -> af
    2659:2659:net.minecraft.client.resources.language.LanguageManager getLanguageManager() -> ag
    2663:2663:java.util.function.Function getTextureAtlas(net.minecraft.resources.ResourceLocation) -> a
    2667:2667:boolean isPaused() -> ah
    2671:2671:net.minecraft.client.renderer.GpuWarnlistManager getGpuWarnlistManager() -> ai
    2675:2675:net.minecraft.client.sounds.SoundManager getSoundManager() -> aj
    2679:2704:net.minecraft.sounds.Music getSituationalMusic() -> ak
    2708:2708:com.mojang.authlib.minecraft.MinecraftSessionService getMinecraftSessionService() -> al
    2712:2712:net.minecraft.client.resources.SkinManager getSkinManager() -> am
    2717:2717:net.minecraft.world.entity.Entity getCameraEntity() -> an
    2721:2723:void setCameraEntity(net.minecraft.world.entity.Entity) -> a
    2726:2726:boolean shouldEntityAppearGlowing(net.minecraft.world.entity.Entity) -> b
    2731:2731:java.lang.Thread getRunningThread() -> az
    2736:2736:java.lang.Runnable wrapRunnable(java.lang.Runnable) -> f
    2741:2741:boolean shouldRun(java.lang.Runnable) -> e
    2745:2745:net.minecraft.client.renderer.block.BlockRenderDispatcher getBlockRenderer() -> ao
    2749:2749:net.minecraft.client.renderer.entity.EntityRenderDispatcher getEntityRenderDispatcher() -> ap
    2753:2753:net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher getBlockEntityRenderDispatcher() -> aq
    2761:2761:com.mojang.datafixers.DataFixer getFixerUpper() -> as
    2765:2765:net.minecraft.client.DeltaTracker getTimer() -> at
    2769:2769:net.minecraft.client.color.block.BlockColors getBlockColors() -> au
    2773:2773:boolean showOnlyReducedInfo() -> av
    2777:2777:net.minecraft.client.gui.components.toasts.ToastComponent getToasts() -> aw
    2781:2781:net.minecraft.client.tutorial.Tutorial getTutorial() -> ax
    2785:2785:boolean isWindowActive() -> aA
    2789:2789:net.minecraft.client.HotbarManager getHotbarManager() -> aB
    2797:2797:net.minecraft.client.resources.PaintingTextureManager getPaintingTextures() -> aD
    2801:2801:net.minecraft.client.resources.MobEffectTextureManager getMobEffectTextures() -> aE
    2805:2805:net.minecraft.client.resources.MapDecorationTextureManager getMapDecorationTextures() -> aF
    2809:2809:net.minecraft.client.gui.GuiSpriteManager getGuiSprites() -> aG
    2814:2815:void setWindowActive(boolean) -> a
    2818:2897:net.minecraft.network.chat.Component grabPanoramixScreenshot(java.io.File,int,int) -> a
    2903:2937:net.minecraft.network.chat.Component grabHugeScreenshot(java.io.File,int,int,int,int) -> a
    2942:2942:net.minecraft.util.profiling.ProfilerFiller getProfiler() -> aH
    2947:2947:net.minecraft.server.level.progress.StoringChunkProgressListener getProgressListener() -> aI
    2951:2951:net.minecraft.client.resources.SplashManager getSplashManager() -> aJ
    2956:2956:net.minecraft.client.gui.screens.Overlay getOverlay() -> aK
    2960:2960:net.minecraft.client.gui.screens.social.PlayerSocialManager getPlayerSocialManager() -> aL
    2968:2968:net.minecraft.client.gui.components.DebugScreenOverlay getDebugOverlay() -> aN
    2972:2972:net.minecraft.client.renderer.RenderBuffers renderBuffers() -> aO
    2976:2977:void updateMaxMipLevel(int) -> b
    2980:2980:net.minecraft.client.model.geom.EntityModelSet getEntityModels() -> aP
    2984:2984:boolean isTextFilteringEnabled() -> aQ
    2988:2991:void prepareForMultiplayer() -> aR
    2995:2995:net.minecraft.util.SignatureValidator getProfileKeySignatureValidator() -> aS
    2999:2999:boolean canValidateProfileKeys() -> aT
    3003:3003:net.minecraft.client.InputType getLastInputType() -> aU
    3007:3008:void setLastInputType(net.minecraft.client.InputType) -> a
    3011:3011:net.minecraft.client.GameNarrator getNarrator() -> aV
    3015:3015:net.minecraft.client.multiplayer.chat.ChatListener getChatListener() -> aW
    3019:3019:net.minecraft.client.multiplayer.chat.report.ReportingContext getReportingContext() -> aX
    3023:3023:com.mojang.realmsclient.gui.RealmsDataFetcher realmsDataFetcher() -> aY
    3027:3027:net.minecraft.client.quickplay.QuickPlayLog quickPlayLog() -> aZ
    3031:3031:net.minecraft.client.CommandHistory commandHistory() -> ba
    3035:3035:net.minecraft.world.level.validation.DirectoryValidator directoryValidator() -> bb
    3039:3045:float getTickTargetMillis(float) -> a
    3095:3095:java.lang.String getLauncherBrand() -> bc
    2932:2932:net.minecraft.network.chat.Style lambda$grabHugeScreenshot$55(java.io.File,net.minecraft.network.chat.Style) -> a
    2875:2875:net.minecraft.network.chat.Style lambda$grabPanoramixScreenshot$54(java.io.File,net.minecraft.network.chat.Style) -> b
    2872:2872:void lambda$grabPanoramixScreenshot$53(net.minecraft.network.chat.Component) -> b
    2582:2582:java.util.concurrent.CompletionStage lambda$delayTextureReload$52(java.util.concurrent.CompletableFuture) -> a
    2572:2572:java.lang.String lambda$fillSystemReport$51() -> bs
    2571:2571:java.lang.String lambda$fillSystemReport$50() -> bt
    2568:2568:java.lang.String lambda$fillSystemReport$49(net.minecraft.client.resources.language.LanguageManager) -> a
    2564:2564:java.lang.String lambda$fillSystemReport$48(net.minecraft.client.Minecraft) -> a
    2550:2550:java.lang.String lambda$fillSystemReport$47(net.minecraft.client.Minecraft) -> b
    2549:2549:java.lang.String lambda$fillSystemReport$46() -> bu
    2548:2548:java.lang.String lambda$fillSystemReport$45() -> bv
    2544:2544:java.lang.String lambda$fillSystemReport$44(net.minecraft.client.Minecraft) -> c
    2537:2537:java.lang.String lambda$fillSystemReport$43(java.lang.String) -> b
    2533:2533:java.lang.String lambda$fillUptime$42() -> bD
    2531:2531:java.lang.String lambda$fillUptime$41() -> bE
    2529:2529:java.lang.String lambda$fillUptime$40() -> bF
    2527:2527:java.lang.String lambda$fillUptime$39() -> bG
    2202:2202:boolean lambda$setLevel$38() -> bH
    2195:2195:void lambda$doWorldLoad$37(net.minecraft.network.chat.Component) -> c
    2166:2166:java.lang.String lambda$doWorldLoad$36(net.minecraft.server.WorldStem) -> a
    2153:2153:net.minecraft.client.server.IntegratedServer lambda$doWorldLoad$35(net.minecraft.world.level.storage.LevelStorageSource$LevelStorageAccess,net.minecraft.server.packs.repository.PackRepository,net.minecraft.server.WorldStem,net.minecraft.server.Services,java.lang.Thread) -> a
    2154:2156:net.minecraft.server.level.progress.ChunkProgressListener lambda$doWorldLoad$34(int) -> c
    1983:1983:boolean lambda$tick$33() -> bI
    1930:1930:void lambda$tick$32() -> bJ
    1512:1514:void lambda$debugClientMetricsStart$31(java.util.function.Consumer,net.minecraft.util.profiling.ProfileResults) -> a
    1503:1503:void lambda$debugClientMetricsStart$30(net.minecraft.util.profiling.ProfileResults) -> a
    1499:1499:void lambda$debugClientMetricsStart$29(java.util.function.Consumer,java.util.concurrent.CompletableFuture,java.util.concurrent.CompletableFuture) -> a
    1491:1491:void lambda$debugClientMetricsStart$28(java.util.function.Consumer,java.nio.file.Path) -> a
    1486:1488:void lambda$debugClientMetricsStart$27(net.minecraft.SystemReport,java.util.function.Consumer,java.util.List) -> a
    1475:1482:void lambda$debugClientMetricsStart$26(java.util.function.Consumer,java.nio.file.Path) -> b
    1480:1480:void lambda$debugClientMetricsStart$25(java.util.function.Consumer,net.minecraft.network.chat.Component) -> a
    1477:1477:net.minecraft.network.chat.Style lambda$debugClientMetricsStart$24(java.nio.file.Path,net.minecraft.network.chat.Style) -> a
    1462:1472:void lambda$debugClientMetricsStart$23(java.util.function.Consumer,net.minecraft.util.profiling.ProfileResults) -> b
    1470:1470:void lambda$debugClientMetricsStart$22(java.util.function.Consumer,double,int) -> a
    1303:1303:void lambda$runTick$21(com.mojang.blaze3d.systems.TimerQuery) -> a
    1228:1228:void lambda$runTick$20(java.util.concurrent.CompletableFuture) -> b
    1088:1092:void lambda$openChatScreen$19(boolean) -> e
    1006:1006:void lambda$reloadResourcePacks$18(boolean,net.minecraft.client.Minecraft$GameLoadCookie,java.util.concurrent.CompletableFuture,java.util.Optional) -> a
    1015:1020:void lambda$reloadResourcePacks$17(java.util.concurrent.CompletableFuture,net.minecraft.client.Minecraft$GameLoadCookie) -> a
    1007:1014:void lambda$reloadResourcePacks$16(boolean,net.minecraft.client.Minecraft$GameLoadCookie,java.lang.Throwable) -> a
    938:938:net.minecraft.CrashReport lambda$delayCrashRaw$15(net.minecraft.CrashReport) -> e
    931:931:net.minecraft.CrashReport lambda$delayCrash$14(net.minecraft.CrashReport) -> f
    845:845:void lambda$clearResourcePacksOnError$13(net.minecraft.network.chat.Component) -> d
    769:769:net.minecraft.client.gui.screens.Screen lambda$addInitialScreens$12(com.mojang.authlib.GameProfile,java.lang.Runnable) -> a
    756:756:net.minecraft.client.gui.screens.Screen lambda$addInitialScreens$11(com.mojang.authlib.minecraft.BanDetails,java.lang.Runnable) -> a
    757:761:void lambda$addInitialScreens$10(java.lang.Runnable,boolean) -> a
    751:751:net.minecraft.client.gui.screens.Screen lambda$addInitialScreens$9(java.lang.Runnable) -> a
    743:743:void lambda$buildInitialScreens$8(net.minecraft.client.gui.screens.Screen) -> f
    734:739:void lambda$buildInitialScreens$7(net.minecraft.client.Minecraft$GameLoadCookie) -> d
    696:696:void lambda$new$6(net.minecraft.client.Minecraft$GameLoadCookie,java.util.Optional) -> a
    697:702:void lambda$new$5(net.minecraft.client.Minecraft$GameLoadCookie) -> e
    696:696:void lambda$new$4(net.minecraft.client.Minecraft$GameLoadCookie,java.lang.Throwable) -> a
    536:539:void lambda$new$3(net.minecraft.client.resources.language.ClientLanguage) -> a
    458:461:com.mojang.authlib.minecraft.UserApiService$UserProperties lambda$new$2() -> bK
    454:454:com.mojang.authlib.yggdrasil.ProfileResult lambda$new$1() -> bL
    405:405:int lambda$new$0() -> bM
 */
class Minecraft(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_client_Minecraft)
		fun getInstance(): Minecraft = Minecraft(clazz.getMethod("Q").invoke(null))
	}

	val font: Font
		get() = Font(clazz.getField("h").get(around))
	val level: ClientLevel?
		get() {
			val level = clazz.getField("r").get(around) ?: return null
			return ClientLevel(level)
		}

	fun getWindow(): Window = Window(
		clazz.getMethod("aM").invoke(around)
	)

	fun getModelManager(): ModelManager = ModelManager(
		clazz.getMethod("aC").invoke(around)
	)

	fun getItemRenderer(): ItemRenderer = ItemRenderer(
		clazz.getMethod("ar").invoke(around)
	)
}