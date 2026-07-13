@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import kotlin.Double
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * CSS Shape Outside details.
 */
@Serializable
data class ShapeOutsideInfo(
  @property:SerialName("bounds")
  val bounds: List<Double>,
  @property:SerialName("shape")
  val shape: List<JsonElement?>,
  @property:SerialName("marginShape")
  val marginShape: List<JsonElement?>,
)
