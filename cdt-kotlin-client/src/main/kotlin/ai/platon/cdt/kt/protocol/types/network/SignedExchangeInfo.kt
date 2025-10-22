package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Information about a signed exchange response.
 */
@Experimental
data class SignedExchangeInfo(
  @field:JsonProperty("outerResponse")
  val outerResponse: Response,
  @field:JsonProperty("header")
  @param:Optional
  val `header`: SignedExchangeHeader? = null,
  @field:JsonProperty("securityDetails")
  @param:Optional
  val securityDetails: SecurityDetails? = null,
  @field:JsonProperty("errors")
  @param:Optional
  val errors: List<SignedExchangeError>? = null,
)
