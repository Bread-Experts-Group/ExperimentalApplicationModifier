package org.bread_experts_group.eam

import org.bread_experts_group.api.system.device.SystemDevice
import org.bread_experts_group.api.system.device.SystemDeviceFeatures
import org.bread_experts_group.api.system.io.IODevice
import org.bread_experts_group.api.system.io.IODeviceFeatures
import org.bread_experts_group.api.system.io.open.FileIOReOpenFeatures
import org.bread_experts_group.api.system.io.open.WindowsIOReOpenFeatures
import org.bread_experts_group.eam.minecraft.feature.BSLReaderStream
import org.bread_experts_group.generic.io.reader.BSLReader
import java.util.zip.ZipInputStream

open class JARDefiningClassLoader(
    name: String? = null,
    private val source: SystemDevice,
    parent: ClassLoader = getSystemClassLoader()
) : DefiningClassLoader(name, parent) {
    override fun loadClass(name: String?): Class<*>? {
        findLoadedClass(name).let { if (it != null) return it }
        if (name == null) return null
        val ioStatus = source.get(SystemDeviceFeatures.IO_DEVICE).open(
            FileIOReOpenFeatures.READ,
            FileIOReOpenFeatures.SHARE_READ,
            WindowsIOReOpenFeatures.OPTIMIZE_SEQUENTIAL_ACCESS
        )
        val ioDevice = ioStatus.firstNotNullOfOrNull { it as? IODevice } ?: return super.loadClass(name)
        val zip = ZipInputStream(
            BSLReaderStream(BSLReader(ioDevice.get(IODeviceFeatures.READ)))
        )
        val asFile = name.lowercase().replace('.', '/') + ".class"
        try {
            while (true) {
                val nextEntry = zip.nextEntry ?: break
                if (nextEntry.name.lowercase() != asFile) continue
                val loaded = this.define(
                    nextEntry.name.take(nextEntry.name.length - 6).replace('/', '.'),
                    zip.readAllBytes()
                )
                return loaded
            }
        } finally {
            ioDevice.get(IODeviceFeatures.RELEASE).close()
            zip.close()
        }
        return super.loadClass(name)
    }
}