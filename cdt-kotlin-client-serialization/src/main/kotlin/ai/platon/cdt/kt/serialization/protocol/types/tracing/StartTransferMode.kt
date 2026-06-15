@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Whether to report trace events as series of dataCollected events or to save trace to a
 * stream (defaults to `ReportEvents`).
 */
@Serializable
public enum class StartTransferMode {
  @SerialName("ReportEvents")
  REPORT_EVENTS,
  @SerialName("ReturnAsStream")
  RETURN_AS_STREAM,
}
