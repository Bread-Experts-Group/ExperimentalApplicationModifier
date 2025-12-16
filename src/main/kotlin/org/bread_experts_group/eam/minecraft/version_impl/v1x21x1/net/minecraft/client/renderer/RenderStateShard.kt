package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_RenderStateShard
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_RenderStateShard_CullStateShard
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_RenderStateShard_ShaderStateShard
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_RenderStateShard_TexturingStateShard
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_RenderStateShard_TransparencyStateShard
import java.lang.constant.ClassDesc
import java.util.function.Supplier

/*
net.minecraft.client.renderer.RenderStateShard -> gfg:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    float VIEW_SCALE_Z_EPSILON -> aQ
    double MAX_ENCHANTMENT_GLINT_SPEED_MILLIS -> a
    java.lang.String name -> b
    java.lang.Runnable setupState -> aR
    java.lang.Runnable clearState -> aS
    net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard ADDITIVE_TRANSPARENCY -> d
    net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard LIGHTNING_TRANSPARENCY -> e
    net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard GLINT_TRANSPARENCY -> f
    net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard CRUMBLING_TRANSPARENCY -> g
    net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard TRANSLUCENT_TRANSPARENCY -> h
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard NO_SHADER -> i
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard POSITION_COLOR_LIGHTMAP_SHADER -> j
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard POSITION_SHADER -> k
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard POSITION_TEX_SHADER -> l
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard POSITION_COLOR_TEX_LIGHTMAP_SHADER -> m
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard POSITION_COLOR_SHADER -> n
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_SOLID_SHADER -> o
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_CUTOUT_MIPPED_SHADER -> p
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_CUTOUT_SHADER -> q
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_TRANSLUCENT_SHADER -> r
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_TRANSLUCENT_MOVING_BLOCK_SHADER -> s
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ARMOR_CUTOUT_NO_CULL_SHADER -> t
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_SOLID_SHADER -> u
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_CUTOUT_SHADER -> v
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_CUTOUT_NO_CULL_SHADER -> w
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_CUTOUT_NO_CULL_Z_OFFSET_SHADER -> x
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ITEM_ENTITY_TRANSLUCENT_CULL_SHADER -> y
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER -> z
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_TRANSLUCENT_SHADER -> A
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_TRANSLUCENT_EMISSIVE_SHADER -> B
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_SMOOTH_CUTOUT_SHADER -> C
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_BEACON_BEAM_SHADER -> D
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_DECAL_SHADER -> E
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_NO_OUTLINE_SHADER -> F
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_SHADOW_SHADER -> G
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_ALPHA_SHADER -> H
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_EYES_SHADER -> I
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENERGY_SWIRL_SHADER -> J
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_LEASH_SHADER -> K
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_WATER_MASK_SHADER -> L
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_OUTLINE_SHADER -> M
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ARMOR_ENTITY_GLINT_SHADER -> N
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_GLINT_TRANSLUCENT_SHADER -> O
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_GLINT_SHADER -> P
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_GLINT_SHADER -> Q
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_ENTITY_GLINT_DIRECT_SHADER -> R
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_CRUMBLING_SHADER -> S
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_TEXT_SHADER -> T
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_TEXT_BACKGROUND_SHADER -> U
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_TEXT_INTENSITY_SHADER -> V
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_TEXT_SEE_THROUGH_SHADER -> W
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_TEXT_BACKGROUND_SEE_THROUGH_SHADER -> X
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_TEXT_INTENSITY_SEE_THROUGH_SHADER -> Y
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_LIGHTNING_SHADER -> Z
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_TRIPWIRE_SHADER -> aa
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_END_PORTAL_SHADER -> ab
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_END_GATEWAY_SHADER -> ac
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_CLOUDS_SHADER -> ad
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_LINES_SHADER -> ae
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_GUI_SHADER -> af
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_GUI_OVERLAY_SHADER -> ag
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_GUI_TEXT_HIGHLIGHT_SHADER -> ah
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_GUI_GHOST_RECIPE_OVERLAY_SHADER -> ai
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard RENDERTYPE_BREEZE_WIND_SHADER -> aj
    net.minecraft.client.renderer.RenderStateShard$TextureStateShard BLOCK_SHEET_MIPPED -> ak
    net.minecraft.client.renderer.RenderStateShard$TextureStateShard BLOCK_SHEET -> al
    net.minecraft.client.renderer.RenderStateShard$EmptyTextureStateShard NO_TEXTURE -> am
    net.minecraft.client.renderer.RenderStateShard$TexturingStateShard DEFAULT_TEXTURING -> an
    net.minecraft.client.renderer.RenderStateShard$TexturingStateShard GLINT_TEXTURING -> ao
    net.minecraft.client.renderer.RenderStateShard$TexturingStateShard ENTITY_GLINT_TEXTURING -> ap
    net.minecraft.client.renderer.RenderStateShard$LightmapStateShard LIGHTMAP -> aq
    net.minecraft.client.renderer.RenderStateShard$LightmapStateShard NO_LIGHTMAP -> ar
    net.minecraft.client.renderer.RenderStateShard$OverlayStateShard OVERLAY -> as
    net.minecraft.client.renderer.RenderStateShard$OverlayStateShard NO_OVERLAY -> at
    net.minecraft.client.renderer.RenderStateShard$DepthTestStateShard NO_DEPTH_TEST -> aw
    net.minecraft.client.renderer.RenderStateShard$DepthTestStateShard EQUAL_DEPTH_TEST -> ax
    net.minecraft.client.renderer.RenderStateShard$DepthTestStateShard LEQUAL_DEPTH_TEST -> ay
    net.minecraft.client.renderer.RenderStateShard$DepthTestStateShard GREATER_DEPTH_TEST -> az
    net.minecraft.client.renderer.RenderStateShard$WriteMaskStateShard COLOR_DEPTH_WRITE -> aA
    net.minecraft.client.renderer.RenderStateShard$WriteMaskStateShard COLOR_WRITE -> aB
    net.minecraft.client.renderer.RenderStateShard$WriteMaskStateShard DEPTH_WRITE -> aC
    net.minecraft.client.renderer.RenderStateShard$LayeringStateShard NO_LAYERING -> aD
    net.minecraft.client.renderer.RenderStateShard$LayeringStateShard POLYGON_OFFSET_LAYERING -> aE
    net.minecraft.client.renderer.RenderStateShard$LayeringStateShard VIEW_OFFSET_Z_LAYERING -> aF
    net.minecraft.client.renderer.RenderStateShard$OutputStateShard MAIN_TARGET -> aG
    net.minecraft.client.renderer.RenderStateShard$OutputStateShard OUTLINE_TARGET -> aH
    net.minecraft.client.renderer.RenderStateShard$OutputStateShard TRANSLUCENT_TARGET -> aI
    net.minecraft.client.renderer.RenderStateShard$OutputStateShard PARTICLES_TARGET -> aJ
    net.minecraft.client.renderer.RenderStateShard$OutputStateShard WEATHER_TARGET -> aK
    net.minecraft.client.renderer.RenderStateShard$OutputStateShard CLOUDS_TARGET -> aL
    net.minecraft.client.renderer.RenderStateShard$OutputStateShard ITEM_ENTITY_TARGET -> aM
    net.minecraft.client.renderer.RenderStateShard$LineStateShard DEFAULT_LINE -> aN
    net.minecraft.client.renderer.RenderStateShard$ColorLogicStateShard NO_COLOR_LOGIC -> aO
    net.minecraft.client.renderer.RenderStateShard$ColorLogicStateShard OR_REVERSE_COLOR_LOGIC -> aP
    30:34:void <init>(java.lang.String,java.lang.Runnable,java.lang.Runnable) -> <init>
    37:38:void setupRenderState() -> a
    41:42:void clearRenderState() -> b
    46:46:java.lang.String toString() -> toString
    288:298:void setupGlintTexturing(float) -> a
 */
