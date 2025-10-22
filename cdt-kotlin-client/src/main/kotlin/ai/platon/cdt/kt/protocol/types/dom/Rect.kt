package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Rectangle.
 */
public data class Rect(
  @field:JsonProperty("x")
  public val x: Double,
  @field:JsonProperty("y")
  public val y: Double,
  @field:JsonProperty("width")
  public val width: Double,
  @field:JsonProperty("height")
  public val height: Double,
)
