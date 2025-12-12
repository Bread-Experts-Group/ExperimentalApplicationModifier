package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com.mojang.datafixers.util

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.mimic.ClassInfo
import org.bread_experts_group.eam.minecraft.mimic.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.com_mojang_datafixers_util_Pair
import java.lang.constant.ClassDesc

class Pair<F, S>(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(com_mojang_datafixers_util_Pair)
		override val classDesc: ClassDesc = clazz.classDesc
		override val mimicClassDesc: ClassDesc = Pair::class.classDesc
	}

	constructor(first: F, second: S) : this(
		clazz.getConstructor(Object::class.java, Object::class.java)
			.newInstance(first, second)
	)
}