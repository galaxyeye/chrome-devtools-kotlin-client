@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of AudioNode::ChannelCountMode from the spec
 */
@Serializable
public enum class ChannelCountMode {
  @SerialName("clamped-max")
  CLAMPED_MAX,
  @SerialName("explicit")
  EXPLICIT,
  @SerialName("max")
  MAX,
  UNKNOWN,
}
