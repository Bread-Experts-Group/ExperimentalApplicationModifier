package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_gui_Gui
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_gui_Gui_layers
import java.lang.constant.ClassDesc

/*
net.minecraft.client.gui.Gui -> fhy:
# {"fileName":"Gui.java","id":"sourceFile"}
    net.minecraft.resources.ResourceLocation CROSSHAIR_SPRITE -> b
    net.minecraft.resources.ResourceLocation CROSSHAIR_ATTACK_INDICATOR_FULL_SPRITE -> c
    net.minecraft.resources.ResourceLocation CROSSHAIR_ATTACK_INDICATOR_BACKGROUND_SPRITE -> d
    net.minecraft.resources.ResourceLocation CROSSHAIR_ATTACK_INDICATOR_PROGRESS_SPRITE -> e
    net.minecraft.resources.ResourceLocation EFFECT_BACKGROUND_AMBIENT_SPRITE -> f
    net.minecraft.resources.ResourceLocation EFFECT_BACKGROUND_SPRITE -> g
    net.minecraft.resources.ResourceLocation HOTBAR_SPRITE -> h
    net.minecraft.resources.ResourceLocation HOTBAR_SELECTION_SPRITE -> i
    net.minecraft.resources.ResourceLocation HOTBAR_OFFHAND_LEFT_SPRITE -> j
    net.minecraft.resources.ResourceLocation HOTBAR_OFFHAND_RIGHT_SPRITE -> k
    net.minecraft.resources.ResourceLocation HOTBAR_ATTACK_INDICATOR_BACKGROUND_SPRITE -> l
    net.minecraft.resources.ResourceLocation HOTBAR_ATTACK_INDICATOR_PROGRESS_SPRITE -> m
    net.minecraft.resources.ResourceLocation JUMP_BAR_BACKGROUND_SPRITE -> n
    net.minecraft.resources.ResourceLocation JUMP_BAR_COOLDOWN_SPRITE -> o
    net.minecraft.resources.ResourceLocation JUMP_BAR_PROGRESS_SPRITE -> p
    net.minecraft.resources.ResourceLocation EXPERIENCE_BAR_BACKGROUND_SPRITE -> q
    net.minecraft.resources.ResourceLocation EXPERIENCE_BAR_PROGRESS_SPRITE -> r
    net.minecraft.resources.ResourceLocation ARMOR_EMPTY_SPRITE -> s
    net.minecraft.resources.ResourceLocation ARMOR_HALF_SPRITE -> t
    net.minecraft.resources.ResourceLocation ARMOR_FULL_SPRITE -> u
    net.minecraft.resources.ResourceLocation FOOD_EMPTY_HUNGER_SPRITE -> v
    net.minecraft.resources.ResourceLocation FOOD_HALF_HUNGER_SPRITE -> w
    net.minecraft.resources.ResourceLocation FOOD_FULL_HUNGER_SPRITE -> x
    net.minecraft.resources.ResourceLocation FOOD_EMPTY_SPRITE -> y
    net.minecraft.resources.ResourceLocation FOOD_HALF_SPRITE -> z
    net.minecraft.resources.ResourceLocation FOOD_FULL_SPRITE -> A
    net.minecraft.resources.ResourceLocation AIR_SPRITE -> B
    net.minecraft.resources.ResourceLocation AIR_BURSTING_SPRITE -> C
    net.minecraft.resources.ResourceLocation HEART_VEHICLE_CONTAINER_SPRITE -> D
    net.minecraft.resources.ResourceLocation HEART_VEHICLE_FULL_SPRITE -> E
    net.minecraft.resources.ResourceLocation HEART_VEHICLE_HALF_SPRITE -> F
    net.minecraft.resources.ResourceLocation VIGNETTE_LOCATION -> G
    net.minecraft.resources.ResourceLocation PUMPKIN_BLUR_LOCATION -> H
    net.minecraft.resources.ResourceLocation SPYGLASS_SCOPE_LOCATION -> I
    net.minecraft.resources.ResourceLocation POWDER_SNOW_OUTLINE_LOCATION -> J
    java.util.Comparator SCORE_DISPLAY_ORDER -> K
    net.minecraft.network.chat.Component DEMO_EXPIRED_TEXT -> L
    net.minecraft.network.chat.Component SAVING_TEXT -> M
    float MIN_CROSSHAIR_ATTACK_SPEED -> N
    int NUM_HEARTS_PER_ROW -> O
    int LINE_HEIGHT -> P
    java.lang.String SPACER -> Q
    float PORTAL_OVERLAY_ALPHA_MIN -> R
    int HEART_SIZE -> S
    int HEART_SEPARATION -> T
    float AUTOSAVE_FADE_SPEED_FACTOR -> U
    net.minecraft.util.RandomSource random -> V
    net.minecraft.client.Minecraft minecraft -> W
    net.minecraft.client.gui.components.ChatComponent chat -> X
    int tickCount -> Y
    net.minecraft.network.chat.Component overlayMessageString -> Z
    int overlayMessageTime -> aa
    boolean animateOverlayMessageColor -> ab
    boolean chatDisabledByPlayerShown -> ac
    float vignetteBrightness -> a
    int toolHighlightTimer -> ad
    net.minecraft.world.item.ItemStack lastToolHighlight -> ae
    net.minecraft.client.gui.components.DebugScreenOverlay debugOverlay -> af
    net.minecraft.client.gui.components.SubtitleOverlay subtitleOverlay -> ag
    net.minecraft.client.gui.components.spectator.SpectatorGui spectatorGui -> ah
    net.minecraft.client.gui.components.PlayerTabOverlay tabList -> ai
    net.minecraft.client.gui.components.BossHealthOverlay bossOverlay -> aj
    int titleTime -> ak
    net.minecraft.network.chat.Component title -> al
    net.minecraft.network.chat.Component subtitle -> am
    int titleFadeInTime -> an
    int titleStayTime -> ao
    int titleFadeOutTime -> ap
    int lastHealth -> aq
    int displayHealth -> ar
    long lastHealthTime -> as
    long healthBlinkTime -> at
    float autosaveIndicatorValue -> au
    float lastAutosaveIndicatorValue -> av
    net.minecraft.client.gui.LayeredDraw layers -> aw
    float scopeScale -> ax
    129:205:void <init>(net.minecraft.client.Minecraft) -> <init>
    208:211:void resetTitleTimes() -> a
    217:220:void render(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> a
    223:252:void renderCameraOverlays(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> c
    255:271:void renderSleepOverlay(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> d
    274:300:void renderOverlayMessage(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> e
    303:344:void renderTitle(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> f
    347:353:void renderChat(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> g
    356:369:void renderScoreboardSidebar(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> h
    372:380:void renderTabList(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> i
    383:443:void renderCrosshair(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> j
    446:458:boolean canRenderCrosshairForSpectator(net.minecraft.world.phys.HitResult) -> a
    462:523:void renderEffects(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> k
    526:550:void renderHotbarAndDecorations(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> l
    553:617:void renderItemHotbar(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> m
    621:638:void renderJumpMeter(net.minecraft.world.entity.PlayerRideableJumping,net.minecraft.client.gui.GuiGraphics,int) -> a
    641:657:void renderExperienceBar(net.minecraft.client.gui.GuiGraphics,int) -> a
    660:675:void renderExperienceLevel(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> n
    678:678:boolean isExperienceBarVisible() -> m
    682:708:void renderSelectedItemName(net.minecraft.client.gui.GuiGraphics) -> a
    711:729:void renderDemoOverlay(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> o
    734:785:void displayScoreboardSidebar(net.minecraft.client.gui.GuiGraphics,net.minecraft.world.scores.Objective) -> a
    789:789:net.minecraft.world.entity.player.Player getCameraPlayer() -> n
    794:804:net.minecraft.world.entity.LivingEntity getPlayerVehicleWithHealth() -> o
    808:817:int getVehicleMaxHearts(net.minecraft.world.entity.LivingEntity) -> a
    821:821:int getVisibleVehicleHeartRows(int) -> a
    825:902:void renderPlayerHealth(net.minecraft.client.gui.GuiGraphics) -> b
    905:924:void renderArmor(net.minecraft.client.gui.GuiGraphics,net.minecraft.world.entity.player.Player,int,int,int,int) -> a
    1041:1083:void renderHearts(net.minecraft.client.gui.GuiGraphics,net.minecraft.world.entity.player.Player,int,int,int,int,float,int,int,int,boolean) -> a
    1086:1089:void renderHeart(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.gui.Gui$HeartType,int,int,boolean,boolean,boolean) -> a
    1092:1127:void renderFood(net.minecraft.client.gui.GuiGraphics,net.minecraft.world.entity.player.Player,int,int) -> a
    1130:1168:void renderVehicleHealth(net.minecraft.client.gui.GuiGraphics) -> c
    1171:1182:void renderTextureOverlay(net.minecraft.client.gui.GuiGraphics,net.minecraft.resources.ResourceLocation,float) -> a
    1185:1210:void renderSpyglassOverlay(net.minecraft.client.gui.GuiGraphics,float) -> a
    1213:1217:void updateVignetteBrightness(net.minecraft.world.entity.Entity) -> a
    1220:1255:void renderVignette(net.minecraft.client.gui.GuiGraphics,net.minecraft.world.entity.Entity) -> a
    1258:1276:void renderPortalOverlay(net.minecraft.client.gui.GuiGraphics,float) -> b
    1279:1300:void renderSlot(net.minecraft.client.gui.GuiGraphics,int,int,net.minecraft.client.DeltaTracker,net.minecraft.world.entity.player.Player,net.minecraft.world.item.ItemStack,int) -> a
    1303:1307:void tick(boolean) -> a
    1310:1341:void tick() -> p
    1344:1348:void tickAutosaveIndicator() -> q
    1351:1354:void setNowPlaying(net.minecraft.network.chat.Component) -> a
    1357:1361:void setOverlayMessage(net.minecraft.network.chat.Component,boolean) -> a
    1364:1365:void setChatDisabledByPlayerShown(boolean) -> b
    1368:1368:boolean isShowingChatDisabledByPlayer() -> b
    1372:1384:void setTimes(int,int,int) -> a
    1387:1388:void setSubtitle(net.minecraft.network.chat.Component) -> b
    1391:1393:void setTitle(net.minecraft.network.chat.Component) -> c
    1396:1399:void clear() -> c
    1402:1402:net.minecraft.client.gui.components.ChatComponent getChat() -> d
    1406:1406:int getGuiTicks() -> e
    1410:1410:net.minecraft.client.gui.Font getFont() -> f
    1414:1414:net.minecraft.client.gui.components.spectator.SpectatorGui getSpectatorGui() -> g
    1418:1418:net.minecraft.client.gui.components.PlayerTabOverlay getTabList() -> h
    1422:1428:void onDisconnected() -> i
    1431:1431:net.minecraft.client.gui.components.BossHealthOverlay getBossOverlay() -> j
    1435:1435:net.minecraft.client.gui.components.DebugScreenOverlay getDebugOverlay() -> k
    1439:1440:void clearCache() -> l
    1443:1454:void renderSavingIndicator(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> b
    761:784:void lambda$displayScoreboardSidebar$9(net.minecraft.client.gui.Gui$1DisplayEntry[],net.minecraft.client.gui.GuiGraphics,int,net.minecraft.network.chat.Component,int) -> a
    748:748:net.minecraft.client.gui.Gui$1DisplayEntry[] lambda$displayScoreboardSidebar$8(int) -> b
    741:746:net.minecraft.client.gui.Gui$1DisplayEntry lambda$displayScoreboardSidebar$7(net.minecraft.world.scores.Scoreboard,net.minecraft.network.chat.numbers.NumberFormat,net.minecraft.world.scores.PlayerScoreEntry) -> a
    737:737:boolean lambda$displayScoreboardSidebar$6(net.minecraft.world.scores.PlayerScoreEntry) -> a
    513:516:void lambda$renderEffects$5(net.minecraft.client.gui.GuiGraphics,float,int,int,net.minecraft.client.renderer.texture.TextureAtlasSprite) -> a
    204:204:boolean lambda$new$4(net.minecraft.client.Minecraft) -> a
    202:202:boolean lambda$new$3(net.minecraft.client.Minecraft) -> b
    199:199:void lambda$new$2(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> p
    190:193:void lambda$new$1(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> q
    185:185:void lambda$new$0(net.minecraft.client.gui.GuiGraphics,net.minecraft.client.DeltaTracker) -> r
    77:116:void <clinit>() -> <clinit>
net.minecraft.client.gui.Gui$1DisplayEntry -> fhy$a:
# {"fileName":"Gui.java","id":"sourceFile"}
    net.minecraft.network.chat.Component name -> a
    net.minecraft.network.chat.Component score -> b
    int scoreWidth -> c
    732:732:void <init>(net.minecraft.network.chat.Component,net.minecraft.network.chat.Component,int) -> <init>
    732:732:java.lang.String toString() -> toString
    732:732:int hashCode() -> hashCode
    732:732:boolean equals(java.lang.Object) -> equals
    732:732:net.minecraft.network.chat.Component name() -> a
    732:732:net.minecraft.network.chat.Component score() -> b
    732:732:int scoreWidth() -> c
net.minecraft.client.gui.Gui$HeartType -> fhy$b:
# {"fileName":"Gui.java","id":"sourceFile"}
    net.minecraft.client.gui.Gui$HeartType CONTAINER -> a
    net.minecraft.client.gui.Gui$HeartType NORMAL -> b
    net.minecraft.client.gui.Gui$HeartType POISIONED -> c
    net.minecraft.client.gui.Gui$HeartType WITHERED -> d
    net.minecraft.client.gui.Gui$HeartType ABSORBING -> e
    net.minecraft.client.gui.Gui$HeartType FROZEN -> f
    net.minecraft.resources.ResourceLocation full -> g
    net.minecraft.resources.ResourceLocation fullBlinking -> h
    net.minecraft.resources.ResourceLocation half -> i
    net.minecraft.resources.ResourceLocation halfBlinking -> j
    net.minecraft.resources.ResourceLocation hardcoreFull -> k
    net.minecraft.resources.ResourceLocation hardcoreFullBlinking -> l
    net.minecraft.resources.ResourceLocation hardcoreHalf -> m
    net.minecraft.resources.ResourceLocation hardcoreHalfBlinking -> n
    net.minecraft.client.gui.Gui$HeartType[] $VALUES -> o
    926:926:net.minecraft.client.gui.Gui$HeartType[] values() -> values
    926:926:net.minecraft.client.gui.Gui$HeartType valueOf(java.lang.String) -> valueOf
    998:1007:void <init>(java.lang.String,int,net.minecraft.resources.ResourceLocation,net.minecraft.resources.ResourceLocation,net.minecraft.resources.ResourceLocation,net.minecraft.resources.ResourceLocation,net.minecraft.resources.ResourceLocation,net.minecraft.resources.ResourceLocation,net.minecraft.resources.ResourceLocation,net.minecraft.resources.ResourceLocation) -> <init>
    1010:1020:net.minecraft.resources.ResourceLocation getSprite(boolean,boolean,boolean) -> a
    1027:1036:net.minecraft.client.gui.Gui$HeartType forPlayer(net.minecraft.world.entity.player.Player) -> a
    926:926:net.minecraft.client.gui.Gui$HeartType[] $values() -> a
    926:985:void <clinit>() -> <clinit>
 */
class Gui(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_gui_Gui)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Gui::class.classDesc
	}

	val layers: LayeredDraw
		get() = LayeredDraw(clazz.getField(net_minecraft_client_gui_Gui_layers).get(around))
}