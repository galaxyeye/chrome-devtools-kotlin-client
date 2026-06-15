@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Details of a signed certificate timestamp (SCT).
 */
@Serializable
data class SignedCertificateTimestamp(
  @SerialName("status")
  val status: String,
  @SerialName("origin")
  val origin: String,
  @SerialName("logDescription")
  val logDescription: String,
  @SerialName("logId")
  val logId: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("hashAlgorithm")
  val hashAlgorithm: String,
  @SerialName("signatureAlgorithm")
  val signatureAlgorithm: String,
  @SerialName("signatureData")
  val signatureData: String,
)
