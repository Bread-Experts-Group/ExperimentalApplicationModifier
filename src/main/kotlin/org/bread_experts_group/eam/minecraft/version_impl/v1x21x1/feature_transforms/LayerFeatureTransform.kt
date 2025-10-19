package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms

import org.bread_experts_group.eam.minecraft.feature.FeatureTransform
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayer
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimicClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.LayeredDraw
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class LayerFeatureTransform(input: MinecraftLayer) : FeatureTransform<MinecraftLayer>(input) {
	override fun createInstance(clazz: Class<*>): Any =
		clazz.getConstructor(MinecraftLayer::class.java).newInstance(input)

	override fun startTransform(name: String): (ClassBuilder) -> Any = { classBuilder ->
		classBuilder.withInterfaceSymbols(LayeredDraw.Layer.classDesc)
		classBuilder.withMethodBody(
			"render",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				GuiGraphics.Companion.classDesc,
				DeltaTracker.Companion.classDesc
			),
			ClassFile.ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.getReferenceField(name, MinecraftLayer.Companion.mimicClassDesc)
				.invokeSpecialNewMimicClass(GuiGraphics.Companion.mimicClassDesc, 1)
				.invokeSpecialNewMimicClass(DeltaTracker.Companion.mimicClassDesc, 2)
				.invokevirtual(
					MinecraftLayer.Companion.mimicClassDesc,
					"render",
					MethodTypeDesc.of(
						ConstantDescs.CD_void,
						GuiGraphics.Companion.mimicClassDesc,
						DeltaTracker.Companion.mimicClassDesc
					)
				)
				.return_()
		}
		classBuilder.withMethodBody(
			"<init>",
			MethodTypeDesc.of(ConstantDescs.CD_void, MinecraftLayer.Companion.mimicClassDesc),
			ClassFile.ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.dup()
				.invokespecial(
					ConstantDescs.CD_Object,
					"<init>",
					MethodTypeDesc.of(ConstantDescs.CD_void)
				)
				.aload(1)
				.putfield(
					ClassDesc.of(name),
					"reference",
					MinecraftLayer.Companion.mimicClassDesc
				)
				.return_()
		}
		classBuilder.withField(
			"reference",
			MinecraftLayer.Companion.mimicClassDesc,
			ClassFile.ACC_FINAL or ClassFile.ACC_PRIVATE
		)
	}
}