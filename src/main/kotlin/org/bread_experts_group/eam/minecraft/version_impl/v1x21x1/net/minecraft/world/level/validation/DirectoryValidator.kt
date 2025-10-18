package org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net.minecraft.world.level.validation

import org.bread_experts_group.eam.classDesc
import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.ClassInfo
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.version_impl.v1x21x1.net_minecraft_world_level_validation_DirectoryValidator
import java.lang.constant.ClassDesc

/*
net.minecraft.world.level.validation.DirectoryValidator -> ews:
# {"fileName":"DirectoryValidator.java","id":"sourceFile"}
    java.nio.file.PathMatcher symlinkTargetAllowList -> a
    18:20:void <init>(java.nio.file.PathMatcher) -> <init>
    23:27:void validateSymlink(java.nio.file.Path,java.util.List) -> a
    30:32:java.util.List validateSymlink(java.nio.file.Path) -> a
    36:61:java.util.List validateDirectory(java.nio.file.Path,boolean) -> a
    65:84:void validateKnownDirectory(java.nio.file.Path,java.util.List) -> b
net.minecraft.world.level.validation.DirectoryValidator$1 -> ews$1:
# {"fileName":"DirectoryValidator.java","id":"sourceFile"}
    java.util.List val$issues -> a
    net.minecraft.world.level.validation.DirectoryValidator this$0 -> b
    65:65:void <init>(net.minecraft.world.level.validation.DirectoryValidator,java.util.List) -> <init>
    67:70:void validateSymlink(java.nio.file.Path,java.nio.file.attribute.BasicFileAttributes) -> c
    74:75:java.nio.file.FileVisitResult preVisitDirectory(java.nio.file.Path,java.nio.file.attribute.BasicFileAttributes) -> a
    80:81:java.nio.file.FileVisitResult visitFile(java.nio.file.Path,java.nio.file.attribute.BasicFileAttributes) -> b
    65:65:java.nio.file.FileVisitResult visitFile(java.lang.Object,java.nio.file.attribute.BasicFileAttributes) -> visitFile
    65:65:java.nio.file.FileVisitResult preVisitDirectory(java.lang.Object,java.nio.file.attribute.BasicFileAttributes) -> preVisitDirectory
 */
class DirectoryValidator(around: Any) : MimickedClass(around) {
	companion object : ClassInfo {
		override val clazz: Class<*> = loadClass(net_minecraft_world_level_validation_DirectoryValidator)
		override val classDesc: ClassDesc = ClassDesc.of(clazz.name)
		override val mimicClassDesc: ClassDesc = DirectoryValidator::class.classDesc
	}
}