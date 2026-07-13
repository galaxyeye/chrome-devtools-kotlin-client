@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class CrossOriginOpenerPolicyValue {
  @JsonProperty("SameOrigin")
  SAME_ORIGIN,
  @JsonProperty("SameOriginAllowPopups")
  SAME_ORIGIN_ALLOW_POPUPS,
  @JsonProperty("RestrictProperties")
  RESTRICT_PROPERTIES,
  @JsonProperty("UnsafeNone")
  UNSAFE_NONE,
  @JsonProperty("SameOriginPlusCoep")
  SAME_ORIGIN_PLUS_COEP,
  @JsonProperty("RestrictPropertiesPlusCoep")
  RESTRICT_PROPERTIES_PLUS_COEP,
  @JsonProperty("NoopenerAllowPopups")
  NOOPENER_ALLOW_POPUPS,
  @JsonEnumDefaultValue
  UNKNOWN,
}
