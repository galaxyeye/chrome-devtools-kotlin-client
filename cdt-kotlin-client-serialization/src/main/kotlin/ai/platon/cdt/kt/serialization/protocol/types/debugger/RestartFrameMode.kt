@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The `mode` parameter must be present and set to 'StepInto', otherwise
 * `restartFrame` will error out.
 */
@Serializable
public enum class RestartFrameMode {
  @SerialName("StepInto")
  STEP_INTO,
  UNKNOWN,
}
