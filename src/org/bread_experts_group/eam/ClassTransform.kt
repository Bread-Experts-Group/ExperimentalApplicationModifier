package org.bread_experts_group.eam

import org.bread_experts_group.eam.minecraft.v1x21x1.MimickedClass
import org.bread_experts_group.eamlaunch.api.Mapping
import java.lang.classfile.*
import java.lang.constant.MethodTypeDesc
import kotlin.reflect.KClass

abstract class ClassTransform<T: MimickedClass>(val target: KClass<T>) {
    val classMapping: Mapping.Class = Mapping.of(target)

    abstract fun transform(): (ClassBuilder, ClassElement) -> Unit

    fun dumpIndex(model: MethodElement) {
        if (model !is CodeModel) return
        model.forEachIndexed { index, element ->
            println("$index, $element")
        }
    }

    fun CodeBuilder.atIndex(source: Int, target: Int, builder: (CodeBuilder) -> Unit): CodeBuilder =
        this.also { if (source == target) builder(this) }

    fun ClassBuilder.transformMethod(
        classElement: ClassElement,
        methodName: String,
        typeDesc: MethodTypeDesc?,
        transform: (MethodBuilder, MethodElement) -> Unit
    ): Boolean {
        val method = classMapping.getMethod(
            methodName,
            *typeDesc?.parameterList()?.toTypedArray() ?: arrayOf()
        ) ?: return false
        if (
            classElement is MethodModel &&
            classElement.methodName().equalsString(method.obfuscated) /*&&
            classElement.methodTypeSymbol() == method.obfTypeDesc()*/
        ) {
            this.transformMethod(classElement, transform)
            return true
        }
        return false
    }

    /*
    fun dropInstructions(index: Int, vararg instructions: IntRange): Boolean = instructions.any { index in it }

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
     */
}