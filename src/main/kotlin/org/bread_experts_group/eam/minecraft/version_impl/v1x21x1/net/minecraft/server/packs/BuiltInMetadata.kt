package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.NativeConstantsV1x21x1.net_minecraft_server_packs_BuiltInMetadata
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.server.packs.metadata.MetadataSectionSerializer
import java.lang.constant.ClassDesc

/*
net.minecraft.server.packs.BuiltInMetadata -> asi:
# {"fileName":"BuiltInMetadata.java","id":"sourceFile"}
    net.minecraft.server.packs.BuiltInMetadata EMPTY -> a
    java.util.Map values -> b
    12:14:void <init>(java.util.Map) -> <init>
    18:18:java.lang.Object get(net.minecraft.server.packs.metadata.MetadataSectionSerializer) -> a
    30:30:net.minecraft.server.packs.BuiltInMetadata of(net.minecraft.server.packs.metadata.MetadataSectionSerializer,java.lang.Object,net.minecraft.server.packs.metadata.MetadataSectionSerializer,java.lang.Object) -> a
    8:8:void <clinit>() -> <clinit>
 */
class BuiltInMetadata private constructor(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_server_packs_BuiltInMetadata)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = BuiltInMetadata::class.classDesc

		fun of(): BuiltInMetadata = BuiltInMetadata(clazz.getMethod("a").invoke(null))

		fun <T : MimickedClass> of(metadataSectionSerializer: MetadataSectionSerializer<T>, `object`: T): BuiltInMetadata =
			BuiltInMetadata(
				clazz.getMethod("a", MetadataSectionSerializer.clazz, Object::class.java)
					.invoke(null, metadataSectionSerializer.around, `object`.around)
			)
	}
}