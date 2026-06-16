@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of BaseAudioContext types
 */
@Serializable
public enum class ContextType {
  @SerialName("realtime")
  REALTIME,
  @SerialName("offline")
  OFFLINE,
  UNKNOWN,
}
