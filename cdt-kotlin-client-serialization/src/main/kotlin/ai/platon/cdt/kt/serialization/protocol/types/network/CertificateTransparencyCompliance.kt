@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Whether the request complied with Certificate Transparency policy.
 */
@Serializable
public enum class CertificateTransparencyCompliance {
  @SerialName("unknown")
  UNKNOWN,
  @SerialName("not-compliant")
  NOT_COMPLIANT,
  @SerialName("compliant")
  COMPLIANT,
}
