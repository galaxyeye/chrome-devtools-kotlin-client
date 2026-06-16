@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details of a signed certificate timestamp (SCT).
 */
@Serializable
data class SignedCertificateTimestamp(
  @property:SerialName("status")
  val status: String,
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("logDescription")
  val logDescription: String,
  @property:SerialName("logId")
  val logId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("hashAlgorithm")
  val hashAlgorithm: String,
  @property:SerialName("signatureAlgorithm")
  val signatureAlgorithm: String,
  @property:SerialName("signatureData")
  val signatureData: String,
)
