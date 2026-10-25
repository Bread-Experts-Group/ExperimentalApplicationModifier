package org.bread_experts_group.eam.transform.v1x21x1

import org.bread_experts_group.eam.ClassTransform
import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.mimics.minecraft.v1x21x1.GuiGraphics
import org.bread_experts_group.eam.mimics.minecraft.v1x21x1.TitleScreen
import org.bread_experts_group.eam.mimics.minecraft.v1x21x1.V1x21x1Hooks
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

object TitleScreenTransform: ClassTransform<TitleScreen>(TitleScreen::class) {
    override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
        val render = classBuilder.transformMethodCode(
            classElement,
            "render",
            MethodTypeDesc.of(
                ConstantDescs.CD_void,
                GuiGraphics::class.classDesc,
                ConstantDescs.CD_int,
                ConstantDescs.CD_int,
                ConstantDescs.CD_float
            )
        )  { codeBuilder, codeElement, codeModel, index ->
            codeBuilder.beforeFinalReturn(index, codeModel) { builder ->
                builder
                    .instantiateMimic(GuiGraphics::class, 1)
                    // todo superclass mappings, somehow
                    .getField("m", ConstantDescs.CD_int)
                    .getField("n", ConstantDescs.CD_int)
                    .iload(2)
                    .iload(3)
                    .invokestatic(
                        V1x21x1Hooks::class.classDesc,
                        "titleScreen_renderText",
                        MethodTypeDesc.of(
                            ConstantDescs.CD_void,
                            GuiGraphics::class.classDesc,
                            ConstantDescs.CD_int,
                            ConstantDescs.CD_int,
                            ConstantDescs.CD_int,
                            ConstantDescs.CD_int
                        )
                    )
            }.with(codeElement)
        }

        if (!render) classBuilder.with(classElement)
    }
}