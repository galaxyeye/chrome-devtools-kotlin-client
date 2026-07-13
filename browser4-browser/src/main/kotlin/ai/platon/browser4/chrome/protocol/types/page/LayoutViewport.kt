@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

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
) {
  companion object {
    /** Fallback instance used when CDP deserialization fails due to protocol mismatch. */
    fun degraded(): LayoutViewport = LayoutViewport(pageX = 0, pageY = 0, clientWidth = 0, clientHeight = 0)
  }
}
