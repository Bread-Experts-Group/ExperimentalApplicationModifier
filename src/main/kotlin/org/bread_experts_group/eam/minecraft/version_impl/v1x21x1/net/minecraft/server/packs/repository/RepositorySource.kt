package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_server_packs_repository_RepositorySource
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.repository.RepositorySource -> atr:
# {"fileName":"RepositorySource.java","id":"sourceFile"}
    void loadPacks(java.util.function.Consumer) -> loadPacks
 */
open class RepositorySource(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_repository_RepositorySource)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = RepositorySource::class.classDesc
	}
}