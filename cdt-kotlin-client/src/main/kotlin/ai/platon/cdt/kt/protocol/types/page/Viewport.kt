package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Viewport for capturing screenshot.
 */
data class Viewport(
  @field:JsonProperty("x")
  val x: Double,
  @field:JsonProperty("y")
  val y: Double,
  @field:JsonProperty("width")
  val width: Double,
  @field:JsonProperty("height")
  val height: Double,
  @field:JsonProperty("scale")
  val scale: Double,
)
