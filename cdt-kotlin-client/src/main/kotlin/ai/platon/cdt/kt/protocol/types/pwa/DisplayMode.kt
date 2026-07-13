@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.pwa

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * If user prefers opening the app in browser or an app window.
 */
public enum class DisplayMode {
  @JsonProperty("standalone")
  STANDALONE,
  @JsonProperty("browser")
  BROWSER,
  @JsonEnumDefaultValue
  UNKNOWN,
}
