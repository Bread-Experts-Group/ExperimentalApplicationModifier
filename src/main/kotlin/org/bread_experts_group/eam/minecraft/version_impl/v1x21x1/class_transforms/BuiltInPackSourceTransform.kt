package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.Pack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_server_packs_repository_BuiltInPackSource
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_STATIC
import java.lang.constant.MethodTypeDesc

class BuiltInPackSourceTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_server_packs_repository_BuiltInPackSource,
	"BuiltInPackSource",
	scanning,
	classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val m = modifyMethodAccess(
			"b",
			MethodTypeDesc.of(Pack.ResourcesSupplier.classDesc, PackResources.classDesc),
			ACC_PUBLIC or ACC_STATIC
		)

		if (!m(classBuilder, classElement)) classBuilder.with(classElement)
	}
}