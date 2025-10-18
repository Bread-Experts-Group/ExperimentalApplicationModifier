package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.Registry
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.registries.Registries
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceKey
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_CreativeModeTabs
import java.lang.constant.ClassDesc

/*
net.minecraft.world.item.CreativeModeTabs -> ctb:
# {"fileName":"CreativeModeTabs.java","id":"sourceFile"}
    net.minecraft.resources.ResourceLocation INVENTORY_BACKGROUND -> a
    net.minecraft.resources.ResourceLocation SEARCH_BACKGROUND -> b
    net.minecraft.resources.ResourceKey BUILDING_BLOCKS -> c
    net.minecraft.resources.ResourceKey COLORED_BLOCKS -> d
    net.minecraft.resources.ResourceKey NATURAL_BLOCKS -> e
    net.minecraft.resources.ResourceKey FUNCTIONAL_BLOCKS -> f
    net.minecraft.resources.ResourceKey REDSTONE_BLOCKS -> g
    net.minecraft.resources.ResourceKey HOTBAR -> h
    net.minecraft.resources.ResourceKey SEARCH -> i
    net.minecraft.resources.ResourceKey TOOLS_AND_UTILITIES -> j
    net.minecraft.resources.ResourceKey COMBAT -> k
    net.minecraft.resources.ResourceKey FOOD_AND_DRINKS -> l
    net.minecraft.resources.ResourceKey INGREDIENTS -> m
    net.minecraft.resources.ResourceKey SPAWN_EGGS -> n
    net.minecraft.resources.ResourceKey OP_BLOCKS -> o
    net.minecraft.resources.ResourceKey INVENTORY -> p
    java.util.Comparator PAINTING_COMPARATOR -> q
    net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters CACHED_PARAMETERS -> r
    44:44:void <init>() -> <init>
    49:49:net.minecraft.resources.ResourceKey createKey(java.lang.String) -> a
    68:2056:net.minecraft.world.item.CreativeModeTab bootstrap(net.minecraft.core.Registry) -> a
    2060:2069:void validate() -> a
    2077:2077:net.minecraft.world.item.CreativeModeTab getDefaultTab() -> b
    2081:2085:void generatePotionEffectTypes(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.core.HolderLookup,net.minecraft.world.item.Item,net.minecraft.world.item.CreativeModeTab$TabVisibility,net.minecraft.world.flag.FeatureFlagSet) -> a
    2088:2091:void generateEnchantmentBookTypesOnlyMaxLevel(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.core.HolderLookup,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
    2094:2097:void generateEnchantmentBookTypesAllLevels(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.core.HolderLookup,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> b
    2100:2105:void generateInstrumentTypes(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.core.HolderLookup,net.minecraft.world.item.Item,net.minecraft.tags.TagKey,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
    2108:2116:void generateSuspiciousStews(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
    2119:2124:void generateOminousVials(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> b
    2127:2132:void generateFireworksAllDurations(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> c
    2135:2147:void generatePresetPaintings(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.core.HolderLookup$Provider,net.minecraft.core.HolderLookup$RegistryLookup,java.util.function.Predicate,net.minecraft.world.item.CreativeModeTab$TabVisibility) -> a
    2150:2150:java.util.List tabs() -> c
    2154:2154:java.util.List allTabs() -> d
    2158:2158:java.util.stream.Stream streamAllTabs() -> f
    2162:2162:net.minecraft.world.item.CreativeModeTab searchTab() -> e
    2166:2169:void buildAllTabContents(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters) -> a
    2172:2178:boolean tryRebuildTabContents(net.minecraft.world.flag.FeatureFlagSet,boolean,net.minecraft.core.HolderLookup$Provider) -> a
    2168:2168:void lambda$buildAllTabContents$50(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab) -> a
    2168:2168:boolean lambda$buildAllTabContents$49(net.minecraft.world.item.CreativeModeTab) -> a
    2166:2166:void lambda$buildAllTabContents$48(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab) -> b
    2166:2166:boolean lambda$buildAllTabContents$47(net.minecraft.world.item.CreativeModeTab) -> b
    2140:2146:void lambda$generatePresetPaintings$46(net.minecraft.resources.RegistryOps,net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$TabVisibility,net.minecraft.core.Holder$Reference) -> a
    2141:2141:void lambda$generatePresetPaintings$45(net.minecraft.nbt.CompoundTag) -> a
    2101:2103:void lambda$generateInstrumentTypes$44(net.minecraft.world.item.Item,net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$TabVisibility,net.minecraft.core.HolderSet$Named) -> a
    2103:2103:void lambda$generateInstrumentTypes$43(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$TabVisibility,net.minecraft.world.item.ItemStack) -> a
    2102:2102:net.minecraft.world.item.ItemStack lambda$generateInstrumentTypes$42(net.minecraft.world.item.Item,net.minecraft.core.Holder) -> a
    2096:2096:void lambda$generateEnchantmentBookTypesAllLevels$41(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$TabVisibility,net.minecraft.world.item.ItemStack) -> b
    2095:2095:java.util.stream.Stream lambda$generateEnchantmentBookTypesAllLevels$40(net.minecraft.core.Holder$Reference) -> a
    2095:2095:net.minecraft.world.item.ItemStack lambda$generateEnchantmentBookTypesAllLevels$39(net.minecraft.core.Holder$Reference,int) -> a
    2090:2090:void lambda$generateEnchantmentBookTypesOnlyMaxLevel$38(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$TabVisibility,net.minecraft.world.item.ItemStack) -> c
    2089:2089:net.minecraft.world.item.ItemStack lambda$generateEnchantmentBookTypesOnlyMaxLevel$37(net.minecraft.core.Holder$Reference) -> b
    2084:2084:void lambda$generatePotionEffectTypes$36(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$TabVisibility,net.minecraft.world.item.ItemStack) -> d
    2083:2083:net.minecraft.world.item.ItemStack lambda$generatePotionEffectTypes$35(net.minecraft.world.item.Item,net.minecraft.core.Holder$Reference) -> a
    2082:2082:boolean lambda$generatePotionEffectTypes$34(net.minecraft.world.flag.FeatureFlagSet,net.minecraft.core.Holder$Reference) -> a
    2050:2050:net.minecraft.world.item.ItemStack lambda$bootstrap$33() -> g
    2029:2046:void lambda$bootstrap$32(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> a
    2043:2043:void lambda$bootstrap$31(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.core.HolderLookup$RegistryLookup) -> a
    2043:2043:boolean lambda$bootstrap$30(net.minecraft.core.Holder) -> a
    2025:2025:net.minecraft.world.item.ItemStack lambda$bootstrap$29() -> h
    1937:2021:void lambda$bootstrap$28(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> b
    1932:1932:net.minecraft.world.item.ItemStack lambda$bootstrap$27() -> i
    1731:1928:void lambda$bootstrap$26(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> c
    1925:1927:void lambda$bootstrap$25(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.core.HolderLookup$RegistryLookup) -> a
    1726:1726:net.minecraft.world.item.ItemStack lambda$bootstrap$24() -> j
    1658:1722:void lambda$bootstrap$23(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> d
    1718:1721:void lambda$bootstrap$22(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.core.HolderLookup$RegistryLookup) -> b
    1655:1655:net.minecraft.world.item.ItemStack lambda$bootstrap$21() -> k
    1564:1651:void lambda$bootstrap$20(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> e
    1649:1649:void lambda$bootstrap$19(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.core.HolderLookup$RegistryLookup) -> c
    1559:1559:net.minecraft.world.item.ItemStack lambda$bootstrap$18() -> l
    1422:1555:void lambda$bootstrap$17(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> f
    1530:1530:void lambda$bootstrap$16(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.core.HolderLookup$RegistryLookup) -> b
    1417:1417:net.minecraft.world.item.ItemStack lambda$bootstrap$15() -> m
    1403:1410:void lambda$bootstrap$14(net.minecraft.core.Registry,net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> a
    1401:1401:net.minecraft.world.item.ItemStack lambda$bootstrap$13() -> n
    1395:1395:net.minecraft.world.item.ItemStack lambda$bootstrap$12() -> o
    1298:1391:void lambda$bootstrap$11(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> g
    1295:1295:net.minecraft.world.item.ItemStack lambda$bootstrap$10() -> p
    1072:1291:void lambda$bootstrap$9(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> h
    1147:1147:void lambda$bootstrap$8(net.minecraft.world.item.CreativeModeTab$Output,net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.core.HolderLookup$RegistryLookup) -> d
    1147:1147:boolean lambda$bootstrap$7(net.minecraft.core.Holder) -> b
    1066:1066:net.minecraft.world.item.ItemStack lambda$bootstrap$6() -> q
    785:1062:void lambda$bootstrap$5(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> i
    780:780:net.minecraft.world.item.ItemStack lambda$bootstrap$4() -> r
    538:776:void lambda$bootstrap$3(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> j
    533:533:net.minecraft.world.item.ItemStack lambda$bootstrap$2() -> s
    75:529:void lambda$bootstrap$1(net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters,net.minecraft.world.item.CreativeModeTab$Output) -> k
    70:70:net.minecraft.world.item.ItemStack lambda$bootstrap$0() -> t
    45:2071:void <clinit>() -> <clinit>
 */
class CreativeModeTabs(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> by lazy { loadClass(net_minecraft_world_item_CreativeModeTabs) }
		override val classDesc: ClassDesc = ClassDesc.of(net_minecraft_world_item_CreativeModeTabs)
		override val mimicClassDesc: ClassDesc = CreativeModeTabs::class.classDesc

		private val BREADMOD: ResourceKey<CreativeModeTab> = createKey("breadmod", "breadmod")

		fun tabs(): List<CreativeModeTab> =
			(clazz.getMethod("c").invoke(null) as List<*>).map { CreativeModeTab(it!!) }

		private fun createKey(namespace: String, key: String): ResourceKey<CreativeModeTab> =
			ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.parse("$namespace:$key"))
	}

	// todo clean up
	object Temp {
		@JvmStatic
		fun registerTabs(registry: Registry<CreativeModeTab>) {
			println("Registering creative tabs")
			Registry.register(
				registry,
				BREADMOD,
				CreativeModeTab.builder(CreativeModeTab.Row.TOP, 7)
					.title(Component.literal("breadmod"))
					.displayItems()
					.build()
			)
		}
	}
}