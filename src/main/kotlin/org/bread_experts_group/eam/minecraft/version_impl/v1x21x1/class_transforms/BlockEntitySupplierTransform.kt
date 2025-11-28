package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_level_block_entity_BlockEntityType_BlockEntitySupplier
import java.lang.classfile.AccessFlags
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.reflect.AccessFlag

class BlockEntitySupplierTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_world_level_block_entity_BlockEntityType_BlockEntitySupplier,
	"BlockEntitySupplier",
	scanning,
	classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		// Signature { "<T:Ldqh;>Ljava/lang/Object;" }
//		if (classElement is SignatureAttribute) println(classElement.signature())
		if (classElement is AccessFlags) classBuilder.withFlags(AccessFlag.INTERFACE, AccessFlag.ABSTRACT, AccessFlag.PUBLIC)
		else classBuilder.with(classElement)
	}
}