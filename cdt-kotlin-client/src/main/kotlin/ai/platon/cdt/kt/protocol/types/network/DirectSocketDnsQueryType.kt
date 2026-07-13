@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class DirectSocketDnsQueryType {
  @JsonProperty("ipv4")
  IPV_4,
  @JsonProperty("ipv6")
  IPV_6,
  @JsonEnumDefaultValue
  UNKNOWN,
}
