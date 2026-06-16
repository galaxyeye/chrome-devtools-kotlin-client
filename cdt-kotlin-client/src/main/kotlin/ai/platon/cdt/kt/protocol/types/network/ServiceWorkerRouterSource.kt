@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Source of service worker router.
 */
public enum class ServiceWorkerRouterSource {
  @JsonProperty("network")
  NETWORK,
  @JsonProperty("cache")
  CACHE,
  @JsonProperty("fetch-event")
  FETCH_EVENT,
  @JsonProperty("race-network-and-fetch-handler")
  RACE_NETWORK_AND_FETCH_HANDLER,
  @JsonProperty("race-network-and-cache")
  RACE_NETWORK_AND_CACHE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
