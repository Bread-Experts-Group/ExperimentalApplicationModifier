package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_world_item_CreativeModeTabs
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.Registry
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.CreativeModeTab
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class CreativeModeTabsTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_world_item_CreativeModeTabs,
	"CreativeModeTabs",
	scanning, classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		classBuilder.transformMethod(
			classElement,
			"a",
			MethodTypeDesc.of(CreativeModeTab.classDesc, Registry.classDesc)
		) { methodBuilder, methodElement ->
			if (methodElement is CodeModel) {
				methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
					codeBuilder.atLineNumber(68, codeElement) { builder ->
						builder
							.new_(Registry.mimicClassDesc)
							.dup()
							.loadConstant(CreativeModeTab.mimicClassDesc)
							.aload(0)
							.invokespecial(
								Registry.mimicClassDesc,
								ConstantDescs.INIT_NAME,
								MethodTypeDesc.of(
									ConstantDescs.CD_void,
									ConstantDescs.CD_Class,
									ConstantDescs.CD_Object
								)
							)
							.invokestatic(
								V1X21X1MinecraftImplementations::class.classDesc,
								"registerTabs",
								MethodTypeDesc.of(ConstantDescs.CD_void, Registry.mimicClassDesc)
							)
					}
					.with(codeElement)
				}
			}
		}.let { if (!it) classBuilder.with(classElement) }
	}
}