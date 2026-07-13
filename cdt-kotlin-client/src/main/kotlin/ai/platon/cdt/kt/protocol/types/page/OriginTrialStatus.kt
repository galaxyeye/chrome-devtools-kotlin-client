@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Status for an Origin Trial.
 */
public enum class OriginTrialStatus {
  @JsonProperty("Enabled")
  ENABLED,
  @JsonProperty("ValidTokenNotProvided")
  VALID_TOKEN_NOT_PROVIDED,
  @JsonProperty("OSNotSupported")
  OS_NOT_SUPPORTED,
  @JsonProperty("TrialNotAllowed")
  TRIAL_NOT_ALLOWED,
  @JsonEnumDefaultValue
  UNKNOWN,
}
