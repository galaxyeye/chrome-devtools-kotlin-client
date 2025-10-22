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
data class SecurityDetails(
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
  @field:JsonProperty("certificateId")
  val certificateId: Int,
  @field:JsonProperty("subjectName")
  val subjectName: String,
  @field:JsonProperty("sanList")
  val sanList: List<String>,
  @field:JsonProperty("issuer")
  val issuer: String,
  @field:JsonProperty("validFrom")
  val validFrom: Double,
  @field:JsonProperty("validTo")
  val validTo: Double,
  @field:JsonProperty("signedCertificateTimestampList")
  val signedCertificateTimestampList: List<SignedCertificateTimestamp>,
  @field:JsonProperty("certificateTransparencyCompliance")
  val certificateTransparencyCompliance: CertificateTransparencyCompliance,
)
