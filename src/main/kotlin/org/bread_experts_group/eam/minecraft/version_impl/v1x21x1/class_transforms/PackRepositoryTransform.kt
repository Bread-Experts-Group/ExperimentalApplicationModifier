package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.MimicLookup1x21x1
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1X21X1MinecraftImplementations
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.PackRepository
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_server_packs_repository_PackRepository
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.CodeModel
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class PackRepositoryTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(
	net_minecraft_server_packs_repository_PackRepository,
	"PackRepository",
	scanning, classFile
) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		classBuilder.modifyMethod(classElement, ConstantDescs.INIT_NAME) { methodBuilder, methodElement ->
			if (methodElement is CodeModel) {
				methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
					codeBuilder.atLine(27, codeElement) { builder ->
						builder
							.aload(0)
							.new_(ClassDesc.of(LinkedHashSet::class.java.name))
							.dup()
							.aload(1)
							.invokestatic(
								ConstantDescs.CD_List,
								"of",
								MethodTypeDesc.of(
									ConstantDescs.CD_List,
									ConstantDescs.CD_Object.arrayType(1)
								),
								true
							)
							.invokespecial(
								ClassDesc.of(LinkedHashSet::class.java.name),
								ConstantDescs.INIT_NAME,
								MethodTypeDesc.of(
									ConstantDescs.CD_void,
									ConstantDescs.CD_Collection
								)
							)
							.putfield(
								MimicLookup1x21x1.nativeClassDesc(PackRepository::class),
								"a",
								ConstantDescs.CD_Set
							)
							.invokeSpecialNewMimic(PackRepository::class.classDesc, 0)
							.invokestatic(
								V1X21X1MinecraftImplementations::class.classDesc,
								"addPackSources",
								MethodTypeDesc.of(ConstantDescs.CD_void, PackRepository::class.classDesc)
							)
							.return_()
					}
					.with(codeElement)
				}
			}
		}
		classBuilder.addMethod(
			"addSources",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_Collection
			),
			ACC_PUBLIC
		) { methodBuilder ->
			methodBuilder.withCode { codeBuilder ->
				codeBuilder
					.aload(0)
					.getfield(
						MimicLookup1x21x1.nativeClassDesc(PackRepository::class),
						"a",
						ConstantDescs.CD_Set
					)
					.aload(1)
					.invokeinterface(
						ConstantDescs.CD_Set,
						"addAll",
						MethodTypeDesc.of(
							ConstantDescs.CD_boolean,
							ConstantDescs.CD_Collection
						)
					)
					.return_()
			}
		}
	}
}