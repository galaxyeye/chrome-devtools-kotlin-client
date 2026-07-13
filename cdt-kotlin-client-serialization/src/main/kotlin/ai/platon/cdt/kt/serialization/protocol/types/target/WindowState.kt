@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.target

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The state of the target window.
 */
@Serializable
public enum class WindowState {
  @SerialName("normal")
  NORMAL,
  @SerialName("minimized")
  MINIMIZED,
  @SerialName("maximized")
  MAXIMIZED,
  @SerialName("fullscreen")
  FULLSCREEN,
  UNKNOWN,
}
