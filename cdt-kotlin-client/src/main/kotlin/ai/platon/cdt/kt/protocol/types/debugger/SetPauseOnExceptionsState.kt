@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.debugger

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Pause on exceptions mode.
 */
public enum class SetPauseOnExceptionsState {
  @JsonProperty("none")
  NONE,
  @JsonProperty("caught")
  CAUGHT,
  @JsonProperty("uncaught")
  UNCAUGHT,
  @JsonProperty("all")
  ALL,
  @JsonEnumDefaultValue
  UNKNOWN,
}
