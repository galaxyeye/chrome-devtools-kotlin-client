@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Protocol object for AudioNode
 */
@Serializable
data class AudioNode(
  @SerialName("nodeId")
  val nodeId: String,
  @SerialName("contextId")
  val contextId: String,
  @SerialName("nodeType")
  val nodeType: String,
  @SerialName("numberOfInputs")
  val numberOfInputs: Double,
  @SerialName("numberOfOutputs")
  val numberOfOutputs: Double,
  @SerialName("channelCount")
  val channelCount: Double,
  @SerialName("channelCountMode")
  val channelCountMode: ChannelCountMode,
  @SerialName("channelInterpretation")
  val channelInterpretation: ChannelInterpretation,
)
