package ai.platon.cdt.kt.protocol.types.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Fields in AudioContext that change in real-time.
 */
public data class ContextRealtimeData(
  @field:JsonProperty("currentTime")
  public val currentTime: Double,
  @field:JsonProperty("renderCapacity")
  public val renderCapacity: Double,
  @field:JsonProperty("callbackIntervalMean")
  public val callbackIntervalMean: Double,
  @field:JsonProperty("callbackIntervalVariance")
  public val callbackIntervalVariance: Double,
)
