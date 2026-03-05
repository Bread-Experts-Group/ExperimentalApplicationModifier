package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.nio.ByteBuffer
import java.nio.FloatBuffer

class TesselatorTransform_LWJGL3: ClassTransform(
	NativeConstantsV1x0x0.net_minecraft_Tessellator,
	"Tesselator"
) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val gl11Desc = ClassDesc.of("org.lwjgl.opengl.GL11")
		val draw = classBuilder.transformMethodCode(
			classElement,
			"a",
			MethodTypeDesc.of(ConstantDescs.CD_int)
		) { codeBuilder, codeElement, index ->
//			println("$index, $codeElement")
			when (index) {
				101 -> codeBuilder
					 .loadConstant(32)
					 .with(codeElement)
				104 -> codeBuilder
					.invokestatic(
						gl11Desc,
						"glTexCoordPointer",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							FloatBuffer::class.classDesc
						)
					)
				173 -> codeBuilder.loadConstant(5121)
				177 -> codeBuilder
					.invokestatic(
						gl11Desc,
						"glColorPointer",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ByteBuffer::class.classDesc
						)
					)
				233 -> codeBuilder
					.with(codeElement)
					.loadConstant(5126)
				237 -> codeBuilder
					.invokestatic(
						gl11Desc,
						"glVertexPointer",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							FloatBuffer::class.classDesc
						)
					)

				else -> codeBuilder.with(codeElement)
			}
//			codeBuilder.with(codeElement)
		}

		if (!draw) classBuilder.with(classElement)
	}
}