package org.bread_experts_group.eam.minecraft.feature

import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassModel
import java.lang.classfile.FieldModel
import java.lang.classfile.TypeKind
import java.lang.constant.MethodTypeDesc

fun ClassBuilder.nameObfuscatedField(
	transformingField: ClassElement,
	model: ClassModel,
	obfuscatedName: String,
	realName: String,
	methodFlags: Int = 0
) {
	if (transformingField !is FieldModel) return
	if (!transformingField.fieldName().equalsString(obfuscatedName)) return
	val fts = transformingField.fieldTypeSymbol()
	withMethodBody(
		realName,
		MethodTypeDesc.of(fts),
		methodFlags
	) { codeBuilder ->
		codeBuilder.getstatic(
			model.thisClass().asSymbol(),
			obfuscatedName,
			fts
		)
		codeBuilder.return_(TypeKind.from(fts))
	}
}