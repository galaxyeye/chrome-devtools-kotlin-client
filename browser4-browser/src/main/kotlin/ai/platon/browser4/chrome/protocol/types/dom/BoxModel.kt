@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.dom

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
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
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): BoxModel = BoxModel(
      content = emptyList(), padding = emptyList(), border = emptyList(),
      margin = emptyList(), width = 0, height = 0
    )
  }
}
