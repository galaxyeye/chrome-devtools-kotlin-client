package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Details of a signed certificate timestamp (SCT).
 */
public data class SignedCertificateTimestamp(
  @field:JsonProperty("status")
  public val status: String,
  @field:JsonProperty("origin")
  public val origin: String,
  @field:JsonProperty("logDescription")
  public val logDescription: String,
  @field:JsonProperty("logId")
  public val logId: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("hashAlgorithm")
  public val hashAlgorithm: String,
  @field:JsonProperty("signatureAlgorithm")
  public val signatureAlgorithm: String,
  @field:JsonProperty("signatureData")
  public val signatureData: String,
)
