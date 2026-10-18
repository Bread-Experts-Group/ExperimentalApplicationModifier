package org.bread_experts_group.eam

import org.bread_experts_group.eam.minecraft.v1x21x1.MimickedClass.Companion.mimicDesc
import org.bread_experts_group.eam.minecraft.v1x21x1.MimickedClass.Companion.nativeDesc
import org.bread_experts_group.eam.mappings.Mappings
import org.bread_experts_group.eam.mappings.MappingsBuilder
import org.bread_experts_group.eam.minecraft.v1x21x1.PoseStack
import java.lang.constant.ConstantDescs
import java.lang.constant.MethodTypeDesc
import kotlin.io.path.Path

private const val tab: String = "\t"
private const val newline: String = "\n"

fun main(vararg args: String) {
    val mappingsFile = Path(args[0]).toFile()
    val list = mappingsFile.readLines().toMutableList()
    list.removeIf { it.contains("package-info") || it.contains("#") || it.contains("clinit") }
    list.replaceAll {
        if (containsMultiple(it)) it.substringAfterLast(":")
        else if (it.startsWith("    ")) it.drop(4) else it
    }
    val mappingsBuilder = MappingsBuilder()

    list.forEach {
        val isMethod = it.contains("(") && !it.contains("init")
        val isInit =  it.contains("(") && it.contains("init")
        val isField = !it.contains("(") && !it.contains(":")
        val isClass = it.contains(":") && it.substringAfterLast(".")[0].isUpperCase()

        if (isMethod)  mappingsBuilder.parseMethod(it)
        else if (isInit) mappingsBuilder.parseInit(it)
        else if (isField) mappingsBuilder.parseField(it)
        else if (isClass) mappingsBuilder.parseClass(it.substringBefore(":"))
        else throw IllegalStateException("Found unknown: $it")
    }

//    mappingsBuilder.finish()
//    Mappings.dumpToFile()

    println(PoseStack::class.nativeDesc)
    println(PoseStack::class.mimicDesc)
}

private fun containsMultiple(input: String): Boolean {
    val array = input.toCharArray()
    var count = 0
    array.forEach { if (it == ':') count ++ }
    return count >= 2
}

fun test(var1: Int, var2: String, var3: Double): Int = 0
fun test1() {}