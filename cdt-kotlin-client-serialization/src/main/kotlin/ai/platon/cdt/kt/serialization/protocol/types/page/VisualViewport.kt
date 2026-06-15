@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double

/**
 * Visual viewport position, dimensions, and scale.
 */
@Serializable
data class VisualViewport(
  @SerialName("offsetX")
  val offsetX: Double,
  @SerialName("offsetY")
  val offsetY: Double,
  @SerialName("pageX")
  val pageX: Double,
  @SerialName("pageY")
  val pageY: Double,
  @SerialName("clientWidth")
  val clientWidth: Double,
  @SerialName("clientHeight")
  val clientHeight: Double,
  @SerialName("scale")
  val scale: Double,
  @SerialName("zoom")
  @param:Optional
  val zoom: Double? = null,
)
