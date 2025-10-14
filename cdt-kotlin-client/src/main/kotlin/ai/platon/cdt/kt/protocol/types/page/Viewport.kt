package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Viewport for capturing screenshot.
 */
public data class Viewport(
  @JsonProperty("x")
  public val x: Double,
  @JsonProperty("y")
  public val y: Double,
  @JsonProperty("width")
  public val width: Double,
  @JsonProperty("height")
  public val height: Double,
  @JsonProperty("scale")
  public val scale: Double,
)
