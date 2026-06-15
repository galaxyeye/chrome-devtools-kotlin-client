@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Corresponds to kMediaEventTriggered
 */
@Serializable
data class PlayerEvent(
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("value")
  val `value`: String,
)
