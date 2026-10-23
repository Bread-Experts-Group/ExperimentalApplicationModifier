package org.bread_experts_group.eam.minecraft.v1x21x1.transform

import org.bread_experts_group.eam.minecraft.v1x21x1.Minecraft
import org.bread_experts_group.eam.ClassTransform
import java.lang.classfile.ClassBuilder
import java.lang.classfile.ClassElement
import java.lang.constant.ConstantDescs

class MinecraftTransform : ClassTransform<Minecraft>(Minecraft::class) {
    override fun transform(): (ClassBuilder, ClassElement) -> Unit = { classBuilder, classElement ->
        val init = classBuilder.transformMethod(
            classElement,
            ConstantDescs.INIT_NAME,
            null
        ) { methodBuilder, methodElement ->
            println("found init?")
            methodBuilder.with(methodElement)
        }

        if (!init) classBuilder.with(classElement)
//        if (classElement is MethodModel) {
//            classMapping.getMethod(ConstantDescs.INIT_NAME)?.let { method ->
//                if (classElement.methodName().equalsString(method.obfuscated)) {
//                    println("found the fucking init")
//                    // todo bro this isn't working imma kill myse-
//                    classBuilder.transformMethodCode(classElement) { codeBuilder, codeElement, index, codeModel ->
//                        codeBuilder.beforeFinalReturn(codeModel, index) { builder ->
//                            builder
//                                .getstatic(System::class.classDesc, "out", PrintStream::class.classDesc)
//                                .ldc("WORDS".toConstantDesc())
//                                .invokevirtual(
//                                    PrintStream::class.classDesc, "println", MethodTypeDesc.of(
//                                        ConstantDescs.CD_void, ConstantDescs.CD_String
//                                    )
//                                )
//                        }
//                        if (!dropInstructions(index, 265 .. 270)) codeBuilder.with(codeElement)
//                    }
//                } else classBuilder.with(classElement)
//            }
//
//            classMapping.getMethod("updateTitle")?.let { method ->
//                if (classElement.methodName().equalsString(method.obfuscated)) {
//                    classBuilder.transformMethodCode(classElement) { codeBuilder, codeElement, index, codeModel ->
//                        println(method.unobfuscated)
//                        codeBuilder.beforeFinalReturn(codeModel, index) { builder ->
//                            builder
//                                .aload(0)
//                                .invokestatic(
//                                    V1x21x1Hooks::class.classDesc,
//                                    "minecraft_setTitleScreen",
//                                    MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_Object)
//                                )
//                        }
//                        codeBuilder.with(codeElement)
//                    }
//                }
//            }
//        } else classBuilder.with(classElement)
    }
}