package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_core_Vec3i
import java.lang.constant.ClassDesc

/*
net.minecraft.core.Vec3i -> kh:
# {"fileName":"Vec3i.java","id":"sourceFile"}
    com.mojang.serialization.Codec CODEC -> f
    net.minecraft.core.Vec3i ZERO -> g
    int x -> a
    int y -> b
    int z -> c
    23:23:com.mojang.serialization.Codec offsetCodec(int) -> v
    38:42:void <init>(int,int,int) -> <init>
    46:65:boolean equals(java.lang.Object) -> equals
    70:70:int hashCode() -> hashCode
    75:81:int compareTo(net.minecraft.core.Vec3i) -> i
    85:85:int getX() -> u
    89:89:int getY() -> v
    93:93:int getZ() -> w
    97:98:net.minecraft.core.Vec3i setX(int) -> u
    102:103:net.minecraft.core.Vec3i setY(int) -> t
    107:108:net.minecraft.core.Vec3i setZ(int) -> s
    112:115:net.minecraft.core.Vec3i offset(int,int,int) -> c
    119:119:net.minecraft.core.Vec3i offset(net.minecraft.core.Vec3i) -> f
    123:123:net.minecraft.core.Vec3i subtract(net.minecraft.core.Vec3i) -> e
    127:132:net.minecraft.core.Vec3i multiply(int) -> o
    136:136:net.minecraft.core.Vec3i above() -> q
    140:140:net.minecraft.core.Vec3i above(int) -> n
    144:144:net.minecraft.core.Vec3i below() -> p
    148:148:net.minecraft.core.Vec3i below(int) -> m
    152:152:net.minecraft.core.Vec3i north() -> o
    156:156:net.minecraft.core.Vec3i north(int) -> l
    160:160:net.minecraft.core.Vec3i south() -> n
    164:164:net.minecraft.core.Vec3i south(int) -> k
    168:168:net.minecraft.core.Vec3i west() -> m
    172:172:net.minecraft.core.Vec3i west(int) -> j
    176:176:net.minecraft.core.Vec3i east() -> l
    180:180:net.minecraft.core.Vec3i east(int) -> i
    184:184:net.minecraft.core.Vec3i relative(net.minecraft.core.Direction) -> b
    188:191:net.minecraft.core.Vec3i relative(net.minecraft.core.Direction,int) -> b
    195:201:net.minecraft.core.Vec3i relative(net.minecraft.core.Direction$Axis,int) -> b
    205:205:net.minecraft.core.Vec3i cross(net.minecraft.core.Vec3i) -> d
    209:209:boolean closerThan(net.minecraft.core.Vec3i,double) -> a
    213:213:boolean closerToCenterThan(net.minecraft.core.Position,double) -> a
    217:217:double distSqr(net.minecraft.core.Vec3i) -> j
    221:221:double distToCenterSqr(net.minecraft.core.Position) -> b
    225:228:double distToCenterSqr(double,double,double) -> c
    232:235:double distToLowCornerSqr(double,double,double) -> d
    239:242:int distManhattan(net.minecraft.core.Vec3i) -> k
    246:246:int get(net.minecraft.core.Direction$Axis) -> a
    251:255:java.lang.String toString() -> toString
    259:259:java.lang.String toShortString() -> x
    12:12:int compareTo(java.lang.Object) -> compareTo
    24:27:com.mojang.serialization.DataResult lambda$offsetCodec$4(int,net.minecraft.core.Vec3i) -> a
    27:27:java.lang.String lambda$offsetCodec$3(int,net.minecraft.core.Vec3i) -> b
    16:16:java.util.stream.IntStream lambda$static$2(net.minecraft.core.Vec3i) -> a
    15:15:com.mojang.serialization.DataResult lambda$static$1(java.util.stream.IntStream) -> a
    15:15:net.minecraft.core.Vec3i lambda$static$0(int[]) -> a
    14:32:void <clinit>() -> <clinit>
 */
open class Vec3i(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_core_Vec3i)
		override val classDesc: ClassDesc= clazz.classDesc
		override val mimicClassDesc: ClassDesc = Vec3i::class.classDesc
	}

	fun getX(): Int = clazz.getMethod("u").invoke(around) as Int
	fun getY(): Int = clazz.getMethod("v").invoke(around) as Int
	fun getZ(): Int = clazz.getMethod("w").invoke(around) as Int
}