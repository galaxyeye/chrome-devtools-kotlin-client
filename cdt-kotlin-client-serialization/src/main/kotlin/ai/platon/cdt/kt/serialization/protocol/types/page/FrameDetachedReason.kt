@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class FrameDetachedReason {
  @SerialName("remove")
  REMOVE,
  @SerialName("swap")
  SWAP,
  UNKNOWN,
}
