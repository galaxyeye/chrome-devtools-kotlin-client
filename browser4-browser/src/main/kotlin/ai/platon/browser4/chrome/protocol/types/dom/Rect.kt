@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.dom

import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Rectangle.
 */
@Serializable
data class Rect(
  @property:SerialName("x")
  val x: Double,
  @property:SerialName("y")
  val y: Double,
  @property:SerialName("width")
  val width: Double,
  @property:SerialName("height")
  val height: Double,
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): Rect = Rect(x = 0.0, y = 0.0, width = 0.0, height = 0.0)
  }
}
