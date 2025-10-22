package ai.platon.cdt.kt.protocol.types.storage

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Pair of issuer origin and number of available (signed, but not used) Trust
 * Tokens from that issuer.
 */
@Experimental
public data class TrustTokens(
  @field:JsonProperty("issuerOrigin")
  public val issuerOrigin: String,
  @field:JsonProperty("count")
  public val count: Double,
)
