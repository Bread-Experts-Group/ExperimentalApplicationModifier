package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_blockentity_BlockEntityRenderers
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntityType
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_STATIC
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class BlockEntityRenderersTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_client_renderer_blockentity_BlockEntityRenderers,
	"BlockEntityRenderers",
	scanning, classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val r = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				BlockEntityType.classDesc,
				BlockEntityRendererProvider.classDesc
			),
			ACC_PUBLIC or ACC_STATIC
		)

		if (!r(classBuilder, classElement)) classBuilder.with(classElement)
	}
}