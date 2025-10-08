package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_gui_GuiGraphics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_gui_GuiGraphics_ScissorStack

/*
926:985:void <clinit>() -> <clinit>
net.minecraft.client.gui.GuiGraphics -> fhz:
# {"fileName":"GuiGraphics.java","id":"sourceFile"}
    float MAX_GUI_Z -> a
    float MIN_GUI_Z -> b
    int EXTRA_SPACE_AFTER_FIRST_TOOLTIP_LINE -> c
    net.minecraft.client.Minecraft minecraft -> d
    com.mojang.blaze3d.vertex.PoseStack pose -> e
    net.minecraft.client.renderer.MultiBufferSource$BufferSource bufferSource -> f
    net.minecraft.client.gui.GuiGraphics$ScissorStack scissorStack -> g
    net.minecraft.client.gui.GuiSpriteManager sprites -> h
    boolean managed -> i
    69:79:void <init>(net.minecraft.client.Minecraft,com.mojang.blaze3d.vertex.PoseStack,net.minecraft.client.renderer.MultiBufferSource$BufferSource) -> <init>
    82:83:void <init>(net.minecraft.client.Minecraft,net.minecraft.client.renderer.MultiBufferSource$BufferSource) -> <init>
    89:94:void drawManaged(java.lang.Runnable) -> a
    98:101:void flushIfUnmanaged() -> g
    105:108:void flushIfManaged() -> h
    111:111:int guiWidth() -> a
    115:115:int guiHeight() -> b
    119:119:com.mojang.blaze3d.vertex.PoseStack pose() -> c
    123:123:net.minecraft.client.renderer.MultiBufferSource$BufferSource bufferSource() -> d
    129:132:void flush() -> e
    135:136:void hLine(int,int,int,int) -> a
    139:145:void hLine(net.minecraft.client.renderer.RenderType,int,int,int,int) -> a
    148:149:void vLine(int,int,int,int) -> b
    152:158:void vLine(net.minecraft.client.renderer.RenderType,int,int,int,int) -> b
    161:162:void enableScissor(int,int,int,int) -> c
    165:166:void disableScissor() -> f
    169:169:boolean containsPointInScissor(int,int) -> a
    173:187:void applyScissor(net.minecraft.client.gui.navigation.ScreenRectangle) -> a
    190:192:void setColor(float,float,float,float) -> a
    195:196:void fill(int,int,int,int,int) -> a
    199:200:void fill(int,int,int,int,int,int) -> a
    203:204:void fill(net.minecraft.client.renderer.RenderType,int,int,int,int,int) -> a
    207:224:void fill(net.minecraft.client.renderer.RenderType,int,int,int,int,int,int) -> a
    227:228:void fillGradient(int,int,int,int,int,int) -> b
    231:232:void fillGradient(int,int,int,int,int,int,int) -> a
    235:238:void fillGradient(net.minecraft.client.renderer.RenderType,int,int,int,int,int,int,int) -> a
    241:246:void fillGradient(com.mojang.blaze3d.vertex.VertexConsumer,int,int,int,int,int,int,int) -> a
    249:256:void fillRenderType(net.minecraft.client.renderer.RenderType,int,int,int,int,int) -> b
    259:260:void drawCenteredString(net.minecraft.client.gui.Font,java.lang.String,int,int,int) -> a
    263:265:void drawCenteredString(net.minecraft.client.gui.Font,net.minecraft.network.chat.Component,int,int,int) -> a
    268:269:void drawCenteredString(net.minecraft.client.gui.Font,net.minecraft.util.FormattedCharSequence,int,int,int) -> a
    276:282:int drawString(net.minecraft.client.gui.Font,java.lang.String,int,int,int,boolean) -> a
    286:286:int drawString(net.minecraft.client.gui.Font,net.minecraft.util.FormattedCharSequence,int,int,int) -> b
    290:292:int drawString(net.minecraft.client.gui.Font,net.minecraft.util.FormattedCharSequence,int,int,int,boolean) -> a
    296:296:int drawString(net.minecraft.client.gui.Font,net.minecraft.network.chat.Component,int,int,int) -> b
    300:300:int drawString(net.minecraft.client.gui.Font,net.minecraft.network.chat.Component,int,int,int,boolean) -> a
    304:308:void drawWordWrap(net.minecraft.client.gui.Font,net.minecraft.network.chat.FormattedText,int,int,int,int) -> a
    311:316:int drawStringWithBackdrop(net.minecraft.client.gui.Font,net.minecraft.network.chat.Component,int,int,int,int) -> a
    320:321:void blit(int,int,int,int,int,net.minecraft.client.renderer.texture.TextureAtlasSprite) -> a
    324:333:void blit(int,int,int,int,int,net.minecraft.client.renderer.texture.TextureAtlasSprite,float,float,float,float) -> a
    336:340:void renderOutline(int,int,int,int,int) -> b
    343:344:void blitSprite(net.minecraft.resources.ResourceLocation,int,int,int,int) -> a
    347:356:void blitSprite(net.minecraft.resources.ResourceLocation,int,int,int,int,int) -> a
    359:360:void blitSprite(net.minecraft.resources.ResourceLocation,int,int,int,int,int,int,int,int) -> a
    363:371:void blitSprite(net.minecraft.resources.ResourceLocation,int,int,int,int,int,int,int,int,int) -> a
    374:387:void blitSprite(net.minecraft.client.renderer.texture.TextureAtlasSprite,int,int,int,int,int,int,int,int,int) -> a
    390:401:void blitSprite(net.minecraft.client.renderer.texture.TextureAtlasSprite,int,int,int,int,int) -> a
    404:412:void blit(net.minecraft.resources.ResourceLocation,int,int,int,int,int,int) -> a
    415:424:void blit(net.minecraft.resources.ResourceLocation,int,int,int,float,float,int,int,int,int) -> a
    427:436:void blit(net.minecraft.resources.ResourceLocation,int,int,int,int,float,float,int,int,int,int) -> a
    439:440:void blit(net.minecraft.resources.ResourceLocation,int,int,float,float,int,int,int,int) -> a
    443:449:void blit(net.minecraft.resources.ResourceLocation,int,int,int,int,int,int,int,float,float,int,int) -> a
    452:463:void innerBlit(net.minecraft.resources.ResourceLocation,int,int,int,int,int,float,float,float,float) -> a
    466:480:void innerBlit(net.minecraft.resources.ResourceLocation,int,int,int,int,int,float,float,float,float,float,float,float,float) -> a
    483:521:void blitNineSlicedSprite(net.minecraft.client.renderer.texture.TextureAtlasSprite,net.minecraft.client.resources.metadata.gui.GuiSpriteScaling$NineSlice,int,int,int,int,int) -> a
    524:537:void blitTiledSprite(net.minecraft.client.renderer.texture.TextureAtlasSprite,int,int,int,int,int,int,int,int,int,int,int) -> a
    540:541:void renderItem(net.minecraft.world.item.ItemStack,int,int) -> a
    544:545:void renderItem(net.minecraft.world.item.ItemStack,int,int,int) -> a
    548:549:void renderItem(net.minecraft.world.item.ItemStack,int,int,int,int) -> a
    552:553:void renderFakeItem(net.minecraft.world.item.ItemStack,int,int) -> b
    556:557:void renderFakeItem(net.minecraft.world.item.ItemStack,int,int,int) -> b
    560:561:void renderItem(net.minecraft.world.entity.LivingEntity,net.minecraft.world.item.ItemStack,int,int,int) -> a
    564:565:void renderItem(net.minecraft.world.entity.LivingEntity,net.minecraft.world.level.Level,net.minecraft.world.item.ItemStack,int,int,int) -> a
    568:599:void renderItem(net.minecraft.world.entity.LivingEntity,net.minecraft.world.level.Level,net.minecraft.world.item.ItemStack,int,int,int,int) -> a
    602:603:void renderItemDecorations(net.minecraft.client.gui.Font,net.minecraft.world.item.ItemStack,int,int) -> a
    606:639:void renderItemDecorations(net.minecraft.client.gui.Font,net.minecraft.world.item.ItemStack,int,int,java.lang.String) -> a
    642:643:void renderTooltip(net.minecraft.client.gui.Font,net.minecraft.world.item.ItemStack,int,int) -> b
    646:652:void renderTooltip(net.minecraft.client.gui.Font,java.util.List,java.util.Optional,int,int) -> a
    655:656:void renderTooltip(net.minecraft.client.gui.Font,net.minecraft.network.chat.Component,int,int) -> a
    659:660:void renderComponentTooltip(net.minecraft.client.gui.Font,java.util.List,int,int) -> a
    663:664:void renderTooltip(net.minecraft.client.gui.Font,java.util.List,int,int) -> b
    667:668:void renderTooltip(net.minecraft.client.gui.Font,java.util.List,net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner,int,int) -> a
    671:718:void renderTooltipInternal(net.minecraft.client.gui.Font,java.util.List,int,int,net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner) -> a
    721:743:void renderComponentHoverEffect(net.minecraft.client.gui.Font,net.minecraft.network.chat.Style,int,int) -> a
    697:697:void lambda$renderTooltipInternal$4(int,int,int,int) -> d
    650:650:void lambda$renderTooltip$3(java.util.List,net.minecraft.world.inventory.tooltip.TooltipComponent) -> a
    594:594:java.lang.String lambda$renderItem$2(net.minecraft.world.item.ItemStack) -> a
    593:593:java.lang.String lambda$renderItem$1(net.minecraft.world.item.ItemStack) -> b
    592:592:java.lang.String lambda$renderItem$0(net.minecraft.world.item.ItemStack) -> c
*/

