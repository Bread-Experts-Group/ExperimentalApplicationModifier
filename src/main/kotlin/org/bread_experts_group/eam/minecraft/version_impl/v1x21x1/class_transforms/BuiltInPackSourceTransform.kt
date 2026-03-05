package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_repository_BuiltInPackSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.Pack
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_STATIC
import java.lang.constant.MethodTypeDesc

class BuiltInPackSourceTransform(
	transformHolder: ModTransformHolder
) : ClassTransform(
	net_minecraft_server_packs_repository_BuiltInPackSource,
	"BuiltInPackSource",
	transformHolder
) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val m = modifyMethodAccess(
			"b",
			MethodTypeDesc.of(Pack.ResourcesSupplier.classDesc, PackResources.classDesc),
			ACC_PUBLIC or ACC_STATIC
		)

		if (!m(classBuilder, classElement)) classBuilder.with(classElement)
	}
}