@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Any
import kotlin.Double
import kotlin.collections.List

/**
 * CSS Shape Outside details.
 */
@Serializable
data class ShapeOutsideInfo(
  @SerialName("bounds")
  val bounds: List<Double>,
  @SerialName("shape")
  val shape: List<Any?>,
  @SerialName("marginShape")
  val marginShape: List<Any?>,
)