class GuiGraphics(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_client_gui_GuiGraphics)
	}

	fun pose(): PoseStack = PoseStack(
		clazz.getMethod("c").invoke(around)
	)

	fun drawString(font: Font, string: String, x: Int, y: Int, color: Int) {
		clazz.getMethod(
			"b",
			font.around::class.java,
			String::class.java,
			Int::class.java,
			Int::class.java,
			Int::class.java
		).invoke(around, font.around, string, x, y, color)
	}

	fun renderItem(stack: ItemStack, x: Int, y: Int) {
		clazz.getMethod("a", ItemStack.clazz, Int::class.java, Int::class.java)
			.invoke(around, stack.around, x, y)
	}

	/*
	net.minecraft.client.gui.GuiGraphics$ScissorStack -> fhz$a:
# {"fileName":"GuiGraphics.java","id":"sourceFile"}
    java.util.Deque stack -> a
    745:746:void <init>() -> <init>
    749:756:net.minecraft.client.gui.navigation.ScreenRectangle push(net.minecraft.client.gui.navigation.ScreenRectangle) -> a
    762:766:net.minecraft.client.gui.navigation.ScreenRectangle pop() -> a
    770:773:boolean containsPoint(int,int) -> a
    */
	class ScissorStack(around: Any) : MimickedClass(around) {
		companion object {
			val clazz: Class<*> = loadClass(net_minecraft_client_gui_GuiGraphics_ScissorStack)
		}

		constructor() : this(clazz.getConstructor().newInstance())
	}
}