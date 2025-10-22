package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.Map

/**
 * An object providing the result of a network resource load.
 */
@Experimental
public data class LoadNetworkResourcePageResult(
  @field:JsonProperty("success")
  public val success: Boolean,
  @field:JsonProperty("netError")
  @param:Optional
  public val netError: Double? = null,
  @field:JsonProperty("netErrorName")
  @param:Optional
  public val netErrorName: String? = null,
  @field:JsonProperty("httpStatusCode")
  @param:Optional
  public val httpStatusCode: Double? = null,
  @field:JsonProperty("stream")
  @param:Optional
  public val stream: String? = null,
  @field:JsonProperty("headers")
  @param:Optional
  public val headers: Map<String, Any?>? = null,
)
