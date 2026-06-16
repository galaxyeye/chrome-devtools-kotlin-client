@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Layout viewport position and dimensions.
 */
@Serializable
data class LayoutViewport(
  @property:SerialName("pageX")
  val pageX: Int,
  @property:SerialName("pageY")
  val pageY: Int,
  @property:SerialName("clientWidth")
  val clientWidth: Int,
  @property:SerialName("clientHeight")
  val clientHeight: Int,
)
