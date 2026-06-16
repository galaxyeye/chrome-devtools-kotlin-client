@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.debugger

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Whether the operation was successful or not. Only `Ok` denotes a
 * successful live edit while the other enum variants denote why
 * the live edit failed.
 */
public enum class SetScriptSourceStatus {
  @JsonProperty("Ok")
  OK,
  @JsonProperty("CompileError")
  COMPILE_ERROR,
  @JsonProperty("BlockedByActiveGenerator")
  BLOCKED_BY_ACTIVE_GENERATOR,
  @JsonProperty("BlockedByActiveFunction")
  BLOCKED_BY_ACTIVE_FUNCTION,
  @JsonProperty("BlockedByTopLevelEsModuleChange")
  BLOCKED_BY_TOP_LEVEL_ES_MODULE_CHANGE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
