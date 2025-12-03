package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.renderer.texture

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.getReferenceField
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
abstract class AbstractTexture(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_client_renderer_texture_AbstractTexture)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = AbstractTexture::class.classDesc

		fun <T : AbstractTexture> implementNative(input: T): T {
			input.around = input.implementNative(AbstractTexture::class.java) { classBuilder, name ->
				classBuilder.withSuperclass(classDesc)
				if (input.hasSuperclass(Tickable::class)) {
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
				if (input.overrides("close")) {
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
				if (input.overrides("releaseId")) {
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
				if (input.overrides("bind")) {
					throw NotImplementedError("bind override not implemented yet.")
				}
				if (input.overrides("getId")) {
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
					"<init>",
					MethodTypeDesc.of(ConstantDescs.CD_void, mimicClassDesc),
					ACC_PUBLIC
				) { codeBuilder ->
					codeBuilder
						.aload(0)
						.invokespecial(
							classDesc,
							"<init>",
							DEFAULT_VOID
						)
						.aload(0)
						.aload(1)
						.putReferenceField(name, mimicClassDesc)
						.return_()
				}
				classBuilder.withReferenceField(mimicClassDesc)
			}.newInstance(input)
			return input
		}
	}

	protected var id: Int
		get() = clazz.getField("b").get(around) as Int
		set(value) {
			clazz.getField("b").set(around, value)
		}

	// todo declaration clash...
//	open fun getId(): Int = clazz.getMethod("a").invoke(around) as Int

	open fun releaseId() {
		clazz.getMethod("b").invoke(around)
	}

	open fun bind() {
		clazz.getMethod("c").invoke(around)
	}

	open fun close() {}

	abstract fun load(resourceManager: ResourceManager)
}