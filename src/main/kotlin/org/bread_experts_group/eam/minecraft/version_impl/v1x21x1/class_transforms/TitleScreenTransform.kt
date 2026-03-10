package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_components_events_GuiEventListener
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_screens_TitleScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_screens_TitleScreen_render
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.eam_impls.BSLTextWidget
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.eam_impls.ModListScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.components.Button
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile.ACC_PRIVATE
import java.lang.classfile.ClassFile.ACC_SYNTHETIC
import java.lang.classfile.instruction.LineNumber
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class TitleScreenTransform(
	transformHolder: ModTransformHolder
) : ClassTransform(
	net_minecraft_client_gui_screens_TitleScreen,
	"TitleScreen",
	transformHolder
) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val render = classBuilder.transformMethodCode(
			classElement,
			net_minecraft_client_gui_screens_TitleScreen_render,
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				GuiGraphics.classDesc,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int,
				ConstantDescs.CD_float
			)
		) { codeBuilder, codeElement, index ->
			if (codeElement is LineNumber && codeElement.line() == 273) {
				codeBuilder
					.invokeSpecialNewMimic(GuiGraphics.mimicClassDesc, 1)
					.aload(0)
					.getfield(
						thisClassDesc,
						"m",
						ConstantDescs.CD_int
					)
					.aload(0)
					.getfield(
						thisClassDesc,
						"n",
						ConstantDescs.CD_int
					)
					.iload(2)
					.iload(3)
					.invokestatic(
						V1X21X1MinecraftImplementations::class.classDesc,
						"renderTitleScreen",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							GuiGraphics.mimicClassDesc,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int
						)
					)
			}
			codeBuilder.with(codeElement)
		}
		val createNormalMenuOptions = classBuilder.transformMethodCode(
			classElement,
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int
			)
		) { codeBuilder, codeElement, index ->
			when (index) {
				84 -> codeBuilder
					.aload(0)
					.aload(0)
					.getfield(
						thisClassDesc,
						"m",
						ConstantDescs.CD_int
					)
					.iload(1)
					.iload(2)
					.invokestatic(
						ModListScreen::class.classDesc,
						"makeTitleScreenButton",
						MethodTypeDesc.of(
							Button.mimicClassDesc,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int,
							ConstantDescs.CD_int
						)
					)
					.getfield(
						MimickedClass.classDesc,
						"around",
						ConstantDescs.CD_Object
					)
					.checkcast(Button.classDesc)
					.invokevirtual(
						thisClassDesc,
						"c",
						MethodTypeDesc.of(
							ClassDesc.of(net_minecraft_client_gui_components_events_GuiEventListener),
							ClassDesc.of(net_minecraft_client_gui_components_events_GuiEventListener)
						)
					)
					.pop()
				else if (index !in 84 .. 110) -> codeBuilder.with(codeElement)
			}
		}
		val onPressDesc = MethodTypeDesc.of(ConstantDescs.CD_void, Button.classDesc)
		val init = classBuilder.transformMethodCode(
			classElement,
			"aT_",
			DEFAULT_VOID
		) { codeBuilder, codeElement, index ->
			when (index) {
				210 -> codeBuilder
					.with(codeElement)
					.aload(0)
					.new_(BSLTextWidget::class.classDesc)
					.dup()
					.aload(0)
					.getfield(
						thisClassDesc,
						"n",
						ConstantDescs.CD_int
					)
					.bipush(20)
					.isub()
					.invokespecial(
						BSLTextWidget::class.classDesc,
						ConstantDescs.INIT_NAME,
						MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_int)
					)
					.getfield(
						MimickedClass.classDesc,
						"around",
						ConstantDescs.CD_Object
					)
					.checkcast(ClassDesc.of(net_minecraft_client_gui_components_events_GuiEventListener))
					.invokevirtual(
						thisClassDesc,
						"c",
						MethodTypeDesc.of(
							ClassDesc.of(net_minecraft_client_gui_components_events_GuiEventListener),
							ClassDesc.of(net_minecraft_client_gui_components_events_GuiEventListener)
						)
					)

				else -> codeBuilder.with(codeElement)
			}

			classBuilder.addMethodWithCode(
				$$"TitleScreen$onPressBSL$lambda$1",
				onPressDesc,
				ACC_PRIVATE or ACC_SYNTHETIC
			) { codeBuilder -> codeBuilder.return_() }
		}

		if (!(render || createNormalMenuOptions || init)) classBuilder.with(classElement)
	}
}