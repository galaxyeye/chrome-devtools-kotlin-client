package ai.platon.cdt.kt.protocol.types.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Fields in AudioContext that change in real-time.
 */
data class ContextRealtimeData(
  @field:JsonProperty("currentTime")
  val currentTime: Double,
  @field:JsonProperty("renderCapacity")
  val renderCapacity: Double,
  @field:JsonProperty("callbackIntervalMean")
  val callbackIntervalMean: Double,
  @field:JsonProperty("callbackIntervalVariance")
  val callbackIntervalVariance: Double,
)
