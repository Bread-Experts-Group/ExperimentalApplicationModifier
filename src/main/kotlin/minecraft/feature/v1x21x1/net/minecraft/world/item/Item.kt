package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.food.FoodProperties
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_Item
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_Item_Properties
import java.lang.constant.ClassDesc

/*
    org.slf4j.Logger LOGGER -> a
    java.util.Map BY_BLOCK -> d
    net.minecraft.resources.ResourceLocation BASE_ATTACK_DAMAGE_ID -> e
    net.minecraft.resources.ResourceLocation BASE_ATTACK_SPEED_ID -> f
    int DEFAULT_MAX_STACK_SIZE -> g
    int ABSOLUTE_MAX_STACK_SIZE -> h
    int MAX_BAR_WIDTH -> i
    net.minecraft.core.Holder$Reference builtInRegistryHolder -> b
    net.minecraft.core.component.DataComponentMap components -> c
    net.minecraft.world.item.Item craftingRemainingItem -> j
    java.lang.String descriptionId -> k
    net.minecraft.world.flag.FeatureFlagSet requiredFeatures -> l
    74:74:int getId(net.minecraft.world.item.Item) -> a
    78:78:net.minecraft.world.item.Item byId(int) -> b
    84:84:net.minecraft.world.item.Item byBlock(net.minecraft.world.level.block.Block) -> a
    115:115:net.minecraft.core.Holder$Reference builtInRegistryHolder() -> o
    119:119:net.minecraft.core.component.DataComponentMap components() -> p
    123:123:int getDefaultMaxStackSize() -> q
    202:202:void onUseTick(net.minecraft.world.level.Level,net.minecraft.world.entity.LivingEntity,net.minecraft.world.item.ItemStack,int) -> a
    205:205:void onDestroyed(net.minecraft.world.entity.item.ItemEntity) -> a
    208:208:void verifyComponentsAfterLoad(net.minecraft.world.item.ItemStack) -> m
    211:211:boolean canAttackBlock(net.minecraft.world.level.block.state.BlockState,net.minecraft.world.level.Level,net.minecraft.core.BlockPos,net.minecraft.world.entity.player.Player) -> a
    216:216:net.minecraft.world.item.Item asItem() -> r
    220:220:net.minecraft.world.InteractionResult useOn(net.minecraft.world.item.context.UseOnContext) -> a
    224:225:float getDestroySpeed(net.minecraft.world.item.ItemStack,net.minecraft.world.level.block.state.BlockState) -> a
    229:238:net.minecraft.world.InteractionResultHolder use(net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,net.minecraft.world.InteractionHand) -> a
    242:246:net.minecraft.world.item.ItemStack finishUsingItem(net.minecraft.world.item.ItemStack,net.minecraft.world.level.Level,net.minecraft.world.entity.LivingEntity) -> a
    250:250:boolean isBarVisible(net.minecraft.world.item.ItemStack) -> d
    254:254:int getBarWidth(net.minecraft.world.item.ItemStack) -> e
    258:262:int getBarColor(net.minecraft.world.item.ItemStack) -> f
    269:269:boolean overrideStackedOnOther(net.minecraft.world.item.ItemStack,net.minecraft.world.inventory.Slot,net.minecraft.world.inventory.ClickAction,net.minecraft.world.entity.player.Player) -> a
    276:276:boolean overrideOtherStackedOnMe(net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemStack,net.minecraft.world.inventory.Slot,net.minecraft.world.inventory.ClickAction,net.minecraft.world.entity.player.Player,net.minecraft.world.entity.SlotAccess) -> a
    280:280:float getAttackDamageBonus(net.minecraft.world.entity.Entity,float,net.minecraft.world.damagesource.DamageSource) -> a
    287:287:boolean hurtEnemy(net.minecraft.world.item.ItemStack,net.minecraft.world.entity.LivingEntity,net.minecraft.world.entity.LivingEntity) -> a
    291:291:void postHurtEnemy(net.minecraft.world.item.ItemStack,net.minecraft.world.entity.LivingEntity,net.minecraft.world.entity.LivingEntity) -> b
    297:307:boolean mineBlock(net.minecraft.world.item.ItemStack,net.minecraft.world.level.Level,net.minecraft.world.level.block.state.BlockState,net.minecraft.core.BlockPos,net.minecraft.world.entity.LivingEntity) -> a
    311:312:boolean isCorrectToolForDrops(net.minecraft.world.item.ItemStack,net.minecraft.world.level.block.state.BlockState) -> b
    316:316:net.minecraft.world.InteractionResult interactLivingEntity(net.minecraft.world.item.ItemStack,net.minecraft.world.entity.player.Player,net.minecraft.world.entity.LivingEntity,net.minecraft.world.InteractionHand) -> a
    320:320:net.minecraft.network.chat.Component getDescription() -> s
    325:325:java.lang.String toString() -> toString
    329:332:java.lang.String getOrCreateDescriptionId() -> t
    339:339:java.lang.String getDescriptionId() -> a
    343:343:java.lang.String getDescriptionId(net.minecraft.world.item.ItemStack) -> h
    349:349:net.minecraft.world.item.Item getCraftingRemainingItem() -> u
    353:353:boolean hasCraftingRemainingItem() -> v
    357:357:void inventoryTick(net.minecraft.world.item.ItemStack,net.minecraft.world.level.Level,net.minecraft.world.entity.Entity,int,boolean) -> a
    360:361:void onCraftedBy(net.minecraft.world.item.ItemStack,net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player) -> b
    364:364:void onCraftedPostProcess(net.minecraft.world.item.ItemStack,net.minecraft.world.level.Level) -> a
    367:367:boolean isComplex() -> ao_
    371:371:net.minecraft.world.item.UseAnim getUseAnimation(net.minecraft.world.item.ItemStack) -> b
    375:379:int getUseDuration(net.minecraft.world.item.ItemStack,net.minecraft.world.entity.LivingEntity) -> a
    383:383:void releaseUsing(net.minecraft.world.item.ItemStack,net.minecraft.world.level.Level,net.minecraft.world.entity.LivingEntity,int) -> a
    386:386:void appendHoverText(net.minecraft.world.item.ItemStack,net.minecraft.world.item.Item$TooltipContext,java.util.List,net.minecraft.world.item.TooltipFlag) -> a
    389:389:java.util.Optional getTooltipImage(net.minecraft.world.item.ItemStack) -> g
    393:393:net.minecraft.network.chat.Component getName(net.minecraft.world.item.ItemStack) -> n
    397:397:boolean isFoil(net.minecraft.world.item.ItemStack) -> d_
    401:401:boolean isEnchantable(net.minecraft.world.item.ItemStack) -> a
    405:409:net.minecraft.world.phys.BlockHitResult getPlayerPOVHitResult(net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,net.minecraft.world.level.ClipContext$Fluid) -> a
    413:413:int getEnchantmentValue() -> g
    417:417:boolean isValidRepairItem(net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemStack) -> a
    425:425:net.minecraft.world.item.component.ItemAttributeModifiers getDefaultAttributeModifiers() -> j
    429:429:boolean useOnRelease(net.minecraft.world.item.ItemStack) -> l
    437:437:net.minecraft.sounds.SoundEvent getDrinkingSound() -> ap_
    441:441:net.minecraft.sounds.SoundEvent getEatingSound() -> aq_
    445:445:net.minecraft.sounds.SoundEvent getBreakingSound() -> e
    449:449:boolean canFitInsideContainerItems() -> ar_
    454:454:net.minecraft.world.flag.FeatureFlagSet requiredFeatures() -> i
    61:65:void <clinit>() -> <clinit>
net.minecraft.world.item.Item$Properties -> cul$a:
# {"fileName":"Item.java","id":"sourceFile"}
    com.google.common.collect.Interner COMPONENT_INTERNER -> a
    net.minecraft.core.component.DataComponentMap$Builder components -> b
    net.minecraft.world.item.Item craftingRemainingItem -> c
    net.minecraft.world.flag.FeatureFlagSet requiredFeatures -> d
    136:136:net.minecraft.world.item.Item$Properties food(net.minecraft.world.food.FoodProperties) -> a
    140:140:net.minecraft.world.item.Item$Properties stacksTo(int) -> a
    144:147:net.minecraft.world.item.Item$Properties durability(int) -> b
    151:152:net.minecraft.world.item.Item$Properties craftRemainder(net.minecraft.world.item.Item) -> a
    156:156:net.minecraft.world.item.Item$Properties rarity(net.minecraft.world.item.Rarity) -> a
    160:160:net.minecraft.world.item.Item$Properties fireResistant() -> a
    164:164:net.minecraft.world.item.Item$Properties jukeboxPlayable(net.minecraft.resources.ResourceKey) -> a
    168:169:net.minecraft.world.item.Item$Properties requiredFeatures(net.minecraft.world.flag.FeatureFlag[]) -> a
    173:177:net.minecraft.world.item.Item$Properties component(net.minecraft.core.component.DataComponentType,java.lang.Object) -> a
    181:181:net.minecraft.world.item.Item$Properties attributes(net.minecraft.world.item.component.ItemAttributeModifiers) -> a
    185:189:net.minecraft.core.component.DataComponentMap buildAndValidateComponents() -> b
    194:197:net.minecraft.core.component.DataComponentMap buildComponents() -> c
    127:127:void <clinit>() -> <clinit>
 */
class Item(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_world_item_Item)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
	
	constructor(properties: Properties) : this(
		clazz.getConstructor(Properties.clazz).newInstance(properties.around)
	)

	fun getDefaultInstance(): ItemStack = ItemStack(
		clazz.getMethod("w").invoke(around)
	)

	class Properties(around: Any) : MimickedClass(around) {
		companion object {
			val clazz: Class<*> = loadClass(net_minecraft_world_item_Item_Properties)
			val classDesc: ClassDesc = ClassDesc.of(clazz.name)
			val mimicClassDesc: ClassDesc = ClassDesc.of(Properties::class.java.name)
		}

		constructor() : this(clazz.getConstructor().newInstance())

		fun food(properties: FoodProperties): Properties = Properties(
			clazz.getMethod("a", FoodProperties.clazz)
				.invoke(this.around, properties.around)
		)

		fun stacksTo(n: Int): Properties = Properties(
			clazz.getMethod("a", Int::class.java).invoke(this.around, n)
		)
	}
}