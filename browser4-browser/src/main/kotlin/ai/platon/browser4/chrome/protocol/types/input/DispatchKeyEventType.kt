@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.input

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of the key event.
 */
@Serializable
public enum class DispatchKeyEventType {
  @SerialName("keyDown")
  KEY_DOWN,
  @SerialName("keyUp")
  KEY_UP,
  @SerialName("rawKeyDown")
  RAW_KEY_DOWN,
  @SerialName("char")
  CHAR,
  UNKNOWN,
}
