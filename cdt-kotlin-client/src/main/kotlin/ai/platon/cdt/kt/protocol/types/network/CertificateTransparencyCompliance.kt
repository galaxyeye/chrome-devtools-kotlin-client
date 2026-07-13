@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Whether the request complied with Certificate Transparency policy.
 */
public enum class CertificateTransparencyCompliance {
  @JsonProperty("unknown")
  @JsonEnumDefaultValue
  UNKNOWN,
  @JsonProperty("not-compliant")
  NOT_COMPLIANT,
  @JsonProperty("compliant")
  COMPLIANT,
}
