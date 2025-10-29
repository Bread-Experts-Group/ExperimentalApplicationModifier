package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_MouseHandler
import java.lang.constant.ClassDesc

/*
net.minecraft.client.MouseHandler -> fgp:
# {"fileName":"MouseHandler.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> a
    net.minecraft.client.Minecraft minecraft -> b
    boolean isLeftPressed -> c
    boolean isMiddlePressed -> d
    boolean isRightPressed -> e
    double xpos -> f
    double ypos -> g
    int fakeRightMouse -> h
    int activeButton -> i
    boolean ignoreFirstMove -> j
    int clickDepth -> k
    double mousePressedTime -> l
    net.minecraft.util.SmoothDouble smoothTurnX -> m
    net.minecraft.util.SmoothDouble smoothTurnY -> n
    double accumulatedDX -> o
    double accumulatedDY -> p
    double accumulatedScrollX -> q
    double accumulatedScrollY -> r
    double lastHandleMovementTime -> s
    boolean mouseGrabbed -> t
    35:53:void <init>(net.minecraft.client.Minecraft) -> <init>
    56:130:void onPress(long,int,int,int) -> a
    133:181:void onScroll(long,double,double) -> a
    184:191:void onDrop(long,java.util.List,int) -> a
    194:216:void setup(long) -> a
    219:236:void onMove(long,double,double) -> b
    240:264:void handleAccumulatedMovement() -> a
    270:302:void turnPlayer(double) -> a
    305:305:boolean isLeftPressed() -> b
    309:309:boolean isMiddlePressed() -> c
    313:313:boolean isRightPressed() -> d
    317:317:double xpos() -> e
    321:321:double ypos() -> f
    325:326:void setIgnoreFirstMove() -> g
    331:331:boolean isMouseGrabbed() -> h
    335:351:void grabMouse() -> i
    354:361:void releaseMouse() -> j
    364:365:void cursorEntered() -> k
    254:254:void lambda$handleAccumulatedMovement$11(net.minecraft.client.gui.screens.Screen,double,double,double,double) -> a
    249:249:void lambda$handleAccumulatedMovement$10(net.minecraft.client.gui.screens.Screen,double,double) -> a
    199:214:void lambda$setup$9(long,int,long) -> a
    212:212:void lambda$setup$8(long,java.util.List,int) -> b
    197:197:void lambda$setup$7(long,double,double) -> c
    197:197:void lambda$setup$6(long,double,double) -> d
    196:196:void lambda$setup$5(long,int,int,int) -> b
    196:196:void lambda$setup$4(long,int,int,int) -> c
    195:195:void lambda$setup$3(long,double,double) -> e
    195:195:void lambda$setup$2(long,double,double) -> f
    109:109:void lambda$onPress$1(boolean[],net.minecraft.client.gui.screens.Screen,double,double,int) -> a
    107:107:void lambda$onPress$0(boolean[],net.minecraft.client.gui.screens.Screen,double,double,int) -> b
    22:22:void <clinit>() -> <clinit>
 */
class MouseHandler(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_MouseHandler)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = MouseHandler::class.classDesc
	}
}