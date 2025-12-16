package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_RenderType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.VertexFormat
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.RenderType
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_STATIC
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class RenderTypeTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_renderer_RenderType, "RenderType", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { cB, cE ->
		val a = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				NativeConstantsV1x21x1.nativeClassDesc(RenderType.CompositeRenderType::class),
				ConstantDescs.CD_String,
				VertexFormat.classDesc,
				VertexFormat.Mode.classDesc,
				ConstantDescs.CD_int,
				ConstantDescs.CD_boolean,
				ConstantDescs.CD_boolean,
				RenderType.CompositeState.classDesc
			),
			ACC_PUBLIC or ACC_STATIC
		)
		val b = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				NativeConstantsV1x21x1.nativeClassDesc(RenderType.CompositeRenderType::class),
				ConstantDescs.CD_String,
				VertexFormat.classDesc,
				VertexFormat.Mode.classDesc,
				ConstantDescs.CD_int,
				RenderType.CompositeState.classDesc
			),
			ACC_PUBLIC or ACC_STATIC
		)

		if (!(a(cB, cE) || b(cB, cE))) cB.with(cE)
	}
}