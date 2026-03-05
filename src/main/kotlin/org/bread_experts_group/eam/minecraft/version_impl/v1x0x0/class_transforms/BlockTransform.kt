package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.atIndex
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.V1X0X0MinecraftImplementations
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.AccessFlag

class BlockTransform(
	transformHolder: ModTransformHolder
) : ClassTransform(NativeConstantsV1x0x0.net_minecraft_Block, "Block", transformHolder) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val init = classBuilder.transformMethod(
			classElement,
			ConstantDescs.INIT_NAME
		) { methodBuilder, methodElement->
			methodBuilder.withFlags(AccessFlag.PUBLIC).with(methodElement)
		}
		val clinit = classBuilder.transformMethodCode(
			classElement,
			ConstantDescs.CLASS_INIT_NAME
		) { codeBuilder, codeElement, index ->
			codeBuilder
				.atIndex(index, 2007) { builder ->
					builder.invokestatic(
						V1X0X0MinecraftImplementations::class.classDesc,
						"registerBlocks",
						MethodTypeDesc.of(ConstantDescs.CD_void)
					)
				}
				.with(codeElement)
		}

		if (!(init || clinit)) classBuilder.with(classElement)
	}
}