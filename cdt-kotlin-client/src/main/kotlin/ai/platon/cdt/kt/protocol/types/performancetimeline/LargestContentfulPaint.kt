package ai.platon.cdt.kt.protocol.types.performancetimeline

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * See https://github.com/WICG/LargestContentfulPaint and largest_contentful_paint.idl
 */
public data class LargestContentfulPaint(
  @field:JsonProperty("renderTime")
  public val renderTime: Double,
  @field:JsonProperty("loadTime")
  public val loadTime: Double,
  @field:JsonProperty("size")
  public val size: Double,
  @field:JsonProperty("elementId")
  @param:Optional
  public val elementId: String? = null,
  @field:JsonProperty("url")
  @param:Optional
  public val url: String? = null,
  @field:JsonProperty("nodeId")
  @param:Optional
  public val nodeId: Int? = null,
)
