package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Visual viewport position, dimensions, and scale.
 */
data class VisualViewport(
  @field:JsonProperty("offsetX")
  val offsetX: Double,
  @field:JsonProperty("offsetY")
  val offsetY: Double,
  @field:JsonProperty("pageX")
  val pageX: Double,
  @field:JsonProperty("pageY")
  val pageY: Double,
  @field:JsonProperty("clientWidth")
  val clientWidth: Double,
  @field:JsonProperty("clientHeight")
  val clientHeight: Double,
  @field:JsonProperty("scale")
  val scale: Double,
  @field:JsonProperty("zoom")
  @param:Optional
  val zoom: Double? = null,
)
