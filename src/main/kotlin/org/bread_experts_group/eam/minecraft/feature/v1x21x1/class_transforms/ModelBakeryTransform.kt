package org.bread_experts_group.eam.minecraft.feature.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.V1x21x1Implementations.registerAdditionalModels
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model.ModelResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model.UnbakedModel
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_client_resources_model_ModelBakery
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class ModelBakeryTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_resources_model_ModelBakery, "ModelBakery", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val regModelAccess = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ModelResourceLocation.classDesc,
				UnbakedModel.classDesc
			),
			ACC_PUBLIC
		)
		val getModelAccess = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				UnbakedModel.classDesc,
				ResourceLocation.classDesc
			),
			ACC_PUBLIC
		)
		val returnInvoke = invokeAtMethodReturns(
			"<init>",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ClassDesc.of("fhq"), // BlockColors
				ClassDesc.of("bnf"), // ProfileFiller,
				ClassDesc.of(Map::class.java.name),
				ClassDesc.of(Map::class.java.name)
			),
			::registerAdditionalModels.javaMethod!!
		)
		if (
			!(regModelAccess.invoke(classBuilder, classElement) ||
					getModelAccess.invoke(classBuilder, classElement) ||
					returnInvoke.invoke(classBuilder, classElement)
					)
		) classBuilder.with(classElement)
	}
}