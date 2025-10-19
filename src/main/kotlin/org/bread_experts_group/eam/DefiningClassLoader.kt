package org.bread_experts_group.eam

class DefiningClassLoader : ClassLoader() {
	fun define(n: String, b: ByteArray): Class<*> = this.defineClass(n, b, 0, b.size)
}