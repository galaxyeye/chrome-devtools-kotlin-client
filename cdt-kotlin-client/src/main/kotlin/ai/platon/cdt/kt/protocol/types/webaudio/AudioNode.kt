package ai.platon.cdt.kt.protocol.types.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Protocol object for AudioNode
 */
public data class AudioNode(
  @field:JsonProperty("nodeId")
  public val nodeId: String,
  @field:JsonProperty("contextId")
  public val contextId: String,
  @field:JsonProperty("nodeType")
  public val nodeType: String,
  @field:JsonProperty("numberOfInputs")
  public val numberOfInputs: Double,
  @field:JsonProperty("numberOfOutputs")
  public val numberOfOutputs: Double,
  @field:JsonProperty("channelCount")
  public val channelCount: Double,
  @field:JsonProperty("channelCountMode")
  public val channelCountMode: ChannelCountMode,
  @field:JsonProperty("channelInterpretation")
  public val channelInterpretation: ChannelInterpretation,
)
