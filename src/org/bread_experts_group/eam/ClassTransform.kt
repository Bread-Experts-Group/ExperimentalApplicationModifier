package org.bread_experts_group.eam

import org.bread_experts_group.eam.mimics.minecraft.v1x21x1.MimickedClass
import org.bread_experts_group.eamlaunch.api.Mapping
import java.lang.classfile.*
import java.lang.classfile.instruction.ReturnInstruction
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.reflect.AccessFlag
import kotlin.reflect.KClass

abstract class ClassTransform<T: MimickedClass>(val target: KClass<T>) {
    val classMapping: Mapping.Class = Mapping.of(target)

    abstract fun transform(): (ClassBuilder, ClassElement) -> Unit

    fun dumpIndex(index: Int, element: CodeElement) {
       println("$index, $element")
    }

    fun dropInstructions(index: Int, vararg instructions: IntRange): Boolean = instructions.any { index in it }

    /// Class Functions ///

    fun ClassBuilder.transformMethod(
        classElement: ClassElement,
        methodName: String,
        typeDesc: MethodTypeDesc? = null,
        transform: (MethodBuilder, MethodElement) -> Unit
    ): Boolean {
        val method = classMapping.getMethod(
            methodName,
            *typeDesc?.parameterList()?.toTypedArray() ?: arrayOf()
        ) ?: return false
        if (
            classElement is MethodModel &&
            classElement.methodName().equalsString(method.obfuscated) &&
            classElement.methodTypeSymbol() == method.obfTypeDesc
        ) {
            this.transformMethod(classElement, transform)
            return true
        }
        return false
    }

    fun ClassBuilder.transformMethodCode(
        classElement: ClassElement,
        methodName: String,
        typeDesc: MethodTypeDesc? = null,
        transform: (CodeBuilder, CodeElement, CodeModel, Int) -> Unit
    ): Boolean = this.transformMethod(classElement, methodName, typeDesc) { mB, mE ->
        if (mE is CodeModel) mB.transformCodeIndexed(mE, transform)
        else mB.with(mE)
    }

    /// Method Functions ///

    fun MethodBuilder.transformCodeIndexed(model: CodeModel, transform: (CodeBuilder, CodeElement, CodeModel, Int) -> Unit) {
        var index = 0
        this.transformCode(model) { c, e ->
            transform(c, e, model, index++)
        }
    }

    /// Field Functions ///

    fun ClassBuilder.modifyFieldFlags(classElement: ClassElement, fieldName: String, vararg flags: AccessFlag): Boolean {
        val field = classMapping.getField(fieldName) ?: return false
        if (classElement is FieldModel && classElement.fieldName().equalsString(field.obfuscated)) {
            this.transformField(classElement) { fieldBuilder, fieldElement ->
                if (fieldElement is AccessFlags) {
                    fieldBuilder.withFlags(*flags)
                } else fieldBuilder.with(fieldElement)
            }
            return true
        }
        return false
    }

    /// Code Functions ///

    fun CodeBuilder.atIndex(source: Int, target: Int, builder: (CodeBuilder) -> Unit): CodeBuilder =
        this.also { if (source == target) builder(this) }

    // todo support all return types
    fun CodeBuilder.beforeFinalReturn(index: Int, codeModel: CodeModel, builder: (CodeBuilder) -> Unit): CodeBuilder =
        this.also {
            val returnIndex = codeModel.indexOfLast { it is ReturnInstruction }
            this.atIndex(index, returnIndex) { b ->
                val opcode = (codeModel[returnIndex] as ReturnInstruction).opcode()
                if (opcode != Opcode.RETURN) throw IllegalStateException("Only void return types are currently supported.")
                builder(b)
            }
        }

    fun <T: MimickedClass> CodeBuilder.instantiateMimic(mClass: KClass<T>, slot: Int): CodeBuilder = this
        .new_(mClass.classDesc)
        .dup()
        .aload(slot)
        .invokespecial(
            mClass.classDesc,
            ConstantDescs.INIT_NAME,
            MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_Object)
        )

    // todo getting fields from superclasses
    fun CodeBuilder.getField(fieldName: String, desc: ClassDesc): CodeBuilder {
        return this
            .aload(0)
            .getfield(classMapping.obfuscated, fieldName, desc)
    }
}