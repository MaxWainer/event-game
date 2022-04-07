package ru.mgkit.event.game.serializer

import android.util.Log
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.*

object UUIDSerializer : KSerializer<UUID> {
    override fun deserialize(decoder: Decoder) = decoder.decodeString().let {
        UUID.fromString(it) ?: kotlin.run {
            Log.e("UUID_SERIALIZER", "Invalid uuid: $it")

            UUID(0, 0)
        }
    }

    override val descriptor = PrimitiveSerialDescriptor("uniqueId", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }
}