package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.VertexFormat
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_RenderType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_RenderType_CompositeRenderType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_RenderType_CompositeState
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_RenderType_CompositeState_CompositeStateBuilder
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.RenderType -> gfh:
# {"fileName":"RenderType.java","id":"sourceFile"}
    int MEGABYTE -> aV
    int BIG_BUFFER_SIZE -> aQ
    int SMALL_BUFFER_SIZE -> aR
    int TRANSIENT_BUFFER_SIZE -> aS
    net.minecraft.client.renderer.RenderType SOLID -> aW
    net.minecraft.client.renderer.RenderType CUTOUT_MIPPED -> aX
    net.minecraft.client.renderer.RenderType CUTOUT -> aY
    net.minecraft.client.renderer.RenderType TRANSLUCENT -> aZ
    net.minecraft.client.renderer.RenderType TRANSLUCENT_MOVING_BLOCK -> ba
    java.util.function.Function ARMOR_CUTOUT_NO_CULL -> bb
    java.util.function.Function ENTITY_SOLID -> bc
    java.util.function.Function ENTITY_CUTOUT -> bd
    java.util.function.BiFunction ENTITY_CUTOUT_NO_CULL -> be
    java.util.function.BiFunction ENTITY_CUTOUT_NO_CULL_Z_OFFSET -> bf
    java.util.function.Function ITEM_ENTITY_TRANSLUCENT_CULL -> bg
    java.util.function.Function ENTITY_TRANSLUCENT_CULL -> bh
    java.util.function.BiFunction ENTITY_TRANSLUCENT -> bi
    java.util.function.BiFunction ENTITY_TRANSLUCENT_EMISSIVE -> bj
    java.util.function.Function ENTITY_SMOOTH_CUTOUT -> bk
    java.util.function.BiFunction BEACON_BEAM -> bl
    java.util.function.Function ENTITY_DECAL -> bm
    java.util.function.Function ENTITY_NO_OUTLINE -> bn
    java.util.function.Function ENTITY_SHADOW -> bo
    java.util.function.Function DRAGON_EXPLOSION_ALPHA -> bp
    java.util.function.BiFunction EYES -> bq
    net.minecraft.client.renderer.RenderType LEASH -> br
    net.minecraft.client.renderer.RenderType WATER_MASK -> bs
    net.minecraft.client.renderer.RenderType ARMOR_ENTITY_GLINT -> bt
    net.minecraft.client.renderer.RenderType GLINT_TRANSLUCENT -> bu
    net.minecraft.client.renderer.RenderType GLINT -> bv
    net.minecraft.client.renderer.RenderType ENTITY_GLINT -> bw
    net.minecraft.client.renderer.RenderType ENTITY_GLINT_DIRECT -> bx
    java.util.function.Function CRUMBLING -> by
    java.util.function.Function TEXT -> bz
    net.minecraft.client.renderer.RenderType TEXT_BACKGROUND -> bA
    java.util.function.Function TEXT_INTENSITY -> bB
    java.util.function.Function TEXT_POLYGON_OFFSET -> bC
    java.util.function.Function TEXT_INTENSITY_POLYGON_OFFSET -> bD
    java.util.function.Function TEXT_SEE_THROUGH -> bE
    net.minecraft.client.renderer.RenderType TEXT_BACKGROUND_SEE_THROUGH -> bF
    java.util.function.Function TEXT_INTENSITY_SEE_THROUGH -> bG
    net.minecraft.client.renderer.RenderType LIGHTNING -> bH
    net.minecraft.client.renderer.RenderType DRAGON_RAYS -> bI
    net.minecraft.client.renderer.RenderType DRAGON_RAYS_DEPTH -> bJ
    net.minecraft.client.renderer.RenderType TRIPWIRE -> bK
    net.minecraft.client.renderer.RenderType END_PORTAL -> bL
    net.minecraft.client.renderer.RenderType END_GATEWAY -> bM
    net.minecraft.client.renderer.RenderType CLOUDS -> bN
    net.minecraft.client.renderer.RenderType CLOUDS_DEPTH_ONLY -> bO
    net.minecraft.client.renderer.RenderType$CompositeRenderType LINES -> aT
    net.minecraft.client.renderer.RenderType$CompositeRenderType LINE_STRIP -> aU
    java.util.function.Function DEBUG_LINE_STRIP -> bP
    net.minecraft.client.renderer.RenderType$CompositeRenderType DEBUG_FILLED_BOX -> bQ
    net.minecraft.client.renderer.RenderType$CompositeRenderType DEBUG_QUADS -> bR
    net.minecraft.client.renderer.RenderType$CompositeRenderType DEBUG_STRUCTURE_QUADS -> bS
    net.minecraft.client.renderer.RenderType$CompositeRenderType DEBUG_SECTION_QUADS -> bT
    net.minecraft.client.renderer.RenderType$CompositeRenderType GUI -> bU
    net.minecraft.client.renderer.RenderType$CompositeRenderType GUI_OVERLAY -> bV
    net.minecraft.client.renderer.RenderType$CompositeRenderType GUI_TEXT_HIGHLIGHT -> bW
    net.minecraft.client.renderer.RenderType$CompositeRenderType GUI_GHOST_RECIPE_OVERLAY -> bX
    com.google.common.collect.ImmutableList CHUNK_BUFFER_LAYERS -> bY
    com.mojang.blaze3d.vertex.VertexFormat format -> bZ
    com.mojang.blaze3d.vertex.VertexFormat$Mode mode -> ca
    int bufferSize -> cb
    boolean affectsCrumbling -> cc
    boolean sortOnUpload -> cd
    53:53:net.minecraft.client.renderer.RenderType solid() -> c
    63:63:net.minecraft.client.renderer.RenderType cutoutMipped() -> d
    73:73:net.minecraft.client.renderer.RenderType cutout() -> e
    77:83:net.minecraft.client.renderer.RenderType$CompositeState translucentState(net.minecraft.client.renderer.RenderStateShard$ShaderStateShard) -> a
    89:89:net.minecraft.client.renderer.RenderType translucent() -> f
    93:99:net.minecraft.client.renderer.RenderType$CompositeState translucentMovingBlockState() -> R
    105:105:net.minecraft.client.renderer.RenderType translucentMovingBlock() -> g
    111:122:net.minecraft.client.renderer.RenderType$CompositeRenderType createArmorCutoutNoCull(java.lang.String,net.minecraft.resources.ResourceLocation,boolean) -> a
    126:126:net.minecraft.client.renderer.RenderType armorCutoutNoCull(net.minecraft.resources.ResourceLocation) -> a
    130:130:net.minecraft.client.renderer.RenderType createArmorDecalCutoutNoCull(net.minecraft.resources.ResourceLocation) -> b
    146:146:net.minecraft.client.renderer.RenderType entitySolid(net.minecraft.resources.ResourceLocation) -> c
    162:162:net.minecraft.client.renderer.RenderType entityCutout(net.minecraft.resources.ResourceLocation) -> d
    179:179:net.minecraft.client.renderer.RenderType entityCutoutNoCull(net.minecraft.resources.ResourceLocation,boolean) -> a
    183:183:net.minecraft.client.renderer.RenderType entityCutoutNoCull(net.minecraft.resources.ResourceLocation) -> e
    201:201:net.minecraft.client.renderer.RenderType entityCutoutNoCullZOffset(net.minecraft.resources.ResourceLocation,boolean) -> b
    205:205:net.minecraft.client.renderer.RenderType entityCutoutNoCullZOffset(net.minecraft.resources.ResourceLocation) -> f
    223:223:net.minecraft.client.renderer.RenderType itemEntityTranslucentCull(net.minecraft.resources.ResourceLocation) -> g
    239:239:net.minecraft.client.renderer.RenderType entityTranslucentCull(net.minecraft.resources.ResourceLocation) -> h
    256:256:net.minecraft.client.renderer.RenderType entityTranslucent(net.minecraft.resources.ResourceLocation,boolean) -> c
    260:260:net.minecraft.client.renderer.RenderType entityTranslucent(net.minecraft.resources.ResourceLocation) -> i
    277:277:net.minecraft.client.renderer.RenderType entityTranslucentEmissive(net.minecraft.resources.ResourceLocation,boolean) -> d
    281:281:net.minecraft.client.renderer.RenderType entityTranslucentEmissive(net.minecraft.resources.ResourceLocation) -> j
    296:296:net.minecraft.client.renderer.RenderType entitySmoothCutout(net.minecraft.resources.ResourceLocation) -> k
    311:311:net.minecraft.client.renderer.RenderType beaconBeam(net.minecraft.resources.ResourceLocation,boolean) -> e
    328:328:net.minecraft.client.renderer.RenderType entityDecal(net.minecraft.resources.ResourceLocation) -> l
    346:346:net.minecraft.client.renderer.RenderType entityNoOutline(net.minecraft.resources.ResourceLocation) -> m
    366:366:net.minecraft.client.renderer.RenderType entityShadow(net.minecraft.resources.ResourceLocation) -> n
    380:380:net.minecraft.client.renderer.RenderType dragonExplosionAlpha(net.minecraft.resources.ResourceLocation) -> o
    394:394:net.minecraft.client.renderer.RenderType eyes(net.minecraft.resources.ResourceLocation) -> p
    398:398:net.minecraft.client.renderer.RenderType breezeEyes(net.minecraft.resources.ResourceLocation) -> q
    402:410:net.minecraft.client.renderer.RenderType breezeWind(net.minecraft.resources.ResourceLocation,float,float) -> a
    415:423:net.minecraft.client.renderer.RenderType energySwirl(net.minecraft.resources.ResourceLocation,float,float) -> b
    434:434:net.minecraft.client.renderer.RenderType leash() -> h
    444:444:net.minecraft.client.renderer.RenderType waterMask() -> i
    448:448:net.minecraft.client.renderer.RenderType outline(net.minecraft.resources.ResourceLocation) -> r
    463:463:net.minecraft.client.renderer.RenderType armorEntityGlint() -> j
    478:478:net.minecraft.client.renderer.RenderType glintTranslucent() -> k
    492:492:net.minecraft.client.renderer.RenderType glint() -> l
    507:507:net.minecraft.client.renderer.RenderType entityGlint() -> m
    521:521:net.minecraft.client.renderer.RenderType entityGlintDirect() -> n
    536:536:net.minecraft.client.renderer.RenderType crumbling(net.minecraft.resources.ResourceLocation) -> s
    561:561:net.minecraft.client.renderer.RenderType textBackground() -> o
    574:574:net.minecraft.client.renderer.RenderType textIntensity(net.minecraft.resources.ResourceLocation) -> u
    588:588:net.minecraft.client.renderer.RenderType textPolygonOffset(net.minecraft.resources.ResourceLocation) -> v
    602:602:net.minecraft.client.renderer.RenderType textIntensityPolygonOffset(net.minecraft.resources.ResourceLocation) -> w
    617:617:net.minecraft.client.renderer.RenderType textSeeThrough(net.minecraft.resources.ResourceLocation) -> x
    631:631:net.minecraft.client.renderer.RenderType textBackgroundSeeThrough() -> p
    646:646:net.minecraft.client.renderer.RenderType textIntensitySeeThrough(net.minecraft.resources.ResourceLocation) -> y
    657:657:net.minecraft.client.renderer.RenderType lightning() -> q
    667:667:net.minecraft.client.renderer.RenderType dragonRays() -> r
    676:676:net.minecraft.client.renderer.RenderType dragonRaysDepth() -> s
    680:686:net.minecraft.client.renderer.RenderType$CompositeState tripwireState() -> S
    692:692:net.minecraft.client.renderer.RenderType tripwire() -> t
    704:704:net.minecraft.client.renderer.RenderType endPortal() -> u
    716:716:net.minecraft.client.renderer.RenderType endGateway() -> v
    723:730:net.minecraft.client.renderer.RenderType$CompositeRenderType createClouds(boolean) -> a
    734:734:net.minecraft.client.renderer.RenderType clouds() -> w
    738:738:net.minecraft.client.renderer.RenderType cloudsDepthOnly() -> x
    752:752:net.minecraft.client.renderer.RenderType lines() -> y
    766:766:net.minecraft.client.renderer.RenderType lineStrip() -> z
    779:779:net.minecraft.client.renderer.RenderType debugLineStrip(double) -> a
    789:789:net.minecraft.client.renderer.RenderType debugFilledBox() -> A
    799:799:net.minecraft.client.renderer.RenderType debugQuads() -> B
    811:811:net.minecraft.client.renderer.RenderType debugStructureQuads() -> C
    822:822:net.minecraft.client.renderer.RenderType debugSectionQuads() -> D
    832:832:net.minecraft.client.renderer.RenderType gui() -> E
    843:843:net.minecraft.client.renderer.RenderType guiOverlay() -> F
    854:854:net.minecraft.client.renderer.RenderType guiTextHighlight() -> G
    865:865:net.minecraft.client.renderer.RenderType guiGhostRecipeOverlay() -> H
    877:883:void <init>(java.lang.String,com.mojang.blaze3d.vertex.VertexFormat,com.mojang.blaze3d.vertex.VertexFormat$Mode,int,boolean,boolean,java.lang.Runnable,java.lang.Runnable) -> <init>
    894:897:void draw(com.mojang.blaze3d.vertex.MeshData) -> a
    901:901:java.lang.String toString() -> toString
    905:905:java.util.List chunkBufferLayers() -> I
    909:909:int bufferSize() -> J
    913:913:com.mojang.blaze3d.vertex.VertexFormat format() -> K
    917:917:com.mojang.blaze3d.vertex.VertexFormat$Mode mode() -> L
    921:921:java.util.Optional outline() -> M
    925:925:boolean isOutline() -> N
    929:929:boolean affectsCrumbling() -> O
    933:933:boolean canConsolidateConsecutiveGeometry() -> P
    937:937:boolean sortOnUpload() -> Q
    770:775:net.minecraft.client.renderer.RenderType$CompositeRenderType lambda$static$23(java.lang.Double) -> a
    635:642:net.minecraft.client.renderer.RenderType lambda$static$22(net.minecraft.resources.ResourceLocation) -> z
    606:613:net.minecraft.client.renderer.RenderType lambda$static$21(net.minecraft.resources.ResourceLocation) -> A
    592:598:net.minecraft.client.renderer.RenderType lambda$static$20(net.minecraft.resources.ResourceLocation) -> B
    578:584:net.minecraft.client.renderer.RenderType lambda$static$19(net.minecraft.resources.ResourceLocation) -> C
    565:570:net.minecraft.client.renderer.RenderType lambda$static$18(net.minecraft.resources.ResourceLocation) -> D
    540:545:net.minecraft.client.renderer.RenderType lambda$static$17(net.minecraft.resources.ResourceLocation) -> E
    525:532:net.minecraft.client.renderer.RenderType lambda$static$16(net.minecraft.resources.ResourceLocation) -> F
    384:390:net.minecraft.client.renderer.RenderType lambda$static$15(net.minecraft.resources.ResourceLocation,net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard) -> a
    370:376:net.minecraft.client.renderer.RenderType lambda$static$14(net.minecraft.resources.ResourceLocation) -> G
    350:362:net.minecraft.client.renderer.RenderType lambda$static$13(net.minecraft.resources.ResourceLocation) -> H
    332:342:net.minecraft.client.renderer.RenderType lambda$static$12(net.minecraft.resources.ResourceLocation) -> I
    315:324:net.minecraft.client.renderer.RenderType lambda$static$11(net.minecraft.resources.ResourceLocation) -> J
    300:307:net.minecraft.client.renderer.RenderType lambda$static$10(net.minecraft.resources.ResourceLocation,java.lang.Boolean) -> a
    285:292:net.minecraft.client.renderer.RenderType lambda$static$9(net.minecraft.resources.ResourceLocation) -> K
    264:273:net.minecraft.client.renderer.RenderType lambda$static$8(net.minecraft.resources.ResourceLocation,java.lang.Boolean) -> b
    243:252:net.minecraft.client.renderer.RenderType lambda$static$7(net.minecraft.resources.ResourceLocation,java.lang.Boolean) -> c
    227:235:net.minecraft.client.renderer.RenderType lambda$static$6(net.minecraft.resources.ResourceLocation) -> L
    209:219:net.minecraft.client.renderer.RenderType lambda$static$5(net.minecraft.resources.ResourceLocation) -> M
    187:197:net.minecraft.client.renderer.RenderType lambda$static$4(net.minecraft.resources.ResourceLocation,java.lang.Boolean) -> d
    166:175:net.minecraft.client.renderer.RenderType lambda$static$3(net.minecraft.resources.ResourceLocation,java.lang.Boolean) -> e
    150:158:net.minecraft.client.renderer.RenderType lambda$static$2(net.minecraft.resources.ResourceLocation) -> N
    134:142:net.minecraft.client.renderer.RenderType lambda$static$1(net.minecraft.resources.ResourceLocation) -> O
    108:108:net.minecraft.client.renderer.RenderType lambda$static$0(net.minecraft.resources.ResourceLocation) -> P
    46:868:void <clinit>() -> <clinit>
 */
