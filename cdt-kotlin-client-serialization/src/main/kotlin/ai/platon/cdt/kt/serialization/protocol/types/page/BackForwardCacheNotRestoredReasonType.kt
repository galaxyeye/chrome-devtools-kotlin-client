@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Types of not restored reasons for back-forward cache.
 */
@Serializable
public enum class BackForwardCacheNotRestoredReasonType {
  @SerialName("SupportPending")
  SUPPORT_PENDING,
  @SerialName("PageSupportNeeded")
  PAGE_SUPPORT_NEEDED,
  @SerialName("Circumstantial")
  CIRCUMSTANTIAL,
  UNKNOWN,
}
