@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of the touch event. TouchEnd and TouchCancel must not contain any touch points, while
 * TouchStart and TouchMove must contains at least one.
 */
@Serializable
public enum class DispatchTouchEventType {
  @SerialName("touchStart")
  TOUCH_START,
  @SerialName("touchEnd")
  TOUCH_END,
  @SerialName("touchMove")
  TOUCH_MOVE,
  @SerialName("touchCancel")
  TOUCH_CANCEL,
  UNKNOWN,
}
