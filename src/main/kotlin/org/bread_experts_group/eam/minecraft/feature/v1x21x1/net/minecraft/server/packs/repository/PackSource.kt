package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.repository

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_server_packs_repository_PackSource
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.repository.PackSource -> atq:
# {"fileName":"PackSource.java","id":"sourceFile"}
    java.util.function.UnaryOperator NO_DECORATION -> a
    net.minecraft.server.packs.repository.PackSource DEFAULT -> b
    net.minecraft.server.packs.repository.PackSource BUILT_IN -> c
    net.minecraft.server.packs.repository.PackSource FEATURE -> d
    net.minecraft.server.packs.repository.PackSource WORLD -> e
    net.minecraft.server.packs.repository.PackSource SERVER -> f
    net.minecraft.network.chat.Component decorate(net.minecraft.network.chat.Component) -> a
    boolean shouldAddAutomatically() -> a
    25:25:net.minecraft.server.packs.repository.PackSource create(java.util.function.UnaryOperator,boolean) -> a
    39:40:java.util.function.UnaryOperator decorateWithSource(java.lang.String) -> a
    40:40:net.minecraft.network.chat.Component lambda$decorateWithSource$0(net.minecraft.network.chat.Component,net.minecraft.network.chat.Component) -> a
    9:18:void <clinit>() -> <clinit>
 */
class PackSource(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_server_packs_repository_PackSource
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)

		val DEFAULT: PackSource
			get() = PackSource(clazz.getField("b").get(null))
	}
}