@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Layout viewport position and dimensions.
 */
@Serializable
data class LayoutViewport(
  @SerialName("pageX")
  val pageX: Int,
  @SerialName("pageY")
  val pageY: Int,
  @SerialName("clientWidth")
  val clientWidth: Int,
  @SerialName("clientHeight")
  val clientHeight: Int,
)
