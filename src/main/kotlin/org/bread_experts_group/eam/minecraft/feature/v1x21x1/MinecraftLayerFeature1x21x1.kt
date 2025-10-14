package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.api.ImplementationSource
import org.bread_experts_group.eam.minecraft.feature.Identifier
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayer
import org.bread_experts_group.eam.minecraft.feature.layer.MinecraftLayerFeature
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.DeltaTracker
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.LayeredDraw
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimicClass
import java.lang.classfile.ClassFile.ACC_FINAL
import java.lang.classfile.ClassFile.ACC_PRIVATE
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.StackMapsOption
import java.lang.classfile.ClassFile.of
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class MinecraftLayerFeature1x21x1 : MinecraftLayerFeature() {
	override val source: ImplementationSource = ImplementationSource.JVM_NATIVE

	private var c = 0
	private val cf = of(StackMapsOption.GENERATE_STACK_MAPS)
	private val cl = object : ClassLoader() {
		fun define(n: String, b: ByteArray) = this.defineClass(n, b, 0, b.size)
	}

	override fun register(id: Identifier, layer: MinecraftLayer): MinecraftLayer {
		val name = layer::class.qualifiedName ?: "eamInternal${c++}"
		val around = cl.define(
			name,
			cf.build(ClassDesc.of(name)) { classBuilder ->
				classBuilder.withInterfaceSymbols(LayeredDraw.Layer.classDesc)
				classBuilder.withMethodBody(
					"render",
					MethodTypeDesc.of(
						ConstantDescs.CD_void,
						GuiGraphics.classDesc,
						DeltaTracker.classDesc
					),
					ACC_PUBLIC
				) { codeBuilder ->
					codeBuilder
						.getReferenceField(name, MinecraftLayer.mimicClassDesc)
						.invokeSpecialNewMimicClass(GuiGraphics.mimicClassDesc, 1)
						.invokeSpecialNewMimicClass(DeltaTracker.mimicClassDesc, 2)
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
					"<init>",
					MethodTypeDesc.of(ConstantDescs.CD_void, MinecraftLayer.mimicClassDesc),
					ACC_PUBLIC
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
							MinecraftLayer.mimicClassDesc
						)
						.return_()
				}
				classBuilder.withField(
					"reference",
					MinecraftLayer.mimicClassDesc,
					ACC_FINAL or ACC_PRIVATE
				)
			}
		).getConstructor(MinecraftLayer::class.java).newInstance(layer)
		val drawLayer = LayeredDraw.Layer(around)
		V1x21x1Implementations.drawLayers.add(drawLayer)
		return layer
	}
}