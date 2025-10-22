package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Information about a signed exchange response.
 */
@Experimental
public data class SignedExchangeInfo(
  @field:JsonProperty("outerResponse")
  public val outerResponse: Response,
  @field:JsonProperty("header")
  @param:Optional
  public val `header`: SignedExchangeHeader? = null,
  @field:JsonProperty("securityDetails")
  @param:Optional
  public val securityDetails: SecurityDetails? = null,
  @field:JsonProperty("errors")
  @param:Optional
  public val errors: List<SignedExchangeError>? = null,
)
