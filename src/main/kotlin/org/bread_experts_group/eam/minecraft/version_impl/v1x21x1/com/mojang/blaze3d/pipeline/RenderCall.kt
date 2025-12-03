package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.blaze3d.pipeline

import org.bread_experts_group.eam.DefiningClassLoader
import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.DEFAULT_VOID
import org.bread_experts_group.eam.minecraft.getReferenceField
import org.bread_experts_group.eam.minecraft.putReferenceField
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com_mojang_blaze3d_pipeline_RenderCall
import org.bread_experts_group.eam.minecraft.withReferenceField
import java.lang.classfile.ClassFile.ACC_PUBLIC
import java.lang.classfile.ClassFile.StackMapsOption
import java.lang.classfile.ClassFile.of
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc

fun interface RenderCall {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_blaze3d_pipeline_RenderCall)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = RenderCall::class.classDesc

		fun native(renderCall: RenderCall): Any {
			val cf = of(StackMapsOption.GENERATE_STACK_MAPS)
			val cl = DefiningClassLoader()
			val name = "EAM_NativeMimic_${RenderCall::class.java.simpleName}"
			val built = cf.build(ClassDesc.of(name)) { builder ->
				builder.withInterfaceSymbols(classDesc)
				builder.withMethodBody(
					"execute",
					DEFAULT_VOID,
					ACC_PUBLIC
				) { codeBuilder ->
					codeBuilder
						.getReferenceField(name, mimicClassDesc)
						.invokeinterface(mimicClassDesc, "execute", DEFAULT_VOID)
						.return_()
				}
				builder.withMethodBody(
					ConstantDescs.INIT_NAME,
					MethodTypeDesc.of(ConstantDescs.CD_void, mimicClassDesc),
					ACC_PUBLIC
				) { codeBuilder ->
					codeBuilder
						.aload(0)
						.aload(1)
						.putReferenceField(name, mimicClassDesc)
						.return_()
				}
				builder.withReferenceField(mimicClassDesc)
			}

			return cl.define(name, built).constructors[0].newInstance(renderCall)
		}
	}

	fun execute()
}