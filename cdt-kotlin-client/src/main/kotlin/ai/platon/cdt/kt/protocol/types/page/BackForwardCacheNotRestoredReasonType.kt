@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Types of not restored reasons for back-forward cache.
 */
public enum class BackForwardCacheNotRestoredReasonType {
  @JsonProperty("SupportPending")
  SUPPORT_PENDING,
  @JsonProperty("PageSupportNeeded")
  PAGE_SUPPORT_NEEDED,
  @JsonProperty("Circumstantial")
  CIRCUMSTANTIAL,
  @JsonEnumDefaultValue
  UNKNOWN,
}
