package ai.platon.cdt.kt.protocol.types.dom

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Box model.
 */
data class BoxModel(
  @field:JsonProperty("content")
  val content: List<Double>,
  @field:JsonProperty("padding")
  val padding: List<Double>,
  @field:JsonProperty("border")
  val border: List<Double>,
  @field:JsonProperty("margin")
  val margin: List<Double>,
  @field:JsonProperty("width")
  val width: Int,
  @field:JsonProperty("height")
  val height: Int,
  @field:JsonProperty("shapeOutside")
  @param:Optional
  val shapeOutside: ShapeOutsideInfo? = null,
)
