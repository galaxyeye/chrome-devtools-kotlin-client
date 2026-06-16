@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details about the security state of the page certificate.
 */
@Serializable
@Experimental
data class CertificateSecurityState(
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
  @property:SerialName("certificate")
  val certificate: List<String>,
  @property:SerialName("subjectName")
  val subjectName: String,
  @property:SerialName("issuer")
  val issuer: String,
  @property:SerialName("validFrom")
  val validFrom: Double,
  @property:SerialName("validTo")
  val validTo: Double,
  @property:SerialName("certificateNetworkError")
  @param:Optional
  val certificateNetworkError: String? = null,
  @property:SerialName("certificateHasWeakSignature")
  val certificateHasWeakSignature: Boolean,
  @property:SerialName("certificateHasSha1Signature")
  val certificateHasSha1Signature: Boolean,
  @property:SerialName("modernSSL")
  val modernSSL: Boolean,
  @property:SerialName("obsoleteSslProtocol")
  val obsoleteSslProtocol: Boolean,
  @property:SerialName("obsoleteSslKeyExchange")
  val obsoleteSslKeyExchange: Boolean,
  @property:SerialName("obsoleteSslCipher")
  val obsoleteSslCipher: Boolean,
  @property:SerialName("obsoleteSslSignature")
  val obsoleteSslSignature: Boolean,
)
