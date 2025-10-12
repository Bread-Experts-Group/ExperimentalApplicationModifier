package org.bread_experts_group.eam.minecraft.feature.v1x21x1

import org.bread_experts_group.eam.minecraft.feature.Implementations
import org.bread_experts_group.eam.minecraft.feature.invokeSpecialNewMimicClass
import org.bread_experts_group.eam.minecraft.feature.invokeStaticMethodWithMimics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.blaze3d.vertex.VertexConsumer
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.com.mojang.math.Axis
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.Gui
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.gui.LayeredDraw
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.renderer.ItemBlockRenderTypes
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.renderer.RenderType
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.renderer.entity.ItemRenderer
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model.BakedModel
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model.ModelBakery
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model.ModelResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.client.resources.model.UnbakedModel
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.PackType
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.repository.FolderRepositorySource
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.repository.PackRepository
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.server.packs.repository.PackSource
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.ItemDisplayContext
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.world.item.ItemStack
import java.awt.Color
import java.lang.classfile.AccessFlags
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile.ACC_FINAL
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.CodeModel
import java.lang.classfile.FieldModel
import java.lang.classfile.MethodModel
import java.lang.classfile.instruction.LineNumber
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method
import java.net.URI
import java.nio.file.FileSystemNotFoundException
import java.nio.file.FileSystems
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.reflect.jvm.javaMethod

object V1x21x1Implementations : Implementations() {
	override fun start() {
		transformClass(
			net_minecraft_core_registries_BuiltInRegistries
		) { classBuilder, classElement ->
			val r = invokeAtMethodReturns(
				net_minecraft_core_registries_BuiltInRegistries_createContents,
				MethodTypeDesc.of(ConstantDescs.CD_void),
				::afterCreateContents.javaMethod!!
			)
			if (!r.invoke(classBuilder, classElement)) classBuilder.with(classElement)
		}

		transformClass(
			net_minecraft_client_gui_screens_TitleScreen
		) { classBuilder, classElement ->
			val r = invokeAtMethodReturns(
				net_minecraft_client_gui_screens_TitleScreen_render,
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					GuiGraphics.classDesc, ConstantDescs.CD_int, ConstantDescs.CD_int,
					ConstantDescs.CD_float
				),
				::renderTitleScreen.javaMethod!!
			)
			if (!r.invoke(classBuilder, classElement)) classBuilder.with(classElement)
		}

		transformClass(
			net_minecraft_client_Minecraft
		) { classBuilder, classElement ->
			val r = invokeAtMethodReturns(
				net_minecraft_client_Minecraft_updateTitle,
				MethodTypeDesc.of(ConstantDescs.CD_void),
				::updateWindowTitle.javaMethod!!
			)
			if (!r.invoke(classBuilder, classElement)) classBuilder.with(classElement)
		}

		transformClass(
			net_minecraft_client_gui_Gui
		) { classBuilder, classElement ->
			val r = invokeAtMethodReturns(
				"<init>",
				MethodTypeDesc.of(ConstantDescs.CD_void, ClassDesc.of(Minecraft.clazz.name)),
				::addLayers.javaMethod!!
			)
			val p = modifyFieldAccess(
				net_minecraft_client_gui_Gui_layers,
				ACC_PUBLIC or ACC_FINAL
			)
			if (
				!(r.invoke(classBuilder, classElement) ||
						p.invoke(classBuilder, classElement))
			) classBuilder.with(classElement)
		}

//		transformClass(
//			net_minecraft_client_renderer_BlockEntityWithoutLevelRenderer
//		) { classBuilder, classElement ->
//			val r = invokeAtMethodReturns(
//				"a",
//				MethodTypeDesc.of(
//					ConstantDescs.CD_void,
//					ItemStack.classDesc,
//					ItemDisplayContext.classDesc,
//					PoseStack.classDesc,
//					MultiBufferSource.classDesc,
//					ConstantDescs.CD_int,
//					ConstantDescs.CD_int
//				),
//				::renderBEWLR.javaMethod!!
//			)
//			if (!r.invoke(classBuilder, classElement)) classBuilder.with(classElement)
//		}

