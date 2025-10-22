package ai.platon.cdt.kt.protocol.types.dom

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Box model.
 */
public data class BoxModel(
  @field:JsonProperty("content")
  public val content: List<Double>,
  @field:JsonProperty("padding")
  public val padding: List<Double>,
  @field:JsonProperty("border")
  public val border: List<Double>,
  @field:JsonProperty("margin")
  public val margin: List<Double>,
  @field:JsonProperty("width")
  public val width: Int,
  @field:JsonProperty("height")
  public val height: Int,
  @field:JsonProperty("shapeOutside")
  @param:Optional
  public val shapeOutside: ShapeOutsideInfo? = null,
)
