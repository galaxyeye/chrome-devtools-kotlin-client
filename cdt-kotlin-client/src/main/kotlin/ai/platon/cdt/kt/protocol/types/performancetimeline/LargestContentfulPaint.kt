package ai.platon.cdt.kt.protocol.types.performancetimeline

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * See https://github.com/WICG/LargestContentfulPaint and largest_contentful_paint.idl
 */
data class LargestContentfulPaint(
  @field:JsonProperty("renderTime")
  val renderTime: Double,
  @field:JsonProperty("loadTime")
  val loadTime: Double,
  @field:JsonProperty("size")
  val size: Double,
  @field:JsonProperty("elementId")
  @param:Optional
  val elementId: String? = null,
  @field:JsonProperty("url")
  @param:Optional
  val url: String? = null,
  @field:JsonProperty("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
