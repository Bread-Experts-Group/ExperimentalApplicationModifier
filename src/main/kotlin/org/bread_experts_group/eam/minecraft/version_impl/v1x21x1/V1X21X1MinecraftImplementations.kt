package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1

import org.bread_experts_group.bslBuildDate
import org.bread_experts_group.bslVersion
import org.bread_experts_group.eam.addToStaticArray
import org.bread_experts_group.eam.minecraft.MinecraftFeatures
import org.bread_experts_group.eam.minecraft.feature.EAMRegistries
import org.bread_experts_group.eam.minecraft.feature.MinecraftImplementations
import org.bread_experts_group.eam.minecraft.feature.SupportedMCFeatures
import org.bread_experts_group.eam.minecraft.test_mods.breadmod.BMContent
import org.bread_experts_group.eam.minecraft.test_mods.breadmod.BMContentClient
import org.bread_experts_group.eam.minecraft.test_mods.breadmod.BMContentClient.TEST_RENDERER
import org.bread_experts_group.eam.minecraft.test_mods.breadmod.TestBlockEntity
import org.bread_experts_group.eam.minecraft.test_mods.breadmod.TestBlockEntityRenderer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_client_gui_screens_inventory_CreativeModeInventoryScreen
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.AbstractTextureTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.BlockEntityRenderersTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.BlockEntitySupplierTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.BlockEntityTypeTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.BuiltInPackSourceTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.BuiltInRegistriesTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.CameraTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.ClientLevelTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.CreativeModeScreenTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.CreativeModeTabsTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.GameRendererTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.GuiTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.ItemRendererTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.LevelRendererTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.MinecraftTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.ModelBakeryTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.MouseHandlerTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.PackRepositoryTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.RenderStateShardTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.RenderTypeTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.TextureManagerTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms.TitleScreenTransform
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.DefaultVertexFormat
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.vertex.PoseStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.datafixers.util.Pair
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.Minecraft
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.Gui
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.GuiGraphics
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.gui.LayeredDraw
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.MultiBufferSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.ShaderInstance
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.blockentity.BlockEntityRenderers
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.ModelBakery
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.resources.model.ModelResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.Registry
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.core.registries.BuiltInRegistries
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.PackRepository
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.resources.ResourceProvider
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.CreativeModeTab
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.CreativeModeTabs.Companion.createKey
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemDisplayContext
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.item.ItemStack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.block.entity.BlockEntityType.Builder
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.pack_resources.LoaderPackSource
import org.bread_experts_group.logging.ColoredHandler
import java.awt.Color
import java.net.URI
import java.nio.file.FileSystemNotFoundException
import java.nio.file.FileSystems
import java.util.function.Consumer
import java.util.logging.Logger

@Suppress("unused")
object V1X21X1MinecraftImplementations : MinecraftImplementations() {
	override val logger: Logger = ColoredHandler.newLogger("V1x21x1 Impl")

	// todo temporary solution until i write adding layers directly into Gui itself
	val drawLayers: MutableList<LayeredDraw.Layer> = mutableListOf()

	override val supportedFeatures: SupportedMCFeatures = mutableMapOf(
		MinecraftFeatures.ITEM to mutableListOf(MinecraftItemFeature1x21x1()),
		MinecraftFeatures.BLOCK to mutableListOf(MinecraftBlockFeature1x21x1()),
		MinecraftFeatures.LAYER to mutableListOf(MinecraftLayerFeature1x21x1()),
		MinecraftFeatures.CREATIVE_TAB to mutableListOf(MinecraftCreativeTabFeature1x21x1())
	)

	override fun start() {
		logger.info("Starting Class Transforms")
		BuiltInRegistriesTransform(scanning, classFile).startTransform()
		MinecraftTransform(scanning, classFile).startTransform()
		GuiTransform(scanning, classFile).startTransform()
		ItemRendererTransform(scanning, classFile).startTransform()
		ModelBakeryTransform(scanning, classFile).startTransform()
		PackRepositoryTransform(scanning, classFile).startTransform()
		TitleScreenTransform(scanning, classFile).startTransform()
		CreativeModeTabsTransform(scanning, classFile).startTransform()
		CreativeModeScreenTransform(scanning, classFile).startTransform()
		MouseHandlerTransform(scanning, classFile).startTransform()
		ClientLevelTransform(scanning, classFile).startTransform()
		CameraTransform(scanning, classFile).startTransform()
		BlockEntityRenderersTransform(scanning, classFile).startTransform()
		BlockEntityTypeTransform(scanning, classFile).startTransform()
		BlockEntitySupplierTransform(scanning, classFile).startTransform()
		TextureManagerTransform(scanning, classFile).startTransform()
		AbstractTextureTransform(scanning, classFile).startTransform()
		GameRendererTransform(scanning, classFile).startTransform()
		RenderTypeTransform(scanning, classFile).startTransform()
		RenderStateShardTransform(scanning, classFile).startTransform()
		LevelRendererTransform(scanning, classFile).startTransform()
		BuiltInPackSourceTransform(scanning, classFile).startTransform()

		// todo a way to implement natives directly into mimics in the future?
		scanning["org.bread_experts_group.eam.minecraft.test_mods.breadmod.camera.CameraTexture"] = { _, _, _, data ->
			val model = classFile.parse(data)
			classFile.transformClass(model) { classBuilder, classElement ->
				println(classElement)
				classBuilder.with(classElement)
			}
		}

		this.mods.forEach { it.registerEvents() }
	}

