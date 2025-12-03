package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.getNativeLocalVariable
import org.bread_experts_group.eam.minecraft.mimic.MimicLookup
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeBuilder
import java.lang.classfile.instruction.LocalVariable
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method
import kotlin.reflect.full.isSubclassOf

val DEFAULT_VOID: MethodTypeDesc = MethodTypeDesc.of(ConstantDescs.CD_void)

fun CodeBuilder.invokeStaticWithLocalVars(
	lookup: MimicLookup,
	method: Method?,
	localVars: List<LocalVariable>,
	returnDesc: ClassDesc = ConstantDescs.CD_void
): CodeBuilder {
	if (method == null) throw NullPointerException("Method cannot be resolved as a java method")
	val params = method.parameters
	val declaring = method.declaringClass
	val className = if (declaring.kotlin.isCompanion) declaring.name.substringBefore('$') else declaring.name
	val usedSlots = mutableListOf<Int>()
	params.forEach { parameter ->
		val filtered = localVars.filter { it.slot() !in usedSlots }
		if (parameter.type.kotlin.isSubclassOf(MimickedClass::class)) {
			val localVariable = lookup.findNativeInLocalVars(parameter, filtered)
			this.invokeSpecialNewMimic(parameter.classDesc, localVariable.slot())
			usedSlots.add(localVariable.slot())
		} else if (parameter.type.isPrimitive) {
			when (val c = parameter.type) {
				Boolean::class.java -> {
					val variable = filtered.getNativeLocalVariable(c.name)
					iload(variable.slot())
					usedSlots.add(variable.slot())
				}
				Long::class.java -> {
					val variable = filtered.getNativeLocalVariable(c.name)
					lload(variable.slot())
					usedSlots.add(variable.slot())
				}
				Float::class.java -> {
					val variable = filtered.getNativeLocalVariable(c.name)
					fload(variable.slot())
					usedSlots.add(variable.slot())
				}
				Double::class.java -> {
					val variable = filtered.getNativeLocalVariable(c.name)
					dload(variable.slot())
					usedSlots.add(variable.slot())
				}
				Int::class.java -> {
					val variable = filtered.getNativeLocalVariable(c.name)
					iload(variable.slot())
					usedSlots.add(variable.slot())
				}
			}
		}
	}
	this.invokestatic(
		ClassDesc.of(className),
		method.name,
		MethodTypeDesc.of(
			returnDesc,
			params.map { if (it.type.isPrimitive) {
				when (it.type) {
					Int::class.java -> ConstantDescs.CD_int
					Long::class.java -> ConstantDescs.CD_long
					Float::class.java -> ConstantDescs.CD_float
					Double::class.java -> ConstantDescs.CD_double
					Boolean::class.java -> ConstantDescs.CD_boolean
					else -> ConstantDescs.CD_Object
				}
			} else it.classDesc }
		)
	)
	return this
}

fun CodeBuilder.getReferenceField(name: String, fieldType: ClassDesc): CodeBuilder =
	this.aload(0)
		.getfield(
			ClassDesc.of(name),
			"reference",
			fieldType
		)

fun ClassBuilder.withReferenceField(descriptor: ClassDesc): ClassBuilder =
	this.withField(
		"reference",
		descriptor,
		ClassFile.ACC_FINAL or ClassFile.ACC_PRIVATE
	)

fun CodeBuilder.putReferenceField(name: String, type: ClassDesc): CodeBuilder =
	this.putfield(
		ClassDesc.of(name),
		"reference",
		type
	)

fun CodeBuilder.invokeSpecialNewMimic(
	classDesc: ClassDesc,
	slot: Int
): CodeBuilder = this
	.new_(classDesc)
	.dup()
	.aload(slot)
	.invokespecial(
		classDesc,
		"<init>",
		MethodTypeDesc.of(
			ConstantDescs.CD_void,
			ConstantDescs.CD_Object
		)
	)

fun CodeBuilder.debugPrint(p: ClassDesc = ConstantDescs.CD_Object): CodeBuilder = this
	.dup()
	.invokevirtual(
		ClassDesc.of("java.lang.Object"),
		"getClass",
		MethodTypeDesc.of(ConstantDescs.CD_Class)
	)
	.getstatic(
		ClassDesc.of("java.lang.System"),
		"out",
		ClassDesc.of("java.io.PrintStream")
	)
	.swap()
	.invokevirtual(
		ClassDesc.of("java.io.PrintStream"),
		"println",
		MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_Object)
	)
	.dup()
	.getstatic(
		ClassDesc.of("java.lang.System"),
		"out",
		ClassDesc.of("java.io.PrintStream")
	)
	.swap()
	.invokevirtual(
		ClassDesc.of("java.io.PrintStream"),
		"println",
		MethodTypeDesc.of(ConstantDescs.CD_void, p)
	)