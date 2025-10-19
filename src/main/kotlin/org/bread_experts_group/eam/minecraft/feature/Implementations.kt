package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.api.FeatureExpression
import org.bread_experts_group.api.FeatureProvider
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import java.lang.classfile.ClassFile
import java.lang.classfile.CodeBuilder
import java.lang.constant.ClassDesc
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain
import java.util.*

typealias Scanning = MutableMap<String, (ClassLoader?, Class<*>?, ProtectionDomain, ByteArray) -> ByteArray?>
typealias SupportedMCFeatures = MutableMap<FeatureExpression<out MinecraftFeatureImplementation<*, *>>, MutableList<MinecraftFeatureImplementation<*, *>>>

abstract class Implementations : FeatureProvider<MinecraftFeatureImplementation<*, *>> {
	protected val classFile: ClassFile = ClassFile.of(
		ClassFile.StackMapsOption.GENERATE_STACK_MAPS
	)

	private lateinit var instrumentation: Instrumentation
	protected lateinit var scanning: Scanning
	protected val mods: List<MinecraftMod> = ServiceLoader.load(MinecraftMod::class.java).toList()
	override val features: MutableList<MinecraftFeatureImplementation<*, *>> = mutableListOf()

	fun implement(
		instrumentation: Instrumentation,
		scanning: Scanning
	) {
		this.instrumentation = instrumentation
		this.scanning = scanning
		start()
	}

	abstract fun start()

	fun CodeBuilder.debugPrint(p: ClassDesc = ConstantDescs.CD_Object): CodeBuilder = this
		.dup()
		.invokevirtual(
			ClassDesc.of("java.lang.Object"),
			"getClass",
			MethodTypeDesc.of(ConstantDescs.CD_Class)
		)
		.getstatic(
			ClassDesc.of("java.lang.System"),
			"out",
			ClassDesc.of("java.io.PrintStream")
		)
		.swap()
		.invokevirtual(
			ClassDesc.of("java.io.PrintStream"),
			"println",
			MethodTypeDesc.of(ConstantDescs.CD_void, ConstantDescs.CD_Object)
		)
		.dup()
		.getstatic(
			ClassDesc.of("java.lang.System"),
			"out",
			ClassDesc.of("java.io.PrintStream")
		)
		.swap()
		.invokevirtual(
			ClassDesc.of("java.io.PrintStream"),
			"println",
			MethodTypeDesc.of(ConstantDescs.CD_void, p)
		)
}