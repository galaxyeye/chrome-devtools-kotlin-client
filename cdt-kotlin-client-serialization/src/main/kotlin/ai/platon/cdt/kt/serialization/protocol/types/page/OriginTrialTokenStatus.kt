@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Origin Trial(https://www.chromium.org/blink/origin-trials) support.
 * Status for an Origin Trial token.
 */
@Serializable
public enum class OriginTrialTokenStatus {
  @SerialName("Success")
  SUCCESS,
  @SerialName("NotSupported")
  NOT_SUPPORTED,
  @SerialName("Insecure")
  INSECURE,
  @SerialName("Expired")
  EXPIRED,
  @SerialName("WrongOrigin")
  WRONG_ORIGIN,
  @SerialName("InvalidSignature")
  INVALID_SIGNATURE,
  @SerialName("Malformed")
  MALFORMED,
  @SerialName("WrongVersion")
  WRONG_VERSION,
  @SerialName("FeatureDisabled")
  FEATURE_DISABLED,
  @SerialName("TokenDisabled")
  TOKEN_DISABLED,
  @SerialName("FeatureDisabledForUser")
  FEATURE_DISABLED_FOR_USER,
  @SerialName("UnknownTrial")
  UNKNOWN_TRIAL,
  UNKNOWN,
}
