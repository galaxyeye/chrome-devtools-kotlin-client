package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Viewport for capturing screenshot.
 */
public data class Viewport(
  @field:JsonProperty("x")
  public val x: Double,
  @field:JsonProperty("y")
  public val y: Double,
  @field:JsonProperty("width")
  public val width: Double,
  @field:JsonProperty("height")
  public val height: Double,
  @field:JsonProperty("scale")
  public val scale: Double,
)
