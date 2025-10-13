package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.repository

import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_server_packs_repository_RepositorySource
import org.bread_experts_group.eam.loadClass
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.repository.RepositorySource -> atr:
# {"fileName":"RepositorySource.java","id":"sourceFile"}
    void loadPacks(java.util.function.Consumer) -> loadPacks
 */
open class RepositorySource(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(net_minecraft_server_packs_repository_RepositorySource)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)
	}
}