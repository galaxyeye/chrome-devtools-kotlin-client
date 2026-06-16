@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Security details about a request.
 */
@Serializable
data class SecurityDetails(
  @property:SerialName("protocol")
  val protocol: String,
  @property:SerialName("keyExchange")
  val keyExchange: String,
  @property:SerialName("keyExchangeGroup")
  @param:Optional
  val keyExchangeGroup: String? = null,
  @property:SerialName("cipher")
  val cipher: String,
  @property:SerialName("mac")
  @param:Optional
  val mac: String? = null,
  @property:SerialName("certificateId")
  val certificateId: Int,
  @property:SerialName("subjectName")
  val subjectName: String,
  @property:SerialName("sanList")
  val sanList: List<String>,
  @property:SerialName("issuer")
  val issuer: String,
  @property:SerialName("validFrom")
  val validFrom: Double,
  @property:SerialName("validTo")
  val validTo: Double,
  @property:SerialName("signedCertificateTimestampList")
  val signedCertificateTimestampList: List<SignedCertificateTimestamp>,
  @property:SerialName("certificateTransparencyCompliance")
  val certificateTransparencyCompliance: CertificateTransparencyCompliance,
)
