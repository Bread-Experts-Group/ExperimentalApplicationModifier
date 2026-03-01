package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.api.feature.FeatureExpression
import org.bread_experts_group.api.feature.FeatureProvider
import org.bread_experts_group.api.system.SystemFeatures.GET_CURRENT_WORKING_PATH_DEVICE
import org.bread_experts_group.api.system.SystemProvider
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import org.bread_experts_group.generic.command_line.ArgumentContainer
import org.bread_experts_group.generic.command_line.Flag
import org.bread_experts_group.generic.command_line.stringToBoolean
import java.lang.classfile.ClassFile
import java.lang.instrument.Instrumentation
import java.net.URLClassLoader
import java.net.URLConnection
import java.nio.file.Files
import java.security.ProtectionDomain
import java.util.ServiceLoader
import java.util.jar.JarFile
import java.util.zip.ZipFile
import kotlin.io.path.Path

typealias Scanning = MutableMap<String, (ClassLoader?, Class<*>?, ProtectionDomain, ByteArray) -> ByteArray?>
typealias SupportedMCFeatures = MutableMap<FeatureExpression<out MinecraftFeatureImplementation<*, *>>, MutableList<MinecraftFeatureImplementation<*, *>>>

abstract class MinecraftImplementations : FeatureProvider<MinecraftFeatureImplementation<*, *>> {
	companion object {
		val logAllLoadsFlag: Flag<Boolean> = Flag(
			"log_all_class_loads",
			"Logs all class loads.",
			conv = ::stringToBoolean
		)
		val writeTransformedClasses: Flag<String> = Flag(
			"write_transformed_classes",
			"Writes transformed CLASS files to the specified path.",
			conv = { it }
		)
		val writeTransformedFeatures: Flag<String> = Flag(
			"write_transformed_features",
			"Writes transformed feature CLASS files to the specified path.",
			conv = { it }
		)
		val writeMimics: Flag<String> = Flag(
			"write_mimics",
			"Writes dynamically generated mimic CLASS files to the specified path.",
			conv = { it }
		)
		lateinit var arguments: ArgumentContainer
	}

	private val classFile: ClassFile = ClassFile.of(ClassFile.StackMapsOption.GENERATE_STACK_MAPS)
	private lateinit var instrumentation: Instrumentation
	protected lateinit var scanning: Scanning
	protected val mods: List<MinecraftMod>
	override val features: MutableList<MinecraftFeatureImplementation<*, *>> = mutableListOf()

	init {
//		val workingDir = System.getProperty("user.dir")
		val modJars = Files.list(Path("eam_mods")).toList()
		modJars.forEach { println(it) }
		val loader = URLClassLoader(modJars.map { it.toUri().toURL() }.toTypedArray())
		println(loader.loadClass("org.bread_experts_group.breadmod.BMUtil"))
		println(loader.loadClass("org.bread_experts_group.breadmod.TestBlockEntity"))
		mods = ServiceLoader.load(MinecraftMod::class.java, loader).toList()
	}

	fun implement(
		instrumentation: Instrumentation,
		scanning: Scanning
	) {
		this.instrumentation = instrumentation
		this.scanning = scanning
		start(this.scanning, classFile)
	}

	abstract fun start(scanning: Scanning, classFile: ClassFile)

	/**
	 * A temporary workaround to force the jvm to load provided classes so they can be transformed.
	 */
	open fun preload(): List<String> = listOf()
}