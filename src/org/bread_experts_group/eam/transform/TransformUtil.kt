package org.bread_experts_group.eam.transform

import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeBuilder
import java.lang.classfile.CodeElement
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodBuilder
import java.lang.classfile.MethodElement
import java.lang.classfile.MethodModel
import java.lang.classfile.Opcode
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.MethodTypeDesc
import java.util.Optional

object TransformUtil {
    val classFile: ClassFile = ClassFile.of()

    fun dumpIndex(model: MethodElement) {
        if (model !is CodeModel) return
        model.forEachIndexed { index, element ->
            println("$index, $element")
        }
    }

    fun CodeBuilder.dropInstructions(index: Int, vararg instructions: IntRange): Boolean = instructions.any { index in it }

    fun CodeBuilder.atIndex(indexSource: Int, indexTarget: Int, builder: (CodeBuilder) -> Unit): CodeBuilder =
        this.also { if (indexSource == indexTarget) builder(this) }

    fun MethodBuilder.transformCodeIndexed(model: CodeModel, transform: (CodeBuilder, CodeElement, Int) -> Unit) {
        var index = 0
        this.transformCode(model) { c, e ->
            transform(c, e, index++)
        }
    }

    /**
     * Method currently only works with void return types.
     */
    fun MethodBuilder.beforeFinalReturn(model: CodeModel, builder: (CodeBuilder) -> Unit) {
        val returnIndex = model.indexOfLast { it is ReturnInstruction }
        this.transformCodeIndexed(model) { builder, element, index ->
            builder.atIndex(index, returnIndex) { b ->
                val opcode = (element as ReturnInstruction).opcode()
                if (opcode != Opcode.RETURN) throw IllegalStateException("Only void return types are currently supported.")
                builder(b)
            }.with(element)
        }
    }

    fun MethodBuilder.transformCode(
        methodElement: MethodElement,
        transform: (CodeBuilder, CodeElement, Int) -> Unit
    ) {
        if (methodElement is CodeModel) this.transformCodeIndexed(methodElement, transform)
        else this.with(methodElement)
    }

    fun ClassBuilder.getMethodCode(
        classElement: ClassElement,
        methodName: String,
        methodDescriptor: MethodTypeDesc?,
    ): Optional<CodeModel> = if (
        classElement is MethodModel &&
        classElement.methodName().equalsString(methodName) &&
        (classElement.methodTypeSymbol() == methodDescriptor || methodDescriptor == null)
    ) classElement.code() else Optional.empty()

    fun ClassBuilder.transformMethod(
        classElement: ClassElement,
        methodName: String,
        methodDescriptor: MethodTypeDesc?,
        transform: (MethodBuilder, MethodElement) -> Unit
    ): Boolean {
        if (
            classElement is MethodModel &&
            classElement.methodName().equalsString(methodName) &&
            (classElement.methodTypeSymbol() == methodDescriptor || methodDescriptor == null)
        ) {
            this.transformMethod(classElement, transform)
            return true
        }
        return false
    }

    fun ClassBuilder.transformMethodCode(
        classElement: ClassElement,
        methodName: String,
        methodDescriptor: MethodTypeDesc?,
        transform: (CodeBuilder, CodeElement, Int) -> Unit
    ): Boolean = this.transformMethod(classElement, methodName, methodDescriptor) { mB, mE ->
        mB.transformCode(mE, transform)
    }
}