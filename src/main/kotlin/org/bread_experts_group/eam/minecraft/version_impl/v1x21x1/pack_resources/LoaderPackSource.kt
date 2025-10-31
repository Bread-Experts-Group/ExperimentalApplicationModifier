package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.pack_resources

import org.bread_experts_group.eam.DefiningClassLoader
import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.CodeTransformer
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.VanillaPackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.BuiltInPackSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository.Pack
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.validation.DirectoryValidator
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.StackMapsOption
import java.lang.classfile.ClassFile.of
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

// TODO WORK IN PROGRESS...
class LoaderPackSource(
	@JvmField val packType: PackType,
	@JvmField val vanillaPackResources: VanillaPackResources,
	@JvmField val resourceLocation: ResourceLocation,
	@JvmField val directoryValidator: DirectoryValidator
) : CodeTransformer {
	companion object {
		val mimicClassDesc: ClassDesc = LoaderPackSource::class.classDesc

		fun createBuiltIn(loaderPackSource: LoaderPackSource): BuiltInPackSource =
			BuiltInPackSource(
				loaderPackSource.cl.define(
					loaderPackSource.name,
					loaderPackSource.cf.build(
						ClassDesc.of(loaderPackSource.name)
					) { classBuilder ->
						loaderPackSource.implementNative().invoke(classBuilder)
					}
				)
			)
	}

	private val name = "EAMGenerated_LoaderPackSource"
	private val cf: ClassFile = of(StackMapsOption.GENERATE_STACK_MAPS)
	private val cl: DefiningClassLoader = DefiningClassLoader()

	private fun implementNative(): (ClassBuilder) -> Any = { classBuilder ->
		classBuilder.withSuperclass(BuiltInPackSource.classDesc)
		classBuilder.withMethodBody(
			"<init>",
			MethodTypeDesc.of(ConstantDescs.CD_void, mimicClassDesc),
			ClassFile.ACC_PUBLIC
		) { codeBuilder ->
			codeBuilder
				.aload(1)
				.getfield(
					PackType.mimicClassDesc,
					"around",
					ConstantDescs.CD_Object
				)
				.checkcast(PackType.classDesc)
				.aload(2)
				.getfield(
					VanillaPackResources.mimicClassDesc,
					"around",
					ConstantDescs.CD_Object
				)
				.checkcast(VanillaPackResources.classDesc)
				.aload(3)
				.getfield(
					ResourceLocation.mimicClassDesc,
					"around",
					ConstantDescs.CD_Object
				)
				.checkcast(ResourceLocation.classDesc)
				.aload(4)
				.getfield(
					DirectoryValidator.mimicClassDesc,
					"around",
					ConstantDescs.CD_Object
				)
				.checkcast(DirectoryValidator.classDesc)
				.invokespecial(
					BuiltInPackSource.classDesc,
					"<init>",
					MethodTypeDesc.of(
						ConstantDescs.CD_void,
						PackType.classDesc,
						VanillaPackResources.classDesc,
						ResourceLocation.classDesc,
						DirectoryValidator.classDesc
					)
				)
				.aload(0)
				.putfield(
					ClassDesc.of(name),
					"reference",
					mimicClassDesc
				)
				.return_()
		}
		classBuilder.withField(
			"reference",
			mimicClassDesc,
			ClassFile.ACC_FINAL or ClassFile.ACC_PRIVATE
		)
	}

	fun createVanillaPack(resources: PackResources): Pack {
		TODO()
	}

	fun getPackTitle(id: String): Component = Component.literal("test")

	fun createBuiltinPack(id: String, resources: Pack.ResourcesSupplier, title: Component): Pack {
		TODO()
	}
}