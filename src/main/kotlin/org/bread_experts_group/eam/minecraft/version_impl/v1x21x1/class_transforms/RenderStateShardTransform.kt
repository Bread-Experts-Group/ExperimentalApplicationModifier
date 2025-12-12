package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_RenderStateShard
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_STATIC

class RenderStateShardTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_renderer_RenderStateShard, "RenderStateShard", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { cB, cE ->
		val t = modifyFieldAccess("c", ACC_PUBLIC or ACC_STATIC) // NO_TRANSPARENCY
		val c = modifyFieldAccess("au", ACC_PUBLIC or ACC_STATIC) // CULL
		val nC = modifyFieldAccess("av", ACC_PUBLIC or ACC_STATIC) // NO_CULL

		if (!(t(cB, cE) || c(cB, cE) || nC(cB, cE))) cB.with(cE)
	}
}