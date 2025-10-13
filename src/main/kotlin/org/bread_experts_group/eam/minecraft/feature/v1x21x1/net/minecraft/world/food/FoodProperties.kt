package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.food

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_food_FoodProperties
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_food_FoodProperties_Builder

/*
    java.util.Optional usingConvertsTo -> g
    java.util.List effects -> h
    float DEFAULT_EAT_SECONDS -> i
    com.mojang.serialization.Codec DIRECT_CODEC -> a
    net.minecraft.network.codec.StreamCodec DIRECT_STREAM_CODEC -> b
    18:18:void <init>(int,float,boolean,float,java.util.Optional,java.util.List) -> <init>
    48:48:int eatDurationTicks() -> a
    18:18:java.lang.String toString() -> toString
    18:18:int hashCode() -> hashCode
    18:18:boolean equals(java.lang.Object) -> equals
    18:18:int nutrition() -> b
    18:18:float saturation() -> c
    18:18:boolean canAlwaysEat() -> d
    18:18:float eatSeconds() -> e
    18:18:java.util.Optional usingConvertsTo() -> f
    18:18:java.util.List effects() -> g
    28:35:com.mojang.datafixers.kinds.App lambda$static$0(com.mojang.serialization.codecs.RecordCodecBuilder$Instance) -> a
    28:43:void <clinit>() -> <clinit>
 */
class FoodProperties(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_world_food_FoodProperties)
	}

	val nutrition: Int
		get() = clazz.getField("c").getInt(null)
	val saturation: Float
		get() = clazz.getField("d").getFloat(null)
	val canAlwaysEat: Boolean
		get() = clazz.getField("e").getBoolean(null)
	val eatSeconds: Float
		get() = clazz.getField("f").getFloat(null)

	/*
	    int nutrition -> a
    float saturationModifier -> b
    boolean canAlwaysEat -> c
    float eatSeconds -> d
    java.util.Optional usingConvertsTo -> e
    com.google.common.collect.ImmutableList$Builder effects -> f
    69:75:void <init>() -> <init>
    78:79:net.minecraft.world.food.FoodProperties$Builder nutrition(int) -> a
    83:84:net.minecraft.world.food.FoodProperties$Builder saturationModifier(float) -> a
    88:89:net.minecraft.world.food.FoodProperties$Builder alwaysEdible() -> a
    93:94:net.minecraft.world.food.FoodProperties$Builder fast() -> b
    98:99:net.minecraft.world.food.FoodProperties$Builder effect(net.minecraft.world.effect.MobEffectInstance,float) -> a
    103:104:net.minecraft.world.food.FoodProperties$Builder usingConvertsTo(net.minecraft.world.level.ItemLike) -> a
    108:109:net.minecraft.world.food.FoodProperties build() -> c

	 */
	class Builder(around: Any) : MimickedClass(around) {
		companion object {
			val clazz: Class<*> = loadClass(
				net_minecraft_world_food_FoodProperties_Builder
			)
		}

		constructor() : this(clazz.getConstructor().newInstance())

		fun nutrition(n: Int): Builder = Builder(
			clazz.getMethod("a", Int::class.java).invoke(around, n)
		)

		fun build(): FoodProperties = FoodProperties(clazz.getMethod("c").invoke(around))
	}
}