		transformClass(
			net_minecraft_client_renderer_entity_ItemRenderer,
			true
		) { classBuilder, classElement ->
			val p = modifyMethodAccess(
				"a",
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					BakedModel.classDesc,
					ItemStack.classDesc,
					ConstantDescs.CD_int,
					ConstantDescs.CD_int,
					PoseStack.classDesc,
					VertexConsumer.classDesc
				),
				ACC_PUBLIC
			)

			if (
				classElement is MethodModel &&
				classElement.methodName().equalsString("a") &&
				classElement.methodTypeSymbol() == MethodTypeDesc.of(
					ConstantDescs.CD_void,
					ItemStack.classDesc,
					ItemDisplayContext.classDesc,
					ConstantDescs.CD_boolean,
					PoseStack.classDesc,
					MultiBufferSource.classDesc,
					ConstantDescs.CD_int,
					ConstantDescs.CD_int,
					BakedModel.classDesc
				)) {
				classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
					if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
						codeBuilder.with(codeElement)
						if (codeElement is LineNumber && codeElement.line() == 127)
							codeBuilder
								.invokeSpecialNewMimicClass(ItemStack.mimicClassDesc, 1)
								.invokeSpecialNewMimicClass(ItemDisplayContext.mimicClassDesc, 2)
								.invokeSpecialNewMimicClass(PoseStack.mimicClassDesc, 4)
								.invokeSpecialNewMimicClass(MultiBufferSource.mimicClassDesc, 5)
								.iload(6)
								.iload(7)
								.invokestatic(
									ClassDesc.of(this::class.qualifiedName),
									"renderBEWLR",
									MethodTypeDesc.of(
										ConstantDescs.CD_void,
										ItemStack.mimicClassDesc,
										ItemDisplayContext.mimicClassDesc,
										PoseStack.mimicClassDesc,
										MultiBufferSource.mimicClassDesc,
										ConstantDescs.CD_int,
										ConstantDescs.CD_int
									)
								)
					}
				}
			} else if (!p.invoke(classBuilder, classElement)) classBuilder.with(classElement)
		}

		transformClass(
			net_minecraft_client_resources_model_ModelBakery
		) { classBuilder, classElement ->
			val regModelAccess = modifyMethodAccess(
				"a",
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					ModelResourceLocation.classDesc,
					UnbakedModel.classDesc
				),
				ACC_PUBLIC
			)
			val getModelAccess = modifyMethodAccess(
				"a",
				MethodTypeDesc.of(
					UnbakedModel.classDesc,
					ResourceLocation.classDesc
				),
				ACC_PUBLIC
			)
			val returnInvoke = invokeAtMethodReturns(
				"<init>",
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					ClassDesc.of("fhq"), // BlockColors
					ClassDesc.of("bnf"), // ProfileFiller,
					ClassDesc.of(Map::class.java.name),
					ClassDesc.of(Map::class.java.name)
				),
				::registerAdditionalModels.javaMethod!!
			)
			if (
				!(regModelAccess.invoke(classBuilder, classElement) ||
						getModelAccess.invoke(classBuilder, classElement) ||
							returnInvoke.invoke(classBuilder, classElement)
						)
				) classBuilder.with(classElement)
		}

		transformClass(
			net_minecraft_server_packs_repository_PackRepository
		) { classBuilder, classElement ->
			if (
				classElement is MethodModel &&
				classElement.methodName().equalsString("<init>")
			) {
				classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
					if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
						if (
							codeElement is LineNumber &&
							codeElement.line() == 27
							) {
							codeBuilder
								.aload(0)
								.new_(ClassDesc.of(java.util.LinkedHashSet::class.java.name))
								.dup()
								.aload(1)
								.invokestatic(
									ClassDesc.of(java.util.List::class.java.name),
									"of",
									MethodTypeDesc.of(
										ClassDesc.of(java.util.List::class.java.name),
										ConstantDescs.CD_Object.arrayType(1)
									),
									true
								)
								.invokespecial(
									ClassDesc.of(java.util.LinkedHashSet::class.java.name),
									"<init>",
									MethodTypeDesc.of(
										ConstantDescs.CD_void,
										ClassDesc.of(java.util.Collection::class.java.name)
									)
								)
								.putfield(
									ClassDesc.of(net_minecraft_server_packs_repository_PackRepository),
									"a",
									ClassDesc.of(java.util.Set::class.java.name)
								)
								.aload(0)
								.invokeStaticMethodWithMimics(::addPackSources.javaMethod!!)
								.return_()
						}
						codeBuilder.with(codeElement)
					}
				}
				classBuilder.withMethod(
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
			} else classBuilder.with(classElement)
		}
	}

	// todo temporary solution until i write adding layers directly into Gui itself
	val drawLayers: MutableList<LayeredDraw.Layer> = mutableListOf()

	@JvmStatic
	@Suppress("unused")
	fun addPackSources(self: PackRepository) {
		val validator = Minecraft.getInstance().directoryValidator()
		val resourceLocation = this::class.java.getResource("/resources")?.toURI()
		val env = hashMapOf<String, String>()
		val array = resourceLocation.toString().split("!")
		val uri = URI.create(array[0])
		val fs = try {
			FileSystems.getFileSystem(uri)
		} catch (_: FileSystemNotFoundException) {
			FileSystems.newFileSystem(uri, env)
		}
		val path = fs.getPath(array[1])
		val sources = listOf(
			FolderRepositorySource(path, PackType.CLIENT_RESOURCES, PackSource.DEFAULT, validator)
		)
		self.addSources(sources)
		println("adding additional pack sources")
	}

	@JvmStatic
	@Suppress("unused")
	fun registerAdditionalModels(self: ModelBakery) {
		println("Registering additional models")
		val unbaked = self.getModel("breadmod:item/tool_gun/item")
		self.registerModelAndLoadDependencies(ModelResourceLocation("breadmod:item/tool_gun/item"), unbaked)
		val unbaked2 = self.getModel("breadmod:item/tool_gun/coil")
		self.registerModelAndLoadDependencies(ModelResourceLocation("breadmod:item/tool_gun/coil"), unbaked2)
	}

	@JvmStatic
	@Suppress("unused")
	fun renderBEWLR(
		stack: ItemStack,
		displayContext: ItemDisplayContext,
		poseStack: PoseStack,
		bufferSource: MultiBufferSource,
		packedLight: Int,
		packedOverlay: Int
	) {
		val minecraft = Minecraft.getInstance()
		object : BlockEntityWithoutLevelRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels()) {
			val mainModel: BakedModel = Minecraft.getInstance().getModelManager().getModel(ModelResourceLocation("breadmod:item/tool_gun/item"))
			val coilModel: BakedModel = Minecraft.getInstance().getModelManager().getModel(ModelResourceLocation("breadmod:item/tool_gun/coil"))
			val itemRenderer = Minecraft.getInstance().getItemRenderer()

			override fun renderByItem(
				stack: ItemStack,
				displayContext: ItemDisplayContext,
				poseStack: PoseStack,
				bufferSource: MultiBufferSource,
				packedLight: Int,
				packedOverlay: Int
			) {
				val consumer = ItemRenderer.getFoilBufferDirect(
					bufferSource,
					ItemBlockRenderTypes.getRenderType(stack, false),
					true,
					stack.hasFoil()
				)

				poseStack.pushPose()
				itemRenderer.renderModelLists(mainModel, stack, packedLight, packedOverlay, poseStack, consumer)
				itemRenderer.renderModelLists(coilModel, stack, packedLight, packedOverlay, poseStack, consumer)
				poseStack.popPose()
			}
		}.renderByItem(stack, displayContext, poseStack, bufferSource, packedLight, packedOverlay)
	}

	@JvmStatic
	@Suppress("unused")
	fun addLayers(self: Gui) {
		println("registering drawLayers")
		val layers = self.layers
		this.drawLayers.forEach { layers.add(it) }
	}

	@JvmStatic
	@Suppress("unused")
	fun afterCreateContents() {
		mods.forEach { it.addBlocks(MinecraftBlockFeature1x21x1()) }
		mods.forEach { it.addItems(MinecraftItemFeature1x21x1()) }
		mods.forEach { it.addLayers(MinecraftLayerFeature1x21x1()) }
	}

	@JvmStatic
	@Suppress("unused")
	fun renderTitleScreen(titleScreen: Any, guiGraphics: GuiGraphics) {
		val poseStack = guiGraphics.pose()
		poseStack.pushPose()
		poseStack.translate(10f, 3f, 0f)
		poseStack.scale(1.25f, 1.25f, 1.25f)
		poseStack.pushPose()
		poseStack.scale(2f, 2f, 2f)
		guiGraphics.renderItem(BuiltInRegistries.ITEM.get(ResourceLocation.parse("breadmod:bread_block")).getDefaultInstance(), 0, 30)
		poseStack.popPose()
		poseStack.mulPose(Axis.ZP.rotationDegrees(25f))
		guiGraphics.drawString(Minecraft.getInstance().font, "EAM on top", 0, 0, Color.WHITE.rgb)
		guiGraphics.drawString(Minecraft.getInstance().font, "oh yeah also minecraft is very cool and nice you should play it :thumbsup:", 0, 10, Color.ORANGE.rgb)
		poseStack.popPose()
	}

	@JvmStatic
	@Suppress("unused")
	fun updateWindowTitle(self: Minecraft) {
		self.getWindow().setTitle("Minecraft - EAM 1.21.1")
	}

	private fun transformClass(
		qualifiedName: String,
		writeModifiedFile: Boolean = false,
		transform: (ClassBuilder, ClassElement) -> Unit
	) {
		scanning[qualifiedName] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) { classBuilder, classElement ->
				transform(classBuilder, classElement)
			}.also { if(writeModifiedFile) Files.write(Path("${qualifiedName.substringAfterLast('_')}.class"), it) }
		}
	}

	private fun invokeAtMethodReturns(
		targetMethodName: String,
		targetMethodType: MethodTypeDesc,
		method: Method
	): (ClassBuilder, ClassElement) -> Boolean {
		if (method.returnType != Void.TYPE) throw IllegalArgumentException(
			"$method (in injection to returns of $targetMethodName : $targetMethodType) must return void!"
		)
		return transform@{ classBuilder, classElement ->
			if (
				classElement is MethodModel &&
				classElement.methodName().equalsString(targetMethodName) &&
				classElement.methodType().equalsString(targetMethodType.descriptorString())
			) {
				classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
					if (methodElement is CodeModel) methodBuilder.transformCode(methodElement) { codeBuilder, codeElement ->
						if (codeElement is ReturnInstruction) codeBuilder.invokeStaticMethodWithMimics(method)
						codeBuilder.with(codeElement)
					}
				}
				return@transform true
			}
			return@transform false
		}
	}

	private fun modifyFieldAccess(
		targetField: String,
		newAccessFlags: Int
	): (ClassBuilder, ClassElement) -> Boolean = transform@{ classBuilder, classElement ->
		if (
			classElement is FieldModel &&
			classElement.fieldName().equalsString(targetField)
		) {
			classBuilder.transformField(classElement) { fieldBuilder, fieldElement ->
				if (fieldElement is AccessFlags) fieldBuilder.withFlags(newAccessFlags)
				else fieldBuilder.with(fieldElement)
			}
			return@transform true
		}
		return@transform false
	}

	private fun modifyMethodAccess(
		targetMethod: String,
		targetMethodType: MethodTypeDesc,
		newAccessFlags: Int
	): (ClassBuilder, ClassElement) -> Boolean = transform@{ classBuilder, classElement ->
		if (
			classElement is MethodModel &&
			classElement.methodName().equalsString(targetMethod) &&
			classElement.methodType().equalsString(targetMethodType.descriptorString())
			) {
			classBuilder.transformMethod(classElement) { methodBuilder, methodElement ->
				if (methodElement is AccessFlags) methodBuilder.withFlags(newAccessFlags)
				else methodBuilder.with(methodElement)
			}
			return@transform true
		}
		return@transform false
	}
}