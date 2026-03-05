package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_core_registries_BuiltInRegistries
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_core_registries_BuiltInRegistries_createContents
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations.afterCreateContents
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class BuiltInRegistriesTransform(
	transformHolder: ModTransformHolder
) : ClassTransform(
	net_minecraft_core_registries_BuiltInRegistries,
	"BuiltInRegistries",
	transformHolder
) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val r = invokeAtMethodReturns(
			net_minecraft_core_registries_BuiltInRegistries_createContents,
			MethodTypeDesc.of(ConstantDescs.CD_void),
			::afterCreateContents.javaMethod!!
		)
		if (!r.invoke(classBuilder, classElement)) classBuilder.with(classElement)
	}
}