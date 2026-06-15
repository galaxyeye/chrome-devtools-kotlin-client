@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.console
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
}
