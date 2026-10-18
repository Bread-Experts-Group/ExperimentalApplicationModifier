package org.bread_experts_group.eam.transform

import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeBuilder
import java.lang.classfile.CodeElement
import java.lang.classfile.CodeModel
import java.lang.classfile.MethodBuilder
import java.lang.classfile.MethodElement
import java.lang.classfile.Opcode
import java.lang.classfile.TypeKind
import java.lang.classfile.instruction.ReturnInstruction

object TransformUtil {
    val classFile: ClassFile = ClassFile.of()

    fun CodeBuilder.atIndex(indexSource: Int, indexTarget: Int, builder: (CodeBuilder) -> Unit): CodeBuilder =
        this.also { if (indexSource == indexTarget) builder(this) }

    fun MethodBuilder.transformCodeIndexed(model: CodeModel, transform: (CodeBuilder, CodeElement, Int) -> Unit) {
        var index = 0
        this.transformCode(model) { c, e ->
            transform(c, e, index++)
        }
    }

    fun dumpIndex(model: MethodElement) {
        if (model !is CodeModel) return
        model.forEachIndexed { index, element ->
            println("$index, $element")
        }
    }

    /**
     * Method currently only works with void return types.
     */
    fun MethodBuilder.beforeFinalReturn(model: CodeModel, builder: (CodeBuilder) -> Unit) {
        val returnIndex = model.indexOfLast { it is ReturnInstruction }
        this.transformCodeIndexed(model) { builder, element, index ->
            builder.atIndex(index, returnIndex) { b ->
                val opcode = (element as? ReturnInstruction)?.opcode()
                if (opcode != Opcode.RETURN) throw IllegalStateException("Only void return types are currently supported.")
                builder(b)
            }.with(element)
        }
    }
}