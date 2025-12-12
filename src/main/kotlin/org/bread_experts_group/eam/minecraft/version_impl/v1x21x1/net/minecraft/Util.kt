package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_Util
import java.lang.constant.ClassDesc
import java.util.function.Function

/*
net.minecraft.Util -> ad:
# {"fileName":"Util.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> g
    int DEFAULT_MAX_THREADS -> h
    int DEFAULT_SAFE_FILE_OPERATION_RETRIES -> i
    java.lang.String MAX_THREADS_SYSTEM_PROPERTY -> j
    java.util.concurrent.ExecutorService BACKGROUND_EXECUTOR -> k
    java.util.concurrent.ExecutorService IO_POOL -> l
    java.util.concurrent.ExecutorService DOWNLOAD_POOL -> m
    java.time.format.DateTimeFormatter FILENAME_DATE_TIME_FORMATTER -> n
    int LINEAR_LOOKUP_THRESHOLD -> a
    java.util.Set ALLOWED_UNTRUSTED_LINK_PROTOCOLS -> o
    long NANOS_PER_MILLI -> b
    net.minecraft.util.TimeSource$NanoTimeSource timeSource -> c
    com.google.common.base.Ticker TICKER -> d
    java.util.UUID NIL_UUID -> e
    java.nio.file.spi.FileSystemProvider ZIP_FILE_SYSTEM_PROVIDER -> f
    java.util.function.Consumer thePauser -> p
    87:87:void <init>() -> <init>
    117:117:java.util.stream.Collector toMap() -> a
    121:121:java.util.stream.Collector toMutableList() -> b
    126:126:java.lang.String getPropertyName(net.minecraft.world.level.block.state.properties.Property,java.lang.Object) -> a
    130:133:java.lang.String makeDescriptionId(java.lang.String,net.minecraft.resources.ResourceLocation) -> a
    137:137:long getMillis() -> c
    141:141:long getNanos() -> d
    145:145:long getEpochMillis() -> e
    149:149:java.lang.String getFilenameFormattedDateTime() -> f
    153:176:java.util.concurrent.ExecutorService makeExecutor(java.lang.String) -> c
    180:192:int getMaxThreads() -> n
    196:196:java.util.concurrent.ExecutorService backgroundExecutor() -> g
    203:203:java.util.concurrent.ExecutorService ioPool() -> h
    210:210:java.util.concurrent.ExecutorService nonCriticalIoPool() -> i
    214:216:void shutdownExecutors() -> j
    219:229:void shutdownExecutor(java.util.concurrent.ExecutorService) -> a
    232:233:java.util.concurrent.ExecutorService makeIoExecutor(java.lang.String,boolean) -> a
    243:243:void throwAsRuntime(java.lang.Throwable) -> a
    247:256:void onThreadException(java.lang.Thread,java.lang.Throwable) -> a
    260:263:com.mojang.datafixers.types.Type fetchChoiceType(com.mojang.datafixers.DSL$TypeReference,java.lang.String) -> a
    268:277:com.mojang.datafixers.types.Type doFetchChoiceType(com.mojang.datafixers.DSL$TypeReference,java.lang.String) -> b
    281:294:java.lang.Runnable wrapThreadWithTaskName(java.lang.String,java.lang.Runnable) -> a
    299:312:java.util.function.Supplier wrapThreadWithTaskName(java.lang.String,java.util.function.Supplier) -> a
    317:321:java.lang.String getRegisteredName(net.minecraft.core.Registry,java.lang.Object) -> a
    325:332:java.util.function.Predicate allOf(java.util.List) -> a
    345:352:java.util.function.Predicate anyOf(java.util.List) -> b
    365:379:boolean isSymmetrical(int,int,java.util.List) -> a
    448:467:net.minecraft.Util$OS getPlatform() -> k
    471:482:java.net.URI parseAndValidateUntrustedUri(java.lang.String) -> a
    486:487:java.util.stream.Stream getVmArguments() -> l
    491:491:java.lang.Object lastOf(java.util.List) -> c
    495:513:java.lang.Object findNextInIterable(java.lang.Iterable,java.lang.Object) -> a
    517:529:java.lang.Object findPreviousInIterable(java.lang.Iterable,java.lang.Object) -> b
    533:533:java.lang.Object make(java.util.function.Supplier) -> a
    537:538:java.lang.Object make(java.lang.Object,java.util.function.Consumer) -> a
    542:551:java.util.concurrent.CompletableFuture sequence(java.util.List) -> d
    556:559:java.util.concurrent.CompletableFuture sequenceFailFast(java.util.List) -> e
    563:571:java.util.concurrent.CompletableFuture sequenceFailFastAndCancel(java.util.List) -> f
    575:590:java.util.concurrent.CompletableFuture fallibleSequence(java.util.List,java.util.function.Consumer) -> a
    594:599:java.util.Optional ifElse(java.util.Optional,java.util.function.Consumer,java.lang.Runnable) -> a
    617:617:java.util.function.Supplier name(java.util.function.Supplier,java.util.function.Supplier) -> a
    636:636:java.lang.Runnable name(java.lang.Runnable,java.util.function.Supplier) -> a
    641:645:void logAndPauseIfInIde(java.lang.String) -> b
    648:652:void logAndPauseIfInIde(java.lang.String,java.lang.Throwable) -> a
    655:659:java.lang.Throwable pauseInIde(java.lang.Throwable) -> b
    663:664:void setPause(java.util.function.Consumer) -> a
    667:674:void doPause(java.lang.String) -> d
    677:682:java.lang.String describeError(java.lang.Throwable) -> c
    687:687:java.lang.Object getRandom(java.lang.Object[],net.minecraft.util.RandomSource) -> a
    692:692:int getRandom(int[],net.minecraft.util.RandomSource) -> a
    696:696:java.lang.Object getRandom(java.util.List,net.minecraft.util.RandomSource) -> a
    700:703:java.util.Optional getRandomSafe(java.util.List,net.minecraft.util.RandomSource) -> b
    707:707:java.util.function.BooleanSupplier createRenamer(java.nio.file.Path,java.nio.file.Path) -> a
    727:727:java.util.function.BooleanSupplier createDeleter(java.nio.file.Path) -> a
    747:747:java.util.function.BooleanSupplier createFileDeletedCheck(java.nio.file.Path) -> b
    761:761:java.util.function.BooleanSupplier createFileCreatedCheck(java.nio.file.Path) -> c
    775:781:boolean executeInSequence(java.util.function.BooleanSupplier[]) -> a
    785:792:boolean runWithRetries(int,java.lang.String,java.util.function.BooleanSupplier[]) -> a
    796:797:void safeReplaceFile(java.nio.file.Path,java.nio.file.Path,java.nio.file.Path) -> a
    800:828:boolean safeReplaceOrMoveFile(java.nio.file.Path,java.nio.file.Path,java.nio.file.Path,boolean) -> a
    833:851:int offsetByCodepoints(java.lang.String,int,int) -> a
    855:855:java.util.function.Consumer prefix(java.lang.String,java.util.function.Consumer) -> a
    862:871:com.mojang.serialization.DataResult fixedSize(java.util.stream.IntStream,int) -> a
    878:887:com.mojang.serialization.DataResult fixedSize(java.util.stream.LongStream,int) -> a
    894:902:com.mojang.serialization.DataResult fixedSize(java.util.List,int) -> a
    908:924:void startTimerHackThread() -> m
    927:930:void copyBetweenDirs(java.nio.file.Path,java.nio.file.Path,java.nio.file.Path) -> b
    933:933:java.lang.String sanitizeName(java.lang.String,net.minecraft.CharPredicate) -> a
    937:937:net.minecraft.util.SingleKeyCache singleKeyCache(java.util.function.Function) -> a
    941:941:java.util.function.Function memoize(java.util.function.Function) -> b
    957:957:java.util.function.BiFunction memoize(java.util.function.BiFunction) -> a
    973:975:java.util.List toShuffledList(java.util.stream.Stream,net.minecraft.util.RandomSource) -> a
    979:985:it.unimi.dsi.fastutil.ints.IntArrayList toShuffledList(java.util.stream.IntStream,net.minecraft.util.RandomSource) -> a
    989:991:java.util.List shuffledCopy(java.lang.Object[],net.minecraft.util.RandomSource) -> b
    998:1000:java.util.List shuffledCopy(it.unimi.dsi.fastutil.objects.ObjectArrayList,net.minecraft.util.RandomSource) -> a
    1004:1009:void shuffle(java.util.List,net.minecraft.util.RandomSource) -> c
    1012:1012:java.util.concurrent.CompletableFuture blockUntilDone(java.util.function.Function) -> c
    1016:1039:java.lang.Object blockUntilDone(java.util.function.Function,java.util.function.Predicate) -> a
    1048:1058:java.util.function.ToIntFunction createIndexLookup(java.util.List) -> g
    1067:1079:java.util.function.ToIntFunction createIndexIdentityLookup(java.util.List) -> h
    1083:1085:com.mojang.datafixers.Typed writeAndReadTypedOrThrow(com.mojang.datafixers.Typed,com.mojang.datafixers.types.Type,java.util.function.UnaryOperator) -> a
    1089:1089:com.mojang.datafixers.Typed readTypedOrThrow(com.mojang.datafixers.types.Type,com.mojang.serialization.Dynamic) -> a
    1093:1104:com.mojang.datafixers.Typed readTypedOrThrow(com.mojang.datafixers.types.Type,com.mojang.serialization.Dynamic,boolean) -> a
    1109:1112:java.util.List copyAndAdd(java.util.List,java.lang.Object) -> a
    1116:1119:java.util.List copyAndAdd(java.lang.Object,java.util.List) -> a
    1123:1126:java.util.Map copyAndPut(java.util.Map,java.lang.Object,java.lang.Object) -> a
    933:933:java.lang.String lambda$sanitizeName$23(net.minecraft.CharPredicate,int) -> a
    895:895:java.lang.String lambda$fixedSize$22(int) -> a
    880:880:java.lang.String lambda$fixedSize$21(int) -> b
    864:864:java.lang.String lambda$fixedSize$20(int) -> c
    855:855:void lambda$prefix$19(java.util.function.Consumer,java.lang.String,java.lang.String) -> a
    590:590:java.util.List lambda$fallibleSequence$18(java.util.List,java.lang.Void) -> a
    579:588:void lambda$fallibleSequence$17(java.util.List,java.util.concurrent.CompletableFuture[],java.util.function.Consumer,java.util.concurrent.CompletableFuture) -> a
    582:587:void lambda$fallibleSequence$16(java.util.function.Consumer,java.util.List,int,java.lang.Object,java.lang.Throwable) -> a
    566:571:void lambda$sequenceFailFastAndCancel$15(java.util.concurrent.CompletableFuture,java.util.List,java.lang.Throwable) -> a
    551:551:java.util.List lambda$sequence$14(java.util.List,java.lang.Void) -> b
    487:487:boolean lambda$getVmArguments$13(java.lang.String) -> e
    353:358:boolean lambda$anyOf$12(java.util.function.Predicate[],java.lang.Object) -> a
    351:351:java.util.function.Predicate[] lambda$anyOf$11(int) -> d
    346:346:boolean lambda$anyOf$10(java.lang.Object) -> a
    333:338:boolean lambda$allOf$9(java.util.function.Predicate[],java.lang.Object) -> b
    331:331:java.util.function.Predicate[] lambda$allOf$8(int) -> e
    326:326:boolean lambda$allOf$7(java.lang.Object) -> b
    301:309:java.lang.Object lambda$wrapThreadWithTaskName$6(java.lang.String,java.util.function.Supplier) -> b
    283:292:void lambda$wrapThreadWithTaskName$5(java.lang.String,java.lang.Runnable) -> b
    234:238:java.lang.Thread lambda$makeIoExecutor$4(java.lang.String,java.util.concurrent.atomic.AtomicInteger,boolean,java.lang.Runnable) -> a
    161:173:java.util.concurrent.ForkJoinWorkerThread lambda$makeExecutor$3(java.lang.String,java.util.concurrent.atomic.AtomicInteger,java.util.concurrent.ForkJoinPool) -> a
    114:114:void lambda$static$2(java.lang.String) -> f
    112:112:java.lang.IllegalStateException lambda$static$1() -> o
    110:110:boolean lambda$static$0(java.nio.file.spi.FileSystemProvider) -> a
    88:114:void <clinit>() -> <clinit>
 */
class Util(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_Util)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Util::class.classDesc

		@Suppress("UNCHECKED_CAST")
		fun <T, R> memoize(memoFunction: Function<T, R>): Function<T, R> =
			clazz.getMethod("b", Function::class.java).invoke(null, memoFunction) as Function<T, R>
	}
}