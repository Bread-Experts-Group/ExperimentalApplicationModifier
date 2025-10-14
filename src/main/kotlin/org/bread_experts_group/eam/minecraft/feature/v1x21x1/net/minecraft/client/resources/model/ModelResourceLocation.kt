package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_resources_model_ModelResourceLocation
import java.lang.constant.ClassDesc

/*
net.minecraft.client.resources.model.ModelResourceLocation -> gsu:
# {"fileName":"ModelResourceLocation.java","id":"sourceFile"}
    net.minecraft.resources.ResourceLocation id -> b
    java.lang.String variant -> c
    java.lang.String INVENTORY_VARIANT -> a
    10:12:void <init>(net.minecraft.resources.ResourceLocation,java.lang.String) -> <init>
    15:15:net.minecraft.client.resources.model.ModelResourceLocation vanilla(java.lang.String,java.lang.String) -> a
    19:19:net.minecraft.client.resources.model.ModelResourceLocation inventory(net.minecraft.resources.ResourceLocation) -> a
    23:23:java.lang.String lowercaseVariant(java.lang.String) -> a
    27:27:java.lang.String getVariant() -> a
    32:32:java.lang.String toString() -> toString
    7:7:int hashCode() -> hashCode
    7:7:boolean equals(java.lang.Object) -> equals
    7:7:net.minecraft.resources.ResourceLocation id() -> b
    7:7:java.lang.String variant() -> c
 */
class ModelResourceLocation(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_resources_model_ModelResourceLocation)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = ModelResourceLocation::class.classDesc
	}

	constructor(id: ResourceLocation, variant: String) : this(
		clazz.getConstructor(ResourceLocation.clazz, String::class.java)
			.newInstance(id.around, variant)
	)

	constructor(location: String) : this(
		ResourceLocation.parse(location), "standalone"
	)
}