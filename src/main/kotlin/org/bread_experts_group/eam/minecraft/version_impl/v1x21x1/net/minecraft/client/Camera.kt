package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_Camera
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity.Entity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.phys.Vec3
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.org.joml.Quaternionf
import java.lang.constant.ClassDesc

/*
# {"fileName":"Camera.java","id":"sourceFile"}
    float DEFAULT_CAMERA_DISTANCE -> b
    org.joml.Vector3f FORWARDS -> c
    org.joml.Vector3f UP -> d
    org.joml.Vector3f LEFT -> e
    boolean initialized -> f
    net.minecraft.world.level.BlockGetter level -> g
    net.minecraft.world.phys.Vec3 position -> i
    net.minecraft.core.BlockPos$MutableBlockPos blockPosition -> j
    org.joml.Vector3f forwards -> k
    org.joml.Vector3f up -> l
    org.joml.Vector3f left -> m
    float xRot -> n
    float yRot -> o
    org.joml.Quaternionf rotation -> p
    boolean detached -> q
    float eyeHeight -> r
    float eyeHeightOld -> s
    float partialTickTime -> t
    float FOG_DISTANCE_SCALE -> a
    24:41:void <init>() -> <init>
    49:70:void setup(net.minecraft.world.level.BlockGetter,net.minecraft.world.entity.Entity,boolean,boolean,float) -> a
    73:77:void tick() -> a
    80:95:float getMaxZoom(float) -> a
    99:101:void move(float,float,float) -> a
    104:116:void setRotation(float,float) -> a
    119:120:void setPosition(double,double,double) -> a
    123:125:void setPosition(net.minecraft.world.phys.Vec3) -> a
    132:132:net.minecraft.core.BlockPos getBlockPosition() -> c
    136:136:float getXRot() -> d
    140:140:float getYRot() -> e
    152:152:boolean isInitialized() -> h
    156:156:boolean isDetached() -> i
    160:169:net.minecraft.client.Camera$NearPlane getNearPlane() -> j
    173:204:net.minecraft.world.level.material.FogType getFluidInCamera() -> k
    208:208:org.joml.Vector3f getLookVector() -> l
    212:212:org.joml.Vector3f getUpVector() -> m
    216:216:org.joml.Vector3f getLeftVector() -> n
    220:223:void reset() -> o
    226:226:float getPartialTickTime() -> p
    27:29:void <clinit>() -> <clinit>
 */
class Camera(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_Camera)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Camera::class.classDesc
	}

	constructor() : this(clazz.getConstructor().newInstance())

	var entity: Entity?
		get() = clazz.getField("h").get(around)?.let { Entity(it) }
		set(value) {
			val field = clazz.getField("h")
			if (value != null) field.set(around, value.around)
			else field.set(around, null)
		}

	fun setPosition(x: Double, y: Double, z: Double) {
		clazz.getMethod("a", Double::class.java, Double::class.java, Double::class.java)
			.invoke(around, x, y, z)
	}

	fun setRotation(yRot: Float, xRot: Float) {
		clazz.getMethod("a", Float::class.java, Float::class.java)
			.invoke(around, yRot, xRot)
	}

	fun rotation(): Quaternionf = Quaternionf(clazz.getMethod("f").invoke(around))
	fun getPosition(): Vec3 = Vec3(clazz.getMethod("b").invoke(around))
	fun isDetached(): Boolean = clazz.getMethod("i").invoke(around) as Boolean

	// declaration clash, but it shouldn't be an issue since the entity field is transformed to be public
//	fun getEntity(): Entity = Entity(
//		clazz.getMethod("g").invoke(around)
//	)
}