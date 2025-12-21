package org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.EAMRegistry
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import org.bread_experts_group.eam.minecraft.localVariable
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x0x0.NativeConstantsV1x0x0
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class ContainerCreativeTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(NativeConstantsV1x0x0.net_minecraft_ContainerCreative, "ContainerCreative", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val iteratorClassDesc = EAMRegistry.EAMEntryIterator::class.classDesc
		val init = classBuilder.transformMethodCode(
			classElement,
			ConstantDescs.INIT_NAME
		) { codeBuilder, codeElement,  _ ->
			codeBuilder
				// todo use index later, it messes with some int field in the init
				.atLineNumber(51, codeElement) { builder ->
					builder
						.localVariable(7, "iterator", iteratorClassDesc)
						.getstatic(
							EAMRegistries.classDesc,
							"BLOCKS",
							EAMRegistry.classDesc
						)
						.invokevirtual(
							EAMRegistry.classDesc,
							"entryIterator",
							MethodTypeDesc.of(iteratorClassDesc)
						)
						.astore(7)
						.block {
							it
								.aload(7)
								.invokevirtual(
									iteratorClassDesc,
									"hasNext",
									MethodTypeDesc.of(ConstantDescs.CD_boolean)
								)
								.bipush(1)
								.if_icmpne(it.endLabel())
								.aload(2)
								.bipush(0)
								.aload(7)
								.invokevirtual(
									iteratorClassDesc,
									"next",
									MethodTypeDesc.of(ConstantDescs.CD_Object)
								)
								.checkcast(ClassDesc.of("kotlin.Pair"))
								.invokevirtual(
									ClassDesc.of("kotlin.Pair"),
									"getSecond",
									MethodTypeDesc.of(ConstantDescs.CD_Object)
								)
								.checkcast(MinecraftBlock.mimicClassDesc)
								.getfield(
									MinecraftBlock.mimicClassDesc,
									"mimic",
									MimickedClass.classDesc
								)
								.getfield(
									MimickedClass.classDesc,
									"around",
									ConstantDescs.CD_Object
								)
								.aastore()
								.goto_(it.startLabel())
						}

				}
				.with(codeElement)
		}

		if (!init) classBuilder.with(classElement)
	}
}