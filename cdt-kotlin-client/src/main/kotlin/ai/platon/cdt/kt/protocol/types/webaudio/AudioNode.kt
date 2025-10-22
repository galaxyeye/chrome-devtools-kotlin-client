package ai.platon.cdt.kt.protocol.types.webaudio

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Protocol object for AudioNode
 */
data class AudioNode(
  @field:JsonProperty("nodeId")
  val nodeId: String,
  @field:JsonProperty("contextId")
  val contextId: String,
  @field:JsonProperty("nodeType")
  val nodeType: String,
  @field:JsonProperty("numberOfInputs")
  val numberOfInputs: Double,
  @field:JsonProperty("numberOfOutputs")
  val numberOfOutputs: Double,
  @field:JsonProperty("channelCount")
  val channelCount: Double,
  @field:JsonProperty("channelCountMode")
  val channelCountMode: ChannelCountMode,
  @field:JsonProperty("channelInterpretation")
  val channelInterpretation: ChannelInterpretation,
)
