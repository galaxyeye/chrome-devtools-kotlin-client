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
data class LoadNetworkResourcePageResult(
  @field:JsonProperty("success")
  val success: Boolean,
  @field:JsonProperty("netError")
  @param:Optional
  val netError: Double? = null,
  @field:JsonProperty("netErrorName")
  @param:Optional
  val netErrorName: String? = null,
  @field:JsonProperty("httpStatusCode")
  @param:Optional
  val httpStatusCode: Double? = null,
  @field:JsonProperty("stream")
  @param:Optional
  val stream: String? = null,
  @field:JsonProperty("headers")
  @param:Optional
  val headers: Map<String, Any?>? = null,
)
