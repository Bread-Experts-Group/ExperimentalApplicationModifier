package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_server_packs_repository_PackRepository
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.repository.PackRepository -> atp:
# {"fileName":"PackRepository.java","id":"sourceFile"}
    java.util.Set sources -> a
    java.util.Map available -> b
    java.util.List selected -> c
    23:28:void <init>(net.minecraft.server.packs.repository.RepositorySource[]) -> <init>
    31:31:java.lang.String displayPackList(java.util.Collection) -> a
    35:38:void reload() -> a
    41:45:java.util.Map discoverAvailable() -> h
    49:50:void setSelected(java.util.Collection) -> b
    53:60:boolean addPack(java.lang.String) -> a
    64:71:boolean removePack(java.lang.String) -> b
    75:83:java.util.List rebuildSelected(java.util.Collection) -> c
    87:87:java.util.stream.Stream getAvailablePacks(java.util.Collection) -> d
    91:91:java.util.Collection getAvailableIds() -> b
    95:95:java.util.Collection getAvailablePacks() -> c
    99:99:java.util.Collection getSelectedIds() -> d
    103:103:net.minecraft.world.flag.FeatureFlagSet getRequestedFeatureFlags() -> e
    107:107:java.util.Collection getSelectedPacks() -> f
    112:112:net.minecraft.server.packs.repository.Pack getPack(java.lang.String) -> c
    116:116:boolean isAvailable(java.lang.String) -> d
    120:120:java.util.List openAllSelected() -> g
    43:43:void lambda$discoverAvailable$1(java.util.Map,net.minecraft.server.packs.repository.Pack) -> a
    31:31:java.lang.String lambda$displayPackList$0(net.minecraft.server.packs.repository.Pack) -> a
 */
class PackRepository(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_repository_PackRepository)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = PackRepository::class.classDesc
	}

	// EAM Added
	fun addSources(sources: Collection<RepositorySource>) {
		clazz.getMethod("addSources", Collection::class.java)
			.invoke(around, sources.map { it.around })
	}
}