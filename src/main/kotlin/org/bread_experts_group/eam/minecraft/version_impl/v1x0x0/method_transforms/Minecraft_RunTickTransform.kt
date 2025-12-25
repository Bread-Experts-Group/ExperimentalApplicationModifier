package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.method_transforms

import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.transform.MethodTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0.net_minecraft_GuiParticle
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.CodeBuilder
import java.lang.classfile.CodeElement
import java.lang.constant.ClassDesc

class Minecraft_RunTickTransform(
	classBuilder: ClassBuilder,
	classElement: ClassElement,
	owningClass: ClassDesc
) : MethodTransform(classBuilder, classElement, "k", owningClass, DEFAULT_VOID) {
	private val guiScreenDesc = ClassDesc.of(NativeConstantsV1x0x0.net_minecraft_GuiScreen)
	private val guiParticlesDesc = ClassDesc.of(net_minecraft_GuiParticle)

	override fun transform(): (CodeBuilder, CodeElement, Int) -> Unit = { codeBuilder, codeElement, index ->
		val label = codeBuilder.newLabel()
		when (index) {
			189 -> codeBuilder
				.aload(0)
				.getfield(
					owningClass,
					"s",
					guiScreenDesc
				)
				.ifnull(label)
				.aload(0)
				.getfield(
					owningClass,
					"s",
					guiScreenDesc
				)
				.getfield(
					guiScreenDesc,
					"r",
					guiParticlesDesc
				)
				.invokevirtual(
					guiParticlesDesc,
					"a",
					DEFAULT_VOID
				)
				.aload(0)
				.getfield(
					owningClass,
					"s",
					guiScreenDesc
				)
				.invokevirtual(
					guiScreenDesc,
					"s_",
					DEFAULT_VOID
				)
				.labelBinding(label)

			else if (
				index !in 188 .. 209
			) -> codeBuilder.with(codeElement)
		}
	}
}