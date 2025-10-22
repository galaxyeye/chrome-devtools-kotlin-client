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
public data class SignedExchangeSignature(
  @field:JsonProperty("label")
  public val label: String,
  @field:JsonProperty("signature")
  public val signature: String,
  @field:JsonProperty("integrity")
  public val integrity: String,
  @field:JsonProperty("certUrl")
  @param:Optional
  public val certUrl: String? = null,
  @field:JsonProperty("certSha256")
  @param:Optional
  public val certSha256: String? = null,
  @field:JsonProperty("validityUrl")
  public val validityUrl: String,
  @field:JsonProperty("date")
  public val date: Int,
  @field:JsonProperty("expires")
  public val expires: Int,
  @field:JsonProperty("certificates")
  @param:Optional
  public val certificates: List<String>? = null,
)
