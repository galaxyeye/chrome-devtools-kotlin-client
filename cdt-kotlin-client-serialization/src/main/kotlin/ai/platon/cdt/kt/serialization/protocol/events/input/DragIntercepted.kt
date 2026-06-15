@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.input
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.input.DragData

/**
 * Emitted only when `Input.setInterceptDrags` is enabled. Use this data with `Input.dispatchDragEvent` to
 * restore normal drag and drop behavior.
 */
@Experimental
@Serializable
data class DragIntercepted(
  @SerialName("data")
  val `data`: DragData,
)
