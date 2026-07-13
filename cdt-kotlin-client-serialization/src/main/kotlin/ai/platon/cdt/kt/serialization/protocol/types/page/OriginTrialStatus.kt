@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Status for an Origin Trial.
 */
@Serializable
public enum class OriginTrialStatus {
  @SerialName("Enabled")
  ENABLED,
  @SerialName("ValidTokenNotProvided")
  VALID_TOKEN_NOT_PROVIDED,
  @SerialName("OSNotSupported")
  OS_NOT_SUPPORTED,
  @SerialName("TrialNotAllowed")
  TRIAL_NOT_ALLOWED,
  UNKNOWN,
}
