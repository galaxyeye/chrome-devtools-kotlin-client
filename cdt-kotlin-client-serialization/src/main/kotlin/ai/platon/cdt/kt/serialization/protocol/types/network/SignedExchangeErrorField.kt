@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Field type for a signed exchange related error.
 */
@Serializable
public enum class SignedExchangeErrorField {
  @SerialName("signatureSig")
  SIGNATURE_SIG,
  @SerialName("signatureIntegrity")
  SIGNATURE_INTEGRITY,
  @SerialName("signatureCertUrl")
  SIGNATURE_CERT_URL,
  @SerialName("signatureCertSha256")
  SIGNATURE_CERT_SHA_256,
  @SerialName("signatureValidityUrl")
  SIGNATURE_VALIDITY_URL,
  @SerialName("signatureTimestamps")
  SIGNATURE_TIMESTAMPS,
  UNKNOWN,
}
