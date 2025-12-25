package org.bread_experts_group.eam.minecraft.transform

import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.CodeBuilder
import java.lang.classfile.CodeElement
import java.lang.constant.ClassDesc
import java.lang.constant.MethodTypeDesc

abstract class MethodTransform(
	private val classBuilder: ClassBuilder,
	private val classElement: ClassElement,
	private val targetMethod: String,
	val owningClass: ClassDesc,
	private val targetDesc: MethodTypeDesc? = null
) : CodeTransformer {
	final override val existingElements: MutableList<String> = mutableListOf()

	abstract fun transform(): (CodeBuilder, CodeElement, Int) -> Unit

	fun run(): Boolean = this.classBuilder.transformMethodCode(
		classElement,
		targetMethod,
		targetDesc
	) { c, e, i ->
		if (shouldPrintOpcodeStack()) println("$i, $e")
		transform().invoke(c, e, i)
	}

	open fun shouldPrintOpcodeStack(): Boolean = false
}