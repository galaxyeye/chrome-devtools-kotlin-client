@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Pause reason.
 */
@Serializable
public enum class PausedReason {
  @SerialName("ambiguous")
  AMBIGUOUS,
  @SerialName("assert")
  ASSERT,
  @SerialName("CSPViolation")
  CSP_VIOLATION,
  @SerialName("debugCommand")
  DEBUG_COMMAND,
  @SerialName("DOM")
  DOM,
  @SerialName("EventListener")
  EVENT_LISTENER,
  @SerialName("exception")
  EXCEPTION,
  @SerialName("instrumentation")
  INSTRUMENTATION,
  @SerialName("OOM")
  OOM,
  @SerialName("other")
  OTHER,
  @SerialName("promiseRejection")
  PROMISE_REJECTION,
  @SerialName("XHR")
  XHR,
  UNKNOWN,
}