	// todo refer to MinecraftCreativeTab
	@JvmStatic
	fun registerTabs(registry: Registry<CreativeModeTab>) {
		var column = 7
		this.mods.forEach { it.addCreativeTabs(this.get(MinecraftFeatures.CREATIVE_TAB)) }
		EAMRegistries.CREATIVE_TABS.entryIterator().forEach { (identifier, _) ->
			val tab = CreativeModeTab.builder(CreativeModeTab.Row.TOP, column++)
				.title(Component.literal(identifier.namespace))
				.displayItems { _, output ->
					EAMRegistries.ITEMS.entryIterator().forEach { (identifier, _) ->
						val (namespace, subject) = identifier
						val item = BuiltInRegistries.ITEM.get(ResourceLocation.parse("$namespace:$subject"))
						output.accept(item.getDefaultInstance())
					}
					EAMRegistries.BLOCKS.entryIterator().forEach { (identifier, _) ->
						val (namespace, subject) = identifier
						val block = BuiltInRegistries.BLOCK.get(ResourceLocation.parse("$namespace:$subject"))
						output.accept(ItemStack(block))
					}
				}
				.build()
			val key = createKey(identifier.namespace, identifier.subject)
			Registry.register(registry, key, tab)
		}
	}

	@JvmStatic
	fun addPackSources(self: PackRepository) {
		logger.info("[EAM Loader] Adding additional pack sources")
		val validator = Minecraft.getInstance().directoryValidator()
		val resourceLocation = this::class.java.getResource("/assets")?.toURI()
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
			LoaderPackSource(path, validator)
//			FolderRepositorySource(path, PackType.CLIENT_RESOURCES, PackSource.DEFAULT, validator)
		)
		self.addSources(sources)
	}

	@JvmStatic
	fun registerAdditionalModels(self: ModelBakery) {
		logger.info("[EAM Loader] Registering additional models")
		val item = "breadmod:item/tool_gun/item"
		val coil = "breadmod:item/tool_gun/coil"
		val unbaked = self.getModel(item)
		val unbaked2 = self.getModel(coil)
		self.registerModelAndLoadDependencies(ModelResourceLocation(item), unbaked)
		self.registerModelAndLoadDependencies(ModelResourceLocation(coil), unbaked2)
	}

	@JvmStatic
	fun addLayers(self: Gui) {
		logger.info("[EAM Loader] Registering drawLayers")
		val layers = self.layers
		this.drawLayers.forEach { layers.add(it) }
	}

	@JvmStatic
	fun renderBEWLR(
		stack: ItemStack,
		displayContext: ItemDisplayContext,
		poseStack: PoseStack,
		bufferSource: MultiBufferSource,
		packedLight: Int,
		packedOverlay: Int
	) {
		TEST_RENDERER.renderByItem(stack, displayContext, poseStack, bufferSource, packedLight, packedOverlay)
	}

	@JvmStatic
	fun afterCreateContents() {
		mods.forEach {
			it.addBlocks(this.get(MinecraftFeatures.BLOCK))
			it.addItems(this.get(MinecraftFeatures.ITEM))
			it.addLayers(this.get(MinecraftFeatures.LAYER))
		}

		BMContent.TEST_ENTITY_TYPE = Registry.register(
			BuiltInRegistries.BLOCK_ENTITY_TYPE,
			"breadmod:test_entity",
			Builder.of(
				BlockEntitySupplier(::TestBlockEntity),
				BuiltInRegistries.BLOCK.get(ResourceLocation.parse("breadmod:bread_block"))
			).build()
		)
	}

	@JvmStatic
	fun test() {
		logger.info("test!")
	}

	@JvmStatic
	fun postClientInit() {
		// adding a 7th entry to the top creative tab texture arrays so it won't crash when trying to render the extra tab
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

		BlockEntityRenderers.register(
			BMContent.TEST_ENTITY_TYPE,
			BlockEntityRendererProvider(::TestBlockEntityRenderer)
		)
	}

	// todo shaders are currently hard-coded to the minecraft namespace, make patch reflecting neoforge's change later
	@JvmStatic
	fun registerShaders(resourceProvider: ResourceProvider, shaderList: MutableList<Any>) {
		println("loading shader instances")
		shaderList.add(
			makeShaderPair(
				ShaderInstance(
					resourceProvider,
					"position_tex_color_no_cutout",
					DefaultVertexFormat.POSITION_TEX_COLOR
				)
			) { BMContentClient.TEST_SHADER_INSTANCE = it }
		)
	}

	private fun makeShaderPair(shaderInstance: ShaderInstance, onLoaded: (ShaderInstance) -> Unit): Any =
		Pair(shaderInstance.around, Consumer<Any> { onLoaded(ShaderInstance(it)) }).around

	@JvmStatic
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
		guiGraphics.drawString(
			Minecraft.getInstance().font,
			"BSL ${bslVersion()} @ ${bslBuildDate()}",
			0,
			10,
			Color.ORANGE.rgb
		)
		poseStack.popPose()
	}
	@JvmStatic
	fun updateWindowTitle(self: Minecraft) {
		self.getWindow().setTitle("Minecraft - EAM 1.21.1")
	}
}