@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.debugger

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The `mode` parameter must be present and set to 'StepInto', otherwise
 * `restartFrame` will error out.
 */
public enum class RestartFrameMode {
  @JsonProperty("StepInto")
  STEP_INTO,
  @JsonEnumDefaultValue
  UNKNOWN,
}
