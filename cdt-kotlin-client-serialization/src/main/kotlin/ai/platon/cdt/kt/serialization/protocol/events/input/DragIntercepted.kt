@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.input

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.input.DragData
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
