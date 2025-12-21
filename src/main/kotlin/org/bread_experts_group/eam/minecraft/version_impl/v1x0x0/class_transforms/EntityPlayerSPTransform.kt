package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms

import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.Opcode
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class EntityPlayerSPTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(NativeConstantsV1x0x0.net_minecraft_EntityPlayerSP, "EntityPlayerSP", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val onLivingUpdate = classBuilder.transformMethodCode(
			classElement,
			"c"
		) { codeBuilder, codeElement, index ->
//			if (index in 500 .. 600) println("$index, $codeElement")
			// todo replace if statement with new one, or figure out how to properly splice the checks into the existing statement
			if (index == 522)
				codeBuilder
					.aload(0)
					.getfield(
						ClassDesc.of("di"),
						"cc",
						ClassDesc.of("wq")
					)
					.getfield(
						ClassDesc.of("wq"),
						"b",
						ConstantDescs.CD_boolean
					)
					.ifThen(Opcode.IFEQ) { builder ->
						builder
							.aload(0)
							.iconst_0()
							.invokevirtual(
								ClassDesc.of("di"),
								"a",
								MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_boolean)
							)
					}

			if (index !in 522 .. 524) codeBuilder.with(codeElement)
		}

		if (!onLivingUpdate) classBuilder.with(classElement)
	}
}