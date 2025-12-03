package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.feature_transforms

import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.FeatureTransform
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayer
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayerFeature
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeDefaultSuper
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.putReferenceField
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.LayeredDraw
import org.bread_experts_group.eam.minecraft.withReferenceField
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class LayerFeatureTransform(input: MinecraftLayer) : FeatureTransform<MinecraftLayer, MinecraftLayerFeature>(
	input,
	MinecraftFeatures.LAYER
) {
	override fun createInstance(clazz: Class<*>): Any =
		clazz.getConstructor(MinecraftLayer::class.java).newInstance(input)

	override fun startTransform(name: String): (ClassBuilder) -> Any = { classBuilder ->
		classBuilder.withInterfaceSymbols(LayeredDraw.Layer.classDesc)
		classBuilder.withMethodBody(
			"render",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				GuiGraphics.classDesc,
				DeltaTracker.classDesc
			),
			ClassFile.ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.getReferenceField(name, MinecraftLayer.mimicClassDesc)
				.invokeSpecialNewMimic(GuiGraphics.mimicClassDesc, 1)
				.invokeSpecialNewMimic(DeltaTracker.mimicClassDesc, 2)
				.invokevirtual(
					MinecraftLayer.mimicClassDesc,
					"render",
					MethodTypeDesc.of(
						ConstantDescs.CD_void,
						GuiGraphics.mimicClassDesc,
						DeltaTracker.mimicClassDesc
					)
				)
				.return_()
		}
		classBuilder.withMethodBody(
			ConstantDescs.INIT_NAME,
			MethodTypeDesc.of(ConstantDescs.CD_void, MinecraftLayer.mimicClassDesc),
			ClassFile.ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(0)
				.invokeDefaultSuper()
				.aload(1)
				.putReferenceField(name, MinecraftLayer.mimicClassDesc)
				.return_()
		}
		classBuilder.withReferenceField(MinecraftLayer.mimicClassDesc)
	}
}