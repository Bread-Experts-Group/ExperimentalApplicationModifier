package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.registries

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.DefaultedRegistry
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.Item
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.level.block.Block
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_core_registries_BuiltInRegistries

/*
    org.slf4j.Logger LOGGER -> aB
    java.util.Map LOADERS -> aC
    net.minecraft.core.WritableRegistry WRITABLE_REGISTRY -> aD
    net.minecraft.core.DefaultedRegistry GAME_EVENT -> a
    net.minecraft.core.Registry SOUND_EVENT -> b
    net.minecraft.core.DefaultedRegistry FLUID -> c
    net.minecraft.core.Registry MOB_EFFECT -> d
    net.minecraft.core.DefaultedRegistry ENTITY_TYPE -> f
    net.minecraft.core.Registry POTION -> h
    net.minecraft.core.Registry PARTICLE_TYPE -> i
    net.minecraft.core.Registry BLOCK_ENTITY_TYPE -> j
    net.minecraft.core.Registry CUSTOM_STAT -> k
    net.minecraft.core.DefaultedRegistry CHUNK_STATUS -> l
    net.minecraft.core.Registry RULE_TEST -> m
    net.minecraft.core.Registry RULE_BLOCK_ENTITY_MODIFIER -> n
    net.minecraft.core.Registry POS_RULE_TEST -> o
    net.minecraft.core.Registry MENU -> p
    net.minecraft.core.Registry RECIPE_TYPE -> q
    net.minecraft.core.Registry RECIPE_SERIALIZER -> r
    net.minecraft.core.Registry ATTRIBUTE -> s
    net.minecraft.core.Registry POSITION_SOURCE_TYPE -> t
    net.minecraft.core.Registry COMMAND_ARGUMENT_TYPE -> u
    net.minecraft.core.Registry STAT_TYPE -> v
    net.minecraft.core.DefaultedRegistry VILLAGER_TYPE -> w
    net.minecraft.core.DefaultedRegistry VILLAGER_PROFESSION -> x
    net.minecraft.core.Registry POINT_OF_INTEREST_TYPE -> y
    net.minecraft.core.DefaultedRegistry MEMORY_MODULE_TYPE -> z
    net.minecraft.core.DefaultedRegistry SENSOR_TYPE -> A
    net.minecraft.core.Registry SCHEDULE -> B
    net.minecraft.core.Registry ACTIVITY -> C
    net.minecraft.core.Registry LOOT_POOL_ENTRY_TYPE -> D
    net.minecraft.core.Registry LOOT_FUNCTION_TYPE -> E
    net.minecraft.core.Registry LOOT_CONDITION_TYPE -> F
    net.minecraft.core.Registry LOOT_NUMBER_PROVIDER_TYPE -> G
    net.minecraft.core.Registry LOOT_NBT_PROVIDER_TYPE -> H
    net.minecraft.core.Registry LOOT_SCORE_PROVIDER_TYPE -> I
    net.minecraft.core.Registry FLOAT_PROVIDER_TYPE -> J
    net.minecraft.core.Registry INT_PROVIDER_TYPE -> K
    net.minecraft.core.Registry HEIGHT_PROVIDER_TYPE -> L
    net.minecraft.core.Registry BLOCK_PREDICATE_TYPE -> M
    net.minecraft.core.Registry CARVER -> N
    net.minecraft.core.Registry FEATURE -> O
    net.minecraft.core.Registry STRUCTURE_PLACEMENT -> P
    net.minecraft.core.Registry STRUCTURE_PIECE -> Q
    net.minecraft.core.Registry STRUCTURE_TYPE -> R
    net.minecraft.core.Registry PLACEMENT_MODIFIER_TYPE -> S
    net.minecraft.core.Registry BLOCKSTATE_PROVIDER_TYPE -> T
    net.minecraft.core.Registry FOLIAGE_PLACER_TYPE -> U
    net.minecraft.core.Registry TRUNK_PLACER_TYPE -> V
    net.minecraft.core.Registry ROOT_PLACER_TYPE -> W
    net.minecraft.core.Registry TREE_DECORATOR_TYPE -> X
    net.minecraft.core.Registry FEATURE_SIZE_TYPE -> Y
    net.minecraft.core.Registry BIOME_SOURCE -> Z
    net.minecraft.core.Registry CHUNK_GENERATOR -> aa
    net.minecraft.core.Registry MATERIAL_CONDITION -> ab
    net.minecraft.core.Registry MATERIAL_RULE -> ac
    net.minecraft.core.Registry DENSITY_FUNCTION_TYPE -> ad
    net.minecraft.core.Registry BLOCK_TYPE -> ae
    net.minecraft.core.Registry STRUCTURE_PROCESSOR -> af
    net.minecraft.core.Registry STRUCTURE_POOL_ELEMENT -> ag
    net.minecraft.core.Registry POOL_ALIAS_BINDING_TYPE -> ah
    net.minecraft.core.Registry CAT_VARIANT -> ai
    net.minecraft.core.Registry FROG_VARIANT -> aj
    net.minecraft.core.Registry INSTRUMENT -> ak
    net.minecraft.core.Registry DECORATED_POT_PATTERN -> al
    net.minecraft.core.Registry CREATIVE_MODE_TAB -> am
    net.minecraft.core.Registry TRIGGER_TYPES -> an
    net.minecraft.core.Registry NUMBER_FORMAT_TYPE -> ao
    net.minecraft.core.Registry ARMOR_MATERIAL -> ap
    net.minecraft.core.Registry DATA_COMPONENT_TYPE -> aq
    net.minecraft.core.Registry ENTITY_SUB_PREDICATE_TYPE -> ar
    net.minecraft.core.Registry ITEM_SUB_PREDICATE_TYPE -> as
    net.minecraft.core.Registry MAP_DECORATION_TYPE -> at
    net.minecraft.core.Registry ENCHANTMENT_EFFECT_COMPONENT_TYPE -> au
    net.minecraft.core.Registry ENCHANTMENT_LEVEL_BASED_VALUE_TYPE -> av
    net.minecraft.core.Registry ENCHANTMENT_ENTITY_EFFECT_TYPE -> aw
    net.minecraft.core.Registry ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE -> ax
    net.minecraft.core.Registry ENCHANTMENT_VALUE_EFFECT_TYPE -> ay
    net.minecraft.core.Registry ENCHANTMENT_PROVIDER_TYPE -> az
    net.minecraft.core.Registry REGISTRY -> aA
    131:131:void <init>() -> <init>
    221:221:net.minecraft.core.Registry registerSimple(net.minecraft.resources.ResourceKey,net.minecraft.core.registries.BuiltInRegistries$RegistryBootstrap) -> a
    225:225:net.minecraft.core.Registry registerSimpleWithIntrusiveHolders(net.minecraft.resources.ResourceKey,net.minecraft.core.registries.BuiltInRegistries$RegistryBootstrap) -> b
    229:229:net.minecraft.core.DefaultedRegistry registerDefaulted(net.minecraft.resources.ResourceKey,java.lang.String,net.minecraft.core.registries.BuiltInRegistries$RegistryBootstrap) -> a
    233:233:net.minecraft.core.DefaultedRegistry registerDefaultedWithIntrusiveHolders(net.minecraft.resources.ResourceKey,java.lang.String,net.minecraft.core.registries.BuiltInRegistries$RegistryBootstrap) -> b
    238:243:net.minecraft.core.WritableRegistry internalRegister(net.minecraft.resources.ResourceKey,net.minecraft.core.WritableRegistry,net.minecraft.core.registries.BuiltInRegistries$RegistryBootstrap) -> a
    247:250:void bootStrap() -> a
    253:259:void createContents() -> b
    262:266:void freeze() -> c
    269:279:void validate(net.minecraft.core.Registry) -> a
    270:278:void lambda$validate$50(net.minecraft.core.Registry,net.minecraft.core.Registry) -> a
    255:258:void lambda$createContents$49(net.minecraft.resources.ResourceLocation,java.util.function.Supplier) -> a
    240:240:java.lang.Object lambda$internalRegister$48(net.minecraft.core.registries.BuiltInRegistries$RegistryBootstrap,net.minecraft.core.WritableRegistry) -> a
    238:238:java.lang.String lambda$internalRegister$47(net.minecraft.resources.ResourceKey) -> a
    197:197:java.lang.Object lambda$static$46(net.minecraft.core.Registry) -> b
    196:196:java.lang.Object lambda$static$45(net.minecraft.core.Registry) -> c
    189:189:java.lang.Object lambda$static$44(net.minecraft.core.Registry) -> d
    188:188:java.lang.Object lambda$static$43(net.minecraft.core.Registry) -> e
    187:187:java.lang.Object lambda$static$42(net.minecraft.core.Registry) -> f
    186:186:java.lang.Object lambda$static$41(net.minecraft.core.Registry) -> g
    185:185:java.lang.Object lambda$static$40(net.minecraft.core.Registry) -> h
    184:184:java.lang.Object lambda$static$39(net.minecraft.core.Registry) -> i
    183:183:java.lang.Object lambda$static$38(net.minecraft.core.Registry) -> j
    182:182:java.lang.Object lambda$static$37(net.minecraft.core.Registry) -> k
    181:181:java.lang.Object lambda$static$36(net.minecraft.core.Registry) -> l
    180:180:java.lang.Object lambda$static$35(net.minecraft.core.Registry) -> m
    179:179:java.lang.Object lambda$static$34(net.minecraft.core.Registry) -> n
    178:178:java.lang.Object lambda$static$33(net.minecraft.core.Registry) -> o
    177:177:java.lang.Object lambda$static$32(net.minecraft.core.Registry) -> p
    176:176:java.lang.Object lambda$static$31(net.minecraft.core.Registry) -> q
    175:175:java.lang.Object lambda$static$30(net.minecraft.core.Registry) -> r
    174:174:java.lang.Object lambda$static$29(net.minecraft.core.Registry) -> s
    173:173:java.lang.Object lambda$static$28(net.minecraft.core.Registry) -> t
    172:172:java.lang.Object lambda$static$27(net.minecraft.core.Registry) -> u
    171:171:java.lang.Object lambda$static$26(net.minecraft.core.Registry) -> v
    170:170:java.lang.Object lambda$static$25(net.minecraft.core.Registry) -> w
    169:169:java.lang.Object lambda$static$24(net.minecraft.core.Registry) -> x
    168:168:java.lang.Object lambda$static$23(net.minecraft.core.Registry) -> y
    167:167:java.lang.Object lambda$static$22(net.minecraft.core.Registry) -> z
    166:166:java.lang.Object lambda$static$21(net.minecraft.core.Registry) -> A
    165:165:java.lang.Object lambda$static$20(net.minecraft.core.Registry) -> B
    164:164:java.lang.Object lambda$static$19(net.minecraft.core.Registry) -> C
    162:162:java.lang.Object lambda$static$18(net.minecraft.core.Registry) -> D
    161:161:java.lang.Object lambda$static$17(net.minecraft.core.Registry) -> E
    160:160:java.lang.Object lambda$static$16(net.minecraft.core.Registry) -> F
    158:158:java.lang.Object lambda$static$15(net.minecraft.core.Registry) -> G
    156:156:java.lang.Object lambda$static$14(net.minecraft.core.Registry) -> H
    155:155:java.lang.Object lambda$static$13(net.minecraft.core.Registry) -> I
    154:154:java.lang.Object lambda$static$12(net.minecraft.core.Registry) -> J
    153:153:java.lang.Object lambda$static$11(net.minecraft.core.Registry) -> K
    152:152:java.lang.Object lambda$static$10(net.minecraft.core.Registry) -> L
    151:151:java.lang.Object lambda$static$9(net.minecraft.core.Registry) -> M
    150:150:java.lang.Object lambda$static$8(net.minecraft.core.Registry) -> N
    149:149:java.lang.Object lambda$static$7(net.minecraft.core.Registry) -> O
    148:148:java.lang.Object lambda$static$6(net.minecraft.core.Registry) -> P
    147:147:java.lang.Object lambda$static$5(net.minecraft.core.Registry) -> Q
    145:145:java.lang.Object lambda$static$4(net.minecraft.core.Registry) -> R
    144:144:java.lang.Object lambda$static$3(net.minecraft.core.Registry) -> S
    143:143:java.lang.Object lambda$static$2(net.minecraft.core.Registry) -> T
    141:141:java.lang.Object lambda$static$1(net.minecraft.core.Registry) -> U
    140:140:java.lang.Object lambda$static$0(net.minecraft.core.Registry) -> V
    132:218:void <clinit>() -> <clinit>
 */
class BuiltInRegistries(around: Any) : MimickedClass(around) {
	companion object {
		private val clazz: Class<*> = loadClass(net_minecraft_core_registries_BuiltInRegistries)
		val BLOCK: DefaultedRegistry<Block>
			get() = DefaultedRegistry(Block::class.java, clazz.getField("e").get(null))
		val ITEM: DefaultedRegistry<Item>
			get() = DefaultedRegistry(Item::class.java, clazz.getField("g").get(null))
	}
}