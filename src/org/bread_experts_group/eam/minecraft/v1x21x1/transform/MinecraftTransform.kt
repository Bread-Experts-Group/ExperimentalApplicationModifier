package org.bread_experts_group.eam.minecraft.v1x21x1.transform

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.minecraft.v1x21x1.Minecraft
import org.bread_experts_group.eam.toConstantDesc
import org.bread_experts_group.eam.transform.ClassTransform
import org.bread_experts_group.eam.transform.TransformUtil
import org.bread_experts_group.eam.transform.TransformUtil.beforeFinalReturn
import org.bread_experts_group.eam.transform.TransformUtil.dropInstructions
import org.bread_experts_group.eam.transform.TransformUtil.transformCodeIndexed
import org.bread_experts_group.eam.transform.TransformUtil.transformMethod
import java.io.PrintStream
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.classfile.CodeModel
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

class MinecraftTransform : ClassTransform<Minecraft>(Minecraft::class) {
    override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
        val init = classBuilder.transformMethod(classElement, "<init>", null) { methodBuilder, methodElement ->
            TransformUtil.dumpIndex(methodElement)
            if (methodElement is CodeModel) {
                methodBuilder.beforeFinalReturn(methodElement) { codeBuilder ->
                    codeBuilder
                        .getstatic(System::class.classDesc, "out", PrintStream::class.classDesc)
                        .ldc("WORDS".toConstantDesc())
                        .invokevirtual(
                            PrintStream::class.classDesc, "println", MethodTypeDesc.of(
                                ConstantDescs.CD_void, ConstantDescs.CD_String
                            )
                        )
                }
                methodBuilder.transformCodeIndexed(methodElement) { codeBuilder, codeElement, index ->
                    // drop the setting user debug print (testing)
                    if (!codeBuilder.dropInstructions(index, 265 .. 270)) codeBuilder.with(codeElement)
                }
            } else methodBuilder.with(methodElement)
        }
        if (!init) classBuilder.with(classElement)
    }
}