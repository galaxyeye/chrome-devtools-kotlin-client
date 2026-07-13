@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Backend type to use for tracing. `chrome` uses the Chrome-integrated
 * tracing service and is supported on all platforms. `system` is only
 * supported on Chrome OS and uses the Perfetto system tracing service.
 * `auto` chooses `system` when the perfettoConfig provided to Tracing.start
 * specifies at least one non-Chrome data source; otherwise uses `chrome`.
 */
@Serializable
public enum class TracingBackend {
  @SerialName("auto")
  AUTO,
  @SerialName("chrome")
  CHROME,
  @SerialName("system")
  SYSTEM,
  UNKNOWN,
}
