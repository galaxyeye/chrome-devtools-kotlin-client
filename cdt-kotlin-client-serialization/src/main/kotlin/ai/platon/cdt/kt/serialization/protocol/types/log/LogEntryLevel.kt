@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Log entry severity.
 */
@Serializable
public enum class LogEntryLevel {
  @SerialName("verbose")
  VERBOSE,
  @SerialName("info")
  INFO,
  @SerialName("warning")
  WARNING,
  @SerialName("error")
  ERROR,
}
