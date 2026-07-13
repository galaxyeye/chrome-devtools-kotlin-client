@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class IPAddressSpace {
  @JsonProperty("Loopback")
  LOOPBACK,
  @JsonProperty("Local")
  LOCAL,
  @JsonProperty("Public")
  PUBLIC,
  @JsonProperty("Unknown")
  @JsonEnumDefaultValue
  UNKNOWN,
}
