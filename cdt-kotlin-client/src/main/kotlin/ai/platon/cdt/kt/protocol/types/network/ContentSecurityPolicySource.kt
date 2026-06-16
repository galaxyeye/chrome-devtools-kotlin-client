@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class ContentSecurityPolicySource {
  @JsonProperty("HTTP")
  HTTP,
  @JsonProperty("Meta")
  META,
  @JsonEnumDefaultValue
  UNKNOWN,
}
