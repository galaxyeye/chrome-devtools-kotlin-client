package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Security details about a request.
 */
public data class SecurityDetails(
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
  @field:JsonProperty("certificateId")
  public val certificateId: Int,
  @field:JsonProperty("subjectName")
  public val subjectName: String,
  @field:JsonProperty("sanList")
  public val sanList: List<String>,
  @field:JsonProperty("issuer")
  public val issuer: String,
  @field:JsonProperty("validFrom")
  public val validFrom: Double,
  @field:JsonProperty("validTo")
  public val validTo: Double,
  @field:JsonProperty("signedCertificateTimestampList")
  public val signedCertificateTimestampList: List<SignedCertificateTimestamp>,
  @field:JsonProperty("certificateTransparencyCompliance")
  public val certificateTransparencyCompliance: CertificateTransparencyCompliance,
)
