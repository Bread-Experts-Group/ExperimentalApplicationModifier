package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.invokeStaticMethodWithMimics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1x21x1Implementations.addPackSources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_server_packs_repository_PackRepository
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.CodeModel
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class PackRepositoryTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_server_packs_repository_PackRepository, "PackRepository", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		classBuilder.modifyMethod(classElement, "<init>") { methodBuilder, methodElement ->
			if (methodElement is CodeModel) {
				methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
					codeBuilder.atLine(27, codeElement) { builder ->
						builder
							.aload(0)
							.new_(ClassDesc.of(LinkedHashSet::class.java.name))
							.dup()
							.aload(1)
							.invokestatic(
								ClassDesc.of(List::class.java.name),
								"of",
								MethodTypeDesc.of(
									ClassDesc.of(List::class.java.name),
									ConstantDescs.CD_Object.arrayType(1)
								),
								true
							)
							.invokespecial(
								ClassDesc.of(LinkedHashSet::class.java.name),
								"<init>",
								MethodTypeDesc.of(
									ConstantDescs.CD_void,
									ClassDesc.of(Collection::class.java.name)
								)
							)
							.putfield(
								ClassDesc.of(net_minecraft_server_packs_repository_PackRepository),
								"a",
								ClassDesc.of(Set::class.java.name)
							)
							.aload(0)
//								.invokestatic(
//									ClassDesc.of(V1x21x1Implementations::class.qualifiedName),
//									"addPackSources",
//									MethodTypeDesc.of(
//										ConstantDescs.CD_void,
//										PackRepository.classDesc
//									)
//								)
							.invokeStaticMethodWithMimics(::addPackSources.javaMethod!!)
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
				ClassDesc.of("java.util.Collection")
			),
			ACC_PUBLIC
		) { methodBuilder ->
			methodBuilder.withCode { codeBuilder ->
				codeBuilder
					.aload(0)
					.getfield(
						ClassDesc.of(net_minecraft_server_packs_repository_PackRepository),
						"a",
						ClassDesc.of("java.util.Set")
					)
					.aload(1)
					.invokeinterface(
						ClassDesc.of("java.util.Set"),
						"addAll",
						MethodTypeDesc.of(
							ConstantDescs.CD_boolean,
							ClassDesc.of("java.util.Collection")
						)
					)
					.return_()
			}
		}
	}
}