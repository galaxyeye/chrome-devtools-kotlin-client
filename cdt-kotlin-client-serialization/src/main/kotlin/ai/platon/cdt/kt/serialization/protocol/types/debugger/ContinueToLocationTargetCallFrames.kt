@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ContinueToLocationTargetCallFrames {
  @SerialName("any")
  ANY,
  @SerialName("current")
  CURRENT,
  UNKNOWN,
}
