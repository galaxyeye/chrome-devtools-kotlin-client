@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double

/**
 * Fields in AudioContext that change in real-time.
 */
@Serializable
data class ContextRealtimeData(
  @SerialName("currentTime")
  val currentTime: Double,
  @SerialName("renderCapacity")
  val renderCapacity: Double,
  @SerialName("callbackIntervalMean")
  val callbackIntervalMean: Double,
  @SerialName("callbackIntervalVariance")
  val callbackIntervalVariance: Double,
)
