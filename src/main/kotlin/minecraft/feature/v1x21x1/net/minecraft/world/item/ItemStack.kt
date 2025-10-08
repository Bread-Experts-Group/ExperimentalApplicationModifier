package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_ItemStack
import java.lang.constant.ClassDesc

/*
net.minecraft.world.item.ItemStack -> cuq:
# {"fileName":"ItemStack.java","id":"sourceFile"}
    com.mojang.serialization.Codec ITEM_NON_AIR_CODEC -> a
    com.mojang.serialization.Codec CODEC -> b
    com.mojang.serialization.Codec SINGLE_ITEM_CODEC -> c
    com.mojang.serialization.Codec STRICT_CODEC -> d
    com.mojang.serialization.Codec STRICT_SINGLE_ITEM_CODEC -> e
    com.mojang.serialization.Codec OPTIONAL_CODEC -> f
    com.mojang.serialization.Codec SIMPLE_ITEM_CODEC -> g
    net.minecraft.network.codec.StreamCodec OPTIONAL_STREAM_CODEC -> h
    net.minecraft.network.codec.StreamCodec STREAM_CODEC -> i
    net.minecraft.network.codec.StreamCodec OPTIONAL_LIST_STREAM_CODEC -> j
    net.minecraft.network.codec.StreamCodec LIST_STREAM_CODEC -> k
    org.slf4j.Logger LOGGER -> m
    net.minecraft.world.item.ItemStack EMPTY -> l
    net.minecraft.network.chat.Component DISABLED_ITEM_TOOLTIP -> n
    int count -> o
    int popTime -> p
    net.minecraft.world.item.Item item -> q
    net.minecraft.core.component.PatchedDataComponentMap components -> r
    net.minecraft.world.entity.Entity entityRepresentation -> s
    115:122:com.mojang.serialization.DataResult validateStrict(net.minecraft.world.item.ItemStack) -> b
    187:187:net.minecraft.network.codec.StreamCodec validatedStreamCodec(net.minecraft.network.codec.StreamCodec) -> a
    211:211:java.util.Optional getTooltipImage() -> b
    216:216:net.minecraft.core.component.DataComponentMap getComponents() -> a
    220:220:net.minecraft.core.component.DataComponentMap getPrototype() -> c
    224:224:net.minecraft.core.component.DataComponentPatch getComponentsPatch() -> d
    244:245:void <init>(net.minecraft.world.level.ItemLike) -> <init>
    248:249:void <init>(net.minecraft.core.Holder) -> <init>
    252:253:void <init>(net.minecraft.core.Holder,int,net.minecraft.core.component.DataComponentPatch) -> <init>
    256:257:void <init>(net.minecraft.core.Holder,int) -> <init>
    260:261:void <init>(net.minecraft.world.level.ItemLike,int) -> <init>
    263:268:void <init>(net.minecraft.world.level.ItemLike,int,net.minecraft.core.component.PatchedDataComponentMap) -> <init>
    270:273:void <init>(java.lang.Void) -> <init>
    276:287:com.mojang.serialization.DataResult validateComponents(net.minecraft.core.component.DataComponentMap) -> a
    291:292:java.util.Optional parse(net.minecraft.core.HolderLookup$Provider,net.minecraft.nbt.Tag) -> a
    296:299:net.minecraft.world.item.ItemStack parseOptional(net.minecraft.core.HolderLookup$Provider,net.minecraft.nbt.CompoundTag) -> a
    303:303:boolean isEmpty() -> e
    307:307:boolean isItemEnabled(net.minecraft.world.flag.FeatureFlagSet) -> a
    315:320:net.minecraft.world.item.ItemStack split(int) -> a
    324:329:net.minecraft.world.item.ItemStack copyAndClear() -> f
    334:334:net.minecraft.world.item.Item getItem() -> g
    338:338:net.minecraft.core.Holder getItemHolder() -> h
    342:342:boolean is(net.minecraft.tags.TagKey) -> a
    346:346:boolean is(net.minecraft.world.item.Item) -> a
    350:350:boolean is(java.util.function.Predicate) -> a
    354:354:boolean is(net.minecraft.core.Holder) -> a
    358:358:boolean is(net.minecraft.core.HolderSet) -> a
    362:362:java.util.stream.Stream getTags() -> i
    366:377:net.minecraft.world.InteractionResult useOn(net.minecraft.world.item.context.UseOnContext) -> a
    381:381:float getDestroySpeed(net.minecraft.world.level.block.state.BlockState) -> a
    385:385:net.minecraft.world.InteractionResultHolder use(net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,net.minecraft.world.InteractionHand) -> a
    389:389:net.minecraft.world.item.ItemStack finishUsingItem(net.minecraft.world.level.Level,net.minecraft.world.entity.LivingEntity) -> a
    393:396:net.minecraft.nbt.Tag save(net.minecraft.core.HolderLookup$Provider,net.minecraft.nbt.Tag) -> b
    400:403:net.minecraft.nbt.Tag save(net.minecraft.core.HolderLookup$Provider) -> a
    407:410:net.minecraft.nbt.Tag saveOptional(net.minecraft.core.HolderLookup$Provider) -> b
    414:414:int getMaxStackSize() -> j
    418:418:boolean isStackable() -> k
    422:422:boolean isDamageableItem() -> l
    426:426:boolean isDamaged() -> m
    430:430:int getDamageValue() -> n
    434:435:void setDamageValue(int) -> b
    438:438:int getMaxDamage() -> o
    442:470:void hurtAndBreak(int,net.minecraft.server.level.ServerLevel,net.minecraft.server.level.ServerPlayer,java.util.function.Consumer) -> a
    473:476:void hurtAndBreak(int,net.minecraft.world.entity.LivingEntity,net.minecraft.world.entity.EquipmentSlot) -> a
    479:487:net.minecraft.world.item.ItemStack hurtAndConvertOnBreak(int,net.minecraft.world.level.ItemLike,net.minecraft.world.entity.LivingEntity,net.minecraft.world.entity.EquipmentSlot) -> a
    491:491:boolean isBarVisible() -> p
    495:495:int getBarWidth() -> q
    499:499:int getBarColor() -> r
    503:503:boolean overrideStackedOnOther(net.minecraft.world.inventory.Slot,net.minecraft.world.inventory.ClickAction,net.minecraft.world.entity.player.Player) -> a
    507:507:boolean overrideOtherStackedOnMe(net.minecraft.world.item.ItemStack,net.minecraft.world.inventory.Slot,net.minecraft.world.inventory.ClickAction,net.minecraft.world.entity.player.Player,net.minecraft.world.entity.SlotAccess) -> a
    511:516:boolean hurtEnemy(net.minecraft.world.entity.LivingEntity,net.minecraft.world.entity.player.Player) -> a
    520:521:void postHurtEnemy(net.minecraft.world.entity.LivingEntity,net.minecraft.world.entity.player.Player) -> b
    524:528:void mineBlock(net.minecraft.world.level.Level,net.minecraft.world.level.block.state.BlockState,net.minecraft.core.BlockPos,net.minecraft.world.entity.player.Player) -> a
    531:531:boolean isCorrectToolForDrops(net.minecraft.world.level.block.state.BlockState) -> b
    535:535:net.minecraft.world.InteractionResult interactLivingEntity(net.minecraft.world.entity.player.Player,net.minecraft.world.entity.LivingEntity,net.minecraft.world.InteractionHand) -> a
    539:544:net.minecraft.world.item.ItemStack copy() -> s
    548:553:net.minecraft.world.item.ItemStack copyWithCount(int) -> c
    557:557:net.minecraft.world.item.ItemStack transmuteCopy(net.minecraft.world.level.ItemLike) -> a
    561:564:net.minecraft.world.item.ItemStack transmuteCopy(net.minecraft.world.level.ItemLike,int) -> a
    568:568:net.minecraft.world.item.ItemStack transmuteCopyIgnoreEmpty(net.minecraft.world.level.ItemLike,int) -> b
    572:578:boolean matches(net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemStack) -> a
    586:594:boolean listMatches(java.util.List,java.util.List) -> a
    598:598:boolean isSameItem(net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemStack) -> b
    602:608:boolean isSameItemSameComponents(net.minecraft.world.item.ItemStack,net.minecraft.world.item.ItemStack) -> c
    612:612:com.mojang.serialization.MapCodec lenientOptionalFieldOf(java.lang.String) -> a
    619:623:int hashItemAndComponents(net.minecraft.world.item.ItemStack) -> a
    631:635:int hashStackList(java.util.List) -> a
    639:639:java.lang.String getDescriptionId() -> t
    644:644:java.lang.String toString() -> toString
    648:654:void inventoryTick(net.minecraft.world.level.Level,net.minecraft.world.entity.Entity,int,boolean) -> a
    657:659:void onCraftedBy(net.minecraft.world.level.Level,net.minecraft.world.entity.player.Player,int) -> a
    662:663:void onCraftedBySystem(net.minecraft.world.level.Level) -> a
    666:666:int getUseDuration(net.minecraft.world.entity.LivingEntity) -> a
    670:670:net.minecraft.world.item.UseAnim getUseAnimation() -> u
    674:675:void releaseUsing(net.minecraft.world.level.Level,net.minecraft.world.entity.LivingEntity,int) -> a
    678:678:boolean useOnRelease() -> v
    683:683:java.lang.Object set(net.minecraft.core.component.DataComponentType,java.lang.Object) -> b
    688:688:java.lang.Object update(net.minecraft.core.component.DataComponentType,java.lang.Object,java.lang.Object,java.util.function.BiFunction) -> a
    693:694:java.lang.Object update(net.minecraft.core.component.DataComponentType,java.lang.Object,java.util.function.UnaryOperator) -> a
    699:699:java.lang.Object remove(net.minecraft.core.component.DataComponentType) -> c
    703:712:void applyComponentsAndValidate(net.minecraft.core.component.DataComponentPatch) -> a
    715:717:void applyComponents(net.minecraft.core.component.DataComponentPatch) -> b
    720:722:void applyComponents(net.minecraft.core.component.DataComponentMap) -> b
    725:733:net.minecraft.network.chat.Component getHoverName() -> w
    737:741:void addToTooltip(net.minecraft.core.component.DataComponentType,net.minecraft.world.item.Item$TooltipContext,java.util.function.Consumer,net.minecraft.world.item.TooltipFlag) -> a
    745:807:java.util.List getTooltipLines(net.minecraft.world.item.Item$TooltipContext,net.minecraft.world.entity.player.Player,net.minecraft.world.item.TooltipFlag) -> a
    811:826:void addAttributeTooltips(java.util.function.Consumer,net.minecraft.world.entity.player.Player) -> a
    830:876:void addModifierTooltip(java.util.function.Consumer,net.minecraft.world.entity.player.Player,net.minecraft.core.Holder,net.minecraft.world.entity.ai.attributes.AttributeModifier) -> a
    879:883:boolean hasFoil() -> x
    887:894:net.minecraft.world.item.Rarity getRarity() -> y
    899:903:boolean isEnchantable() -> z
    907:908:void enchant(net.minecraft.core.Holder,int) -> a
    911:911:boolean isEnchanted() -> A
    915:915:net.minecraft.world.item.enchantment.ItemEnchantments getEnchantments() -> B
    919:919:boolean isFramed() -> C
    923:926:void setEntityRepresentation(net.minecraft.world.entity.Entity) -> a
    930:930:net.minecraft.world.entity.decoration.ItemFrame getFrame() -> D
    935:935:net.minecraft.world.entity.Entity getEntityRepresentation() -> E
    939:946:void forEachModifier(net.minecraft.world.entity.EquipmentSlotGroup,java.util.function.BiConsumer) -> a
    949:956:void forEachModifier(net.minecraft.world.entity.EquipmentSlot,java.util.function.BiConsumer) -> a
    959:970:net.minecraft.network.chat.Component getDisplayName() -> F
    974:975:boolean canPlaceOnBlockInAdventureMode(net.minecraft.world.level.block.state.pattern.BlockInWorld) -> a
    979:980:boolean canBreakBlockInAdventureMode(net.minecraft.world.level.block.state.pattern.BlockInWorld) -> b
    984:984:int getPopTime() -> G
    988:989:void setPopTime(int) -> d
    992:992:int getCount() -> H
    996:997:void setCount(int) -> e
    1000:1003:void limitSize(int) -> f
    1006:1007:void grow(int) -> g
    1010:1011:void shrink(int) -> h
    1014:1017:void consume(int,net.minecraft.world.entity.LivingEntity) -> a
    1020:1022:net.minecraft.world.item.ItemStack consumeAndReturn(int,net.minecraft.world.entity.LivingEntity) -> b
    1026:1027:void onUseTick(net.minecraft.world.level.Level,net.minecraft.world.entity.LivingEntity,int) -> b
    1030:1031:void onDestroyed(net.minecraft.world.entity.item.ItemEntity) -> a
    1034:1034:net.minecraft.sounds.SoundEvent getDrinkingSound() -> I
    1038:1038:net.minecraft.sounds.SoundEvent getEatingSound() -> J
    1042:1042:net.minecraft.sounds.SoundEvent getBreakingSound() -> K
    1046:1046:boolean canBeHurtBy(net.minecraft.world.damagesource.DamageSource) -> a
    967:967:net.minecraft.network.chat.Style lambda$getDisplayName$21(net.minecraft.network.chat.Style) -> a
    907:907:void lambda$enchant$20(net.minecraft.core.Holder,int,net.minecraft.world.item.enchantment.ItemEnchantments$Mutable) -> a
    818:824:void lambda$addAttributeTooltips$19(org.apache.commons.lang3.mutable.MutableBoolean,java.util.function.Consumer,net.minecraft.world.entity.EquipmentSlotGroup,net.minecraft.world.entity.player.Player,net.minecraft.core.Holder,net.minecraft.world.entity.ai.attributes.AttributeModifier) -> a
    614:614:java.util.Optional lambda$lenientOptionalFieldOf$18(net.minecraft.world.item.ItemStack) -> c
    613:613:net.minecraft.world.item.ItemStack lambda$lenientOptionalFieldOf$17(java.util.Optional) -> a
    474:474:void lambda$hurtAndBreak$16(net.minecraft.world.entity.LivingEntity,net.minecraft.world.entity.EquipmentSlot,net.minecraft.world.item.Item) -> a
    292:292:void lambda$parse$15(java.lang.String) -> b
    284:284:java.lang.String lambda$validateComponents$14(int,int) -> a
    277:277:java.lang.String lambda$validateComponents$13() -> L
    127:127:java.util.Optional lambda$static$12(net.minecraft.world.item.ItemStack) -> d
    126:126:net.minecraft.world.item.ItemStack lambda$static$11(java.util.Optional) -> b
    120:120:java.lang.String lambda$validateStrict$10(net.minecraft.world.item.ItemStack) -> e
    117:117:net.minecraft.world.item.ItemStack lambda$validateStrict$9(net.minecraft.world.item.ItemStack,net.minecraft.util.Unit) -> a
    105:105:com.mojang.serialization.Codec lambda$static$8() -> M
    105:108:com.mojang.datafixers.kinds.App lambda$static$7(com.mojang.serialization.codecs.RecordCodecBuilder$Instance) -> a
    108:108:net.minecraft.world.item.ItemStack lambda$static$6(net.minecraft.core.Holder,net.minecraft.core.component.DataComponentPatch) -> a
    107:107:net.minecraft.core.component.DataComponentPatch lambda$static$5(net.minecraft.world.item.ItemStack) -> f
    98:98:com.mojang.serialization.Codec lambda$static$4() -> N
    98:103:com.mojang.datafixers.kinds.App lambda$static$3(com.mojang.serialization.codecs.RecordCodecBuilder$Instance) -> b
    102:102:net.minecraft.core.component.DataComponentPatch lambda$static$2(net.minecraft.world.item.ItemStack) -> g
    95:95:com.mojang.serialization.DataResult lambda$static$1(net.minecraft.core.Holder) -> b
    95:95:java.lang.String lambda$static$0() -> O
    94:208:void <clinit>() -> <clinit>
 */
class ItemStack(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_world_item_ItemStack)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}

	constructor(item: Item) : this(
		clazz.getConstructor(Item.clazz).newInstance(item)
	)
}