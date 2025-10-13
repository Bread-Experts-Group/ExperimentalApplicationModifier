package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.repository

import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_server_packs_repository_Pack
import org.bread_experts_group.eam.loadClass
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.repository.Pack -> atm:
# {"fileName":"Pack.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> a
    net.minecraft.server.packs.PackLocationInfo location -> b
    net.minecraft.server.packs.repository.Pack$ResourcesSupplier resources -> c
    net.minecraft.server.packs.repository.Pack$Metadata metadata -> d
    net.minecraft.server.packs.PackSelectionConfig selectionConfig -> e
    40:42:net.minecraft.server.packs.repository.Pack readMetaAndCreate(net.minecraft.server.packs.PackLocationInfo,net.minecraft.server.packs.repository.Pack$ResourcesSupplier,net.minecraft.server.packs.PackType,net.minecraft.server.packs.PackSelectionConfig) -> a
    45:50:void <init>(net.minecraft.server.packs.PackLocationInfo,net.minecraft.server.packs.repository.Pack$ResourcesSupplier,net.minecraft.server.packs.repository.Pack$Metadata,net.minecraft.server.packs.PackSelectionConfig) -> <init>
    54:74:net.minecraft.server.packs.repository.Pack$Metadata readPackMetadata(net.minecraft.server.packs.PackLocationInfo,net.minecraft.server.packs.repository.Pack$ResourcesSupplier,int) -> a
    78:89:net.minecraft.util.InclusiveRange getDeclaredPackVersions(java.lang.String,net.minecraft.server.packs.metadata.pack.PackMetadataSection) -> a
    93:93:net.minecraft.server.packs.PackLocationInfo location() -> a
    97:97:net.minecraft.network.chat.Component getTitle() -> b
    101:101:net.minecraft.network.chat.Component getDescription() -> c
    105:105:net.minecraft.network.chat.Component getChatLink(boolean) -> a
    109:109:net.minecraft.server.packs.repository.PackCompatibility getCompatibility() -> d
    113:113:net.minecraft.world.flag.FeatureFlagSet getRequestedFeatures() -> e
    117:117:net.minecraft.server.packs.PackResources open() -> f
    121:121:java.lang.String getId() -> g
    125:125:net.minecraft.server.packs.PackSelectionConfig selectionConfig() -> h
    129:129:boolean isRequired() -> i
    133:133:boolean isFixedPosition() -> j
    137:137:net.minecraft.server.packs.repository.Pack$Position getDefaultPosition() -> k
    141:141:net.minecraft.server.packs.repository.PackSource getPackSource() -> l
    146:155:boolean equals(java.lang.Object) -> equals
    160:160:int hashCode() -> hashCode
    22:22:void <clinit>() -> <clinit>
net.minecraft.server.packs.repository.Pack$Metadata -> atm$a:
# {"fileName":"Pack.java","id":"sourceFile"}
    net.minecraft.network.chat.Component description -> a
    net.minecraft.server.packs.repository.PackCompatibility compatibility -> b
    net.minecraft.world.flag.FeatureFlagSet requestedFeatures -> c
    java.util.List overlays -> d
    35:35:void <init>(net.minecraft.network.chat.Component,net.minecraft.server.packs.repository.PackCompatibility,net.minecraft.world.flag.FeatureFlagSet,java.util.List) -> <init>
    35:35:java.lang.String toString() -> toString
    35:35:int hashCode() -> hashCode
    35:35:boolean equals(java.lang.Object) -> equals
    35:35:net.minecraft.network.chat.Component description() -> a
    35:35:net.minecraft.server.packs.repository.PackCompatibility compatibility() -> b
    35:35:net.minecraft.world.flag.FeatureFlagSet requestedFeatures() -> c
    35:35:java.util.List overlays() -> d
net.minecraft.server.packs.repository.Pack$Position -> atm$b:
# {"fileName":"Pack.java","id":"sourceFile"}
    net.minecraft.server.packs.repository.Pack$Position TOP -> a
    net.minecraft.server.packs.repository.Pack$Position BOTTOM -> b
    net.minecraft.server.packs.repository.Pack$Position[] $VALUES -> c
    163:163:net.minecraft.server.packs.repository.Pack$Position[] values() -> values
    163:163:net.minecraft.server.packs.repository.Pack$Position valueOf(java.lang.String) -> valueOf
    163:163:void <init>(java.lang.String,int) -> <init>
    169:193:int insert(java.util.List,java.lang.Object,java.util.function.Function,boolean) -> a
    198:198:net.minecraft.server.packs.repository.Pack$Position opposite() -> a
    163:163:net.minecraft.server.packs.repository.Pack$Position[] $values() -> b
    163:165:void <clinit>() -> <clinit>
net.minecraft.server.packs.repository.Pack$ResourcesSupplier -> atm$c:
# {"fileName":"Pack.java","id":"sourceFile"}
    net.minecraft.server.packs.PackResources openPrimary(net.minecraft.server.packs.PackLocationInfo) -> a
    net.minecraft.server.packs.PackResources openFull(net.minecraft.server.packs.PackLocationInfo,net.minecraft.server.packs.repository.Pack$Metadata) -> a
 */
class Pack(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_server_packs_repository_Pack)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
}