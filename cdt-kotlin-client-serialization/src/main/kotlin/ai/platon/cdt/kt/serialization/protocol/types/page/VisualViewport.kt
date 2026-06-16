@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
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
)
