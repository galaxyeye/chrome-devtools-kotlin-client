@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio

import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fields in AudioContext that change in real-time.
 */
@Serializable
data class ContextRealtimeData(
  @property:SerialName("currentTime")
  val currentTime: Double,
  @property:SerialName("renderCapacity")
  val renderCapacity: Double,
  @property:SerialName("callbackIntervalMean")
  val callbackIntervalMean: Double,
  @property:SerialName("callbackIntervalVariance")
  val callbackIntervalVariance: Double,
)
