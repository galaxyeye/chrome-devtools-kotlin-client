@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The result of a challenge.
 */
public enum class ChallengeEventDetailsChallengeResult {
  @JsonProperty("Success")
  SUCCESS,
  @JsonProperty("NoSessionId")
  NO_SESSION_ID,
  @JsonProperty("NoSessionMatch")
  NO_SESSION_MATCH,
  @JsonProperty("CantSetBoundCookie")
  CANT_SET_BOUND_COOKIE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
