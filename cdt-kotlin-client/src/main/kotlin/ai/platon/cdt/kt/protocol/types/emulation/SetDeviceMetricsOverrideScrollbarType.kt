@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Scrollbar type. Default: `default`.
 */
public enum class SetDeviceMetricsOverrideScrollbarType {
  @JsonProperty("overlay")
  OVERLAY,
  @JsonProperty("default")
  DEFAULT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
