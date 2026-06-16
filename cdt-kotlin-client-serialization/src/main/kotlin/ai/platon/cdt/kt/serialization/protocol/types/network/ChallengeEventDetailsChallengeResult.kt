@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The result of a challenge.
 */
@Serializable
public enum class ChallengeEventDetailsChallengeResult {
  @SerialName("Success")
  SUCCESS,
  @SerialName("NoSessionId")
  NO_SESSION_ID,
  @SerialName("NoSessionMatch")
  NO_SESSION_MATCH,
  @SerialName("CantSetBoundCookie")
  CANT_SET_BOUND_COOKIE,
  UNKNOWN,
}
