@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.events.input

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.types.input.DragData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Emitted only when `Input.setInterceptDrags` is enabled. Use this data with `Input.dispatchDragEvent` to
 * restore normal drag and drop behavior.
 */
@Serializable
@Experimental
data class DragIntercepted(
  @property:SerialName("data")
  val `data`: DragData,
)
