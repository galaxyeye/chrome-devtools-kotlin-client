@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class IPAddressSpace {
  // Patch: vincent, 20251025, protocol upgraded. Or you can modify the received message before deserialization.
  @JsonProperty("Loopback")
  LOOPBACK,

  @JsonProperty("Local")
  LOCAL,
  @JsonProperty("Private")
  PRIVATE,
  @JsonProperty("Public")
  PUBLIC,
  @JsonProperty("Unknown")
  UNKNOWN,
}
