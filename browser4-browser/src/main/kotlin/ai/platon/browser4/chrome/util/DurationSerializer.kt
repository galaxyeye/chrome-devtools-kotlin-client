package ai.platon.browser4.chrome.util

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Duration

/**
 * Serializes [Duration] as its millisecond value (Long).
 */
object DurationSerializer : KSerializer<Duration> {
    override val descriptor = PrimitiveSerialDescriptor("Duration", PrimitiveKind.LONG)

    override fun serialize(encoder: Encoder, value: Duration) = encoder.encodeLong(value.toMillis())

    override fun deserialize(decoder: Decoder): Duration = Duration.ofMillis(decoder.decodeLong())
}
