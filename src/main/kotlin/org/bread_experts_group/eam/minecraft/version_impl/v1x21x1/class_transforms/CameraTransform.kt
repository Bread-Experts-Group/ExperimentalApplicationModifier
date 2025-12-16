package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_Camera
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class CameraTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_client_Camera,
	"Camera",
	scanning, classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { cB, cE ->
		val r = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_float,
				ConstantDescs.CD_float
			),
			ACC_PUBLIC
		)
		val p = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_double,
				ConstantDescs.CD_double,
				ConstantDescs.CD_double
			),
			ACC_PUBLIC
		)
		val e = modifyFieldAccess("h", ACC_PUBLIC)

		if (!(r(cB, cE) || p(cB, cE) || e(cB, cE))) cB.with(cE)
	}
}