package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_screens_Screen
import java.lang.constant.ClassDesc

/*
net.minecraft.client.gui.screens.Screen -> fod:
# {"fileName":"Screen.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> a
    net.minecraft.network.chat.Component USAGE_NARRATION -> b
    net.minecraft.client.renderer.CubeMap CUBE_MAP -> d
    net.minecraft.client.renderer.PanoramaRenderer PANORAMA -> e
    net.minecraft.resources.ResourceLocation MENU_BACKGROUND -> f
    net.minecraft.resources.ResourceLocation HEADER_SEPARATOR -> g
    net.minecraft.resources.ResourceLocation FOOTER_SEPARATOR -> h
    net.minecraft.resources.ResourceLocation INWORLD_MENU_BACKGROUND -> c
    net.minecraft.resources.ResourceLocation INWORLD_HEADER_SEPARATOR -> i
    net.minecraft.resources.ResourceLocation INWORLD_FOOTER_SEPARATOR -> j
    net.minecraft.network.chat.Component title -> k
    java.util.List children -> r
    java.util.List narratables -> s
    net.minecraft.client.Minecraft minecraft -> l
    boolean initialized -> u
    int width -> m
    int height -> n
    java.util.List renderables -> v
    net.minecraft.client.gui.Font font -> o
    long NARRATE_SUPPRESS_AFTER_INIT_TIME -> w
    long NARRATE_DELAY_NARRATOR_ENABLED -> x
    long NARRATE_DELAY_MOUSE_MOVE -> y
    long NARRATE_DELAY_MOUSE_ACTION -> z
    long NARRATE_DELAY_KEYBOARD_ACTION -> A
    net.minecraft.client.gui.narration.ScreenNarrationCollector narrationState -> B
    long narrationSuppressTime -> C
    long nextNarrationTime -> D
    net.minecraft.client.gui.components.CycleButton narratorButton -> p
    net.minecraft.client.gui.narration.NarratableEntry lastNarratable -> E
    net.minecraft.client.gui.screens.Screen$DeferredTooltipRendering deferredTooltipRendering -> F
    java.util.concurrent.Executor screenExecutor -> q
    72:106:void <init>(net.minecraft.network.chat.Component) -> <init>
    109:109:net.minecraft.network.chat.Component getTitle() -> n
    113:113:net.minecraft.network.chat.Component getNarrationMessage() -> i
    117:122:void renderWithTooltip(net.minecraft.client.gui.GuiGraphics,int,int,float) -> c
    126:130:void render(net.minecraft.client.gui.GuiGraphics,int,int,float) -> a
    134:160:boolean keyPressed(int,int,int) -> a
    164:165:net.minecraft.client.gui.navigation.FocusNavigationEvent$TabNavigation createTabEvent() -> m
    169:169:net.minecraft.client.gui.navigation.FocusNavigationEvent$ArrowNavigation createArrowEvent(net.minecraft.client.gui.navigation.ScreenDirection) -> a
    173:180:void setInitialFocus() -> aI_
    183:187:void setInitialFocus(net.minecraft.client.gui.components.events.GuiEventListener) -> b
    190:194:void clearFocus() -> o
    198:200:void changeFocus(net.minecraft.client.gui.ComponentPath) -> a
    203:203:boolean shouldCloseOnEsc() -> aJ_
    207:208:void onClose() -> d
    211:212:net.minecraft.client.gui.components.events.GuiEventListener addRenderableWidget(net.minecraft.client.gui.components.events.GuiEventListener) -> c
    216:217:net.minecraft.client.gui.components.Renderable addRenderableOnly(net.minecraft.client.gui.components.Renderable) -> a
    221:223:net.minecraft.client.gui.components.events.GuiEventListener addWidget(net.minecraft.client.gui.components.events.GuiEventListener) -> d
    227:234:void removeWidget(net.minecraft.client.gui.components.events.GuiEventListener) -> e
    237:240:void clearWidgets() -> p
    243:243:java.util.List getTooltipFromItem(net.minecraft.client.Minecraft,net.minecraft.world.item.ItemStack) -> a
    247:247:void insertText(java.lang.String,boolean) -> a_
    250:300:boolean handleComponentClicked(net.minecraft.network.chat.Style) -> a
    304:318:void init(net.minecraft.client.Minecraft,int,int) -> b
    321:325:void rebuildWidgets() -> q
    329:329:java.util.List children() -> aK_
    333:333:void init() -> aT_
    336:336:void tick() -> e
    339:339:void removed() -> j
    342:342:void added() -> aL_
    345:350:void renderBackground(net.minecraft.client.gui.GuiGraphics,int,int,float) -> b
    353:355:void renderBlurredBackground(float) -> a
    358:359:void renderPanorama(net.minecraft.client.gui.GuiGraphics,float) -> a
    362:363:void renderMenuBackground(net.minecraft.client.gui.GuiGraphics) -> a
    366:367:void renderMenuBackground(net.minecraft.client.gui.GuiGraphics,int,int,int,int) -> a
    370:374:void renderMenuBackgroundTexture(net.minecraft.client.gui.GuiGraphics,net.minecraft.resources.ResourceLocation,int,int,float,float,int,int) -> a
    377:378:void renderTransparentBackground(net.minecraft.client.gui.GuiGraphics) -> b
    381:381:boolean isPauseScreen() -> k
    386:390:boolean hasControlDown() -> r
    394:394:boolean hasShiftDown() -> s
    398:398:boolean hasAltDown() -> t
    402:402:boolean isCut(int) -> c
    406:406:boolean isPaste(int) -> d
    410:410:boolean isCopy(int) -> e
    414:414:boolean isSelectAll(int) -> f
    419:420:void repositionElements() -> c
    424:427:void resize(net.minecraft.client.Minecraft,int,int) -> a
    431:438:void wrapScreenError(java.lang.Runnable,java.lang.String,java.lang.String) -> a
    441:452:boolean isValidCharacterForName(java.lang.String,char,int) -> a
    457:457:boolean isMouseOver(double,double) -> c
    461:461:void onFilesDrop(java.util.List) -> a
    464:468:void scheduleNarration(long,boolean) -> a
    471:472:void suppressNarration(long) -> a
    475:476:void afterMouseMove() -> u
    479:480:void afterMouseAction() -> v
    483:484:void afterKeyboardAction() -> x
    487:487:boolean shouldRunNarration() -> C
    491:498:void handleDelayedNarration() -> y
    501:504:void triggerImmediateNarration(boolean) -> d
    507:512:void runNarration(boolean) -> c
    515:515:boolean shouldNarrateNavigation() -> aS_
    519:524:void updateNarrationState(net.minecraft.client.gui.narration.NarrationElementOutput) -> a
    527:546:void updateNarratedWidget(net.minecraft.client.gui.narration.NarrationElementOutput) -> b
    549:549:net.minecraft.network.chat.Component getUsageNarration() -> z
    554:570:net.minecraft.client.gui.screens.Screen$NarratableSearchResult findNarratableWidget(java.util.List,net.minecraft.client.gui.narration.NarratableEntry) -> a
    574:581:void updateNarratorStatus(boolean) -> e
    584:585:void clearTooltipForNextRenderPass() -> A
    588:589:void setTooltipForNextRenderPass(java.util.List) -> b
    592:595:void setTooltipForNextRenderPass(java.util.List,net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner,boolean) -> a
    598:599:void setTooltipForNextRenderPass(net.minecraft.network.chat.Component) -> d
    602:603:void setTooltipForNextRenderPass(net.minecraft.client.gui.components.Tooltip,net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner,boolean) -> a
    619:619:net.minecraft.client.gui.navigation.ScreenRectangle getRectangle() -> H
    624:624:net.minecraft.sounds.Music getBackgroundMusic() -> B
    435:435:java.lang.String lambda$wrapScreenError$3(java.lang.String) -> a
    268:272:void lambda$handleComponentClicked$2(java.net.URI,boolean) -> a
    98:98:void lambda$new$1(java.lang.Runnable) -> a
    99:102:void lambda$new$0(java.lang.Runnable) -> b
    58:83:void <clinit>() -> <clinit>
 */
class Screen(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_gui_screens_Screen)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Screen::class.classDesc
	}
}