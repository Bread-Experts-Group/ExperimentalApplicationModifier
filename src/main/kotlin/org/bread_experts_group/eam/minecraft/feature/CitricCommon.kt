package org.bread_experts_group.eam.minecraft.feature

import java.lang.classfile.CodeBuilder
import java.lang.classfile.constantpool.MethodRefEntry
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.Method
import kotlin.reflect.full.isSubclassOf

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

fun CodeBuilder.invokeVirtualMethodWithMimics(method: Method): CodeBuilder =
	this.invokevirtual(this.getMethodMimicry(method))

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
	slot: Int,
	isInterface: Boolean = false
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
		),
		isInterface
	)