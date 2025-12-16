package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_renderer_texture_TextureManager
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.texture.TextureManager
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.constant.ConstantDescs

class TextureManagerTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_renderer_texture_TextureManager, "TextureManager", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		classBuilder.transformMethod(classElement, "e") { methodBuilder, methodElement ->
			if (methodElement is CodeModel) methodBuilder.transformCodeIndexed(methodElement) { codeBuilder, codeElement, index ->
				if (index == 3) {
					codeBuilder.iconst_1()
					codeBuilder.putstatic(
						TextureManager::class.classDesc,
						"textureLock",
						ConstantDescs.CD_boolean
					)
				} else if (index == 24) {
					codeBuilder.iconst_0()
					codeBuilder.putstatic(
						TextureManager::class.classDesc,
						"textureLock",
						ConstantDescs.CD_boolean
					)
				}
				codeBuilder.with(codeElement)
			}
		}.let { if (!it) classBuilder.with(classElement) }
	}
}