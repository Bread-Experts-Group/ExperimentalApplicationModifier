package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.class_transforms

import org.bread_experts_group.eam.minecraft.ClassTransform
import org.bread_experts_group.eam.minecraft.feature.Scanning
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.sounds.SoundEvent
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.client.sounds.SoundSource
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_client_multiplayer_ClientLevel
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class ClientLevelTransform(
	scanning: Scanning,
	classFile: ClassFile
) : ClassTransform(net_minecraft_client_multiplayer_ClientLevel, "ClientLevel", scanning, classFile) {
	override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
		val f = modifyMethodAccess(
			"a",
			MethodTypeDesc.of(
				ConstantDescs.CD_void,
				ConstantDescs.CD_double,
				ConstantDescs.CD_double,
				ConstantDescs.CD_double,
				SoundEvent.classDesc,
				SoundSource.classDesc,
				ConstantDescs.CD_float,
				ConstantDescs.CD_float,
				ConstantDescs.CD_boolean,
				ConstantDescs.CD_long
			),
			ACC_PUBLIC
		)

		if (!f.invoke(classBuilder, classElement)) classBuilder.with(classElement)
	}
}