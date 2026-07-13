@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fetch

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Source of the authentication challenge.
 */
@Serializable
public enum class AuthChallengeSource {
  @SerialName("Server")
  SERVER,
  @SerialName("Proxy")
  PROXY,
  UNKNOWN,
}
