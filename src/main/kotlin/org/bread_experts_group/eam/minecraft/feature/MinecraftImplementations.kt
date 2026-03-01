package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.api.feature.FeatureExpression
import org.bread_experts_group.api.feature.FeatureProvider
import org.bread_experts_group.api.system.SystemFeatures
import org.bread_experts_group.api.system.SystemProvider
import org.bread_experts_group.api.system.device.SystemDeviceFeatures
import org.bread_experts_group.api.system.io.IODevice
import org.bread_experts_group.api.system.io.IODeviceFeatures
import org.bread_experts_group.api.system.io.open.FileIOReOpenFeatures
import org.bread_experts_group.api.system.io.open.WindowsIOReOpenFeatures
import org.bread_experts_group.eam.JARDefiningClassLoader
import org.bread_experts_group.eam.minecraft.MinecraftFeatureImplementation
import org.bread_experts_group.generic.command_line.ArgumentContainer
import org.bread_experts_group.generic.command_line.Flag
import org.bread_experts_group.generic.command_line.stringToBoolean
import org.bread_experts_group.generic.io.reader.BSLReader
import java.lang.classfile.ClassFile
import java.lang.instrument.Instrumentation
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Files
import java.security.ProtectionDomain
import java.util.*
import java.util.zip.ZipInputStream
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
	protected lateinit var mods: List<MinecraftMod>
	override val features: MutableList<MinecraftFeatureImplementation<*, *>> = mutableListOf()

	private val modDir: String = "eam_mods"
	private fun bslLoad(): List<MinecraftMod>? {
		val cwd = SystemProvider.getOrNull(SystemFeatures.GET_CURRENT_WORKING_PATH_DEVICE)?.device
			?: return null
		val mods = (cwd.getOrNull(SystemDeviceFeatures.PATH_APPEND)
			?: return null).append(modDir)
		val modsChildren = mods.getOrNull(SystemDeviceFeatures.PATH_CHILDREN)
			?: return null
		val loadedClasses = mutableListOf<MinecraftMod>()
		for (device in modsChildren) {
			val ioStatus = device.get(SystemDeviceFeatures.IO_DEVICE).open(
				FileIOReOpenFeatures.READ,
				FileIOReOpenFeatures.SHARE_READ,
				WindowsIOReOpenFeatures.OPTIMIZE_SEQUENTIAL_ACCESS
			)
			val ioDevice = ioStatus.firstNotNullOfOrNull { it as? IODevice } ?: continue
			val zip = ZipInputStream(
				BSLReaderStream(BSLReader(ioDevice.get(IODeviceFeatures.READ)))
			)
			val jarLoader = JARDefiningClassLoader(
				"${device.get(SystemDeviceFeatures.SYSTEM_IDENTIFIER).identity} Loader",
				device
			)
			try {
				while (true) {
					val nextEntry = zip.nextEntry ?: break
					if (nextEntry.name != "META-INF/services/${MinecraftMod::class.qualifiedName}")
						continue
					val classes = zip.readAllBytes().decodeToString().split('\n').map {
						it.replace('.', '/').lowercase() + ".class"
					}.toMutableSet()
					if (classes.isEmpty()) break
					val ioStatus = device.get(SystemDeviceFeatures.IO_DEVICE).open(
						FileIOReOpenFeatures.READ,
						FileIOReOpenFeatures.SHARE_READ,
						WindowsIOReOpenFeatures.OPTIMIZE_SEQUENTIAL_ACCESS
					)
					val ioDevice = ioStatus.firstNotNullOfOrNull { it as? IODevice } ?: continue
					val zip = ZipInputStream(
						BSLReaderStream(BSLReader(ioDevice.get(IODeviceFeatures.READ)))
					)
					try {
						while (true) {
							val nextEntry = zip.nextEntry ?: break
							if (!classes.remove(nextEntry.name.lowercase())) continue
							val loaded = jarLoader.define(
								nextEntry.name.take(nextEntry.name.length - 6).replace('/', '.'),
								zip.readAllBytes()
							)
							loadedClasses.add(loaded.getConstructor().newInstance() as MinecraftMod)
						}
					} finally {
						ioDevice.get(IODeviceFeatures.RELEASE).close()
						zip.close()
					}
					break
				}
			} finally {
				ioDevice.get(IODeviceFeatures.RELEASE).close()
				zip.close()
			}
		}
		return loadedClasses
	}

	private fun javaLoad(): List<MinecraftMod> {
		val loaded: List<URL> = Files.list(Path("eam_mods")).toList().map { it.toUri().toURL() }
		val loader = URLClassLoader(loaded.toTypedArray(), this::class.java.classLoader)
		return ServiceLoader.load(MinecraftMod::class.java, loader).toList()
	}

	fun implement(
		instrumentation: Instrumentation,
		scanning: Scanning
	) {
		mods = bslLoad() ?: javaLoad()
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