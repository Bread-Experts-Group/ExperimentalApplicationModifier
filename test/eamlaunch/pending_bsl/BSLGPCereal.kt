package eamlaunch.pending_bsl

import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.KType
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.typeOf

interface IBSLGPSerializer<T> {
    fun bslGpSerialize(data: T, output: FlushingOutput)
}

interface IBSLGPDeserializer<T> {
    fun bslGpDeserialize(input: BlockingInput): T
}

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class BSLGPSerializer(val serializer: KClass<out IBSLGPSerializer<*>>)

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class BSLGPDeserializer(val deserializer: KClass<out IBSLGPDeserializer<*>>)

fun bslGPEncode(type: KType, data: Any?, buffer: FlushingOutput) {
    val clazz = type.classifier as KClass<*>
    if (data == null) {
        buffer.writeByte(0)
        return
    }
    buffer.writeByte(1)
    if (clazz.isData) {
        val constructor = clazz.primaryConstructor!!
        constructor.parameters.forEach { parameter ->
            @Suppress("UNCHECKED_CAST")
            val property = clazz.memberProperties.first {
                it.name == parameter.name && it.returnType == parameter.type
            } as KProperty1<Any, *>
            bslGPEncode(property.returnType, property.get(data), buffer)
        }
    } else when (type.classifier as KClass<*>) {
        String::class -> {
            data as String
            buffer.writeInt(data.length)
            buffer.writeData(data.toByteArray())
        }

        Int::class -> {
            data as Int
            buffer.writeInt(data)
        }

        Long::class -> {
            data as Long
            buffer.writeLong(data)
        }

        BigDecimal::class -> {
            data as BigDecimal
            bslGPEncode(data.scale(), buffer)
            bslGPEncode(data.unscaledValue(), buffer)
        }

        BigInteger::class -> {
            data as BigInteger
            bslGPEncode(data.toByteArray(), buffer)
        }

        ByteArray::class -> {
            data as ByteArray
            bslGPEncode(data.size, buffer)
            buffer.writeData(data)
        }

        List::class -> {
            @Suppress("UNCHECKED_CAST")
            data as List<Any>
            buffer.writeInt(data.size)
            data.forEach { element ->
                bslGPEncode(type.arguments.first().type!!, element, buffer)
            }
        }

        else -> {
            val serializerKind = type.findAnnotation<BSLGPSerializer>()?.serializer ?: clazz.findAnnotation<BSLGPSerializer>()?.serializer ?: throw IllegalArgumentException(
                "Unable to serialize $type"
            )
            @Suppress("UNCHECKED_CAST")
            (serializerKind.objectInstance as IBSLGPSerializer<Any>).bslGpSerialize(data, buffer)
        }
    }
}

inline fun <reified T : Any> bslGPEncode(data: T, buffer: FlushingOutput) = bslGPEncode(typeOf<T>(), data, buffer)

fun bslGPDecode(type: KType, input: BlockingInput): Any? {
    val clazz = type.classifier as KClass<*>
    if (input.readByte() == 0.toByte()) return null
    return if (clazz.isData) {
        val constructor = clazz.primaryConstructor!!
        constructor.callBy(
            buildMap {
                constructor.parameters.forEach { parameter ->
                    @Suppress("UNCHECKED_CAST")
                    val property = clazz.memberProperties.first {
                        it.name == parameter.name && it.returnType == parameter.type
                    } as KProperty1<Any, *>
                    put(parameter, bslGPDecode(property.returnType, input))
                }
            }
        )
    } else when (type.classifier as KClass<*>) {
        String::class -> input.readBytes(input.readInt()).decodeToString()

        BigDecimal::class -> {
            val scale = bslGPDecode<Int>(input)!!
            BigDecimal(bslGPDecode<BigInteger>(input)!!, scale)
        }

        BigInteger::class -> BigInteger(bslGPDecode<ByteArray>(input))

        ByteArray::class -> input.readBytes(bslGPDecode<Int>(input)!!)

        Int::class -> input.readInt()

        List::class -> List(input.readInt()) {
            bslGPDecode(type.arguments.first().type!!, input)
        }

        else -> {
            val serializerKind = type.findAnnotation<BSLGPDeserializer>()?.deserializer ?: clazz.findAnnotation<BSLGPDeserializer>()?.deserializer ?: throw IllegalArgumentException(
                "Unable to deserialize $type"
            )
            @Suppress("UNCHECKED_CAST")
            (serializerKind.objectInstance as IBSLGPDeserializer<Any>).bslGpDeserialize(input)
        }
    }
}

inline fun <reified T> bslGPDecode(input: BlockingInput): T? = bslGPDecode(typeOf<T>(), input) as? T