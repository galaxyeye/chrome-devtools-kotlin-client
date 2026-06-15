@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of the mouse event.
 */
@Serializable
public enum class EmulateTouchFromMouseEventType {
  @SerialName("mousePressed")
  MOUSE_PRESSED,
  @SerialName("mouseReleased")
  MOUSE_RELEASED,
  @SerialName("mouseMoved")
  MOUSE_MOVED,
  @SerialName("mouseWheel")
  MOUSE_WHEEL,
}
