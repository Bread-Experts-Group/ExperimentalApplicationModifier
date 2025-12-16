package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.systems

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.com_mojang_blaze3d_systems_RenderSystem
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.pipeline.RenderCall
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.org.joml.Matrix4f
import java.lang.constant.ClassDesc

/*
com.mojang.blaze3d.systems.RenderSystem -> com.mojang.blaze3d.systems.RenderSystem:
# {"fileName":"RenderSystem.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> LOGGER
    java.util.concurrent.ConcurrentLinkedQueue recordingQueue -> recordingQueue
    com.mojang.blaze3d.vertex.Tesselator RENDER_THREAD_TESSELATOR -> RENDER_THREAD_TESSELATOR
    int MINIMUM_ATLAS_TEXTURE_SIZE -> MINIMUM_ATLAS_TEXTURE_SIZE
    java.lang.Thread renderThread -> renderThread
    int MAX_SUPPORTED_TEXTURE_SIZE -> MAX_SUPPORTED_TEXTURE_SIZE
    boolean isInInit -> isInInit
    double lastDrawTime -> lastDrawTime
    com.mojang.blaze3d.systems.RenderSystem$AutoStorageIndexBuffer sharedSequential -> sharedSequential
    com.mojang.blaze3d.systems.RenderSystem$AutoStorageIndexBuffer sharedSequentialQuad -> sharedSequentialQuad
    com.mojang.blaze3d.systems.RenderSystem$AutoStorageIndexBuffer sharedSequentialLines -> sharedSequentialLines
    org.joml.Matrix4f projectionMatrix -> projectionMatrix
    org.joml.Matrix4f savedProjectionMatrix -> savedProjectionMatrix
    com.mojang.blaze3d.vertex.VertexSorting vertexSorting -> vertexSorting
    com.mojang.blaze3d.vertex.VertexSorting savedVertexSorting -> savedVertexSorting
    org.joml.Matrix4fStack modelViewStack -> modelViewStack
    org.joml.Matrix4f modelViewMatrix -> modelViewMatrix
    org.joml.Matrix4f textureMatrix -> textureMatrix
    int[] shaderTextures -> shaderTextures
    float[] shaderColor -> shaderColor
    float shaderGlintAlpha -> shaderGlintAlpha
    float shaderFogStart -> shaderFogStart
    float shaderFogEnd -> shaderFogEnd
    float[] shaderFogColor -> shaderFogColor
    com.mojang.blaze3d.shaders.FogShape shaderFogShape -> shaderFogShape
    org.joml.Vector3f[] shaderLightDirections -> shaderLightDirections
    float shaderGameTime -> shaderGameTime
    float shaderLineWidth -> shaderLineWidth
    java.lang.String apiDescription -> apiDescription
    net.minecraft.client.renderer.ShaderInstance shader -> shader
    java.util.concurrent.atomic.AtomicLong pollEventsWaitStart -> pollEventsWaitStart
    java.util.concurrent.atomic.AtomicBoolean pollingEvents -> pollingEvents
    45:45:void <init>() -> <init>
    112:116:void initRenderThread() -> initRenderThread
    119:119:boolean isOnRenderThread() -> isOnRenderThread
    123:123:boolean isOnRenderThreadOrInit() -> isOnRenderThreadOrInit
    127:130:void assertOnRenderThreadOrInit() -> assertOnRenderThreadOrInit
    134:137:void assertOnRenderThread() -> assertOnRenderThread
    140:140:java.lang.IllegalStateException constructThreadException() -> constructThreadException
    144:145:void recordRenderCall(com.mojang.blaze3d.pipeline.RenderCall) -> recordRenderCall
    148:153:void pollEvents() -> pollEvents
    156:156:boolean isFrozenAtPollEvents() -> isFrozenAtPollEvents
    161:169:void flipFrame(long) -> flipFrame
    172:176:void replayQueue() -> replayQueue
    181:188:void limitDisplayFPS(int) -> limitDisplayFPS
    192:194:void disableDepthTest() -> disableDepthTest
    197:198:void enableDepthTest() -> enableDepthTest
    201:203:void enableScissor(int,int,int,int) -> enableScissor
    206:207:void disableScissor() -> disableScissor
    210:212:void depthFunc(int) -> depthFunc
    215:217:void depthMask(boolean) -> depthMask
    220:222:void enableBlend() -> enableBlend
    226:228:void disableBlend() -> disableBlend
    231:233:void blendFunc(com.mojang.blaze3d.platform.GlStateManager$SourceFactor,com.mojang.blaze3d.platform.GlStateManager$DestFactor) -> blendFunc
    236:238:void blendFunc(int,int) -> blendFunc
    241:243:void blendFuncSeparate(com.mojang.blaze3d.platform.GlStateManager$SourceFactor,com.mojang.blaze3d.platform.GlStateManager$DestFactor,com.mojang.blaze3d.platform.GlStateManager$SourceFactor,com.mojang.blaze3d.platform.GlStateManager$DestFactor) -> blendFuncSeparate
    246:248:void blendFuncSeparate(int,int,int,int) -> blendFuncSeparate
    251:253:void blendEquation(int) -> blendEquation
    261:263:void disableCull() -> disableCull
    267:269:void polygonMode(int,int) -> polygonMode
    272:274:void enablePolygonOffset() -> enablePolygonOffset
    277:279:void disablePolygonOffset() -> disablePolygonOffset
    282:284:void polygonOffset(float,float) -> polygonOffset
    287:289:void enableColorLogicOp() -> enableColorLogicOp
    292:294:void disableColorLogicOp() -> disableColorLogicOp
    297:299:void logicOp(com.mojang.blaze3d.platform.GlStateManager$LogicOp) -> logicOp
    303:305:void activeTexture(int) -> activeTexture
    308:309:void texParameter(int,int,int) -> texParameter
    312:313:void deleteTexture(int) -> deleteTexture
    316:317:void bindTextureForSetup(int) -> bindTextureForSetup
    320:321:void bindTexture(int) -> bindTexture
    324:325:void viewport(int,int,int,int) -> viewport
    329:331:void colorMask(boolean,boolean,boolean,boolean) -> colorMask
    335:337:void stencilFunc(int,int,int) -> stencilFunc
    340:342:void stencilMask(int) -> stencilMask
    345:347:void stencilOp(int,int,int) -> stencilOp
    351:352:void clearDepth(double) -> clearDepth
    355:356:void clearColor(float,float,float,float) -> clearColor
    359:361:void clearStencil(int) -> clearStencil
    368:370:void setShaderFogStart(float) -> setShaderFogStart
    373:374:float getShaderFogStart() -> getShaderFogStart
    378:379:void setShaderGlintAlpha(double) -> setShaderGlintAlpha
    382:384:void setShaderGlintAlpha(float) -> setShaderGlintAlpha
    387:388:float getShaderGlintAlpha() -> getShaderGlintAlpha
    392:394:void setShaderFogEnd(float) -> setShaderFogEnd
    397:398:float getShaderFogEnd() -> getShaderFogEnd
    402:407:void setShaderFogColor(float,float,float,float) -> setShaderFogColor
    410:411:void setShaderFogColor(float,float,float) -> setShaderFogColor
    414:415:float[] getShaderFogColor() -> getShaderFogColor
    419:421:void setShaderFogShape(com.mojang.blaze3d.shaders.FogShape) -> setShaderFogShape
    424:425:com.mojang.blaze3d.shaders.FogShape getShaderFogShape() -> getShaderFogShape
    429:432:void setShaderLights(org.joml.Vector3f,org.joml.Vector3f) -> setShaderLights
    435:442:void setupShaderLights(net.minecraft.client.renderer.ShaderInstance) -> setupShaderLights
    445:452:void setShaderColor(float,float,float,float) -> setShaderColor
    455:459:void _setShaderColor(float,float,float,float) -> _setShaderColor
    462:463:float[] getShaderColor() -> getShaderColor
    467:469:void drawElements(int,int,int) -> drawElements
    472:479:void lineWidth(float) -> lineWidth
    482:483:float getShaderLineWidth() -> getShaderLineWidth
    487:488:void pixelStore(int,int) -> pixelStore
    491:493:void readPixels(int,int,int,int,int,int,java.nio.ByteBuffer) -> readPixels
    496:498:void getString(int,java.util.function.Consumer) -> getString
    501:501:java.lang.String getBackendDescription() -> getBackendDescription
    505:505:java.lang.String getApiDescription() -> getApiDescription
    509:509:net.minecraft.util.TimeSource$NanoTimeSource initBackendSystem() -> initBackendSystem
    513:515:void initRenderer(int,boolean) -> initRenderer
    518:519:void setErrorCallback(org.lwjgl.glfw.GLFWErrorCallbackI) -> setErrorCallback
    522:524:void renderCrosshair(int) -> renderCrosshair
    527:528:java.lang.String getCapsString() -> getCapsString
    532:544:void setupDefaultState(int,int,int,int) -> setupDefaultState
    547:562:int maxSupportedTextureSize() -> maxSupportedTextureSize
    566:567:void glBindBuffer(int,int) -> glBindBuffer
    570:571:void glBindVertexArray(int) -> glBindVertexArray
    574:576:void glBufferData(int,java.nio.ByteBuffer,int) -> glBufferData
    579:581:void glDeleteBuffers(int) -> glDeleteBuffers
    584:586:void glDeleteVertexArrays(int) -> glDeleteVertexArrays
    589:591:void glUniform1i(int,int) -> glUniform1i
    594:596:void glUniform1(int,java.nio.IntBuffer) -> glUniform1
    599:601:void glUniform2(int,java.nio.IntBuffer) -> glUniform2
    604:606:void glUniform3(int,java.nio.IntBuffer) -> glUniform3
    609:611:void glUniform4(int,java.nio.IntBuffer) -> glUniform4
    614:616:void glUniform1(int,java.nio.FloatBuffer) -> glUniform1
    619:621:void glUniform2(int,java.nio.FloatBuffer) -> glUniform2
    624:626:void glUniform3(int,java.nio.FloatBuffer) -> glUniform3
    629:631:void glUniform4(int,java.nio.FloatBuffer) -> glUniform4
    634:636:void glUniformMatrix2(int,boolean,java.nio.FloatBuffer) -> glUniformMatrix2
    639:641:void glUniformMatrix3(int,boolean,java.nio.FloatBuffer) -> glUniformMatrix3
    644:646:void glUniformMatrix4(int,boolean,java.nio.FloatBuffer) -> glUniformMatrix4
    649:651:void setupOverlayColor(int,int) -> setupOverlayColor
    654:656:void teardownOverlayColor() -> teardownOverlayColor
    659:661:void setupLevelDiffuseLighting(org.joml.Vector3f,org.joml.Vector3f) -> setupLevelDiffuseLighting
    664:666:void setupGuiFlatDiffuseLighting(org.joml.Vector3f,org.joml.Vector3f) -> setupGuiFlatDiffuseLighting
    669:671:void setupGui3DDiffuseLighting(org.joml.Vector3f,org.joml.Vector3f) -> setupGui3DDiffuseLighting
    674:675:void beginInitialization() -> beginInitialization
    678:685:void finishInitialization() -> finishInitialization
    688:695:void glGenBuffers(java.util.function.Consumer) -> glGenBuffers
    698:705:void glGenVertexArrays(java.util.function.Consumer) -> glGenVertexArrays
    708:709:com.mojang.blaze3d.vertex.Tesselator renderThreadTesselator() -> renderThreadTesselator
    713:714:void defaultBlendFunc() -> defaultBlendFunc
    718:730:void runAsFancy(java.lang.Runnable) -> runAsFancy
    733:740:void setShader(java.util.function.Supplier) -> setShader
    744:745:net.minecraft.client.renderer.ShaderInstance getShader() -> getShader
    749:756:void setShaderTexture(int,net.minecraft.resources.ResourceLocation) -> setShaderTexture
    759:764:void _setShaderTexture(int,net.minecraft.resources.ResourceLocation) -> _setShaderTexture
    767:774:void setShaderTexture(int,int) -> setShaderTexture
    777:780:void _setShaderTexture(int,int) -> _setShaderTexture
    783:787:int getShaderTexture(int) -> getShaderTexture
    791:801:void setProjectionMatrix(org.joml.Matrix4f,com.mojang.blaze3d.vertex.VertexSorting) -> setProjectionMatrix
    804:812:void setTextureMatrix(org.joml.Matrix4f) -> setTextureMatrix
    815:822:void resetTextureMatrix() -> resetTextureMatrix
    825:833:void applyModelViewMatrix() -> applyModelViewMatrix
    836:843:void backupProjectionMatrix() -> backupProjectionMatrix
    846:848:void _backupProjectionMatrix() -> _backupProjectionMatrix
    851:858:void restoreProjectionMatrix() -> restoreProjectionMatrix
    861:863:void _restoreProjectionMatrix() -> _restoreProjectionMatrix
    866:867:org.joml.Matrix4f getProjectionMatrix() -> getProjectionMatrix
    871:872:org.joml.Matrix4f getModelViewMatrix() -> getModelViewMatrix
    876:876:org.joml.Matrix4fStack getModelViewStack() -> getModelViewStack
    880:881:org.joml.Matrix4f getTextureMatrix() -> getTextureMatrix
    885:889:com.mojang.blaze3d.systems.RenderSystem$AutoStorageIndexBuffer getSequentialBuffer(com.mojang.blaze3d.vertex.VertexFormat$Mode) -> getSequentialBuffer
    894:902:void setShaderGameTime(long,float) -> setShaderGameTime
    905:906:float getShaderGameTime() -> getShaderGameTime
    910:911:com.mojang.blaze3d.vertex.VertexSorting getVertexSorting() -> getVertexSorting
    897:898:void lambda$setShaderGameTime$15(float) -> lambda$setShaderGameTime$15
    853:854:void lambda$restoreProjectionMatrix$14() -> lambda$restoreProjectionMatrix$14
    838:839:void lambda$backupProjectionMatrix$13() -> lambda$backupProjectionMatrix$13
    828:829:void lambda$applyModelViewMatrix$12(org.joml.Matrix4f) -> lambda$applyModelViewMatrix$12
    817:818:void lambda$resetTextureMatrix$11() -> lambda$resetTextureMatrix$11
    807:808:void lambda$setTextureMatrix$10(org.joml.Matrix4f) -> lambda$setTextureMatrix$10
    794:796:void lambda$setProjectionMatrix$9(org.joml.Matrix4f,com.mojang.blaze3d.vertex.VertexSorting) -> lambda$setProjectionMatrix$9
    769:770:void lambda$setShaderTexture$8(int,int) -> lambda$setShaderTexture$8
    751:752:void lambda$setShaderTexture$7(int,net.minecraft.resources.ResourceLocation) -> lambda$setShaderTexture$7
    735:736:void lambda$setShader$6(java.util.function.Supplier) -> lambda$setShader$6
    700:701:void lambda$glGenVertexArrays$5(java.util.function.Consumer) -> lambda$glGenVertexArrays$5
    690:691:void lambda$glGenBuffers$4(java.util.function.Consumer) -> lambda$glGenBuffers$4
    474:475:void lambda$lineWidth$3(float) -> lambda$lineWidth$3
    447:448:void lambda$setShaderColor$2(float,float,float,float) -> lambda$setShaderColor$2
    69:75:void lambda$static$1(it.unimi.dsi.fastutil.ints.IntConsumer,int) -> lambda$static$1
    61:67:void lambda$static$0(it.unimi.dsi.fastutil.ints.IntConsumer,int) -> lambda$static$0
 */
