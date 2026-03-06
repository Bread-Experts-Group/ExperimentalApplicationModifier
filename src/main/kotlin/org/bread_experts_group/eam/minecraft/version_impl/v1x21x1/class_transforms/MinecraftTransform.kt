package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_Minecraft_updateTitle
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations.updateWindowTitle
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
		val init = classBuilder.transformMethodCode(
			classElement,
			ConstantDescs.INIT_NAME
		) { codeBuilder, codeElement, index ->
			when (index) {
				1331 -> codeBuilder
					.invokestatic(
						V1X21X1MinecraftImplementations::class.classDesc,
						"postClientInit",
						MethodTypeDesc.of(ConstantDescs.CD_void)
					)
					.with(codeElement)
				else -> codeBuilder.with(codeElement)
			}
		}

		if (!(r(classBuilder, classElement) || init)) classBuilder.with(classElement)
	}
}