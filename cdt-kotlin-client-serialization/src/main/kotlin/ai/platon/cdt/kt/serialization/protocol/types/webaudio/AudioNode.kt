@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Protocol object for AudioNode
 */
@Serializable
data class AudioNode(
  @property:SerialName("nodeId")
  val nodeId: String,
  @property:SerialName("contextId")
  val contextId: String,
  @property:SerialName("nodeType")
  val nodeType: String,
  @property:SerialName("numberOfInputs")
  val numberOfInputs: Double,
  @property:SerialName("numberOfOutputs")
  val numberOfOutputs: Double,
  @property:SerialName("channelCount")
  val channelCount: Double,
  @property:SerialName("channelCountMode")
  val channelCountMode: ChannelCountMode,
  @property:SerialName("channelInterpretation")
  val channelInterpretation: ChannelInterpretation,
)
