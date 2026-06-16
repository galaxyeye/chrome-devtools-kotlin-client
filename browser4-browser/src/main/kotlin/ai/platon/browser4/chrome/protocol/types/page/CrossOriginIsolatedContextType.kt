@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates whether the frame is cross-origin isolated and why it is the case.
 */
@Serializable
public enum class CrossOriginIsolatedContextType {
  @SerialName("Isolated")
  ISOLATED,
  @SerialName("NotIsolated")
  NOT_ISOLATED,
  @SerialName("NotIsolatedFeatureDisabled")
  NOT_ISOLATED_FEATURE_DISABLED,
  UNKNOWN,
}
