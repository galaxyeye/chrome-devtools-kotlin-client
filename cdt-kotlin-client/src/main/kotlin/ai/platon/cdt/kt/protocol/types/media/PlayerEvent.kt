package ai.platon.cdt.kt.protocol.types.media

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Corresponds to kMediaEventTriggered
 */
data class PlayerEvent(
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("value")
  val `value`: String,
)
