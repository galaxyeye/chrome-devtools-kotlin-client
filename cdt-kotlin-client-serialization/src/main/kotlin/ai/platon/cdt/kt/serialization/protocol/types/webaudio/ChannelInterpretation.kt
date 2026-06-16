@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of AudioNode::ChannelInterpretation from the spec
 */
@Serializable
public enum class ChannelInterpretation {
  @SerialName("discrete")
  DISCRETE,
  @SerialName("speakers")
  SPEAKERS,
  UNKNOWN,
}
