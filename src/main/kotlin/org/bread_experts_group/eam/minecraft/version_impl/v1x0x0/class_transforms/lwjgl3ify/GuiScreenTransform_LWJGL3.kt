package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms.lwjgl3ify

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

// todo work in progress..
class GuiScreenTransform_LWJGL3: ClassTransform(NativeConstantsV1x0x0.net_minecraft_GuiScreen, "GuiScreen") {
	private val handleInputDesc = MethodTypeDesc.of(
		ConstantDescs.CD_void,
//		ConstantDescs.CD_long, // window
		MouseHandler::class.classDesc,
		ConstantDescs.CD_int, // button
		ConstantDescs.CD_int, // action
		ConstantDescs.CD_int // mods
	)
	private val handleMouseInputSig = MethodTypeDesc.of(
		ConstantDescs.CD_void,
		ConstantDescs.CD_double,
		ConstantDescs.CD_double,
		ConstantDescs.CD_int
	)
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val handleInput = classBuilder.transformMethodNewSignature(
			classElement,
			"g",
			handleInputDesc,
			DEFAULT_VOID
		) { codeBuilder, codeElement, index ->
			codeBuilder.with(codeElement)
//			codeBuilder.return_()
		}
		val handleMouseInput = classBuilder.transformMethodNewSignature(
			classElement,
			"h",
			handleMouseInputSig,
			DEFAULT_VOID
		) { codeBuilder, codeElement, index -> codeBuilder.with(codeElement) }

		if (!(handleInput || handleMouseInput)) classBuilder.with(classElement)
	}
}