package org.bread_experts_group.eam.minecraft.feature.v1x21x1.net.minecraft.resources

import org.bread_experts_group.eam.loadClass
import org.bread_experts_group.eam.minecraft.feature.MimickedClass
import org.bread_experts_group.eam.minecraft.feature.v1x21x1.net_minecraft_resources_ResourceLocation
import java.lang.constant.ClassDesc

/*
    com.mojang.serialization.Codec CODEC -> a
    net.minecraft.network.codec.StreamCodec STREAM_CODEC -> b
    com.mojang.brigadier.exceptions.SimpleCommandExceptionType ERROR_INVALID -> c
    char NAMESPACE_SEPARATOR -> d
    java.lang.String DEFAULT_NAMESPACE -> e
    java.lang.String REALMS_NAMESPACE -> f
    java.lang.String namespace -> h
    java.lang.String path -> i
    boolean $assertionsDisabled -> g
    39:45:void <init>(java.lang.String,java.lang.String) -> <init>
    48:48:net.minecraft.resources.ResourceLocation createUntrusted(java.lang.String,java.lang.String) -> d
    52:52:net.minecraft.resources.ResourceLocation fromNamespaceAndPath(java.lang.String,java.lang.String) -> a
    56:56:net.minecraft.resources.ResourceLocation parse(java.lang.String) -> a
    60:60:net.minecraft.resources.ResourceLocation withDefaultNamespace(java.lang.String) -> b
    65:65:net.minecraft.resources.ResourceLocation tryParse(java.lang.String) -> c
    70:73:net.minecraft.resources.ResourceLocation tryBuild(java.lang.String,java.lang.String) -> b
    77:89:net.minecraft.resources.ResourceLocation bySeparator(java.lang.String,char) -> a
    94:109:net.minecraft.resources.ResourceLocation tryBySeparator(java.lang.String,char) -> b
    114:116:com.mojang.serialization.DataResult read(java.lang.String) -> d
    121:121:java.lang.String getPath() -> a
    125:125:java.lang.String getNamespace() -> b
    129:129:net.minecraft.resources.ResourceLocation withPath(java.lang.String) -> e
    133:133:net.minecraft.resources.ResourceLocation withPath(java.util.function.UnaryOperator) -> a
    137:137:net.minecraft.resources.ResourceLocation withPrefix(java.lang.String) -> f
    141:141:net.minecraft.resources.ResourceLocation withSuffix(java.lang.String) -> g
    146:146:java.lang.String toString() -> toString
    151:159:boolean equals(java.lang.Object) -> equals
    164:164:int hashCode() -> hashCode
    170:174:int compareTo(net.minecraft.resources.ResourceLocation) -> a
    178:178:java.lang.String toDebugFileName() -> c
    182:182:java.lang.String toLanguageKey() -> d
    186:186:java.lang.String toShortLanguageKey() -> e
    190:190:java.lang.String toLanguageKey(java.lang.String) -> h
    194:194:java.lang.String toLanguageKey(java.lang.String,java.lang.String) -> c
    210:214:java.lang.String readGreedy(com.mojang.brigadier.StringReader) -> c
    218:224:net.minecraft.resources.ResourceLocation read(com.mojang.brigadier.StringReader) -> a
    229:238:net.minecraft.resources.ResourceLocation readNonEmpty(com.mojang.brigadier.StringReader) -> b
    243:243:boolean isAllowedInResourceLocation(char) -> a
    251:256:boolean isValidPath(java.lang.String) -> i
    260:265:boolean isValidNamespace(java.lang.String) -> j
    269:272:java.lang.String assertValidNamespace(java.lang.String,java.lang.String) -> e
    276:276:boolean validPathChar(char) -> b
    280:280:boolean validNamespaceChar(char) -> c
    284:287:java.lang.String assertValidPath(java.lang.String,java.lang.String) -> f
    26:26:int compareTo(java.lang.Object) -> compareTo
    116:116:java.lang.String lambda$read$0(java.lang.String,net.minecraft.ResourceLocationException) -> a
    26:30:void <clinit>() -> <clinit>
 */
class ResourceLocation(around: Any) : MimickedClass(around) {
	companion object {
		val clazz: Class<*> = loadClass(
			net_minecraft_resources_ResourceLocation
		)
		val classDesc: ClassDesc = ClassDesc.of(clazz.name)

		fun parse(location: String) = ResourceLocation(
			clazz.getMethod("a", String::class.java).invoke(null, location)
		)
	}
}