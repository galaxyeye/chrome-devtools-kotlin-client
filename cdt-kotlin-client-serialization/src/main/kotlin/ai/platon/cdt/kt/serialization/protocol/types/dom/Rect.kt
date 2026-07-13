@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

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
)
