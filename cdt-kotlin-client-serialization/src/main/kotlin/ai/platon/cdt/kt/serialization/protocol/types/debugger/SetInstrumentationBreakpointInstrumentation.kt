@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Instrumentation name.
 */
@Serializable
public enum class SetInstrumentationBreakpointInstrumentation {
  @SerialName("beforeScriptExecution")
  BEFORE_SCRIPT_EXECUTION,
  @SerialName("beforeScriptWithSourceMapExecution")
  BEFORE_SCRIPT_WITH_SOURCE_MAP_EXECUTION,
}
