package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.test_mods.breadmod.camera.CameraTexture
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_Minecraft_updateTitle
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations.postClientInit
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations.updateWindowTitle
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.pipeline.RenderTarget
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.main.GameConfig
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.Opcode
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class MinecraftTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_client_Minecraft,
	"Minecraft",
	scanning, classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val r = invokeAtMethodReturns(
			net_minecraft_client_Minecraft_updateTitle,
			MethodTypeDesc.of(ConstantDescs.CD_void),
			::updateWindowTitle.javaMethod!!
		)
		val r1 = invokeAtMethodReturns(
			ConstantDescs.INIT_NAME,
			MethodTypeDesc.of(ConstantDescs.CD_void, GameConfig.classDesc),
			::postClientInit.javaMethod!!
		)
		val mainTargetMethod = classBuilder.transformMethodCode(
			classElement,
			"h",
			MethodTypeDesc.of(RenderTarget.classDesc)
			) { codeBuilder, codeElement, index ->
			if (index == 1) {
				codeBuilder
					.getstatic(
						CameraTexture::class.classDesc,
						"targetBeingRendered",
						RenderTarget.mimicClassDesc
					)
					.ifThen(Opcode.IFNONNULL) { builder ->
						builder
							.getstatic(
								CameraTexture::class.classDesc,
								"targetBeingRendered",
								RenderTarget.mimicClassDesc
							)
							.getfield(
								MimickedClass.classDesc,
								"around",
								ConstantDescs.CD_Object
							)
							.checkcast(RenderTarget.classDesc)
							.areturn()
					}
			}
			codeBuilder.with(codeElement)
		}

		if (!(r(classBuilder, classElement) || r1(classBuilder, classElement) || mainTargetMethod)) classBuilder.with(classElement)
	}
}