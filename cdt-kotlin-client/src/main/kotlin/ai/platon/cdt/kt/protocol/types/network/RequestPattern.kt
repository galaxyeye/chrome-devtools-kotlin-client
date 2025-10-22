package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Request pattern for interception.
 */
@Experimental
data class RequestPattern(
  @field:JsonProperty("urlPattern")
  @param:Optional
  val urlPattern: String? = null,
  @field:JsonProperty("resourceType")
  @param:Optional
  val resourceType: ResourceType? = null,
  @field:JsonProperty("interceptionStage")
  @param:Optional
  val interceptionStage: InterceptionStage? = null,
)
