package org.bread_experts_group.eam.minecraft.mimic

import java.lang.constant.ClassDesc

interface ClassInfo {
	val clazz: Class<*>
	val classDesc: ClassDesc
	val mimicClassDesc: ClassDesc
}