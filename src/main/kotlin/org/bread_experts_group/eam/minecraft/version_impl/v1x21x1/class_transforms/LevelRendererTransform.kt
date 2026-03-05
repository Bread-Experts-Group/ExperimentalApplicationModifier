package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_LevelRenderer
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement

class LevelRendererTransform(
	transformHolder: ModTransformHolder
) : ClassTransform(net_minecraft_client_renderer_LevelRenderer, "LevelRenderer", transformHolder) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
		classBuilder.with(classElement)
	}
}