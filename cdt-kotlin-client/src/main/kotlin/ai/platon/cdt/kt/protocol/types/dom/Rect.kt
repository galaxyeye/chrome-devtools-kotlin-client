package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Rectangle.
 */
data class Rect(
  @field:JsonProperty("x")
  val x: Double,
  @field:JsonProperty("y")
  val y: Double,
  @field:JsonProperty("width")
  val width: Double,
  @field:JsonProperty("height")
  val height: Double,
)
