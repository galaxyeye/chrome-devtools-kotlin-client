@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Touch/gesture events configuration. Default: current platform.
 */
@Serializable
public enum class SetEmitTouchEventsForMouseConfiguration {
  @SerialName("mobile")
  MOBILE,
  @SerialName("desktop")
  DESKTOP,
}
