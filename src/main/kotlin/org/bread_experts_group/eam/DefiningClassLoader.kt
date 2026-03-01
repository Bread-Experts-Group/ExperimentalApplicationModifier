package org.bread_experts_group.eam

class DefiningClassLoader(parent: ClassLoader = getSystemClassLoader()) : ClassLoader(parent) {
	fun define(n: String, b: ByteArray): Class<*> = this.defineClass(n, b, 0, b.size)
}