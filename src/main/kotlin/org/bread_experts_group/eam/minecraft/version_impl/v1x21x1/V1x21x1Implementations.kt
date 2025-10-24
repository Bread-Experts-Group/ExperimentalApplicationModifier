package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.eam.addToStaticArray
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.Implementations
import org.bread_experts_group.eam.minecraft.feature.SupportedMCFeatures
import org.bread_experts_group.eam.minecraft.feature.event.EventSystem
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.BuiltInRegistriesTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.CreativeModeScreenTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.CreativeModeTabsTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.GuiTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.ItemRendererTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.MinecraftTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.ModelBakeryTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.MouseHandlerTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.PackRepositoryTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.TitleScreenTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.Gui
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.LayeredDraw
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.ItemBlockRenderTypes
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.entity.ItemRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.BakedModel
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.ModelBakery
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.ModelResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.FolderRepositorySource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.PackRepository
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.PackSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemDisplayContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.logging.ColoredHandler
import java.awt.Color
import java.net.URI
import java.nio.file.FileSystemNotFoundException
import java.nio.file.FileSystems
import java.util.logging.Logger

object V1x21x1Implementations : Implementations() {
	override val logger: Logger = ColoredHandler.newLogger("V1x21x1 Impl")

	// todo temporary solution until i write adding layers directly into Gui itself
	val drawLayers: MutableList<LayeredDraw.Layer> = mutableListOf()

	override val supportedFeatures: SupportedMCFeatures = mutableMapOf(
		MinecraftFeatures.ITEM to mutableListOf(MinecraftItemFeature1x21x1()),
		MinecraftFeatures.BLOCK to mutableListOf(MinecraftBlockFeature1x21x1()),
		MinecraftFeatures.LAYER to mutableListOf(MinecraftLayerFeature1x21x1())
	)

	override fun start() {
		println("Starting Class Transforms")
		BuiltInRegistriesTransform(scanning, classFile).startTransform(true)
		MinecraftTransform(scanning, classFile).startTransform(true)
		GuiTransform(scanning, classFile).startTransform(true)
		ItemRendererTransform(scanning, classFile).startTransform(true)
		ModelBakeryTransform(scanning, classFile).startTransform(true)
		PackRepositoryTransform(scanning, classFile).startTransform(true)
		TitleScreenTransform(scanning, classFile).startTransform(true)
		CreativeModeTabsTransform(scanning, classFile).startTransform(true)
		CreativeModeScreenTransform(scanning, classFile).startTransform(true)
		MouseHandlerTransform(scanning, classFile).startTransform(true)

		EventSystem.addListener(EventSystem.MOUSE_INPUT_PRE) { button, action, _ ->
			println("handling mouse input pre, $button, $action")
			true
		}

		EventSystem.addListener(EventSystem.MOUSE_INPUT_POST) { button, action, _ ->
			println("handling mouse input post, $button, $action")
		}
	}

	@JvmStatic
	@Suppress("unused")
	fun handleMousePre(button: Int, action: Int, modifiers: Int): Boolean {
		return EventSystem.MOUSE_INPUT_PRE.post(button, action, modifiers)
	}

	@JvmStatic
	@Suppress("unused")
	fun handleMousePost(windowPointer: Long, button: Int, action: Int, modifiers: Int) {
		EventSystem.MOUSE_INPUT_POST.post(button, action, modifiers)
	}

	// todo built-in pack source that doesn't need to be manually enabled
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
		println("[EAM Loader] Adding additional pack sources")
	}

	@JvmStatic
	@Suppress("unused")
	fun registerAdditionalModels(self: ModelBakery) {
		println("[EAM Loader] Registering additional models")
		val unbaked = self.getModel("breadmod:item/tool_gun/item")
		self.registerModelAndLoadDependencies(ModelResourceLocation("breadmod:item/tool_gun/item"), unbaked)
		val unbaked2 = self.getModel("breadmod:item/tool_gun/coil")
		self.registerModelAndLoadDependencies(ModelResourceLocation("breadmod:item/tool_gun/coil"), unbaked2)
	}

	var flag = false

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
		// todo temp solution to add to the arrays until a better entrypoint is made
		if (!flag) {
			addToStaticArray(
				net_minecraft_client_gui_screens_inventory_CreativeModeInventoryScreen,
				"G",
				ResourceLocation.clazz,
				ResourceLocation.parse("container/creative_inventory/tab_top_unselected_1")
			)
			addToStaticArray(
				net_minecraft_client_gui_screens_inventory_CreativeModeInventoryScreen,
				"H",
				ResourceLocation.clazz,
				ResourceLocation.parse("container/creative_inventory/tab_top_selected_1")
			)

			flag = true
		}
		val minecraft = Minecraft.getInstance()
		object : BlockEntityWithoutLevelRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels()) {
			val mainModel: BakedModel = Minecraft.getInstance().getModelManager().getModel(
				ModelResourceLocation("breadmod:item/tool_gun/item")
			)
			val coilModel: BakedModel = Minecraft.getInstance().getModelManager().getModel(
				ModelResourceLocation("breadmod:item/tool_gun/coil")
			)
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
		println("[EAM Loader] Registering drawLayers")
		val layers = self.layers
		this.drawLayers.forEach { layers.add(it) }
	}

	@JvmStatic
	@Suppress("unused")
	fun afterCreateContents() {
		mods.forEach {
			it.addBlocks(this.get(MinecraftFeatures.BLOCK))
			it.addItems(this.get(MinecraftFeatures.ITEM))
			it.addLayers(this.get(MinecraftFeatures.LAYER))
		}
	}

	@JvmStatic
	@Suppress("unused")
	fun renderTitleScreen(guiGraphics: GuiGraphics) {
		val poseStack = guiGraphics.pose()
		poseStack.pushPose()
		poseStack.translate(10f, 3f, 0f)
		poseStack.scale(1.25f, 1.25f, 1.25f)
		poseStack.pushPose()
		poseStack.scale(2f, 2f, 2f)
		guiGraphics.renderItem(BuiltInRegistries.ITEM.get(ResourceLocation.parse("breadmod:bread_block")).getDefaultInstance(), 0, 30)
		poseStack.popPose()
		guiGraphics.drawString(Minecraft.getInstance().font, "EAM on top", 0, 0, Color.WHITE.rgb)
		guiGraphics.drawString(Minecraft.getInstance().font, "Version 1.0982317512309128e94", 0, 10, Color.ORANGE.rgb)
		poseStack.popPose()
	}
	@JvmStatic
	@Suppress("unused")
	fun updateWindowTitle(self: Minecraft) {
		self.getWindow().setTitle("Minecraft - EAM 1.21.1")
	}
}