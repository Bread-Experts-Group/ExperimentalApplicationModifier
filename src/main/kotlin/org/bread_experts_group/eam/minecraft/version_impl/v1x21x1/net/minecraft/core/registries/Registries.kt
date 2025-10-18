package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.registries

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.Registry
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceKey
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.CreativeModeTab
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_core_registries_Registries
import java.lang.constant.ClassDesc

/*
net.minecraft.core.registries.Registries -> lu:
# {"fileName":"Registries.java","id":"sourceFile"}
    net.minecraft.resources.ResourceLocation ROOT_REGISTRY_NAME -> a
    net.minecraft.resources.ResourceKey ACTIVITY -> b
    net.minecraft.resources.ResourceKey ATTRIBUTE -> c
    net.minecraft.resources.ResourceKey BANNER_PATTERN -> d
    net.minecraft.resources.ResourceKey BIOME_SOURCE -> e
    net.minecraft.resources.ResourceKey BLOCK -> f
    net.minecraft.resources.ResourceKey BLOCK_TYPE -> g
    net.minecraft.resources.ResourceKey BLOCK_ENTITY_TYPE -> h
    net.minecraft.resources.ResourceKey BLOCK_PREDICATE_TYPE -> i
    net.minecraft.resources.ResourceKey BLOCK_STATE_PROVIDER_TYPE -> j
    net.minecraft.resources.ResourceKey CARVER -> k
    net.minecraft.resources.ResourceKey CAT_VARIANT -> l
    net.minecraft.resources.ResourceKey WOLF_VARIANT -> m
    net.minecraft.resources.ResourceKey CHUNK_GENERATOR -> n
    net.minecraft.resources.ResourceKey CHUNK_STATUS -> o
    net.minecraft.resources.ResourceKey COMMAND_ARGUMENT_TYPE -> p
    net.minecraft.resources.ResourceKey CREATIVE_MODE_TAB -> q
    net.minecraft.resources.ResourceKey CUSTOM_STAT -> r
    net.minecraft.resources.ResourceKey DAMAGE_TYPE -> s
    net.minecraft.resources.ResourceKey DENSITY_FUNCTION_TYPE -> t
    net.minecraft.resources.ResourceKey ENCHANTMENT_ENTITY_EFFECT_TYPE -> u
    net.minecraft.resources.ResourceKey ENCHANTMENT_LEVEL_BASED_VALUE_TYPE -> v
    net.minecraft.resources.ResourceKey ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE -> w
    net.minecraft.resources.ResourceKey ENCHANTMENT_PROVIDER_TYPE -> x
    net.minecraft.resources.ResourceKey ENCHANTMENT_VALUE_EFFECT_TYPE -> y
    net.minecraft.resources.ResourceKey ENTITY_TYPE -> z
    net.minecraft.resources.ResourceKey FEATURE -> A
    net.minecraft.resources.ResourceKey FEATURE_SIZE_TYPE -> B
    net.minecraft.resources.ResourceKey FLOAT_PROVIDER_TYPE -> C
    net.minecraft.resources.ResourceKey FLUID -> D
    net.minecraft.resources.ResourceKey FOLIAGE_PLACER_TYPE -> E
    net.minecraft.resources.ResourceKey FROG_VARIANT -> F
    net.minecraft.resources.ResourceKey GAME_EVENT -> G
    net.minecraft.resources.ResourceKey HEIGHT_PROVIDER_TYPE -> H
    net.minecraft.resources.ResourceKey INSTRUMENT -> I
    net.minecraft.resources.ResourceKey INT_PROVIDER_TYPE -> J
    net.minecraft.resources.ResourceKey ITEM -> K
    net.minecraft.resources.ResourceKey JUKEBOX_SONG -> L
    net.minecraft.resources.ResourceKey LOOT_CONDITION_TYPE -> M
    net.minecraft.resources.ResourceKey LOOT_FUNCTION_TYPE -> N
    net.minecraft.resources.ResourceKey LOOT_NBT_PROVIDER_TYPE -> O
    net.minecraft.resources.ResourceKey LOOT_NUMBER_PROVIDER_TYPE -> P
    net.minecraft.resources.ResourceKey LOOT_POOL_ENTRY_TYPE -> Q
    net.minecraft.resources.ResourceKey LOOT_SCORE_PROVIDER_TYPE -> R
    net.minecraft.resources.ResourceKey MATERIAL_CONDITION -> S
    net.minecraft.resources.ResourceKey MATERIAL_RULE -> T
    net.minecraft.resources.ResourceKey MEMORY_MODULE_TYPE -> U
    net.minecraft.resources.ResourceKey MENU -> V
    net.minecraft.resources.ResourceKey MOB_EFFECT -> W
    net.minecraft.resources.ResourceKey PAINTING_VARIANT -> X
    net.minecraft.resources.ResourceKey PARTICLE_TYPE -> Y
    net.minecraft.resources.ResourceKey PLACEMENT_MODIFIER_TYPE -> Z
    net.minecraft.resources.ResourceKey POINT_OF_INTEREST_TYPE -> aa
    net.minecraft.resources.ResourceKey POSITION_SOURCE_TYPE -> ab
    net.minecraft.resources.ResourceKey POS_RULE_TEST -> ac
    net.minecraft.resources.ResourceKey POTION -> ad
    net.minecraft.resources.ResourceKey RECIPE_SERIALIZER -> ae
    net.minecraft.resources.ResourceKey RECIPE_TYPE -> af
    net.minecraft.resources.ResourceKey ROOT_PLACER_TYPE -> ag
    net.minecraft.resources.ResourceKey RULE_TEST -> ah
    net.minecraft.resources.ResourceKey RULE_BLOCK_ENTITY_MODIFIER -> ai
    net.minecraft.resources.ResourceKey SCHEDULE -> aj
    net.minecraft.resources.ResourceKey SENSOR_TYPE -> ak
    net.minecraft.resources.ResourceKey SOUND_EVENT -> al
    net.minecraft.resources.ResourceKey STAT_TYPE -> am
    net.minecraft.resources.ResourceKey STRUCTURE_PIECE -> an
    net.minecraft.resources.ResourceKey STRUCTURE_PLACEMENT -> ao
    net.minecraft.resources.ResourceKey STRUCTURE_POOL_ELEMENT -> ap
    net.minecraft.resources.ResourceKey POOL_ALIAS_BINDING -> aq
    net.minecraft.resources.ResourceKey STRUCTURE_PROCESSOR -> ar
    net.minecraft.resources.ResourceKey STRUCTURE_TYPE -> as
    net.minecraft.resources.ResourceKey TREE_DECORATOR_TYPE -> at
    net.minecraft.resources.ResourceKey TRUNK_PLACER_TYPE -> au
    net.minecraft.resources.ResourceKey VILLAGER_PROFESSION -> av
    net.minecraft.resources.ResourceKey VILLAGER_TYPE -> aw
    net.minecraft.resources.ResourceKey DECORATED_POT_PATTERN -> ax
    net.minecraft.resources.ResourceKey NUMBER_FORMAT_TYPE -> ay
    net.minecraft.resources.ResourceKey ARMOR_MATERIAL -> az
    net.minecraft.resources.ResourceKey DATA_COMPONENT_TYPE -> aA
    net.minecraft.resources.ResourceKey ENTITY_SUB_PREDICATE_TYPE -> aB
    net.minecraft.resources.ResourceKey ITEM_SUB_PREDICATE_TYPE -> aC
    net.minecraft.resources.ResourceKey MAP_DECORATION_TYPE -> aD
    net.minecraft.resources.ResourceKey ENCHANTMENT_EFFECT_COMPONENT_TYPE -> aE
    net.minecraft.resources.ResourceKey BIOME -> aF
    net.minecraft.resources.ResourceKey CHAT_TYPE -> aG
    net.minecraft.resources.ResourceKey CONFIGURED_CARVER -> aH
    net.minecraft.resources.ResourceKey CONFIGURED_FEATURE -> aI
    net.minecraft.resources.ResourceKey DENSITY_FUNCTION -> aJ
    net.minecraft.resources.ResourceKey DIMENSION_TYPE -> aK
    net.minecraft.resources.ResourceKey ENCHANTMENT -> aL
    net.minecraft.resources.ResourceKey ENCHANTMENT_PROVIDER -> aM
    net.minecraft.resources.ResourceKey FLAT_LEVEL_GENERATOR_PRESET -> aN
    net.minecraft.resources.ResourceKey NOISE_SETTINGS -> aO
    net.minecraft.resources.ResourceKey NOISE -> aP
    net.minecraft.resources.ResourceKey PLACED_FEATURE -> aQ
    net.minecraft.resources.ResourceKey STRUCTURE -> aR
    net.minecraft.resources.ResourceKey PROCESSOR_LIST -> aS
    net.minecraft.resources.ResourceKey STRUCTURE_SET -> aT
    net.minecraft.resources.ResourceKey TEMPLATE_POOL -> aU
    net.minecraft.resources.ResourceKey TRIGGER_TYPE -> aV
    net.minecraft.resources.ResourceKey TRIM_MATERIAL -> aW
    net.minecraft.resources.ResourceKey TRIM_PATTERN -> aX
    net.minecraft.resources.ResourceKey WORLD_PRESET -> aY
    net.minecraft.resources.ResourceKey MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST -> aZ
    net.minecraft.resources.ResourceKey DIMENSION -> ba
    net.minecraft.resources.ResourceKey LEVEL_STEM -> bb
    net.minecraft.resources.ResourceKey LOOT_TABLE -> bc
    net.minecraft.resources.ResourceKey ITEM_MODIFIER -> bd
    net.minecraft.resources.ResourceKey PREDICATE -> be
    net.minecraft.resources.ResourceKey ADVANCEMENT -> bf
    net.minecraft.resources.ResourceKey RECIPE -> bg
    112:112:void <init>() -> <init>
    242:242:net.minecraft.resources.ResourceKey levelStemToLevel(net.minecraft.resources.ResourceKey) -> a
    246:246:net.minecraft.resources.ResourceKey levelToLevelStem(net.minecraft.resources.ResourceKey) -> b
    250:250:net.minecraft.resources.ResourceKey createRegistryKey(java.lang.String) -> a
    255:255:java.lang.String elementsDirPath(net.minecraft.resources.ResourceKey) -> c
    260:260:java.lang.String tagsDirPath(net.minecraft.resources.ResourceKey) -> d
    113:239:void <clinit>() -> <clinit>
 */
class Registries(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_core_registries_Registries)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Registries::class.classDesc

		val CREATIVE_MODE_TAB: ResourceKey<Registry<CreativeModeTab>> =
			ResourceKey(clazz.getField("q").get(null))
	}
}