@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Viewport for capturing screenshot.
 */
@Serializable
data class Viewport(
  @property:SerialName("x")
  val x: Double,
  @property:SerialName("y")
  val y: Double,
  @property:SerialName("width")
  val width: Double,
  @property:SerialName("height")
  val height: Double,
  @property:SerialName("scale")
  val scale: Double,
)
