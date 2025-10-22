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
public data class CertificateSecurityState(
  @field:JsonProperty("protocol")
  public val protocol: String,
  @field:JsonProperty("keyExchange")
  public val keyExchange: String,
  @field:JsonProperty("keyExchangeGroup")
  @param:Optional
  public val keyExchangeGroup: String? = null,
  @field:JsonProperty("cipher")
  public val cipher: String,
  @field:JsonProperty("mac")
  @param:Optional
  public val mac: String? = null,
  @field:JsonProperty("certificate")
  public val certificate: List<String>,
  @field:JsonProperty("subjectName")
  public val subjectName: String,
  @field:JsonProperty("issuer")
  public val issuer: String,
  @field:JsonProperty("validFrom")
  public val validFrom: Double,
  @field:JsonProperty("validTo")
  public val validTo: Double,
  @field:JsonProperty("certificateNetworkError")
  @param:Optional
  public val certificateNetworkError: String? = null,
  @field:JsonProperty("certificateHasWeakSignature")
  public val certificateHasWeakSignature: Boolean,
  @field:JsonProperty("certificateHasSha1Signature")
  public val certificateHasSha1Signature: Boolean,
  @field:JsonProperty("modernSSL")
  public val modernSSL: Boolean,
  @field:JsonProperty("obsoleteSslProtocol")
  public val obsoleteSslProtocol: Boolean,
  @field:JsonProperty("obsoleteSslKeyExchange")
  public val obsoleteSslKeyExchange: Boolean,
  @field:JsonProperty("obsoleteSslCipher")
  public val obsoleteSslCipher: Boolean,
  @field:JsonProperty("obsoleteSslSignature")
  public val obsoleteSslSignature: Boolean,
)
