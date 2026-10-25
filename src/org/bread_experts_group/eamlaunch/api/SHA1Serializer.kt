package org.bread_experts_group.eamlaunch.api

import org.bread_experts_group.bread_systems_library.generic.BlockingInput
import org.bread_experts_group.bread_systems_library.generic.FlushingOutput
import org.bread_experts_group.bread_systems_library.model.codings.*

object SHA1Serializer : IJSONDeserializer<String, SHA1>, IBSLGPDeserializer<SHA1>, IBSLGPSerializer<SHA1> {
    override fun jsonDeserialize(input: String?): SHA1 = SHA1(
        input!!.hexToByteArray().also {
            if (it.size != 20) throw IllegalArgumentException(
                "SHA-1 must be 20 bytes (40 hexadecimal characters: $input [${it.size}])"
            )
        }
    )

    override fun bslGpDeserialize(input: BlockingInput, context: DecodingContext): SHA1 = SHA1(
        input.readBytes(20)
    )

    override fun bslGpSerialize(data: SHA1, output: FlushingOutput, context: EncodingContext) {
        if (data.value.size != 20) throw IllegalArgumentException(
            "SHA-1 must be 20 bytes (40 hexadecimal characters: ${data.value.toHexString()} [${data.value.size}])"
        )
        output.writeData(data.value)
    }
}