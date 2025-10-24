package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.getLocalVariableInfo
import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.invokeStaticMethodWithLocalVars
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1x21x1Implementations.handleMousePost
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.V1x21x1Implementations.handleMousePre
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_MouseHandler
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class MouseHandlerTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_MouseHandler, "MouseHandler", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		classBuilder.modifyMethod(
			classElement,
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_long,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int
			)
		) { methodBuilder, methodElement ->
			if (methodElement is CodeModel) {
				val localVars = methodBuilder.getLocalVariableInfo(methodElement)
				methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
//					val label = codeBuilder.newLabel()
					codeBuilder
						.atLine(92, codeElement) { builder ->
							// todo figure out how to make the ifne not wrap the remaining method
							//  or figure out how to make the post call not be wrapped in the ifne
						builder
							/*
							.getfield(
								EventSystem::class.classDesc,
								"MOUSE_INPUT_PRE",
								MouseEventPre::class.classDesc
							)
							.iload(2)
							.iload(3)
							.iload(4)
							.invokevirtual(
								MouseEventPre::class.classDesc,
								"post",
								MethodTypeDesc.of(
									ConstantDescs.CD_void,
									ConstantDescs.CD_int,
									ConstantDescs.CD_int,
									ConstantDescs.CD_int
								)
							)
							 */
							.invokeStaticMethodWithLocalVars(
								::handleMousePre.javaMethod,
								localVars,
								ConstantDescs.CD_boolean)
//							.ifne(label)
//						    .return_()
//							.labelBinding(label)
						}
						.atLine(130, codeElement) { builder ->
							builder.invokeStaticMethodWithLocalVars(::handleMousePost.javaMethod, localVars)
						}
						.with(codeElement)
				}
			}
		}
	}
}