package org.bread_experts_group.eam.minecraft.feature

import org.bread_experts_group.generic.io.reader.BSLReader
import java.io.InputStream

class BSLReaderStream(private val reader: BSLReader<*, *>) : InputStream() {
    override fun read(): Int = reader.readU8i().first!!
    override fun read(b: ByteArray): Int = reader.read(b).first
    override fun readNBytes(len: Int): ByteArray = reader.readN(len).first
    override fun readNBytes(b: ByteArray, off: Int, len: Int): Int = reader.read(b, off, len).first
    override fun read(b: ByteArray, off: Int, len: Int): Int = reader.read(b, off, len).first
    override fun skip(n: Long): Long = reader.skip(n).first
    override fun skipNBytes(n: Long) {
        reader.skip(n)
    }
}