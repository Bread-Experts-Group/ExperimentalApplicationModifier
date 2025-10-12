package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.model.geom

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_model_geom_EntityModelSet
import java.lang.constant.ClassDesc

/*
net.minecraft.client.model.geom.EntityModelSet -> fyg:
# {"fileName":"EntityModelSet.java","id":"sourceFile"}
    java.util.Map roots -> a
    10:12:void <init>() -> <init>
    15:19:net.minecraft.client.model.geom.ModelPart bakeLayer(net.minecraft.client.model.geom.ModelLayerLocation) -> a
    24:25:void onResourceManagerReload(net.minecraft.server.packs.resources.ResourceManager) -> a
 */
class EntityModelSet(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_client_model_geom_EntityModelSet)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
}