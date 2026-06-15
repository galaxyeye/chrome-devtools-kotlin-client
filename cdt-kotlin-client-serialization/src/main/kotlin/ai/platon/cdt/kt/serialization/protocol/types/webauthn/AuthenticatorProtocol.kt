@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webauthn
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class AuthenticatorProtocol {
  @SerialName("u2f")
  U_2F,
  @SerialName("ctap2")
  CTAP_2,
}
