@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Source of service worker router.
 */
@Serializable
public enum class ServiceWorkerRouterSource {
  @SerialName("network")
  NETWORK,
  @SerialName("cache")
  CACHE,
  @SerialName("fetch-event")
  FETCH_EVENT,
  @SerialName("race-network-and-fetch-handler")
  RACE_NETWORK_AND_FETCH_HANDLER,
  @SerialName("race-network-and-cache")
  RACE_NETWORK_AND_CACHE,
  UNKNOWN,
}
