@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates whether a frame has been identified as an ad.
 */
@Serializable
public enum class AdFrameType {
  @SerialName("none")
  NONE,
  @SerialName("child")
  CHILD,
  @SerialName("root")
  ROOT,
  UNKNOWN,
}
