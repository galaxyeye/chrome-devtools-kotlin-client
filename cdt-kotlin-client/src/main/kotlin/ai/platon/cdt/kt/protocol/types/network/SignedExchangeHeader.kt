package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Information about a signed exchange header.
 * https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#cbor-representation
 */
@Experimental
public data class SignedExchangeHeader(
  @field:JsonProperty("requestUrl")
  public val requestUrl: String,
  @field:JsonProperty("responseCode")
  public val responseCode: Int,
  @field:JsonProperty("responseHeaders")
  public val responseHeaders: Map<String, Any?>,
  @field:JsonProperty("signatures")
  public val signatures: List<SignedExchangeSignature>,
  @field:JsonProperty("headerIntegrity")
  public val headerIntegrity: String,
)
