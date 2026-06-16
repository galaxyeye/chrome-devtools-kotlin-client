@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Maps to the |SCARD_SHARE_*| values.
 */
public enum class ShareMode {
  @JsonProperty("shared")
  SHARED,
  @JsonProperty("exclusive")
  EXCLUSIVE,
  @JsonProperty("direct")
  DIRECT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
