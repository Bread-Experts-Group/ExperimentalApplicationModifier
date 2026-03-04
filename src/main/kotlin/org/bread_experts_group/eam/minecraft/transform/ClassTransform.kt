package org.bread_experts_group.eam.minecraft.transform

import org.bread_experts_group.eam.JARDefiningClassLoader
import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.clazz
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations.Companion.writeTransformedClasses
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod
import org.bread_experts_group.eam.minecraft.feature.MinecraftMod.Companion.modID
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.loadConstant
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.qualifiedName
import java.lang.classfile.*
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.instruction.FieldInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Field
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.createParentDirectories
import kotlin.jvm.java
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.isSubclassOf

/**
 * Intended to be used internally by EAM to set up initial transforms for MC Classes.
 * Mods are passed into the transform after EAM performs the initial processing.
 * // todo allow mods to define entirely new class transforms in the future
 */
abstract class ClassTransform(
	private val targetClass: String,
	private val deobfClassName: String,
	private val scanning: Scanning,
	private val classFile: ClassFile,
) : CodeTransformer {
	override val existingElements: MutableList<String> = mutableListOf()
	val thisClassDesc: ClassDesc = ClassDesc.of(targetClass.replace('/', '.'))

	fun addTransform(transformHolder: ModTransformHolder) {
		scanning[targetClass] = { _, _, _, data ->
			val model = classFile.parse(data)
			var transformed = classFile.build(model.thisClass().asSymbol()) { classBuilder ->
				classBuilder.withVersion(ClassFile.JAVA_24_VERSION, 0)
				model.filterNot { it is ClassFileVersion }.forEach { classElement ->
					transform().invoke(classBuilder, classElement)
				}
			}
			val clDesc = ClassLoader::class.java.classDesc
			transformHolder.getTransforms(targetClass).forEach { (mod, transform) ->
				var model = classFile.parse(transformed)
				val modelTransformed = classFile.transformClass(model, transform::process)
				model = classFile.parse(modelTransformed)
				val classesInUse = mutableSetOf<String>()
				val jarClassesInUse = mutableSetOf<String>()
				val modLoader = mod::class.java.classLoader as JARDefiningClassLoader.ModClassLoader
				for (classElement in model) when (classElement) {
					is MethodModel -> classElement.code().ifPresent { code ->
						for (codeElement in code) when (codeElement) {
							is FieldInstruction -> classesInUse.add(
								codeElement.owner().asInternalName().lowercase() + ".class"
							)

							else -> {}
						}
					}

					else -> {}
				}
				modLoader.bslFindFiles(classesInUse) { e, _ ->
					jarClassesInUse.add(e.name.lowercase().take(e.name.length - 6))
				}
				transformed = classFile.build(model.thisClass().asSymbol()) { builder ->
					for (classElement in model) when (classElement) {
						is MethodModel -> classElement.code().ifPresentOrElse({ code ->
							builder.withMethodBody(
								classElement.methodName(),
								classElement.methodType(),
								classElement.flags().flagsMask()
							) { builder ->
								for (codeElement in code) when (codeElement) {
									is FieldInstruction -> {
										if (jarClassesInUse.contains(
												codeElement.owner().asInternalName().lowercase()
											)
										) {
											val tr =
												"org.bread_experts_group.eam.minecraft.transform.TransformReflectionKt"
											builder.invokestatic(
												clDesc,
												"getSystemClassLoader",
												MethodTypeDesc.of(clDesc)
											).loadConstant(
												tr
											).invokevirtual(
												clDesc,
												"loadClass",
												MethodTypeDesc.of(
													ConstantDescs.CD_Class,
													ConstantDescs.CD_String
												)
											).getstatic(
												ClassDesc.of(tr),
												"classLoaders",
												Map::class.java.classDesc
											).loadConstant(
												modLoader.id
											).invokeinterface(
												Map::class.java.classDesc,
												"get",
												MethodTypeDesc.of(
													ConstantDescs.CD_Object,
													ConstantDescs.CD_Object
												)
											).checkcast(
												clDesc
											).loadConstant(
												codeElement.owner().asSymbol().qualifiedName
											).invokevirtual(
												clDesc,
												"loadClass",
												MethodTypeDesc.of(
													ConstantDescs.CD_Class,
													ConstantDescs.CD_String
												)
											).loadConstant(
												codeElement.name().stringValue()
											).invokevirtual(
												ConstantDescs.CD_Class,
												"getField",
												MethodTypeDesc.of(
													Field::class.java.classDesc,
													ConstantDescs.CD_String
												)
											).aconst_null(
											).invokevirtual(
												Field::class.java.classDesc,
												"get",
												MethodTypeDesc.of(
													ConstantDescs.CD_Object,
													ConstantDescs.CD_Object
												)
											).checkcast(
												codeElement.typeSymbol()
											)
										} else builder.with(codeElement)
									}

									else -> builder.with(codeElement)
								}
							}
						}) {
							builder.with(classElement)
						}

						else -> builder.with(classElement)
					}
				}
			}
			val path = MinecraftImplementations.arguments.get(writeTransformedClasses)
			val target = targetClass.replace('/', '_').substringAfterLast('_')
			if (path != null) Files.write(
				Path(path)
					.resolve("$deobfClassName [$target].class")
					.createParentDirectories(),
				transformed
			)
			transformed
		}
	}

//	private fun transformClass(data: ByteArray, transform: ClassTransform) {
//		this.classFile.transformClass(this.classFile.parse(data), transform)
//	}

	// todo look into lambda transferring
	/**
	 * Integrates a method from a [sourceClass] into the class transform.
	 *
	 * @param generateMimicMethod Generates an additional method to invoke mimic based parameters from the source method using native classes.
	 */
	fun ClassBuilder.integrateMethod(
		sourceClass: Class<*>,
		methodName: String,
		methodTypeDesc: MethodTypeDesc? = null,
		generateMimicMethod: Boolean = false
	) {
		if (methodName !in existingElements) existingElements.add(methodName) else return
		val classData = classFile.parse(readClassSource(sourceClass))
		val method = classData.filterIsInstance<MethodModel>().firstOrNull { model ->
			model.methodName().equalsString(methodName) &&
					(model.methodTypeSymbol() == methodTypeDesc || methodTypeDesc == null)
		} ?: return
		this.with(method)
		// todo lambda stuff is hard...
		//  minecraft 1x0x0 has lambda implementations, look into using those to transfer lambdas to other classes
		/*this.withMethod(
			method.methodName().stringValue(),
			method.methodTypeSymbol(),
			method.flags().flagsMask()
		) { mBuilder ->
			val desc = NativeLookupV1x21x1.nativeClassDesc(ClientLevel::class)
			method.forEach { element ->
				if (element is CodeModel) mBuilder.withCode { cB ->
					element.forEach { cE ->
						if (cE is InvokeDynamicInstruction) {
//								cB.with(cE)
//								cB.invokedynamic(cE.invokedynamic())
							val staticMethod = cE.bootstrapArgs().filterIsInstance<MethodHandleDesc>().first()
							println(cE.bootstrapArgs())
							val rType = staticMethod.invocationType().returnType()
							val mName = staticMethod.toString()
								.substringBefore("()" + rType.displayName())
								.substringAfter("::")
//								println(mName)
							transformClass(classData) { b, e ->
								if (e is MethodModel && e.methodName().equalsString(mName)) {
									this.with(e)
									println(e)
								}
							}
							cB.invokedynamic(DynamicCallSiteDesc.of(
								cE.bootstrapMethod(),
								cE.name().stringValue(),
								cE.typeSymbol(),
								cE.bootstrapArgs()[0],
								MethodHandleDesc.ofMethod(
									DirectMethodHandleDesc.Kind.STATIC,
									desc,
									mName,
									DEFAULT_VOID
								),
								cE.bootstrapArgs()[2]
							))
						} else if (cE is InvokeInstruction) {
							cB.invokevirtual(
								desc,
								$$"lambda$lambdaExecute$0",
								DEFAULT_VOID
							)
						} else cB.with(cE)
					}
				} else mBuilder.with(element)
			}
		}*/
		if (generateMimicMethod) {
			val typeDesc = method.methodTypeSymbol()
			this.withMethodBody(
				"${method.methodName()}_EAMGenerated",
				MethodTypeDesc.of(
					typeDesc.returnType(),
					typeDesc.parameterList().map { desc ->
						if (desc.isPrimitive) desc else {
							val clazz = desc.clazz
							if (clazz.kotlin.isSubclassOf(MimickedClass::class)) {
								val companionInst = clazz.kotlin.companionObjectInstance!!
								companionInst.javaClass.getMethod("getClassDesc").invoke(companionInst) as ClassDesc
							} else desc
						}
					}
				),
				ACC_PUBLIC
			) { codeBuilder ->
				val parameters = method.methodTypeSymbol().parameterList()
				codeBuilder.aload(0)
				parameters.forEachIndexed { index, desc ->
					val slot = index + 1
					if (desc.isPrimitive) {
						when (desc.descriptorString()) {
							"Z" -> codeBuilder.iload(slot)
							"D" -> codeBuilder.dload(slot)
							"F" -> codeBuilder.fload(slot)
							"J" -> codeBuilder.lload(slot)
						}
					} else codeBuilder.invokeSpecialNewMimic(desc, slot)
				}

				codeBuilder
					.invokevirtual(
						ClassDesc.of(targetClass),
						methodName,
						method.methodTypeSymbol()
					)
					.return_()
			}
		}
	}

	/**
	 * ## !!WARNING!!
	 * This method is executed multiple times during class transformation due to [ClassBuilder] iterating through the structure being built.
	 *
	 * Ensure calls that add methods or fields aren't ran more than once, or else the JVM will throw an error about duplicate entries.
	 *
	 * @see addMethod
	 * @see transformMethod
	 * @see transformMethodCode
	 * @see transformCodeIndexed
	 */
	protected abstract fun transform(): (ClassBuilder, ClassElement) -> Unit
}