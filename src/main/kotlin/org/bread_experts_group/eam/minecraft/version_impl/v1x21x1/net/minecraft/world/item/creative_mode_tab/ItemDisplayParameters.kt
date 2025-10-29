package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.creative_mode_tab

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_item_CreativeModeTab_ItemDisplayParameters
import java.lang.constant.ClassDesc

/*
net.minecraft.world.item.CreativeModeTab$ItemDisplayParameters -> cta$d:
# {"fileName":"CreativeModeTab.java","id":"sourceFile"}
net.minecraft.world.flag.FeatureFlagSet enabledFeatures -> a
boolean hasPermissions -> b
net.minecraft.core.HolderLookup$Provider holders -> c
122:122:void <init>(net.minecraft.world.flag.FeatureFlagSet,boolean,net.minecraft.core.HolderLookup$Provider) -> <init>
124:124:boolean needsUpdate(net.minecraft.world.flag.FeatureFlagSet,boolean,net.minecraft.core.HolderLookup$Provider) -> a
122:122:java.lang.String toString() -> toString
122:122:int hashCode() -> hashCode
122:122:boolean equals(java.lang.Object) -> equals
122:122:net.minecraft.world.flag.FeatureFlagSet enabledFeatures() -> a
122:122:boolean hasPermissions() -> b
122:122:net.minecraft.core.HolderLookup$Provider holders() -> c
 */
class ItemDisplayParameters(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_item_CreativeModeTab_ItemDisplayParameters)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ItemDisplayParameters::class.classDesc
	}
}