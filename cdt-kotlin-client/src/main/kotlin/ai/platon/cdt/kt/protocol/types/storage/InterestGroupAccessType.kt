@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Enum of interest group access types.
 */
public enum class InterestGroupAccessType {
  @JsonProperty("join")
  JOIN,
  @JsonProperty("leave")
  LEAVE,
  @JsonProperty("update")
  UPDATE,
  @JsonProperty("loaded")
  LOADED,
  @JsonProperty("bid")
  BID,
  @JsonProperty("win")
  WIN,
  @JsonProperty("additionalBid")
  ADDITIONAL_BID,
  @JsonProperty("additionalBidWin")
  ADDITIONAL_BID_WIN,
  @JsonProperty("topLevelBid")
  TOP_LEVEL_BID,
  @JsonProperty("topLevelAdditionalBid")
  TOP_LEVEL_ADDITIONAL_BID,
  @JsonProperty("clear")
  CLEAR,
  @JsonEnumDefaultValue
  UNKNOWN,
}
