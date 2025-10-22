package ai.platon.cdt.kt.protocol.types.security

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Details about the security state of the page certificate.
 */
@Experimental
data class CertificateSecurityState(
  @field:JsonProperty("protocol")
  val protocol: String,
  @field:JsonProperty("keyExchange")
  val keyExchange: String,
  @field:JsonProperty("keyExchangeGroup")
  @param:Optional
  val keyExchangeGroup: String? = null,
  @field:JsonProperty("cipher")
  val cipher: String,
  @field:JsonProperty("mac")
  @param:Optional
  val mac: String? = null,
  @field:JsonProperty("certificate")
  val certificate: List<String>,
  @field:JsonProperty("subjectName")
  val subjectName: String,
  @field:JsonProperty("issuer")
  val issuer: String,
  @field:JsonProperty("validFrom")
  val validFrom: Double,
  @field:JsonProperty("validTo")
  val validTo: Double,
  @field:JsonProperty("certificateNetworkError")
  @param:Optional
  val certificateNetworkError: String? = null,
  @field:JsonProperty("certificateHasWeakSignature")
  val certificateHasWeakSignature: Boolean,
  @field:JsonProperty("certificateHasSha1Signature")
  val certificateHasSha1Signature: Boolean,
  @field:JsonProperty("modernSSL")
  val modernSSL: Boolean,
  @field:JsonProperty("obsoleteSslProtocol")
  val obsoleteSslProtocol: Boolean,
  @field:JsonProperty("obsoleteSslKeyExchange")
  val obsoleteSslKeyExchange: Boolean,
  @field:JsonProperty("obsoleteSslCipher")
  val obsoleteSslCipher: Boolean,
  @field:JsonProperty("obsoleteSslSignature")
  val obsoleteSslSignature: Boolean,
)
