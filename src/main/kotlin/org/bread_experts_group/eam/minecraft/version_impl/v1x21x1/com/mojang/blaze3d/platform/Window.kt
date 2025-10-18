package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.platform

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com_mojang_blaze3d_platform_Window
import java.lang.constant.ClassDesc

/*
    100:100:void <clinit>() -> <clinit>
com.mojang.blaze3d.platform.Window -> fam:
# {"fileName":"Window.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> c
    int BASE_WIDTH -> a
    int BASE_HEIGHT -> b
    org.lwjgl.glfw.GLFWErrorCallback defaultErrorCallback -> d
    com.mojang.blaze3d.platform.WindowEventHandler eventHandler -> e
    com.mojang.blaze3d.platform.ScreenManager screenManager -> f
    long window -> g
    int windowedX -> h
    int windowedY -> i
    int windowedWidth -> j
    int windowedHeight -> k
    java.util.Optional preferredFullscreenVideoMode -> l
    boolean fullscreen -> m
    boolean actuallyFullscreen -> n
    int x -> o
    int y -> p
    int width -> q
    int height -> r
    int framebufferWidth -> s
    int framebufferHeight -> t
    int guiScaledWidth -> u
    int guiScaledHeight -> v
    double guiScale -> w
    java.lang.String errorSection -> x
    boolean dirty -> y
    int framerateLimit -> z
    boolean vsync -> A
    36:128:void <init>(com.mojang.blaze3d.platform.WindowEventHandler,com.mojang.blaze3d.platform.ScreenManager,com.mojang.blaze3d.platform.DisplayData,java.lang.String,java.lang.String) -> <init>
    131:139:java.lang.String getPlatform() -> a
    144:145:int getRefreshRate() -> b
    150:150:boolean shouldClose() -> c
    154:163:void checkGlfwError(java.util.function.BiConsumer) -> a
    167:197:void setIcon(net.minecraft.server.packs.PackResources,com.mojang.blaze3d.platform.IconSet) -> a
    200:201:void setErrorSection(java.lang.String) -> a
    206:207:void setBootErrorCallback() -> v
    210:212:void bootCrash(int,long) -> b
    216:221:void defaultErrorCallback(int,long) -> a
    224:228:void setDefaultErrorCallback() -> d
    231:234:void updateVsync(boolean) -> a
    238:243:void close() -> close
    246:248:void onMove(long,int,int) -> a
    251:266:void onFramebufferResize(long,int,int) -> b
    269:275:void refreshFramebufferSize() -> w
    278:280:void onResize(long,int,int) -> c
    283:286:void onFocus(long,boolean) -> a
    289:292:void onEnter(long,boolean) -> b
    295:296:void setFramerateLimit(int) -> a
    299:299:int getFramerateLimit() -> e
    303:308:void updateDisplay() -> f
    311:311:java.util.Optional getPreferredFullscreenVideoMode() -> g
    315:320:void setPreferredFullscreenVideoMode(java.util.Optional) -> a
    323:328:void changeFullscreenVideoMode() -> h
    333:368:void setMode() -> x
    371:372:void toggleFullScreen() -> i
    375:379:void setWindowed(int,int) -> a
    382:391:void updateFullscreen(boolean) -> c
    394:401:int calculateScale(int,boolean) -> a
    405:410:void setGuiScale(double) -> a
    413:414:void setTitle(java.lang.String) -> b
    417:417:long getWindow() -> j
    421:421:boolean isFullscreen() -> k
    425:425:int getWidth() -> l
    429:429:int getHeight() -> m
    433:434:void setWidth(int) -> b
    437:438:void setHeight(int) -> c
    441:441:int getScreenWidth() -> n
    445:445:int getScreenHeight() -> o
    449:449:int getGuiScaledWidth() -> p
    453:453:int getGuiScaledHeight() -> q
    457:457:int getX() -> r
    461:461:int getY() -> s
    465:465:double getGuiScale() -> t
    470:470:com.mojang.blaze3d.platform.Monitor findBestMonitor() -> u
    474:475:void updateRawMouseInput(boolean) -> b
 */
class Window(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_blaze3d_platform_Window)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Window::class.classDesc
	}

	fun setTitle(title: String) {
		clazz.getMethod("b", String::class.java).invoke(around, title)
	}
}