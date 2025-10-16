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

// todo there is a minor edge case with getting the needed local var.
//  if there's multiple matching types it will always use the first matching result,
//  maybe implement some kind of mechanism to keep track of multiple matching vars and cycle to the next var if the first one is used
fun CodeBuilder.invokeStaticMethodWithLocalVars(method: Method?, localVars: List<LocalVariable>): CodeBuilder {
	if (method == null) throw NullPointerException("Method is somehow null??")
	val params = method.parameters
	params.forEach { parameter ->
		if (parameter.type.kotlin.isSubclassOf(MimickedClass::class)) {
			val native = localVars.getNativeLocalVariable(parameter.type.getAroundClassName())
			this.invokeSpecialNewMimicClass(
				parameter.classDesc,
				native.slot()
			)
		} else if (parameter.type.isPrimitive) {
			when (val c = parameter.type) {
				Boolean::class.java -> {
					val variable = localVars.getNativeLocalVariable(c.name)
					iload(variable.slot())
				}
				Float::class.java -> {
					val variable = localVars.getNativeLocalVariable(c.name)
					fload(variable.slot())
				}
				Int::class.java -> {
					val variable = localVars.getNativeLocalVariable(c.name)
					iload(variable.slot())
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