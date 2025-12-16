package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.repository

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.putReferenceField
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_repository_BuiltInPackSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.network.chat.Component
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.resources.ResourceLocation
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.PackType
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.VanillaPackResources
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.validation.DirectoryValidator
import org.bread_experts_group.eam.minecraft.withReferenceField
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.Opcode
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

/*
net.minecraft.server.packs.repository.BuiltInPackSource -> atj:
# {"fileName":"BuiltInPackSource.java","id":"sourceFile"}
    org.slf4j.Logger LOGGER -> c
    java.lang.String VANILLA_ID -> a
    net.minecraft.server.packs.repository.KnownPack CORE_PACK_INFO -> b
    net.minecraft.server.packs.PackType packType -> d
    net.minecraft.server.packs.VanillaPackResources vanillaPack -> e
    net.minecraft.resources.ResourceLocation packDir -> f
    net.minecraft.world.level.validation.DirectoryValidator validator -> g
    36:41:void <init>(net.minecraft.server.packs.PackType,net.minecraft.server.packs.VanillaPackResources,net.minecraft.resources.ResourceLocation,net.minecraft.world.level.validation.DirectoryValidator) -> <init>
    45:50:void loadPacks(java.util.function.Consumer) -> loadPacks
    net.minecraft.server.packs.repository.Pack createVanillaPack(net.minecraft.server.packs.PackResources) -> a
    net.minecraft.network.chat.Component getPackTitle(java.lang.String) -> a
    58:58:net.minecraft.server.packs.VanillaPackResources getVanillaPack() -> a
    62:72:void listBundledPacks(java.util.function.Consumer) -> a
    75:76:void populatePackList(java.util.function.BiConsumer) -> a
    79:88:void discoverPacksInPath(java.nio.file.Path,java.util.function.BiConsumer) -> a
    91:91:java.lang.String pathToId(java.nio.file.Path) -> a
    82:82:void lambda$discoverPacksInPath$3(java.util.function.BiConsumer,java.nio.file.Path,net.minecraft.server.packs.repository.Pack$ResourcesSupplier) -> a
    82:82:net.minecraft.server.packs.repository.Pack lambda$discoverPacksInPath$2(net.minecraft.server.packs.repository.Pack$ResourcesSupplier,java.lang.String) -> a
    75:75:void lambda$populatePackList$1(java.util.function.BiConsumer,java.nio.file.Path) -> a
    67:71:void lambda$listBundledPacks$0(java.util.function.Consumer,java.lang.String,java.util.function.Function) -> a
    25:29:void <clinit>() -> <clinit>
 */
@Suppress("unused")
abstract class BuiltInPackSource(
	packType: PackType,
	vanillaPackSource: VanillaPackResources,
	packDir: ResourceLocation,
	validator: DirectoryValidator
) : RepositorySource(0) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_repository_BuiltInPackSource)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BuiltInPackSource::class.classDesc

		fun fixedResources(packResources: PackResources): Pack.ResourcesSupplier = Pack.ResourcesSupplier(
			clazz.getMethod("b", PackResources.clazz)
				.invoke(null, packResources.around)
		)
	}

	init {
		this.around = createNative(BuiltInPackSource::class.java) { classBuilder, name ->
			classBuilder.withSuperclass(classDesc)
			classBuilder.withMethodBody(
				ConstantDescs.INIT_NAME,
				MethodTypeDesc.of(
					ConstantDescs.CD_void,
					mimicClassDesc,
					PackType.classDesc,
					VanillaPackResources.classDesc,
					ResourceLocation.classDesc,
					DirectoryValidator.classDesc
				),
				ACC_PUBLIC
			) { codeBuilder ->
				codeBuilder
					.aload(0)
					.aload(2)
					.aload(3)
					.aload(4)
					.aload(5)
					.invokespecial(
						classDesc,
						ConstantDescs.INIT_NAME,
						MethodTypeDesc.of(
							ConstantDescs.CD_void,
							PackType.classDesc,
							VanillaPackResources.classDesc,
							ResourceLocation.classDesc,
							DirectoryValidator.classDesc
						)
					)
					.aload(0)
					.aload(1)
					.putReferenceField(name, mimicClassDesc)
					.return_()
			}
			classBuilder.withReferenceField(mimicClassDesc)
			classBuilder.withMethodBody(
				"a",
				MethodTypeDesc.of(Pack.classDesc, PackResources.classDesc),
				ACC_PUBLIC
			) { codeBuilder ->
				codeBuilder
					.localVariable(4, "invoke", Pack.mimicClassDesc, codeBuilder.startLabel(), codeBuilder.endLabel())
					.getReferenceField(name, mimicClassDesc)
					.invokeSpecialNewMimic(PackResources.mimicClassDesc, 1)
					.invokevirtual(
						mimicClassDesc,
						"createVanillaPack",
						MethodTypeDesc.of(Pack.mimicClassDesc, PackResources.mimicClassDesc)
					)
					.astore(4)
					.aload(4)
					.ifThen(Opcode.IFNONNULL) { builder ->
						builder
							.aload(4)
							.getfield(
								MimickedClass.classDesc,
								"around",
								ConstantDescs.CD_Object
							)
							.checkcast(Pack.classDesc)
							.areturn()
					}
					.aconst_null()
					.areturn()
			}
			classBuilder.withMethodBody(
				"a",
				MethodTypeDesc.of(
					Pack.classDesc,
					ConstantDescs.CD_String,
					Pack.ResourcesSupplier.classDesc,
					Component.classDesc
				),
				ACC_PUBLIC
			) { codeBuilder ->
				codeBuilder
					.localVariable(4, "invoke", Pack.mimicClassDesc, codeBuilder.startLabel(), codeBuilder.endLabel())
					.getReferenceField(name, mimicClassDesc)
					.aload(1)
					.invokeSpecialNewMimic(Pack.ResourcesSupplier.mimicClassDesc, 2)
					.invokeSpecialNewMimic(Component.mimicClassDesc, 3)
					.invokevirtual(
						mimicClassDesc,
						"createBuiltinPack",
						MethodTypeDesc.of(
							Pack.mimicClassDesc,
							ConstantDescs.CD_String,
							Pack.ResourcesSupplier.mimicClassDesc,
							Component.mimicClassDesc
						)
					)
					.astore(4)
					.aload(4)
					.ifThen(Opcode.IFNONNULL) { builder ->
						builder
							.aload(4)
							.getfield(
								MimickedClass.classDesc,
								"around",
								ConstantDescs.CD_Object
							)
							.checkcast(Pack.classDesc)
							.areturn()
					}
					.aconst_null()
					.areturn()
			}
		}.newInstance(this, packType.around, vanillaPackSource.around, packDir.around, validator.around)
	}

	abstract fun createVanillaPack(resources: PackResources): Pack?

	abstract fun getPackTitle(id: String): Component

	abstract fun createBuiltinPack(id: String, resources: Pack.ResourcesSupplier, name: Component): Pack?
}