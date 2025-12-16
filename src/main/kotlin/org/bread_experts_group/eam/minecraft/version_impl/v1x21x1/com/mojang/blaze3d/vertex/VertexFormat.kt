package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.com_mojang_blaze3d_vertex_VertexFormat
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.com_mojang_blaze3d_vertex_VertexFormat_Mode
import java.lang.constant.ClassDesc

/*
com.mojang.blaze3d.vertex.VertexFormat -> fbn:
# {"fileName":"VertexFormat.java","id":"sourceFile"}
    int UNKNOWN_ELEMENT -> a
    java.util.List elements -> b
    java.util.List names -> c
    int vertexSize -> d
    int elementsMask -> e
    int[] offsetsByElement -> f
    com.mojang.blaze3d.vertex.VertexBuffer immediateDrawVertexBuffer -> g
    22:37:void <init>(java.util.List,java.util.List,it.unimi.dsi.fastutil.ints.IntList,int) -> <init>
    40:40:com.mojang.blaze3d.vertex.VertexFormat$Builder builder() -> a
    45:57:java.lang.String toString() -> toString
    61:61:int getVertexSize() -> b
    65:65:java.util.List getElements() -> c
    69:69:java.util.List getElementAttributeNames() -> d
    73:73:int[] getOffsetsByElement() -> e
    77:77:int getOffset(com.mojang.blaze3d.vertex.VertexFormatElement) -> a
    81:81:boolean contains(com.mojang.blaze3d.vertex.VertexFormatElement) -> b
    85:85:int getElementsMask() -> f
    89:93:java.lang.String getElementName(com.mojang.blaze3d.vertex.VertexFormatElement) -> c
    98:105:boolean equals(java.lang.Object) -> equals
    110:110:int hashCode() -> hashCode
    114:119:void setupBufferState() -> g
    122:128:void _setupBufferState() -> j
    131:136:void clearBufferState() -> h
    139:142:void _clearBufferState() -> k
    145:149:com.mojang.blaze3d.vertex.VertexBuffer getImmediateDrawVertexBuffer() -> i
    31:31:int lambda$new$0(int,int) -> a
 */
class VertexFormat(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_blaze3d_vertex_VertexFormat)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = VertexFormat::class.classDesc
	}

	/*
	com.mojang.blaze3d.vertex.VertexFormat$Mode -> fbn$c:
# {"fileName":"VertexFormat.java","id":"sourceFile"}
    com.mojang.blaze3d.vertex.VertexFormat$Mode LINES -> a
    com.mojang.blaze3d.vertex.VertexFormat$Mode LINE_STRIP -> b
    com.mojang.blaze3d.vertex.VertexFormat$Mode DEBUG_LINES -> c
    com.mojang.blaze3d.vertex.VertexFormat$Mode DEBUG_LINE_STRIP -> d
    com.mojang.blaze3d.vertex.VertexFormat$Mode TRIANGLES -> e
    com.mojang.blaze3d.vertex.VertexFormat$Mode TRIANGLE_STRIP -> f
    com.mojang.blaze3d.vertex.VertexFormat$Mode TRIANGLE_FAN -> g
    com.mojang.blaze3d.vertex.VertexFormat$Mode QUADS -> h
    int asGLMode -> i
    int primitiveLength -> j
    int primitiveStride -> k
    boolean connectedPrimitives -> l
    com.mojang.blaze3d.vertex.VertexFormat$Mode[] $VALUES -> m
    200:200:com.mojang.blaze3d.vertex.VertexFormat$Mode[] values() -> values
    200:200:com.mojang.blaze3d.vertex.VertexFormat$Mode valueOf(java.lang.String) -> valueOf
    215:220:void <init>(java.lang.String,int,int,int,int,boolean) -> <init>
    224:241:int indexCount(int) -> a
    200:200:com.mojang.blaze3d.vertex.VertexFormat$Mode[] $values() -> a
    200:208:void <clinit>() -> <clinit>
	 */
	class Mode(around: Any) : MimickedClass(around) {
		companion object : ClassInfo {
			override val clazz: Class<*> = loadClass(com_mojang_blaze3d_vertex_VertexFormat_Mode)
			override val classDesc: ClassDesc = clazz.classDesc
			override val mimicClassDesc: ClassDesc = Mode::class.classDesc

			val LINES: Mode = Mode(clazz.enumConstants[0])
			val LINE_STRIP: Mode = Mode(clazz.enumConstants[1])
			val DEBUG_LINES: Mode = Mode(clazz.enumConstants[2])
			val DEBUG_LINE_STRIP: Mode = Mode(clazz.enumConstants[3])
			val TRIANGLES: Mode = Mode(clazz.enumConstants[4])
			val TRIANGLE_STRIP: Mode = Mode(clazz.enumConstants[5])
			val TRIANGLE_FAN: Mode = Mode(clazz.enumConstants[6])
			val QUADS: Mode = Mode(clazz.enumConstants[7])
		}
	}
}