package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Request pattern for interception.
 */
@Experimental
public data class RequestPattern(
  @field:JsonProperty("urlPattern")
  @param:Optional
  public val urlPattern: String? = null,
  @field:JsonProperty("resourceType")
  @param:Optional
  public val resourceType: ResourceType? = null,
  @field:JsonProperty("interceptionStage")
  @param:Optional
  public val interceptionStage: InterceptionStage? = null,
)
