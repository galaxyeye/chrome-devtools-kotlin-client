@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the cookie's 'SameSite' status:
 * https://tools.ietf.org/html/draft-west-first-party-cookies
 */
@Serializable
public enum class CookieSameSite {
  @SerialName("Strict")
  STRICT,
  @SerialName("Lax")
  LAX,
  @SerialName("None")
  NONE,
  UNKNOWN,
}
