package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.network.chat

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_network_chat_Component
import java.lang.constant.ClassDesc

/*
net.minecraft.network.chat.Component -> wz:
# {"fileName":"Component.java","id":"sourceFile"}
    net.minecraft.network.chat.Style getStyle() -> a
    net.minecraft.network.chat.ComponentContents getContents() -> b
    45:45:java.lang.String getString() -> getString
    49:58:java.lang.String getString(int) -> a
    java.util.List getSiblings() -> c
    65:68:java.lang.String tryCollapseToString() -> d
    78:78:net.minecraft.network.chat.MutableComponent plainCopy() -> e
    88:88:net.minecraft.network.chat.MutableComponent copy() -> f
    net.minecraft.util.FormattedCharSequence getVisualOrderText() -> g
    95:109:java.util.Optional visit(net.minecraft.network.chat.FormattedText$StyledContentConsumer,net.minecraft.network.chat.Style) -> a
    114:126:java.util.Optional visit(net.minecraft.network.chat.FormattedText$ContentConsumer) -> a
    130:130:java.util.List toFlatList() -> h
    134:141:java.util.List toFlatList(net.minecraft.network.chat.Style) -> a
    145:151:boolean contains(net.minecraft.network.chat.Component) -> a
    221:221:net.minecraft.network.chat.Component nullToEmpty(java.lang.String) -> a
    225:225:net.minecraft.network.chat.MutableComponent literal(java.lang.String) -> b
    229:229:net.minecraft.network.chat.MutableComponent translatable(java.lang.String) -> c
    233:233:net.minecraft.network.chat.MutableComponent translatable(java.lang.String,java.lang.Object[]) -> a
    240:246:net.minecraft.network.chat.MutableComponent translatableEscape(java.lang.String,java.lang.Object[]) -> b
    250:250:net.minecraft.network.chat.MutableComponent translatableWithFallback(java.lang.String,java.lang.String) -> a
    254:254:net.minecraft.network.chat.MutableComponent translatableWithFallback(java.lang.String,java.lang.String,java.lang.Object[]) -> a
    258:258:net.minecraft.network.chat.MutableComponent empty() -> i
    262:262:net.minecraft.network.chat.MutableComponent keybind(java.lang.String) -> d
    266:266:net.minecraft.network.chat.MutableComponent nbt(java.lang.String,boolean,java.util.Optional,net.minecraft.network.chat.contents.DataSource) -> a
    270:270:net.minecraft.network.chat.MutableComponent score(java.lang.String,java.lang.String) -> b
    274:274:net.minecraft.network.chat.MutableComponent selector(java.lang.String,java.util.Optional) -> a
    279:279:net.minecraft.network.chat.Component translationArg(java.util.Date) -> a
    283:283:net.minecraft.network.chat.Component translationArg(com.mojang.brigadier.Message) -> a
    287:287:net.minecraft.network.chat.Component translationArg(java.util.UUID) -> a
    291:291:net.minecraft.network.chat.Component translationArg(net.minecraft.resources.ResourceLocation) -> a
    295:295:net.minecraft.network.chat.Component translationArg(net.minecraft.world.level.ChunkPos) -> a
    299:299:net.minecraft.network.chat.Component translationArg(java.net.URI) -> a
    136:139:java.util.Optional lambda$toFlatList$1(java.util.List,net.minecraft.network.chat.Style,java.lang.String) -> a
    51:56:java.util.Optional lambda$getString$0(int,java.lang.StringBuilder,java.lang.String) -> a

net.minecraft.network.chat.Component$Serializer -> wz$a:
# {"fileName":"Component.java","id":"sourceFile"}
    com.google.gson.Gson GSON -> a
    155:156:void <init>() -> <init>
    160:160:net.minecraft.network.chat.MutableComponent deserialize(com.google.gson.JsonElement,net.minecraft.core.HolderLookup$Provider) -> b
    164:164:com.google.gson.JsonElement serialize(net.minecraft.network.chat.Component,net.minecraft.core.HolderLookup$Provider) -> b
    170:170:java.lang.String toJson(net.minecraft.network.chat.Component,net.minecraft.core.HolderLookup$Provider) -> a
    175:179:net.minecraft.network.chat.MutableComponent fromJson(java.lang.String,net.minecraft.core.HolderLookup$Provider) -> a
    184:187:net.minecraft.network.chat.MutableComponent fromJson(com.google.gson.JsonElement,net.minecraft.core.HolderLookup$Provider) -> a
    192:198:net.minecraft.network.chat.MutableComponent fromJsonLenient(java.lang.String,net.minecraft.core.HolderLookup$Provider) -> b
    167:167:void <clinit>() -> <clinit>

net.minecraft.network.chat.Component$SerializerAdapter -> wz$b:
# {"fileName":"Component.java","id":"sourceFile"}
    net.minecraft.core.HolderLookup$Provider registries -> a
    205:207:void <init>(net.minecraft.core.HolderLookup$Provider) -> <init>
    211:211:net.minecraft.network.chat.MutableComponent deserialize(com.google.gson.JsonElement,java.lang.reflect.Type,com.google.gson.JsonDeserializationContext) -> a
    216:216:com.google.gson.JsonElement serialize(net.minecraft.network.chat.Component,java.lang.reflect.Type,com.google.gson.JsonSerializationContext) -> a
    202:202:com.google.gson.JsonElement serialize(java.lang.Object,java.lang.reflect.Type,com.google.gson.JsonSerializationContext) -> serialize
    202:202:java.lang.Object deserialize(com.google.gson.JsonElement,java.lang.reflect.Type,com.google.gson.JsonDeserializationContext) -> deserialize
 */
abstract class Component(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_network_chat_Component)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Component::class.classDesc

		fun literal(text: String): MutableComponent = MutableComponent(
			clazz.getMethod("b", String::class.java)
				.invoke(null, text)
		)
	}
}