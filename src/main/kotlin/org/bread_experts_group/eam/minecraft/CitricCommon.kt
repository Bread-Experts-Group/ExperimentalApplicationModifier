package org.bread_experts_group.eam.minecraft

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.getAroundClassName
import org.bread_experts_group.eam.getNativeLocalVariable
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import java.lang.classfile.CodeBuilder
import java.lang.classfile.constantpool.MethodRefEntry
import java.lang.classfile.instruction.LocalVariable
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method
import kotlin.reflect.full.isSubclassOf

fun CodeBuilder.invokeStaticMethodWithLocalVars(method: Method?, localVars: List<LocalVariable>): CodeBuilder {
	if (method == null) throw NullPointerException("Method is somehow null??")
	val params = method.parameters
	val usedSlots = mutableListOf<Int>()
	params.forEach { parameter ->
		val filtered = localVars.filter { it.slot() !in usedSlots }
		if (parameter.type.kotlin.isSubclassOf(MimickedClass::class)) {
			val native = filtered.getNativeLocalVariable(parameter.type.getAroundClassName())
			this.invokeSpecialNewMimicClass(
				parameter.classDesc,
				native.slot()
			)
			usedSlots.add(native.slot())
		} else if (parameter.type.isPrimitive) {
			when (val c = parameter.type) {
				Boolean::class.java -> {
					val variable = filtered.getNativeLocalVariable(c.name)
					iload(variable.slot())
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
		ClassDesc.of(method.declaringClass.name),
		method.name,
		MethodTypeDesc.of(
			ConstantDescs.CD_void,
			params.map { if (it.type.isPrimitive) {
				when (it.type) {
					Int::class.java -> ConstantDescs.CD_int
					Float::class.java -> ConstantDescs.CD_float
					Double::class.java -> ConstantDescs.CD_Double
					Boolean::class.java -> ConstantDescs.CD_boolean
					else -> ConstantDescs.CD_Object
				}
			} else it.classDesc }
		)
	)
	return this
}

fun CodeBuilder.prepareMimicry(method: Method): MethodTypeDesc {
	var lVarPos = 0
	return MethodTypeDesc.of(
		ConstantDescs.CD_void,
		method.parameters.map {
			val slot = lVarPos++
			when (val c = it.type) {
				Int::class.java -> {
					this.iload(slot)
					ConstantDescs.CD_int
				}

				Boolean::class.java -> {
					this.iload(slot)
					ConstantDescs.CD_boolean
				}

				else if !c.isPrimitive -> {
					val desc = ClassDesc.of(c.name)
					if (c.kotlin.isSubclassOf(MimickedClass::class)) this
						.new_(desc)
						.dup()
						.aload(slot)
						.invokespecial(
							desc,
							"<init>",
							MethodTypeDesc.of(
								ConstantDescs.CD_void,
								ConstantDescs.CD_Object
							)
						)
					else this.aload(slot)
					desc
				}

				else -> throw IllegalArgumentException("No ClassDesc cnv for $c")
			}
		}
	)
}

fun CodeBuilder.getMethodMimicry(method: Method): MethodRefEntry = this.constantPool().methodRefEntry(
	ClassDesc.of(method.declaringClass.name),
	method.name,
	this.prepareMimicry(method)
)

//fun CodeBuilder.invokeVirtualMethodWithMimics(method: Method): CodeBuilder =
//	this.invokevirtual(this.getMethodMimicry(method))

@Deprecated("replace with invokeStaticMethodWithLocalVars")
fun CodeBuilder.invokeStaticMethodWithMimics(method: Method): CodeBuilder =
	this.invokestatic(this.getMethodMimicry(method))

fun CodeBuilder.getReferenceField(name: String, fieldType: ClassDesc): CodeBuilder =
	this.aload(0)
		.getfield(
			ClassDesc.of(name),
			"reference",
			fieldType
		)

fun CodeBuilder.invokeSpecialNewMimicClass(
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