open class RenderType(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_RenderType)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = RenderType::class.classDesc

		const val BIG_BUFFER_SIZE: Int = 4194304
		const val SMALL_BUFFER_SIZE: Int = 786432
		const val TRANSIENT_BUFFER_SIZE: Int = 1536

		fun solid(): RenderType = RenderType(
			clazz.getMethod("c").invoke(null)
		)
		fun translucent(): RenderType = RenderType(
			clazz.getMethod("f").invoke(null)
		)
		fun text(location: ResourceLocation): RenderType = RenderType(
			clazz.getMethod("t", ResourceLocation.clazz)
				.invoke(null, location.around)
		)

/*
		create(java.lang.String,com.mojang.blaze3d.vertex.VertexFormat,com.mojang.blaze3d.vertex.VertexFormat$Mode,int,net.minecraft.client.renderer.RenderType$CompositeState) -> a
        create(java.lang.String,com.mojang.blaze3d.vertex.VertexFormat,com.mojang.blaze3d.vertex.VertexFormat$Mode,int,boolean,boolean,net.minecraft.client.renderer.RenderType$CompositeState) -> a
*/

		fun create(
			name: String,
			vertexFormat: VertexFormat,
			mode: VertexFormat.Mode,
			bufferSize: Int,
			state: CompositeState
		): CompositeRenderType = CompositeRenderType(
			clazz.getMethod(
				"a",
				String::class.java,
				VertexFormat.clazz,
				VertexFormat.Mode.clazz,
				Int::class.java,
				CompositeState.clazz
			).invoke(null, name, vertexFormat.around, mode.around, bufferSize, state.around)
		)

		fun create(
			name: String,
			vertexFormat: VertexFormat,
			mode: VertexFormat.Mode,
			bufferSize: Int,
			affectsCrumbling: Boolean,
			sortOnUpload: Boolean,
			state: CompositeState
		): CompositeRenderType = CompositeRenderType(
			clazz.getMethod(
				"a",
				String::class.java,
				VertexFormat.clazz,
				VertexFormat.Mode.clazz,
				Int::class.java,
				Boolean::class.java,
				Boolean::class.java,
				CompositeState.clazz
			).invoke(null, name, vertexFormat.around, mode.around, bufferSize, affectsCrumbling, sortOnUpload, state.around)
		)
	}

	/*
	net.minecraft.client.renderer.RenderType$CompositeRenderType -> gfh$a:
# {"fileName":"RenderType.java","id":"sourceFile"}
    java.util.function.BiFunction OUTLINE -> aV
    net.minecraft.client.renderer.RenderType$CompositeState state -> aW
    java.util.Optional outline -> aX
    boolean isOutline -> aY
    1109:1113:void <init>(java.lang.String,com.mojang.blaze3d.vertex.VertexFormat,com.mojang.blaze3d.vertex.VertexFormat$Mode,int,boolean,boolean,net.minecraft.client.renderer.RenderType$CompositeState) -> <init>
    1117:1117:java.util.Optional outline() -> M
    1122:1122:boolean isOutline() -> N
    1126:1126:net.minecraft.client.renderer.RenderType$CompositeState state() -> R
    1131:1131:java.lang.String toString() -> toString
    1111:1111:net.minecraft.client.renderer.RenderType lambda$new$3(net.minecraft.client.renderer.RenderType$CompositeState,net.minecraft.resources.ResourceLocation) -> a
    1109:1109:void lambda$new$2(net.minecraft.client.renderer.RenderType$CompositeState) -> a
    1109:1109:void lambda$new$1(net.minecraft.client.renderer.RenderType$CompositeState) -> b
    1095:1101:net.minecraft.client.renderer.RenderType lambda$static$0(net.minecraft.resources.ResourceLocation,net.minecraft.client.renderer.RenderStateShard$CullStateShard) -> a
    1094:1094:void <clinit>() -> <clinit>
	 */
	class CompositeRenderType(around: Any) : RenderType(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_RenderType_CompositeRenderType)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = CompositeRenderType::class.classDesc
		}
	}

	/*
	net.minecraft.client.renderer.RenderType$CompositeState -> gfh$b:
# {"fileName":"RenderType.java","id":"sourceFile"}
    net.minecraft.client.renderer.RenderStateShard$EmptyTextureStateShard textureState -> a
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard shaderState -> b
    net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard transparencyState -> c
    net.minecraft.client.renderer.RenderStateShard$DepthTestStateShard depthTestState -> d
    net.minecraft.client.renderer.RenderStateShard$CullStateShard cullState -> e
    net.minecraft.client.renderer.RenderStateShard$LightmapStateShard lightmapState -> f
    net.minecraft.client.renderer.RenderStateShard$OverlayStateShard overlayState -> g
    net.minecraft.client.renderer.RenderStateShard$LayeringStateShard layeringState -> h
    net.minecraft.client.renderer.RenderStateShard$OutputStateShard outputState -> i
    net.minecraft.client.renderer.RenderStateShard$TexturingStateShard texturingState -> j
    net.minecraft.client.renderer.RenderStateShard$WriteMaskStateShard writeMaskState -> k
    net.minecraft.client.renderer.RenderStateShard$LineStateShard lineState -> l
    net.minecraft.client.renderer.RenderStateShard$ColorLogicStateShard colorLogicState -> m
    net.minecraft.client.renderer.RenderType$OutlineProperty outlineProperty -> n
    com.google.common.collect.ImmutableList states -> o
    958:989:void <init>(net.minecraft.client.renderer.RenderStateShard$EmptyTextureStateShard,net.minecraft.client.renderer.RenderStateShard$ShaderStateShard,net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard,net.minecraft.client.renderer.RenderStateShard$DepthTestStateShard,net.minecraft.client.renderer.RenderStateShard$CullStateShard,net.minecraft.client.renderer.RenderStateShard$LightmapStateShard,net.minecraft.client.renderer.RenderStateShard$OverlayStateShard,net.minecraft.client.renderer.RenderStateShard$LayeringStateShard,net.minecraft.client.renderer.RenderStateShard$OutputStateShard,net.minecraft.client.renderer.RenderStateShard$TexturingStateShard,net.minecraft.client.renderer.RenderStateShard$WriteMaskStateShard,net.minecraft.client.renderer.RenderStateShard$LineStateShard,net.minecraft.client.renderer.RenderStateShard$ColorLogicStateShard,net.minecraft.client.renderer.RenderType$OutlineProperty) -> <init>
    993:993:java.lang.String toString() -> toString
    997:997:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder builder() -> a
	 */
	class CompositeState(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_RenderType_CompositeState)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = CompositeState::class.classDesc

			fun builder(): CompositeStateBuilder = CompositeStateBuilder(
				clazz.getMethod("a").invoke(null)
			)
		}

		/*
		net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder -> gfh$b$a:
    net.minecraft.client.renderer.RenderStateShard$EmptyTextureStateShard textureState -> a
    net.minecraft.client.renderer.RenderStateShard$ShaderStateShard shaderState -> b
    net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard transparencyState -> c
    net.minecraft.client.renderer.RenderStateShard$DepthTestStateShard depthTestState -> d
    net.minecraft.client.renderer.RenderStateShard$CullStateShard cullState -> e
    net.minecraft.client.renderer.RenderStateShard$LightmapStateShard lightmapState -> f
    net.minecraft.client.renderer.RenderStateShard$OverlayStateShard overlayState -> g
    net.minecraft.client.renderer.RenderStateShard$LayeringStateShard layeringState -> h
    net.minecraft.client.renderer.RenderStateShard$OutputStateShard outputState -> i
    net.minecraft.client.renderer.RenderStateShard$TexturingStateShard texturingState -> j
    net.minecraft.client.renderer.RenderStateShard$WriteMaskStateShard writeMaskState -> k
    net.minecraft.client.renderer.RenderStateShard$LineStateShard lineState -> l
    net.minecraft.client.renderer.RenderStateShard$ColorLogicStateShard colorLogicState -> m
    1001:1016:void <init>() -> <init>
    1019:1020:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setTextureState(net.minecraft.client.renderer.RenderStateShard$EmptyTextureStateShard) -> a
    1024:1025:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setShaderState(net.minecraft.client.renderer.RenderStateShard$ShaderStateShard) -> a
    1029:1030:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setTransparencyState(net.minecraft.client.renderer.RenderStateShard$TransparencyStateShard) -> a
    1034:1035:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setDepthTestState(net.minecraft.client.renderer.RenderStateShard$DepthTestStateShard) -> a
    1039:1040:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setCullState(net.minecraft.client.renderer.RenderStateShard$CullStateShard) -> a
    1044:1045:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setLightmapState(net.minecraft.client.renderer.RenderStateShard$LightmapStateShard) -> a
    1049:1050:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setOverlayState(net.minecraft.client.renderer.RenderStateShard$OverlayStateShard) -> a
    1054:1055:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setLayeringState(net.minecraft.client.renderer.RenderStateShard$LayeringStateShard) -> a
    1059:1060:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setOutputState(net.minecraft.client.renderer.RenderStateShard$OutputStateShard) -> a
    1064:1065:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setTexturingState(net.minecraft.client.renderer.RenderStateShard$TexturingStateShard) -> a
    1069:1070:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setWriteMaskState(net.minecraft.client.renderer.RenderStateShard$WriteMaskStateShard) -> a
    1074:1075:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setLineState(net.minecraft.client.renderer.RenderStateShard$LineStateShard) -> a
    1079:1080:net.minecraft.client.renderer.RenderType$CompositeState$CompositeStateBuilder setColorLogicState(net.minecraft.client.renderer.RenderStateShard$ColorLogicStateShard) -> a
    1084:1084:net.minecraft.client.renderer.RenderType$CompositeState createCompositeState(boolean) -> a
    1088:1088:net.minecraft.client.renderer.RenderType$CompositeState createCompositeState(net.minecraft.client.renderer.RenderType$OutlineProperty) -> a
		 */
		class CompositeStateBuilder(around: Any) : MimickedClass(around) {
			companion object : ClassInfo {
				override val clazz: Class<*> =
					loadClass(net_minecraft_client_renderer_RenderType_CompositeState_CompositeStateBuilder)
				override val classDesc: ClassDesc = clazz.classDesc
				override val mimicClassDesc: ClassDesc = CompositeStateBuilder::class.classDesc
			}

			fun setShaderState(shaderStateShard: RenderStateShard.ShaderStateShard): CompositeStateBuilder =
				CompositeStateBuilder(
					clazz.getMethod("a", RenderStateShard.ShaderStateShard.clazz)
					.invoke(around, shaderStateShard.around)
				)

			fun setTransparencyState(transparencyStateShard: RenderStateShard.TransparencyStateShard): CompositeStateBuilder =
				CompositeStateBuilder(
					clazz.getMethod("a", RenderStateShard.TransparencyStateShard.clazz)
						.invoke(around, transparencyStateShard.around)
				)

			fun setCullState(cullStateShard: RenderStateShard.CullStateShard): CompositeStateBuilder =
				CompositeStateBuilder(
					clazz.getMethod("a", RenderStateShard.CullStateShard.clazz)
						.invoke(around, cullStateShard.around)
				)

			fun setTexturingState(texturingStateShard: RenderStateShard.TexturingStateShard): CompositeStateBuilder =
				CompositeStateBuilder(
					clazz.getMethod("a", RenderStateShard.TexturingStateShard.clazz)
						.invoke(around, texturingStateShard.around)
				)

			fun createCompositeState(outline: Boolean): CompositeState = CompositeState(
				clazz.getMethod("a", Boolean::class.java)
					.invoke(around, outline)
			)
		}
	}
}