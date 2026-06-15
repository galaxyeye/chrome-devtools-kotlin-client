@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double

/**
 * Viewport for capturing screenshot.
 */
@Serializable
data class Viewport(
  @SerialName("x")
  val x: Double,
  @SerialName("y")
  val y: Double,
  @SerialName("width")
  val width: Double,
  @SerialName("height")
  val height: Double,
  @SerialName("scale")
  val scale: Double,
)
