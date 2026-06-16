@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the source scheme of the origin that originally set the cookie.
 * A value of "Unset" allows protocol clients to emulate legacy cookie scope for the scheme.
 * This is a temporary ability and it will be removed in the future.
 */
@Serializable
public enum class CookieSourceScheme {
  @SerialName("Unset")
  UNSET,
  @SerialName("NonSecure")
  NON_SECURE,
  @SerialName("Secure")
  SECURE,
  UNKNOWN,
}
