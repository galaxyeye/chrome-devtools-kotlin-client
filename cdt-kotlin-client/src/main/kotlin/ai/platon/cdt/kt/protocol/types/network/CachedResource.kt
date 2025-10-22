package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Information about the cached resource.
 */
public data class CachedResource(
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("type")
  public val type: ResourceType,
  @field:JsonProperty("response")
  @param:Optional
  public val response: Response? = null,
  @field:JsonProperty("bodySize")
  public val bodySize: Double,
)
