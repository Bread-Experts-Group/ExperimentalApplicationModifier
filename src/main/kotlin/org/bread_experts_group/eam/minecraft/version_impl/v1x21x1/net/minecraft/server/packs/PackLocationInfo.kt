package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_PackLocationInfo
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.KnownPack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.PackSource
import java.lang.constant.ClassDesc
import java.util.*

/*
net.minecraft.server.packs.PackLocationInfo -> asp:
# {"fileName":"PackLocationInfo.java","id":"sourceFile"}
    java.lang.String id -> a
    net.minecraft.network.chat.Component title -> b
    net.minecraft.server.packs.repository.PackSource source -> c
    java.util.Optional knownPackInfo -> d
    13:13:void <init>(java.lang.String,net.minecraft.network.chat.Component,net.minecraft.server.packs.repository.PackSource,java.util.Optional) -> <init>
    20:20:net.minecraft.network.chat.Component createChatLink(boolean,net.minecraft.network.chat.Component) -> a
    13:13:java.lang.String toString() -> toString
    13:13:int hashCode() -> hashCode
    13:13:boolean equals(java.lang.Object) -> equals
    13:13:java.lang.String id() -> a
    13:13:net.minecraft.network.chat.Component title() -> b
    13:13:net.minecraft.server.packs.repository.PackSource source() -> c
    13:13:java.util.Optional knownPackInfo() -> d
    20:23:net.minecraft.network.chat.Style lambda$createChatLink$0(boolean,net.minecraft.network.chat.Component,net.minecraft.network.chat.Style) -> a
 */
class PackLocationInfo(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_PackLocationInfo)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = PackLocationInfo::class.classDesc
	}

	constructor(id: String, title: Component, source: PackSource, knownPackInfo: Optional<KnownPack>) : this(
		clazz.getConstructor(String::class.java, Component.clazz, PackSource.clazz, Optional::class.java)
			.newInstance(id, title.around, source.around, knownPackInfo.let { Optional.of(it.get().around) })
	)
}