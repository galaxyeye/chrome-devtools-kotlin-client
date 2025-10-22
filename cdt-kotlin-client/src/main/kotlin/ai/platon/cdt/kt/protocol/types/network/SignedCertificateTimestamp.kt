package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Details of a signed certificate timestamp (SCT).
 */
data class SignedCertificateTimestamp(
  @field:JsonProperty("status")
  val status: String,
  @field:JsonProperty("origin")
  val origin: String,
  @field:JsonProperty("logDescription")
  val logDescription: String,
  @field:JsonProperty("logId")
  val logId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("hashAlgorithm")
  val hashAlgorithm: String,
  @field:JsonProperty("signatureAlgorithm")
  val signatureAlgorithm: String,
  @field:JsonProperty("signatureData")
  val signatureData: String,
)
