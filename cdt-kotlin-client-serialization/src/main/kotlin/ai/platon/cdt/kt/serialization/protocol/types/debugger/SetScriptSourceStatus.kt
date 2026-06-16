@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Whether the operation was successful or not. Only `Ok` denotes a
 * successful live edit while the other enum variants denote why
 * the live edit failed.
 */
@Serializable
public enum class SetScriptSourceStatus {
  @SerialName("Ok")
  OK,
  @SerialName("CompileError")
  COMPILE_ERROR,
  @SerialName("BlockedByActiveGenerator")
  BLOCKED_BY_ACTIVE_GENERATOR,
  @SerialName("BlockedByActiveFunction")
  BLOCKED_BY_ACTIVE_FUNCTION,
  @SerialName("BlockedByTopLevelEsModuleChange")
  BLOCKED_BY_TOP_LEVEL_ES_MODULE_CHANGE,
  UNKNOWN,
}
