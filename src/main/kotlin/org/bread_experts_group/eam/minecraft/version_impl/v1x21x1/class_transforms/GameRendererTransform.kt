package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_GameRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.resources.ResourceProvider
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.instruction.InvokeInstruction
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class GameRendererTransform(
	transformHolder: ModTransformHolder
) : ClassTransform(
	net_minecraft_client_renderer_GameRenderer,
	"GameRenderer",
	transformHolder
) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		val transformedMethod = classBuilder.transformMethodCode(
			classElement,
			"c",
			MethodTypeDesc.of(ConstantDescs.CD_void, ResourceProvider.classDesc)
		) { codeBuilder, codeElement, _ ->
			if (codeElement is InvokeInstruction &&
				codeElement.typeSymbol() == MethodTypeDesc.of(ConstantDescs.CD_void, ResourceProvider.classDesc)
			) {
				codeBuilder
					.with(codeElement)
					.invokeSpecialNewMimic(ResourceProvider.mimicClassDesc, 1)
					.aload(3)
					.invokestatic(
						V1X21X1MinecraftImplementations::class.classDesc,
						"registerShaders",
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							ResourceProvider.mimicClassDesc,
							ConstantDescs.CD_List
						)
					)
			} else codeBuilder.with(codeElement)
		}

		if (!transformedMethod) classBuilder.with(classElement)
	}
}