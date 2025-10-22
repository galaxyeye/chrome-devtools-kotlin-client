package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Information about the cached resource.
 */
data class CachedResource(
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("type")
  val type: ResourceType,
  @field:JsonProperty("response")
  @param:Optional
  val response: Response? = null,
  @field:JsonProperty("bodySize")
  val bodySize: Double,
)
