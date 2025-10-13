package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_world_item_ItemDisplayContext
import java.lang.constant.ClassDesc

/*
net.minecraft.world.item.ItemDisplayContext -> cun:
# {"fileName":"ItemDisplayContext.java","id":"sourceFile"}
    com.mojang.serialization.Codec CODEC -> j
    java.util.function.IntFunction BY_ID -> k
    byte id -> l
    java.lang.String name -> m
    net.minecraft.world.item.ItemDisplayContext[] $VALUES -> n
    9:9:net.minecraft.world.item.ItemDisplayContext[] values() -> values
    9:9:net.minecraft.world.item.ItemDisplayContext valueOf(java.lang.String) -> valueOf
    27:30:void <init>(java.lang.String,int,int,java.lang.String) -> <init>
    34:34:java.lang.String getSerializedName() -> c
    38:38:byte getId() -> a
    42:42:boolean firstPerson() -> b
    9:9:net.minecraft.world.item.ItemDisplayContext[] $values() -> d
    9:22:void <clinit>() -> <clinit>
 */
class ItemDisplayContext(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_world_item_ItemDisplayContext
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
		val mimicClassDesc: ClassDesc = ClassDesc.of(ItemDisplayContext::class.qualifiedName)

		val NONE: ItemDisplayContext
			get() = ItemDisplayContext(clazz.getField("a").get(null))
		val THIRD_PERSON_LEFT_HAND: ItemDisplayContext
			get() = ItemDisplayContext(clazz.getField("b").get(null))
		val THIRD_PERSON_RIGHT_HAND: ItemDisplayContext
			get() = ItemDisplayContext(clazz.getField("c").get(null))
		val FIRST_PERSON_LEFT_HAND: ItemDisplayContext
			get() = ItemDisplayContext(clazz.getField("d").get(null))
		val FIRST_PERSON_RIGHT_HAND: ItemDisplayContext
			get() = ItemDisplayContext(clazz.getField("e").get(null))
		val HEAD: ItemDisplayContext
			get() = ItemDisplayContext(clazz.getField("f").get(null))
		val GUI: ItemDisplayContext
			get() = ItemDisplayContext(clazz.getField("g").get(null))
		val GROUND: ItemDisplayContext
			get() = ItemDisplayContext(clazz.getField("h").get(null))
		val FIXED: ItemDisplayContext
			get() = ItemDisplayContext(clazz.getField("i").get(null))
	}
}