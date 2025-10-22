package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Information about a signed exchange signature.
 * https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#rfc.section.3.1
 */
@Experimental
data class SignedExchangeSignature(
  @field:JsonProperty("label")
  val label: String,
  @field:JsonProperty("signature")
  val signature: String,
  @field:JsonProperty("integrity")
  val integrity: String,
  @field:JsonProperty("certUrl")
  @param:Optional
  val certUrl: String? = null,
  @field:JsonProperty("certSha256")
  @param:Optional
  val certSha256: String? = null,
  @field:JsonProperty("validityUrl")
  val validityUrl: String,
  @field:JsonProperty("date")
  val date: Int,
  @field:JsonProperty("expires")
  val expires: Int,
  @field:JsonProperty("certificates")
  @param:Optional
  val certificates: List<String>? = null,
)
