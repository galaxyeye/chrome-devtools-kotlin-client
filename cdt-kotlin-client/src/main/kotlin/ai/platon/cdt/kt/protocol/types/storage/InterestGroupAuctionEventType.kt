@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Enum of auction events.
 */
public enum class InterestGroupAuctionEventType {
  @JsonProperty("started")
  STARTED,
  @JsonProperty("configResolved")
  CONFIG_RESOLVED,
  @JsonEnumDefaultValue
  UNKNOWN,
}
