@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.fedcm

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Whether this is a sign-up or sign-in action for this account, i.e.
 * whether this account has ever been used to sign in to this RP before.
 */
public enum class LoginState {
  @JsonProperty("SignIn")
  SIGN_IN,
  @JsonProperty("SignUp")
  SIGN_UP,
  @JsonEnumDefaultValue
  UNKNOWN,
}
