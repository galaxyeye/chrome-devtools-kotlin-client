@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Only set for "token-redemption" operation and determine whether
 * to request a fresh SRR or use a still valid cached SRR.
 */
@Serializable
public enum class TrustTokenParamsRefreshPolicy {
  @SerialName("UseCached")
  USE_CACHED,
  @SerialName("Refresh")
  REFRESH,
  UNKNOWN,
}
