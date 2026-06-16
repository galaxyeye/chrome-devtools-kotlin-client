@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the cookie's 'Priority' status:
 * https://tools.ietf.org/html/draft-west-cookie-priority-00
 */
@Serializable
public enum class CookiePriority {
  @SerialName("Low")
  LOW,
  @SerialName("Medium")
  MEDIUM,
  @SerialName("High")
  HIGH,
  UNKNOWN,
}
