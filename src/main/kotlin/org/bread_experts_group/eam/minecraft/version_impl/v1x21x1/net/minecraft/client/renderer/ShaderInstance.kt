package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_ShaderInstance
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.VertexFormat
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.resources.ResourceProvider
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.ShaderInstance -> gfn:
# {"fileName":"ShaderInstance.java","id":"sourceFile"}
    java.lang.String SHADER_PATH -> a
    java.lang.String SHADER_CORE_PATH -> q
    java.lang.String SHADER_INCLUDE_PATH -> r
    org.slf4j.Logger LOGGER -> s
    com.mojang.blaze3d.shaders.AbstractUniform DUMMY_UNIFORM -> t
    boolean ALWAYS_REAPPLY -> u
    net.minecraft.client.renderer.ShaderInstance lastAppliedShader -> v
    int lastProgramId -> w
    java.util.Map samplerMap -> x
    java.util.List samplerNames -> y
    java.util.List samplerLocations -> z
    java.util.List uniforms -> A
    java.util.List uniformLocations -> B
    java.util.Map uniformMap -> C
    int programId -> D
    java.lang.String name -> E
    boolean dirty -> F
    com.mojang.blaze3d.shaders.Program vertexProgram -> G
    com.mojang.blaze3d.shaders.Program fragmentProgram -> H
    com.mojang.blaze3d.vertex.VertexFormat vertexFormat -> I
    com.mojang.blaze3d.shaders.Uniform MODEL_VIEW_MATRIX -> b
    com.mojang.blaze3d.shaders.Uniform PROJECTION_MATRIX -> c
    com.mojang.blaze3d.shaders.Uniform TEXTURE_MATRIX -> d
    com.mojang.blaze3d.shaders.Uniform SCREEN_SIZE -> e
    com.mojang.blaze3d.shaders.Uniform COLOR_MODULATOR -> f
    com.mojang.blaze3d.shaders.Uniform LIGHT0_DIRECTION -> g
    com.mojang.blaze3d.shaders.Uniform LIGHT1_DIRECTION -> h
    com.mojang.blaze3d.shaders.Uniform GLINT_ALPHA -> i
    com.mojang.blaze3d.shaders.Uniform FOG_START -> j
    com.mojang.blaze3d.shaders.Uniform FOG_END -> k
    com.mojang.blaze3d.shaders.Uniform FOG_COLOR -> l
    com.mojang.blaze3d.shaders.Uniform FOG_SHAPE -> m
    com.mojang.blaze3d.shaders.Uniform LINE_WIDTH -> n
    com.mojang.blaze3d.shaders.Uniform GAME_TIME -> o
    com.mojang.blaze3d.shaders.Uniform CHUNK_OFFSET -> p
    57:200:void <init>(net.minecraft.server.packs.resources.ResourceProvider,java.lang.String,com.mojang.blaze3d.vertex.VertexFormat) -> <init>
    204:235:com.mojang.blaze3d.shaders.Program getOrCreate(net.minecraft.server.packs.resources.ResourceProvider,com.mojang.blaze3d.shaders.Program$Type,java.lang.String) -> a
    240:244:void close() -> close
    248:266:void clear() -> f
    270:320:void apply() -> g
    324:325:void markDirty() -> b
    329:330:com.mojang.blaze3d.shaders.Uniform getUniform(java.lang.String) -> a
    334:335:com.mojang.blaze3d.shaders.AbstractUniform safeGetUniform(java.lang.String) -> b
    339:370:void updateLocations() -> j
    373:383:void parseSamplerNode(com.google.gson.JsonElement) -> a
    386:388:void setSampler(java.lang.String,java.lang.Object) -> a
    391:436:void parseUniformNode(com.google.gson.JsonElement) -> b
    440:440:com.mojang.blaze3d.shaders.Program getVertexProgram() -> c
    445:445:com.mojang.blaze3d.shaders.Program getFragmentProgram() -> d
    450:452:void attachToProgram() -> e
    455:455:com.mojang.blaze3d.vertex.VertexFormat getVertexFormat() -> h
    464:464:int getId() -> a
    468:509:void setDefaultUniforms(com.mojang.blaze3d.vertex.VertexFormat$Mode,org.joml.Matrix4f,org.joml.Matrix4f,com.mojang.blaze3d.platform.Window) -> a
    49:54:void <clinit>() -> <clinit>
 */
class ShaderInstance(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_ShaderInstance)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ShaderInstance::class.classDesc
	}

	constructor(resourceProvider: ResourceProvider, name: String, vertexFormat: VertexFormat) : this(
		clazz.getConstructor(ResourceProvider.clazz, String::class.java, VertexFormat.clazz)
			.newInstance(resourceProvider.around, name, vertexFormat.around)
	)

	fun getName(): String = clazz.getMethod("i").invoke(around) as String
}