@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double

/**
 * Rectangle.
 */
@Serializable
data class Rect(
  @SerialName("x")
  val x: Double,
  @SerialName("y")
  val y: Double,
  @SerialName("width")
  val width: Double,
  @SerialName("height")
  val height: Double,
)
