package org.bread_experts_group.eam

fun loadClass(clazz: String): Class<*> = ClassLoader.getSystemClassLoader().loadClass(clazz)