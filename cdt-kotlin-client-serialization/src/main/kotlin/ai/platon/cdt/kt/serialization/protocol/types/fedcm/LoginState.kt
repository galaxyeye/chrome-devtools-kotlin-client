@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fedcm

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Whether this is a sign-up or sign-in action for this account, i.e.
 * whether this account has ever been used to sign in to this RP before.
 */
@Serializable
public enum class LoginState {
  @SerialName("SignIn")
  SIGN_IN,
  @SerialName("SignUp")
  SIGN_UP,
  UNKNOWN,
}
