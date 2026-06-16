@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Controls how the trace buffer stores data. The default is `recordUntilFull`.
 */
@Serializable
public enum class TraceConfigRecordMode {
  @SerialName("recordUntilFull")
  RECORD_UNTIL_FULL,
  @SerialName("recordContinuously")
  RECORD_CONTINUOUSLY,
  @SerialName("recordAsMuchAsPossible")
  RECORD_AS_MUCH_AS_POSSIBLE,
  @SerialName("echoToConsole")
  ECHO_TO_CONSOLE,
  UNKNOWN,
}
