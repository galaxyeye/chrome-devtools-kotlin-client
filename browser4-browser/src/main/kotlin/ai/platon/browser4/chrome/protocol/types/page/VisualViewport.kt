@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Visual viewport position, dimensions, and scale.
 */
@Serializable
data class VisualViewport(
  @property:SerialName("offsetX")
  val offsetX: Double,
  @property:SerialName("offsetY")
  val offsetY: Double,
  @property:SerialName("pageX")
  val pageX: Double,
  @property:SerialName("pageY")
  val pageY: Double,
  @property:SerialName("clientWidth")
  val clientWidth: Double,
  @property:SerialName("clientHeight")
  val clientHeight: Double,
  @property:SerialName("scale")
  val scale: Double,
  @property:SerialName("zoom")
  @param:Optional
  val zoom: Double? = null,
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): VisualViewport = VisualViewport(
      offsetX = 0.0, offsetY = 0.0, pageX = 0.0, pageY = 0.0,
      clientWidth = 0.0, clientHeight = 0.0, scale = 1.0
    )
  }
}
