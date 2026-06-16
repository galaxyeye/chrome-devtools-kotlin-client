@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Corresponds to kMediaEventTriggered
 */
@Serializable
data class PlayerEvent(
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("value")
  val `value`: String,
)
