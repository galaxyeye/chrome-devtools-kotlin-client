package ai.platon.cdt.kt.protocol.types.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Protocol object for AudioParam
 */
data class AudioParam(
  @field:JsonProperty("paramId")
  val paramId: String,
  @field:JsonProperty("nodeId")
  val nodeId: String,
  @field:JsonProperty("contextId")
  val contextId: String,
  @field:JsonProperty("paramType")
  val paramType: String,
  @field:JsonProperty("rate")
  val rate: AutomationRate,
  @field:JsonProperty("defaultValue")
  val defaultValue: Double,
  @field:JsonProperty("minValue")
  val minValue: Double,
  @field:JsonProperty("maxValue")
  val maxValue: Double,
)
