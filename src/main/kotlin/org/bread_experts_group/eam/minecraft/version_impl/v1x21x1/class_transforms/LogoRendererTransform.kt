package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.loadConstant
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_components_LogoRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class LogoRendererTransform(
	transformHolder: ModTransformHolder
) : ClassTransform(
	net_minecraft_client_gui_components_LogoRenderer,
	"LogoRenderer",
	transformHolder
) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val renderLogo = classBuilder.transformMethodCode(
			classElement,
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				GuiGraphics.classDesc,
				ConstantDescs.CD_int,
				ConstantDescs.CD_float,
				ConstantDescs.CD_int
			)
		) { codeBuilder, codeElement, index ->
			when (index) {
				70 -> codeBuilder
					.loadConstant("eam")
					.loadConstant("textures/gui/title/eam_edition.png")
					.invokestatic(
						ResourceLocation.classDesc,
						"a",
						MethodTypeDesc.of(
							ResourceLocation.classDesc,
							ConstantDescs.CD_String,
							ConstantDescs.CD_String
						)
					)
				76 -> codeBuilder.loadConstant(16)

				else -> codeBuilder.with(codeElement)
			}
		}

		if (!renderLogo) classBuilder.with(classElement)
	}
}