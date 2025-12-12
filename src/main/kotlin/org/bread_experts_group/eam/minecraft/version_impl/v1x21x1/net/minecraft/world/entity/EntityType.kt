package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_entity_EntityType
import java.lang.constant.ClassDesc

/*
net.minecraft.world.entity.EntityType -> bsx:
# {"fileName":"EntityType.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> bB
    net.minecraft.core.Holder$Reference builtInRegistryHolder -> bC
    float MAGIC_HORSE_WIDTH -> bD
    int DISPLAY_TRACKING_RANGE -> bE
    net.minecraft.world.entity.EntityType ALLAY -> a
    net.minecraft.world.entity.EntityType AREA_EFFECT_CLOUD -> b
    net.minecraft.world.entity.EntityType ARMADILLO -> c
    net.minecraft.world.entity.EntityType ARMOR_STAND -> d
    net.minecraft.world.entity.EntityType ARROW -> e
    net.minecraft.world.entity.EntityType AXOLOTL -> f
    net.minecraft.world.entity.EntityType BAT -> g
    net.minecraft.world.entity.EntityType BEE -> h
    net.minecraft.world.entity.EntityType BLAZE -> i
    net.minecraft.world.entity.EntityType BOAT -> k
    net.minecraft.world.entity.EntityType BOGGED -> l
    net.minecraft.world.entity.EntityType BREEZE -> m
    net.minecraft.world.entity.EntityType BREEZE_WIND_CHARGE -> n
    net.minecraft.world.entity.EntityType CAMEL -> o
    net.minecraft.world.entity.EntityType CAT -> p
    net.minecraft.world.entity.EntityType CAVE_SPIDER -> q
    net.minecraft.world.entity.EntityType CHEST_BOAT -> r
    net.minecraft.world.entity.EntityType CHEST_MINECART -> s
    net.minecraft.world.entity.EntityType CHICKEN -> t
    net.minecraft.world.entity.EntityType COD -> u
    net.minecraft.world.entity.EntityType COMMAND_BLOCK_MINECART -> v
    net.minecraft.world.entity.EntityType COW -> w
    net.minecraft.world.entity.EntityType CREEPER -> x
    net.minecraft.world.entity.EntityType DOLPHIN -> y
    net.minecraft.world.entity.EntityType DONKEY -> z
    net.minecraft.world.entity.EntityType DRAGON_FIREBALL -> A
    net.minecraft.world.entity.EntityType DROWNED -> B
    net.minecraft.world.entity.EntityType EGG -> C
    net.minecraft.world.entity.EntityType ELDER_GUARDIAN -> D
    net.minecraft.world.entity.EntityType END_CRYSTAL -> E
    net.minecraft.world.entity.EntityType ENDER_DRAGON -> F
    net.minecraft.world.entity.EntityType ENDER_PEARL -> G
    net.minecraft.world.entity.EntityType ENDERMAN -> H
    net.minecraft.world.entity.EntityType ENDERMITE -> I
    net.minecraft.world.entity.EntityType EVOKER -> J
    net.minecraft.world.entity.EntityType EVOKER_FANGS -> K
    net.minecraft.world.entity.EntityType EXPERIENCE_BOTTLE -> L
    net.minecraft.world.entity.EntityType EXPERIENCE_ORB -> M
    net.minecraft.world.entity.EntityType EYE_OF_ENDER -> N
    net.minecraft.world.entity.EntityType FALLING_BLOCK -> O
    net.minecraft.world.entity.EntityType FIREWORK_ROCKET -> P
    net.minecraft.world.entity.EntityType FOX -> Q
    net.minecraft.world.entity.EntityType FROG -> R
    net.minecraft.world.entity.EntityType FURNACE_MINECART -> S
    net.minecraft.world.entity.EntityType GHAST -> T
    net.minecraft.world.entity.EntityType GIANT -> U
    net.minecraft.world.entity.EntityType GLOW_ITEM_FRAME -> V
    net.minecraft.world.entity.EntityType GLOW_SQUID -> W
    net.minecraft.world.entity.EntityType GOAT -> X
    net.minecraft.world.entity.EntityType GUARDIAN -> Y
    net.minecraft.world.entity.EntityType HOGLIN -> Z
    net.minecraft.world.entity.EntityType HOPPER_MINECART -> aa
    net.minecraft.world.entity.EntityType HORSE -> ab
    net.minecraft.world.entity.EntityType HUSK -> ac
    net.minecraft.world.entity.EntityType ILLUSIONER -> ad
    net.minecraft.world.entity.EntityType INTERACTION -> ae
    net.minecraft.world.entity.EntityType IRON_GOLEM -> af
    net.minecraft.world.entity.EntityType ITEM -> ag
    net.minecraft.world.entity.EntityType ITEM_DISPLAY -> ah
    net.minecraft.world.entity.EntityType ITEM_FRAME -> ai
    net.minecraft.world.entity.EntityType OMINOUS_ITEM_SPAWNER -> aj
    net.minecraft.world.entity.EntityType FIREBALL -> ak
    net.minecraft.world.entity.EntityType LEASH_KNOT -> al
    net.minecraft.world.entity.EntityType LIGHTNING_BOLT -> am
    net.minecraft.world.entity.EntityType LLAMA -> an
    net.minecraft.world.entity.EntityType LLAMA_SPIT -> ao
    net.minecraft.world.entity.EntityType MAGMA_CUBE -> ap
    net.minecraft.world.entity.EntityType MARKER -> aq
    net.minecraft.world.entity.EntityType MINECART -> ar
    net.minecraft.world.entity.EntityType MOOSHROOM -> as
    net.minecraft.world.entity.EntityType MULE -> at
    net.minecraft.world.entity.EntityType OCELOT -> au
    net.minecraft.world.entity.EntityType PAINTING -> av
    net.minecraft.world.entity.EntityType PANDA -> aw
    net.minecraft.world.entity.EntityType PARROT -> ax
    net.minecraft.world.entity.EntityType PHANTOM -> ay
    net.minecraft.world.entity.EntityType PIG -> az
    net.minecraft.world.entity.EntityType PIGLIN -> aA
    net.minecraft.world.entity.EntityType PIGLIN_BRUTE -> aB
    net.minecraft.world.entity.EntityType PILLAGER -> aC
    net.minecraft.world.entity.EntityType POLAR_BEAR -> aD
    net.minecraft.world.entity.EntityType POTION -> aE
    net.minecraft.world.entity.EntityType PUFFERFISH -> aF
    net.minecraft.world.entity.EntityType RABBIT -> aG
    net.minecraft.world.entity.EntityType RAVAGER -> aH
    net.minecraft.world.entity.EntityType SALMON -> aI
    net.minecraft.world.entity.EntityType SHEEP -> aJ
    net.minecraft.world.entity.EntityType SHULKER -> aK
    net.minecraft.world.entity.EntityType SHULKER_BULLET -> aL
    net.minecraft.world.entity.EntityType SILVERFISH -> aM
    net.minecraft.world.entity.EntityType SKELETON -> aN
    net.minecraft.world.entity.EntityType SKELETON_HORSE -> aO
    net.minecraft.world.entity.EntityType SLIME -> aP
    net.minecraft.world.entity.EntityType SMALL_FIREBALL -> aQ
    net.minecraft.world.entity.EntityType SNIFFER -> aR
    net.minecraft.world.entity.EntityType SNOW_GOLEM -> aS
    net.minecraft.world.entity.EntityType SNOWBALL -> aT
    net.minecraft.world.entity.EntityType SPAWNER_MINECART -> aU
    net.minecraft.world.entity.EntityType SPECTRAL_ARROW -> aV
    net.minecraft.world.entity.EntityType SPIDER -> aW
    net.minecraft.world.entity.EntityType SQUID -> aX
    net.minecraft.world.entity.EntityType STRAY -> aY
    net.minecraft.world.entity.EntityType STRIDER -> aZ
    net.minecraft.world.entity.EntityType TADPOLE -> ba
    net.minecraft.world.entity.EntityType TEXT_DISPLAY -> bb
    net.minecraft.world.entity.EntityType TNT -> bc
    net.minecraft.world.entity.EntityType TNT_MINECART -> bd
    net.minecraft.world.entity.EntityType TRADER_LLAMA -> be
    net.minecraft.world.entity.EntityType TRIDENT -> bf
    net.minecraft.world.entity.EntityType TROPICAL_FISH -> bg
    net.minecraft.world.entity.EntityType TURTLE -> bh
    net.minecraft.world.entity.EntityType VEX -> bi
    net.minecraft.world.entity.EntityType VILLAGER -> bj
    net.minecraft.world.entity.EntityType VINDICATOR -> bk
    net.minecraft.world.entity.EntityType WANDERING_TRADER -> bl
    net.minecraft.world.entity.EntityType WARDEN -> bm
    net.minecraft.world.entity.EntityType WIND_CHARGE -> bn
    net.minecraft.world.entity.EntityType WITCH -> bo
    net.minecraft.world.entity.EntityType WITHER -> bp
    net.minecraft.world.entity.EntityType WITHER_SKELETON -> bq
    net.minecraft.world.entity.EntityType WITHER_SKULL -> br
    net.minecraft.world.entity.EntityType WOLF -> bs
    net.minecraft.world.entity.EntityType ZOGLIN -> bt
    net.minecraft.world.entity.EntityType ZOMBIE -> bu
    net.minecraft.world.entity.EntityType ZOMBIE_HORSE -> bv
    net.minecraft.world.entity.EntityType ZOMBIE_VILLAGER -> bw
    net.minecraft.world.entity.EntityType ZOMBIFIED_PIGLIN -> bx
    net.minecraft.world.entity.EntityType PLAYER -> by
    net.minecraft.world.entity.EntityType FISHING_BOBBER -> bz
    net.minecraft.world.entity.EntityType$EntityFactory factory -> bF
    net.minecraft.world.entity.MobCategory category -> bG
    com.google.common.collect.ImmutableSet immuneTo -> bH
    boolean serialize -> bI
    boolean summon -> bJ
    boolean fireImmune -> bK
    boolean canSpawnFarFromPlayer -> bL
    int clientTrackingRange -> bM
    int updateInterval -> bN
    java.lang.String descriptionId -> bO
    net.minecraft.network.chat.Component description -> bP
    net.minecraft.resources.ResourceKey lootTable -> bQ
    net.minecraft.world.entity.EntityDimensions dimensions -> bR
    float spawnDimensionsScale -> bS
    net.minecraft.world.flag.FeatureFlagSet requiredFeatures -> bT
    179:179:net.minecraft.world.entity.EntityType register(java.lang.String,net.minecraft.world.entity.EntityType$Builder) -> a
    326:326:net.minecraft.resources.ResourceLocation getKey(net.minecraft.world.entity.EntityType) -> a
    330:330:java.util.Optional byString(java.lang.String) -> a
    176:365:void <init>(net.minecraft.world.entity.EntityType$EntityFactory,net.minecraft.world.entity.MobCategory,boolean,boolean,boolean,boolean,com.google.common.collect.ImmutableSet,net.minecraft.world.entity.EntityDimensions,float,int,int,net.minecraft.world.flag.FeatureFlagSet) -> <init>
    370:376:net.minecraft.world.entity.Entity spawn(net.minecraft.server.level.ServerLevel,net.minecraft.world.item.ItemStack,net.minecraft.world.entity.player.Player,net.minecraft.core.BlockPos,net.minecraft.world.entity.MobSpawnType,boolean,boolean) -> a
    383:383:java.util.function.Consumer createDefaultStackConfig(net.minecraft.server.level.ServerLevel,net.minecraft.world.item.ItemStack,net.minecraft.world.entity.player.Player) -> a
    387:387:java.util.function.Consumer appendDefaultStackConfig(java.util.function.Consumer,net.minecraft.server.level.ServerLevel,net.minecraft.world.item.ItemStack,net.minecraft.world.entity.player.Player) -> a
    391:395:java.util.function.Consumer appendCustomNameConfig(java.util.function.Consumer,net.minecraft.world.item.ItemStack) -> a
    399:403:java.util.function.Consumer appendCustomEntityStackConfig(java.util.function.Consumer,net.minecraft.server.level.ServerLevel,net.minecraft.world.item.ItemStack,net.minecraft.world.entity.player.Player) -> b
    408:408:net.minecraft.world.entity.Entity spawn(net.minecraft.server.level.ServerLevel,net.minecraft.core.BlockPos,net.minecraft.world.entity.MobSpawnType) -> a
    413:417:net.minecraft.world.entity.Entity spawn(net.minecraft.server.level.ServerLevel,java.util.function.Consumer,net.minecraft.core.BlockPos,net.minecraft.world.entity.MobSpawnType,boolean,boolean) -> a
    425:455:net.minecraft.world.entity.Entity create(net.minecraft.server.level.ServerLevel,java.util.function.Consumer,net.minecraft.core.BlockPos,net.minecraft.world.entity.MobSpawnType,boolean,boolean) -> b
    459:465:double getYOffset(net.minecraft.world.level.LevelReader,net.minecraft.core.BlockPos,boolean,net.minecraft.world.phys.AABB) -> a
    469:479:void updateCustomEntityTag(net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,net.minecraft.world.entity.Entity,net.minecraft.world.item.component.CustomData) -> a
    482:482:boolean canSerialize() -> b
    486:486:boolean canSummon() -> c
    490:490:boolean fireImmune() -> d
    494:494:boolean canSpawnFarFromPlayer() -> e
    498:498:net.minecraft.world.entity.MobCategory getCategory() -> f
    502:505:java.lang.String getDescriptionId() -> g
    509:512:net.minecraft.network.chat.Component getDescription() -> h
    517:517:java.lang.String toString() -> toString
    521:522:java.lang.String toShortString() -> j
    526:531:net.minecraft.resources.ResourceKey getDefaultLootTable() -> k
    535:535:float getWidth() -> l
    539:539:float getHeight() -> m
    544:544:net.minecraft.world.flag.FeatureFlagSet requiredFeatures() -> i
    549:552:net.minecraft.world.entity.Entity create(net.minecraft.world.level.Level) -> a
    556:556:java.util.Optional create(net.minecraft.nbt.CompoundTag,net.minecraft.world.level.Level) -> a
    563:565:net.minecraft.world.phys.AABB getSpawnAABB(double,double,double) -> a
    576:582:boolean isBlockDangerous(net.minecraft.world.level.block.state.BlockState) -> a
    586:586:net.minecraft.world.entity.EntityDimensions getDimensions() -> n
    590:590:java.util.Optional by(net.minecraft.nbt.CompoundTag) -> a
    595:609:net.minecraft.world.entity.Entity loadEntityRecursive(net.minecraft.nbt.CompoundTag,net.minecraft.world.level.Level,java.util.function.Function) -> a
    613:614:java.util.stream.Stream loadEntitiesRecursive(java.util.List,net.minecraft.world.level.Level) -> a
    644:647:java.util.Optional loadStaticEntity(net.minecraft.nbt.CompoundTag,net.minecraft.world.level.Level) -> b
    652:652:int clientTrackingRange() -> o
    656:656:int updateInterval() -> p
    661:661:boolean trackDeltas() -> q
    675:675:boolean is(net.minecraft.tags.TagKey) -> a
    679:679:boolean is(net.minecraft.core.HolderSet) -> a
    686:686:net.minecraft.world.entity.Entity tryCast(net.minecraft.world.entity.Entity) -> a
    691:691:java.lang.Class getBaseClass() -> a
    699:699:net.minecraft.core.Holder$Reference builtInRegistryHolder() -> r
    174:174:java.lang.Object tryCast(java.lang.Object) -> a
    598:608:net.minecraft.world.entity.Entity lambda$loadEntityRecursive$7(net.minecraft.nbt.CompoundTag,net.minecraft.world.level.Level,java.util.function.Function,net.minecraft.world.entity.Entity) -> a
    558:558:void lambda$create$6(net.minecraft.nbt.CompoundTag) -> b
    557:557:void lambda$create$5(net.minecraft.nbt.CompoundTag,net.minecraft.world.entity.Entity) -> a
    556:556:net.minecraft.world.entity.Entity lambda$create$4(net.minecraft.world.level.Level,net.minecraft.world.entity.EntityType) -> a
    401:401:void lambda$appendCustomEntityStackConfig$3(net.minecraft.server.level.ServerLevel,net.minecraft.world.entity.player.Player,net.minecraft.world.item.component.CustomData,net.minecraft.world.entity.Entity) -> a
    393:393:void lambda$appendCustomNameConfig$2(net.minecraft.network.chat.Component,net.minecraft.world.entity.Entity) -> a
    383:383:void lambda$createDefaultStackConfig$1(net.minecraft.world.entity.Entity) -> b
    373:373:void lambda$spawn$0(net.minecraft.world.entity.Entity) -> c
    175:323:void <clinit>() -> <clinit>
 */
class EntityType(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_entity_EntityType)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = EntityType::class.classDesc

		val BLOCK_DISPLAY: EntityType
			get() = EntityType(clazz.getField("j").get(null))
	}
}