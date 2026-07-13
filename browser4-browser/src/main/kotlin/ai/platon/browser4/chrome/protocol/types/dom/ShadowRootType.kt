@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.dom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Shadow root type.
 */
@Serializable
public enum class ShadowRootType {
  @SerialName("user-agent")
  USER_AGENT,
  @SerialName("open")
  OPEN,
  @SerialName("closed")
  CLOSED,
  UNKNOWN,
}
