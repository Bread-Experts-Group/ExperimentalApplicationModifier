package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_core_BlockPos
import java.lang.constant.ClassDesc

/*
net.minecraft.core.BlockPos -> jd:
# {"fileName":"BlockPos.java","id":"sourceFile"}
    com.mojang.serialization.Codec CODEC -> a
    net.minecraft.network.codec.StreamCodec STREAM_CODEC -> b
    org.slf4j.Logger LOGGER -> e
    net.minecraft.core.BlockPos ZERO -> c
    int PACKED_X_LENGTH -> h
    int PACKED_Z_LENGTH -> i
    int PACKED_Y_LENGTH -> d
    long PACKED_X_MASK -> j
    long PACKED_Y_MASK -> k
    long PACKED_Z_MASK -> l
    int Y_OFFSET -> m
    int Z_OFFSET -> n
    int X_OFFSET -> o
    73:74:void <init>(int,int,int) -> <init>
    77:78:void <init>(net.minecraft.core.Vec3i) -> <init>
    81:81:long offset(long,net.minecraft.core.Direction) -> a
    85:85:long offset(long,int,int,int) -> a
    89:89:int getX(long) -> a
    93:93:int getY(long) -> b
    97:97:int getZ(long) -> c
    101:101:net.minecraft.core.BlockPos of(long) -> d
    105:105:net.minecraft.core.BlockPos containing(double,double,double) -> a
    109:109:net.minecraft.core.BlockPos containing(net.minecraft.core.Position) -> a
    113:116:net.minecraft.core.BlockPos min(net.minecraft.core.BlockPos,net.minecraft.core.BlockPos) -> a
    121:124:net.minecraft.core.BlockPos max(net.minecraft.core.BlockPos,net.minecraft.core.BlockPos) -> b
    129:129:long asLong() -> a
    133:137:long asLong(int,int,int) -> a
    145:145:long getFlatIndex(long) -> e
    150:153:net.minecraft.core.BlockPos offset(int,int,int) -> b
    157:157:net.minecraft.world.phys.Vec3 getCenter() -> b
    161:161:net.minecraft.world.phys.Vec3 getBottomCenter() -> c
    166:166:net.minecraft.core.BlockPos offset(net.minecraft.core.Vec3i) -> a
    171:171:net.minecraft.core.BlockPos subtract(net.minecraft.core.Vec3i) -> b
    176:181:net.minecraft.core.BlockPos multiply(int) -> a
    186:186:net.minecraft.core.BlockPos above() -> d
    191:191:net.minecraft.core.BlockPos above(int) -> b
    196:196:net.minecraft.core.BlockPos below() -> e
    201:201:net.minecraft.core.BlockPos below(int) -> c
    206:206:net.minecraft.core.BlockPos north() -> f
    211:211:net.minecraft.core.BlockPos north(int) -> d
    216:216:net.minecraft.core.BlockPos south() -> g
    221:221:net.minecraft.core.BlockPos south(int) -> e
    226:226:net.minecraft.core.BlockPos west() -> h
    231:231:net.minecraft.core.BlockPos west(int) -> f
    236:236:net.minecraft.core.BlockPos east() -> i
    241:241:net.minecraft.core.BlockPos east(int) -> g
    246:246:net.minecraft.core.BlockPos relative(net.minecraft.core.Direction) -> a
    251:254:net.minecraft.core.BlockPos relative(net.minecraft.core.Direction,int) -> a
    259:265:net.minecraft.core.BlockPos relative(net.minecraft.core.Direction$Axis,int) -> a
    269:278:net.minecraft.core.BlockPos rotate(net.minecraft.world.level.block.Rotation) -> a
    284:284:net.minecraft.core.BlockPos cross(net.minecraft.core.Vec3i) -> c
    288:288:net.minecraft.core.BlockPos atY(int) -> h
    292:292:net.minecraft.core.BlockPos immutable() -> j
    296:296:net.minecraft.core.BlockPos$MutableBlockPos mutable() -> k
    300:303:net.minecraft.world.phys.Vec3 clampLocationWithin(net.minecraft.world.phys.Vec3) -> a
    437:437:java.lang.Iterable randomInCube(net.minecraft.util.RandomSource,int,net.minecraft.core.BlockPos,int) -> a
    449:453:java.util.stream.Stream squareOutSouthEast(net.minecraft.core.BlockPos) -> a
    459:463:java.lang.Iterable randomBetweenClosed(net.minecraft.util.RandomSource,int,int,int,int,int,int,int) -> a
    485:490:java.lang.Iterable withinManhattan(net.minecraft.core.BlockPos,int,int,int) -> a
    541:546:java.util.Optional findClosestMatch(net.minecraft.core.BlockPos,int,int,java.util.function.Predicate) -> a
    550:550:java.util.stream.Stream withinManhattanStream(net.minecraft.core.BlockPos,int,int,int) -> b
    554:560:java.lang.Iterable betweenClosed(net.minecraft.core.BlockPos,net.minecraft.core.BlockPos) -> c
    565:565:java.util.stream.Stream betweenClosedStream(net.minecraft.core.BlockPos,net.minecraft.core.BlockPos) -> d
    569:575:java.util.stream.Stream betweenClosedStream(net.minecraft.world.level.levelgen.structure.BoundingBox) -> a
    580:580:java.util.stream.Stream betweenClosedStream(net.minecraft.world.phys.AABB) -> a
    584:584:java.util.stream.Stream betweenClosedStream(int,int,int,int,int,int) -> a
    589:594:java.lang.Iterable betweenClosed(int,int,int,int,int,int) -> b
    616:618:java.lang.Iterable spiralAround(net.minecraft.core.BlockPos,int,net.minecraft.core.Direction,net.minecraft.core.Direction) -> a
    673:694:int breadthFirstTraversal(net.minecraft.core.BlockPos,int,int,java.util.function.BiConsumer,java.util.function.Predicate) -> a
    34:34:net.minecraft.core.Vec3i cross(net.minecraft.core.Vec3i) -> d
    34:34:net.minecraft.core.Vec3i relative(net.minecraft.core.Direction$Axis,int) -> b
    34:34:net.minecraft.core.Vec3i relative(net.minecraft.core.Direction,int) -> b
    34:34:net.minecraft.core.Vec3i relative(net.minecraft.core.Direction) -> b
    34:34:net.minecraft.core.Vec3i east(int) -> i
    34:34:net.minecraft.core.Vec3i east() -> l
    34:34:net.minecraft.core.Vec3i west(int) -> j
    34:34:net.minecraft.core.Vec3i west() -> m
    34:34:net.minecraft.core.Vec3i south(int) -> k
    34:34:net.minecraft.core.Vec3i south() -> n
    34:34:net.minecraft.core.Vec3i north(int) -> l
    34:34:net.minecraft.core.Vec3i north() -> o
    34:34:net.minecraft.core.Vec3i below(int) -> m
    34:34:net.minecraft.core.Vec3i below() -> p
    34:34:net.minecraft.core.Vec3i above(int) -> n
    34:34:net.minecraft.core.Vec3i above() -> q
    34:34:net.minecraft.core.Vec3i multiply(int) -> o
    34:34:net.minecraft.core.Vec3i subtract(net.minecraft.core.Vec3i) -> e
    34:34:net.minecraft.core.Vec3i offset(net.minecraft.core.Vec3i) -> f
    34:34:net.minecraft.core.Vec3i offset(int,int,int) -> c
    692:692:void lambda$breadthFirstTraversal$7(java.util.Queue,int,net.minecraft.core.BlockPos) -> a
    618:618:java.util.Iterator lambda$spiralAround$6(net.minecraft.core.Direction,net.minecraft.core.Direction,net.minecraft.core.BlockPos,int) -> a
    594:594:java.util.Iterator lambda$betweenClosed$5(int,int,int,int,int,int) -> c
    490:490:java.util.Iterator lambda$withinManhattan$4(int,int,int,int,int,int,int) -> a
    463:463:java.util.Iterator lambda$randomBetweenClosed$3(int,int,net.minecraft.util.RandomSource,int,int,int,int,int) -> a
    38:38:java.util.stream.IntStream lambda$static$2(net.minecraft.core.BlockPos) -> b
    37:37:com.mojang.serialization.DataResult lambda$static$1(java.util.stream.IntStream) -> a
    37:37:net.minecraft.core.BlockPos lambda$static$0(int[]) -> a
    36:70:void <clinit>() -> <clinit>
 */
class BlockPos(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_core_BlockPos)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BlockPos::class.classDesc
	}
}