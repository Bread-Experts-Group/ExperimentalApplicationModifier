package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_Minecraft_updateTitle
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations.postClientInit
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations.updateWindowTitle
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.main.GameConfig
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class MinecraftTransform(
	holder: ModTransformHolder
) : ClassTransform(
	net_minecraft_client_Minecraft,
	"Minecraft",
	holder
) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val r = invokeAtMethodReturns(
			net_minecraft_client_Minecraft_updateTitle,
			MethodTypeDesc.of(ConstantDescs.CD_void),
			::updateWindowTitle.javaMethod!!
		)
		val r1 = invokeAtMethodReturns(
			ConstantDescs.INIT_NAME,
			MethodTypeDesc.of(ConstantDescs.CD_void, GameConfig.classDesc),
			::postClientInit.javaMethod!!
		)

		if (!(r(classBuilder, classElement) || r1(classBuilder, classElement))) classBuilder.with(classElement)
	}
}