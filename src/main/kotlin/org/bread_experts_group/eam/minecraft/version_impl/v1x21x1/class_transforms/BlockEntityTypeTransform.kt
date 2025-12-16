package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_world_level_block_entity_BlockEntityType
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_STATIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class BlockEntityTypeTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_world_level_block_entity_BlockEntityType,
	"BlockEntityType",
	scanning, classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val r = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				ClassDesc.of("dqj"),
				ConstantDescs.CD_String,
				ClassDesc.of($$"dqj$b")
			),
			ACC_PUBLIC or ACC_STATIC
		)
		val v = modifyFieldAccess("U", ACC_PUBLIC)


		if (!(r(classBuilder, classElement) || v(classBuilder, classElement))) classBuilder.with(classElement)
	}
}