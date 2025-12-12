package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.texture

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.invokeSpecialNewMimic
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.putReferenceField
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.resources.ResourceManager
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_renderer_texture_AbstractTexture
import org.bread_experts_group.eam.minecraft.withReferenceField
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

/*
net.minecraft.client.renderer.texture.AbstractTexture -> gpw:
# {"fileName":"AbstractTexture.java","id":"sourceFile"}
    int NOT_ASSIGNED -> a
    int id -> b
    boolean blur -> c
    boolean mipmap -> d
    13:15:void <init>() -> <init>
    20:36:void setFilter(boolean,boolean) -> a
    39:44:int getId() -> a
    48:61:void releaseId() -> b
    void load(net.minecraft.server.packs.resources.ResourceManager) -> a
    66:73:void bind() -> c
    76:77:void reset(net.minecraft.client.renderer.texture.TextureManager,net.minecraft.server.packs.resources.ResourceManager,net.minecraft.resources.ResourceLocation,java.util.concurrent.Executor) -> a
    81:81:void close() -> close
    68:69:void lambda$bind$1() -> d
    50:54:void lambda$releaseId$0() -> e
 */
abstract class AbstractTexture : MimickedClass(0) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_texture_AbstractTexture)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = AbstractTexture::class.classDesc
		}

		init {
			this.around = createNative(AbstractTexture::class.java) { classBuilder, name ->
				classBuilder.withSuperclass(classDesc)
				if (this.hasSuperclass(Tickable::class)) {
					classBuilder.withInterfaceSymbols(Tickable.classDesc)
					classBuilder.withMethodBody(
						Tickable.tick,
						DEFAULT_VOID,
						ACC_PUBLIC
					) { codeBuilder ->
						codeBuilder
							.getReferenceField(name, mimicClassDesc)
							.invokeinterface(
								Tickable.mimicClassDesc,
								"tick",
								DEFAULT_VOID
							)
							.return_()
					}
				}
				classBuilder.withMethodBody(
					"a", // load
					MethodTypeDesc.of(
						ConstantDescs.CD_void,
						ResourceManager.classDesc
					),
					ACC_PUBLIC
				) { codeBuilder ->
					codeBuilder
						.getReferenceField(name, mimicClassDesc)
						.invokeSpecialNewMimic(ResourceManager.mimicClassDesc, 1)
						.invokevirtual(
							mimicClassDesc,
							"load",
							MethodTypeDesc.of(
								ConstantDescs.CD_void,
								ResourceManager.mimicClassDesc
							)
						)
						.return_()
				}
				if (this.overrides("close")) {
					classBuilder.withMethodBody(
						"close",
						DEFAULT_VOID,
						ACC_PUBLIC
					) { codeBuilder ->
						codeBuilder
							.getReferenceField(name, mimicClassDesc)
							.invokevirtual(
								mimicClassDesc,
								"close",
								DEFAULT_VOID
							)
							.return_()
					}
				}
				if (this.overrides("releaseId")) {
					classBuilder.withMethodBody(
						"b",
						DEFAULT_VOID,
						ACC_PUBLIC
					) { codeBuilder ->
						codeBuilder
							.getReferenceField(name, mimicClassDesc)
							.invokevirtual(
								mimicClassDesc,
								"releaseId",
								DEFAULT_VOID
							)
							.return_()
					}
				}
				if (this.overrides("bind")) {
					throw NotImplementedError("bind override not implemented yet.")
				}
				if (this.overrides("getId")) {
					classBuilder.withMethodBody(
						"a",
						MethodTypeDesc.of(ConstantDescs.CD_int),
						ACC_PUBLIC
					) { codeBuilder ->
						codeBuilder
							.getReferenceField(name, mimicClassDesc)
							.invokevirtual(
								mimicClassDesc,
								"getId",
								MethodTypeDesc.of(ConstantDescs.CD_int)
							)
							.ireturn()
					}
				}
				classBuilder.withMethodBody(
					ConstantDescs.INIT_NAME,
					MethodTypeDesc.of(ConstantDescs.CD_void, mimicClassDesc),
					ACC_PUBLIC
				) { codeBuilder ->
					codeBuilder
						.aload(0)
						.invokespecial(
							classDesc,
							ConstantDescs.INIT_NAME,
							DEFAULT_VOID
						)
						.aload(0)
						.aload(1)
						.putReferenceField(name, mimicClassDesc)
						.return_()
				}
				classBuilder.withReferenceField(mimicClassDesc)
			}.newInstance(this)
		}

	// Can't annotate with JvmField to remove the getter/setter population because there's no backing field
	protected var textureId: Int
		get() = clazz.getField("b").getInt(around)
		set(value) = clazz.getField("b").setInt(around, value)

	open fun getId(): Int = clazz.getMethod("a").invoke(around) as Int

	open fun releaseId() {
		clazz.getMethod("b").invoke(around)
	}

	open fun bind() {
		clazz.getMethod("c").invoke(around)
	}

	open fun close() {}

	abstract fun load(resourceManager: ResourceManager)
}