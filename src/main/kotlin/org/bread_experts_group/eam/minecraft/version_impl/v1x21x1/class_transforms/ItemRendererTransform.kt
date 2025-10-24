package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.getLocalVariableInfo
import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.invokeStaticMethodWithLocalVars
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1x21x1Implementations.renderBEWLR
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.VertexConsumer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.BakedModel
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemDisplayContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_entity_ItemRenderer
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class ItemRendererTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_renderer_entity_ItemRenderer, "ItemRenderer", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val p = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				BakedModel.classDesc,
				ItemStack.classDesc,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int,
				PoseStack.classDesc,
				VertexConsumer.classDesc
			),
			ACC_PUBLIC
		)

		if (
			classElement is MethodModel &&
			classElement.methodName().equalsString("a") &&
			classElement.methodTypeSymbol() == MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ItemStack.classDesc,
				ItemDisplayContext.classDesc,
				ConstantDescs.CD_boolean,
				PoseStack.classDesc,
				MultiBufferSource.classDesc,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int,
				BakedModel.classDesc
			)) {
			classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
				if (methodElement is CodeModel) {
					val localVars = methodBuilder.getLocalVariableInfo(methodElement)
					methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
						codeBuilder.atLine(127, codeElement) { builder ->
							builder.invokeStaticMethodWithLocalVars(::renderBEWLR.javaMethod, localVars)
						}
						.with(codeElement)
					}
				}
			}
		} else if (!p.invoke(classBuilder, classElement)) classBuilder.with(classElement)
	}
}