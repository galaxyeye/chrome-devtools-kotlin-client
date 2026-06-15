@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Details about the security state of the page certificate.
 */
@Experimental
@Serializable
data class CertificateSecurityState(
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
  @SerialName("certificate")
  val certificate: List<String>,
  @SerialName("subjectName")
  val subjectName: String,
  @SerialName("issuer")
  val issuer: String,
  @SerialName("validFrom")
  val validFrom: Double,
  @SerialName("validTo")
  val validTo: Double,
  @SerialName("certificateNetworkError")
  @param:Optional
  val certificateNetworkError: String? = null,
  @SerialName("certificateHasWeakSignature")
  val certificateHasWeakSignature: Boolean,
  @SerialName("certificateHasSha1Signature")
  val certificateHasSha1Signature: Boolean,
  @SerialName("modernSSL")
  val modernSSL: Boolean,
  @SerialName("obsoleteSslProtocol")
  val obsoleteSslProtocol: Boolean,
  @SerialName("obsoleteSslKeyExchange")
  val obsoleteSslKeyExchange: Boolean,
  @SerialName("obsoleteSslCipher")
  val obsoleteSslCipher: Boolean,
  @SerialName("obsoleteSslSignature")
  val obsoleteSslSignature: Boolean,
)
