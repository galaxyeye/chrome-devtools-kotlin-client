package ai.platon.cdt.kt.protocol.types.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Protocol object for AudioParam
 */
public data class AudioParam(
  @field:JsonProperty("paramId")
  public val paramId: String,
  @field:JsonProperty("nodeId")
  public val nodeId: String,
  @field:JsonProperty("contextId")
  public val contextId: String,
  @field:JsonProperty("paramType")
  public val paramType: String,
  @field:JsonProperty("rate")
  public val rate: AutomationRate,
  @field:JsonProperty("defaultValue")
  public val defaultValue: Double,
  @field:JsonProperty("minValue")
  public val minValue: Double,
  @field:JsonProperty("maxValue")
  public val maxValue: Double,
)
