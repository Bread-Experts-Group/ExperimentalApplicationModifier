package org.bread_experts_group.eamlaunch.pending_bsl

import org.bread_experts_group.eamlaunch.api.SerializableURI
import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.bread_systems_library.model.JSONArray
import org.bread_experts_group.bread_systems_library.model.JSONNumber
import org.bread_experts_group.bread_systems_library.model.JSONObject
import org.bread_experts_group.bread_systems_library.model.JSONPrimitive
import org.bread_experts_group.bread_systems_library.model.JSONString
import java.math.BigDecimal
import java.net.URI
import kotlin.collections.remove
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.typeOf

interface IJSONDeserializer<I, T> {
    fun jsonDeserialize(input: I?): T
}

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class JSONDeserializer(val deserializer: KClass<out IJSONDeserializer<*, *>>)

annotation class JSONName(val name: String)

fun jsonDecode(type: KType, primitive: JSONPrimitive?): Any? {
    val clazz = type.classifier as KClass<*>
    return if (clazz.isData) {
        if (primitive !is JSONObject) return null
        val constructor = clazz.primaryConstructor!!
        constructor.callBy(
            buildMap {
                val elementsMutable = primitive.elements.toMutableMap()
                constructor.parameters.forEach {
                    val name = it.findAnnotation<JSONName>()?.name ?: it.name
                    put(it, jsonDecode(it.type, elementsMutable.remove(name)))
                }
                if (elementsMutable.isNotEmpty()) {
                    println("$type")
                    elementsMutable.forEach { (key, element) ->
                        println("  $key ... $element")
                    }
                    println("===")
                }
            }
        )
    } else when (clazz) {
        BigDecimal::class -> (primitive as JSONNumber).number
        String::class -> (primitive as? JSONString)?.value
        List::class -> (primitive as? JSONArray)?.elements?.map { jsonDecode(type.arguments[0].type!!, it) }
        Map::class -> (primitive as? JSONObject)?.elements?.entries?.associate { (key, element) ->
            key to jsonDecode(type.arguments[1].type!!, element)
        }

        else -> {
            val deserializerKind = type.findAnnotation<JSONDeserializer>()?.deserializer ?: clazz.findAnnotation<JSONDeserializer>()?.deserializer ?: throw IllegalArgumentException(
                "Unable to deserialize $type"
            )
            val deserializerInput = deserializerKind.supertypes.first { it.classifier as KClass<*> == IJSONDeserializer::class }.arguments[0].type!!
            @Suppress("UNCHECKED_CAST")
            (deserializerKind.objectInstance as IJSONDeserializer<Any?, Any>).jsonDeserialize(
                jsonDecode(deserializerInput, primitive)
            )
        }
    }
}

inline fun <reified T> jsonDecode(primitive: JSONPrimitive?): T = jsonDecode(typeOf<T>(), primitive) as T

object URISerializer : IJSONDeserializer<String, SerializableURI>, IBSLGPSerializer<SerializableURI>, IBSLGPDeserializer<SerializableURI> {
    override fun jsonDeserialize(input: String?): SerializableURI = SerializableURI(URI(input!!))

    override fun bslGpSerialize(data: SerializableURI, output: FlushingOutput, context: EncodingContext) {
        bslGPEncode(data.value.toString(), output, context)
    }

    override fun bslGpDeserialize(input: BlockingInput, context: DecodingContext): SerializableURI = SerializableURI(
        URI(bslGPDecode<String>(input, context))
    )
}