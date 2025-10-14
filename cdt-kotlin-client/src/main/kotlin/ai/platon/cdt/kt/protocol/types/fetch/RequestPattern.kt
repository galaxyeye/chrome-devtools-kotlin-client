package ai.platon.cdt.kt.protocol.types.fetch

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.ResourceType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class RequestPattern(
  @JsonProperty("urlPattern")
  @Optional
  public val urlPattern: String? = null,
  @JsonProperty("resourceType")
  @Optional
  public val resourceType: ResourceType? = null,
  @JsonProperty("requestStage")
  @Optional
  public val requestStage: RequestStage? = null,
)
