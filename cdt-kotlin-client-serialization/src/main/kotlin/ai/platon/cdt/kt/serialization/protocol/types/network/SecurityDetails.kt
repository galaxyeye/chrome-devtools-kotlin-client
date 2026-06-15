@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Security details about a request.
 */
@Serializable
data class SecurityDetails(
  @SerialName("protocol")
  val protocol: String,
  @SerialName("keyExchange")
  val keyExchange: String,
  @SerialName("keyExchangeGroup")
  @param:Optional
  val keyExchangeGroup: String? = null,
  @SerialName("cipher")
  val cipher: String,
  @SerialName("mac")
  @param:Optional
  val mac: String? = null,
  @SerialName("certificateId")
  val certificateId: Int,
  @SerialName("subjectName")
  val subjectName: String,
  @SerialName("sanList")
  val sanList: List<String>,
  @SerialName("issuer")
  val issuer: String,
  @SerialName("validFrom")
  val validFrom: Double,
  @SerialName("validTo")
  val validTo: Double,
  @SerialName("signedCertificateTimestampList")
  val signedCertificateTimestampList: List<SignedCertificateTimestamp>,
  @SerialName("certificateTransparencyCompliance")
  val certificateTransparencyCompliance: CertificateTransparencyCompliance,
)
