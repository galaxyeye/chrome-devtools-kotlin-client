@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Pause on exceptions mode.
 */
@Serializable
public enum class SetPauseOnExceptionsState {
  @SerialName("none")
  NONE,
  @SerialName("uncaught")
  UNCAUGHT,
  @SerialName("all")
  ALL,
  UNKNOWN,
}
