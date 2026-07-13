@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fetch

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The decision on what to do in response to the authorization challenge.  Default means
 * deferring to the default behavior of the net stack, which will likely either the Cancel
 * authentication or display a popup dialog box.
 */
@Serializable
public enum class AuthChallengeResponseResponse {
  @SerialName("Default")
  DEFAULT,
  @SerialName("CancelAuth")
  CANCEL_AUTH,
  @SerialName("ProvideCredentials")
  PROVIDE_CREDENTIALS,
  UNKNOWN,
}
