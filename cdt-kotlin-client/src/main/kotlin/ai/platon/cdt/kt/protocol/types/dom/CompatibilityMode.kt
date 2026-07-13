@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Document compatibility mode.
 */
public enum class CompatibilityMode {
  @JsonProperty("QuirksMode")
  QUIRKS_MODE,
  @JsonProperty("LimitedQuirksMode")
  LIMITED_QUIRKS_MODE,
  @JsonProperty("NoQuirksMode")
  NO_QUIRKS_MODE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
