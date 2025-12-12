package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.culling

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_culling_Frustum
import java.lang.constant.ClassDesc

/*
net.minecraft.client.renderer.culling.Frustum -> gie:
# {"fileName":"Frustum.java","id":"sourceFile"}
    int OFFSET_STEP -> a
    org.joml.FrustumIntersection intersection -> b
    org.joml.Matrix4f matrix -> c
    org.joml.Vector4f viewVector -> d
    double camX -> e
    double camY -> f
    double camZ -> g
    10:19:void <init>(org.joml.Matrix4f,org.joml.Matrix4f) -> <init>
    10:28:void <init>(net.minecraft.client.renderer.culling.Frustum) -> <init>
    53:56:void prepare(double,double,double) -> a
    59:63:void calculateFrustum(org.joml.Matrix4f,org.joml.Matrix4f) -> a
    66:66:boolean isVisible(net.minecraft.world.phys.AABB) -> a
    70:76:boolean cubeInFrustum(double,double,double,double,double,double) -> a
 */
class Frustum(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_culling_Frustum)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Frustum::class.classDesc
	}

	fun offsetToFullyIncludeCameraCube(offset: Int): Frustum = Frustum(
		clazz.getMethod("a", Int::class.java).invoke(around, offset)
	)
}