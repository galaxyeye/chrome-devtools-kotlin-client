@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Source of serviceworker response.
 */
@Serializable
public enum class ServiceWorkerResponseSource {
  @SerialName("cache-storage")
  CACHE_STORAGE,
  @SerialName("http-cache")
  HTTP_CACHE,
  @SerialName("fallback-code")
  FALLBACK_CODE,
  @SerialName("network")
  NETWORK,
  UNKNOWN,
}
