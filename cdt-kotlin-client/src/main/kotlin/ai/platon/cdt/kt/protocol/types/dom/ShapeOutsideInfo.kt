package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Double
import kotlin.collections.List

/**
 * CSS Shape Outside details.
 */
public data class ShapeOutsideInfo(
  @field:JsonProperty("bounds")
  public val bounds: List<Double>,
  @field:JsonProperty("shape")
  public val shape: List<Any?>,
  @field:JsonProperty("marginShape")
  public val marginShape: List<Any?>,
)
