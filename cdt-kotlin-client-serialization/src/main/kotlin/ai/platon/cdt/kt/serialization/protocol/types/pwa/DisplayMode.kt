@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.pwa

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * If user prefers opening the app in browser or an app window.
 */
@Serializable
public enum class DisplayMode {
  @SerialName("standalone")
  STANDALONE,
  @SerialName("browser")
  BROWSER,
  UNKNOWN,
}
