@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webauthn

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Ctap2Version {
  @SerialName("ctap2_0")
  CTAP_2_0,
  @SerialName("ctap2_1")
  CTAP_2_1,
  UNKNOWN,
}
