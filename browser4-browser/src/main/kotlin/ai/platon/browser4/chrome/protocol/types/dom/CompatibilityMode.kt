@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.dom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Document compatibility mode.
 */
@Serializable
public enum class CompatibilityMode {
  @SerialName("QuirksMode")
  QUIRKS_MODE,
  @SerialName("LimitedQuirksMode")
  LIMITED_QUIRKS_MODE,
  @SerialName("NoQuirksMode")
  NO_QUIRKS_MODE,
  UNKNOWN,
}
