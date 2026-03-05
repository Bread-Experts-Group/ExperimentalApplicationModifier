package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms

import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.net.minecraft.EntityPlayer
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.Opcode
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class EntityPlayerTransform(
	transformHolder: ModTransformHolder
) : ClassTransform(NativeConstantsV1x0x0.net_minecraft_EntityPlayer, "EntityPlayer", transformHolder) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val moveFlying = classBuilder.transformMethodCode(
			classElement,
			"d",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_float,
				ConstantDescs.CD_float,
			)
		) { codeBuilder, codeElement, index ->
			if (index == 25) {
				codeBuilder
					.aload(0)
					.invokevirtual(
						NativeConstantsV1x0x0.nativeClassDesc(EntityPlayer::class),
						"X",
						MethodTypeDesc.of(ConstantDescs.CD_boolean)
					)
					.ifThenElse(Opcode.IFNE, { thenBuilder ->
						thenBuilder
							.loadConstant(0.14f)
					}) { elseBuilder ->
						elseBuilder
							.loadConstant(0.06f)
					}
			} else codeBuilder.with(codeElement)
		}

		if (!moveFlying) classBuilder.with(classElement)
	}
}