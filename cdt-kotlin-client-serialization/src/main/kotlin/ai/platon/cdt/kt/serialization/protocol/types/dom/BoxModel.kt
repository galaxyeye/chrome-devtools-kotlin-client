@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Box model.
 */
@Serializable
data class BoxModel(
  @property:SerialName("content")
  val content: List<Double>,
  @property:SerialName("padding")
  val padding: List<Double>,
  @property:SerialName("border")
  val border: List<Double>,
  @property:SerialName("margin")
  val margin: List<Double>,
  @property:SerialName("width")
  val width: Int,
  @property:SerialName("height")
  val height: Int,
  @property:SerialName("shapeOutside")
  @param:Optional
  val shapeOutside: ShapeOutsideInfo? = null,
)
