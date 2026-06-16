@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Reason for rectangle to force scrolling on the main thread
 */
@Serializable
public enum class ScrollRectType {
  @SerialName("RepaintsOnScroll")
  REPAINTS_ON_SCROLL,
  @SerialName("TouchEventHandler")
  TOUCH_EVENT_HANDLER,
  @SerialName("WheelEventHandler")
  WHEEL_EVENT_HANDLER,
  UNKNOWN,
}
