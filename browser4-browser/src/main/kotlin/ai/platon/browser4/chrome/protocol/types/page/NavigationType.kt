@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The type of a frameNavigated event.
 */
@Serializable
public enum class NavigationType {
  @SerialName("Navigation")
  NAVIGATION,
  @SerialName("BackForwardCacheRestore")
  BACK_FORWARD_CACHE_RESTORE,
  UNKNOWN,
}
