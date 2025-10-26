package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.getLocalVariableInfo
import org.bread_experts_group.eam.injectTestMethod
import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleMouseButtonPost
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleMouseButtonPre
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleScreenMousePressedPost
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleScreenMousePressedPre
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleScreenMouseReleasedPost
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleScreenMouseReleasedPre
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimicClass
import org.bread_experts_group.eam.minecraft.invokeStaticWithLocalVars
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.Screen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_MouseHandler
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.Opcode
import java.lang.classfile.instruction.InvokeInstruction
import java.lang.classfile.instruction.StackInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

class MouseHandlerTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_MouseHandler, "MouseHandler", scanning, classFile) {
	private var passed: Boolean = false
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		when (classElement) {
			is MethodModel if classElement.methodName().equalsString("a") && classElement.methodTypeSymbol() == MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_long,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int,
				ConstantDescs.CD_int
			)                                                                                                           -> { // onClick
				classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
					if (methodElement is CodeModel) {
						val localVars = methodBuilder.getLocalVariableInfo(methodElement)
						methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							val label = codeBuilder.newLabel()
							codeBuilder
								.atLine(92, codeElement) { builder ->
									builder
										.invokeStaticWithLocalVars(
											::handleMouseButtonPre.javaMethod,
											localVars,
											ConstantDescs.CD_boolean
										)
										.ifeq(label)
										.return_()
										.labelBinding(label)
								}
								.atLine(130, codeElement) { builder ->
									builder.invokeStaticWithLocalVars(::handleMouseButtonPost.javaMethod, localVars)
								}
								.with(codeElement)
						}
					}
				}
			}
			is MethodModel if classElement.flags().flagsMask() == 0x100A && classElement.methodName().equalsString("b") -> { // mouseClicked event handler
				classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
					if (methodElement is CodeModel) {
						val localVars = methodBuilder.getLocalVariableInfo(methodElement)
						methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							codeBuilder
								.aload(0)
								.iconst_0()
								.invokeStaticWithLocalVars(
									::handleScreenMousePressedPre.javaMethod,
									localVars,
									ConstantDescs.CD_boolean
								)
								.bastore()
								.aload(0)
								.iconst_0()
								.baload()
								.ifThen(Opcode.IFEQ) { builder ->
									builder
										.aload(0)
										.iconst_0()
										.aload(1)
										.dload(2)
										.dload(4)
										.iload(6)
										.invokevirtual(
											Screen.classDesc,
											"a",
											MethodTypeDesc.of(
												ConstantDescs.CD_boolean,
												ConstantDescs.CD_double,
												ConstantDescs.CD_double,
												ConstantDescs.CD_int
											)
										)
										.bastore()
										.invokeStaticWithLocalVars(
											::handleScreenMousePressedPost.javaMethod,
											localVars
										)
										.return_()
								}
								.return_()
						}
					}
				}
			}
			is MethodModel if classElement.methodName().equalsString("a") && classElement.methodTypeSymbol() == MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_boolean.arrayType(1),
				Screen.classDesc,
				ConstantDescs.CD_double,
				ConstantDescs.CD_double,
				ConstantDescs.CD_int
			)                                                                                                           -> { // mouseReleased event handler
				classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
					if (methodElement is CodeModel) {
						val localVars = methodBuilder.getLocalVariableInfo(methodElement)
						methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							codeBuilder
								.aload(0)
								.iconst_0()
								.invokeStaticWithLocalVars(
									::handleScreenMouseReleasedPre.javaMethod,
									localVars,
									ConstantDescs.CD_boolean
								)
								.bastore()
								.aload(0)
								.iconst_0()
								.baload()
								.ifThen(Opcode.IFEQ) { builder ->
									builder
										.aload(0)
										.iconst_0()
										.aload(1)
										.dload(2)
										.dload(4)
										.iload(6)
										.invokevirtual(
											Screen.classDesc,
											"b",
											MethodTypeDesc.of(
												ConstantDescs.CD_boolean,
												ConstantDescs.CD_double,
												ConstantDescs.CD_double,
												ConstantDescs.CD_int
											)
										)
										.bastore()
										.invokeStaticWithLocalVars(
											::handleScreenMouseReleasedPost.javaMethod,
											localVars
										)
										.return_()
								}
								.return_()
						}
					}
				}
			}
			is MethodModel if classElement.methodName().equalsString("a") && classElement.methodTypeSymbol() == MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_long,
				ConstantDescs.CD_double,
				ConstantDescs.CD_double
			)                                                                                                           -> { // onScroll
				classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
					if (methodElement is CodeModel) {
//						val localVars = methodBuilder.getLocalVariableInfo(methodElement)
						methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
							val label = codeBuilder.newLabel()
							codeBuilder
								.atLine(165, codeElement) { builder ->
									builder
										.invokeSpecialNewMimicClass(MouseHandler::class.classDesc, 0)
										.dload(3)
										.dload(5)
										.invokestatic(
											EventSystem::class.classDesc,
											"handleMouseScroll",
											MethodTypeDesc.of(
												ConstantDescs.CD_boolean,
												MouseHandler::class.classDesc,
												ConstantDescs.CD_double,
												ConstantDescs.CD_double
											)
										)
										.ifeq(label)
										.return_()
										.labelBinding(label)
								}
							val label1 = codeBuilder.newLabel()
							val label2 = codeBuilder.newLabel()
							// todo figure out how to combine the two ifs here and figure out how to properly "delete" instructions
							if (
								codeElement is InvokeInstruction &&
								codeElement.typeSymbol() == MethodTypeDesc.of(
									ConstantDescs.CD_boolean,
									ConstantDescs.CD_double,
									ConstantDescs.CD_double,
									ConstantDescs.CD_double,
									ConstantDescs.CD_double
								)
							) {
								codeBuilder
									.invokeSpecialNewMimicClass(MouseHandler::class.classDesc, 0)
									.new_(Screen.mimicClassDesc)
									.dup()
									.aload(0)
									.getfield(
										ClassDesc.of("fgp"),
										"b",
										Minecraft.classDesc
									)
									.getfield(
										Minecraft.classDesc,
										"y",
										Screen.classDesc
									)
									.invokespecial(
										Screen.mimicClassDesc,
										"<init>",
										MethodTypeDesc.of(
											ConstantDescs.CD_void,
											ConstantDescs.CD_Object
										)
									)
									.dload(8)
									.dload(10)
									.invokestatic(
										EventSystem::class.classDesc,
										"handleScreenMouseScrolledPre",
										MethodTypeDesc.of(
											ConstantDescs.CD_boolean,
											MouseHandler::class.classDesc,
											Screen.mimicClassDesc,
											ConstantDescs.CD_double,
											ConstantDescs.CD_double
										)
									)
									.ifne(label1)
									.injectTestMethod()
									.labelBinding(label1)
							}
							if (
								codeElement is StackInstruction &&
								codeElement.opcode() == Opcode.POP &&
								!passed
							) {
								codeBuilder
									.ifne(label2)
									.injectTestMethod()
									.labelBinding(label2)
								passed = true
							} else codeBuilder.with(codeElement)
						}
					}
				}
			}
			else                                                                                                        -> classBuilder.with(classElement)
		}
	}
}