class RenderSystem(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_blaze3d_systems_RenderSystem)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = RenderSystem::class.classDesc

		fun isOnRenderThread(): Boolean = clazz.getMethod("isOnRenderThread").invoke(null) as Boolean

		fun recordRenderCall(runnable: () -> Unit) {
			clazz.getMethod("recordRenderCall", RenderCall.clazz)
				.invoke(null, RenderCall.createNative { runnable() })
		}

		fun getModelViewMatrix(): Matrix4f = Matrix4f(
			clazz.getMethod("getModelViewMatrix").invoke(null)
		)

		fun getProjectionMatrix(): Matrix4f = Matrix4f(
			clazz.getMethod("getProjectionMatrix").invoke(null)
		)

		fun executeOnRenderThread(runnable: () -> Unit) {
			if (!this.isOnRenderThread()) {
				this.recordRenderCall { runnable() }
			} else runnable()
		}

		fun clear(mask: Int, checkError: Boolean) {
			clazz.getMethod("clear", Int::class.java, Boolean::class.java)
				.invoke(null, mask, checkError)
		}

		fun enableCull() {
			clazz.getMethod("enableCull").invoke(null)
		}

		fun setShaderTexture(shaderTexture: Int, textureId: Int) {
			clazz.getMethod("setShaderTexture", Int::class.java, Int::class.java)
				.invoke(null, shaderTexture, textureId)
		}
	}
}