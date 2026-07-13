@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.security

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The security level of a page or resource.
 */
@Serializable
public enum class SecurityState {
  @SerialName("unknown")
  UNKNOWN,
  @SerialName("neutral")
  NEUTRAL,
  @SerialName("insecure")
  INSECURE,
  @SerialName("secure")
  SECURE,
  @SerialName("info")
  INFO,
  @SerialName("insecure-broken")
  INSECURE_BROKEN,
}
