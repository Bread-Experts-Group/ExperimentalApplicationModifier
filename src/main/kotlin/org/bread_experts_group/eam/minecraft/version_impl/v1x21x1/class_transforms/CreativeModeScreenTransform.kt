package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_gui_screens_inventory_CreativeModeInventoryScreen
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_STATIC

// todo overhaul the CreativeModeScreen to include creative tab pages
class CreativeModeScreenTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_client_gui_screens_inventory_CreativeModeInventoryScreen,
	"CreativeModeInventoryScreen",
	scanning,
	classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val f = modifyFieldAccess("H", ACC_PUBLIC or ACC_STATIC)
		val f1 = modifyFieldAccess("G", ACC_PUBLIC or ACC_STATIC) // add one to this array's size

		if (!(f(classBuilder, classElement) || f1(classBuilder, classElement))) classBuilder.with(classElement)
	}
}