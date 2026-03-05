package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.getLocalVariableInfo
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleMouseButtonPost
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleMouseButtonPre
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleScreenMousePressedPost
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleScreenMousePressedPre
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleScreenMouseReleasedPost
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem.handleScreenMouseReleasedPre
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.invokeStaticWithLocalVars
import org.bread_experts_group.eam.minecraft.transform.ClassTransform
import org.bread_experts_group.eam.minecraft.transform.ModTransformHolder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.MouseHandler
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.screens.Screen
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodModel
import java.lang.classfile.Opcode
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.jvm.javaMethod

// todo clean up later
class MouseHandlerTransform(
	transformHolder: ModTransformHolder
) : ClassTransform(
	net_minecraft_client_MouseHandler,
	"MouseHandler",
	transformHolder
) {
	override fun transform(classBuilder: ClassBuilder, classElement: ClassElement) {
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
								.atLineNumber(92, codeElement) { builder ->
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
								.atLineNumber(130, codeElement) { builder ->
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
						methodBuilder.transformCode(methodElement) { codeBuilder, _ ->
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
						methodBuilder.transformCode(methodElement) { codeBuilder, _ ->
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
						methodBuilder.transformCodeIndexed(methodElement) { codeBuilder, codeElement, index ->
							val label = codeBuilder.newLabel()
							codeBuilder
								.atLineNumber(165, codeElement) { builder ->
									builder
										.invokeSpecialNewMimic(MouseHandler::class.classDesc, 0)
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
							if (index == 115) {
								codeBuilder
									.invokeSpecialNewMimic(MouseHandler::class.classDesc, 0)
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
									.ifThen(Opcode.IFEQ) { builder ->
										builder
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
											.dload(14)
											.dload(16)
											.dload(10)
											.dload(12)
											.invokevirtual(
												Screen.classDesc,
												"a",
												MethodTypeDesc.of(
													ConstantDescs.CD_boolean,
													ConstantDescs.CD_double,
													ConstantDescs.CD_double,
													ConstantDescs.CD_double,
													ConstantDescs.CD_double
												)
											)
											.ifThen(Opcode.IFEQ) { builder1 ->
												builder1
													.invokeSpecialNewMimic(MouseHandler::class.classDesc, 0)
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
														"handleScreenMouseScrolledPost",
														MethodTypeDesc.of(
															ConstantDescs.CD_void,
															MouseHandler::class.classDesc,
															Screen.mimicClassDesc,
															ConstantDescs.CD_double,
															ConstantDescs.CD_double
														)
													)
											}

									}
							}
							if (index !in 115 .. 123) codeBuilder.with(codeElement)
						}
					}
				}
			}
			is MethodModel if classElement.methodTypeSymbol() == MethodTypeDesc.of(
				ConstantDescs.CD_void,
				Screen.classDesc,
				ConstantDescs.CD_double,
				ConstantDescs.CD_double,
				ConstantDescs.CD_double,
				ConstantDescs.CD_double
			)                                                                                                           -> {
				classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
					if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, _ ->
						codeBuilder
							.lineNumber(254)
							.invokeSpecialNewMimic(Screen.mimicClassDesc, 1)
							.dload(2)
							.dload(4)
							.aload(0)
							.getfield(
								ClassDesc.of("fgp"),
								"i",
								ConstantDescs.CD_int
							)
							.dload(6)
							.dload(8)
							.invokestatic(
								EventSystem::class.classDesc,
								"handleScreenMouseDraggedPre",
								MethodTypeDesc.of(
									ConstantDescs.CD_boolean,
									Screen.mimicClassDesc,
									ConstantDescs.CD_double,
									ConstantDescs.CD_double,
									ConstantDescs.CD_int,
									ConstantDescs.CD_double,
									ConstantDescs.CD_double
								)
							)
							.ifThen(Opcode.IFNE) { it.return_() }
							.aload(1)
							.dload(2)
							.dload(4)
							.aload(0)
							.getfield(
								ClassDesc.of("fgp"),
								"i",
								ConstantDescs.CD_int
							)
							.dload(6)
							.dload(8)
							.invokevirtual(
								Screen.classDesc,
								"a",
								MethodTypeDesc.of(
									ConstantDescs.CD_boolean,
									ConstantDescs.CD_double,
									ConstantDescs.CD_double,
									ConstantDescs.CD_int,
									ConstantDescs.CD_double,
									ConstantDescs.CD_double
								)
							)
							.ifThen(Opcode.IFNE) { it.return_() }
							.invokeSpecialNewMimic(Screen.mimicClassDesc, 1)
							.dload(2)
							.dload(4)
							.aload(0)
							.getfield(
								ClassDesc.of("fgp"),
								"i",
								ConstantDescs.CD_int
							)
							.dload(6)
							.dload(8)
							.invokestatic(
								EventSystem::class.classDesc,
								"handleScreenMouseDraggedPre",
								MethodTypeDesc.of(
									ConstantDescs.CD_boolean,
									Screen.mimicClassDesc,
									ConstantDescs.CD_double,
									ConstantDescs.CD_double,
									ConstantDescs.CD_int,
									ConstantDescs.CD_double,
									ConstantDescs.CD_double
								)
							)
							.return_()
					}
				}
			}
			else                                                                                                        -> classBuilder.with(classElement)
		}
	}
}