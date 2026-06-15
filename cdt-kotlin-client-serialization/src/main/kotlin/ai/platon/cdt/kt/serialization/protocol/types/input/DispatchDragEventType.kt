@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of the drag event.
 */
@Serializable
public enum class DispatchDragEventType {
  @SerialName("dragEnter")
  DRAG_ENTER,
  @SerialName("dragOver")
  DRAG_OVER,
  @SerialName("drop")
  DROP,
  @SerialName("dragCancel")
  DRAG_CANCEL,
}
