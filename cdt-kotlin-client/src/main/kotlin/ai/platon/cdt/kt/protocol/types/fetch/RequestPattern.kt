package ai.platon.cdt.kt.protocol.types.fetch

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.ResourceType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class RequestPattern(
  @field:JsonProperty("urlPattern")
  @param:Optional
  public val urlPattern: String? = null,
  @field:JsonProperty("resourceType")
  @param:Optional
  public val resourceType: ResourceType? = null,
  @field:JsonProperty("requestStage")
  @param:Optional
  public val requestStage: RequestStage? = null,
)
