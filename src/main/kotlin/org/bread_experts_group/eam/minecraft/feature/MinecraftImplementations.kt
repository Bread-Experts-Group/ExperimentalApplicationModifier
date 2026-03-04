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
import org.bread_experts_group.eam.minecraft.transform.classLoaders
import org.bread_experts_group.generic.command_line.ArgumentContainer
import org.bread_experts_group.generic.command_line.Flag
import org.bread_experts_group.generic.command_line.stringToBoolean
import org.bread_experts_group.generic.io.reader.BSLReader
import java.lang.classfile.ClassFile
import java.lang.instrument.Instrumentation
import java.security.ProtectionDomain
import java.util.zip.ZipInputStream

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
	protected val mods: MutableMap<String, MutableList<MinecraftMod>> = mutableMapOf()
	override val features: MutableList<MinecraftFeatureImplementation<*, *>> = mutableListOf()

	private val modDir: String = "eam_mods"
	private fun bslLoad() {
		val cwd = SystemProvider.get(SystemFeatures.GET_CURRENT_WORKING_PATH_DEVICE).device
		val mods = cwd.get(SystemDeviceFeatures.PATH_APPEND).append(modDir)
		val modsChildren = mods.get(SystemDeviceFeatures.PATH_CHILDREN)
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
					if (nextEntry.name != "META-INF/eam/mods.txt") continue
					val classes = mutableMapOf<String, String>()
					zip.readAllBytes().decodeToString().split('\n').forEach {
						val (classPath, modID) = it.split(' ', limit = 2)
						classes[classPath.replace('.', '/').lowercase() + ".class"] = modID
					}
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
							val id = classes.remove(nextEntry.name.lowercase()) ?: continue
							val adjacentMods = this.mods.getOrPut(id) { mutableListOf() }
							val noConflictID = if (adjacentMods.isNotEmpty()) "${id}_eam${adjacentMods.size + 1}"
							else id
							val modLoader = jarLoader.ModClassLoader(noConflictID)
							classLoaders[noConflictID] = modLoader
							val loaded = modLoader.define(
								nextEntry.name.take(nextEntry.name.length - 6).replace('/', '.'),
								zip.readAllBytes()
							)
							adjacentMods.add(loaded.getConstructor().newInstance() as MinecraftMod)
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
	}

	fun implement(
		instrumentation: Instrumentation,
		scanning: Scanning
	) {
		bslLoad()
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