package org.bread_experts_group.eam.transform.v1x21x1

import org.bread_experts_group.eam.ClassTransform
import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.mimics.minecraft.v1x21x1.Minecraft
import org.bread_experts_group.eam.mimics.minecraft.v1x21x1.V1x21x1Hooks
import org.bread_experts_group.eam.toConstantDesc
import java.io.PrintStream
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

object MinecraftTransform : ClassTransform<Minecraft>(Minecraft::class) {
    override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
        val init = classBuilder.transformMethodCode(
            classElement,
            ConstantDescs.INIT_NAME
        ) { codeBuilder, codeElement, codeModel, index ->
            codeBuilder.beforeFinalReturn(index, codeModel) { builder ->
                builder
                    .getstatic(System::class.classDesc, "out", PrintStream::class.classDesc)
                    .ldc("WORDS".toConstantDesc())
                    .invokevirtual(
                        PrintStream::class.classDesc, "println", MethodTypeDesc.of(
                            ConstantDescs.CD_void, ConstantDescs.CD_String
                        )
                    )
            }
            if (!dropInstructions(index, 265 .. 270)) codeBuilder.with(codeElement)
        }

        val updateTitle = classBuilder.transformMethodCode(
            classElement,
            "updateTitle"
        ) { codeBuilder, codeElement, codeModel, index ->
            codeBuilder.beforeFinalReturn(index, codeModel) { builder ->
                builder
                    .aload(0)
                    .invokestatic(
                        V1x21x1Hooks::class.classDesc,
                        "minecraft_setTitleScreen",
                        MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_Object)
                    )
            }.with(codeElement)
        }

        if (!(init || updateTitle)) classBuilder.with(classElement)
    }
}