package org.bread_experts_group.eam.minecraft.feature.v1x0x0

import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.EAMRegistry
import org.bread_experts_group.eam.minecraft.feature.Implementations
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.block.MinecraftBlock
import java.lang.classfile.ClassFile.*
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.TypeKind
import java.lang.classfile.instruction.LineNumber
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

object V1x0x0Implementations : Implementations() {
	override fun start() {
		scanning[net_minecraft_Block] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (
					classElement is MethodModel &&
					classElement.methodName().equalsString("<init>")
				) {
					classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
						methodBuilder.withFlags(
							classElement.flags().flagsMask() and (ACC_PRIVATE or ACC_PROTECTED).inv() or ACC_PUBLIC
						)
						methodBuilder.with(methodElement)
					}
				} else if (
					classElement is MethodModel &&
					classElement.methodName().equalsString("<clinit>")
				) {
					classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
						var added = true
						if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							if (codeElement is LineNumber && codeElement.line() == 262 && added) {
								@Suppress("AssignedValueIsNeverRead")
								added = false
								codeBuilder.invokestatic(
									ClassDesc.of(this::class.qualifiedName),
									"registerBlocks",
									MethodTypeDesc.of(ConstantDescs.CD_void)
								)
							}
							codeBuilder.with(codeElement)
						} else methodBuilder.with(methodElement)
					}
				} else classBuilder.with(classElement)
			}
		}
		scanning[net_minecraft_ContainerCreative] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) nextElement@{ classBuilder, classElement ->
				if (
					classElement is MethodModel &&
					classElement.methodName().equalsString("<init>")
				) {
					classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
						var added = true
						if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							if (codeElement is LineNumber && codeElement.line() == 51 && added) {
								@Suppress("AssignedValueIsNeverRead")
								added = false
								val iterator = codeBuilder.allocateLocal(TypeKind.REFERENCE)
								val iteratorClass =
									ClassDesc.of($$"org.bread_experts_group.eam.minecraft.feature.EAMRegistry$EAMEntryIterator")
								codeBuilder
									.getstatic(
										EAMRegistries.classDesc,
										"blocks",
										EAMRegistry.classDesc
									)
									.invokevirtual(
										EAMRegistry.classDesc,
										"entryIterator",
										MethodTypeDesc.of(iteratorClass)
									)
									.astore(iterator)
									.block {
										it
											.aload(iterator)
											.invokevirtual(
												iteratorClass,
												"hasNext",
												MethodTypeDesc.of(ConstantDescs.CD_boolean)
											)
											.bipush(1)
											.if_icmpne(it.endLabel())
											.aload(2)
											.bipush(0)
											.aload(iterator)
											.invokevirtual(
												iteratorClass,
												"next",
												MethodTypeDesc.of(ConstantDescs.CD_Object)
											)
											.checkcast(ClassDesc.of("kotlin.Pair"))
											.invokevirtual(
												ClassDesc.of("kotlin.Pair"),
												"getSecond",
												MethodTypeDesc.of(ConstantDescs.CD_Object)
											)
											.checkcast(MinecraftBlock.classDesc)
											.getfield(
												MinecraftBlock.classDesc,
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
							codeBuilder.with(codeElement)
						} else methodBuilder.with(methodElement)
					}
				} else classBuilder.with(classElement)
			}
		}
	}

	@Suppress("unused")
	@JvmStatic
	fun registerBlocks() {
		mods.forEach { it.addBlocks(MinecraftBlockFeature1x0x0()) }
	}
}