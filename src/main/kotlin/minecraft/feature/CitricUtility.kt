package org.bread_experts_group.eam.minecraft.feature

import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.ACC_STATIC
import java.lang.classfile.ClassModel
import java.lang.classfile.FieldModel
import java.lang.classfile.TypeKind
import java.lang.constant.MethodTypeDesc

fun ClassBuilder.nameObfuscatedField(
	transformingField: ClassElement,
	model: ClassModel,
	obfuscatedName: String,
	realName: String
) {
	if (transformingField !is FieldModel) return
	if (!transformingField.fieldName().equalsString(obfuscatedName)) return
	val fts = transformingField.fieldTypeSymbol()
	withMethodBody(
		realName,
		MethodTypeDesc.of(fts),
		ACC_STATIC or ACC_PUBLIC
	) { codeBuilder ->
		codeBuilder.getstatic(
			model.thisClass().asSymbol(),
			obfuscatedName,
			fts
		)
		codeBuilder.return_(TypeKind.from(fts))
	}
}