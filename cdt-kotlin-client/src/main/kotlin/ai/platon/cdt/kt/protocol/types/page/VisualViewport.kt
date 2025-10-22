package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Visual viewport position, dimensions, and scale.
 */
public data class VisualViewport(
  @field:JsonProperty("offsetX")
  public val offsetX: Double,
  @field:JsonProperty("offsetY")
  public val offsetY: Double,
  @field:JsonProperty("pageX")
  public val pageX: Double,
  @field:JsonProperty("pageY")
  public val pageY: Double,
  @field:JsonProperty("clientWidth")
  public val clientWidth: Double,
  @field:JsonProperty("clientHeight")
  public val clientHeight: Double,
  @field:JsonProperty("scale")
  public val scale: Double,
  @field:JsonProperty("zoom")
  @param:Optional
  public val zoom: Double? = null,
)
