@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Box model.
 */
@Serializable
data class BoxModel(
  @SerialName("content")
  val content: List<Double>,
  @SerialName("padding")
  val padding: List<Double>,
  @SerialName("border")
  val border: List<Double>,
  @SerialName("margin")
  val margin: List<Double>,
  @SerialName("width")
  val width: Int,
  @SerialName("height")
  val height: Int,
  @SerialName("shapeOutside")
  @param:Optional
  val shapeOutside: ShapeOutsideInfo? = null,
)
