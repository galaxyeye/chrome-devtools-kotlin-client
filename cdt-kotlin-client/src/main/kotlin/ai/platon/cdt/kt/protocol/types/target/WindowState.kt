@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.target

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The state of the target window.
 */
public enum class WindowState {
  @JsonProperty("normal")
  NORMAL,
  @JsonProperty("minimized")
  MINIMIZED,
  @JsonProperty("maximized")
  MAXIMIZED,
  @JsonProperty("fullscreen")
  FULLSCREEN,
  @JsonEnumDefaultValue
  UNKNOWN,
}
