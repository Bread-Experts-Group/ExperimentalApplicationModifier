package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.test_mods.breadmod.camera.CameraTexture
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeLookupV1x21x1
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.pipeline.RenderTarget
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Camera
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.GameRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.LevelRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.LightTexture
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity.Entity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.entity.LivingEntity
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_LevelRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.org.joml.Matrix4f
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PRIVATE
import java.lang.classfile.Opcode
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class LevelRendererTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_renderer_LevelRenderer, "LevelRenderer", scanning, classFile) {
	// For some reason specifying Camera#classDesc directly causes the entity field to not exist when it's accessed at runtime...
	//  Unsure why that's the case, so we fall back to NativeLookup to get the ClassDesc
	private val cameraNative = NativeLookupV1x21x1.nativeClassDesc(Camera::class)
	private val levelRendererNative = NativeLookupV1x21x1.nativeClassDesc(LevelRenderer::class)

	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val renderLevelTransform = classBuilder.transformMethodCode(
			classElement,
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				DeltaTracker.classDesc,
				ConstantDescs.CD_boolean,
				cameraNative,
				GameRenderer.classDesc,
				LightTexture.classDesc,
				Matrix4f.classDesc,
				Matrix4f.classDesc
			)
		) { codeBuilder, codeElement, index ->
			codeBuilder.with(codeElement)
			when (index) {
				527 -> codeBuilder.aload(0) // Before INVOKEVIRTUAL ffy.i ()Z // Bytecode Line 4694
				529 -> codeBuilder // After INVOKEVIRTUAL ffy.i ()Z // Bytecode Line 4694
					.invokevirtual(
						levelRendererNative,
						"cameraIsDetachedOverride",
						MethodTypeDesc.of(ConstantDescs.CD_boolean, ConstantDescs.CD_boolean)
					)
				546 -> codeBuilder.aload(0) // Before ALOAD 3 // Bytecode Line 4713
				549 -> codeBuilder  // After ALOAD 27 // Bytecode Line 4715
					.invokevirtual(
						levelRendererNative,
						"getCameraEntityOrOriginal",
						MethodTypeDesc.of(Entity.classDesc, Entity.classDesc, Entity.classDesc)
					)
					.aload(27)
			}
		}

		val shouldShowEntityOutlines = classBuilder.transformMethodCode(
			classElement,
			"d",
			MethodTypeDesc.of(ConstantDescs.CD_boolean)
		) { codeBuilder, codeElement, index ->
			when (index) {
				0 -> codeBuilder.localVariable(
					1,
					"original",
					ConstantDescs.CD_boolean,
					codeBuilder.startLabel(),
					codeBuilder.endLabel()
				)
				23 -> codeBuilder // Replaces IRETURN // Bytecode Line 2552
					.istore(1)
					.getstatic(
						CameraTexture::class.classDesc,
						"targetBeingRendered",
						RenderTarget.mimicClassDesc
					)
					.ifThen(Opcode.IFNONNULL) { builder ->
						builder
							.iconst_0()
							.ireturn()
					}
					.iload(1)
					.ireturn()
				else -> codeBuilder.with(codeElement)
			}
		}

		classBuilder.addMethod(
			"getCameraEntityOrOriginal",
			MethodTypeDesc.of(Entity.classDesc, Entity.classDesc, Entity.classDesc),
			ACC_PRIVATE
		) { methodBuilder ->
			methodBuilder.withCode { codeBuilder ->
				codeBuilder
					.getstatic(
						CameraTexture::class.classDesc,
						"targetBeingRendered",
						RenderTarget.mimicClassDesc
					)
					.ifThen(Opcode.IFNONNULL) { builder ->
						builder
							.aload(2)
							.instanceOf(LivingEntity.classDesc)
							.ifThen { b ->
								b.aload(2).areturn()
							}
					}
					.aload(1)
					.areturn()
			}
		}

		classBuilder.addMethod(
			"cameraIsDetachedOverride",
			MethodTypeDesc.of(ConstantDescs.CD_boolean, ConstantDescs.CD_boolean),
			ACC_PRIVATE
		) { methodBuilder ->
			methodBuilder.withCode { codeBuilder ->
				codeBuilder
					.getstatic(
						CameraTexture::class.classDesc,
						"targetBeingRendered",
						RenderTarget.mimicClassDesc
					)
					.ifThen(Opcode.IFNONNULL) { builder ->
						builder
							.iconst_1()
							.ireturn()
					}
					.iload(1)
					.ireturn()
			}
		}

		if (!(renderLevelTransform || shouldShowEntityOutlines)) classBuilder.with(classElement)
	}
}