package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Double
import kotlin.collections.List

/**
 * CSS Shape Outside details.
 */
data class ShapeOutsideInfo(
  @field:JsonProperty("bounds")
  val bounds: List<Double>,
  @field:JsonProperty("shape")
  val shape: List<Any?>,
  @field:JsonProperty("marginShape")
  val marginShape: List<Any?>,
)
