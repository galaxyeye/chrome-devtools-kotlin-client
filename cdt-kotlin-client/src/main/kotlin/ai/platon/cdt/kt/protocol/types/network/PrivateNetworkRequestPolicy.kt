@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class PrivateNetworkRequestPolicy {
  @JsonProperty("Allow")
  ALLOW,
  @JsonProperty("BlockFromInsecureToMorePrivate")
  BLOCK_FROM_INSECURE_TO_MORE_PRIVATE,
//  @JsonProperty("WarnFromInsecureToMorePrivate")
//  WARN_FROM_INSECURE_TO_MORE_PRIVATE,

  // Patch: vincent, 20251025, protocol upgraded. Or you can modify the received message before deserialization.
  @JsonProperty("WarnFromInsecureToMorePrivate")
  PERMISSION_BLOCK,
}
