package org.bread_experts_group.eam

class DefiningClassLoader(
	private val name: String? = null,
	parent: ClassLoader = getSystemClassLoader()
) : ClassLoader(parent) {
	override fun getName(): String? = name
	fun define(n: String, b: ByteArray): Class<*> = this.defineClass(n, b, 0, b.size)
}