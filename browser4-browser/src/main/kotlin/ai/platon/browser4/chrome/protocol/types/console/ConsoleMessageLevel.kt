@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.console

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Message severity.
 */
@Serializable
public enum class ConsoleMessageLevel {
  @SerialName("log")
  LOG,
  @SerialName("warning")
  WARNING,
  @SerialName("error")
  ERROR,
  @SerialName("debug")
  DEBUG,
  @SerialName("info")
  INFO,
  UNKNOWN,
}