open class RenderStateShard(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_RenderStateShard)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = RenderStateShard::class.classDesc

		val NO_TRANSPARENCY: TransparencyStateShard
			get() = TransparencyStateShard(clazz.getField("c").get(null))
		val CULL: CullStateShard
			get() = CullStateShard(clazz.getField("au").get(null))
		val NO_CULL: CullStateShard
			get() = CullStateShard(clazz.getField("av").get(null))
	}

	/*
	net.minecraft.client.renderer.RenderStateShard$ShaderStateShard -> gfg$m:
    java.util.Optional shader -> aQ
    104:109:void <init>(java.util.function.Supplier) -> <init>
    112:117:void <init>() -> <init>
    121:121:java.lang.String toString() -> toString
    115:115:void lambda$new$4() -> c
    113:114:void lambda$new$3() -> d
    113:113:net.minecraft.client.renderer.ShaderInstance lambda$new$2() -> e
    107:107:void lambda$new$1() -> f
    105:106:void lambda$new$0(java.util.function.Supplier) -> a
	 */
	class ShaderStateShard private constructor(around: Any) : RenderStateShard(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_RenderStateShard_ShaderStateShard)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = ShaderStateShard::class.classDesc
		}

		constructor(supplier: Supplier<ShaderInstance>) : this(
			clazz.getConstructor(Supplier::class.java)
				.newInstance(Supplier<Any> { supplier.get().around })
		)
	}

	/*
	net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard -> gfg$p:
    51:52:void <init>(java.lang.String,java.lang.Runnable,java.lang.Runnable) -> <init>
	 */
	class TransparencyStateShard(around: Any) : RenderStateShard(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_RenderStateShard_TransparencyStateShard)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = TransparencyStateShard::class.classDesc
		}
	}

	/*
	net.minecraft.client.renderer.RenderStateShard$CullStateShard -> gfg$c:
    362:371:void <init>(boolean) -> <init>
    367:370:void lambda$new$1(boolean) -> a
    363:366:void lambda$new$0(boolean) -> b
	 */
	class CullStateShard(around: Any) : RenderStateShard(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_RenderStateShard_CullStateShard)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = CullStateShard::class.classDesc
		}
	}

	/*
	net.minecraft.client.renderer.RenderStateShard$TexturingStateShard -> gfg$o:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    267:268:void <init>(java.lang.String,java.lang.Runnable,java.lang.Runnable) -> <init>
	 */
	class TexturingStateShard(around: Any) : RenderStateShard(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_RenderStateShard_TexturingStateShard)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = TexturingStateShard::class.classDesc
		}

		constructor(name: String, setupState: Runnable, clearState: Runnable) : this(
			clazz.getConstructor(String::class.java, Runnable::class.java, Runnable::class.java)
				.newInstance(name, setupState, clearState)
		)
	}

	/*
	net.minecraft.client.renderer.RenderStateShard$BooleanStateShard -> gfg$a:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    boolean enabled -> aQ
    316:318:void <init>(java.lang.String,java.lang.Runnable,java.lang.Runnable,boolean) -> <init>
    322:322:java.lang.String toString() -> toString
net.minecraft.client.renderer.RenderStateShard$ColorLogicStateShard -> gfg$b:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    565:566:void <init>(java.lang.String,java.lang.Runnable,java.lang.Runnable) -> <init>
net.minecraft.client.renderer.RenderStateShard$DepthTestStateShard -> gfg$d:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    java.lang.String functionName -> aQ
    381:393:void <init>(java.lang.String,int) -> <init>
    397:397:java.lang.String toString() -> toString
    387:391:void lambda$new$1(int) -> a
    382:386:void lambda$new$0(int) -> b
net.minecraft.client.renderer.RenderStateShard$EmptyTextureStateShard -> gfg$e:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    183:184:void <init>(java.lang.Runnable,java.lang.Runnable) -> <init>
    187:188:void <init>() -> <init>
    191:191:java.util.Optional cutoutTexture() -> c
    187:187:void lambda$new$1() -> d
    187:187:void lambda$new$0() -> e
net.minecraft.client.renderer.RenderStateShard$LayeringStateShard -> gfg$f:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    442:443:void <init>(java.lang.String,java.lang.Runnable,java.lang.Runnable) -> <init>
net.minecraft.client.renderer.RenderStateShard$LightmapStateShard -> gfg$g:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    328:337:void <init>(boolean) -> <init>
    333:336:void lambda$new$1(boolean) -> a
    329:332:void lambda$new$0(boolean) -> b
net.minecraft.client.renderer.RenderStateShard$LineStateShard -> gfg$h:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    java.util.OptionalDouble width -> aQ
    539:553:void <init>(java.util.OptionalDouble) -> <init>
    557:557:java.lang.String toString() -> toString
    548:551:void lambda$new$1(java.util.OptionalDouble) -> a
    540:547:void lambda$new$0(java.util.OptionalDouble) -> b
net.minecraft.client.renderer.RenderStateShard$MultiTextureStateShard -> gfg$i:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    java.util.Optional cutoutTexture -> aQ
    199:208:void <init>(com.google.common.collect.ImmutableList) -> <init>
    212:212:java.util.Optional cutoutTexture() -> c
    216:216:net.minecraft.client.renderer.RenderStateShard$MultiTextureStateShard$Builder builder() -> d
    206:206:void lambda$new$1() -> e
    200:206:void lambda$new$0(com.google.common.collect.ImmutableList) -> a
net.minecraft.client.renderer.RenderStateShard$MultiTextureStateShard$Builder -> gfg$i$a:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    com.google.common.collect.ImmutableList$Builder builder -> a
    219:220:void <init>() -> <init>
    223:224:net.minecraft.client.renderer.RenderStateShard$MultiTextureStateShard$Builder add(net.minecraft.resources.ResourceLocation,boolean,boolean) -> a
    228:228:net.minecraft.client.renderer.RenderStateShard$MultiTextureStateShard build() -> a
net.minecraft.client.renderer.RenderStateShard$OffsetTexturingStateShard -> gfg$j:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    278:284:void <init>(float,float) -> <init>
    281:282:void lambda$new$1() -> c
    279:280:void lambda$new$0(float,float) -> a
net.minecraft.client.renderer.RenderStateShard$OutputStateShard -> gfg$k:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    471:472:void <init>(java.lang.String,java.lang.Runnable,java.lang.Runnable) -> <init>
net.minecraft.client.renderer.RenderStateShard$OverlayStateShard -> gfg$l:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    345:354:void <init>(boolean) -> <init>
    350:353:void lambda$new$1(boolean) -> a
    346:349:void lambda$new$0(boolean) -> b
net.minecraft.client.renderer.RenderStateShard$TextureStateShard -> gfg$n:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    java.util.Optional texture -> aQ
    boolean blur -> aR
    boolean mipmap -> aS
    239:248:void <init>(net.minecraft.resources.ResourceLocation,boolean,boolean) -> <init>
    252:252:java.lang.String toString() -> toString
    257:257:java.util.Optional cutoutTexture() -> c
    244:244:void lambda$new$1() -> d
    240:243:void lambda$new$0(net.minecraft.resources.ResourceLocation,boolean,boolean) -> a
net.minecraft.client.renderer.RenderStateShard$WriteMaskStateShard -> gfg$q:
# {"fileName":"RenderStateShard.java","id":"sourceFile"}
    boolean writeColor -> aQ
    boolean writeDepth -> aR
    411:428:void <init>(boolean,boolean) -> <init>
    432:432:java.lang.String toString() -> toString
    419:425:void lambda$new$1(boolean,boolean) -> a
    412:418:void lambda$new$0(boolean,boolean) -> b
	 */
}